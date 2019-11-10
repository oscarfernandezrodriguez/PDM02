package com.example.pdm02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Cliente extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
        Bundle bundle = getIntent().getExtras();
        TextView NombreT = (TextView) findViewById(R.id.TextoUsuario);
        ImageView Foto = (ImageView) findViewById(R.id.imageView);

        if ((bundle != null)) {
            String Nombre = bundle.getString("nombre");
            if (bundle.getString("visible") != null) {
                String Visibilidad = bundle.getString("visible");
                if (Visibilidad.equals("False")) {
                    View boton1 = findViewById(R.id.button2);
                    View boton2 = findViewById(R.id.button3);
                    View boton3 = findViewById(R.id.button4);
                    View boton4 = findViewById(R.id.button5);
                    boton1.setVisibility(View.GONE);
                    boton2.setVisibility(View.GONE);
                    boton3.setVisibility(View.GONE);
                    boton4.setVisibility(View.GONE);
                }
            }

            if (Nombre.equals("NomeB Apelido1B Apelido2B")) {
                Foto.setImageDrawable(getResources().getDrawable(R.drawable.mujer));
            } else {
                Foto.setImageDrawable(getResources().getDrawable(R.drawable.hombre));
            }


            NombreT.setText(Nombre);


        }

    }

    public void Fpedidos(View view) {
        Intent intent = new Intent(this, Fpedidos.class);
        intent.putExtra("nombre", "NomeA Apelido1A Apelido2A");
        startActivity(intent);
    }

    public void pedidos(View view) {
        Intent intent = new Intent(this, Pedidos.class);
        intent.putExtra("nombre", "NomeA Apelido1A Apelido2A");
        startActivity(intent);
    }

    public void compras(View view) {
        Intent intent = new Intent(this, Compras.class);
        intent.putExtra("nombre", "NomeA Apelido1A Apelido2A");
        startActivity(intent);
    }

    public void sair(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
