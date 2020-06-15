package net.kanozo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.kanozo.domain.KanozoVO;
import net.kanozo.domain.UserVO;
import net.kanozo.validator.KanozoValidator;

@Controller
@RequestMapping("/user/")
public class UserController {
	@RequestMapping(value = "regist", method = RequestMethod.GET)
	public String viewRegistPage(HttpServletRequest req) {

		return "user/regist";
	}

	@RequestMapping(value = "regist", method = RequestMethod.POST)
	public String registProcess(KanozoVO kanozoVO, Errors errors, Model model) {
		new KanozoValidator().validate(kanozoVO, errors);
		if (errors.hasErrors()) {
			model.addAttribute("errors", errors);
			return "error"; // 에러가 존재할 시 error페이지로 이동
		}
		return "user/registok";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String viewLoginPage() {
		return "user/login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String loginProcess(UserVO user, HttpServletRequest req) {
		if (user.getUserid().equals("kanozo") && user.getPassword().equals("1234")) {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			// 로그인 성공시 메인화면으로 이동
			return "redirect:/";
		} else {
			// 실패시 다시 로그인 화면으로 이동
			return "redirect:/user/login";
		}
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logoutProcess(HttpSession session) {
		if (session.getAttribute("user") != null) {
			session.removeAttribute("user");
			return "redirect:/";
		} else {
			return "redirect:/user/login";
		}
	}

	@RequestMapping(value = "info", method = RequestMethod.GET)
	public String viewInfoPage(HttpSession session) {
		if (session.getAttribute("user") == null) {
			// 로그인 되자 않은 유저는 로그인 페이지로 다이렉트!
			return "redirect:/user/login";
		}
		return "user/info";
	}
}
