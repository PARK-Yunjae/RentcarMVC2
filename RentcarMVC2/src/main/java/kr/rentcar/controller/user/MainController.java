package kr.rentcar.controller.user;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.RentcarDAO;
import kr.rentcar.frontController.Controller;
import kr.rentcar.vo.Rentcar;

// 메인 페이지
public class MainController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		ArrayList<Rentcar> list = RentcarDAO.getInstance().getRentcarList(0);
		req.setAttribute("list", list);
		return "parts/main";
	}

}
