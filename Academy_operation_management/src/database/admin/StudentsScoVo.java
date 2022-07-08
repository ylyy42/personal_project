package database.admin;

public class StudentsScoVo {
	private String edate;
	private String ename;
	private String escore;

	public StudentsScoVo(String edate, String ename, String escore) {
		this.edate = edate;
		this.ename = ename;
		this.escore = escore;
	}

	public String getEdate() {
		return edate;
	}

	public String getEname() {
		return ename;
	}

	public String getEscore() {
		return escore;
	}
	
}
