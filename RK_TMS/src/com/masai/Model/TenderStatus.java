package com.masai.Model;

public class TenderStatus {
	
	private int tsTendorId;
	private int tsBidderId;
	private String status;
	private int tsVendorId;
	
	public TenderStatus() {
		// TODO Auto-generated constructor stub
	}

	public TenderStatus(int tsTendorId, int tsBidderId, String status, int tsVendorId) {
		super();
		this.tsTendorId = tsTendorId;
		this.tsBidderId = tsBidderId;
		this.status = status;
		this.tsVendorId = tsVendorId;
	}
	
	
	
	
	public int getTsTendorId() {
		return tsTendorId;
	}

	public void setTsTendorId(int tsTendorId) {
		this.tsTendorId = tsTendorId;
	}

	public int getTsBidderId() {
		return tsBidderId;
	}

	public void setTsBidderId(int tsBidderId) {
		this.tsBidderId = tsBidderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTsVendorId() {
		return tsVendorId;
	}

	public void setTsVendorId(int tsVendorId) {
		this.tsVendorId = tsVendorId;
	}

	@Override
	public String toString() {
		return "TenderStatus === tsTendorId=" + tsTendorId + ", tsBidderId=" + tsBidderId + ", status=" + status
				+ ", tsVendorId=" + tsVendorId ;
	}
	
	
	
}
