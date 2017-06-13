package com.feng.bean;

import com.feng.annotaion.Column;
import com.feng.annotaion.Table;

/**
 * Created by Fengunion on 2017/6/6.
 */
@Table(tableName = "t_article")
public class Article {
    @Column(type = "varchar(100)", field = "id", primaryKey = true)
    private String id;    //主键，采用UUID
    @Column(type = "varchar(100)", field = "header")
    private String header;//标题
    @Column(type = "varchar(60)", field = "name")
    private String name;  //文章名称
    @Column(type = "text", field = "content")
    private String content; //文章内容
    @Column(type = "varchar(30)", field = "author")
    private String author;     //作者
    @Column(type = "varchar(100)", field = "description")
    private String description;     //概要
    @Column(type = "int(1)", field = "is_published")
    private String isPublished;//是否发布 0 未发布  1 已删除
    @Column(type = "int(1)", field = "is_delete")
    private String isDelete;//是否删除  0 未删除  1 已删除
    @Column(type = "timestamp", field = "create_time")
    private String createTime; // 创建时间
    @Column(type = "timestamp", field = "update_time", defaultNull = false)
    private String updateTime;   //最后更新时间
    @Column(field = "user_id", type = "varchar(100)", defaultNull = false)
    private String userId;//作者id
    @Column(field = "category_id", type = "int(2)", defaultNull = false)
    private Integer categoryId;//分类ID

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", header='" + header + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", description=" + description +
                ", isPublished='" + isPublished + '\'' +
                ", isDelete='" + isDelete + '\'' +
                ", createTime=" + createTime +
                ", updateTime='" + updateTime + '\'' +
                ", userId='" + userId + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(String isPublished) {
        this.isPublished = isPublished;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}

