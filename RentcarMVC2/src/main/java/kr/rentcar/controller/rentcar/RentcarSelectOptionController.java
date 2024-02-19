package kr.rentcar.controller.rentcar;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
		
		// 날짜 데이터 형식 지정
		SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd");
		// 캘린더 소환
		Calendar cal = Calendar.getInstance();
		Date minDate = cal.getTime(); // 오늘날짜 주고
		cal.add(Calendar.DATE, 10);  // 10일 더해서
		Date maxDate = cal.getTime(); // 마지막 날짜

		String min = dtFormat.format(minDate); // 사용자 형식으로 포멧
		String max = dtFormat.format(maxDate);

		req.setAttribute("value", min);
		req.setAttribute("min", min);
		req.setAttribute("max", max);
		req.setAttribute("rc", rc);
		
		return "rentcar/rentcarSelectOption";
	}

}
