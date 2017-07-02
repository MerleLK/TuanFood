package com.tuan.Action.adminAction;

import com.opensymphony.xwork2.ActionSupport;
import com.tuan.DB.DAO.AdminDAO;
import com.tuan.DB.DAOImpl.AdminDAOImpl;

/**  修改类别信息Action
 * Created by Administrator on 2017/7/2.
 */
public class EditFoodTypeAction extends ActionSupport {

    private int foodTypeId;
    private String foodTypeName;

    public int getFoodTypeId() {
        return foodTypeId;
    }

    public void setFoodTypeId(int foodTypeId) {
        this.foodTypeId = foodTypeId;
    }

    public String getFoodTypeName() {
        return foodTypeName;
    }

    public void setFoodTypeName(String foodTypeName) {
        this.foodTypeName = foodTypeName;
    }

    @Override
    public String execute() throws Exception{

        AdminDAO adminDAO = new AdminDAOImpl();
        boolean isSuccess = adminDAO.editFoodType(foodTypeId, foodTypeName);

        if (isSuccess){
            addActionMessage("类别信息修改成功!");
            return SUCCESS;
        }
        else {
            addActionError("类别信息修改失败!");
            return "fail";
        }
    }
}
