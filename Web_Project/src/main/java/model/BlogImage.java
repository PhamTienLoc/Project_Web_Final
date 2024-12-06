package model;

public class BlogImage {
	private int id;
	private int blogId;
	private String imagePath;
	private String caption;
	private int imageOrder;

	public BlogImage() {
	}

	public BlogImage(int id, int blogId, String imagePath, String caption, int imageOrder) {
		this.id = id;
		this.blogId = blogId;
		this.imagePath = imagePath;
		this.caption = caption;
		this.imageOrder = imageOrder;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public int getImageOrder() {
		return imageOrder;
	}

	public void setImageOrder(int imageOrder) {
		this.imageOrder = imageOrder;
	}

	@Override
	public String toString() {
		return "BlogImage [id=" + id + ", blogId=" + blogId + ", imagePath=" + imagePath + ", caption=" + caption
				+ ", imageOrder=" + imageOrder + "]";
	}

}
