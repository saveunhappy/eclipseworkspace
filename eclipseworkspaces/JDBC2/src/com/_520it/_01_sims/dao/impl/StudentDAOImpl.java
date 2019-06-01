package com._520it._01_sims.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com._520it._01_sims.dao.IStudentDAO;
import com._520it._01_sims.domain.Student;
import com._520it._01_sims.util.JdbcUtil;

public class StudentDAOImpl implements IStudentDAO{
	
	
	public void save(Student stu) {
//		String sql = "INSERT INTO t_student (name,age) VALUES('"+stu.getName()+"',"+stu.getAge()+")";
		//������Դ
		StringBuilder sb = new StringBuilder(80);
		sb.append("INSERT INTO t_student (name,age) VALUES('");
		sb.append(stu.getName());
		sb.append("',");
		sb.append(stu.getAge());
		sb.append(")");
		System.out.println(sb);
		Connection conn = null;
		Statement st = null;
		try {
			//1: ����ע������
			//2:��ȡ���Ӷ���
			conn = JdbcUtil.getConnection();
			//3:����������
			st = conn.createStatement();
			//4:ִ��SQL
			st.executeUpdate(sb.toString());
			//��������
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
				try {
					if(st != null) {
						st.close();
					}
				} catch (Exception e3) {
					e3.printStackTrace();
				}finally {
					try {
						if(conn!=null) {
							conn.close();
						}
					} catch (Exception e4) {
						e4.printStackTrace();
					}
				}
			
		}
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from t_student where id = "+id;
		Connection conn = null;
		Statement st = null;
		try {
			//2:��ȡ���Ӷ���
			conn = JdbcUtil.getConnection();
			//3:����������
			st = conn.createStatement();
			//4:ִ��SQL
			st.executeUpdate(sql);
			//��������
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
				try {
					if(st != null) {
						st.close();
					}
				} catch (Exception e3) {
					e3.printStackTrace();
				}finally {
					try {
						if(conn!=null) {
							conn.close();
						}
					} catch (Exception e4) {
						e4.printStackTrace();
					}
				}
			
		}
		
	}

	@Override
	//UPDATE t_student SET name='xx',age='28' where id = 6;
	public void update(Long id, Student newStu) {
		StringBuilder sb = new StringBuilder(80);
		sb.append("UPDATE t_student SET name = '").append(newStu.getName())
		.append("',age=").append(newStu.getAge());
		sb.append(" where id =").append(id);
		System.out.println(sb.toString());
		Connection conn = null;
		Statement st = null;
		try {
			//1: ����ע������
			conn = JdbcUtil.getConnection();
			st = conn.createStatement();
			//4:ִ��SQL
			st.executeUpdate(sb.toString());
			//��������
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		JdbcUtil.close(conn, st, null);
		}
	}

	@Override
	public Student get(Long id) {
		String sql = "SELECT * FROM t_student where id ="+id;
		//������Դ
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			//1: ����ע������
			conn = JdbcUtil.getConnection();
			//3:����������
			st = conn.createStatement();
			//4:ִ��SQL
			rs = st.executeQuery(sql);
			
			//��������
			
			if(rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getLong("id"));
				stu.setName(rs.getString("name"));
				stu.setAge(rs.getInt("age"));
				return stu;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, st, rs);
			
		}
		return null;
	}

	@Override
	public List<Student> listAll() {
		List<Student> list = new ArrayList<>();
		String sql = "SELECT * FROM t_student";
		//������Դ
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			//1: ����ע������
			conn = JdbcUtil.getConnection();
			//3:����������
			st = conn.createStatement();
			//4:ִ��SQL
			rs = st.executeQuery(sql);
			
			//��������
			
			while(rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getLong("id"));
				stu.setName(rs.getString("name"));
				stu.setAge(rs.getInt("age"));
				list.add(stu);//��ѧ�������ȴ洢��������
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}finally {
				try {
					if(st != null) {
						st.close();
					}
				} catch (Exception e3) {
					e3.printStackTrace();
				}finally {
					try {
						if(conn!=null) {
							conn.close();
						}
					} catch (Exception e4) {
						e4.printStackTrace();
					}
				}
			}
			
		}
		return list;
	}
	
}
