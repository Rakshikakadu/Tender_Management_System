package com.masai.Model;

import java.sql.Date;
import java.time.LocalDate;

public class Tender {
	
	private int tid;
	private String tname;
	private String ttype;
	private int tprice;
	private String tdesc;
	private String tdeadline;
	private String tloc;
	
	public Tender() {
		// TODO Auto-generated constructor stub
	}

	public Tender( String tname, String ttype, int tprice, String tdesc, String tdeadline, String tloc) {
		super();
		
		this.tname = tname;
		this.ttype = ttype;
		this.tprice = tprice;
		this.tdesc = tdesc;
		this.tdeadline = tdeadline;
		this.tloc = tloc;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTtype() {
		return ttype;
	}

	public void setTtype(String ttype) {
		this.ttype = ttype;
	}

	public int getTprice() {
		return tprice;
	}

	public void setTprice(int tprice) {
		this.tprice = tprice;
	}

	public String getTdesc() {
		return tdesc;
	}

	public void setTdesc(String tdesc) {
		this.tdesc = tdesc;
	}

	public String getTdeadline() {
		return tdeadline;
	}

	public void setTdeadline(String tdeadline) {
		this.tdeadline = tdeadline;
	}

	public String getTloc() {
		return tloc;
	}

	public void setTloc(String tloc) {
		this.tloc = tloc;
	}

	@Override
	public String toString() {
		return "Tender [tid=" + tid + ", tname=" + tname + ", ttype=" + ttype + ", tprice=" + tprice + ", tdesc="
				+ tdesc + ", tdeadline=" + tdeadline + ", tloc=" + tloc + "]";
	}
	
	
	
}
