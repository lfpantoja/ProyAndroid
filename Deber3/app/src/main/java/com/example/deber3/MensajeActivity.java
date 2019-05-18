package com.example.deber3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MensajeActivity extends AppCompatActivity {

    TextView msj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);

        msj=(TextView) findViewById(R.id.txtValorMsj);
        Bundle miBundle = this.getIntent().getExtras();

        if(miBundle!=null){
            String valor = miBundle.getString("valor");
            msj.setText(valor);
        }
    }

    public void onClick(View view) {
        finish();
    }
}
