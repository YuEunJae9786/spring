package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.Quiz01VO;

@Controller
@RequestMapping("/quiz")
public class QuizController {

	@RequestMapping("/quiz01")
	public void quiz01() {
		
	}
	
	@RequestMapping(value = "/sendBirth", method = RequestMethod.POST)
	public ModelAndView sendBirth(Quiz01VO vo) {
		
		System.out.println(vo.toString());
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("birth", vo);
		mv.setViewName("/quiz/quiz01_ok");
		
		return mv;
	}
	
	@RequestMapping("/quiz02")
	public void quiz02() {
		
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute("id") String id,
					   @ModelAttribute("pw") String pw,
					   @ModelAttribute("name") String name,
					   @ModelAttribute("email") String email) {

		System.out.println(id);
		System.out.println(pw);
		System.out.println(name);
		System.out.println(email);
		
		return "quiz/quiz02_ok";
	}
	
	@RequestMapping("/quiz03")
	public void quiz03() {
		
	}
	
	@RequestMapping(value = "/join2", method = RequestMethod.POST)
	public ModelAndView join2(@ModelAttribute("id") String id,
						@RequestParam("pw") String pw,
						@RequestParam("pw_check") String pwCheck,
						RedirectAttributes RA) {
		
		ModelAndView mv = new ModelAndView();
		
		if(id.equals("")) {
			RA.addFlashAttribute("msg1", "아이디를 입력하세요");
			mv.setViewName("redirect:/quiz/quiz03");
		}
		if(!pw.equals(pwCheck) || pw.equals("")) {
			RA.addFlashAttribute("msg2", "비밀번호를 확인하세요");
			mv.setViewName("redirect:/quiz/quiz03");
		}
		
		if(!id.equals("") && pw.equals(pwCheck) && !pw.equals("")) mv.setViewName("/quiz/quiz03_ok");
		
		return mv;
	}
	
}