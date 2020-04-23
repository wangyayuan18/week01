package com.wangyayuan.beans;

public class Hero {

	private Integer  yid;
	private String  yname;
	private Double yjg;
	private Integer yis;
	private String ytp;//ͼƬ
	private Integer cid;
	private String cname;
	public Hero() {
		super();
	}
	public Integer getYid() {
		return yid;
	}
	public void setYid(Integer yid) {
		this.yid = yid;
	}
	public String getYname() {
		return yname;
	}
	public void setYname(String yname) {
		this.yname = yname;
	}
	public Double getYjg() {
		return yjg;
	}
	public void setYjg(Double yjg) {
		this.yjg = yjg;
	}
	public Integer getYis() {
		return yis;
	}
	public void setYis(Integer yis) {
		this.yis = yis;
	}
	public String getYtp() {
		return ytp;
	}
	public void setYtp(String ytp) {
		this.ytp = ytp;
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
		return "Hero [yid=" + yid + ", yname=" + yname + ", yjg=" + yjg + ", yis=" + yis + ", ytp=" + ytp + ", cid="
				+ cid + ", cname=" + cname + "]";
	}
	
	
	
}
