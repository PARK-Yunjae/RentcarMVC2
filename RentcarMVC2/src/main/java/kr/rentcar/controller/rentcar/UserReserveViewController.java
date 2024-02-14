package kr.rentcar.controller.rentcar;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.RentCarDAO;
import kr.rentcar.dao.ReservationDAO;
import kr.rentcar.frontController.Controller;
import kr.rentcar.util.etcUtil;
import kr.rentcar.vo.JoinCarView;
import kr.rentcar.vo.Rentcar;
import kr.rentcar.vo.Reservation;

// 유저 예약 상세 페이지
public class UserReserveViewController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if(req.getParameter("reserveSeq") == null) 
			return "main";
		
		String reserveSeq = req.getParameter("reserveSeq");
		
		Reservation re = ReservationDAO.getInstance().getOneReservation(reserveSeq);
		Rentcar rc = RentCarDAO.getInstance().getOneRentcar(re.getNo());
		JoinCarView jcv = etcUtil.mySelectReservation(re, rc);

		req.setAttribute("jcv", jcv);
		req.setAttribute("center", "rentcar/userReserveView.jsp");

		return "main";
	}

}
