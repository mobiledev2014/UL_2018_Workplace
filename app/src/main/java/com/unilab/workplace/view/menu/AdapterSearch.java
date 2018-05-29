package com.unilab.workplace.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.unilab.workplace.R;
import com.unilab.workplace.database.model.SearchModel;

import java.util.ArrayList;

import butterknife.ButterKnife;


public class AdapterSearch extends BaseAdapter {

    private ArrayList<SearchModel> searchModels;
    private LayoutInflater mInflater;

    public AdapterSearch(Context context, ArrayList<SearchModel> data) {

        mInflater = LayoutInflater.from(context);
        this.searchModels = data;
    }

    @Override
    public int getCount() {
        return searchModels.size();
    }

    @Override
    public SearchModel getItem(int position) {
        return searchModels.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    //TODO view
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        View row = convertView;
//        if (convertView == null) {
        if (convertView == null) {

            convertView = mInflater.inflate(R.layout.adapter_search, null);
            holder = new ViewHolder();
            holder.tv_sc_name = ButterKnife.findById(convertView, R.id.tv_search);
            holder.tv_content = ButterKnife.findById(convertView, R.id.tv_content);
            holder.tv_cat_id = ButterKnife.findById(convertView, R.id.tv_cat_id);
            holder.tv_title_desc = ButterKnife.findById(convertView, R.id.tv_title_desc);

            convertView.setTag(holder);

        } else {

            holder = (ViewHolder) convertView.getTag();

        }
        //populate
        holder.tv_sc_name.setText(getProperSubCatName(searchModels.get(position).getCat_id()));
        holder.tv_title_desc.setText(searchModels.get(position).getTitle_desc().replace("_", " "));
        holder.tv_content.setText(searchModels.get(position).getDescription());
        holder.tv_cat_id.setText(searchModels.get(position).getCat_id());

        return convertView;

    }

    static class ViewHolder {
        TextView tv_sc_name;
        TextView tv_content;
        TextView tv_cat_id;
        TextView tv_title_desc;


    }

    public String getProperSubCatName(String sub_cat_id) {
        //Log.e("test","test sub_cat_id:"+sub_cat_id);
        if(sub_cat_id.equals("No result/s found.")){
            sub_cat_id = "0";
        }

        int x = Integer.parseInt(sub_cat_id);
        String s;
        switch (x) {

            case 1:
                s = "Health and Sanitation";
                break;
            case 2:
                s = "Safety and Security";
                break;
            case 3:
                s = "Company Property and Property Rights";
                break;
            case 4:
                s = "Business and Workplace Conduct";
                break;
            case 5:
                s = "Productivity";
                break;
            case 6:
                s = "Handling Information";
                break;
            case 7:
                s = "Business and Transactional Integrity";
                break;
            case 8:
                s = "Unauthorized Activities";
                break;
            case 9:
                s = "Penalties";
                break;
            case 10:
                s = "Disciplinary Procedures";
                break;
            case 11:
                s = "The Divisional Disciplinary Committee";
                break;
            case 12:
                s = "The Employee Discipline Board";
                break;
            case 13:
                s = "Evidence Handling";
                break;
            case 14:
                s = "Administrative Hearing Process";
                break;
            case 15:
                s = "Confidentiality of information";
                break;
            case 16:
                s = "Legal Advice";
                break;
            case 17:
                s = "Enforcement of Penalties";
                break;
            case 18:
                s = "Others";
                break;
            case 19:
                s = "Grievance Handling Process";
                break;
            case 20:
                s = "Roles and Responsibilities";
                break;
            case 21:
                s = "Mediation Meeting";
                break;
            case 22:
                s = "Confidentiality of information";
                break;
            case 23:
                s = "Others";
                break;
            case 24:
                s = "Dangerous Drug-Free Workplace Policy";
                break;
            case 25:
                s = "Anti-Sexual Harassment Policy";
                break;
            case 26:
                s = "Policy on Use of Digitized Signatures";
                break;
            case 27:
                s = "Workplace Breastfeeding Policy";
                break;
            case 28:
                s = "How to use the code";
                break;
            case 29:
                s = "Policy on Business Conduct";
                break;
            default:
                s = "No result/s found.";
        }
        return s;
    }
}