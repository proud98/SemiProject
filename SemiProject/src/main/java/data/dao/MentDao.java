package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import data.dto.MentDto;
import mysql.db.DbConnect;

public class MentDao {
	
	DbConnect db=new DbConnect();
	
	//insert
	public void insertMent(MentDto dto) {
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		String sql="insert into ment values(null,?,?,?,now())";
		
		try {
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCommu_num());
			pstmt.setString(2, dto.getUser_num());
			pstmt.setString(3, dto.getMent_content());
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//select
	public List<MentDto> getAllMent(String commu_num){
		
		List<MentDto> list=new Vector<>();
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from ment where commu_num=? order by ment_num";
		
		try {
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, commu_num);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				
				MentDto dto=new MentDto();
				dto.setMent_num(rs.getString("ment_num"));
				dto.setCommu_num(rs.getString("commu_num"));
				dto.setUser_num(rs.getString("user_num"));
				dto.setMent_content(rs.getString("ment_content"));
				dto.setMent_writeday(rs.getTimestamp("ment_writeday"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return list;
	}
	
	//delete
	public void deleteMent(String ment_num) {
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		String sql="delete from ment where ment_num=?";
		
		try {
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, ment_num);
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//ment_num에 따른 각각의 dto
	public MentDto getMentData(String ment_num) {
		
		MentDto dto=new MentDto();
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from ment where ment_num=?";
		
		try {
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, ment_num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				
				dto.setMent_num(rs.getString("ment_num"));
				dto.setCommu_num(rs.getString("commu_num"));
				dto.setUser_num(rs.getString("user_num"));
				dto.setMent_content(rs.getString("ment_content"));
				dto.setMent_writeday(rs.getTimestamp("ment_writeday"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return dto;
	}
	
	//update
	public void updateMent(MentDto dto) {
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		String sql="update ment set ment_content=? where ment_num=?";
		
		try {
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMent_content());
			pstmt.setString(2, dto.getMent_num());
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//user_num에 따른 리스트 출력
	public List<MentDto> getMyMentList(String user_num, int start, int perPage){
		
		List<MentDto> mymentlist=new Vector<>();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from ment where user_num=? order by ment_num desc limit ?,?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, user_num);
			pstmt.setInt(2, start);
			pstmt.setInt(3, perPage);

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				MentDto dto=new MentDto();
				
				dto.setMent_num(rs.getString("ment_num"));
				dto.setCommu_num(rs.getString("commu_num"));
				dto.setUser_num(rs.getString("user_num"));
				dto.setMent_content(rs.getString("ment_content"));
				dto.setMent_writeday(rs.getTimestamp("ment_writeday"));
				
				mymentlist.add(dto);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return mymentlist;
	}
	
	
	// user_num에 따른 댓글 갯수 구하기
	public int myMentCount(String user_num) {

		int total = 0;

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select count(*) from ment where user_num=?";

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				total = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		return total;
	}
	
	//commu_num에 따른 category 
	 public String getCategory(String commu_num) {
	      
	      String commu_category="";
	      
	      Connection conn=db.getConnection();
	        PreparedStatement pstmt=null;
	        ResultSet rs=null;
	        
	        String sql="select commu_category from commu where commu_num=?";
	        
	        try {
	         pstmt=conn.prepareStatement(sql);
	         pstmt.setString(1, commu_num);
	           rs=pstmt.executeQuery();
	               
	               if(rs.next()) {
	                  commu_category=rs.getString("commu_category");
	               }
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }finally {
	         db.dbClose(rs, pstmt, conn);
	      }
	      
	      return commu_category;
	   }
	 
	 
	
}