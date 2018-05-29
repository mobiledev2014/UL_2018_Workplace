package com.unilab.workplace.database.model;

/**
 * Created by c_alraygon on 11/7/2016.
 */
public class SubCatModel {

    String id;
    String description;
    String main_cat_id;
    String title_sec_desc;
    String content_img;

    public String getMain_cat_id() {
        return main_cat_id;
    }

    public void setMain_cat_id(String main_cat_id) {
        this.main_cat_id = main_cat_id;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle_sec_desc() {
        return title_sec_desc;
    }

    public void setTitle_sec_desc(String title_sec_desc) {
        this.title_sec_desc = title_sec_desc;
    }

    public String getContent_img() {
        return content_img;
    }

    public void setContent_img(String content_img) {
        this.content_img = content_img;
    }
    @Override
    public String toString() {
        return "SubCatModel{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", title_sec_desc='" + title_sec_desc + '\'' +
                ", content_img='" + content_img + '\'' +
                ", main_cat_id='" + main_cat_id + '\'' +
                '}';
    }


}
