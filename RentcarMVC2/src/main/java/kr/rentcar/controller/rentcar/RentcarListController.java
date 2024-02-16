package kr.rentcar.controller.rentcar;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.RentcarDAO;
import kr.rentcar.frontController.Controller;
import kr.rentcar.vo.Rentcar;

// 차 리스트
public class RentcarListController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int category = 0;
		if(req.getParameter("category") != null) {
			category = Integer.parseInt(req.getParameter("category"));
		}

		ArrayList<Rentcar> list = RentcarDAO.getInstance().getRentcarList(category);
		req.setAttribute("list", list);
		return "rentcar/rentcarList";
	}

}
