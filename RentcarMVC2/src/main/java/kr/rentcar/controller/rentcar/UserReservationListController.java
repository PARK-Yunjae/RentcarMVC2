package kr.rentcar.controller.rentcar;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.rentcar.dao.RentcarDAO;
import kr.rentcar.dao.ReservationDAO;
import kr.rentcar.frontController.Controller;
import kr.rentcar.util.etcUtil;
import kr.rentcar.vo.JoinCarView;
import kr.rentcar.vo.Rentcar;
import kr.rentcar.vo.Reservation;

// 유저 예약 목록
public class UserReservationListController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("loginId");
		if (session.getAttribute("loginId") == null) {
			return "parts/main";
		}
		ArrayList<Reservation> reservelist = ReservationDAO.getInstance().myReservationlist(id);
		ArrayList<Rentcar> rentcarlist = RentcarDAO.getInstance().myReservationRentcarlist(reservelist);
		// 두개를 합친 리스트를 따로 만듬
		ArrayList<JoinCarView> list = etcUtil.myReservationlist(reservelist, rentcarlist);
		req.setAttribute("list", list);

		return "rentcar/userReservationList";
	}

}
