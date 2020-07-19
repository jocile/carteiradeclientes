package com.example.carteiradeclientes;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

public class ActMain extends AppCompatActivity {

    private RecyclerView lstDados;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        lstDados = (RecyclerView)findViewById(R.id.lstDados);

        /*
         fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
        }
        */
    }

        public void cadastrar(View view) {
        Intent it = new Intent(ActMain.this, ActCadCliente.class);
        startActivity(it);
    }

}