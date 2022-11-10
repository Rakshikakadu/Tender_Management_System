package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.Exception.AdminException;
import com.masai.Exception.VendorException;
import com.masai.Model.Vendor;
import com.masai.Utility.DBUtill;

public class AdministratorDaoImpl implements AdministratorDao{


	@Override
	public boolean adminLogin(String adminUserName, String adminPassword) throws AdminException {
		
		boolean b = false;
		
		try(Connection con = DBUtill.provideConnection()) {
			
			PreparedStatement ps =  con.prepareStatement("select * from administrator where adminUserName=? AND adminPassword=?");
			ps.setString(1, adminUserName);
			ps.setString(2, adminPassword);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				b = true;
			}else {
				throw new AdminException("Wrong Username or Password...");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return b;
	}

	@Override
	public String registerVendorDetails(Vendor vendor) throws VendorException {
		
		String str = "Not inserted";
		
		try(Connection con = DBUtill.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("insert into vendor(vendorPassword,vendorName,vendorMob,vendorEmail,vendorCompany,vendorAddress) values(?,?,?,?,?,?)");
			
			ps.setString(1, vendor.getPassword());
			ps.setString(2, vendor.getVname());
			ps.setString(3, vendor.getVmob());
			ps.setString(4, vendor.getVemail());
			ps.setString(5, vendor.getCompany());
			ps.setString(6, vendor.getAddress());
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				str = "Inserted sucessfully...";
			}else {
				throw new VendorException("Vendor registration fail...");
			}
			
		} catch (SQLException e) {
			e.getMessage();
		}
		
		
		return str;
	}

	@Override
	public List<Vendor> getAllVendorsDetails() throws VendorException {
		
		List<Vendor> vendors = new ArrayList<>();
		
		try (Connection con = DBUtill.provideConnection()){
			
			PreparedStatement ps =  con.prepareStatement("select * from vendor");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				vendors.add(new Vendor(rs.getString("vendorPassword"),rs.getString("vendorName"), rs.getString("vendorMob"),rs.getString("vendorEmail"),rs.getString("vendorCompany"),rs.getString("vendorAddress")));
			}
			
			if(vendors.size()==0) {
				throw new VendorException("Vendor list is empty");
			}
			
		} catch (SQLException e) {
			e.getMessage();
		}
		
		return vendors;
	}

	

}
