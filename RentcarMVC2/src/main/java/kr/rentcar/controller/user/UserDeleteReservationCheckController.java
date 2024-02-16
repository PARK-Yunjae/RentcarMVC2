package kr.rentcar.controller.user;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.ReservationDAO;
import kr.rentcar.frontController.Controller;
import kr.rentcar.vo.Reservation;

// 회원탈퇴시 예약 유무 체크
public class UserDeleteReservationCheckController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id"); // { "id" : id }
		ArrayList<Reservation> list = ReservationDAO.getInstance().myReservationlist(id);
		int cnt = -1;
		if(list != null) {
			cnt = list.size();
		}
		res.getWriter().print(cnt);
		
		return null;
	}

}
