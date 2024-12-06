package model;

import java.sql.Date;
import java.util.List;

public class Blog {
	private int id;
	private String author;
	private String title;
	private String description;
	private String thumbnail;
	private String contentPath;
	private Date createdAt;
	private Date updatedAt;
	private boolean status;
	private List<BlogImage> images;
	private int readTime;

	public Blog() {
	}

	public Blog(int id, String author, String title, String description, String thumbnail, String contentPath,
			Date createdAt, Date updatedAt, boolean status, List<BlogImage> images, int readTime) {
		this.id = id;
		this.author = author;
		this.title = title;
		this.description = description;
		this.thumbnail = thumbnail;
		this.contentPath = contentPath;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.status = status;
		this.images = images;
		this.readTime = readTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getContentPath() {
		return contentPath;
	}

	public void setContentPath(String contentPath) {
		this.contentPath = contentPath;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<BlogImage> getImages() {
		return images;
	}

	public void setImages(List<BlogImage> images) {
		this.images = images;
	}

	public int getReadTime() {
		return readTime;
	}

	public void setReadTime(int readTime) {
		this.readTime = readTime;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", author=" + author + ", title=" + title + ", description=" + description
				+ ", thumbnail=" + thumbnail + ", contentPath=" + contentPath + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", status=" + status + ", images=" + images + ", readTime=" + readTime
				+ "]";
	}

}
