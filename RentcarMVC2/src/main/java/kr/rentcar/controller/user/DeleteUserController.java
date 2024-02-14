package kr.rentcar.controller.user;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.UserDAO;
import kr.rentcar.frontController.Controller;

// 회원 탈퇴
public class DeleteUserController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id =(String)req.getSession().getAttribute("loginId");
		if(id == null) {
			return "main";
		}
		else if(req.getParameter("pw") == null) {
			String pw = UserDAO.getInstance().getUserPW(id);
			req.setAttribute("id", id);
			req.setAttribute("pw", pw);
			return "main";
		}
		UserDAO.getInstance().deleteUser(id);
		
		return "main";
	}
}
