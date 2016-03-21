package com.edmund.qingniancaijun.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.edmund.qingniancaijun.Model.CategoryItem;
import com.edmund.qingniancaijun.R;

import java.util.List;

/**
 * Created by edmund on 2016/1/4.
 */
public class CategoryAdapter<T> extends ArrayAdapter<CategoryItem> {

    private static String default_backgroundColor = "#dcdcdc";
    private static String selected_backgroudColor = "#ffffff";

    private int mSelectedIndex = 0;
    public void setSelectedIndex(int index) {
        mSelectedIndex = index;
    }

    private List<CategoryItem> mDataSources ;
    private int mLayoutResource;

    public List<CategoryItem> getmDataSources(){
        return  mDataSources;
    }

    public CategoryAdapter(Context context, int resource, List<CategoryItem> objects) {

        super(context, resource, objects);
        mDataSources = objects;
        mLayoutResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CategoryItem item = mDataSources.get(position);
        if (convertView == null) {
            convertView = View.inflate(getContext(), mLayoutResource, null);
        }
        //View view = View.inflate(getContext(), mLayoutResource, null);

        TextView textView_name = (TextView) convertView.findViewById(R.id.category_name);
        textView_name.setText(item.getName());

        TextView textView_id = (TextView) convertView.findViewById(R.id.category_id);
        textView_id.setText(item.getID());

        View leftSlider = convertView.findViewById(R.id.category_item_leftslider);

        if(position == mSelectedIndex){
            leftSlider.setVisibility(View.GONE);
            convertView.setBackground(new ColorDrawable(Color.parseColor(selected_backgroudColor)));
        }else{
            leftSlider.setVisibility(View.VISIBLE);
            convertView.setBackground(new ColorDrawable(Color.parseColor(default_backgroundColor)));
        }

        return convertView;
    }
}
