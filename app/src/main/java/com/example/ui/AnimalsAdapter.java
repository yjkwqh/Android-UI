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

public class AnimalsAdapter extends ArrayAdapter {
    private int resourceId;
    public AnimalsAdapter(@NonNull Context context, int resource, @NonNull List<Animals> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Animals animal = (Animals) getItem(position);
//        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
//        提高List的运行效率，利用convertView对布局进行缓存
         View view;
         ViewHolder viewHolder;
         if(convertView == null){
             view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
             viewHolder = new ViewHolder();
             viewHolder.animalsImage = (ImageView) view.findViewById(R.id.animals_image);
             viewHolder.animalsName = (TextView) view.findViewById(R.id.animals_name);
             view.setTag(viewHolder);
         }else{
             view = convertView;
             viewHolder = (ViewHolder) view.getTag();
         }
//        ImageView animalImage = (ImageView) view.findViewById(R.id.animals_image);
//        TextView animalName = (TextView) view.findViewById(R.id.animals_name);
//        animalImage.setImageResource(animal.getImagesId());
//        animalName.setText(animal.getName());
        viewHolder.animalsImage.setImageResource(animal.getImagesId());
         viewHolder.animalsName.setText(animal.getName());
        return view;
    }
    class ViewHolder{
        ImageView animalsImage;
        TextView animalsName;
    }
}
