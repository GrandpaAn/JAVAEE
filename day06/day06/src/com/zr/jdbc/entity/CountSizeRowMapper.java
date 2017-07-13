package com.zr.jdbc.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.zr.jdbc.utils.RowMapper;

public class CountSizeRowMapper implements RowMapper<CountSize>{

	@Override
	public CountSize parse(ResultSet rs) {
		CountSize cs = new CountSize();
		try {
			cs.setSize(rs.getInt("size"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cs;
	}

}
