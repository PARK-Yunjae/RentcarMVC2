package kr.rentcar.util;

import java.util.ArrayList;

import kr.rentcar.vo.JoinCarView;
import kr.rentcar.vo.Rentcar;
import kr.rentcar.vo.Reservation;

public class etcUtil {
	// 예약정보 띄우기 위해 따로 만듬
	public static ArrayList<JoinCarView> myReservationlist(ArrayList<Reservation> reservelist,
			ArrayList<Rentcar> rentcarlist) {
		ArrayList<JoinCarView> list = new ArrayList<JoinCarView>();
		for (int i = 0; i < reservelist.size(); i++) {
			int reserveSeq = reservelist.get(i).getReserveSeq();
			int no = rentcarlist.get(i).getNo();
			String name = rentcarlist.get(i).getName();
			String img = rentcarlist.get(i).getImg();
			int qty = reservelist.get(i).getQty();
			int dday = reservelist.get(i).getDday();
			String rday = reservelist.get(i).getRday();
			int usein = reservelist.get(i).getUsein();
			int usewifi = reservelist.get(i).getUsewifi();
			int usenavi = reservelist.get(i).getUsenavi();
			int useseat = reservelist.get(i).getUseseat();

			JoinCarView jcv = new JoinCarView(reserveSeq, no, name, img, qty, dday, rday, usein, usewifi, usenavi,
					useseat);
			list.add(jcv);
		}
		return list;
	}

	// 예약정보 띄우기 위해 따로 만듬
	public static JoinCarView mySelectReservation(Reservation re, Rentcar rc) {

		int reserveSeq = re.getReserveSeq();
		int no = rc.getNo();
		String name = rc.getName();
		String img = rc.getImg();
		int qty = re.getQty();
		int dday = re.getDday();
		String rday = re.getRday();
		int usein = re.getUsein();
		int usewifi = re.getUsewifi();
		int usenavi = re.getUsenavi();
		int useseat = re.getUseseat();

		JoinCarView jcv = new JoinCarView(reserveSeq, no, name, img, qty, dday, rday, usein, usewifi, usenavi, useseat);

		return jcv;
	}
}
