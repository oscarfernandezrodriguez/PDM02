package com.example.pdm02;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

public class Compras extends AppCompatActivity {
    public String nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compras);
        ActionBar actionBar =getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        Intent intent = new Intent(this, Pedidos.class);
        Bundle bundle = getIntent().getExtras();
        this.nombre = bundle.getString("nombre");


    }
    @Override
    public boolean  onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void onBackPressed(){
        Intent atras = new Intent(this,Cliente.class);
        atras.putExtra("nombre", nombre);
        startActivity(atras);
        finish();
    }
}
