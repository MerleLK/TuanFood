package com.tuan.Action.sellerAction;

import com.opensymphony.xwork2.ActionSupport;
import com.tuan.DB.DAO.SellerDAO;
import com.tuan.DB.DAOImpl.SellerDAOImpl;

import java.util.HashMap;

/** 得到系统内部的地区列表和美食类型列表
 * Created by Administrator on 2017/6/26.
 */
public class getDistrictTypeAction extends ActionSupport{

    private HashMap<String, String> districts;
    private HashMap<String, String> types;

    public HashMap<String, String> getTypes() {
        return types;
    }

    public void setTypes(HashMap<String, String> types) {
        this.types = types;
    }

    public HashMap<String, String> getDistricts() {
        return districts;
    }

    public void setDistricts(HashMap<String, String> districts) {
        this.districts = districts;
    }

    @Override
    public String execute() throws Exception{

        SellerDAO sellerDAO = new SellerDAOImpl();

        districts = sellerDAO.getAllArea();

        types = sellerDAO.getAllFoodType();

        return SUCCESS;
    }

}
