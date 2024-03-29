package ex05;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("collection-context.xml");
		
		Customer cus = (Customer)ctx.getBean("customer");
		
		List<String> list = cus.getLists();
		for(int i = 0 ; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		List<MemberVO> vo = cus.getVo();
		for(int i = 0 ; i < vo.size(); i++) {
			System.out.println(vo.get(i).getId() + " : " + vo.get(i).getName());
		}
		
	}
}
