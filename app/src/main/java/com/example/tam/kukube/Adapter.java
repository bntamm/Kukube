package com.example.tam.kukube;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tam on 2/28/2018.
 */

public class Adapter extends ArrayAdapter<String> {
    private Context ct;
    private ArrayList<String> arrayList;


    public Adapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        this.ct = context;
        this.arrayList = new ArrayList<>(objects);
    }


    //Kết nối layout và chuyển đổi chuỗi string thành màu sắc
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row = convertView;
        LayoutInflater inflater = (LayoutInflater) ct.getSystemService(ct.LAYOUT_INFLATER_SERVICE);
        row = inflater.inflate(R.layout.item_gridview , null);
        if(arrayList != null && arrayList.size() > 0){
            com.example.tam.kukube.textView a = (com.example.tam.kukube.textView) row.findViewById(R.id.item_gridview);

        a.setBackgroundColor(Color.parseColor(arrayList.get(position)));

        }
        return row;


    }
}
