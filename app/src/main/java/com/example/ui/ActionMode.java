package com.example.ui;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;



public class ActionMode extends AppCompatActivity {
    private ListView listView;
    private List<Number> numberList = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        this.setTitle("ActionMode");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actionmode_layout);
        initNumber();
        NumberAdapter adapter = new NumberAdapter(ActionMode.this,R.layout.number_layout,numberList);
        listView = (ListView) findViewById(R.id.list_view2);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public boolean onCreateActionMode(android.view.ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.actionmode, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(android.view.ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(android.view.ActionMode mode, MenuItem item) {
                mode.finish();
                return false;
            }

            @Override
            public void onDestroyActionMode(android.view.ActionMode mode) {

            }

            @Override
            public void onItemCheckedStateChanged(android.view.ActionMode mode, int position, long id, boolean checked) {
                mode.setTitle(listView.getCheckedItemCount()+" selected");
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

            }
        });
    }

    private void initNumber(){
        for(int i=0;i<2;i++){
            Number one = new Number("One",R.mipmap.ic_launcher);
            numberList.add(one);
            Number two = new Number("Two",R.mipmap.ic_launcher);
            numberList.add(two);
            Number three = new Number("Three",R.mipmap.ic_launcher);
            numberList.add(three);
            Number four = new Number("four",R.mipmap.ic_launcher);
            numberList.add(four);
            Number five = new Number("five",R.mipmap.ic_launcher);
            numberList.add(five);
        }
    }
}
