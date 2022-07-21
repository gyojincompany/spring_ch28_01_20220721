package com.gyojincompany.ch2801.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.gyojincompany.ch2801.dto.ContentDto;

public class ContentDao implements IDao{
	
	JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public ContentDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<ContentDto> listDao() {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM simple_board ORDER BY mid DESC";
		
		ArrayList<ContentDto> dtos = (ArrayList<ContentDto>) template.query(sql, new BeanPropertyRowMapper<ContentDto>(ContentDto.class));
		
		return dtos;
	}

	@Override
	public void writeDao(final String mwriter, final String mcontent) {
		// TODO Auto-generated method stub
		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				String sql = "INSERT INTO simple_board (mid, mwriter, mcontent) VALUES(simple_board_seq.nextval,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, mwriter);
				pstmt.setString(2, mcontent);
				
				return pstmt;
			}
		});
		
		
	}

	@Override
	public void deleteDao(final String mid) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM simple_board WHERE mid=?";
		this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, Integer.parseInt(mid));
				
			}
		});
		
		
	}
	
	
	
	

}
