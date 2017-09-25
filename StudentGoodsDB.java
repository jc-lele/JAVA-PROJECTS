package vcampus.database.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vcampus.database.classtype.Goods;
import vcampus.database.classtype.StudentGoods;

public class StudentGoodsDB {
	private static Connection conn = null;
	private PreparedStatement prestmt = null;
	private ResultSet res = null;
	
	/**
	 * 
	 * 打印出个人购物车
	 * 
	 * @param sID
	 * @param goodscar
	 * @param valuecar
	 */
	public void print_person_goods(String sID,String goodscar[],String valuecar[]) {
		
		conn = DBConnection.getCon();
		String sql = " SELECT * FROM StudentGoods WHERE sID=? ";
		
		int i = 0;
		int j = 0;
		
		try {
			
			prestmt = conn.prepareStatement(sql);
			prestmt.setString(1, sID);
			
			res = prestmt.executeQuery();
			
			while( res.next() ) {
				
				goodscar[i] = res.getString("productName");
				valuecar[j] = res.getString("value");
				
				i++;
				j++;
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 
	 * 根据sID和goodsID确定sg
	 * @param sID
	 * @param goodsID
	 * @return
	 */
	public StudentGoods selectSG(String sID,String goodsID) {
		
		StudentGoods sg = new StudentGoods();
		String sql = " SELECT * FROM StudentGoods WHERE( sID=? AND goodsID=? ) ";
		conn = DBConnection.getCon();
		
		try {
			
			prestmt = conn.prepareStatement(sql);
			prestmt.setString(1, sID);
			prestmt.setString(2, goodsID);
			
			res = prestmt.executeQuery();
			
			if(res.next()) {
				
				sg.setsID(sID);
				sg.setGoodsID(goodsID);
				sg.setProductName(res.getString("productName"));
				sg.setValue(res.getString("value"));
				
			}else sg = null;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return sg;
		
	}
	
	
	
	public void addGoods(String sID,Goods goods) {
		String sql = " INSERT INTO StudentGoods(sID,goodsID,productName,value) VALUES(?,?,?,?) ";
		
		conn = DBConnection.getCon();
		
		try {
			
			prestmt = conn.prepareStatement(sql);
			prestmt.setString(1,sID);
			prestmt.setString(2, goods.getGoodsID());
			prestmt.setString(3, goods.getProductName());
			prestmt.setString(4, goods.getValue());
			
			prestmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteGoods(StudentGoods sg) {
		String sql = " DELETE FROM StudentGoods WHERE( sID=? AND goodsID=? ) ";
		conn = DBConnection.getCon();
		
		try {
			prestmt = conn.prepareStatement(sql);
			prestmt.setString(1, sg.getsID());
			prestmt.setString(2, sg.getGoodsID());
			
			prestmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
