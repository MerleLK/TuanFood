package com.tuan.Action.adminAction;

import com.opensymphony.xwork2.ActionSupport;
import com.tuan.DB.DAO.AdminDAO;
import com.tuan.DB.DAOImpl.AdminDAOImpl;

import java.util.HashMap;
import java.util.List;

/** 得到所有的城市信息的Action
 * Created by Administrator on 2017/6/25.
 */
public class getAllCityIdAction extends ActionSupport{

    private HashMap<String, String> citys;

    public HashMap<String, String> getCitys() {
        return citys;
    }

    public void setCitys(HashMap<String, String> citys) {
        this.citys = citys;
    }

    @Override
    public String execute() throws Exception{
        AdminDAO adminDAO = new AdminDAOImpl();
        citys = adminDAO.getAllCityId();
        System.out.println(citys);

        return SUCCESS;
    }
}
