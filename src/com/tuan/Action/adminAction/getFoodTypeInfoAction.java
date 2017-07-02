package com.tuan.Action.adminAction;

import com.opensymphony.xwork2.ActionSupport;
import com.tuan.DB.DAO.AdminDAO;
import com.tuan.DB.DAOImpl.AdminDAOImpl;
import com.tuan.DB.domain.FoodType;

/** 得到某美食类别的具体信息
 * Created by Administrator on 2017/7/2.
 */
public class getFoodTypeInfoAction extends ActionSupport {

    private FoodType foodType;
    private int foodTypeId;

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public int getFoodTypeId() {
        return foodTypeId;
    }

    public void setFoodTypeId(int foodTypeId) {
        this.foodTypeId = foodTypeId;
    }

    @Override
    public String execute() throws Exception{

        AdminDAO adminDAO = new AdminDAOImpl();
        foodType = adminDAO.getFoodTypeById(foodTypeId);
        return SUCCESS;
    }
}
