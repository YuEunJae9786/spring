package com.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.BoardVO;
import com.simple.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardServiceController {

	@Autowired
	@Qualifier("boardService")
	private BoardService boardService;
	
//	리스트 화면
	@RequestMapping("boardList")
	public ModelAndView boardList() {

		ModelAndView mv = new ModelAndView();
		mv.addObject("list", boardService.getList());
		mv.setViewName("/board/boardList");
		
		return mv;
	}
	
//	등록 화면
	@RequestMapping("boardRegister")
	public void boardRegist() {
		
	}
	
//	결과 화면
	@RequestMapping("boardResult")
	public void boardResult() {
		
	}
	
//	등록요청
	@RequestMapping("boardForm")
	public String boardForm(BoardVO vo) {
		
		boardService.boardRegist(vo);
		
		return "/board/boardResult";
	}
	
//	삭제요청
	@RequestMapping("boardDelete")
	public ModelAndView boardDelete(@RequestParam("num") int num,
									RedirectAttributes RA) {
		
		boardService.boardDelete(num);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/board/boardList");
		
		RA.addFlashAttribute("msg", "삭제가 완료 되었습니다");
		
		return mv;
	}
	
}
