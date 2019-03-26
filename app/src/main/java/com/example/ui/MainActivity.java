package com.example.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button1,button2,button3,button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        button1 = findViewById(R.id.B1);
        button2 = findViewById(R.id.B2);
        button3 = findViewById(R.id.B3);
        button4 = findViewById(R.id.B4);
        button1.setOnClickListener(new myOnclick(1));
        button2.setOnClickListener(new myOnclick(2));
        button3.setOnClickListener(new myOnclick(3));
        button4.setOnClickListener(new myOnclick(4));
    }
    class myOnclick implements View.OnClickListener {
        private int id;
        public myOnclick(int id){
            this.id=id;
        }
        @Override
        public void onClick(View v) {

            Intent intent = new Intent();
            switch (id){
                case 1:
                    intent.setClass(MainActivity.this, AnimalsActivity.class);
                    break;
                case 2:
                    intent.setClass(MainActivity.this, AlterDialog.class);
                    break;
                case 3:
                    intent.setClass(MainActivity.this, MenuActivity.class);
                    break;
                case 4:
                    intent.setClass(MainActivity.this, ActionMode.class);
                    break;
            }

            MainActivity.this.startActivity(intent);
        }
    }

}
