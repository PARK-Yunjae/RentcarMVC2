package kr.rentcar.controller.rentcar;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.RentcarDAO;
import kr.rentcar.dao.ReservationDAO;
import kr.rentcar.frontController.Controller;

// 예약 삭제
public class RentcarReservationDeleteController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String ctx = req.getContextPath();
		
		if (req.getParameter("reserveSeq") == null) {
			return "parts/main";
		}
		String reserveSeq = req.getParameter("reserveSeq");
		int no = Integer.parseInt(req.getParameter("no"));
		int qty = Integer.parseInt(req.getParameter("qty"));

		// 예약 페이지 삭제
		ReservationDAO.getInstance().deleteReservation(reserveSeq);
		// 랜트카 수량 증가
		RentcarDAO.getInstance().updatePlusRentcarQty(qty, no);

		return "redirect:" + ctx + "/userResercationList.do";
	}

}
