package com.tuan.Action.adminAction;

import com.opensymphony.xwork2.ActionSupport;
import com.tuan.DB.DAO.AdminDAO;
import com.tuan.DB.DAOImpl.AdminDAOImpl;

/** 修改地区信息Action
 * Created by Administrator on 2017/7/2.
 */
public class EditDistrictAction extends ActionSupport{

    private int districtId;
    private String districtName;
    private int cityId;

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Override
    public String execute() throws Exception{

        AdminDAO adminDAO = new AdminDAOImpl();

        boolean isSuccess = adminDAO.editDistrict(districtId, districtName, cityId);
        if (isSuccess){
            addActionMessage("修改地区信息成功");
            return SUCCESS;
        }
        else {
            addActionError("修改地区信息失败");
            return "fail";
        }

    }
}
