package com.lopezjesus.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    TextView resultado,solucion;
    MaterialButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    MaterialButton btnSuma, btnResta, btnMultip, btnDiv;
    MaterialButton btnClear, btnPunto, btnIgual, btnPar1, btnPar2,btnDEL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultado = findViewById(R.id.resultado);
        solucion = findViewById(R.id.solucion);
        assignId(btn0,R.id.btn0);
        assignId(btn1,R.id.btn1);
        assignId(btn2,R.id.btn2);
        assignId(btn3,R.id.btn3);
        assignId(btn4,R.id.btn4);
        assignId(btn5,R.id.btn5);
        assignId(btn6,R.id.btn6);
        assignId(btn7,R.id.btn7);
        assignId(btn8,R.id.btn8);
        assignId(btn9,R.id.btn9);
        assignId(btnSuma,R.id.btnSuma);
        assignId(btnResta,R.id.btnResta);
        assignId(btnMultip,R.id.btnMultip);
        assignId(btnDiv,R.id.btnDiv);
        assignId(btnClear,R.id.btnClear);
        assignId(btnPunto,R.id.btnPunto);
        assignId(btnIgual,R.id.btnIgual);
        assignId(btnPar1,R.id.btnPar1);
        assignId(btnPar2,R.id.btnPar2);
        assignId(btnDEL,R.id.btnDEL);

    }
    void assignId(MaterialButton btn,int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        MaterialButton button =(MaterialButton) view;
        String buttonText = button.getText().toString();
        String dataToCalculate = solucion.getText().toString();

        if(buttonText.equals("DEL")){
            solucion.setText("");
            resultado.setText("0");
            return;
        }
        if (buttonText.equals("=")){
            solucion.setText(resultado.getText());
            return;
        }
        if (buttonText.equals("C")){
            dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);
        }else {
            dataToCalculate = dataToCalculate +buttonText;
        }
        solucion.setText(dataToCalculate);

        String finalResult = getResult(dataToCalculate);
        if (!finalResult.equals("Err")){
            resultado.setText(finalResult);
        }

    }
    String getResult(String data){
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            String finalResult = context.evaluateString(scriptable,data,"Javascript",1,null).toString();
            return finalResult;
        }catch (Exception e){
            return "Err";
        }
    }
}