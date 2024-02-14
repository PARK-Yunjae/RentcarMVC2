package kr.rentcar.controller.user;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.UserDAO;
import kr.rentcar.frontController.Controller;

// 유저 id 중복 확인 - 비동기
public class ValidateIdController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// $.ajax();
		String id = req.getParameter("id"); // { "id" : id }
		String passData = UserDAO.getInstance().isValidId(id) ? "notValid" : "valid";

		// ajax() 함수에 만들어놓은 callback함수 응답
		res.getWriter().print(passData); // "notValid" : "valid";

		return null;
	}

}
