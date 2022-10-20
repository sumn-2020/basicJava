package kr.or.ddit.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpChatServer {
	public static void main(String[] args) {
		
		ServerSocket server = null;
		Socket socket = null;
		
		try {
			server = new ServerSocket(7777); //클라이언트의 요청을 받기 위한 준비를 한다.(ServerSocket)
			System.out.println("서버준비 완료 ... ");
			socket = server.accept(); //클라이언트 응답올때까지 서버는 대기타고있기 
			System.out.println("접속되었습니다.");
			
			Sender sender = new Sender(socket);
			sender.start(); //스레드 동작시키기 
			
			Receiver receiver = new Receiver(socket);
			receiver.start(); //스레드 동작시키기 
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
