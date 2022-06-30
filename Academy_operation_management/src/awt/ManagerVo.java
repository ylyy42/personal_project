package awt;

public class ManagerVo {
	private int num;
	private String name;
	private String id;
	private String password;
	private String residentId;
	private String phone;
	private String email;

	public ManagerVo(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public ManagerVo(int num, String name, String id, String password, String residentId, String phone, String email) {
		this.num = num;
		this.name = name;
		this.id = id;
		this.password = password;
		this.residentId = residentId;
		this.phone = phone;
		this.email = email;
	}
	
	public int getNum() {
		return num;
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

}
