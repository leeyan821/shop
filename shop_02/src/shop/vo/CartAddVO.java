package shop.vo;

public class CartAddVO {
	private String id;
	private String pid;
	private String mid;
	private int count;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	} 
}
