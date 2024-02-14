package kr.rentcar.controller.rentcar;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.RentCarDAO;
import kr.rentcar.frontController.Controller;
import kr.rentcar.vo.Rentcar;

// 차 정보
public class CarInfoController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int no = 0;
		if(req.getParameter("no") != null) {
			no = Integer.parseInt(req.getParameter("no"));
		}
		Rentcar rc = RentCarDAO.getInstance().getOneRentcar(no);
		req.setAttribute("rc", rc);
		req.setAttribute("center", "rentcar/rentcarInfo.jsp");
		return "main";
	}

}
