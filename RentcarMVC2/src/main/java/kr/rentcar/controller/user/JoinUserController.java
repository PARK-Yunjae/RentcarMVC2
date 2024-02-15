package kr.rentcar.controller.user;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.UserDAO;
import kr.rentcar.frontController.Controller;
import kr.rentcar.vo.User;

// 회원가입
public class JoinUserController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if (req.getParameter("id") == null) {
			req.setAttribute("center", "user/join.jsp");
			return "main";
		}
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String age = req.getParameter("age");
		String email = req.getParameter("email");
		String tel = req.getParameter("tel");
		String hobby = req.getParameter("hobby");
		String job = req.getParameter("job");
		String info = req.getParameter("info");
		User vo = null;

		vo = new User(id, pw, age, email, tel, hobby, job, info);
		
		int cnt = UserDAO.getInstance().memberInsert(vo);
		if (cnt > 0) {
			return "main";
		} else {
			throw new ServletException("not insert");
		}
	}
}
