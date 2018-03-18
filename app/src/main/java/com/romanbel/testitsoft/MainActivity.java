package com.romanbel.testitsoft;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerAdapter mRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List <Сontact> list = setDataList();
        setUpRecyclerView(list);
    }

    private void setUpRecyclerView(List<Сontact> сontacts){
        mRecyclerAdapter = new RecyclerAdapter(сontacts);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mRecyclerAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    private List<Сontact> setDataList(){
        List <Сontact> list = new ArrayList<>();
        list.add(new Сontact("Антонов Антон ОченьДлинноеОтчиствоНуОченьДлинное","Какой то текст"));
        list.add(new Сontact("Белянин Роман Сергеевич","Какой то текст"));
        list.add(new Сontact("Василенко Антон Петрович","Какой то текст"));
        list.add(new Сontact("Грызлов Игорь Николаевич","Какой то текст"));
        list.add(new Сontact("Дмитриев Василий Андреевич","Какой то текст"));
        list.add(new Сontact("Еремеева Анна Петровна","Какой то текст"));
        list.add(new Сontact("Жевалова Инна Алексеевна","Какой то текст"));
        list.add(new Сontact("Знаменко Петр Андреевич","Какой то текст"));
        list.add(new Сontact("Иванов Иван Иванович","Какой то текст"));
        list.add(new Сontact("Круптман Екатерина Дмитриевна","Какой то текст"));
        list.add(new Сontact("Ломоносов Михаил Васильевич","Какой то текст"));
        return list;
    }
}
