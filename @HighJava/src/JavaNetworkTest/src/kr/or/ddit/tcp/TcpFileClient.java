package kr.or.ddit.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TcpFileClient {
	// 클라이언트는 서버에 접속하여 서버가 보내주는 파일을 저장한다.
	private Socket socket;
	private FileOutputStream fos;
	private DataOutputStream dos;
	private DataInputStream dis;

	public void clienStart() {

		File file = new File("d:/D_Other/br5.jpg");

		try {

			socket = new Socket("192.168.35.90", 7777); //요청

			// 소켓접속이 성공하면 받고 싶은 파일명을 보낸다.
			dos = new DataOutputStream(socket.getOutputStream());

			dos.writeUTF(file.getName()); //파일 객체의 파일이름을 가져오기 

			dis = new DataInputStream(socket.getInputStream());

			String resultMsg = dis.readUTF(); //메시지 읽어들이기
			if (resultMsg.equals("OK")) { //파일이 있다면 
				fos = new FileOutputStream(file);

				BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());

				BufferedOutputStream bos = new BufferedOutputStream(fos);

				int data = 0;
				while ((data = bis.read()) != -1) {
					bos.write(data);
				}

				bis.close();
				bos.close();
				System.out.println("파일 다운로드 완료..");

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	public static void main(String[] args) {
		new TcpFileClient().clienStart();
	}



}
