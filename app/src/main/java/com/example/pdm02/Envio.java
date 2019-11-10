package com.example.pdm02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Envio extends AppCompatActivity {
    public String nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envio);
        Bundle bundle = getIntent().getExtras();
        this.nombre = bundle.getString("nombre");
    }
    public void sair(View view) {
        Intent intent = new Intent(this, Cliente.class);

        Bundle bundle = getIntent().getExtras();
        String categoria = bundle.getString("categoria");
        String producto = bundle.getString("producto");
        String cantidad = bundle.getString("cantidad");
        EditText direET= (EditText)findViewById(R.id.editText);
        String dire=direET.getText().toString();
        EditText ciudadET= (EditText)findViewById(R.id.editText2);
        String ciudad=ciudadET.getText().toString();
        EditText cpET= (EditText)findViewById(R.id.editText3);
        String cp=cpET.getText().toString();

        if(!ciudad.isEmpty() && !cp.isEmpty() && !dire.isEmpty()){
            Toast valido;
            valido = Toast.makeText(this, "",Toast.LENGTH_LONG);
            valido.setText("Pedido creado:\n"+"Categoria: "+categoria+"\nProducto: "+producto+"\nCantidad: "+cantidad+"\n\nDatos del Envio:\nDireccion: "+dire+"\nCiudad: "+ciudad+"\nCP: "+cp);
            valido.show();
            intent.putExtra("nombre", this.nombre);
            startActivity(intent);
        }else{
            Toast error;
            error = Toast.makeText(this, R.string.errorCampos,Toast.LENGTH_LONG);
            error.show();
        }

    }
}
