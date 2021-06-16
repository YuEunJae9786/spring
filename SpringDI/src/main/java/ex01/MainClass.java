package ex01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("application-context.xml");
		
		SpringTest t = (SpringTest)ctx.getBean("test");
		t.test();
		
		SpringTest t2 = (SpringTest)ctx.getBean("test");
		t2.test();
		
		System.out.println(t == t2); // 아무 속성을 적지 않으면 자동으로 싱글톤 형식으로 나타납니다.
		
		System.out.println(t);
		System.out.println(t2);
		
	}
	
}
