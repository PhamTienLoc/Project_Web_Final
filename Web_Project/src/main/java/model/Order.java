package model;

import java.util.Date;

public class Order {
	private int id;
	private int userId;
	private String fullName;
	private String email;
	private String phoneNumber;
	private String address;
	private String note;
	private Date orderDate;
	private String status;
	private double totalMoney;
	private String paymentMethod;

	public Order() {
		super();
	}

	public Order(int id, int userId, String fullName, String email, String phoneNumber, String address, String note,
			Date orderDate, String status, double totalMoney, String paymentMethod) {
		super();
		this.id = id;
		this.userId = userId;
		this.fullName = fullName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.note = note;
		this.orderDate = orderDate;
		this.status = status;
		this.totalMoney = totalMoney;
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Order(int userId, String fullName, String email, String phoneNumber, String address, String note,
			double totalMoney, String paymentMethod) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.note = note;
		this.totalMoney = totalMoney;
		this.paymentMethod = paymentMethod;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}

}
