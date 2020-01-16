package com.example.adeligncia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

public class cadastrar extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        Button botao= (Button) findViewById(R.id.botaocadastrar);

        botao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText Nome = findViewById(R.id.Nome);
                EditText email = findViewById(R.id.mail);
                EditText Senha = findViewById(R.id.Senha);
                EditText repitasenha = findViewById(R.id.repitasenha);

                String nomeString = Nome.getText().toString();
                String emailString = email.getText().toString();
                String SenhaString = Senha.getText().toString();
                String repitasenhaString = repitasenha.getText().toString();

                if (nomeString.isEmpty() || emailString.isEmpty() || SenhaString.isEmpty() || repitasenhaString.isEmpty()) {
                    String resultado = "preeencha todos os campos";

                    Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

                }else{
                    if (SenhaString.equals(repitasenhaString)) {
                        String resultado = "Cadastrou";
                        Toast toast=Toast.makeText(getApplicationContext(),resultado,Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0,50);
                        toast.show();
                    } else {
                        String resultado = "as senhas não conferem";
                        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                    }



                }
            }
        });
    }
}
