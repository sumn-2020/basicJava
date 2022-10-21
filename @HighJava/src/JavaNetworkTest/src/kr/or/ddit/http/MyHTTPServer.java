package kr.or.ddit.http;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

/**
 * 간단한 웹서버 예제
 *
 */
public class MyHTTPServer {

	private final int port = 8888;
	private final String encoding = "UTF-8";


	// 서버 시작
	public void start() {

		System.out.println("HTTP 서버가 시작되었습니다.");

		try (ServerSocket server = new ServerSocket(this.port)) {

			while (true) {

				try {
					Socket socket = server.accept();

					// Http 요청 처리를 위한 스레드 객체 생성
					HttpHander hander = new HttpHander(socket);
					hander.start();

				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Http 요청 처리를 위한 스레드 클래드
	 */
	private class HttpHander extends Thread {

		private final Socket socket;

		public HttpHander(Socket socket) {

			this.socket = socket;

		}

		@Override
		public void run() {

			OutputStream out = null;
			BufferedReader br = null;

			try {

				out = new BufferedOutputStream(socket.getOutputStream());
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

				// 요청헤더 정보 파싱하기
				StringBuilder sb = new StringBuilder(); // .append랑 기능 똑같음 

				// Request Line(첫 줄은 요청라인)
				String reqLine = br.readLine();

				printMsg("Request Line: ", reqLine);

				while (true) {
					String str = br.readLine();

					// Empty Line 체크
					if (str.equals(""))
						break;

					sb.append(str + "\n");
				}

				// 헤더정보(Header)
				String reqHeaderStr = sb.toString();

				printMsg("요청헤더 : ", reqHeaderStr);
				
				String reqPath = ""; //요청 경로
				
				//요청 페이지 정보 가져오기
				StringTokenizer st = new StringTokenizer(reqLine);
				while(st.hasMoreTokens()) {
					String token = st.nextToken();
					if(token.startsWith("/")) { //  "/index.html" 대신 > 시작을 "/" 로!! 
						reqPath = token;
						break;
					}
				}
				
				System.out.println("reqPath => " + reqPath);
				
				

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					socket.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		}

		private void printMsg(String title, String msg) {

			System.out.println("===============================");
			System.out.println("title");
			System.out.println("===============================");
			System.out.println(msg);
			System.out.println("-------------------------------");

		}

	}

	public static void main(String[] args) {
		new MyHTTPServer().start();
	}

}
