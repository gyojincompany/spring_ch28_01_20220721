package com.gyojincompany.ch2801.dao;

import java.util.ArrayList;

import com.gyojincompany.ch2801.dto.ContentDto;

public interface IDao {
	
	public ArrayList<ContentDto> listDao();//리스트 불러오기
	public void writeDao(String mwriter, String mcontent);//글쓰기

}
