package kr.rentcar.controller.rentcar;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.RentcarDAO;
import kr.rentcar.frontController.Controller;
import kr.rentcar.vo.Rentcar;

// 예약 차량 선택 페이지
public class RentcarSelectOptionController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int no = 0;
		if(req.getParameter("no") == null) {
			return "parts/main";
		}else {
			no = Integer.parseInt(req.getParameter("no"));
		}
		Rentcar rc = RentcarDAO.getInstance().getOneRentcar(no);
		System.out.println(rc);
		req.setAttribute("rc", rc);
		
		return "rentcar/rentcarSelectOption";
	}

}
