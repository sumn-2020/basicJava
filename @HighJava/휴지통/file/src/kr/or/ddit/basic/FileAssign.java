package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileAssign {

	public static void main(String[] args) {

		// FileInputStream객체를 이용한 파일 읽어오기
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {

			fis = new FileInputStream("d:/D_Other/Tulips.jpg");
			fos = new FileOutputStream("d:/D_Other/Tulipscopied.jpg");// 출력을 위한 FileOutputSteam객체 생성

			// 파일읽어오기
			int data = 0;

			while ((data = fis.read()) != -1) {

				// 읽어온 내용 출력하기
				fos.write(data);

			}
			fis.close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				fis.close();
				fos.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
