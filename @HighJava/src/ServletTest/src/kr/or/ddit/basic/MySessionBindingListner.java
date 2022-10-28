package kr.or.ddit.basic;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class MySessionBindingListner implements HttpSessionBindingListener {

	@Override
	public void valueBound(HttpSessionBindingEvent event) {

		System.out.println("[MySessionBindingListner]"
				+ "valueBound() 호출됨 => "
				+ this.hashCode() + "객체가 "
				+ event.getName() + "으로 바인딩 됨");
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("[MySessionBindingListner]"
				+ "valueUnbound() 호출됨 => "
				+ this.hashCode() + "객체가 "
				+ event.getName() + "으로 언바인딩 됨");
	}

}
