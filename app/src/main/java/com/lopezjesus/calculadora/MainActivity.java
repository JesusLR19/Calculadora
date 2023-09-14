package com.lopezjesus.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity   {
    TextView tvResultado;
    Float numero1 = 0.0f, numero2 = 0.0f;
    String operador = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResultado = findViewById(R.id.tvResultado);
    }
    public void EscribirCero(View view) {
        String textoActual = tvResultado.getText().toString();
        if (textoActual.equals("0")) {
            return;
        } else {
            tvResultado.setText(textoActual + "0");
        }
    }
    public void EscribirUno(View view) {
        if (tvResultado.getText().toString().equals("0")){
            tvResultado.setText("0");
        }else{
            tvResultado.setText(tvResultado.getText() + "1");
        }
    }
    public void EscribirDos(View view) {
        if (tvResultado.getText().toString().equals("0")){
            tvResultado.setText("0");
        }else{
            tvResultado.setText(tvResultado.getText() + "2");
        }
    }
    public void EscribirTres(View view) {
        if (tvResultado.getText().toString().equals("0")) {
            tvResultado.setText("0");
        }else {
            tvResultado.setText(tvResultado.getText() + "3");
        }
    }
    public void EscribirCuatro(View view) {
        if (tvResultado.getText().toString().equals("0")) {
            tvResultado.setText("0");
        }else {
            tvResultado.setText(tvResultado.getText() + "4");
        }
    }
    public void EscribirCinco(View view) {
        if (tvResultado.getText().toString().equals("0")) {
            tvResultado.setText("0");
        }else {
            tvResultado.setText(tvResultado.getText() + "5");
        }
    }
    public void EscribirSeis(View view) {
        if (tvResultado.getText().toString().equals("0")) {
            tvResultado.setText("0");
        }else {
            tvResultado.setText(tvResultado.getText() + "6");
        }
    }
    public void EscribirSiete(View view) {
        if (tvResultado.getText().toString().equals("0")) {
            tvResultado.setText("0");
        }else {
            tvResultado.setText(tvResultado.getText() + "7");
        }
    }
    public void EscribirOcho(View view) {
        if (tvResultado.getText().toString().equals("0")) {
            tvResultado.setText("0");
        }else {
            tvResultado.setText(tvResultado.getText() + "8");
        }
    }
    public void EscribirNueve(View view) {
        if (tvResultado.getText().toString().equals("0")) {
            tvResultado.setText("0");
        }else {
            tvResultado.setText(tvResultado.getText() + "9");
        }
    }
    public void Punto(View view) {
            tvResultado.setText(tvResultado.getText() + ".");
    }
    public void ClearTv(View view) {
        tvResultado.setText("");
        numero1 = 0.0f;
        numero2 = 0.0f;
        operador = "";
    }
    public void Dividir(View view) {
        operador = "/";
        SaveOne(view);
    }
    public void Suma(View view) {
        operador = "+";
        SaveOne(view);
    }
    public void Multiplicar(View view) {
        operador = "*";
        SaveOne(view);
    }
    public void Resta(View view) {
        operador = "-";
        SaveOne(view);
    }
    public void BorrarDEL(View view) {
        if (tvResultado.getText() != ""){
            String text = tvResultado.getText().toString();
            tvResultado.setText(text.substring(0,text.length()-1));
        }else{
            return;
        }
    }
    public void SaveOne(View view){
        numero1 = Float.parseFloat(tvResultado.getText().toString());
        tvResultado.setText("");
    }
    public void Equals(View view) {
        numero2 = Float.parseFloat(tvResultado.getText().toString());
        Float resultado = 0.0f;
        if (operador == "+"){
            resultado = numero1+numero2;
            String resultadoStr = Float.toString(resultado);
            tvResultado.setText(resultadoStr);
            operador = "";
        }
        if (operador == "-"){
            resultado = numero1-numero2;
            String resultadoStr = Float.toString(resultado);
            tvResultado.setText(resultadoStr);
            operador = "";
        }
        if (operador == "/"){
            resultado = numero1/numero2;
            String resultadoStr = Float.toString(resultado);
            tvResultado.setText(resultadoStr);
            operador = "";
        }
        if (operador == "*"){
            resultado = numero1*numero2;
            String resultadoStr = Float.toString(resultado);
            tvResultado.setText(resultadoStr);
            operador = "";
        }
    }
}



