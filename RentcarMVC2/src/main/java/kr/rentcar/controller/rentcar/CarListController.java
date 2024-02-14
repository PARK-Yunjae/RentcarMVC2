package kr.rentcar.controller.rentcar;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.RentCarDAO;
import kr.rentcar.frontController.Controller;
import kr.rentcar.vo.Rentcar;

// 차 리스트
public class CarListController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int category = 0;
		if(req.getParameter("category") != null) {
			category = Integer.parseInt(req.getParameter("category"));
		}

		ArrayList<Rentcar> list = RentCarDAO.getInstance().getRentcarList(category);
		req.setAttribute("list", list);
		req.setAttribute("center", "rentcar/rentCarList.jsp");
		return "main";
	}

}
