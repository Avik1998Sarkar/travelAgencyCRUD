package com.example.validator;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.example.impl.RegisterDao;
import com.example.model.Register;

@Component
public class CustomerValidator implements org.springframework.validation.Validator {

	@Autowired
	RegisterDao regDao;

	@Override
	public boolean supports(Class<?> clazz) {
		return Register.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerName", "", "Fill Customer Name Field");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "", "Fill Email Field");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contact", "", "Fill Contact Field");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "", "Fill gender Field");

		Register customer = (Register) target;
		Pattern pattern = Pattern.compile("^([0-9]{10})$");
		if (!(pattern.matcher(customer.getContact()).matches())) {
			errors.rejectValue("contact", "", "Enter Valid contact");
		}
		
		List<Register> getall = regDao.getall();
		int flag = 1;
		for (Register i : getall) {
			if(i.getEmail().equals(customer.getEmail())) {
				flag = 0;
			}
		}
		if(flag == 0) {
			errors.rejectValue("email", "", "Email already Registered");
		}
	}

	
}
