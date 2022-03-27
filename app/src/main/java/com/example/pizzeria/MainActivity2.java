package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btnback = findViewById(R.id.btnregresar);
        TextView txtgracias = findViewById(R.id.txtnombre);
        TextView txting = findViewById(R.id.txtIng);

        String nombre = getIntent().getStringExtra("cliente");
        txtgracias.setText(nombre);

        String ingredientes = getIntent().getStringExtra("ing");
        String size = getIntent().getStringExtra("size");
        String total = getIntent().getStringExtra("total");

        txting.setText("Los ingredientes de su orden son: \n \n" + ingredientes + "\n siendo una pizza de tamano: \n \n" + size + "\n\n con un costo total de: \n\n $" + total);


        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(i);
            }
        });


    }
}