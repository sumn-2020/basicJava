package kr.or.ddit.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receiver extends Thread {

	private DataInputStream dis;

	public Receiver(Socket socket) {
		try {
			dis = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (dis != null) {
			try {
				System.out.println(dis.readUTF()); //상대방이 writeUTF할때마다 나는 ReadUTF로 읽음
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
