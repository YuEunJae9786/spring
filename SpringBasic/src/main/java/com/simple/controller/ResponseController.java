package com.simple.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.ReqVO;

@Controller
@RequestMapping("/response")
public class ResponseController {
	
//	res_ex01 화면처리
	@RequestMapping("/res_ex01")
	public void res_ex01() {
		
	}
	
//	Model 전달자 - 화면으로 전달할 데이터를 addAttribute(키, 값)
	@RequestMapping("/res_ex02")
	public String res_ex02(Model model) {
		
		model.addAttribute("serverTime", new Date());
		model.addAttribute("name", "홍길동");
		
		return "response/res_ex02";
	}
	
//	ModelAndView 방법 - 데이터 addObject(키, 값) , 화면정보 setViewName()
	@RequestMapping("/res_ex03")
	public ModelAndView res_ex03() {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("serverTime", new Date());
		mv.setViewName("/response/res_ex03");
		
		return mv; // 디패스쳐 서블릿으로 반환 ( 디스패쳐가 받아서, view 에 대한 정보를 꺼내서 이동 )
	}
	
//	@ModelAttribute 전달자 - @RequestParam + Model
	@RequestMapping("/res_ex04")
	public String res_ex04(@ModelAttribute("id") String a) {
		
		System.out.println("넘어온 값:" + a);
		
		return "/response/res_ex04";
	}
	
//	@ModelAttribute 여러 값
	@RequestMapping("/res_ex05")
	public String res_ex05(@ModelAttribute("info") ReqVO vo) {
		
		System.out.println("넘어온 값:" + vo.toString());
		
		return "/response/res_ex05";
	}
	
//	========= 리다이렉트와 리다이렉트어트리뷰트 ================
	@RequestMapping("/res_redirect")
	public void res_redirect() {
		
	}
	
//	가정 - 아이디 비밀번호가 동일하면 성공화면, 다르다면 다시 로그인화면으로 이동
	@RequestMapping("/login")
	public String login(ReqVO vo,
						RedirectAttributes RA) {
		
		if(!vo.getId().equals(vo.getPw() )){ // 실패
//			redirect:/절대경로 - 다시 컨트롤러를 타게한다.
//			이 때 화면에 1회성 데이터로 값을 전당하고 싶다면 RedirectAttributes 객체의 addFlashAttribute를 이용합니다.
			RA.addFlashAttribute("msg", "아이디 비밀번호를 확인하세요");
			return "redirect:/response/res_redirect"; // 다시 로그인화면
		}
		
		return "response/res_login_ok";
	}
	
//	====== res_quiz01 ======
	@RequestMapping("/res_quiz01")
	public void res_quiz01() {
		
	}
	
	@RequestMapping(value = "/res_login", method = RequestMethod.POST)
	public String res_login(ReqVO vo, Model model) {

		model.addAttribute("id", vo.getId());
		
		if(vo.getId().equals("kim12") && vo.getPw().equals("1234")) {
			return "/response/res_quiz02";
		}
		
		return "/response/res_quiz03";
	}
	
	

}
