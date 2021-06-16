package com.simple.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.simple.command.ScoreVO;

@Repository("scoreDAO")
public class ScoreDAOImpl implements ScoreDAO {
	
	// DB로 가정
	private List<ScoreVO> list = new ArrayList<>();

	@Override
	public void regist(ScoreVO vo) {
		
		list.add(vo); // DB에 저장
		
		System.out.println("넘어오는 값:" + vo.getName());
		System.out.println("넘어오는 값:" + vo.getKor());
		System.out.println("넘어오는 값:" + vo.getEng());
		
	}
	
	@Override
	public List<ScoreVO> getList() {
		
		// DB 관련 처리.....
		
		return list;
	}
	
}