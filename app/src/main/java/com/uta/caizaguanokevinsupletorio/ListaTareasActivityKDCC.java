package com.uta.caizaguanokevinsupletorio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class ListaTareasActivityKDCC extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    TabItem tab1,tab2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_tareas_kdcc);
        tabLayout = findViewById(R.id.tabbussi);
        viewPager = findViewById(R.id.viewpager);
        tab1 = findViewById(R.id.tabpersonal);
        tab2 = findViewById(R.id.tabbussi);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menukdcc,menu);
        return super.onCreateOptionsMenu(menu);
    }
}