package com.tuan.Action.loginAction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/** 登出的Action
 * Created by Administrator on 2017/6/28.
 */
public class logoutAction extends ActionSupport{

    @Override
    public String execute() {
//        ActionContext.getContext().getSession().remove("username");
        ActionContext.getContext().getSession().clear();
        return SUCCESS;
    }

}
