package kr.or.ddit.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpReceiver {
	private DatagramSocket ds;
	private DatagramPacket dp;
	private byte[] msg;

	public UdpReceiver() {
		try {
			msg = new byte[100];
			// 소켓객체 생성(포트번호를 명시하지 않으면 사용가능한 포트번호중에서 임의의번호로 할당됨)
			ds = new DatagramSocket();

		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	public void start() throws IOException {

		InetAddress serverAddr = InetAddress.getByName("192.168.35.90");
		dp = new DatagramPacket(msg, 1, serverAddr, 8888); //패킷정보 쏴줄라고 패킷객체 만들었음
		ds.send(dp); // 전송

		dp = new DatagramPacket(msg, msg.length); 
		ds.receive(dp); // 패킷수신... 상대방이 시간을 보내줄때까지 기다리다가 상대방이 시간을 보내주면 

		System.out.println("현재 서버 시간 => " + new String(dp.getData())); //String객체 만들어서 여기다가 그 시간을 넣기 

		ds.close(); // 소켓 종료

	}

	public static void main(String[] args) throws IOException {
		new UdpReceiver().start();
	}

}
