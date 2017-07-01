package com.tuan.Action.adminAction;

import com.opensymphony.xwork2.ActionSupport;
import com.tuan.DB.DAO.AdminDAO;
import com.tuan.DB.DAOImpl.AdminDAOImpl;

import java.util.List;

/** 展示所有还没有审核的团购记录
 * Created by Administrator on 2017/6/26.
 */
public class showAllReviewWithoutChheckAction extends ActionSupport{

    private List<String[]> reviewWithoutCheck;

    public List<String[]> getReviewWithoutCheck() {
        return reviewWithoutCheck;
    }

    public void setReviewWithoutCheck(List<String[]> reviewWithoutCheck) {
        this.reviewWithoutCheck = reviewWithoutCheck;
    }

    @Override
    public String execute() throws Exception{
        AdminDAO adminDAO = new AdminDAOImpl();
        reviewWithoutCheck = adminDAO.getAllReviewWithoutCheck();

        return SUCCESS;
    }
}
