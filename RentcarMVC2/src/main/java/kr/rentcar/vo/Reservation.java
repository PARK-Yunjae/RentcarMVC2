package kr.rentcar.vo;

// 예약
public class Reservation {
	private int reserveSeq; // 예약 번호
	private int no; // 랜트카 고유 번호
	private String id; // 고객 id
	private int qty; // 랜트 수량
	private int dday; // 대여 기간
	private String rday; // 대여일
	private int usein; // 운전자 보험 여부
	private int usewifi; // 인터넷 여부
	private int usenavi; // 네비게이션 대여 여부
	private int useseat; // 베이비 시트 적용

	public Reservation(int reserveSeq, int no, String id, int qty, int dday, String rday, int usein, int usewifi,
			int usenavi, int useseat) {
		this.reserveSeq = reserveSeq;
		this.no = no;
		this.id = id;
		this.qty = qty;
		this.dday = dday;
		this.rday = rday;
		this.usein = usein;
		this.usewifi = usewifi;
		this.usenavi = usenavi;
		this.useseat = useseat;
	}

	public int getReserveSeq() {
		return reserveSeq;
	}

	public void setReserveSeq(int reserveSeq) {
		this.reserveSeq = reserveSeq;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getDday() {
		return dday;
	}

	public void setDday(int dday) {
		this.dday = dday;
	}

	public String getRday() {
		return rday;
	}

	public void setRday(String rday) {
		this.rday = rday;
	}

	public int getUsein() {
		return usein;
	}

	public void setUsein(int usein) {
		this.usein = usein;
	}

	public int getUsewifi() {
		return usewifi;
	}

	public void setUsewifi(int usewifi) {
		this.usewifi = usewifi;
	}

	public int getUseseat() {
		return useseat;
	}

	public void setUseseat(int useseat) {
		this.useseat = useseat;
	}

	public int getUsenavi() {
		return usenavi;
	}

	public void setUsenavi(int usenavi) {
		this.usenavi = usenavi;
	}

	@Override
	public String toString() {
		return "CarReserveVO [reserveSeq=" + reserveSeq + ", no=" + no + ", id=" + id + ", qty=" + qty + ", dday="
				+ dday + ", rday=" + rday + ", usein=" + usein + ", usewifi=" + usewifi + ", usenavi=" + usenavi
				+ ", useseat=" + useseat + "]";
	}
}
