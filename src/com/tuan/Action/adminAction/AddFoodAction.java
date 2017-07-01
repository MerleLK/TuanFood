package com.tuan.Action.adminAction;

import com.opensymphony.xwork2.ActionSupport;
import com.tuan.DB.DAO.AdminDAO;
import com.tuan.DB.DAOImpl.AdminDAOImpl;

/** 添加美食类别
 * Created by Administrator on 2017/6/25.
 */
public class AddFoodAction extends ActionSupport{
    private String foodType;

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    @Override
    public void validate(){
        if (foodType.trim().length()==0){
            addFieldError("foodtype", "请输入美食类别名称!");
        }
    }

    @Override
    public String execute() throws Exception{

        AdminDAO adminDAO = new AdminDAOImpl();
        boolean isHave = adminDAO.checkFoodType(foodType);
        if(!isHave){
            boolean isSuccess = adminDAO.addFoodType(foodType);
            if(isSuccess){
                addActionMessage("新增美食类别成功");
                return SUCCESS;
            }
            else
                addActionError("数据库存取错误");
        }else
            addActionError("该美食类别已存在!");

        return "fail";
    }
}
