package kr.rentcar.controller.rentcar;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.RentCarDAO;
import kr.rentcar.frontController.Controller;
import kr.rentcar.vo.Rentcar;

// 예약 차량 선택 페이지
public class SelectCarOptionController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int no = 0;
		if(req.getParameter("no") == null) {
			return "main";
		}else {
			no = Integer.parseInt(req.getParameter("no"));
		}
		Rentcar rc = RentCarDAO.getInstance().getOneRentcar(no);
		System.out.println(rc);
		req.setAttribute("rc", rc);
		req.setAttribute("center", "rentcar/reserveCarView.jsp");
		return "main";
	}

}
