package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.IOException;

public class T05FileStreamTest {
	public static void main(String[] args) {

		// FileInputStream객체를 이용한 파일 내용 읽기
		FileInputStream fis = null;

		try {

			fis = new FileInputStream("d:/D_Other/test2.txt");

			int data = 0;

			while ((data = fis.read()) != -1) {
				// 읽어온 내용 출력하기
				System.out.println((char) data);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				fis.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}

	}
}
