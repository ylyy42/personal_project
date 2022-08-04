package database.admin;

public class TeacherVo {

	private String code;
	private String name;
	private String residentId;
	private String phone;
	private String email;
	private String year;
	private String sal;
	private String major;
	private String address;
	private String accountNumber;
	private String lName;
	private String ls;
	private String members;
	
	public TeacherVo(String lName, String ls, String members) {
		this.lName = lName;
		this.ls = ls;
		this.members = members;
	}
	
	public TeacherVo(String code, String name, String residentId, String phone,
			String email, String year, String sal, String major, String address, String accountNumber) {
			
		this.code = code;
		this.name = name;
		this.residentId = residentId;
		this.phone = phone;
		this.email = email;
		this.year = year;
		this.sal = sal;
		this.major = major;
		this.address = address;
		this.accountNumber = accountNumber;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getResidentId() {
		return residentId;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getYear() {
		return year;
	}

	public String getSal() {
		return sal;
	}

	public String getMajor() {
		return major;
	}

	public String getAddress() {
		return address;
	}

	public String getAccountNumber() {
		return accountNumber;
	}
	
	public String getlName() {
		return lName;
	}

	public String getLs() {
		return ls;
	}

	public String getMembers() {
		return members;
	}

	
}
