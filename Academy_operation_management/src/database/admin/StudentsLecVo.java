package database.admin;

public class StudentsLecVo {
	private String lecName;
	private String startDate;
	private String giveDate;
	private String giving;
	private String ing;
	
	StudentsLecVo(String lecName, String startDate, String giveDate, String giving, String ing) {
		this.lecName = lecName;
		this.startDate = startDate;
		this.giveDate = giveDate;
		this.giving = giving;
		this.ing = ing;
	}

	public String getLecName() {
		return lecName;
	}

	public String getStartDate() {
		return startDate;
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
	
}
