package com.example.deber4;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText campoValor;
    TextView etiValor;
    String mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoValor = (EditText)findViewById(R.id.txtValor);

        etiValor = (TextView) findViewById(R.id.etiValor);

        if(savedInstanceState != null){
            mensaje = savedInstanceState.getString("mensaje");
            etiValor.setText(String.valueOf(mensaje));
        }
    }

    public void evento(View view){
        switch (view.getId()){
            case R.id.btnIngresar:
                String valor = campoValor.getText().toString();
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
