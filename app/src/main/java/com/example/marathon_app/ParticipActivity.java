package com.example.marathon_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;

public class ParticipActivity extends AppCompatActivity {

    ListView ls;
    String nom, prenom ;
    HashMap<String,String> map;
    Params p = new Params();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_particip);

        ls = findViewById(R.id.lst);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
             nom = extras.getString("nom");
             prenom = extras.getString("prenom");

             map= new HashMap<String, String>();
             map.put("nom",nom);
             map.put("prenom",prenom);

             p.values.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(ParticipActivity.this,p.values,R.layout.item,
                new String[]{"nom","prenom"},
                new int[]{R.id.nom,R.id.prenom}
                );

        ls.setAdapter(adapter);
    }
}