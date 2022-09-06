package chapter11;

public class ByteToStringExample {
	public static void main(String[] args) {

		byte[] bytes = { 72, 101, 108, 108, 111, 32, 74, 97, 118, 97 };

		String str1 = new String(bytes);
		System.out.println(str1);

		String str2 = new String(bytes, 6, 4); // 6 => 74의 인덱스 위치, 4개
		System.out.println(str2);

	}
}
