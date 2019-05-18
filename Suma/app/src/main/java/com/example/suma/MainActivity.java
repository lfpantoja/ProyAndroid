package com.example.suma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText campoValor1;
    EditText campoValor2;
    TextView etiValor;
    String mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoValor1 = (EditText)findViewById(R.id.txtValor1);
        campoValor2 = (EditText)findViewById(R.id.txtValor2);

        etiValor = (TextView) findViewById(R.id.etiValor);

        if(savedInstanceState != null){
            mensaje = savedInstanceState.getString("mensaje");
            etiValor.setText(String.valueOf(mensaje));
        }
    }

    public void evento(View view){
        switch (view.getId()){
            case R.id.btnSumar:
                Integer valor1  = Integer.parseInt(campoValor1.getText().toString());
                Integer valor2  = Integer.parseInt(campoValor2.getText().toString());
                Integer valor3 = valor1 + valor2;

                String valor = String.valueOf(valor3);
                etiValor.setText(valor);
                mensaje = valor;

                Toast.makeText(this,"El valor es: "+valor,Toast.LENGTH_LONG).show();

                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("mensaje", mensaje);
        super.onSaveInstanceState(outState);
    }
}
