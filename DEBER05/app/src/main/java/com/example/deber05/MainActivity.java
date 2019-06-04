package com.example.deber05;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> list = new ArrayList<>();
    EditText campoValor;
    TextView etiValor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = this.getSharedPreferences("Fruit_names", Context.MODE_PRIVATE);
        //list.add("China");
//        list.add("Francia");
//        list.add("Alemania");

        try {
            list = (List<String>) ObjectSerializer.deserialize(sharedPreferences.getString("list",ObjectSerializer.serialize(new ArrayList<>())));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> storeData = new ArrayList<>();

        try {
            storeData = (ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("list",ObjectSerializer.serialize(new ArrayList<>())));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(list.size()<1){
            Toast.makeText(this,"No existen registros",Toast.LENGTH_LONG).show();
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        MyAdapter myAdapter = new MyAdapter(list);
        recyclerView.setAdapter(myAdapter);

        campoValor = (EditText)findViewById(R.id.campoValor);
        etiValor = (TextView) findViewById(R.id.etiValor);

    }

    public void evento(View view){
        SharedPreferences sharedPreferences = this.getSharedPreferences("Fruit_names", Context.MODE_PRIVATE);
        switch (view.getId()){
            case R.id.btnSave:
                String valor = campoValor.getText().toString();

                Toast.makeText(this,"El valor es: "+valor,Toast.LENGTH_LONG).show();


                try {

                    list.add(valor);
                    sharedPreferences.edit().putString("list",ObjectSerializer.serialize((Serializable) list)).apply();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    list = (List<String>) ObjectSerializer.deserialize(sharedPreferences.getString("list",ObjectSerializer.serialize(new ArrayList<>())));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                RecyclerView recyclerView1 = findViewById(R.id.recyclerView);
                recyclerView1.setHasFixedSize(true);

                LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this);
                linearLayoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView1.setLayoutManager(linearLayoutManager1);

                MyAdapter myAdapter1 = new MyAdapter(list);
                recyclerView1.setAdapter(myAdapter1);

                campoValor.setText("");
                break;

            case R.id.btnDelete:
                String valor1 = campoValor.getText().toString();

                //Toast.makeText(this,"El valor a eliminar es: "+valor1,Toast.LENGTH_LONG).show();
                try{
                    int index = list.indexOf(valor1);

                    Toast.makeText(this,"El valor a eliminar es: "+valor1,Toast.LENGTH_LONG).show();

                    try {
                        list.remove(index);
                        sharedPreferences.edit().putString("list",ObjectSerializer.serialize((Serializable) list)).apply();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        list = (List<String>) ObjectSerializer.deserialize(sharedPreferences.getString("list",ObjectSerializer.serialize(new ArrayList<>())));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    RecyclerView recyclerView = findViewById(R.id.recyclerView);
                    recyclerView.setHasFixedSize(true);

                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    recyclerView.setLayoutManager(linearLayoutManager);

                    MyAdapter myAdapter = new MyAdapter(list);
                    recyclerView.setAdapter(myAdapter);
                }catch(Exception e){
                    Toast.makeText(this,"No encontrado",Toast.LENGTH_LONG).show();
                }

                campoValor.setText("");
                break;

            case R.id.btnSearch:
                String valor2 = campoValor.getText().toString();

                //Toast.makeText(this,"El valor a eliminar es: "+valor1,Toast.LENGTH_LONG).show();
                try{
                    int index = list.indexOf(valor2);
                    if(list.contains(valor2)== true){
                        Toast.makeText(this,"El valor: '"+valor2 + "' si existe",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(this,"El valor: '"+valor2 + "' no existe",Toast.LENGTH_LONG).show();
                    }


                }catch(Exception e){
                    Toast.makeText(this,"No encontrado el valor: "+valor2,Toast.LENGTH_LONG).show();
                }
                campoValor.setText("");
                break;
        }
    }


}
