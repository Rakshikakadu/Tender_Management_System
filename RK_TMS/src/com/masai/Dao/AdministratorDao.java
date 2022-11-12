package com.masai.Dao;

import java.util.List;

import com.masai.Exception.AdminException;
import com.masai.Exception.BidderException;
import com.masai.Exception.TendorException;
import com.masai.Exception.VendorException;
import com.masai.Model.Bidder;
import com.masai.Model.Tender;
import com.masai.Model.Vendor;

public interface AdministratorDao {
	
	public boolean adminLogin(String adminUserName, String adminPassword) throws AdminException;
	
	public String registerVendorDetails(Vendor vendor)throws VendorException;
	
	public List<Vendor> getAllVendorsDetails()throws VendorException;
	
	public String addNewTenders(Tender tender)throws TendorException;
	
	public List<Tender> getAllTenderDetails()throws TendorException;
	
	public List<Bidder> getAllBids()throws BidderException;
	
	public List<Bidder> getAllBidsOfTender(int tenderId)throws BidderException;
	
	public String assignTendorToVendor(int tendorId,int vendorId,int bidderId)throws TendorException , VendorException, BidderException;
}
