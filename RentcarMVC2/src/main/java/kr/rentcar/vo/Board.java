package kr.rentcar.vo;

// 게시판
public class Board {
	private int no; // 게시판 번호
	private String id; // 작성자
	private String subject; // 제목
	private String contents; // 내용
	private String regDate; // 날짜
	private String oFileName;// 파일 원본 이름
	private String sFileName;// 저장용 이름 바뀐 파일 이름

	public Board(int no, String id, String subject, String contents, String regDate, String oFileName,
			String sFileName) {
		this.no = no;
		this.id = id;
		this.subject = subject;
		this.contents = contents;
		this.regDate = regDate;
		this.oFileName = oFileName;
		this.sFileName = sFileName;
	}

	public String getoFileName() {
		return oFileName;
	}

	public void setoFileName(String oFileName) {
		this.oFileName = oFileName;
	}

	public String getsFileName() {
		return sFileName;
	}

	public void setsFileName(String sFileName) {
		this.sFileName = sFileName;
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", id=" + id + ", subject=" + subject + ", contents=" + contents + ", regDate="
				+ regDate + ", oFileName=" + oFileName + ", sFileName=" + sFileName + "]";
	}
}
