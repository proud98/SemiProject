package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import data.dto.CommuDto;
import mysql.db.DbConnect;

public class CommuDao {

	DbConnect db = new DbConnect();

	// insert
	public void insertCommu(CommuDto dto) {

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;

		String sql = "insert into commu values(null,?,?,?,?,?,0,now())";

		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getUser_num());
			pstmt.setString(2, dto.getCommu_subject());
			pstmt.setString(3, dto.getCommu_category());
			pstmt.setString(4, dto.getCommu_content());
			pstmt.setString(5, dto.getCommu_photo());

			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}

	}

	// (페이징 처리) 전체 갯수 구하기
	public int totalCommuCount() {

		int total = 0;

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select count(*) from commu";

		try {

			pstmt = conn.prepareStatement(sql);
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
	
	// (페이징 처리) 카테고리별 갯수 구하기
	public int commuCount(String commu_category) {

		int total = 0;

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select count(*) from commu where commu_category=?";

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, commu_category);
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
	
	// (페이징처리) 리스트 카테고리별 츌력
		public List<CommuDto> getCategoryList(String commu_category, int start, int perPage) {

			List<CommuDto> categorylist = new Vector<>();

			Connection conn = db.getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			String sql = "select * from commu where commu_category=? order by commu_num desc limit ?,?";

			try {

				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, commu_category);
				pstmt.setInt(2, start);
				pstmt.setInt(3, perPage);

				rs = pstmt.executeQuery();

				while (rs.next()) {

					CommuDto dto = new CommuDto();

					dto.setCommu_num(rs.getString("commu_num"));
					dto.setUser_num(rs.getString("user_num"));
					dto.setCommu_category(rs.getString("commu_category"));
					dto.setCommu_subject(rs.getString("commu_subject"));
					dto.setCommu_content(rs.getString("commu_content"));
					dto.setCommu_photo(rs.getString("commu_photo"));
					dto.setCommu_readcount(rs.getInt("commu_readcount"));
					dto.setCommu_writeday(rs.getTimestamp("commu_writeday"));

					categorylist.add(dto);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				db.dbClose(rs, pstmt, conn);
			}

			return categorylist;
		}

	// (페이징처리) 리스트 전체 츌력
	public List<CommuDto> getAllList(int start, int perPage) {

		List<CommuDto> list = new Vector<>();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from commu order by commu_num desc limit ?,?";

		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, start);
			pstmt.setInt(2, perPage);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				CommuDto dto = new CommuDto();

				dto.setCommu_num(rs.getString("commu_num"));
				dto.setUser_num(rs.getString("user_num"));
				dto.setCommu_category(rs.getString("commu_category"));
				dto.setCommu_subject(rs.getString("commu_subject"));
				dto.setCommu_content(rs.getString("commu_content"));
				dto.setCommu_photo(rs.getString("commu_photo"));
				dto.setCommu_readcount(rs.getInt("commu_readcount"));
				dto.setCommu_writeday(rs.getTimestamp("commu_writeday"));

				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}

		return list;
	}
	

	// num에 대한 각각의 dto
	public CommuDto getCommuData(String commu_num) {

		CommuDto dto = new CommuDto();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from commu where commu_num=?";

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, commu_num);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				dto.setCommu_num(rs.getString("commu_num"));
				dto.setUser_num(rs.getString("user_num"));
				dto.setCommu_category(rs.getString("commu_category"));
				dto.setCommu_subject(rs.getString("commu_subject"));
				dto.setCommu_content(rs.getString("commu_content"));
				dto.setCommu_photo(rs.getString("commu_photo"));
				dto.setCommu_readcount(rs.getInt("commu_readcount"));
				dto.setCommu_writeday(rs.getTimestamp("commu_writeday"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}

		return dto;
	}

	// 조회수 카운트
	public void updateReadCount(String commu_num) {

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;

		String sql = "update commu set commu_readcount=commu_readcount+1 where commu_num=?";

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, commu_num);
			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	// maxNum (게시글 등록 후 그 글로 페이지 이동)
	public int getMaxNum() {

		int max = 0;

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select max(commu_num) max from commu";

		try {

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				max = rs.getInt("max");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}

		return max;
	}

	// update
	public void updateCommu(CommuDto dto) {

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;

		String sql = "update commu set commu_category=?,commu_subject=?,commu_content=?,commu_photo=? where commu_num=?";

		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getCommu_category());
			pstmt.setString(2, dto.getCommu_subject());
			pstmt.setString(3, dto.getCommu_content());
			pstmt.setString(4, dto.getCommu_photo());
			pstmt.setString(5, dto.getCommu_num());

			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	// delete
	public void deleteCommu(String commu_num) {

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;

		String sql = "delete from commu where commu_num=?";

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, commu_num);
			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	// (페이징처리) user_num에 따른 리스트 츌력
	public List<CommuDto> getMyCommuList(String user_num, int start, int perPage) {

		List<CommuDto> mycommulist = new Vector<>();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from commu where user_num=? order by commu_num desc limit ?,?";

		try {

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user_num);
			pstmt.setInt(2, start);
			pstmt.setInt(3, perPage);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				CommuDto dto = new CommuDto();

				dto.setCommu_num(rs.getString("commu_num"));
				dto.setUser_num(rs.getString("user_num"));
				dto.setCommu_category(rs.getString("commu_category"));
				dto.setCommu_subject(rs.getString("commu_subject"));
				dto.setCommu_content(rs.getString("commu_content"));
				dto.setCommu_photo(rs.getString("commu_photo"));
				dto.setCommu_readcount(rs.getInt("commu_readcount"));
				dto.setCommu_writeday(rs.getTimestamp("commu_writeday"));

				mycommulist.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}

		return mycommulist;
	}
	
	//user_num별 갯수 구하기
	public int myCommuCount(String user_num) {

		int total = 0;

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select count(*) from commu where user_num=?";

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
	
	

}