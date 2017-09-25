package vcampus.database.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vcampus.database.classtype.StudentGrade;
import vcampus.database.classtype.SumCourseScore;


public class StudentGradeDB {
	private static Connection conn = null;
	private PreparedStatement prestmt = null;
	private ResultSet res = null;
	
	public StudentGrade selectSG(String sID) {
		StudentGrade sg = new StudentGrade();
		String sql = "SELECT * FROM StudentGrade WHERE sID=?";
		conn = DBConnection.getCon();
		try {
			prestmt = conn.prepareStatement(sql);
			prestmt.setString(1, sID);
			res = prestmt.executeQuery();
			if(res.next()) {
				sg.setsID(res.getString("sID"));
				sg.setSubject(res.getString("subject"));
				sg.setScore(res.getString("score"));
				sg.setGrade(res.getString("grade"));
				sg.setYear(res.getString("year"));
				
			}else sg = null;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return sg;
	}
	
	public void print_grade(StudentGrade sg,String year,String subject[],String score[],String grade[]) {
		
		conn = DBConnection.getCon();
		String sql = " SELECT * FROM StudentGrade WHERE( sID=? AND year=? ) ";
		
		int i = 0;
		int j = 0;
		int k = 0;
		
		try {
			prestmt = conn.prepareStatement(sql);
			prestmt.setString(1, sg.getsID());
			prestmt.setString(2, year);
			
			res = prestmt.executeQuery();
			
			while(res.next()) {
				
				subject[i] = res.getString("subject");
				score[j] = res.getString("score");
				grade[k] = res.getString("grade");
				
				i++;
				j++;
				k++;
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * 
	 * 获得总的课程数 和 总学分
	 * 
	 * @param scs
	 * @param sID
	 * @param coursenum
	 * @param scorenum
	 */
	
	
	public void sum_course_score(SumCourseScore scs,String sID,int coursenum,int scorenum) {
			
			conn = DBConnection.getCon();
			String sql = " SELECT * FROM StudentGrade WHERE sID=? ";
			
			try {
				prestmt = conn.prepareStatement(sql);
				prestmt.setString(1, sID);
				
				res = prestmt.executeQuery();
				
				int box = 0;
				
				while( res.next() ) {
					
					coursenum++;
					box = Integer.parseInt(res.getString("score"));
					scorenum = scorenum + box;
					
				}
				
				scs.setCoursenum(coursenum);
				scs.setScorenum(scorenum);
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
	
		}
	
	/**
	 * 课表查询功能
	 * 
	 */
//	public void print_grade(StudentGrade sg,String year,String subject[],String score[],String grade[]) {
//		
//		conn = DBConnection.getCon();
//		String sql = " SELECT * FROM StudentGrade WHERE( sID=? AND year=? ) ";
//		
//		int i = 0;
//		int j = 0;
//		int k = 0;
//		
//		try {
//			prestmt = conn.prepareStatement(sql);
//			prestmt.setString(1, sg.getsID());
//			prestmt.setString(2, year);
//			
//			res = prestmt.executeQuery();
//			
//			while(res.next()) {
//				
//				subject[i] = res.getString("subject");
//				score[j] = res.getString("score");
//				grade[k] = res.getString("grade");
//				
//				i++;
//				j++;
//				k++;
//				
//			}
//			
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//	}
	public void print_course(String sID,String course[],String coursescore[],String coursetime[]) {
		conn = DBConnection.getCon();
		String sql = " SELECT * FROM StudentGrade WHERE sID=? ";
		
		int i = 0;
		int j = 0;
		int k = 0;
		
		try {
			prestmt = conn.prepareStatement(sql);
			prestmt.setString(1, sID);
			res = prestmt.executeQuery();
			
			while( res.next() ) {
				
				course[i] = res.getString("subject");
				coursescore[j] = res.getString("score");
				coursetime[k] = res.getString("courseTime");
				
				i++;
				j++;
				k++;
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
