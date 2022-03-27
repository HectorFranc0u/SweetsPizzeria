package com.example.pizzeria;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    CheckBox cbfresas,cbchocolate,cbbanana,cbmalvaviscos,cbkiwi,cbmango,cbuvas;
    RadioButton rbpersonal, rbmediana, rbfamiliar;
    EditText etnombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnombre = (EditText) findViewById(R.id.edtxtNombre);

        rbpersonal = (RadioButton) findViewById(R.id.rbpersonal);
        rbmediana = (RadioButton) findViewById(R.id.rbMediana);
        rbfamiliar = (RadioButton) findViewById(R.id.rbfamiliar);

        cbfresas = (CheckBox) findViewById(R.id.cbfresas);
        cbchocolate = (CheckBox) findViewById(R.id.cbchocolate);
        cbbanana = (CheckBox) findViewById(R.id.cbbanana);
        cbmalvaviscos = (CheckBox) findViewById(R.id.cbmalvaviscos);
        cbkiwi = (CheckBox) findViewById(R.id.cbkiwi);
        cbmango = (CheckBox) findViewById(R.id.cbmango);
        cbuvas = (CheckBox) findViewById(R.id.cbuvas);

        Button btn = findViewById(R.id.btnenviar);

        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                ordenar();
            }
        });
    }

    public void ordenar(){

        String pizzasize = "";
        String ing = "";
        Double total = 0.00;

        if (cbfresas.isChecked()){
            ing+="fresas $1.50 \n";
            total+= 1.50;
        }
        if (cbchocolate.isChecked()){
            ing+="chocolates $2.50 \n";
            total += 2.50;
        }
        if (cbbanana.isChecked()){
            ing+="bananas $1.50 \n";
            total+=1.50;
        }
        if (cbmalvaviscos.isChecked()){
            ing+="malvaviscos $2.50 \n";
            total+=2.50;
        }
        if (cbkiwi.isChecked()){
            ing+="kiwi $2.00 \n";
            total+=2.00;
        }
        if (cbmango.isChecked()){
            ing+="mango $2.00 \n";
            total+=2.00;
        }
        if (cbuvas.isChecked()){
            ing+="uvas $1.50 \n";
            total+=1.50;
        }

        if(rbpersonal.isChecked()){
            pizzasize += "Personal ";
            total += 5.00;
        }
        else if(rbmediana.isChecked()){
            pizzasize += "Mediana ";
            total += 10.00;
        }
        else if(rbfamiliar.isChecked()){
            pizzasize += "Familiar ";
            total += 15.00;
        }

        Intent i = new Intent(MainActivity.this, MainActivity2.class);
        i.putExtra("cliente", String.valueOf(etnombre.getText()));
        i.putExtra("size", pizzasize);
        i.putExtra("total", total.toString());
        i.putExtra("ing", ing);
        startActivity(i);

    }


}