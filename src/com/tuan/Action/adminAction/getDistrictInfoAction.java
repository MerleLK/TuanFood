package com.tuan.Action.adminAction;

import com.opensymphony.xwork2.ActionSupport;
import com.tuan.DB.DAO.AdminDAO;
import com.tuan.DB.DAOImpl.AdminDAOImpl;
import com.tuan.DB.domain.District;

import java.util.HashMap;

/** 得到某地区的详细信息Action
 * Created by Administrator on 2017/7/2.
 */
public class getDistrictInfoAction extends ActionSupport{

    private District district;
    private int districtId;
    HashMap<String, String> citys;

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public HashMap<String, String> getCitys() {

        return citys;
    }

    public void setCitys(HashMap<String, String> citys) {
        this.citys = citys;
    }

    @Override
    public String execute() throws Exception{
        AdminDAO adminDAO = new AdminDAOImpl();

        district = adminDAO.getDistrictByDistrictId(districtId);
        citys = adminDAO.getAllCityId();

        return SUCCESS;
    }
}
