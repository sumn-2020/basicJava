package kr.or.ddit.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MultiChatServer {

	// 대화명, 클라이언트의 Socket을 저장하기 위한 Map 변수 선언
	private Map<String, Socket> clients;

	// 생성자
	public MultiChatServer() {
		// 동기화 처리가 가능하도록 Map객체 생성
		clients = Collections.synchronizedMap(new HashMap<>());
	}

	// 서버시작
	public void serverStart() {

		Socket socket = null;

		try (ServerSocket serverSocket = new ServerSocket(7777)) {

			System.out.println("서버가 시작되었습니다.");

			while (true) {
				// 클라이언트의 접속을 대기한다.
				socket = serverSocket.accept();

				System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "] 에서 접속하였습니다.");

				// 메시지 전송처리를 하는 스레드 생성 및 실행
				ServerReceiver receiver = new ServerReceiver(socket);
				receiver.start();

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

//		ServerSocket serverSocket = null;
//		try {
//			serverSocket = new ServerSocket(7777);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				serverSocket.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}

	}

	/**
	 * 대화방 즉, Map에 저장된 전체 유저에게 안내메시지를 전송하는 메서드
	 * ~님이 입장하셨습니다. ~님이 퇴장하셨습니다관련 메시지
	 * @param msg
	 */
	public void sendMessage(String msg) {

		// Map에 저장된 사용자의 대화명 리스트 추출(key값 구하기)
		Iterator<String> it = clients.keySet().iterator();
		while (it.hasNext()) { //한 사람이 메시지를 꺼내면 map에 저장되어있는 모든 사용자들의 소켓 꺼내서 모두에게 메시지를 뿌리는 거
			try {

				String name = it.next(); // 대화명

				// 대화명에 해당하는 Socket객체에서 OutputStream꺼내기
				DataOutputStream dos = new DataOutputStream(clients.get(name).getOutputStream());
				dos.writeUTF(msg); // 메시지 전송하기

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	
	/**
	 * 대화방 즉, Map에 저장된 전체 유저에게 "대화메시지"를 전송하는 메서드
	 * @param msg
	 * @param from
	 */
	public void sendMessage(String msg, String from) {
		sendMessage("[" + from  + "]" + msg); //[홍길동] 메시지내용입니다.
		
	}
	
	
	// 서버에서 클라이언트로 메시지를 전송할 Thread 클래스를 Inner클래스로 정의하면
	// 부모(Outer)클래스의 멤버들을 직접 사용할 수 있다.
	class ServerReceiver extends Thread { // "사용자 수만큼" 해당 쓰레드 만들어지면서 사용자가 추가되면 이 쓰레드를 뿌려줌

		private Socket socket;
		private DataInputStream dis; // readUTF를 쓰기 위해서 DataInputStream 사용함
		private String name;

		public ServerReceiver(Socket socket) {

			this.socket = socket;

			try {
				// 수신용
				dis = new DataInputStream(socket.getInputStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {

			try {

				// 서버에서 클라이언트가 보내는 최초의 메시지
				// 즉, 대화명을 수신해야 한 후 name에다가 저장
				name = dis.readUTF();

				// 대화명을 받아서 다른 모든 클라이언트에게 대화방 참여 메시지를 보낸다.
				sendMessage("#" + name + "님이 입장했습니다.");

				// 대화명과 소켓객체를 Map에 저장한다.
				clients.put(name, socket); //이름과 그 사람의 소켓을 map에 저장하기

				System.out.println("현재 서버 접속자 수는 " + clients.size() + "명 입니다.");

				// 이 이후의 메시지 처리는 반복문으로 처리한다.
				// 한 클라이언트가 보낸 메시지를 다른 모든 클라이언트들에게 보내준다.
				while (dis != null) {
					sendMessage(dis.readUTF(), name); // 방금 writeUTF한사람이 보낸걸 readUTF함
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally { //소켓에 문제가 문제가 생겼을 경우 exception 실행 후 소켓에 문제가 된사람은 map에서 제외시킴 
				// 이 finally 영역이 실행된다는 것은 클라이언트의 접속이 종료되었다는 의미이다.
				sendMessage(name + "님이 나가셨습니다.");

				// Map에서 해당 대화명을 삭제한다.
				clients.remove(name);
				System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "] 에서 접속을 종료하였습니다.");
				System.out.println("현재 서버 접속자 수는 " + clients.size() + "명 입니다.");
			}

		}

	}
	
	public static void main(String[] args) {
		new MultiChatServer().serverStart();
	}
}
