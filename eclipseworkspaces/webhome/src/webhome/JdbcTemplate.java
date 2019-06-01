package webhome;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcTemplate {
	public static <T>T query(String sql,IResultSetHander<T> rsh,Object...params){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			//设置占位符参数
			for(int index=0;index<params.length;index++) {
				ps.setObject(index+1, params[index]);	
			}
			return rsh.handle(rs);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
}
