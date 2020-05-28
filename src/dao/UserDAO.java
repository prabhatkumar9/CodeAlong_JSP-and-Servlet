package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;
import utility.ConnectionManager;

public class UserDAO implements UserDaoInterface {

    @Override
    public int signup(User user) {
	String insert_users_sql = "INSERT INTO USERS(email,password) VALUES(?,?)";
	int result =0;
	try {
	    Connection con = ConnectionManager.getConnection();
	    PreparedStatement ps = con.prepareStatement(insert_users_sql);
	    ps.setString(1, user.getEmail());
	    ps.setString(2, user.getPassword());
	    System.out.println(ps);
	    result = ps.executeUpdate();
	}catch(Exception e) {
	    e.printStackTrace();
	}
	return result;
    }

    @Override
    public boolean loginUser(User user) {
	boolean status = false;
	try {
	    Connection con = ConnectionManager.getConnection();
	    PreparedStatement ps = con.prepareStatement("SELECT * FROM USERS WHERE EMAIL = ? AND PASSWORD = ?");
	    ps.setString(1, user.getEmail());
	    ps.setString(2, user.getPassword());
	    ResultSet rs = ps.executeQuery();
	    status = rs.next();
	}catch(Exception e) {
	    e.printStackTrace();
	}
	return status;
    }

  
}
