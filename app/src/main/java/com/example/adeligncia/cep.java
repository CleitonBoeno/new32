package com.example.adeligncia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class cep extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cep);
        final EditText textCEP= findViewById(R.id.textCEP);
        final TextView textViewresposta= findViewById(R.id.textviewresposta);
        Button btnBuscarCep = findViewById(R.id.cep);
        btnBuscarCep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textCEP.getText().toString().length()> 0 && textCEP.getText().toString().equals("") && textCEP.getText().toString().length() == 8){
                    Log.i("Teste", "CEP válido");
                }
                HTTPService service = new HTTPService(textCEP.getText().toString());
                try {
                    CEPteste retorno = service.execute().get();
                    textViewresposta.setText(retorno.toString());
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
