package com.example.animalsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowInfo extends AppCompatActivity {
    ImageView imgAnimal;
    TextView nameAnimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info);

        imgAnimal = findViewById(R.id.img_animal_src);
        nameAnimal = findViewById(R.id.animal_name);
        String animalName = getIntent().getStringExtra("animalName");
        int animalImg = getIntent().getIntExtra("animalImg", R.drawable.img_shape);
        nameAnimal.setText(animalName);
        imgAnimal.setImageResource(animalImg);
    }
}