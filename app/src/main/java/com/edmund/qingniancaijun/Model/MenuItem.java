package com.edmund.qingniancaijun.Model;

/**
 * Created by edmund on 2016/1/6.
 */
public class MenuItem {

    private String mID;
    private String mName;
    private double mPrice;
    private double mPrimePrice;
    private boolean mIsBargain;
    private boolean mIsSellout;
    private String mImageUrl;
    private String mCategoryID;

    private String mCategoryName;//类名称，如果此值不为空，Item为类标头

    public String getmID() {
        return mID;
    }

    public String getmName() {
        return mName;
    }

    public double getmPrice() {
        return mPrice;
    }

    public double getmPrimePrice() {
        return mPrimePrice;
    }

    public boolean getmIsBargain() {
        return mIsBargain;
    }

    public boolean getmIsSellout() {
        return mIsSellout;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public String getmCategoryID() {
        return mCategoryID;
    }

    public String getmCategoryName(){
        return mCategoryName;
    }

    public MenuItem(String id, String name, double price, double primeprice, boolean isbargain,
                    boolean isSellout, String imageurl, String categoryid) {
        this.mID = id;
        this.mName = name;
        this.mPrice = price;
        this.mPrimePrice = primeprice;
        this.mIsBargain = isbargain;
        this.mIsSellout = isSellout;
        this.mImageUrl = imageurl;
        this.mCategoryID = categoryid;
    }

    public MenuItem(String categoryName, String categoryid) {
        this.mCategoryName = categoryName;
        this.mCategoryID = categoryid;
    }

}
