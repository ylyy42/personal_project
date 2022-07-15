package database.admin;

public class StudentsScoVo {
	private String edate;
	private String ename;
	private String escore;
	private String scode;
	
	public StudentsScoVo(String edate, String ename, String escore) {
		this.edate = edate;
		this.ename = ename;
		this.escore = escore;
	}

	public StudentsScoVo(String edate, String ename, String escore, String scode) {
		this.edate = edate;
		this.ename = ename;
		this.escore = escore;
		this.scode = scode;
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
	
	public String getScode() {
		return scode;
	}
	
}
