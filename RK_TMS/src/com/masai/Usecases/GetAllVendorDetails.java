package com.masai.Usecases;

import java.util.List;

import com.masai.Dao.AdministratorDao;
import com.masai.Dao.AdministratorDaoImpl;
import com.masai.Model.Vendor;

public class GetAllVendorDetails {

	public static void main(String[] args) {
		
		AdministratorDao admin = new AdministratorDaoImpl();
		
		try {
			
			List<Vendor> vendors =	admin.getAllVendorsDetails();
			vendors.forEach( v -> System.out.println(v));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
