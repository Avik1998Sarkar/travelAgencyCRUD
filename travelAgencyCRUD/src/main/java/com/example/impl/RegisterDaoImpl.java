package com.example.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.Register;

@Repository
public class RegisterDaoImpl implements RegisterDao {

	@Autowired
	JdbcTemplate jt;

	@Override
	public int insert(Register register) {
		String sql = "insert into register(customerName,email,contact,gender) values(?,?,?,?)";
		int insert = jt.update(sql, register.getCustomerName(), register.getEmail(), register.getContact(),
				register.getGender());
		return insert;
	}

	@Override
	public int update(Register register) {
		String sql = "update register set customerName=?, contact=?, gender=? where customerId=? ";
		int update = jt.update(sql, register.getCustomerName(), register.getContact(), register.getGender(),
				register.getCustomerId());
		return update;
	}

	@Override
	public int delete(int id) {
		String sql = "delete from register where customerId=?";
		int delete = jt.update(sql, id);
		return delete;
	}

	@Override
	public List<Register> getall() {
		String sql = "select * from register";
		RegisterRowMapper regRowMapper = new RegisterRowMapper();
		return jt.query(sql, regRowMapper);
	}

}
