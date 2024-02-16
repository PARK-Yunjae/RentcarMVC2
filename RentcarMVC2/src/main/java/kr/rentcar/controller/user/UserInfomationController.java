package kr.rentcar.controller.user;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.UserDAO;
import kr.rentcar.frontController.Controller;
import kr.rentcar.vo.User;

// 회원 정보 수정하기
public class UserInfomationController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = (String)req.getSession().getAttribute("loginId");
		
		User u = UserDAO.getInstance().myInfomation(id);
		
		req.setAttribute("u", u);

		return "user/userInfomation";
	}

}
