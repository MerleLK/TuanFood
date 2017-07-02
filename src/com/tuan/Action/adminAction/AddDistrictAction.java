package com.tuan.Action.adminAction;

import com.opensymphony.xwork2.ActionSupport;
import com.tuan.DB.DAO.AdminDAO;
import com.tuan.DB.DAOImpl.AdminDAOImpl;

import java.util.List;

/** Add District Action
 * Created by Administrator on 2017/6/25.
 */
public class AddDistrictAction extends ActionSupport{

    private String city;
    private String districtName;


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    @Override
    public void validate(){
        if (districtName.trim().length() ==0){
            addFieldError("districtName", "地区名称不能为空");
        }
    }

    @Override
    public String execute() throws Exception{
        AdminDAO adminDAO = new AdminDAOImpl();

        boolean isHave = adminDAO.checkDistrict(Integer.valueOf(city), districtName);
        if (!isHave){
            boolean isSuccess = adminDAO.addDistrict(Integer.valueOf(city), districtName);
            if (isSuccess) {
                addActionMessage("您已经成功增加一个地区");
                return SUCCESS;
            }
            else {
                addActionError("数据库存取错误。");
            }
        }else {
            addActionError("该地区已经存在!");
        }
        return "fail";
    }

}
