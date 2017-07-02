package com.tuan.Action.adminAction;

import com.opensymphony.xwork2.ActionSupport;
import com.tuan.DB.DAO.AdminDAO;
import com.tuan.DB.DAOImpl.AdminDAOImpl;
import com.tuan.DB.domain.City;

/** 得到某城市具体信息 Action
 * Created by Administrator on 2017/7/2.
 */
public class getCityInfoAction extends ActionSupport{

    private int cityId;
    private City city;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String execute() throws Exception{

        AdminDAO adminDAO = new AdminDAOImpl();
        city = adminDAO.getCityByCityId(cityId);

        return SUCCESS;
    }
}
