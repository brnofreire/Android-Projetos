package com.example.projeto_bruno.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.projeto_bruno.Adapter.ItemsAdapter;
import com.example.projeto_bruno.Domain.ItemsDomain;
import com.example.projeto_bruno.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapterPopular, adapterNew;
private RecyclerView recyclerViewPopular,  recyclerViewNew;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<ItemsDomain> ItemsArraylist=new ArrayList<>();

        ItemsArraylist.add(new ItemsDomain("Casa com uma vista linda", "Montes Claros, CA 94110", "Com dois quartos /1 suíte, \n" +
                " Amplo espaço aberto, com caracteríticas arquitetônicas \n" +
                " marcantes e acabamentos de alta qualidade. \n" +
                " Sinta-se inspirado pelo conjunto externo\n"+
                " que o visual moderno oferece.",2, 1, 841456, "pic1", true));
        ItemsArraylist.add(new ItemsDomain("Casa com uma vista linda", "Montes Claros, CA 94110", "Com dois quartos /1 suíte, \n" +
                " Amplo espaço aberto, com caracteríticas arquitetônicas \n" +
                " marcantes e acabamentos de alta qualidade. \n" +
                " Sinta-se inspirado pelo conjunto externo\n"+
                " que o visual moderno oferece.",3, 1, 654987, "pic2", false));
        ItemsArraylist.add(new ItemsDomain("Casa com uma vista linda", "Montes Claros, CA 94110", "Com dois quartos /1 suíte, \n" +
                " Amplo espaço aberto, com caracteríticas arquitetônicas \n" +
                " marcantes e acabamentos de alta qualidade. \n" +
                " Sinta-se inspirado pelo conjunto externo\n"+
                " que o visual moderno oferece.",3, 1, 841456, "pic1", true));

        recyclerViewPopular=findViewById(R.id.viewPopular);
        recyclerViewNew=findViewById(R.id.viewNew);

        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerViewNew.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));

        adapterNew=new ItemsAdapter(ItemsArraylist);
        adapterPopular=new ItemsAdapter(ItemsArraylist);

        recyclerViewNew.setAdapter(adapterNew);
        recyclerViewPopular.setAdapter(adapterPopular);
    }
}