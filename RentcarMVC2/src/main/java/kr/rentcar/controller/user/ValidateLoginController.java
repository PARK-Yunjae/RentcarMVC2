package kr.rentcar.controller.user;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.UserDAO;
import kr.rentcar.frontController.Controller;

// 로그인 체크 - 비동기
public class ValidateLoginController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		String passData = UserDAO.getInstance().checkLogin(id, pw) ? "성공" : "실패";
		
		res.getWriter().print(passData);
		
		return null;
	}

}
