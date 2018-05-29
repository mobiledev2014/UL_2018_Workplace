package com.unilab.workplace.database.model;

/**
 * Created by c_alraygon on 11/8/2016.
 */
public class SearchModel {

    String id;
    String description;
    String cat_id;
    String title_desc;

    public String getTitle_desc() {
        return title_desc;
    }

    public void setTitle_desc(String title_desc) {
        this.title_desc = title_desc;
    }




//    public SubCatModel getSubCatModel() {
//        return subCatModel;
//    }
//
//    public void setSubCatModel(SubCatModel subCatModel) {
//        this.subCatModel = subCatModel;
//    }
//
//
//
//    public String getSub_cat_description() {
//        return sub_cat_description;
//    }
//
//    public void setSub_cat_description(String sub_cat_description) {
//        this.sub_cat_description = sub_cat_description;
//    }



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

    public String getCat_id() {
        return cat_id;
    }

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
    }

    @Override
    public String toString() {
        return "SearchModel{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", cat_id='" + cat_id + '\'' +
                '}';
    }

}
