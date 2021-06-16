﻿package ex07;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Computer {

	@Autowired(required = false)
	@Qualifier("mouse")
	private Mouse mouse;
	@Resource(name="keyboard")
	private Keyboard kb;
	@Autowired
	private Monitor monitor;
	
	public Computer() {
		// TODO Auto-generated constructor stub
	}
	
	public void computerInfo() {
		System.out.println("***컴퓨터 정보***");
		mouse.info();
		kb.info();
		monitor.info();
	}
	
	
	
	
	
	
	
	
}
