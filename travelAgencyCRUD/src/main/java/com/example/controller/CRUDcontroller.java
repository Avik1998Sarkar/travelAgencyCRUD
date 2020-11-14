package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.impl.RegisterDao;
import com.example.model.Register;
import com.example.validator.CustomerValidator;

@Controller
public class CRUDcontroller {

	@Autowired
	RegisterDao registerDao;

	@Autowired
	CustomerValidator custValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(custValidator);
	}

	@RequestMapping(value = "/registerPage", method = RequestMethod.GET)
	public ModelAndView goRegisterPage(Model model) {
		model.addAttribute("register", new Register());
		return new ModelAndView("register");
	}

	@RequestMapping(value = "/submitRegister", method = RequestMethod.POST)
	public ModelAndView showRegisterPage(@ModelAttribute("register") @Validated Register register,
			BindingResult result) {
		ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			mv.setViewName("register");
			return mv;
		}
		List<Register> getall = registerDao.getall();
		System.out.println(getall);
		for (Register i : getall) {
			System.out.println(i.getEmail());
			System.out.println(register.getEmail());
			if (i.getEmail().equals(register.getEmail())) {
				String str = "<div class=\"alert alert-danger alert-dismissible text-center\">\r\n"
						+ "			<button class=\"close\" type=\"button\" data-dismiss=\"alert\">\r\n"
						+ "				<span>&times;</span>\r\n" + "			</button>\r\n"
						+ "			<strong>User Already Registed</strong> with this Email-ID\r\n" + "		</div>";
				mv.addObject("sameEmail", str);
				mv.setViewName("register");
				return mv;
			}
		}
		int insert = registerDao.insert(register);
		if (insert >= 1) {
			String str = "<div class=\"alert alert-success alert-dismissible text-center\">\r\n"
					+ "			<button class=\"close\" type=\"button\" data-dismiss=\"alert\">\r\n"
					+ "				<span>&times;</span>\r\n" + "			</button>\r\n"
					+ "			<strong>Registration Successful!</strong> Now Try To Login\r\n" + "		</div>";
			mv.addObject("nowlogin", str);
			mv.setViewName("register");
			return mv;
		} else {
			mv.setViewName("register");
			return mv;
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView goUpdatePage(@RequestParam String customerName, @RequestParam String contact,
			@RequestParam String gender, @RequestParam String customerId, ModelMap model) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("contact", contact);
		mv.addObject("customerName", customerName);
		mv.addObject("gender", gender);
		mv.addObject("customerId", Integer.parseInt(customerId));
		mv.setViewName("update");
		return mv;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView showUpdatePage(@ModelAttribute("update") Register register, ModelMap model) {
		int update = registerDao.update(register);
		if (update >= 1) {
			String str = "<div class=\"alert alert-success alert-dismissible text-center\">\r\n"
					+ "			<button class=\"close\" type=\"button\" data-dismiss=\"alert\">\r\n"
					+ "				<span>&times;</span>\r\n" + "			</button>\r\n"
					+ "			Credential<strong> Updated!</strong>" + "		</div>";
			model.put("updatedonemsg", str);
			return showAll();
		}
		return showAll();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView goDeletePage(@RequestParam int customerId, ModelMap model) {
		ModelAndView mv = new ModelAndView();
		int delete = registerDao.delete(customerId);
		if (delete >= 1) {
			String str = "<div class=\"alert alert-danger alert-dismissible text-center\">\r\n"
					+ "			<button class=\"close\" type=\"button\" data-dismiss=\"alert\">\r\n"
					+ "				<span>&times;</span>\r\n" + "			</button>\r\n"
					+ "			<strong>Deleted Successful!</strong>\r\n" + "		</div>";
			mv.addObject("deletedone", str);
			mv.setViewName("register");
		}
		return showAll();
	}

	@RequestMapping(value = "/showAll", method = RequestMethod.GET)
	public ModelAndView showAll() {
		ModelAndView mv = new ModelAndView();
		List<Register> getall = registerDao.getall();
		mv.addObject("list", getall);
		if (getall.size() == 0) {
			String str = "<tr>\r\n" + "				<td colspan=\"5\">No Data Available\r\n"
					+ "				</td>\r\n" + "			</tr>";
			mv.addObject("nothing", str);
		}
		mv.setViewName("showall");
		return mv;
	}
}
