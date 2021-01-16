package com.example.animalsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements AnimalAdapter.MyClickInterface{
    RecyclerView recyclerView;
    ArrayList<Animal> animals;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        animals = new ArrayList<>();

        animals.add(new Animal("Ara",R.drawable.ara));
        animals.add(new Animal("Cat",R.drawable.cat));
        animals.add(new Animal("Deer",R.drawable.deer));
        animals.add(new Animal("Elephant",R.drawable.elephant));
        animals.add(new Animal("Hedgehog",R.drawable.hedgehog));
        animals.add(new Animal("Horse",R.drawable.horse));
        animals.add(new Animal("Lion",R.drawable.lion));
        animals.add(new Animal("Mammal",R.drawable.mammal));
        animals.add(new Animal("Pug",R.drawable.pug));
        animals.add(new Animal("Zebra",R.drawable.zebra));

        AnimalAdapter animalAdapter = new AnimalAdapter(animals, this, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(animalAdapter);
    }

    @Override
    public void onItemClick(int positionOfTheAnimal) {
        String animalName = animals.get(positionOfTheAnimal).getName();
        int animalImage = animals.get(positionOfTheAnimal).getImg();
        intent = new Intent(MainActivity.this, ShowInfo.class);
        intent.putExtra("animalName", animalName);
        intent.putExtra("animalImg", animalImage);
        startActivity(intent);
    }
}