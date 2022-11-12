package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.Exception.AdminException;
import com.masai.Exception.BidderException;
import com.masai.Exception.TendorException;
import com.masai.Exception.VendorException;
import com.masai.Model.Bidder;
import com.masai.Model.Tender;
import com.masai.Model.Vendor;
import com.masai.Utility.DBUtill;

public class AdministratorDaoImpl implements AdministratorDao {

	@Override
	public boolean adminLogin(String adminUserName, String adminPassword) throws AdminException {

		boolean b = false;

		try (Connection con = DBUtill.provideConnection()) {

			PreparedStatement ps = con
					.prepareStatement("select * from administrator where adminUserName=? AND adminPassword=?");
			ps.setString(1, adminUserName);
			ps.setString(2, adminPassword);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				b = true;
			} else {
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

		try (Connection con = DBUtill.provideConnection()) {

			PreparedStatement ps = con.prepareStatement(
					"insert into vendor(vendorPassword,vendorName,vendorMob,vendorEmail,vendorCompany,vendorAddress) values(?,?,?,?,?,?)");

			ps.setString(1, vendor.getPassword());
			ps.setString(2, vendor.getVname());
			ps.setString(3, vendor.getVmob());
			ps.setString(4, vendor.getVemail());
			ps.setString(5, vendor.getCompany());
			ps.setString(6, vendor.getAddress());

			int x = ps.executeUpdate();

			if (x > 0) {
				str = "Inserted sucessfully...";
			} else {
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

		try (Connection con = DBUtill.provideConnection()) {

			PreparedStatement ps = con.prepareStatement("select * from vendor");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				vendors.add(new Vendor(rs.getString("vendorPassword"), rs.getString("vendorName"),
						rs.getString("vendorMob"), rs.getString("vendorEmail"), rs.getString("vendorCompany"),
						rs.getString("vendorAddress")));
			}

			if (vendors.size() == 0) {
				throw new VendorException("Vendor list is empty!....");
			}

		} catch (SQLException e) {
			e.getMessage();
		}

		return vendors;
	}

	@Override
	public String addNewTenders(Tender tender) throws TendorException {

		String str = "Tender details is not inserted";

		try (Connection con = DBUtill.provideConnection()) {

			PreparedStatement ps = con.prepareStatement(
					"insert into tender(tendorName,tendorType,tendorPrice,tendorDesc,tendorLocation,tendorDeadline) values(?,?,?,?,?,?)");

			ps.setString(1, tender.getTname());
			ps.setString(2, tender.getTtype());
			ps.setInt(3, tender.getTprice());
			ps.setString(4, tender.getTdesc());
			ps.setString(5, tender.getTloc());
			ps.setString(6, tender.getTdeadline());
			int x = ps.executeUpdate();

			if (x > 0) {
				str = "Tender details is inserted";
			} else {
				throw new TendorException("Tendor not found");
			}

		} catch (SQLException e) {
			e.getMessage();
		}

		return str;
	}

	@Override
	public List<Tender> getAllTenderDetails() throws TendorException {
		List<Tender> tendors = new ArrayList<>();

		try (Connection con = DBUtill.provideConnection()) {

			PreparedStatement ps = con.prepareStatement("select * from tender");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				tendors.add(new Tender(rs.getInt("tendorId"),rs.getString("tendorName"), rs.getString("tendorType"), rs.getInt("tendorPrice"),
						rs.getString("tendorDesc"), rs.getString("tendorLocation"), rs.getString("tendorDeadline")));
			}

			if (tendors.size() == 0) {
				throw new TendorException("Tendor list is empty!....");
			}

		} catch (SQLException e) {
			e.getMessage();
		}

		return tendors;
	}

	@Override
	public List<Bidder> getAllBidsOfTender(int tenderId) throws BidderException {

		List<Bidder> bidders = new ArrayList<>();

		try (Connection con = DBUtill.provideConnection()) {

			PreparedStatement ps = con.prepareStatement("select b from bidder b inner join tender t ON b.tendorId=t.tendorId where t.tendorId=?");
			ps.setInt(1,tenderId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				bidders.add(new Bidder(rs.getInt("vendorId"),rs.getInt("tendorId"),rs.getInt("bidamount"),rs.getString("status"),rs.getString("Bidderdeadline")));
			}

			if (bidders.size() == 0) {
				throw new BidderException("Tendor id with bidderid is mismatched...");
			}

		} catch (SQLException e) {
			e.getMessage();
		}

		return bidders;
	}

	@Override
	public String assignTendorToVendor(int tendorId, int vendorId,int bidderId) throws TendorException, VendorException,BidderException {
		
		
		String str="";
		try (Connection con = DBUtill.provideConnection()){
			
			PreparedStatement ps =  con.prepareStatement("select * from tenderstatus where tsTendorId=? AND tsVendorId=?");
			ps.setInt(1, tendorId);
			ps.setInt(2, vendorId);	
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				 str = "Assigned already...";
			}else {
				PreparedStatement ps1 =  con.prepareStatement("insert into tenderstatus(status,tsTendorId,tsBidderId,tsVendorId) values('Selected',?,?,?)");
				ps1.setInt(1, tendorId);
				ps1.setInt(2, bidderId);
				ps1.setInt(2, vendorId);
				
				int x = ps.executeUpdate();
				
				if(x>0) {
					
					
					PreparedStatement ps2 =  con.prepareStatement("update tender set status = 'Assigned' where tendorId=tendorId");
					
					int x2 = ps.executeUpdate();
					
					if(x2>0) {
						str = "Assigned tendor "+tendorId+" to a vendor "+vendorId+"...";
						PreparedStatement ps3 =  con.prepareStatement("update bidder set status = 'Selected' where tendorId=tendorId And bidderId=bidderId AND vendorId=vendorId");
						
						int x3 = ps.executeUpdate();
						
					}	
					
				}else {
					throw new TendorException("Tendor is not available");
					
				}
				
			}
			
		} catch (SQLException e) {
			e.getMessage();
			throw new VendorException("Vendor is not available");
		}
		
		return str;
	}

	@Override
	public List<Bidder> getAllBids() throws BidderException {
		List<Bidder> bidders = new ArrayList<>();

		try (Connection con = DBUtill.provideConnection()) {

			PreparedStatement ps = con.prepareStatement("select * from bidder");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				bidders.add(new Bidder(rs.getInt("bidderId"),rs.getInt("vendorId"), rs.getInt("tendorId"), rs.getInt("bidamount"), rs.getString("status"), rs.getString("Bidderdeadline")));
			}

			if (bidders.size() == 0) {
				throw new BidderException("Bidder list is empty!....");
			}

		} catch (SQLException e) {
			e.getMessage();
		}

		return bidders;
	}

}
