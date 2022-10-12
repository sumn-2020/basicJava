package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class T17NonSerializableParentTest {

	/*
	 * 부모클래스가 Serializable 인터페이스를 구현하고 있지 않을 경우 부모객체의 필드값 처리 방법
	 * 
	 * 1. 부모 클래스가 Serializable 인터페이스를 구현하도록 한다. 2. 자식클래스에 writeObject()와
	 * readObject()메서드를 이용하여 부모객체의 필드값을 처리할 수 있도록 직접 구현한다.
	 */

	public static void main(String[] args) throws Exception {
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:/D_Other/nonSerializableTest.bin")); //io작업한 결과물이 이 경로로 저장됨
		
		Child child = new Child();
		child.setParentName("부모");
		child.setChildName("자식");
		
		oos.writeObject(child);
		oos.close();
		
		///////////////////////////////////////////////////
		
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/D_Other/nonSerializableTest.bin"));
		
		Child child2 = (Child) ois.readObject(); //역직렬화
		System.out.println("parentName: " + child2.getParentName());
		System.out.println("childName: " + child2.getChildName());
		
	
		ois.close();


	}

}

class Parent {
	private String parentName;

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

}

class Child extends Parent implements Serializable {
	private String childName;

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}
	
	
	/**
	 *  직렬화될 때 자동으로 호출됨
	 *  (접근제한자가  private이 아니면 자동호출되지 않음)
	 *  
	 */
	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.writeUTF(getParentName()); //현재 child에 저장되어있는 문자열을 저장하겠다. 
		oos.defaultWriteObject(); //기본 기능 
	}
	
	
	/**
	 * 역직렬화가 될 때 자동으로 호출됨
	 * (접근제한자가 private이 아니면 자동 호출되지 않음)
	 * 
	 * @param ois
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		setParentName(ois.readUTF());
		ois.defaultReadObject();
	}
	
	

}
