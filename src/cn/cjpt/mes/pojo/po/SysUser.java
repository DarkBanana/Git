package cn.cjpt.mes.pojo.po;

public class SysUser {
	private String id;

	private String usercode;

	private String username;

	private String password;

	private String salt;

	private String age;

	private String sex;

	private String locked;

	private String jobnumber;

	private String worktype;

	private String positionaltitles; // 职称

	private String department;

	private String tel;

	private String workstation;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode == null ? null : usercode.trim();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt == null ? null : salt.trim();
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age == null ? null : age.trim();
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	public String getLocked() {
		return locked;
	}

	public void setLocked(String locked) {
		this.locked = locked == null ? null : locked.trim();
	}

	public String getJobnumber() {
		return jobnumber;
	}

	public void setJobnumber(String jobnumber) {
		this.jobnumber = jobnumber == null ? null : jobnumber.trim();
	}

	public String getWorktype() {
		return worktype;
	}

	public void setWorktype(String worktype) {
		this.worktype = worktype == null ? null : worktype.trim();
	}

	public String getPositionaltitles() {
		return positionaltitles;
	}

	public void setPositionaltitles(String positionaltitles) {
		this.positionaltitles = positionaltitles == null ? null
				: positionaltitles.trim();
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department == null ? null : department.trim();
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel == null ? null : tel.trim();
	}

	public String getWorkstation() {
		return workstation;
	}

	public void setWorkstation(String workstation) {
		this.workstation = workstation == null ? null : workstation.trim();
	}
}