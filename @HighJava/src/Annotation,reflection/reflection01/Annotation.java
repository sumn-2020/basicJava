import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Annotation {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException {

	
		Class anyClass = Class.forName("UserService");
		
		//클래스 정보 가져오기
		System.out.println(anyClass.getName());
		
		
		//필드정보 가져오기 :  private 일 경우 출력 되지 않는다.
		Field[] fields = anyClass.getFields();
		for (Field f : fields) {
			System.out.println(f.getName());
		}
		
		System.out.println();
		
		//메소드 정보 가져오기 : private 이여도 출력 된다.
		Method[] declaredMethods = anyClass.getDeclaredMethods();
		for (Method m : declaredMethods) {
			System.out.println(m.getName());
		}
		
		System.out.println();
		
		//생성자 정보 
		Constructor[] constructors = anyClass.getConstructors();
		for (Constructor c : constructors) {
			System.out.println(c.getName()  + ", Param count: " + c.getParameterCount());
		}
		
		System.out.println();
		
		//같은 클래스 인지 확인
		boolean result = anyClass.isInstance(new UserService());
		System.out.println(result);
		
		
		
		
		
		
		
	}
}




