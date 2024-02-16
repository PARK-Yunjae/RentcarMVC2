package kr.rentcar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.rentcar.util.DBUtil;
import kr.rentcar.vo.Rentcar;
import kr.rentcar.vo.Reservation;

public class RentcarDAO {
	private static RentcarDAO instance= new RentcarDAO();

	public static RentcarDAO getInstance() {
		return instance;
	}
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	// 렌트카 목록 가져가기
	public ArrayList<Rentcar> getRentcarList(int num){
		ArrayList<Rentcar> list = new ArrayList<Rentcar>();
		String SQL = "select * from rentcar";
		if(num != 0) {
			SQL = "select * from rentcar where category = ?";
		}
		try {
			conn = DBUtil.getConnect();
			ps = conn.prepareStatement(SQL);
			if(num != 0) ps.setInt(1, num);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				int category = rs.getInt("category");
				int price = rs.getInt("price");
				int usepeople = rs.getInt("usepeople");
				int totalQty = rs.getInt("total_qty");
				String company = rs.getString("company");
				String img = rs.getString("img");
				String info = rs.getString("info");
				
				Rentcar rc = new Rentcar(no, name, category, price, usepeople, totalQty, company, img, info);
				list.add(rc);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, ps, rs);
		}
		return list;
	}
	
	// 랜트카 정보 하나 
	public Rentcar getOneRentcar(int no) {
		Rentcar c = null;
		
		String SQL = "select * from rentcar where no = ?";
		
		try {
			conn = DBUtil.getConnect();
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, no); 
			rs = ps.executeQuery();
			if(rs.next()) {
				String name = rs.getString("name");
				int category = rs.getInt("category");
				int price = rs.getInt("price");
				int usepeople = rs.getInt("usepeople");
				int totalQty = rs.getInt("total_qty");
				String company = rs.getString("company");
				String img = rs.getString("img");
				String info = rs.getString("info");
				
				c = new Rentcar(no, name, category, price, usepeople, totalQty, company, img, info);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, ps, rs);
		}
		return c;
	}
	
	// 랜트카 수량 감소
	public int updateMinusRentcarQty(int qty, int no) {
		String SQL = "update rentcar set total_qty = total_qty - ? where no = ?;";
		int cnt = -1;
		try {
			conn = DBUtil.getConnect();
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, qty);
			ps.setInt(2, no);
			cnt = ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, ps, rs);
		}
		return cnt;
	}
	
	// 랜트카 수량 증가
	public int updatePlusRentcarQty(int qty, int no) {
		String SQL = "update rentcar set total_qty = total_qty + ? where no = ?;";
		int cnt = -1;
		try {
			conn = DBUtil.getConnect();
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, qty);
			ps.setInt(2, no);
			cnt = ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, ps, rs);
		}
		return cnt;
	}
	
	// 내가 예약한 차 정보 받아가기
	public ArrayList<Rentcar> myReservationRentcarlist(ArrayList<Reservation> reservelist){
		ArrayList<Rentcar> list = new ArrayList<Rentcar>();
		String SQL = "select * from Rentcar where no = ?";

		try {
			conn = DBUtil.getConnect();
			for(int i=0 ; i<reservelist.size() ; i++) {
				ps = conn.prepareStatement(SQL);
				ps.setInt(1, reservelist.get(i).getNo());
				rs = ps.executeQuery();
				if(rs.next()) {
					int no = rs.getInt("no");
					String name = rs.getString("name");
					int category = rs.getInt("category");
					int price = rs.getInt("price");
					int usepeople = rs.getInt("usepeople");
					int totalQty = rs.getInt("total_qty");
					String company = rs.getString("company");
					String img = rs.getString("img");
					String info = rs.getString("info");
					Rentcar r = new Rentcar(no, name, category, price, usepeople, totalQty, company, img, info);
					list.add(r);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, ps, rs);
		}
		
		return list;
	}
	
	// 랜트카 추가 - 관리자
	public int insertRentcar(Rentcar r) {
		int cnt = -1;
		String SQL = "insert into rentcar(name, category, price, usepeople, total_qty, company, img, info) value(?,?,?,?,?,?,?,?);";
		
		try {
			conn = DBUtil.getConnect();
			ps = conn.prepareStatement(SQL);
			ps.setString(1, r.getName());
			ps.setInt(2, r.getCategory());
			ps.setInt(3, r.getPrice());
			ps.setInt(4, r.getUsepeople());
			ps.setInt(5, r.getTotalQty());
			ps.setString(6, r.getCompany());
			ps.setString(7, r.getImg());
			ps.setString(8, r.getInfo());
			cnt = ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, ps, rs);
		}
		
		return cnt;
	}
}
