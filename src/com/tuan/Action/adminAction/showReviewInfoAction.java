package com.tuan.Action.adminAction;

import com.opensymphony.xwork2.ActionSupport;
import com.tuan.DB.DAO.AdminDAO;
import com.tuan.DB.DAOImpl.AdminDAOImpl;
import com.tuan.DB.domain.Review;

/** 展示某条记录的详细信息
 * Created by Administrator on 2017/6/26.
 */
public class showReviewInfoAction extends ActionSupport{

    private Review review;
    private int reviewId;

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public int getReviewId() {

        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    @Override
    public String execute() throws Exception{
        AdminDAO adminDAO = new AdminDAOImpl();
        review = adminDAO.getReviewInfo(reviewId);
        System.out.println(review+ "ShowReviewInfoAction");
        return SUCCESS;
    }
}
