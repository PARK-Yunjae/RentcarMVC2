package kr.rentcar.controller.user;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.rentcar.dao.UserDAO;
import kr.rentcar.frontController.Controller;

// 로그인 페이지
public class LoginUserController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 값이 안넘어오고 페이지 이동시엔 로그인 창으로
		if (req.getParameter("id") == null) {
			req.setAttribute("center", "user/login.jsp");
			return  "main";
		}
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		if(UserDAO.getInstance().checkLogin(id, pw)) {
			HttpSession session = req.getSession();
			session.setAttribute("log", UserDAO.getInstance().getMemberNo(id));
			session.setAttribute("loginId", id);
			res.getWriter().write("<script>alert('로그인 성공');</script>");
			return "main";
		}else {
			req.setAttribute("center", "user/login.jsp");
			res.getWriter().write("<script>alert('로그인 실패');</script>");
			return "main";
		}
	}

}
