package com.example.leorss.calculoimc;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView resultado1, resultado2, resultado3, resultado4;
    double imc, pesoIdeal, pesoMinimo, pesoMaximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button calcular = (Button) findViewById(R.id.bCalcular);

        resultado1 = (TextView) findViewById(R.id.tvResultado1);
        resultado2 = (TextView) findViewById(R.id.tvResultado2);
        resultado3 = (TextView) findViewById(R.id.tvResultado3);
        resultado4 = (TextView) findViewById(R.id.tvResultado4);
    }

    public void calcularIMC(View botaoCalcular) {

        EditText altura = (EditText) findViewById(R.id.etAltura);
        EditText peso = (EditText) findViewById(R.id.etPeso);

        if ((altura.getText().toString().isEmpty()) ||
                ((peso.getText().toString().isEmpty()))) {

            Toast toast = Toast.makeText(getApplicationContext(), "Digite Peso e Altura", Toast.LENGTH_SHORT);
            toast.show();

        } else {

            double valorAltura = Double.parseDouble(altura.getText().toString());
            double valorPeso = Double.parseDouble(peso.getText().toString());

            if ((valorAltura < 1) || (valorAltura > 3)) {

                Toast toast = Toast.makeText(getApplicationContext(), "Altura invalida", Toast.LENGTH_SHORT);
                toast.show();

            } else {
                imc = valorPeso / (valorAltura * valorAltura);
                pesoIdeal = 0.75 * ((valorAltura * 100) - 150) + 50;

                pesoMinimo = (valorAltura * valorAltura) * 19;
                pesoMaximo = (valorAltura * valorAltura) * 25;

                resultadoIMC();
            }
        }

    }

    final void resultadoIMC(){

        resultado2.setText("IMC = " + String.format("%.2f", imc));
        resultado3.setText("Peso Ideal = " + String.format("%.2f", pesoIdeal));
        resultado4.setText("Peso entre "   + String.format("%.2f", pesoMinimo) +
                                   " e "   + String.format("%.2f", pesoMaximo));

        if (imc <= 12)
            resultado1.setText("Limite Inferior Sobrevivencia");
        else
        if (imc <= 15)
            resultado1.setText("Magreza Extrema");
        else
        if (imc <= 19)
            resultado1.setText("Abaixo do Peso");
        else
        if (imc <= 25)
            resultado1.setText("Peso ideal");
        else
        if (imc <= 30)
           resultado1.setText("Acima do Peso");
        else
        if (imc <= 35)
            resultado1.setText("Obesidade Leve");
        else
        if (imc <= 40)
            resultado1.setText("Obesidade");
        else
            resultado1.setText("Obesidade Morbida");

    }
}