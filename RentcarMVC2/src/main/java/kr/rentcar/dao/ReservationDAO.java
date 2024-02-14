package kr.rentcar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.rentcar.util.DBUtil;
import kr.rentcar.vo.Reservation;

public class ReservationDAO {
	public static ReservationDAO instance = new ReservationDAO();

	public static ReservationDAO getInstance() {
		return instance;
	}
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	// 예약 데이터 베이스에 넣기
	public int insertReservation(Reservation r) {
		int cnt = 0;
		String SQL = "insert into reservation(no,id,qty,dday,rday,usein,usewifi,usenavi,useseat) value(?,?,?,?,?,?,?,?,?)";
		try {
			conn = DBUtil.getConnect();
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, r.getNo());
			ps.setString(2, r.getId());
			ps.setInt(3, r.getQty());
			ps.setInt(4, r.getDday());
			ps.setString(5, r.getRday());
			ps.setInt(6, r.getUsein());
			ps.setInt(7, r.getUsewifi());
			ps.setInt(8, r.getUsenavi());
			ps.setInt(9, r.getUseseat());
			cnt = ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, ps, rs);
		}
		
		return cnt;
	}
	
	// 내가 예약한 리스트 가져오기
	public ArrayList<Reservation> myReservationlist(String id){
		ArrayList<Reservation> list = new ArrayList<Reservation>();
		String SQL = "select * from reservation where id = ?";
		
		try {
			conn = DBUtil.getConnect();
			ps = conn.prepareStatement(SQL);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				int reserveSeq = rs.getInt("reserve_seq");
				int no = rs.getInt("no");
				int qty = rs.getInt("qty");
				int dday = rs.getInt("dday");
				String rday = rs.getString("rday");
				int usein = rs.getInt("usein");
				int usewifi = rs.getInt("usewifi");
				int usenavi = rs.getInt("usenavi");
				int useseat = rs.getInt("useseat");
				
				Reservation r = new Reservation(reserveSeq, no, id, qty, dday, rday, usein, usewifi, usenavi, useseat);
				list.add(r);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, ps, rs);
		}
		return list;
	}
	
	// 예약 취소
	public int deleteReservation(String reserveSeq) {
		int cnt = -1;
		String SQL = "delete from reservation where reserve_seq = ?;";
		
		try {
			conn = DBUtil.getConnect();
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, Integer.parseInt(reserveSeq));
			cnt = ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, ps, rs);
		}
		
		return cnt;
	}
	
	// 상세 페이지를 위한 예약 값 가져오기
	public Reservation getOneReservation(String reserveSeq) {
		Reservation r = null;
		String SQL = "select * from reservation where reserve_seq= ? ";
		
		try {
			conn = DBUtil.getConnect();
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, Integer.parseInt(reserveSeq));
			rs = ps.executeQuery();
			if(rs.next()) {
				int no = rs.getInt("no");
				String id = rs.getString("id");
				int qty = rs.getInt("qty");
				int dday = rs.getInt("dday");
				String rday = rs.getString("rday");
				int usein = rs.getInt("usein");
				int usewifi = rs.getInt("usewifi");
				int usenavi = rs.getInt("usenavi");
				int useseat = rs.getInt("useseat");
				
				r = new Reservation(Integer.parseInt(reserveSeq), no, id, qty, dday, rday, usein, usewifi, usenavi, useseat);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, ps, rs);
		}
		
		return r;
	}
}
