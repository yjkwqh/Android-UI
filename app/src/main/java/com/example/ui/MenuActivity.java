package com.example.ui;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setTitle("XML定义菜单");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TextView textView =(TextView) findViewById(R.id.text);
        switch (item.getItemId()){
            case R.id.z1:
                textView.setTextSize(10);break;
            case R.id.z2:
                textView.setTextSize(16);break;
            case R.id.z3:
                textView.setTextSize(20);break;
            case R.id.y1:
                textView.setTextColor(Color.RED);break;
            case R.id.y2:
                textView.setTextColor(Color.BLACK);break;
            case R.id.p:
                Toast.makeText(this,"这是普通单击项",Toast.LENGTH_SHORT).show();
                break;
             default:
        }
        return true;
    }
}
