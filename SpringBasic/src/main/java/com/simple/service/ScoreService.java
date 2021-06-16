package com.simple.service;

import java.util.List;

import com.simple.command.ScoreVO;

public interface ScoreService {

	public void regist(ScoreVO vo);
	public List<ScoreVO> getList();
	
}
