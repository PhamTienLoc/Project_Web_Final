package model;

import java.sql.Date;
import java.util.List;

public class Blog {
	private int id;
	private int authorId;
	private String title;
	private String description;
	private String thumbnail;
	private String contentPath;
	private Date createdAt;
	private boolean status;
	private List<BlogImage> images;

	public Blog() {
	}

	public Blog(int id, int authorId, String title, String description, String thumbnail, String contentPath,
			Date createdAt, boolean status, List<BlogImage> images) {
		this.id = id;
		this.authorId = authorId;
		this.title = title;
		this.description = description;
		this.thumbnail = thumbnail;
		this.contentPath = contentPath;
		this.createdAt = createdAt;
		this.status = status;
		this.images = images;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
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

	@Override
	public String toString() {
		return "Blog [id=" + id + ", authorId=" + authorId + ", title=" + title + ", description=" + description
				+ ", thumbnail=" + thumbnail + ", contentPath=" + contentPath + ", createdAt=" + createdAt + ", status="
				+ status + ", images=" + images + "]";
	}

}
