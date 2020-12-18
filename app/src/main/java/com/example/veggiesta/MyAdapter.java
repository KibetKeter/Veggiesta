package com.example.veggiesta;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{
    String data1[];
    int img[];
    Context context;
    int Price[];

    public MyAdapter(Context ct, String s1[], int images[], int s2[])
        {
            context = ct;
            data1 = s1;
            img = images;
            Price = s2;
        }
    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull MyAdapter.MyViewHolder holder, int position) {
        holder.mytext1.setText(data1[position]);
        holder.mytext2.setText(String.valueOf(Price[position]));
        holder.myImage.setImageResource(img[position]);
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
        {
            TextView mytext1;
            TextView mytext2;
            ImageView myImage;

            public MyViewHolder(@NonNull View itemView)
                {
                    super(itemView);
                    mytext1 = itemView.findViewById(R.id.foodname);
                    mytext2 = itemView.findViewById(R.id.price);
                    myImage = itemView.findViewById(R.id.foodpicture);
                }
        }
}
