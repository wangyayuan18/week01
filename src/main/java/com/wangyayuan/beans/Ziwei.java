package com.wangyayuan.beans;

public class Ziwei {

	private Integer cid;
	private String cname;
	public Ziwei() {
		super();
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "Ziwei [cid=" + cid + ", cname=" + cname + "]";
	}
	
}
