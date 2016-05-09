package com.z3dd.conjugo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class VerbListActivity extends AppCompatActivity {

    static List<Verb> verbList;
    static Verb selectedVerb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verb_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    protected void onStart(){
        super.onStart();
        //TODO find more efficient way to update the list
        verbList = new ArrayList<>(VerbSetManager.getVerbSet());

        setContentView(R.layout.activity_verb_list);
        ArrayAdapter<Verb> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, verbList);
        ListView lv = (ListView)findViewById(android.R.id.list);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                goToEditVerbActivity(position);
            }
        });
    }

    public void onClickAdd(View view) {
        Intent intent = new Intent(this, AddVerbActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }

    private void goToEditVerbActivity(int listViewPosition) {
        VerbSetManager.setSelectedVerb(verbList.get(listViewPosition));
        Intent intent = new Intent(this, EditVerbActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }

}
