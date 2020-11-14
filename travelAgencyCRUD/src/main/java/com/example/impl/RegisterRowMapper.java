package com.example.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.model.Register;

public class RegisterRowMapper implements RowMapper<Register> {

	@Override
	public Register mapRow(ResultSet rs, int rowNum) throws SQLException {
		Register register = new Register();
		register.setCustomerId(rs.getInt(1));
		register.setCustomerName(rs.getString(2));
		register.setEmail(rs.getString(3));
		register.setContact(rs.getString(4));
		register.setGender(rs.getString(5));
		return register;
	}

}
