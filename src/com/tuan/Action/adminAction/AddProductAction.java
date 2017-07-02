package com.tuan.Action.adminAction;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xpath.internal.SourceTree;
import com.tuan.DB.DAO.AdminDAO;
import com.tuan.DB.DAOImpl.AdminDAOImpl;
import com.tuan.DB.domain.Review;

/** 审核通过后添加新的商品信息
 * Created by Administrator on 2017/6/26.
 */
public class AddProductAction extends ActionSupport{

    private Review review;
    private int reviewId;
    private String result;
    private String reviewStatus; // 0-未审核  1-审核通过  2- 审核未通过

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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(String reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    @Override
    public void validate(){
        if (result.trim().length()==0){
            addActionError("审核结果不能为空!");
        }
    }

    @Override
    public String execute() throws Exception{

        System.out.println(reviewId);
        AdminDAO adminDAO = new AdminDAOImpl();

        review = adminDAO.getReviewInfo(reviewId);

        int new_reviewStatus = Integer.valueOf(reviewStatus);
        if (new_reviewStatus==1){
            review.setResult(result);
            boolean isSuccess = adminDAO.addProduct(review);
            if (isSuccess){
                // 更改审核状态。
                boolean isChange = adminDAO.changeReviewStatus(reviewId, new_reviewStatus);
                if(isChange){
                    addActionMessage("商品审核通过，已加入");
                    return SUCCESS;
                }
            }else {
                addActionError("数据存取出错");
                return "fail";
            }
        }
        else {
            addActionError("商品审核未通过.");
            return "fail";
        }
        addActionError("商品审核状态更改出错");
        return  "fail";
    }
}
