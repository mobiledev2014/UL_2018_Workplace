package com.unilab.workplace.database.model;

/**
 * Created by c_jsbustamante on 11/7/2016.
 */
public class MainCatModel {

    String id;
    String selector_img;

    String description;

    public String getSelector_img() {
        return selector_img;
    }

    public void setSelector_img(String selector_img) {
        this.selector_img = selector_img;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MainCatModel{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", setSelector_img='" + selector_img + '\'' +
                '}';
    }
}
