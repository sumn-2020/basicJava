package kr.or.ddit.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpFileServer {
	/*
	 * 서버는 클라이언트가 접속하면 서버 컴퓨터의 D:/D_Other/ 에 있는 이미지 파일을 클라이언트로 전송한다.
	 * 
	 */
	private ServerSocket server;
	private Socket socket;
	private FileInputStream fis;
	private DataInputStream dis;
	private DataOutputStream dos;

	public void serverStart() {

		try {

			server = new ServerSocket(7777);
			System.out.println("서버 준비 완료...");
			String downDir = "d:/D_Other/";

			File file = null;
			while (true) { //무한루프 돌면서 클라이언트 기다리기 

				System.out.println("파일 전송 대기 중...");
				socket = server.accept(); //두개의 소켓(서버소켓, 클라이언트 소켓)이 완성되면 accept풀림

				System.out.println("요청 파일 존재여부 체크 중...");

				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());

				file = new File(downDir + dis.readUTF()); //사용자가 writeUTF로 전송했을 데이터를 readUTF를 읽음

				if (!file.exists()) { //데이터가 존재하지 않으면 
					System.out.println("요청파일(" + file.getName() + ") 존재하지 않음");
					dos.writeUTF("요청파일(" + file.getName() + ") 존재하지 않습니다."); //상대방한테도 보내주기 

					dos.close();
					socket.close();

					continue;
				} else {
					dos.writeUTF("OK"); // 요청파일 확인했을을 알려줌
					System.out.println("요청파일( " + file.getName() + ") 전송시작 ...");
				}

				fis = new FileInputStream(file); //FileInputStrea을 이용해서 파일 읽어들이기 

				BufferedInputStream bis = new BufferedInputStream(fis);
				BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream()); //소켓을 통해서 상대방 소켓으로 보내기 

				int data = 0;

				while ((data = bis.read()) != -1) {
					bos.write(data); 
				}

				bis.close();
				bos.close();
				dis.close();
				dos.close();
				socket.close();

				System.out.println("파일전송완료...");

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	
	public static void main(String[] args) {
		new TcpFileServer().serverStart();
	}
}
