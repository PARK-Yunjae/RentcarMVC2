package kr.rentcar.controller.user;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.UserDAO;
import kr.rentcar.frontController.Controller;
import kr.rentcar.vo.User;

// 회원 정보 수정 페이지
public class UserUpdateController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if (req.getSession().getAttribute("loginId") == null) {
			return "parts/main";
		}
		String id = (String)req.getSession().getAttribute("loginId");
		String age = req.getParameter("age");
		String email = req.getParameter("email");
		String tel = req.getParameter("tel");
		String hobby = req.getParameter("hobby");
		String job = req.getParameter("job");
		String info = req.getParameter("info");
		
		User u = new User(id, age, email, tel, hobby, job, info);
		UserDAO.getInstance().updateUser(u);
		return "parts/main";
	}
}
