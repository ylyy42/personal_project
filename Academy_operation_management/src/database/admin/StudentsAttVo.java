package database.admin;

import java.util.Date;

public class StudentsAttVo {
	private String sCode;
	private String inTime;
	private String outTime;
	private String early;
	private String earlyWhy;
	
	public StudentsAttVo(String sCode, String inTime, String outTime) {
		this.sCode = sCode;
		this.inTime = inTime;
		this.outTime = outTime;
		this.early = early;
		this.earlyWhy = earlyWhy;
	}
	
	public StudentsAttVo(String inTime, String outTime) {
		this.inTime = inTime;
		this.outTime = outTime;
	}
	
	
	public String getsCode() {
		return sCode;
	}

	public String getInTime() {
		return inTime;
	}

	public String getOutTime() {
		return outTime;
	}

	
}
