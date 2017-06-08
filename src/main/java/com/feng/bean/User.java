package com.feng.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Fengunion on 2017/4/19.
 */
public class User implements Serializable {
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", headerPic='" + headerPic + '\'' +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", isDelete=" + isDelete +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }

    private String id;    //主键，采用UUID

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String username;  //用户名
    private String password;  //密码
    private String headerPic; //头像
    private String email;     //电子邮箱
    private Integer sex;     //性别 0男 1女 3保密
    private String createTime;//创建时间
    private String updateTime;//最后更新时间
    private Integer isDelete; // 删除状态0未删除1删除
    private String address;   //地址
    private String telephone; //电话



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeaderPic() {
        return headerPic;
    }

    public void setHeaderPic(String headerPic) {
        this.headerPic = headerPic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
