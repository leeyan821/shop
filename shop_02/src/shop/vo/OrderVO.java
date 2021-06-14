package shop.vo;

public class OrderVO {
	private String id;
	private String mid;
	private int count;
	private String odate;
	private String address;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getOdate() {
		return odate;
	}
	public void setOdate(String odate) {
		this.odate = odate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
