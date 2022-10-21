package kr.or.ddit.udp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpFileSender {
	private DatagramSocket ds;
	private DatagramPacket dp;

	private InetAddress receiverAddr;
	private int port; // 데이터를 보낼 때 사용할 포트번호
	private File file;

	public UdpFileSender(String receiverIp, int port) {

		try {

			ds = new DatagramSocket();
			this.port = port;
			receiverAddr = InetAddress.getByName(receiverIp);
			file = new File("d:/D_Other/br5.jpg");

			if (!file.exists()) {
				System.out.println("파일이 존재하지 않습니다.");
				System.exit(0);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void start() throws Exception {

		long fileSize = file.length();
		long totalReadBytes = 0;
		long startTime = System.currentTimeMillis();

		try {

			// 전송시작을 알려주기 위한 문자열 전송
			sendData("start".getBytes()); // start 보내기 ㄴ

			// 파일명 전송
			sendData(file.getName().getBytes());

			// 총 파일 크기 정보를 전송
			sendData(String.valueOf(fileSize).getBytes());

			FileInputStream fis = new FileInputStream(file);

			byte[] buffer = new byte[1000];
			while (true) {
				// 패킷전송간의 간격을 주기 위해
				Thread.sleep(10);
				int readBytes = fis.read(buffer, 0, buffer.length);

				if (readBytes == -1) { // 다 읽은 경우...
					break;
				}

				// 읽은 파일내용 전송하기
				sendData(buffer, readBytes);

				totalReadBytes += readBytes;
				System.out.println("진행상태 : " + totalReadBytes + "/" + fileSize + " Byte(s) ("
						+ (totalReadBytes * 100 / fileSize) + " %)");

			}

			long endTime = System.currentTimeMillis();
			long diffTime = endTime - startTime;
			double transferSpeed = fileSize / diffTime;

			System.out.println("걸린 시간 : " + diffTime + " (ms)");
			System.out.println("평균 전송속도 : " + transferSpeed + " Bytes/ms");

			System.out.println("전송완료 ... ");

			fis.close();
			ds.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 바이트 배열 데이터 전송하기
	 * 
	 * @param data
	 * @param length
	 * @throws IOException
	 */
	public void sendData(byte[] data, int length) throws IOException { // 총 8바이트 중 hello글자에 맞게 5바이트만 보내기 위한 메소드
		dp = new DatagramPacket(data, length, receiverAddr, port);
		ds.send(dp);
	}

	public void sendData(byte[] data) throws IOException { // 총 8바이트 중 8바이트 전부 보내기위한 메소드

		sendData(data, data.length);

	}

	public static void main(String[] args) throws Exception {

		new UdpFileSender("192.168.35.55", 8888).start();

	}

}
