package com.example.ui;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnimalsActivity extends AppCompatActivity {
//    private List<Animals> animalsList = new ArrayList<>();
    private   List<Map<String, Object>> listItems;
    private String[] names = new String[]
        { "Lion", "Tiger", "Monkey", "Dog","Cat","Elephant"};
    private int[] imageIds = new int[]
            { R.drawable.lion,R.drawable.tiger , R.drawable.monkey,
                    R.drawable.dog , R.drawable.cat,R.drawable.elephant};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        this.setTitle("Android ListView");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++)
        {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("animalName", names[i]);
            listItem.put("image", imageIds[i]);
            listItems.add(listItem);
        }
        // 创建一个SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems,
                R.layout.animals_layout,
                new String[] {  "animalName", "image"},
                new int[] { R.id.animals_name, R.id.animals_image });
//        initAnimals();
//        AnimalsAdapter adapter = new AnimalsAdapter(AnimalsActivity.this,R.layout.animals_layout,animalsList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(AnimalsActivity.this,names[position],Toast.LENGTH_SHORT).show();
//                Animals animals = (Animals) listItems.get(position);
//                Toast.makeText(AnimalsActivity.this,animals.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }


//    private void initAnimals(){
//        for(int i=0;i<2;i++){
//            Animals lion = new Animals("Lion",R.drawable.lion);
//            animalsList.add(lion);
//            Animals tiger = new Animals("Tiger",R.drawable.tiger);
//            animalsList.add(tiger);
//            Animals monkey = new Animals("Monkey",R.drawable.monkey);
//            animalsList.add(monkey);
//            Animals dog = new Animals("Dog",R.drawable.dog);
//            animalsList.add(dog);
//            Animals cat = new Animals("Cat",R.drawable.cat);
//            animalsList.add(cat);
//            Animals elephant = new Animals("Elephant",R.drawable.elephant);
//            animalsList.add(elephant);
//        }
//    }
}
