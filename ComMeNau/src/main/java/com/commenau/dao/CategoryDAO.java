package com.commenau.dao;

import com.commenau.model.CategoryModel;
import com.commenau.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
	public List<CategoryModel> selectAll() {
		List<CategoryModel> ketQua = new ArrayList<CategoryModel>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM categories";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("category_name");
				String code = rs.getString("category_code");
				Timestamp updated = rs.getTimestamp("updated_at");
				Timestamp create = rs.getTimestamp("created_at");
				ketQua.add(new CategoryModel(id, code, name, updated, create));
			}

			// Bước 5:
			JDBCUtil.closeConnection(con, st, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ketQua;
	}

}
