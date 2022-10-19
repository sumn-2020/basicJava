package kr.or.ddit.basic;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class URLTest {
	public static void main(String[] args) throws MalformedURLException, URISyntaxException {
		
		//URL 클래스 => 인터넷에 존재하는 서버들의 자원에 접근할 수 있는 주소를 관리하는 클래스
		URL url = new URL("http", "ddit.or.kr", 80, "/main/index.html?name=홍길동&age=30#kkk");
		
		//용어에 맞춰서 내용을 꺼내올수있도록 만든 메소드들을 이용해서 url 안에 있는 세부 정보 가져오기
		System.out.println("전체 URL주소: " + url);
		System.out.println("protocol: " + url.getProtocol());
		System.out.println("host: " + url.getHost());
		System.out.println("query: " + url.getQuery());
		System.out.println("file: " + url.getFile()); //쿼리정보포함
		System.out.println("path: " + url.getPath()); //쿼리정보미포함
		System.out.println("port: " + url.getPort());
		System.out.println("ref: " + url.getRef()); //참조정보
		
		System.out.println(url.toExternalForm()); //외부에 노출되는 형태의 모양으로 출력
		System.out.println(url.toString());
		System.out.println(url.toURI().toString()); //URI로 바꾼후 URI가 가지고있는  toString메소드 출력  (url은 uri이다 / uri는 url이 될수도있고 안될수도있음)
		
	}
}
