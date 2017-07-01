package com.tuan.Action.loginAction;

import com.opensymphony.xwork2.ActionSupport;
import com.tuan.DB.DAO.UserDAO;
import com.tuan.DB.DAOImpl.UserDAOImpl;
import com.tuan.DB.domain.User;


/** register Action
 * Created by Administrator on 2017/6/25.
 */
public class registerAction extends ActionSupport{

   private User user = new User();
   private int id;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void validate(){
        // 做一些其他判断, 为空和部分格式在页面 js判断
        if (user.getUserAge()<0 || user.getUserAge()>100){
            addActionMessage(getText("AgeWrong"));
        }
    }

    @Override
    public String execute() throws Exception{
        UserDAO userDAO = new UserDAOImpl();
        float f = 1000; // 用户默认钱数
        boolean isHave = userDAO.checkUser(user.getUsername());
        if (!isHave){
            boolean isSuccess = userDAO.insertUser(user.getUsername(), user.getPassword(), user.getUserAge(),
                    user.getUserBirthday(), f, user.getUserAddress(), user.getUserRoleId());
            if (isSuccess){
                addActionMessage(getText("registerSuccess"));
                return SUCCESS;
            }
            else
            {
                addActionMessage(getText("registerWrong_other"));
            }
        }
        else {
            addActionMessage(getText("registerWrong_sameNAme"));
        }
        return "fail";
    }
}
