package com.example.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class NumberAdapter extends ArrayAdapter<Number> {
    private int resourceId;
    public NumberAdapter(@NonNull Context context, int resource, @NonNull List<Number> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Number number = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView numberImage=(ImageView)view.findViewById(R.id.num_image);
        TextView numberName=(TextView)view.findViewById(R.id.num_name);
        numberImage.setImageResource(number.getImageId());
        numberName.setText(number.getName());
        return view;
    }
}
