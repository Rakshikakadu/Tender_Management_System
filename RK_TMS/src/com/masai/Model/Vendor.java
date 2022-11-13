package com.masai.Model;

public class Vendor {

	private int vid;
	private String password;
	private String vname;
	private String vmob;
	private String vemail;
	private String company;
	private String address;

	public Vendor() {
		// TODO Auto-generated constructor stub
	}

	public Vendor(String password, String vname, String vmob, String vemail, String company, String address) {
		super();

		this.password = password;
		this.vname = vname;
		this.vmob = vmob;
		this.vemail = vemail;
		this.company = company;
		this.address = address;
	}

	public Vendor(int vid, String password, String vname, String vmob, String vemail, String company, String address) {
		super();
		this.vid = vid;
		this.password = password;
		this.vname = vname;
		this.vmob = vmob;
		this.vemail = vemail;
		this.company = company;
		this.address = address;
	}

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public String getVmob() {
		return vmob;
	}

	public void setVmob(String vmob) {
		this.vmob = vmob;
	}

	public String getVemail() {
		return vemail;
	}

	public void setVemail(String vemail) {
		this.vemail = vemail;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Vendor === vid=" + vid + ", password=" + password + ", vname=" + vname + ", vmob=" + vmob + ", vemail="
				+ vemail + ", company=" + company + ", address=" + address ;
	}

}
