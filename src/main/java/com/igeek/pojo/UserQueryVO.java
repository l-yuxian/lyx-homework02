package com.igeek.pojo;

import java.util.List;

/**
 * 查询需求 ： 通过用户性别和姓名查询用户列表，且id值是15或20或25
 */
public class UserQueryVO {

    //通过用户性别和姓名查询用户列表
    private UserCustom userCustom;

    //id值是15或20或25
    private List<Integer> ids;

    public UserQueryVO() {
    }

    public UserQueryVO(UserCustom userCustom, List<Integer> ids) {
        this.userCustom = userCustom;
        this.ids = ids;
    }

    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "UserQueryVO{" +
                "userCustom=" + userCustom +
                ", ids=" + ids +
                '}';
    }
}
