package kr.or.ddit.basic;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class assign {

	public void parse() throws ParserConfigurationException, SAXException, IOException {
		String svcKey = "Grid_20150827000000000227_1"; // 레시피 재료 정보 조회 서비스
		String apiKey = "6QxACXzZz3DhIcHKtEVaNe3%2BNmsF5U7Ql635CDNUki%2Bn7s%2BOIUuMp1MY9rCEsUPerlOfrGwmtgYvnOPWHL2iDw%3D%3D&"; // 개인별 발급.
		String startIdx = "1"; // 레시피 재료 시작 순번
		String endIdx = "5"; // 레시피 재료 종료 순번
		String recipeId = "498"; // 래시피가 궁금한 음식 ID

		URL url = new URL("https://apis.data.go.kr/6300000/festivalDaejeonService/festivalDaejeonList?serviceKey=" + apiKey + "/xml/" + svcKey + "/" + startIdx + "/"
				+ endIdx + "?RECIPE_ID=" + recipeId);
	
	
		//XML문서를 생성하기 위한 DocumentBuilder 객체 생성하기
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbf.newDocumentBuilder();
		Document document = builder.parse(url.toString());
		
		Element root = document.getDocumentElement();
		System.out.println("루트엘리먼트 태그명: " + root.getTagName());
		
		//전체 컬럼 수를 가져오기
//		String totalCnt = root.getElementsByTagName("totalCnt");
//		endIdx = totalCnt;
//
//		
//		if(code.equals("00")) {
//			
//		}
//		
		
		
	
	}
	
	


}
