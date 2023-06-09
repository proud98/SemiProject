package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.mysql.cj.protocol.Resultset;

import data.dto.MovieDto;
import data.dto.ReviewDto;
import mysql.db.DbConnect;

public class ReviewDao {
   DbConnect db = new DbConnect();

   public void insertreview(ReviewDto dto) {

      Connection conn = db.getConnection();
      PreparedStatement pstmt = null;

      String sql = "insert into review values(null, ?, ?, ?, ?, now())";

      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, dto.getMovie_num());
         pstmt.setString(2, dto.getUser_num());
         pstmt.setDouble(3, dto.getReview_score());
         pstmt.setString(4, dto.getReview_content());

         pstmt.execute();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         db.dbClose(pstmt, conn);
      }

   }
   
   public void deleteReview(String review_num) {

	      Connection conn = db.getConnection();
	      PreparedStatement pstmt = null;

	      String sql = "delete from review where review_num=?";

	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, review_num);
	         
	         pstmt.execute();
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         db.dbClose(pstmt, conn);
	      }

	   }

   public int getMaxNum() {
      int max = 0;

      Connection conn = db.getConnection();
      PreparedStatement pstmt = null;
      ResultSet rs = null;

      String sql = "select max(review_num) max from review";

      try {
         pstmt = conn.prepareStatement(sql);
         rs = pstmt.executeQuery();

         if (rs.next()) {
            max = rs.getInt("max");
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }

      return max;

   }

   public MovieDto getPickData(String movie_num) {
      MovieDto mdto = new MovieDto();

      Connection conn = db.getConnection();
      PreparedStatement pstmt = null;
      ResultSet rs = null;

      String sql = "select movie_pcount from movie where movie_num=?";

      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, movie_num);
         rs = pstmt.executeQuery();

         if (rs.next()) {
               mdto.setMovie_num(rs.getString("movie_num"));
         }

      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         db.dbClose(pstmt, conn);
      }

      return mdto;
   }

   public List<ReviewDto> getAllReview_num(String user_num) {
      List<ReviewDto> list = new Vector<>();

      Connection conn = db.getConnection();
      PreparedStatement pstmt = null;
      ResultSet rs = null;

      String sql = "select * from review where user_num=? order by movie_num";

      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, user_num);
         rs = pstmt.executeQuery();

         while (rs.next()) {
            ReviewDto dto = new ReviewDto();
            dto.setUser_num(rs.getString("user_num"));
            dto.setMovie_num(rs.getString("movie_num"));
            dto.setReview_num(rs.getString("review_num"));
            dto.setReview_score(rs.getDouble("review_score"));
            dto.setReview_content(rs.getString("review_content"));
            dto.setReview_writeday(rs.getTimestamp("review_writeday"));

            list.add(dto);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         db.dbClose(rs, pstmt, conn);
      }

      return list;
   }

   public int getTotalReviewCount(String movie_num) {
      int total = 0;

      Connection conn = db.getConnection();
      PreparedStatement pstmt = null;
      ResultSet rs = null;

      String sql = "select count(*) from review where movie_num=?";

      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, movie_num);
         rs = pstmt.executeQuery();

         if (rs.next()) {
            total = rs.getInt(1);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         db.dbClose(rs, pstmt, conn);
      }

      return total;
   }

   // 페이징처리 list
   public List<ReviewDto> getAllReview(int start, int perPage) {
      List<ReviewDto> list = new Vector<>();

      Connection conn = db.getConnection();
      PreparedStatement pstmt = null;
      ResultSet rs = null;

      String sql = "select * from review order by user_num desc limit ?,?";

      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, start);
         pstmt.setInt(2, perPage);

         rs = pstmt.executeQuery();

         while (rs.next()) {
            ReviewDto dto = new ReviewDto();

            dto.setUser_num(rs.getString("user_num"));
            dto.setMovie_num(rs.getString("movie_num"));
            dto.setReview_num(rs.getString("review_num"));
            dto.setReview_score(rs.getDouble("review_score"));
            dto.setReview_content(rs.getString("review_content"));
            dto.setReview_writeday(rs.getTimestamp("review_writeday"));

            list.add(dto);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         db.dbClose(rs, pstmt, conn);
      }

      return list;

   }

   public List<ReviewDto> getAllReview_movie(String movie_num, int start, int perPage) {
      List<ReviewDto> list = new Vector<>();

      Connection conn = db.getConnection();
      PreparedStatement pstmt = null;
      ResultSet rs = null;

      String sql = "select * from review where movie_num=? order by review_num desc limit ?,?";

      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, movie_num);
         pstmt.setInt(2, start);
         pstmt.setInt(3, perPage);

         rs = pstmt.executeQuery();

         while (rs.next()) {
            ReviewDto dto = new ReviewDto();

            dto.setReview_num(rs.getString("review_num"));
            dto.setMovie_num(rs.getString("movie_num"));
            dto.setUser_num(rs.getString("user_num"));
            dto.setReview_score(rs.getDouble("review_score"));
            dto.setReview_content(rs.getString("review_content"));
            dto.setReview_writeday(rs.getTimestamp("review_writeday"));

            list.add(dto);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         db.dbClose(rs, pstmt, conn);
      }

      return list;

   }

   public double review_ScoreAvg(String movie_num) {
      double score = 0;

      Connection conn = db.getConnection();
      PreparedStatement pstmt = null;
      ResultSet rs = null;

      String sql = "select round(avg(review_score),2) avg from review where movie_num=?";

      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, movie_num);
         rs = pstmt.executeQuery();

         if (rs.next()) {
            score = rs.getDouble(1);
         }

      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return score;
   }

   public void insertMovie_Rank_Avg(double review_avgscore, String movie_num) {

      Connection conn = db.getConnection();
      PreparedStatement pstmt = null;

      String sql = "update movie set movie_rank_avg=? where movie_num=?";

      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setDouble(1, review_avgscore);
         pstmt.setString(2, movie_num);

         pstmt.execute();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         db.dbClose(pstmt, conn);
      }
   }

   public void updatePick(String movie_num) {
      Connection conn = db.getConnection();
      PreparedStatement pstmt = null;

      String sql = "update movie set movie_pcount=movie_pcount+1 where movie_num=?";

      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, movie_num);

         pstmt.execute();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         db.dbClose(pstmt, conn);
      }
   }
   
   public void deletePick(String movie_num) {
      Connection conn = db.getConnection();
      PreparedStatement pstmt = null;

      String sql = "update movie set movie_pcount=movie_pcount-1 where movie_num=?";

      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, movie_num);

         pstmt.execute();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         db.dbClose(pstmt, conn);
      }
   }
   
   
   //user_num에 따른 리스트 출력
   public List<ReviewDto> getMyReview(String user_num, int start, int perPage) {
	      List<ReviewDto> myreviewlist = new Vector<>();

	      Connection conn = db.getConnection();
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;

	      String sql = "select * from review where user_num=? order by review_num desc limit ?,?";

	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, user_num);
	         pstmt.setInt(2, start);
	         pstmt.setInt(3, perPage);

	         rs = pstmt.executeQuery();

	         while (rs.next()) {
	            ReviewDto dto = new ReviewDto();

	            dto.setReview_num(rs.getString("review_num"));
	            dto.setMovie_num(rs.getString("movie_num"));
	            dto.setUser_num(rs.getString("user_num"));
	            dto.setReview_score(rs.getDouble("review_score"));
	            dto.setReview_content(rs.getString("review_content"));
	            dto.setReview_writeday(rs.getTimestamp("review_writeday"));

	            myreviewlist.add(dto);
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         db.dbClose(rs, pstmt, conn);
	      }

	      return myreviewlist;

	   }
   
   //user_num별 갯수 구하기
   public int myReviewCount(String user_num) {
	   
	    int total = 0;
	    
	    Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select count(*) from review where user_num=?";

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
   
   //movie_num에 따른 제목
   public String getMovieSubject(String movie_num) {
	      
	      String movie_subject="";
	      
	      Connection conn=db.getConnection();
	        PreparedStatement pstmt=null;
	        ResultSet rs=null;
	        
	        String sql="select movie_subject from movie where movie_num=?";
	        
	        try {
	         pstmt=conn.prepareStatement(sql);
	         pstmt.setString(1, movie_num);
	           rs=pstmt.executeQuery();
	               
	               if(rs.next()) {
	            	   movie_subject=rs.getString("movie_subject");
	               }
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }finally {
	         db.dbClose(rs, pstmt, conn);
	      }
	      
	      return movie_subject;
	   }


}