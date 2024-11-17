package model;

public class Image {
	private int mid;
	private int pid;
	private String image1;
	private String image2;

	public Image(int mid, int pid, String image1, String image2) {
		super();
		this.mid = mid;
		this.pid = pid;
		this.image1 = image1;
		this.image2 = image2;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	@Override
	public String toString() {
		return "Image [mid=" + mid + ", pid=" + pid + ", image1=" + image1 + ", image2=" + image2 + "]";
	}

}
