package com.tuan.Action.sellerAction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tuan.DB.DAO.SellerDAO;
import com.tuan.DB.DAO.UserDAO;
import com.tuan.DB.DAOImpl.SellerDAOImpl;
import com.tuan.DB.DAOImpl.UserDAOImpl;
import com.tuan.DB.domain.Review;
import com.tuan.comonMethod.GenerateShortUuid;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/** 卖家发布商品
 * Created by Administrator on 2017/6/28.
 */
public class PublishProductAction extends ActionSupport{

    private Review review;
    private File upload;
    private String uploadFileName;
    private String uploadContentType;
    private String savePath;

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getUploadContentType() {
        return uploadContentType;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    private String getSavePath() {
        return ServletActionContext.getServletContext().getRealPath(savePath);
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    @Override
    public String execute() throws Exception{
        // 使用UUID重命名上传文件的文件名
        GenerateShortUuid generateShortUuid = new GenerateShortUuid();
        String newFileName =  generateShortUuid.generateShortUuid();

//        FileOutputStream fos = new FileOutputStream(getSavePath() + "\\" + getUploadFileName());
        FileOutputStream fos = new FileOutputStream(getSavePath() + "\\" + newFileName);
        FileInputStream fis = new FileInputStream(getUpload());
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = fis.read(buffer)) > 0){
            fos.write(buffer, 0, len );
        }

        System.out.println("文件保存成功");

        // 设置文件的保存路径
//        getReview().setProductPic("\\productPics\\"+getUploadFileName());
        getReview().setProductPic("\\productPics\\"+newFileName);
        System.out.println(review.getProductPic());

        // 设置商品的发布者id
        UserDAO userDAO = new UserDAOImpl();
        String username = ActionContext.getContext().getSession().get("username").toString();
        int userId = userDAO.getUserIdByName(username);
        getReview().setSellerId(userId);

        SellerDAO sellerDAO = new SellerDAOImpl();

        boolean isHaveProduct = sellerDAO.checkProduct(review.getProductName(), review.getProductArea(),
                review.getProductType());
        if(!isHaveProduct){
            boolean isHaveReview = sellerDAO.checkReview(review.getProductName(), review.getProductArea(),
                    review.getProductType());
            if(!isHaveReview){
                boolean isSuccess = sellerDAO.addProduct(review);
                if(isSuccess){
                    addActionMessage("该商品发布审核成功!");
                    return SUCCESS;
                }
            }
            else {
                addActionError("该商品已经送往审核.");
            }
        }
        else {
            addActionError("该商品已经上架!");
        }

        return "fail";

    }
}
