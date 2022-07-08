package database.admin;

import java.util.Date;

public class StudentsAttVo {
	private String inTime;
	private String outTime;
	private String early;
	private String earlyWhy;
	
	public StudentsAttVo(String inTime, String outTime, String early, String earlyWhy) {
		this.inTime = inTime;
		this.outTime = outTime;
		this.early = early;
		this.earlyWhy = earlyWhy;
	}

	public String getInTime() {
		return inTime;
	}

	public String getOutTime() {
		return outTime;
	}

	public String getEarly() {
		return early;
	}

	public String getEarlyWhy() {
		return earlyWhy;
	}
	
	
}
