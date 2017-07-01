package com.tuan.DB.DBManager;

import java.sql.Connection;
import java.sql.DriverManager;

/** 获取数据库连接
 * Created by Administrator on 2017/6/24.
 */
public class DatabaseConnection {
    private Connection con;
    private static final String DRIVER = "org.hsqldb.jdbcDriver";
    private static final String USER = "SA";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:hsqldb:hsql://localhost:10000/mydb";

    public DatabaseConnection() throws Exception{
        Class.forName(DRIVER);
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("数据库连接成功....");
    }

    public Connection getConnection() throws Exception{
        return con;
    }

    public void close() throws Exception{
        if (con != null){
            con.close();
            System.out.println("数据库连接已关闭.....");
        }
    }
}
