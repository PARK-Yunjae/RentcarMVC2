package kr.rentcar.vo;

public class JoinCarView {
	private int reserveSeq; // 예약 번호
	private int no; // 차량 번호
	private String name; // 차량 이름
	private String img; // 차량 이미지
	private int qty; // 랜트 수량
	private int dday; // 대여 기간
	private String rday; // 대여일
	private int usein; // 운전자 보험 여부
	private int usewifi; // 인터넷 여부
	private int usenavi; // 네비게이션 대여 여부
	private int useseat; // 베이비 시트 적용

	public JoinCarView(int reserveSeq, int no, String name, String img, int qty, int dday, String rday, int usein,
			int usewifi, int usenavi, int useseat) {
		super();
		this.reserveSeq = reserveSeq;
		this.no = no;
		this.name = name;
		this.img = img;
		this.qty = qty;
		this.dday = dday;
		this.rday = rday;
		this.usein = usein;
		this.usewifi = usewifi;
		this.usenavi = usenavi;
		this.useseat = useseat;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getReserveSeq() {
		return reserveSeq;
	}

	public void setReserveSeq(int reserveSeq) {
		this.reserveSeq = reserveSeq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
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

	public int getUsenavi() {
		return usenavi;
	}

	public void setUsenavi(int usenavi) {
		this.usenavi = usenavi;
	}

	public int getUseseat() {
		return useseat;
	}

	public void setUseseat(int useseat) {
		this.useseat = useseat;
	}

	@Override
	public String toString() {
		return "JoinCarView [reserveSeq=" + reserveSeq + ", name=" + name + ", img=" + img + ", qty=" + qty + ", dday="
				+ dday + ", rday=" + rday + ", usein=" + usein + ", usewifi=" + usewifi + ", usenavi=" + usenavi
				+ ", useseat=" + useseat + "]";
	}

}
