package kr.or.ddit.basic;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class T02DOMParsingTest {

	public void parse() throws ParserConfigurationException, SAXException, IOException {

		// XML문서를 생성하기 위한 DocumentBuilder객체 생성하기
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		DocumentBuilder builder = dbf.newDocumentBuilder();

		// Document 객체 생성
		Document document = builder.parse(new File("./src/new_book.xml"));
		
		// DOM Document 객체로부터 root 엘리먼트 객체 가져오기
		Element root = document.getDocumentElement();
		System.out.println("루트엘리먼트 태그명: " + root.getTagName());
		
		// 하위엘리먼트 접근방법1 : getElementsByTagName() 이용
		NodeList bookNodeList = root.getElementsByTagName("book");
		Node firstBookNode = bookNodeList.item(0); //첫번째 항목
		Element firstBookElement = (Element) firstBookNode;
		
		// 속성 접근방법1 : 엘리먼트 객체의 getAttribute() 이용
		System.out.println("엘리먼트 객체의 getAttribute()이용 => " + firstBookElement.getAttribute("isbn"));
		
		// 속성접근방법2 : 노드 객체의 getAttributes() 이용
		NamedNodeMap nodeMap = firstBookNode.getAttributes();
		System.out.println("노드 객체의 getAttributes() 이용 => " + nodeMap.getNamedItem("isbn").getNodeValue());
		
		// 하위 엘리먼트 접근방법2 : getChildNodes() 이용
		NodeList firstBookChildNodeList = firstBookNode.getChildNodes();
		Node titleNode = firstBookChildNodeList.item(1);//빈공백(텍스트)도 노드고 전부 다 노드임 => <book>태그와 <title>사이의 공백때문에 0이 아니라 1을 넣어줘야됨(공백을  0이라고 치기 때문)
		Element titleElement = (Element) titleNode;
		System.out.println("titleElement.getTagName() => " + titleElement.getTagName());
		System.out.println("titleElement.getTextContent() => " + titleElement.getTextContent());

		//전체 출력하기
		System.out.println("-------------------------------");
		System.out.printf("%8s %8s %15s %10s %8s\n", "ISBN", "분류", "제목", "저자", "가격");
		System.out.println("-------------------------------");
		for (int i = 0; i < bookNodeList.getLength(); i++) {
			Element element = (Element) bookNodeList.item(i);
			
			String isbn = element.getAttribute("isbn");
			String kind = element.getAttribute("kind");
			String title = element.getElementsByTagName("title").item(0).getTextContent();
			String author = element.getElementsByTagName("author").item(0).getTextContent();
			String price = element.getElementsByTagName("price").item(0).getTextContent();
			
			System.out.printf("%8s %8s %15s %10s %8s\n", isbn, kind, title, author, price);
		}
	
	}
	
	public static void main(String[] args) throws Exception {
		new T02DOMParsingTest().parse();
	}

}
