package com.masai.Dao;

import java.util.List;

import com.masai.Exception.AdminException;
import com.masai.Exception.VendorException;
import com.masai.Model.Vendor;

public interface AdministratorDao {
	
	public boolean adminLogin(String adminUserName, String adminPassword) throws AdminException;
	
	public String registerVendorDetails(Vendor vendor)throws VendorException;
	
	public List<Vendor> getAllVendorsDetails()throws VendorException;
	
	
}
