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

public class VendoreDaoImpl implements VendorDao {

	@Override
	public Boolean loginVendor(String userName, String password) throws VendorException {

		boolean b = false;

		try (Connection con = DBUtill.provideConnection()) {

			PreparedStatement ps = con.prepareStatement("select * from vendor where vendorName=? AND vendorPassword=?");
			ps.setString(1, userName);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				b = true;
			} else {
				throw new VendorException("Wrong Username or Password...");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return b;
	}

	@Override
	public List<Tender> getAvailableTendersList() throws TendorException {

		List<Tender> currentTender = new ArrayList<>();

		try (Connection con = DBUtill.provideConnection()) {

			PreparedStatement ps = con.prepareStatement("select * from tender where status = 'Not_Assigned'");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				currentTender.add(new Tender(rs.getString("tendorName"), rs.getString("tendorType"),
						rs.getInt("tendorPrice"), rs.getString("tendorDesc"), rs.getString("tendorLocation"),
						rs.getString("tendorDeadline")));
			}

			if (currentTender.size() == 0) {
				throw new TendorException("Tendor not found....");
			}

		} catch (SQLException e) {
			e.getMessage();
		}

		return currentTender;
	}

	@Override
	public List<Bidder> vendorBidHistory(int vid) throws BidderException {

		List<Bidder> bids = new ArrayList<>();

		try (Connection con = DBUtill.provideConnection()) {

			PreparedStatement ps = con.prepareStatement("select * from bidder where vid=?");
			ps.setInt(1, vid);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				bids.add(new Bidder(rs.getInt("vendorId"), rs.getInt("tendorId"), rs.getInt("bidamount"),
						rs.getString("status"), rs.getString("Bidderdeadline")));

			}

			if (bids.size() == 0) {
				throw new BidderException("No Tender for Bidding");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return bids;
	}

	@Override
	public String statusOfBid(int bid) throws BidderException {

		String str = "No bids present";

		try (Connection con = DBUtill.provideConnection()) {

			PreparedStatement ps = con.prepareStatement("select status from bidder where bid=?");
			
			ps.setInt(1, bid);
			
			ResultSet rs =  ps.executeQuery();
			if (rs.next()) {
				 str = rs.getString("status");
			} else {
				throw new BidderException("Tendor not found");
			}

		} catch (SQLException e) {
			e.getMessage();
		}

		return str;
	}

}
