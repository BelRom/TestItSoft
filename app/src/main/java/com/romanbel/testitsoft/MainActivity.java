package com.romanbel.testitsoft;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import in.myinnos.alphabetsindexfastscrollrecycler.IndexFastScrollRecyclerView;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private IndexFastScrollRecyclerView mRecyclerView;
    private RecyclerAdapter mRecyclerAdapter;
    private List<Сontact> сontactList;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchView = findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(this);

        сontactList = DataHelper.setDataList();
        setUpRecyclerView(сontactList);
    }

    private void setUpRecyclerView(List<Сontact> сontacts){
        mRecyclerAdapter = new RecyclerAdapter(сontacts);
        mRecyclerView = (IndexFastScrollRecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mRecyclerAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        mRecyclerView.setIndexTextSize(12);
        mRecyclerView.setIndexBarColor("#33334c");
        mRecyclerView.setIndexBarCornerRadius(0);
        mRecyclerView.setIndexBarTransparentValue((float) 0.4);
        mRecyclerView.setIndexbarMargin(0);
        mRecyclerView.setIndexbarWidth(40);
        mRecyclerView.setPreviewPadding(0);
        mRecyclerView.setIndexBarTextColor("#FFFFFF");

        mRecyclerView.setIndexBarVisibility(true);
        mRecyclerView.setIndexbarHighLateTextColor("#33334c");
        mRecyclerView.setIndexBarHighLateTextVisibility(true);
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();
        List<Сontact> newList = new ArrayList<>();
        for(Сontact contact: сontactList){
            String name = contact.getName().toLowerCase();
            if (name.contains(newText)){
                newList.add(contact);
            }
        }
        mRecyclerAdapter.setFilter(newList);
        return true;
    }
}
