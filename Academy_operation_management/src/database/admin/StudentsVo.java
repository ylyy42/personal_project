package database.admin;

public class StudentsVo {
	private int code;
	private String name;
	private String residentId;
	private String phone;
	private String email;
	private String school;
	private String grade;
	private String parentsName;
	private String parentsPhone;
	private String address;
	
	public StudentsVo(String name, String school, String grade) {
		this.name = name;
		this.school = school;
		this.grade = grade;
	}

	public StudentsVo(int code, String name, String residentId, String phone, String email, String school,
			String grade, String parentsName, String parentsPhone, String address) {

		this.code = code;
		this.name = name;
		this.residentId =residentId;
		this.phone = phone;
		this.email = email;
		this.school = school;
		this.grade = grade;
		this.parentsName = parentsName;
		this.parentsPhone = parentsPhone;
		this.address = address;
	}

	public int getCode() {
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

	public String getSchool() {
		return school;
	}

	public String getGrade() {
		return grade;
	}

	public String getParentsName() {
		return parentsName;
	}

	public String getParentsPhone() {
		return parentsPhone;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "StudentsVo [code=" + code + ", name=" + name + ", residentId=" + residentId + ", phone=" + phone
				+ ", email=" + email + ", school=" + school + ", grade=" + grade + ", parentsName=" + parentsName
				+ ", parentsPhone=" + parentsPhone + ", address=" + address + "]";
	}
	
	
}
