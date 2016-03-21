package com.edmund.qingniancaijun.Model;

/**
 * Created by edmund on 2016/1/4.
 */
public class CategoryItem {

    private String ID;
    private String Name;

    public String getID(){
        return ID;
    }

    public String getName(){
        return Name;
    }

    public CategoryItem(String id, String name) {
        this.ID = id;
        this.Name = name;
    }
}
