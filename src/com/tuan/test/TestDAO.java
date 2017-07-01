package com.tuan.test;


import com.tuan.DB.DBManager.DatabaseConnection;
import java.sql.Connection;

/** 数据库测试
 * Created by Administrator on 2017/6/24.
 */
public class TestDAO {

    private boolean getCon() throws Exception{
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();
        return con != null;

    }

    public static void main(String[] args) throws Exception{
        TestDAO test = new TestDAO();
        if (!test.getCon()){
            System.out.println("数据库连接失败.....");
        }

    }
}
