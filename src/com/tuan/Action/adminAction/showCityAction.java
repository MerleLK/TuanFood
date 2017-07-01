package com.tuan.Action.adminAction;

import com.opensymphony.xwork2.ActionSupport;
import com.tuan.DB.DAO.AdminDAO;
import com.tuan.DB.DAOImpl.AdminDAOImpl;

import java.util.List;

/** show citys
 * Created by Administrator on 2017/6/25.
 */
public class showCityAction extends ActionSupport{

    private List<String[]> citys;
    private int cityId;

    public List<String[]> getCitys() {
        return citys;
    }

    public void setCitys(List<String[]> citys) {
        this.citys = citys;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String execute() throws Exception{

        AdminDAO adminDAO = new AdminDAOImpl();
        citys = adminDAO.getAllCitys();
        return SUCCESS;
    }
}
