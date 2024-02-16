package kr.rentcar.controller.rentcar;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.RentcarDAO;
import kr.rentcar.dao.ReservationDAO;
import kr.rentcar.frontController.Controller;
import kr.rentcar.vo.Reservation; 

// 랜트카 예약 처리
public class RentcarReservationController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if(req.getParameter("no") == null) {
			return "parts/main";
		}
		int no = Integer.parseInt(req.getParameter("no"));
		String id = (String)req.getSession().getAttribute("loginId");
		int qty = Integer.parseInt(req.getParameter("qty"));
		int dday = Integer.parseInt(req.getParameter("dday"));
		String rday = req.getParameter("rday");
		int usein = Integer.parseInt(req.getParameter("usein"));
		int usewifi = Integer.parseInt(req.getParameter("usewifi"));
		int usenavi = Integer.parseInt(req.getParameter("usenavi"));
		int useseat = Integer.parseInt(req.getParameter("useseat"));
		
		Reservation r = new Reservation(0, no, id, qty, dday, rday, usein, usewifi, usenavi, useseat);
		ReservationDAO.getInstance().insertReservation(r);
		int cnt = RentcarDAO.getInstance().updateMinusRentcarQty(qty, no); // 랜트카 수량 갱신
		
		if(cnt > 0) {
			return "parts/main";
		}else {
			throw new ServletException("not insert");
		}
	}

}
