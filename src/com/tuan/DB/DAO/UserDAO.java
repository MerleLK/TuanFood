package com.tuan.DB.DAO;

import com.tuan.DB.domain.User;

import java.util.Date;

/** 用户的数据库操作接口
 * Created by Administrator on 2017/6/24.
 */
public interface UserDAO {
    // 登录的的用户名和密码检查
    boolean checkUser(String username, String password) throws Exception;
    // 得到用户身份
    String getUserRole(String username) throws Exception;
    // 检查用户是否存在
    boolean checkUser(String username) throws Exception;

    // 添加一个用户记录
    boolean insertUser(String username, String password, int userAge, Date userBirthday,
                       Float userMoney, String userAddress, int userRoleId) throws Exception;

    // 通过用户名得到用户ID
    int getUserIdByName(String username) throws Exception;

    // 通过用户名 得到用户的所有信息
    User getUserInfo(String username) throws Exception;

}
