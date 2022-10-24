package kr.or.ddit.http;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLConnection;
import java.net.URLDecoder;
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

				printMsg("Request Line: ", reqLine); // 브라우저에 엔터쳤을 때 날라가는 메시지를 보여주는 거

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

				String reqPath = ""; // 요청 경로

				// 요청 페이지 정보 가져오기
				StringTokenizer st = new StringTokenizer(reqLine); // StringTokenizer을 이용해서 문자열 쪼개기
				while (st.hasMoreTokens()) {
					String token = st.nextToken(); // nextToken() : StringTokenizer에서 다음 토큰을 불러오는 메서드
					if (token.startsWith("/")) { // "/index.html" 대신 > 시작을 "/" 로!!
						reqPath = token; // (경로 정보만 추출)
						break;
					}
				}

				System.out.println("reqPath => " + reqPath);

				// URL 디코딩 처리(한글깨짐문제 해결)
				reqPath = URLDecoder.decode(reqPath, encoding);

				String filePath = "./WebContent" + reqPath; // ./ => 현재 프로젝트 / 상대경로

				// 해당 파일 이름을 이용하여 Content-type정보(파일로) 추출하기
				String contentType = URLConnection.getFileNameMap().getContentTypeFor(filePath);

				// Css파일인 경우 인식이 안돼서 추가함
				if (contentType == null && filePath.endsWith(".css")) {
					contentType = "text/css";
				}

				File file = new File(filePath);
				if (!file.exists()) { // 파일이 존재하지 않으면
					makeErrorPage(out, 404, "Not Found");
					return;
				}

				byte[] body = makeResponseBody(filePath);

				// byte기반으로 받기 때문에 byte[]배열 속에 담아야 됨
				byte[] header = makeResponseHeader(body.length, contentType);

				// 응답 헤더 데이터 보내기
				out.write(header);

				// 응답내용 보내기 전 반드시 empty Line을 보내야 한다.
				out.write("\r\n\r\n".getBytes()); // \r\n\r\n : 엔터 두번치기

				// 응답 내용 데이터 보내기
				out.write(body); // body 보내기
				out.flush();

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

	
	
	/**
	 * 에러 페이지 생성
	 * @param out 출력용 스트림
	 * @param statusCode 상태코드
	 * @param errMsg 에러메시지
	 */
	private void makeErrorPage(OutputStream out, int statusCode, String errMsg) {

		String statusLine = "HTTP/1.1" + " " + statusCode + " " + errMsg; //statusLine만들기

		try {

			out.write(statusLine.getBytes());
			out.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 응답헤더 생성하기
	 * 
	 * @param length      응답내용 크기
	 * @param contentType MIME타입
	 * @return 헤더 정보 바이트 배열
	 */
	private byte[] makeResponseHeader(int length, String contentType) {

		String header = "HTTP/1.1 200 OK\r\n" + "Server: MyHTTPServer 1.0\r\n" + "Content-length: " + length + "\r\n"
				+ "Content-type: " + contentType + "; charset=" + this.encoding;

		return header.getBytes(); // getBytes() : String을 byte별로 return 하기 위해서 사용
	}

	/**
	 * 응답내용 생성하기
	 * 
	 * @param filePath 응답으로 사용할 파일경로
	 * @return 바이트배열 데이터
	 */
	private byte[] makeResponseBody(String filePath) {

		FileInputStream fis = null;
		byte[] data = null;

		try {

			File file = new File(filePath); // file.length(파일의 크기)를 알고싶어서 파일 객체 생성함
			data = new byte[(int) file.length()];

			fis = new FileInputStream(file);
			fis.read(data);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return data;
	}

	public static void main(String[] args) {
		new MyHTTPServer().start();
	}

}
