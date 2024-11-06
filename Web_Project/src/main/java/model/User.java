package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class User {
	private int id;
	private String fullName;
	private String user;
	private String password;
	private boolean gender;
	private Date birthDay;
	private String email;
	private String phoneNumber;
	private String address;
	private Date createdAt;
	private Date updatedAt;
	private int isAdmin;

	public User() {
		super();
	}

	public User(String fullName, String user, String password, boolean gender, Date birthDay, String email,
			String phoneNumber, String address, Date createdAt, Date updatedAt) {
		super();
		this.fullName = fullName;
		this.user = user;
		this.password = password;
		this.gender = gender;
		this.birthDay = birthDay;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public User(int id, String fullName, String user, String password, boolean gender, Date birthDay, String email,
			String phoneNumber, String address, Date createdAt, Date updatedAt, int isAdmin) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.user = user;
		this.password = password;
		this.gender = gender;
		this.birthDay = birthDay;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.isAdmin = isAdmin;
	}

	public User(int id, String fullName, String user, String password, boolean gender, Date birthDay, String email,
			String phoneNumber, String address, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.user = user;
		this.password = password;
		this.gender = gender;
		this.birthDay = birthDay;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fullName=" + fullName + ", user=" + user + ", password=" + password + ", gender="
				+ gender + ", birthDay=" + birthDay + ", email=" + email + ", phoneNumber=" + phoneNumber + ", address="
				+ address + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", isAdmin=" + isAdmin + "]";
	}

}
