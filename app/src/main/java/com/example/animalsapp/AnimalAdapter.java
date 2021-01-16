package com.example.animalsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

// <AnimalAdapter.AnimalRowHolder> is added to this class
// because in onBindViewHolder method we need to get value of AnimalRowHolder arguments
public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalRowHolder> {
    ArrayList<Animal> animalData;
    Context context;
    MyClickInterface onClickListener;

    public AnimalAdapter(ArrayList<Animal> animalData, Context context, MyClickInterface onClickListener) {
        this.animalData = animalData;
        this.context = context;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public AnimalRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Get context from one row layout
        View view = LayoutInflater.from(context).inflate(R.layout.animal_row, parent,false);
        // Return created new obj from inner class
        return new AnimalRowHolder(view);
    }

    // THis method show real information from arguments in AnimalRowHolder class
    @Override
    public void onBindViewHolder(@NonNull AnimalRowHolder holder, int position) {
        // position is id of the row. Array starts from 0, 1, 2 etc.
        holder.animalName.setText(animalData.get(position).getName());
        holder.animalImg.setImageResource(animalData.get(position).getImg());
    }

    // Size of data.
    @Override
    public int getItemCount() {
        return animalData.size();
    }

    class AnimalRowHolder extends RecyclerView.ViewHolder {
        TextView animalName;
        ImageView animalImg;

        public AnimalRowHolder(@NonNull View itemView) {
            super(itemView);

            animalName = itemView.findViewById(R.id.txt_animal_name);
            animalImg = itemView.findViewById(R.id.img_animal);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.onItemClick(getAdapterPosition());
                }
            });
        }
    }

    interface MyClickInterface {
        void onItemClick(int positionOfTheAnimal);
    }
}
