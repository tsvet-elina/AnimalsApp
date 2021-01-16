package com.example.animalsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Animal> animals;

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

        AnimalAdapter animalAdapter = new AnimalAdapter(animals, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(animalAdapter);
    }
}