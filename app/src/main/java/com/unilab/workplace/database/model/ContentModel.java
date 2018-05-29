package com.unilab.workplace.database.model;

/**
 * Created by c_jsbustamante on 11/4/2016.
 */
public class ContentModel {

    String id;
    String title;
    String title_sec_id;

    String title_desc;
    String content_img_id;
    String sub_cat_id;
    String description;

    public String getTitle_desc() {
        return title_desc;
    }

    public void setTitle_desc(String title_desc) {
        this.title_desc = title_desc;
    }


    @Override
    public String toString() {
        return "ContentModel{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", title_sec_id='" + title_sec_id + '\'' +
                ", content_img_id='" + content_img_id + '\'' +
                ", sub_cat_id='" + sub_cat_id + '\'' +
                ", description='" + description + '\'' +
                ", title_desc='" + title_desc + '\'' +
                '}';
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle_sec_id() {
        return title_sec_id;
    }

    public void setTitle_sec_id(String title_sec_id) {
        this.title_sec_id = title_sec_id;
    }

    public String getContent_img_id() {
        return content_img_id;
    }

    public void setContent_img_id(String content_img_id) {
        this.content_img_id = content_img_id;
    }

    public String getSub_cat_id() {
        return sub_cat_id;
    }

    public void setSub_cat_id(String sub_cat_id) {
        this.sub_cat_id = sub_cat_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
