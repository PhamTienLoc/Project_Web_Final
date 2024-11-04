package model;

import java.util.Date;

public class Product {
	private int id;
	private String title;
	private double price;
	private int discount;
	private int warranty;
	private int inventoryNumber;
	private String description;
	private String thumbnail;
	private Date createdAt;
	private Date updatedAt;
	private int cid;

	public Product() {
		super();
	}

	public Product(int id, String title, double price, int discount, int inventoryNumber, String description,
			String thumbnail, int cid) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.discount = discount;
		this.inventoryNumber = inventoryNumber;
		this.description = description;
		this.thumbnail = thumbnail;
		this.cid = cid;
	}

	public Product(int id, String title, double price, String description, String thumbnail) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.description = description;
		this.thumbnail = thumbnail;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getWarranty() {
		return warranty;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}

	public int getInventoryNumber() {
		return inventoryNumber;
	}

	public void setInventoryNumber(int inventoryNumber) {
		this.inventoryNumber = inventoryNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
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

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", price=" + price + ", discount=" + discount
				+ ", inventoryNumber=" + inventoryNumber + ", description=" + description + ", thumbnail=" + thumbnail
				+ ", cid=" + cid + "]";
	}

}
