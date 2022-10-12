package kr.or.ddit.basic;

import java.io.File;
import java.io.IOException;

public class T01FileTest {
	public static void main(String[] args) throws IOException {

		// File객체 만들기 연습

		// 1. new File(String 파일 또는 경로명)
		// => 디렉토리와 디렉토리 사이 또는 디렉토리와 파일명 사이의 구분문자 '\' 또는 '/'를 사용할 수 있다.

		File file = new File("d:\\D_Other\\test.txt"); //escape문자가 아니라 진짜 역슬래쉬로 쓴다는 것을 보여주기 위해서 \\두개씀
		System.out.println("파일명 : " + file.getName());
		System.out.println("파일여부 : " + file.isFile()); //얘가 파일인가
		System.out.println("디렉토리(폴더) 여부 : " + file.isDirectory());
		System.out.println("--------------------------------------");

		File file2 = new File("d:\\D_Other");
		System.out.println(file2.getName() + "은");
		if (file2.isFile()) {
			System.out.println("파일");
		} else if (file2.isDirectory()) {
			System.out.println("디렉토리(폴더)");
		}

		System.out.println("---------------------------------------");

		// 2. new File(File parent, String child)
		// => 'parent' 디렉토리 안에 있는 'child'파일 또는 디렉토리를 갖는다
		File file3 = new File(file2, "test.txt");
		System.out.println(file3.getName() + "의 용량크기 : " + file.length() + "(bytes)");

		// 3. new File(String parent, String child)
		File file4 = new File(".\\D_Other\\test\\..", "test.txt"); //.현재경로 , 현재 경로 안에있는  D_Other폴더 안에있는 test폴더 안 말고 test폴더 그 부모 폴더 => D_Other
		System.out.println("절대경로 " + file4.getAbsolutePath());
		System.out.println("경로 :" + file4.getPath());
		System.out.println("표준경로 :" + file4.getCanonicalPath());
		
		
		/*
		 * 디렉토리(폴더) 만들기
		 * 
		 * 1. mkdir() => File객체의 경로 중 마지막 위치의 디렉토리를 만든다
		 * 		      => 중간의 경로가 모두 미리 만들어져 있어야 한다. (수동으로 폴더 만들어야됨)
		 * 
		 * 2. mkdirs() => 중간의 경로가 없으면 중간의 경로도 새롭게 만든 후 마지막 위치의 디렉토리를 만들어 준다. (자동으로 폴더 만들어짐)
		 * 
		 * => 위 두 메서드 모두 만들기를 성공하면 true, 실패하면 false를 반환함
		 * 
		 */
		
		File file5 = new File("d:/D_Other/연습용");
		if(file5.mkdir()) {
			System.out.println(file5.getName() + "만들기 성공");
		}else {
			System.out.println(file5.getName() + "만들기 실패");
		}
		
		System.out.println();
		File file6 = new File("d:/D_other/test/java/src");
		if(file6.mkdirs()) {
			System.out.println(file6.getName() + "만들기 성공");
		}else {
			System.out.println(file6.getName() + "만들기 실패");
		}
		
		
		

	}
}
