package kr.or.ddit.basic;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class assign {

	public void parse() throws ParserConfigurationException, SAXException, IOException {
		
		String svcKey = "ServiceResult"; // 레시피 재료 정보 조회 서비스
		String apiKey = "6QxACXzZz3DhIcHKtEVaNe3%2BNmsF5U7Ql635CDNUki%2Bn7s%2BOIUuMp1MY9rCEsUPerlOfrGwmtgYvnOPWHL2iDw%3D%3D"; // 개인별 발급.
		String startIdx = "1"; // 레시피 재료 시작 순번
		String endIdx = "1"; // 레시피 재료 종료 순번
		String recipeId = "1"; // 래시피가 궁금한 음식 ID

		URL url = new URL("http://apis.data.go.kr/6300000/festivalDaejeonService/festivalDaejeonList?serviceKey=" + apiKey + "/xml/" + svcKey + "/" + startIdx + "/"
				+ endIdx + "?RECIPE_ID=" + recipeId);
	
		//XML문서를 생성하기 위한 DocumentBuilder 객체 생성하기
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbf.newDocumentBuilder();
		Document document = builder.parse(url.toString());
		
		Element root = document.getDocumentElement();
		System.out.println("루트엘리먼트 태그명: " + root.getTagName());
		
		//전체 컬럼 수를 가져오기
		String totalCnt = root.getElementsByTagName("totalCount").item(0).getTextContent();
		endIdx = totalCnt;

		url = new URL("http://apis.data.go.kr/6300000/festivalDaejeonService/festivalDaejeonList?serviceKey=" + apiKey + "/xml/" + svcKey + "/" + startIdx + "/"
				+ endIdx + "?RECIPE_ID=" + recipeId);
		
		document = builder.parse(url.toString());
		
		root = document.getDocumentElement();
		String code = root.getElementsByTagName("returnCode").item(0).getTextContent();
		
		if(code.equals("00")) { //정상상태인경우..
			NodeList rowNodeList = root.getElementsByTagName("row");
			
			for (int i = 0; i < rowNodeList.getLength(); i++) {
				
				Element element = (Element) rowNodeList.item(i);
				
				String auspiceAgency = element.getElementsByTagName("auspiceAgency").item(0).getTextContent();
				String content = element.getElementsByTagName("content").item(0).getTextContent();
				String dataStnDt = element.getElementsByTagName("dataStnDt").item(0).getTextContent();
				String homepageUrl = element.getElementsByTagName("homepageUrl").item(0).getTextContent();
				String manageAgency = element.getElementsByTagName("manageAgency").item(0).getTextContent();
				String ntatcSeq = element.getElementsByTagName("ntatcSeq").item(0).getTextContent();
				String opnEndDt = element.getElementsByTagName("opnEndDt").item(0).getTextContent();
				String opnStrtDt = element.getElementsByTagName("opnStrtDt").item(0).getTextContent();
				String regDtTm = element.getElementsByTagName("regDtTm").item(0).getTextContent();
				String tel = element.getElementsByTagName("tel").item(0).getTextContent();
				String title = element.getElementsByTagName("title").item(0).getTextContent();
				
				System.out.printf("%3s %8s %10s %10s %8s %8s %8s %8s %8s %8s\n", auspiceAgency, content, dataStnDt, homepageUrl, manageAgency, ntatcSeq, opnEndDt, opnStrtDt, regDtTm, tel, title);
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			}
		}	
	}
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		new assign().parse();
	}

}
