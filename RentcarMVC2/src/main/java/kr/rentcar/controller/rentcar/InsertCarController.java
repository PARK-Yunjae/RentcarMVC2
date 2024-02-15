package kr.rentcar.controller.rentcar;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.dao.RentCarDAO;
import kr.rentcar.frontController.Controller;
import kr.rentcar.util.FileUtil;
import kr.rentcar.vo.Rentcar;

// 차량등록 - 관리자
public class InsertCarController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String saveDirectory = req.getServletContext().getRealPath("/image"); //add?파일?
		System.out.println("오니ㅏ");
		System.out.println(req.getParameter("name"));
		System.out.println(req.getParameter("category"));
		System.out.println(req.getParameter("price"));
		System.out.println(req.getParameter("usepeople"));
		System.out.println(req.getParameter("totalQty"));
		System.out.println(req.getParameter("company"));
		System.out.println(req.getParameter("info"));
		if(req.getParameter("name") == null) {
			ArrayList<Rentcar> list = RentCarDAO.getInstance().getRentcarList(0);
			req.setAttribute("no", list.size());;
			req.setAttribute("center", "rentcar/registerCar.jsp");
			return "main";
		}
		FileUtil.newFolder(req);
		
		String name = req.getParameter("name");
		int category = Integer.parseInt(req.getParameter("category"));
		int price = Integer.parseInt(req.getParameter("price"));
		int usepeople = Integer.parseInt(req.getParameter("usepeople"));
		int totalQty = Integer.parseInt(req.getParameter("totalQty"));
		String company = req.getParameter("company");
		String img = FileUtil.uploadFile(req, saveDirectory);
		String info = req.getParameter("info");
		
		Rentcar r = new Rentcar(0, name, category, price, usepeople, totalQty, company, img, info);
		int cnt = RentCarDAO.getInstance().insertRentcar(r);
		System.out.println(cnt);
		if(cnt > 0) {
			return "main";
		}else {
			throw new ServletException("not insert");
		}
			
	}

}
