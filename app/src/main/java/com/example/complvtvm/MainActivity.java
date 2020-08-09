package com.example.complvtvm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewMaestro;
    TextView textViewGuerrero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewMaestro = findViewById(R.id.id_maestro);
        textViewGuerrero = findViewById(R.id.id_guerrero);

        Fecha fecha = new Fecha();
        fecha.setHora("22:22");
        String json = fecha.toJson();
        Log.i("json","mi json es: "+json);
    }

    public void clickGuerrero (View v){
        Intent intent = new Intent(this,ListGuerreroActivity.class);
        startActivity(intent);
    }

    public void homeCarmelo (View v){
        Intent intent = new Intent(this, HomeCarmeloActivity.class);
        startActivity(intent);
    }
}
