package com.example.complvtvm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ListGuerreroActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView;
    ImageView imageViewMMA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_guerrero);
        imageView = findViewById(R.id.id_box);
        imageView.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this,BoxActivity.class);
        startActivity(intent);
    }

    public void onClickMMA(View v){
        Intent intent = new Intent(this, DojoActivity.class);
        startActivity(intent);
    }
}
