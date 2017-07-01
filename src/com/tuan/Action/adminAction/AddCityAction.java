package com.tuan.Action.adminAction;

import com.opensymphony.xwork2.ActionSupport;
import com.tuan.DB.DAO.AdminDAO;
import com.tuan.DB.DAOImpl.AdminDAOImpl;
import com.tuan.DB.domain.City;

/** Add city Action
 * Created by Administrator on 2017/6/25.
 */
public class AddCityAction extends ActionSupport{
    private City city;
    private int cityId;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
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

        boolean isHave = adminDAO.checkCity(city.getCityName());
        if (!isHave) {
            boolean isSuccess = adminDAO.addCity(city.getCityName());
            if (isSuccess) {
                addActionMessage("城市添加成功!");  //todo
                return SUCCESS;
            } else {
                addActionError("城市添加失败,请重新选择!");
            }
        }else {
            addActionError("该城市已被添加,请重新选择!");
        }
        return "fail";
    }
}
