package com._520it._05dbcp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

public class DBCPTest {
	public DataSource setupDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/jdbcdemo");
        ds.setUsername("root");
        ds.setPassword("root");
        return ds;
    }
	
	@Test
	public void testName() throws Exception {
		DataSource ds = this.setupDataSource();
		Connection conn = ds.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from t_student");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			System.out.println(rs.getLong("id"));
		}
	}
}
