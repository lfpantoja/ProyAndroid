package com.example.lista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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


        list.add("China");
        list.add("Francia");
        list.add("Alemania");
        list.add("India");
        list.add("Rusia");
        list.add("Ecuador");

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
        switch (view.getId()){
            case R.id.btnSave:
                String valor = campoValor.getText().toString();

                Toast.makeText(this,"El valor es: "+valor,Toast.LENGTH_LONG).show();

                list.add(valor);


                break;

            case R.id.btnDelete:
                String valor1 = campoValor.getText().toString();

                //Toast.makeText(this,"El valor a eliminar es: "+valor1,Toast.LENGTH_LONG).show();
                try{
                    int index = list.indexOf(valor1);

                    Toast.makeText(this,"El valor a eliminar es: "+index,Toast.LENGTH_LONG).show();

                    list.remove(index);

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


                break;
        }
    }


}
