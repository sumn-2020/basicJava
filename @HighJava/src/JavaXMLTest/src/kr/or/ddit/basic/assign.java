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
//https://apis.data.go.kr/6300000/festivalDaejeonService/festivalDaejeonList?serviceKey=6QxACXzZz3DhIcHKtEVaNe3%2BNmsF5U7Ql635CDNUki%2Bn7s%2BOIUuMp1MY9rCEsUPerlOfrGwmtgYvnOPWHL2iDw%3D%3D&numOfRows=1
public class assign {

	public void parse() throws ParserConfigurationException, SAXException, IOException {
		
		String apiKey = "6QxACXzZz3DhIcHKtEVaNe3%2BNmsF5U7Ql635CDNUki%2Bn7s%2BOIUuMp1MY9rCEsUPerlOfrGwmtgYvnOPWHL2iDw%3D%3D"; // 개인별 발급.
		String numOfRows = "3"; 
		String pageNo = "1"; 

		URL url = new URL("http://apis.data.go.kr/6300000/festivalDaejeonService/festivalDaejeonList?serviceKey=" + apiKey 
				+ "numOfRows= " +   numOfRows 
				+ "pageNo=" + pageNo);
		System.out.println(url.toString());
		//http://apis.data.go.kr/6300000/festivalDaejeonService/festivalDaejeonList?serviceKey=인증키(URL Encode)&numOfRows=10&pageNo=1
		
		//XML문서를 생성하기 위한 DocumentBuilder 객체 생성하기
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbf.newDocumentBuilder();
		Document document = builder.parse(url.toString());
		
		Element root = document.getDocumentElement();
		System.out.println("루트엘리먼트 태그명: " + root.getTagName());
		
		//전체 컬럼 수를 가져오기
//		String totalCnt = root.getElementsByTagName("totalCount").item(0).getTextContent();
//		endIdx = totalCnt;
//      url = new URL("http://apis.data.go.kr/6300000/festivalDaejeonService/festivalDaejeonList?serviceKey=" + apiKey + "&startIdx= " +   startIdx + "&endIdx=" + endIdx);
		
		document = builder.parse(url.toString());

		//url = new URL("http://apis.data.go.kr/6300000/festivalDaejeonService/festivalDaejeonList?serviceKey=" + apiKey + "numOfRows= " +   numOfRows + "pageNo=" + pageNo);
		root = document.getDocumentElement();
		String code = root.getElementsByTagName("successYN").item(0).getTextContent();
		
		
		if(code.equals("Y")) { //정상상태인경우..
			NodeList rowNodeList = root.getElementsByTagName("items");
			
			for (int i = 0; i < rowNodeList.getLength(); i++) {
				
				Element element = (Element) rowNodeList.item(i);
				
				String auspiceAgency = element.getElementsByTagName("auspiceAgency").item(0).getTextContent();
				//String content = element.getElementsByTagName("content").item(0).getTextContent();
				//String homepageUrl = element.getElementsByTagName("homepageUrl").item(0).getTextContent();
				String manageAgency = element.getElementsByTagName("manageAgency").item(0).getTextContent();
				String ntatcSeq = element.getElementsByTagName("ntatcSeq").item(0).getTextContent();
				String openPlace = element.getElementsByTagName("openPlace").item(0).getTextContent();
				String opnStrtDt = element.getElementsByTagName("opnStrtDt").item(0).getTextContent();
				String opnEndDt = element.getElementsByTagName("opnEndDt").item(0).getTextContent();
				String title = element.getElementsByTagName("title").item(0).getTextContent();
				String tel = element.getElementsByTagName("tel").item(0).getTextContent();
				
				System.out.println("축제번호 : " + ntatcSeq);
				System.out.println("축제명 : " + title);
				//System.out.println("내용 : " + content);
				System.out.println("시작일 : " + opnStrtDt);
				System.out.println("종료일 : " + opnEndDt);
				System.out.println("개최장소 : " + openPlace);
				System.out.println("주최기관 : " + auspiceAgency);
				System.out.println("주관기관 : " + manageAgency);
				System.out.println("연락처 : " + tel);
				//System.out.println("홈페이지 : " + homepageUrl);
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			
				
				
				System.out.printf("%8s\r %15s\r %8s\r %8s\r %15s\r %8s\r %8s\r %8s\r" , 
						ntatcSeq, title,  opnStrtDt, opnEndDt, openPlace, auspiceAgency, manageAgency, tel);
			
			}
		}	
	}
	
	public static void main(String[] args) throws Exception  {
		new assign().parse();
	}

}
