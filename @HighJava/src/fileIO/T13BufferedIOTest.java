package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class T13BufferedIOTest {
	public static void main(String[] args) {

		// 문자기반의 Buffered 스트림 사용하기

		FileReader fr = null;
		BufferedReader br = null;

		try {

			// 전체 파일 읽어오기
			fr = new FileReader("./src/kr/or/ddit/basic/T12BufferedIOTest.java");
//
//			int data = 0;
//
//			while ((data = fr.read()) != -1) {
//				System.out.print((char) data);
//			}

			// 한줄씩 읽을 수 있도록 해주는 readLine()을 이용하기 위해 BufferedReader 사용
			br = new BufferedReader(fr);

			String temp = "";
			int cnt = 1;

			while ((temp = br.readLine()) != null) { // temp = br.readLine() 한줄씩 읽는데 null이 아닐때까지 읽어라

				System.out.printf("%4d : %s\n", cnt++, temp);

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {

				br.close();
				// fr.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}

	}
}
