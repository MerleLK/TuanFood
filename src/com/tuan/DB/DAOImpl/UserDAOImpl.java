package com.tuan.DB.DAOImpl;

import com.tuan.DB.DAO.UserDAO;
import com.tuan.DB.DBManager.DatabaseConnection;
import com.tuan.DB.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

/** 用户数据库操作的接口实现
 * Created by Administrator on 2017/6/24.
 */
public class UserDAOImpl implements UserDAO {

    @Override
    // 登录检查 返回 bool
    public boolean checkUser(String username, String password) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        String checkUserSql = "select * from users where username=? and PASSWORD=?";
        PreparedStatement stmt = con.prepareStatement(checkUserSql);
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        boolean isHave = rs.next();

        rs.close();
        stmt.close();
        con.close();
        return isHave;
    }

    @Override
    public String getUserRole(String username) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        String getUserRoleSql = "select ROLE_ID from users where username=?";
        PreparedStatement stmt = con.prepareStatement(getUserRoleSql);
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();
//        int role_id = rs.getInt("ROLE_ID");
        rs.next();
        int role_id = Integer.valueOf(rs.getString("ROLE_ID"));

        String getUserRoleNameSql = "select * from roles where role_id=?";
        PreparedStatement stmt2 = con.prepareStatement(getUserRoleNameSql);
        stmt2.setInt(1, role_id);
        ResultSet rs2 = stmt2.executeQuery();
        rs2.next();
        String role_name = rs2.getString("role_name");
        System.out.println(role_name);
        return role_name;
    }

    @Override
    public boolean checkUser(String username) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        String checkUserSql = "select * from users where username=?";
        PreparedStatement stmt = con.prepareStatement(checkUserSql);
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();
        boolean isHave = rs.next();
        rs.close();
        stmt.close();
        con.close();
        return isHave;
    }

    @Override
    public boolean insertUser(String username, String password, int userAge, Date userBirthday,
                              Float userMoney, String userAddress, int userRoleId) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        String insertUserSql = "insert into users(USERNAME, PASSWORD, USER_AGE, USER_BIRTHDAY, USER_MONEY, " +
                "USER_ADDRESS, ROLE_ID) values(?,?,?,?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(insertUserSql);
        stmt.setString(1, username);
        stmt.setString(2, password);
        stmt.setInt(3, userAge);
        java.sql.Date birth = new java.sql.Date(userBirthday.getTime());
        stmt.setDate(4, birth);
        stmt.setFloat(5, userMoney);
        stmt.setString(6, userAddress);
        stmt.setInt(7, userRoleId);
        int m = stmt.executeUpdate();

        return m>0;
    }

    @Override
    public int getUserIdByName(String username) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        String getUserIdByNameSql = "SELECT USER_ID FROM USERS WHERE USERNAME=?";
        PreparedStatement stmt = con.prepareStatement(getUserIdByNameSql);
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        int userId = rs.getInt("user_id");

        return userId;
    }

    @Override
    public User getUserInfo(String username) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        User user = new User();
        String getUserInfoSql = "SELECT * from USERS WHERE USERNAME=?";
        PreparedStatement stmt = con.prepareStatement(getUserInfoSql);
        stmt.setString(1, username);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            user.setUserId(rs.getInt("user_id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setUserAge(rs.getInt("user_age"));
            user.setUserBirthday(rs.getDate("user_birthday"));
            user.setUserMoney(rs.getFloat("user_money"));
            user.setUserAddress(rs.getString("user_address"));
            user.setUserRoleId(rs.getInt("role_id"));
        }
        return user;
    }
}
