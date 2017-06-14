package com.feng.bean;

import com.feng.annotaion.Column;
import com.feng.annotaion.Table;

import java.util.Date;

/**
 * Created by Fengunion on 2017/6/6.
 */
@Table(tableName = "t_article")
public class Article {

    @Column(field = "id", type = "varchar(100)", primaryKey = true)
    private String id; //主键

    @Column(field = "header", type = "varchar(100)")
    private String header; //标题

    @Column(field = "name", type = "varchar(60)")
    private String name; //文章名称

    @Column(field = "content", type = "text")
    private String content; //文章内容

    @Column(field = "author", type = "varchar(30)")
    private String author; //作者

    @Column(field = "description", type = "varchar(100)")
    private String description; //概要

    @Column(field = "is_published", type = "int(1)")
    private Integer isPublished; //是否发布 0 未发布 1 发布

    @Column(field = "is_delete", type = "int(1)")
    private Integer isDelete;      //是否删除   0 未删除 1 已删除

    @Column(field = "create_time", type = "datetime")
    private Date createTime;//创建时间

    @Column(field = "update_time", type = "timestamp", defaultNull = false)
    private Date updateTime;//最后更新时间

    @Column(field = "user_id", type = "varchar(100)", defaultNull = false)
    private String userId;//作者id

    @Column(field = "category_id", type = "int(2)", defaultNull = false)
    private Integer categoryId;//分类ID

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

    public Integer getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(Integer isPublished) {
        this.isPublished = isPublished;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
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


    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", header='" + header + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", isPublished=" + isPublished +
                ", isDelete=" + isDelete +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", userId='" + userId + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }
}

