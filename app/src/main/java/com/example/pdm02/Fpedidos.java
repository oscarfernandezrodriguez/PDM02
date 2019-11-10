package com.example.pdm02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class Fpedidos extends AppCompatActivity {
    public String nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fpedidos);
        Bundle bundle = getIntent().getExtras();
        if ((bundle != null)) {
            this.nombre = bundle.getString("nombre");
        }
        final Spinner categoriasS = (Spinner) findViewById(R.id.spinner);


        categoriasS.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                  @Override
                                                  public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                      Spinner productoS = (Spinner) findViewById(R.id.spinner2);
                                                      String categoria = categoriasS.getSelectedItem().toString();
                                                      if (categoria.equals("Informática")) {
                                                          ArrayAdapter<String> comboAdapter = new ArrayAdapter<String>(Fpedidos.this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.Producto1));

                                                          productoS.setAdapter(comboAdapter);
                                                      } else if (categoria.equals("Electrónica")) {
                                                          ArrayAdapter<String> comboAdapter = new ArrayAdapter<String>(Fpedidos.this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.Producto2));

                                                          productoS.setAdapter(comboAdapter);
                                                      } else {
                                                          ArrayAdapter<String> comboAdapter = new ArrayAdapter<String>(Fpedidos.this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.Producto3));

                                                          productoS.setAdapter(comboAdapter);
                                                      }

                                                  }

                                                  @Override
                                                  public void onNothingSelected(AdapterView<?> parent) {

                                                  }
                                              }


        );

    }

    public void Pedir(View view) {
        Intent intent = new Intent(this, Envio.class);
        Spinner categoriasS = (Spinner) findViewById(R.id.spinner);
        Spinner productoS = (Spinner) findViewById(R.id.spinner2);
        Spinner cantidadS = (Spinner) findViewById(R.id.spinner3);
        String categoria = categoriasS.getSelectedItem().toString();
        String producto = productoS.getSelectedItem().toString();
        String cantidad = cantidadS.getSelectedItem().toString();
        intent.putExtra("categoria", categoria);
        intent.putExtra("producto", producto);
        intent.putExtra("cantidad", cantidad);
        intent.putExtra("nombre", this.nombre);
        startActivity(intent);

    }
}
