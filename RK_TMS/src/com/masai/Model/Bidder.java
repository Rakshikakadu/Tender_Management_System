package com.masai.Model;

public class Bidder {

	private int bidderId;
	private int vendorId;
	private int tendorId;
	private int bidAmount;
	private String bidderDeadline;
	private String status;

	public Bidder() {
		// TODO Auto-generated constructor stub
	}

	public Bidder(int vendorId, int tendorId, int bidAmount, String bidderDeadline, String status) {
		super();

		this.vendorId = vendorId;
		this.tendorId = tendorId;
		this.bidAmount = bidAmount;
		this.bidderDeadline = bidderDeadline;
		this.status = status;
	}

	public Bidder(int bidderId, int vendorId, int tendorId, int bidAmount, String bidderDeadline, String status) {
		super();
		this.bidderId = bidderId;
		this.vendorId = vendorId;
		this.tendorId = tendorId;
		this.bidAmount = bidAmount;
		this.bidderDeadline = bidderDeadline;
		this.status = status;
	}

	public int getBidderId() {
		return bidderId;
	}

	public void setBidderId(int bidderId) {
		this.bidderId = bidderId;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public int getTendorId() {
		return tendorId;
	}

	public void setTendorId(int tendorId) {
		this.tendorId = tendorId;
	}

	public int getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(int bidAmount) {
		this.bidAmount = bidAmount;
	}

	public String getBidderDeadline() {
		return bidderDeadline;
	}

	public void setBidderDeadline(String bidderDeadline) {
		this.bidderDeadline = bidderDeadline;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Bidder [bidderId=" + bidderId + ", vendorId=" + vendorId + ", tendorId=" + tendorId + ", bidAmount="
				+ bidAmount + ", bidderDeadline=" + bidderDeadline + ", status=" + status + "]";
	}

}
