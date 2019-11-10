package com.example.pdm02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void logueo(View view) {
        Intent intent = new Intent(this, Cliente.class);
        EditText usuarioET= (EditText)findViewById(R.id.Cusuario);
        String usuario=usuarioET.getText().toString();
        EditText passwordET= (EditText)findViewById(R.id.Cpasword);
        String password=passwordET.getText().toString();

        if(usuario.equals("admin") && password.equals("abc123.")){
            intent.putExtra("nombre", "NomeB Apelido1B Apelido2B");
            intent.putExtra("visible", "False");
            startActivity(intent);
        }else if(usuario.equals("cliente1") && password.equals("abc123.")){
            intent.putExtra("nombre", "NomeA Apelido1A Apelido2A");
            intent.putExtra("visible", "True");
            startActivity(intent);
        }else{
            Toast error;
            error = Toast.makeText(this, R.string.error,Toast.LENGTH_LONG);
            error.show();
        }


    }

}
