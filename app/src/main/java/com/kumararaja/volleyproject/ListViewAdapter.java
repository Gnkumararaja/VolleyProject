package com.kumararaja.volleyproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter {

    private List<ModelClass> modelList;
    private Context mCntx;


    public ListViewAdapter(List<ModelClass>modell,Context mContx){
        super(mContx,R.layout.list_items,modell);
        this.modelList=modell;
        this.mCntx=mContx;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater=LayoutInflater.from(mCntx);

        View listViewItem=inflater.inflate(R.layout.list_items,null,true);
        TextView txtViewName=listViewItem.findViewById(R.id.textViewName);
        TextView txtViewImageUrl=listViewItem.findViewById(R.id.textViewImageUrl);

        ModelClass modelClass=modelList.get(position);

        txtViewName.setText(modelClass.getName());
        txtViewImageUrl.setText(modelClass.getImageurl());

        return listViewItem;

    }
}
