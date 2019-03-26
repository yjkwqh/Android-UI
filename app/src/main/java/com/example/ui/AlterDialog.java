package com.example.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;

public class AlterDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setTitle("AlterDialog");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog builder = new AlertDialog.Builder(AlterDialog.this)
                        .setView(R.layout.dialog_layout)
                        .setNegativeButton("Cancel",null)
                        .setPositiveButton("Sign in",null)
                        .create();
                builder.show();
            }
        });


    }

}
