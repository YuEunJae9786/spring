package com.simple.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.simple.command.BoardVO;
import com.simple.dao.BoardDAO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	@Qualifier("boardDAO")
	private BoardDAO boardDAO;
	
	@Override
	public void boardDelete(int num) {
		
		boardDAO.boardDelete(num);
	}
	
	@Override
	public void boardRegist(BoardVO vo) {
		
		boardDAO.boardRegist(vo);
	}
	
	@Override
	public List<BoardVO> getList() {
		
		return boardDAO.getList();
	}

}
