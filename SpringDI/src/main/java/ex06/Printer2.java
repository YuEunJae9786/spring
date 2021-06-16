package ex06;

import javax.annotation.Resource;

public class Printer2 {
	
	/*
	 * 자바 1.8어노테이션
	 * @Resource -> 이름으로 찾아서 주입 -> 타입으로 찾아서 주입
	 * 
	 * Resource의 빈객체 강제 연결은
	 * name 속성을 이용하면 됩니다.
	 */

	@Resource(name="doc2")
	private Document document;
	
//	기본 생성자
	public Printer2() {
		// TODO Auto-generated constructor stub
	}
//	생성자
	public Printer2(Document document) {
		this.document = document;
	}

//	setter, getter
	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
	
}
