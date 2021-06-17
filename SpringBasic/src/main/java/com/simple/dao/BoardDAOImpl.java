package com.simple.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.simple.command.BoardVO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO{
	
	private List<BoardVO> lists = new ArrayList<>();
	
	@Override
	public void boardDelete(int num) {
		
		lists.remove(num);
	}
	
	@Override
	public void boardRegist(BoardVO vo) {
		
		lists.add(vo);
		
	}
	
	@Override
	public List<BoardVO> getList() {
		
		return lists;
	}

}
