package database.admin;

public class StudentsLecVo {
	private String lecName;
	private String giveDate;
	private String giving;
	private String ing;
	private String tName;
	private String lectureFee;
	private String quota;
	private String members;
	private String sCode;
	private String lCode;
	
	StudentsLecVo(String lCode, String lecName, String lectureFee, String tName, String quota ,String members) {
		this.lCode = lCode;
		this.lecName = lecName;
		this.lectureFee = lectureFee;
		this.tName = tName;
		this.quota = quota;
		this.members = members;
	}
	
	public StudentsLecVo(String sCode, String lCode, String giveDate, String giving, String ing, int num) {
		this.sCode = sCode;
		this.lCode = lCode;
		this.giveDate = giveDate;
		this.giving = giving;
		this.ing = ing;
	}
	
	StudentsLecVo(String lCode, String lecName, String giveDate, String giving, String tName) {
		this.lecName = lecName;
		this.giveDate = giveDate;
		this.giving = giving;
		this.lCode = lCode;
		this.tName = tName;
	}
	
	public String getsCode() {
		return sCode;
	}
	
	public String getlCode() {
		return lCode;
	}
	
	public String gettName() {
		return tName;
	}

	public String getLectureFee() {
		return lectureFee;
	}

	public String getQuota() {
		return quota;
	}

	public String getMembers() {
		return members;
	}
	
	public String getLecName() {
		return lecName;
	}

	public String getGiveDate() {
		return giveDate;
	}

	public String getGiving() {
		return giving;
	}

	public String getIng() {
		return ing;
	}
	
	public String getTname() {
		return tName;
	}
	
}
