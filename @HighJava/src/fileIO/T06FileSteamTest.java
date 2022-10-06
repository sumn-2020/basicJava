package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 *  파일출력(저장) 예제
 *
 */
public class T06FileSteamTest {
	public static void main(String[] args) {
		
		FileOutputStream fos = null;
		
		try {
			
			//출력을 위한 FileOutputSteam객체 생성
			fos = new FileOutputStream("d:/D_Other/out.txt", true); //true를 쓰면 기존에 쓴거에서 계속 추가적으로 이어서 작성됨 
			
			for(char ch ='a'; ch<= 'z'; ch++) {
				fos.write(ch);
			}
			
			System.out.println("파일 쓰기 작업완료.");
			
			// 콘솔창에서 파일읽기
			FileInputStream fis = new FileInputStream("d:/D_Other/out.txt");
			
			int data = 0;
			
			while((data = fis.read()) != -1) {
				System.out.print((char) data);
			}
			
			fis.close();

		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
			try {
				fos.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		
		
	}
}
