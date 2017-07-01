package com.tuan.Action.adminAction;

import com.opensymphony.xwork2.ActionSupport;
import com.tuan.DB.DAO.AdminDAO;
import com.tuan.DB.DAOImpl.AdminDAOImpl;

import java.util.List;

/** 展示美食类别
 * Created by Administrator on 2017/6/25.
 */
public class showFoodTypeAction extends ActionSupport{

    private List<String[]> foodTypes;

    public List<String[]> getFoodTypes() {
        return foodTypes;
    }

    public void setFoodTypes(List<String[]> foodTypes) {
        this.foodTypes = foodTypes;
    }

    @Override
    public String execute() throws Exception{
        AdminDAO adminDAO = new AdminDAOImpl();

        foodTypes = adminDAO.getAllFoodType();

        return SUCCESS;
    }
}
