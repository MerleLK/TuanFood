package com.tuan.Action.adminAction;

import com.opensymphony.xwork2.ActionSupport;
import com.tuan.DB.DAO.AdminDAO;
import com.tuan.DB.DAOImpl.AdminDAOImpl;

/** 修改城市信息的Action
 * Created by Administrator on 2017/7/2.
 */
public class EditCityAction extends ActionSupport {

    private int cityId;
    private String cityName;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String execute() throws Exception{
        AdminDAO adminDAO = new AdminDAOImpl();
        boolean isSuccess = adminDAO.editCity(cityId, cityName);
        if (isSuccess){
            addActionMessage("修改成功");
            return SUCCESS;
        }
        else{
            addActionError("修改失败!");
            return "fail";
        }
    }
}
