package com.example.kriapps;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
//
//import javax.script.ScriptEngineManager;
//import javax.script.ScriptEngine;
//import javax.script.ScriptException;

import androidx.appcompat.app.AppCompatActivity;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptableObject;

public class CalculatorActivity extends AppCompatActivity {
    public TextView secOutput;
    public TextView mainOutput;
    public Button allClear;
    public Button clear;
    public Button leftBracket;
    public Button rightBracket;
    public Button sin;
    public Button cos;
    public Button tan;
    public Button log;
    public Button ln;
    public Button fact;
    public Button square;
    public Button sqrt;
    public Button inv;
    public Button b0;
    public Button b9;
    public Button b8;
    public Button b7;
    public Button b6;
    public Button b5;
    public Button b4;
    public Button b3;
    public Button b2;
    public Button b1;
    public Button pi;

    public Button plus;
    public Button minus;
    public Button multiply;
    public Button div;
    public Button equal;
    public Button decimal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        secOutput = findViewById(R.id.secOutput);
        mainOutput = findViewById(R.id.mainOutput);
        allClear = findViewById(R.id.allClear);
        clear = findViewById(R.id.clear);
        leftBracket = findViewById(R.id.leftBracket);
        rightBracket = findViewById(R.id.rightBracket);
        sin = findViewById(R.id.sin);
        cos = findViewById(R.id.cos);
        tan = findViewById(R.id.tan);
        log = findViewById(R.id.log);
        ln = findViewById(R.id.ln);
        fact = findViewById(R.id.fact);
        square = findViewById(R.id.square);
        sqrt = findViewById(R.id.sqrt);
        inv = findViewById(R.id.inv);

        b0 = (Button)findViewById(R.id.b0);
        b1 = (Button)findViewById(R.id.b1);
        b2 = (Button)findViewById(R.id.b2);
        b3 = (Button)findViewById(R.id.b3);
        b4 = (Button)findViewById(R.id.b4);
        b5 = (Button)findViewById(R.id.b5);
        b6 = (Button)findViewById(R.id.b6);
        b7 = (Button)findViewById(R.id.b7);
        b8 = (Button)findViewById(R.id.b8);
        b9 = (Button)findViewById(R.id.b9);
        pi = (Button)findViewById(R.id.pi);

        plus = (Button)findViewById(R.id.plus);
        minus = (Button)findViewById(R.id.minus);
        multiply = (Button)findViewById(R.id.multiply);
        div = (Button)findViewById(R.id.div);
        equal = (Button)findViewById(R.id.equal);
        decimal = (Button)findViewById(R.id.decimal);


        b0.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mainOutput.setText(mainOutput.getText().toString() + "0");
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mainOutput.setText(mainOutput.getText().toString() + "1");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mainOutput.setText(mainOutput.getText().toString() + "2");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mainOutput.setText(mainOutput.getText().toString() + "3");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mainOutput.setText(mainOutput.getText().toString() + "4");
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mainOutput.setText(mainOutput.getText().toString() + "5");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mainOutput.setText(mainOutput.getText().toString() + "6");
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mainOutput.setText(mainOutput.getText().toString() + "7");
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mainOutput.setText(mainOutput.getText().toString() + "8");
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mainOutput.setText(mainOutput.getText().toString() + "9");
            }
        });

        pi.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mainOutput.setText(mainOutput.getText().toString() + "3.14");
            }
        });

        decimal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mainOutput.setText(mainOutput.getText().toString() + ".");
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mainOutput.setText(mainOutput.getText().toString() + "+");
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mainOutput.setText(mainOutput.getText().toString() + "-");
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mainOutput.setText(mainOutput.getText().toString() + "*");
            }
        });

        div.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mainOutput.setText(mainOutput.getText().toString() + "/");
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String input = mainOutput.getText().toString();
                String res = evaluate(input);
                mainOutput.setText(res);
                secOutput.setText(input);
            }
        });
    }

    private String evaluate(String input) {
        String res="";
        Context jsCx = Context.enter();
        Context.getCurrentContext().setOptimizationLevel(-1);
        ScriptableObject scope = jsCx.initStandardObjects();
        Object result = jsCx.evaluateString(scope, input , "formula", 0, null);
        Context.exit();
        System.out.println(result);
        res = result.toString();
        return res;
    }
}