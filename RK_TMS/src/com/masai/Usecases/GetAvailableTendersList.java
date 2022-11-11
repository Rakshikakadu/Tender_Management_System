package com.masai.Usecases;

import java.util.List;

import com.masai.Dao.VendorDao;
import com.masai.Dao.VendoreDaoImpl;
import com.masai.Model.Tender;

public class GetAvailableTendersList {

	public static void main(String[] args) {
		
		VendorDao vendor = new VendoreDaoImpl();
		
		try {
			
			List<Tender> tendors =	vendor.getAvailableTendersList();
			tendors.forEach( t -> System.out.println(t));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
