package com.example.duet_app;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class home_page extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private List<Image>imageList;
    private ImageAdapter adapter;

//    BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
//bottomNavigationView.inflateMenu(R.menu.bottom_menu);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_page);

        viewPager2=findViewById(R.id.viewpager2);
        imageList = new ArrayList<>();

        imageList.add(new Image(R.drawable.sample1));
        imageList.add(new Image(R.drawable.sample2));
        imageList.add(new Image(R.drawable.sample3));
        imageList.add(new Image(R.drawable.sample4));
        imageList.add(new Image(R.drawable.sample5));
        imageList.add(new Image(R.drawable.sample6));
        imageList.add(new Image(R.drawable.sample7));
        imageList.add(new Image(R.drawable.sample8));
        imageList.add(new Image(R.drawable.sample9));


        adapter=new ImageAdapter(imageList,viewPager2);
        viewPager2.setAdapter(adapter);

        viewPager2.setOffscreenPageLimit(3);
        viewPager2.setClipChildren(false);
        viewPager2.setClipToPadding(false);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer transformer = new CompositePageTransformer();
        transformer.addTransformer(new MarginPageTransformer(250));
        transformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1-Math.abs(position);
                page.setScaleY(0.45f + r * 0.45f);
                page.setScaleX(0.51f + r * 0.55f);
            }
        });

        viewPager2.setPageTransformer(transformer);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        if (id==R.id.group){
            Toast.makeText(this,"Create a new group",Toast.LENGTH_SHORT).show();
        }
        if (id==R.id.broadcast){
            Toast.makeText(this,"Create a new broadcast",Toast.LENGTH_SHORT).show();
        }
        if (id==R.id.linked){
            Toast.makeText(this,"Check linked device",Toast.LENGTH_SHORT).show();
        }
        if (id==R.id.settings){
            Toast.makeText(this,"Go to setting",Toast.LENGTH_SHORT).show();
        }

        return true;

    }

    //    Toolbar toolbar= findViewById(R.id.toolbar);
//
//    @Override
//    public void setSupportActionBar(@Nullable Toolbar toolbar) {
//        super.setSupportActionBar(toolbar);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int id= item.getItemId();
//        if (id==R.id.group){
//            Toast.makeText(this,"Create a new group",Toast.LENGTH_SHORT).show();
//        }
//        if (id==R.id.broadcast){
//            Toast.makeText(this,"Create a new broadcast",Toast.LENGTH_SHORT).show();
//        }
//        if (id==R.id.linked){
//            Toast.makeText(this,"Chect linked device",Toast.LENGTH_SHORT).show();
//        }
//        if (id==R.id.settings){
//            Toast.makeText(this,"Go to setting",Toast.LENGTH_SHORT).show();
//        }
//
//        return true;
//    }
}