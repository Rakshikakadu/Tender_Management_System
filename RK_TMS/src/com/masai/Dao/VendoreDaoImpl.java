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
	public Vendor loginVendor(String userName, String password) throws VendorException {

		Vendor v = null;

		try (Connection con = DBUtill.provideConnection()) {

			PreparedStatement ps = con.prepareStatement("select * from vendor where vendorName=? AND vendorPassword=?");
			ps.setString(1, userName);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				v = new Vendor(rs.getInt("vendorId"), rs.getString("vendorPassword"), rs.getString("vendorName"),
						rs.getString("vendorMob"), rs.getString("vendorEmail"), rs.getString("vendorCompany"),
						rs.getString("vendorAddress"));
			} else {
				throw new VendorException("Wrong Username or Password...");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return v;
	}

	@Override
	public List<Tender> getAvailableTendersList() throws TendorException {

		List<Tender> currentTender = new ArrayList<>();

		try (Connection con = DBUtill.provideConnection()) {

			PreparedStatement ps = con.prepareStatement("select * from tender where status = 'Not_Assigned'");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				currentTender.add(new Tender(rs.getInt("tendorId"), rs.getString("tendorName"),
						rs.getString("tendorType"), rs.getInt("tendorPrice"), rs.getString("tendorDesc"),
						rs.getString("tendorLocation"), rs.getString("tendorDeadline")));
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
	public String bidAgainstaTender(int tid, int vid, int bidAmt, String biddeadline)
			throws BidderException, TendorException {

		String str = "Something went wrong....";
		int price;
		try (Connection con = DBUtill.provideConnection()) {

			List<Bidder> bidders = new ArrayList<>();

			PreparedStatement ps = con.prepareStatement(
					"select b.tendorId,b.vendorId,b.bidamount,b.status,b.Bidderdeadline from bidder b inner join tender t ON b.tendorId=t.tendorId where t.tendorId=?");
			ps.setInt(1, tid);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				bidders.add(new Bidder(rs.getInt("vendorId"), rs.getInt("tendorId"), rs.getInt("bidamount"),
						rs.getString("Bidderdeadline"), rs.getString("status")));
			}

			boolean flag = true;
			for (Bidder b : bidders) {
				if (b.getVendorId() == vid) {
					flag = false;
				}
			}

			PreparedStatement ps2 = con.prepareStatement("select tendorPrice from tender where tendorId=?");
			ps2.setInt(1, tid);

			ResultSet rs2 = ps2.executeQuery();
			
			if (rs2.next()) {
				price = rs2.getInt("tendorPrice");
				
			}
			else
				throw new TendorException("Tendor not found for price....");

			if (price <= bidAmt) {

				if (bidders.size() == 0 || flag) {

					PreparedStatement ps1 = con.prepareStatement(
							"insert into bidder(vendorId,tendorId,bidamount,Bidderdeadline) values(?,?,?,?)");
					ps1.setInt(1, vid);
					ps1.setInt(2, tid);
					ps1.setInt(3, bidAmt);
					ps1.setString(4, biddeadline);

					int x = ps1.executeUpdate();
					if (x > 0) {
						
						PreparedStatement ps3 = con
								.prepareStatement("select * from bidder where vendorId=? AND tendorId=?");
						ps3.setInt(1, vid);
						ps3.setInt(2, tid);
						
						ResultSet rs3 = ps3.executeQuery();
						
						if (rs3.next()) {
							
							 Bidder b = new Bidder(rs3.getInt("bidderId"), rs3.getInt("vendorId"), rs3.getInt("tendorId"),
									rs3.getInt("bidamount"), rs3.getString("Bidderdeadline"), rs3.getString("status"));
							str = "Successfully bid for " + b.toString();
						} else {
							throw new BidderException("Bid not placed successfully...");
						}

						
					} else {
						throw new BidderException("Tendor not found");
					}

				} else {
					throw new BidderException(
							"You have already bidded for tender id : " + tid + " With respect to " + vid);
				}
			} else {
				throw new BidderException(
						"Bidding Price is too low for bidding it must be greater than price -- " + price);
			}

		} catch (SQLException e) {
			e.getMessage();
		}

		return str;
	}

	@Override
	public List<Bidder> vendorBidHistory(int vid) throws BidderException {

		List<Bidder> bids = new ArrayList<>();

		try (Connection con = DBUtill.provideConnection()) {

			PreparedStatement ps = con.prepareStatement("select * from bidder where vendorId=?");
			ps.setInt(1, vid);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				bids.add(new Bidder(rs.getInt("bidderId"), rs.getInt("vendorId"), rs.getInt("tendorId"),
						rs.getInt("bidamount"), rs.getString("status"), rs.getString("Bidderdeadline")));

			}

			if (bids.size() == 0) {
				throw new BidderException("No Tender for Bidding");
			}
		} catch (SQLException e) {
			e.getMessage();
		}

		return bids;
	}

	@Override
	public String statusOfBid(int bid) throws BidderException {

		String str = "No bids present";

		try (Connection con = DBUtill.provideConnection()) {

			PreparedStatement ps = con.prepareStatement("select status from bidder where bidderId=?");

			ps.setInt(1, bid);

			ResultSet rs = ps.executeQuery();
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
