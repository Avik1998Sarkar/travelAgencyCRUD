package com.example.impl;

import java.util.List;

import com.example.model.Register;

public interface RegisterDao {
	int insert(Register register);

	int update(Register register);

	int delete(int id);

	List<Register> getall();
}
