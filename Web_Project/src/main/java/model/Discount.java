package model;

import java.util.Date;

public class Discount {
	private int id;
	private String title;
	private double discount;
	private Date startDate;
	private Date endDate;

	public Discount() {
		super();
	}

	public Discount(String title, double discount, Date startDate, Date endDate) {
		super();
		this.title = title;
		this.discount = discount;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Discount(int id, String title, double discount, Date startDate, Date endDate) {
		super();
		this.id = id;
		this.title = title;
		this.discount = discount;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Discount [id=" + id + ", title=" + title + ", discount=" + discount + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
}
