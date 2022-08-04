package database.lecture;

public class LectureVo {

	private String lCode;
	private String lName;
	private String lFee;
	private String quota;
	private String days;
	private String tCode;
	private String lectureStartdate;
	private String tName;
	
	public LectureVo(String lCode, String lName, String lFee, String quota, String days, String tCode, String lectureStartdate) {
		this.lCode = lCode;
		this.lName = lName;
		this.lFee = lFee;
		this.quota = quota;
		this.days = days;
		this.tCode = tCode;
		this.lectureStartdate = lectureStartdate;
	}
	
	public LectureVo(String lCode, String lName, String lectureStartdate, String tName) {
		this.lCode = lCode;
		this.lName = lName;
		this.lectureStartdate = lectureStartdate;
		this.tName = tName;
	}

	public String getlCode() {
		return lCode;
	}

	public String getlName() {
		return lName;
	}

	public String getLectureStartdate() {
		return lectureStartdate;
	}
	
	public String gettName() {
		return tName;
	}
	
	public String getlFee() {
		return lFee;
	}

	public String getQuota() {
		return quota;
	}

	public String getDays() {
		return days;
	}

	public String gettCode() {
		return tCode;
	}
	
}
