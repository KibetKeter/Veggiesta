package com.example.veggiesta;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Market extends AppCompatActivity {

    RecyclerView recyclerview;

        String s1[];
        int s2[];
        int images[] = {R.drawable.ic_friedrice,R.drawable.ic_lentilsoup,R.drawable.ic_falafel,R.drawable.ic_vegetariantacos,R.drawable.ic_peanutnoodles
        , R.drawable.ic_vegsoup, R.drawable.ic_lassagna, R.drawable.ic_pumpkinsoup};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

//        recyclerview = findViewById(R.id.recyclerview);
//        s1 = getResources().getStringArray(R.array.Veggie_Meals);
//        s2 = getResources().getIntArray(R.array.Price);
//
//        MyAdapter myadapter = new MyAdapter(this, s1,images,s2);
//        recyclerview.setAdapter(myadapter);
//        recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }
}