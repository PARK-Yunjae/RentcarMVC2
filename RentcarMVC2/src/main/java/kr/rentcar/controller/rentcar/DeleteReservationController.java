package kr.rentcar.controller.rentcar;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.RentCarDAO;
import kr.rentcar.dao.ReservationDAO;
import kr.rentcar.frontController.Controller;

// 예약 삭제
public class DeleteReservationController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String ctx = req.getContextPath();
		int cnt = -1;
		
		if (req.getParameter("reserveSeq") == null) {
			return "main";
		}
		String reserveSeq = req.getParameter("reserveSeq");
		int no = Integer.parseInt(req.getParameter("no"));
		int qty = Integer.parseInt(req.getParameter("qty"));

		// 예약 페이지 삭제
		cnt = ReservationDAO.getInstance().deleteReservation(reserveSeq);
		// 랜트카 수량 증가
		cnt = RentCarDAO.getInstance().addRentcarQty(qty, no);
		System.out.println("삭제 했니");
		return "redirect:" + ctx + "/userResecationList.do";
	}

}
