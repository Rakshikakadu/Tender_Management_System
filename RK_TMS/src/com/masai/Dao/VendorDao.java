package com.masai.Dao;

import java.util.List;

import com.masai.Exception.BidderException;
import com.masai.Exception.TendorException;
import com.masai.Exception.VendorException;
import com.masai.Model.Bidder;
import com.masai.Model.Tender;
import com.masai.Model.Vendor;

public interface VendorDao {
	
		public Boolean loginVendor(String userName,String password)throws VendorException;
		
		
		public List<Tender> getAvailableTendersList()throws TendorException;
		
		public String statusOfBid(int bid) throws BidderException;
		
		
		public List<Bidder> vendorBidHistory(int vid)throws BidderException;
	
}
