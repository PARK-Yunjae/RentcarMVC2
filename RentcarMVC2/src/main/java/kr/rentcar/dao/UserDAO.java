package kr.rentcar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.rentcar.util.DBUtil;
import kr.rentcar.vo.User;

public class UserDAO {
	private static UserDAO instance = new UserDAO();

	public static UserDAO getInstance() {
		return instance;
	}

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	// 중복 ID 체크 - 비동기
	public boolean isValidId(String id) {
		String SQL = "select pw from user where id=?";

		try {
			conn = DBUtil.getConnect();
			ps = conn.prepareStatement(SQL);
			ps.setString(1, id);
			rs = ps.executeQuery();
			return rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn,ps,rs);
		}
		return false;
	}

	// 회원 가입
	public int memberInsert(User u) {
		String SQL = "insert into user(id, pw, age, email, tel, hobby, job, info) values(?,?,?,?,?,?,?,?)";
		int cnt = -1;
		try {
			conn = DBUtil.getConnect();
			ps = conn.prepareStatement(SQL);
			ps.setString(1, u.getId());
			ps.setString(2, u.getPw());
			ps.setString(3, u.getAge());
			ps.setString(4, u.getEmail());
			ps.setString(5, u.getTel());
			ps.setString(6, u.getHobby());
			ps.setString(7, u.getJob());
			ps.setString(8, u.getInfo());
			cnt = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn,ps,rs);
		}
		return cnt;
	}

	// 로그인 시도
	public boolean checkLogin(String id, String pw) {
		String SQL = "select * from user where id=? and pw=?";
		
		try {
			conn = DBUtil.getConnect();
			ps = conn.prepareStatement(SQL);
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery();
			return rs.next();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn,ps,rs);
		}
		return false;
	}
	
	// 로그인시 회원 고유 넘버도 넘겨주기
	public int getMemberNo(String id) {
		String SQL = "select no from user where id=?";

		try {
			conn = DBUtil.getConnect();
			ps = conn.prepareStatement(SQL);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt("no");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn,ps,rs);
		}
		return -1;
	}
	// 회원 수정 - 때 가져올 메서드
	public User myInfomation(String id) {
		User u = null;
		String SQL = "select * from user where id = ?";
		
		try {
			conn = DBUtil.getConnect();
			ps = conn.prepareStatement(SQL);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				int no = rs.getInt("no");
				String pw = rs.getString("pw");
				String age = rs.getString("age");
				String email = rs.getString("email");
				String tel = rs.getString("tel");
				String hobby = rs.getString("hobby");
				String job = rs.getString("job");
				String info = rs.getString("info");
				u = new User(no, id, pw, age, email, tel, hobby, job, info);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, ps, rs);
		}
		
		return u;
	}
	
	// 회원 업데이트
	public void updateUser(User u) {
		String SQL = "update user set age = ?, email = ?, tel = ?, hobby = ?, job = ?, info = ? where id = ? ";
	
		try {
			conn = DBUtil.getConnect();
			ps = conn.prepareStatement(SQL);
			ps.setString(1, u.getAge());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getTel());
			ps.setString(4, u.getHobby());
			ps.setString(5, u.getJob());
			ps.setString(6, u.getInfo());
			ps.setString(7, u.getId());
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, ps, rs);
		}
	}
	
	// 회원탈퇴용 pw 가져가기
	public String getUserPW(String id) {
		String pw = null;
		String SQL = "select pw from user where id = ?";
		
		try {
			conn = DBUtil.getConnect();
			ps = conn.prepareStatement(SQL);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				pw = rs.getString("pw");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, ps, rs);
		}
		
		return pw;
	}
	
	// 회원탈퇴
	public int deleteUser(String id) {
		String SQL = "delete from user where id = ?";
		int cnt = -1;
		try {
			conn = DBUtil.getConnect();
			ps = conn.prepareStatement(SQL);
			ps.setString(1, id);
			cnt = ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, ps, rs);
		}
		return cnt;
	}
}
