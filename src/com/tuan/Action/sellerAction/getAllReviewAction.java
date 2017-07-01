package com.tuan.Action.sellerAction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tuan.DB.DAO.SellerDAO;
import com.tuan.DB.DAO.UserDAO;
import com.tuan.DB.DAOImpl.SellerDAOImpl;
import com.tuan.DB.DAOImpl.UserDAOImpl;

import java.util.List;

/** 得到卖家所有的团购审核记录
 * Created by Administrator on 2017/6/26.
 */
public class getAllReviewAction extends ActionSupport {

    private List<String[]> reviews;

    public List<String[]> getReviews() {
        return reviews;
    }

    public void setReviews(List<String[]> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String execute() throws Exception{

        SellerDAO sellerDAO = new SellerDAOImpl();
        UserDAO userDAO = new UserDAOImpl();

        String username = ActionContext.getContext().getSession().get("username").toString();
        System.out.println(username + "GetAllReviewAction");
        int userId = userDAO.getUserIdByName(username);
        System.out.println(userId + "GetAllReviewAction");
        reviews = sellerDAO.showAllReviewProduct(userId);

        return SUCCESS;
    }
}
