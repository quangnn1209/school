package org.school.persisted;

public class User implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private String password;
	private int role;
	private String code;
	private String email;

	public User() {
	}

	public User(String password, String email) {
		super();
		this.password = password;
		this.email = email;
	}

	public User(long id) {
		super();
		this.id = id;
	}

	public User(String name, String password, int role, String code, String email) {
		super();
		this.name = name;
		this.password = password;
		this.role = role;
		this.code = code;
		this.email = email;
	}

	public User(long id, String name, int role, String code, String email) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.code = code;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}