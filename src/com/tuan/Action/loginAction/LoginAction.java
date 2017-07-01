package com.tuan.Action.loginAction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tuan.DB.DAO.UserDAO;
import com.tuan.DB.DAOImpl.UserDAOImpl;

import java.util.Map;

/**
 * Login Action
 * Created by Administrator on 2017/6/24.
 */
public class LoginAction extends ActionSupport {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void validate() {
        if (username.trim().length() == 0) {
            addFieldError("username", getText("username.blank"));
        }
        if (password.trim().length() == 0) {
            addFieldError("password", getText("password.blank"));
        }
    }

    @Override
    public String execute() throws Exception {

        UserDAO userDAO = new UserDAOImpl();
        boolean isHave = userDAO.checkUser(username, password);
        if (isHave) {
            String role_name = userDAO.getUserRole(username);
            Map<String, Object> session = ActionContext.getContext().getSession();
            session.put("username", username);
            session.put("userRole", role_name);
//            return SUCCESS;
            switch (role_name) {
                case "admin":
                    return "adminSuccess";
                case "seller":
                    return "sellerSuccess";
                case "user":
//                    session.put("nowCity", "郑州");
                    return "userSuccess";
            }

        }
        addActionError(getText("login.error"));
        return "fail";
    }
}
