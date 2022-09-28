package kr.or.ddit.basic;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * Annotation에 대하여
 * 
 * 프로그램 소스코드 안에  다른 프로그램을 위한 정보를 미리 약속된 형식으로 포함시킨것 (JDK1.5부터 지원)
 * 
 * 주석처럼 프로그램에 영향을 미치지 않으면서도 다른 프로그램에게 유용한 정보를 제공함
 * 
 * 종류: 1. 표준 애너테이션
 *      2. 메타 애너테이션(애너테이션을 위한 애너테이션, 즉 애너테이션을 정의할 때 사용하는 애너테이션)
 *      
 * 애너테이션 요소의 규칙 
 * 1. 요소의 타입은 기본형, String, enum, annotation, class만 허용함.
 * 2. ()안에 매개변수를 선언할 수 없다.
 * 3. 예외를 선언할 수 없다.
 * 4. 요소의 타입에 타입 파라미터(제너릭타입글자)를 사용할 수 없다. 
 * 
 */


@Target({ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER}) //적용 대상 지정함 => PrintAnnotation을 메소드로 지정 , 메소드에만 annotation붙일수있음 
@Retention(RetentionPolicy.RUNTIME) //유지지간 지정함(기본: CLASS 레벨까지만 유지, RUNTIME까지 유지되려면 따로 선언해줘야됨 =>@Retention(RetentionPolicy.RUNTIME))
public @interface PrintAnnotation {
	//int id = 100; //상수선언 가능. static final int id = 100;
	String value() default "-"; //value()의 타입은 String으로 쓸 것이다. / default는 마이너스로 
	int count() default 20; //count()의 타입은 Integer으로 쓸 것이다. 
}



















