package kr.rentcar.vo;

// 회원
public class User {
	private int no; // 회원 고유 번호
	private String id; // 아이디
	private String pw; // 비밀번호
	private String age; // 나이
	private String email; // 이메일
	private String tel; // 전화번호
	private String hobby; // 취미
	private String job; // 직업
	private String info; // 정보
	
	// 가입할 때
	public User(String id, String pw, String age, String email, String tel, String hobby, String job,
			String info) {
		this.id = id;
		this.pw = pw;
		this.age = age;
		this.email = email;
		this.tel = tel;
		this.hobby = hobby;
		this.job = job;
		this.info = info;
	}

	// 불러올 때
	public User(int no, String id, String pw, String age, String email, String tel, String hobby, String job,
			String info) {
		this.no = no;
		this.id = id;
		this.pw = pw;
		this.age = age;
		this.email = email;
		this.tel = tel;
		this.hobby = hobby;
		this.job = job;
		this.info = info;
	}
	
	// 업데이트용
	public User(String id, String age, String email, String tel, String hobby, String job,
			String info) {
		this.id = id;
		this.age = age;
		this.email = email;
		this.tel = tel;
		this.hobby = hobby;
		this.job = job;
		this.info = info;
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

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "MemberVO [no=" + no + ", id=" + id + ", pw=" + pw + ", email=" + email + ", tel=" + tel + ", hobby="
				+ hobby + ", job=" + job + ", age=" + age + ", info=" + info + "]";
	}
}
