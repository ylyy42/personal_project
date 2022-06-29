package awt;

public class JoinVo {
	private String name;
	private String id;
	private String password;
	private String residentId;
	private String phone;
	private String email;
	private String gender;

	public JoinVo() {

	}

	public JoinVo(String name, String id, String password, String residentId, String phone, String email,
			String gender) {
		this.name = name;
		this.id = id;
		this.password = password;
		this.residentId = residentId;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
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

	public String getGender() {
		return gender;
	}

}
