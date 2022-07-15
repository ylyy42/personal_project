package database.admin;

public class StudentsFeeVo {
	
	private String sCode;
	private String sName;
	private String giveDate;
	private String lectureFee;
	private String giving;
	
	public StudentsFeeVo(String sCode, String sName, String giveDate, String lectureFee, String giving) {
		this.sCode = sCode;
		this.sName = sName;
		this.giveDate = giveDate;
		this.lectureFee = lectureFee;
		this.giving = giving;
	}

	public String getsCode() {
		return sCode;
	}

	public String getsName() {
		return sName;
	}

	public String getGiveDate() {
		return giveDate;
	}

	public String getLectureFee() {
		return lectureFee;
	}

	public String getGiving() {
		return giving;
	}
	
}
