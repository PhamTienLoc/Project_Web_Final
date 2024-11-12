package model;

public class Category {
	private int cid;
	private String cname;
	private String thumb;

	public Category() {
		super();
	}

	public Category(int cid, String cname, String thumb) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.thumb = thumb;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + "]";
	}

}
