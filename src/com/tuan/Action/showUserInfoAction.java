package com.tuan.Action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tuan.DB.DAO.UserDAO;
import com.tuan.DB.DAOImpl.UserDAOImpl;
import com.tuan.DB.domain.User;

/** 展示用户个人信息页面
 * Created by Administrator on 2017/6/29.
 */
public class showUserInfoAction extends ActionSupport{

    private User user;
    private String username;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String execute() throws Exception{
        UserDAO userDAO = new UserDAOImpl();
        if (username == null){
            username = ActionContext.getContext().getSession().get("username").toString();
        }
        user = userDAO.getUserInfo(username);
        return SUCCESS;
    }
}
