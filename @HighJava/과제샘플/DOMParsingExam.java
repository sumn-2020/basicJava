package kr.or.ddit.basic;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * XML DOM을 이용한 XML문서 파싱 예제(레시피정보 조회 API)
 * @author PC-04
 *
 */
public class DOMParsingExam {

	public void parse() throws Exception {
		String apiKey = "GhjHHu%2BnzsiX4Ktz%2FbiSTNMwfilyprU8GHfZ9DErGVWcvazeyYJz%2F2lsNBgGsSHXoeucSGs1jcUIPQelC5tamw%3D%3D"; // 개인별 발급
		String pageNo = "1";
		String numOfRows = "3";

		URL url = new URL("http://apis.data.go.kr/6300000/festivalDaejeonService/festivalDaejeonList?serviceKey=" + apiKey
				+ "&pageNo=" + pageNo
				+ "&numOfRows=" + numOfRows);
  		
  		 System.out.println(url.toString());
  		 System.out.println("-------------------------------------------------------------");
  		
  		// XML 문서를 생성하기 위한 DocumentBuilder 객체 생성하기
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbf.newDocumentBuilder();
		
		// Document 객체 생성
		Document document = builder.parse(url.toString());
		
		// ROOT 엘리먼트 가져오기
		Element root = document.getDocumentElement();
		System.out.println("루트엘리먼트 태그명 : " + root.getTagName());
		System.out.println("-------------------------------------------------------------");
		
		document = builder.parse(url.toString());
		
		root = document.getDocumentElement();
		String code = root.getElementsByTagName("returnCode").item(0).getTextContent();
		
		if(code.equals("00")) { // 정상상태인 경우
			NodeList rowNodeList = root.getElementsByTagName("items");
			
			for(int i=0; i<rowNodeList.getLength(); i++) {
				Element element = (Element) rowNodeList.item(i);
				String auspiceAgency = element.getElementsByTagName("auspiceAgency").item(0).getTextContent();
				String content = element.getElementsByTagName("content").item(0).getTextContent();
				String homepageUrl = element.getElementsByTagName("homepageUrl").item(0).getTextContent();
				String manageAgency = element.getElementsByTagName("manageAgency").item(0).getTextContent();
				String ntatcSeq = element.getElementsByTagName("ntatcSeq").item(0).getTextContent();
				String openPlace = element.getElementsByTagName("openPlace").item(0).getTextContent();
				String opnStrtDt = element.getElementsByTagName("opnStrtDt").item(0).getTextContent();
				String opnEndDt = element.getElementsByTagName("opnEndDt").item(0).getTextContent();
				String title = element.getElementsByTagName("title").item(0).getTextContent();
				String tel = element.getElementsByTagName("tel").item(0).getTextContent();
				
				System.out.println("축제번호 : " + ntatcSeq);
				System.out.println("축제명 : " + title);
				System.out.println("내용 : " + content);
				System.out.println("시작일 : " + opnStrtDt);
				System.out.println("종료일 : " + opnEndDt);
				System.out.println("개최장소 : " + openPlace);
				System.out.println("주최기관 : " + auspiceAgency);
				System.out.println("주관기관 : " + manageAgency);
				System.out.println("연락처 : " + tel);
				System.out.println("홈페이지 : " + homepageUrl);
				
//				System.out.printf("%8s\r %15s\r %50s\r %8s\r %8s\r %15s\r %8s\r %8s\r %8s\r %10s\n"
//						, ntatcSeq, title, content, opnStrtDt, opnEndDt, openPlace, auspiceAgency, manageAgency, tel, homepageUrl);
				System.out.println("-------------------------------------------------------------");
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		new DOMParsingExam().parse();
	}
}
