package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * 외부의 properties파일을 읽어와 Properties객체로 처리하기 properties문서를 사용하므로써 자바소스를 건들이지 않고
 * 정보를 수정할 수 있는 장점이 있음
 */

public class JDBCHotelProperties {
	public static void main(String[] args) {

		// 읽어온 정보를 저장할 Properties객체 생성
		Properties prop = new Properties();

		// 읽어올 파일명을 이용한 File객체 생성하기
		File file = new File("res/dbhotel.properties");

		try {

			// 파일읽기를 수행할 FileInputStream 객체 생성
			FileInputStream fis = new FileInputStream(file);

			// Properties객체로 파일 내용 읽기
			prop.load(fis); // 파일 내용을 읽어와 key와 value값으로 분류한 후 Properties객체에 담아준다

			// 읽어온 데이터 출력하기
			// key값만 읽어와 Enumeration객체로 반환하기
			Enumeration<String> keys = (Enumeration<String>) prop.propertyNames();

			while (keys.hasMoreElements()) {
				String key = keys.nextElement();
				String value = prop.getProperty(key);
				System.out.println(key + ":" + value);
			}
			System.out.println("출력끝");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
