package com.tuan.Action.adminAction;

import com.opensymphony.xwork2.ActionSupport;
import com.tuan.DB.DAO.AdminDAO;
import com.tuan.DB.DAOImpl.AdminDAOImpl;

import java.util.List;

/** 展示地区
 * Created by Administrator on 2017/6/25.
 */
public class showDistrictAction extends ActionSupport{
    private List<String[]> districts;
    private int districtId;
    private String districtName;

    public List<String[]> getDistricts() {
        return districts;
    }

    public void setDistricts(List<String[]> districts) {
        this.districts = districts;
    }

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

    @Override
    public String execute() throws Exception{
        AdminDAO adminDAO = new AdminDAOImpl();
        districts = adminDAO.getAllDistricts();

        return SUCCESS;
    }
}
