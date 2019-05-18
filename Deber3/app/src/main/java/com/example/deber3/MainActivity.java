package com.example.deber3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText campoValor;
    TextView etiValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoValor = (EditText)findViewById(R.id.txtValor);
        etiValor = (TextView) findViewById(R.id.etiValor);

    }

    public void evento(View view){
        switch (view.getId()){
            case R.id.btnIngresar:
                String valor = campoValor.getText().toString();
                etiValor.setText(valor);

                Toast.makeText(this,"El valor es: "+valor,Toast.LENGTH_LONG).show();

                break;

            case R.id.btnenviar:
                Intent miIntent = new Intent(MainActivity.this,MensajeActivity.class);

                Bundle miBundle = new Bundle();
                miBundle.putString("valor",campoValor.getText().toString());

                miIntent.putExtras(miBundle);

                startActivity(miIntent);

                break;
        }
    }
}
