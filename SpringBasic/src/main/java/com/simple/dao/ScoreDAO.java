package com.simple.dao;

import java.util.List;

import com.simple.command.ScoreVO;

public interface ScoreDAO {
	
	public void regist(ScoreVO vo);
	public List<ScoreVO> getList();
	public void delete(int num); // 삭제
	
}
