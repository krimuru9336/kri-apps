package com.example.kriapps;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
//
//import javax.script.ScriptEngineManager;
//import javax.script.ScriptEngine;
//import javax.script.ScriptException;

import androidx.appcompat.app.AppCompatActivity;

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
    public Button power;
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
        power = findViewById(R.id.power);
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

        allClear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mainOutput.setText("");
                secOutput.setText("");
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String str = mainOutput.getText().toString();
                if(!str.equals("")) {
                    str = str.substring(0, str.length() - 1);
                    mainOutput.setText(str);
                }
            }
        });


        leftBracket.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mainOutput.setText(mainOutput.getText().toString() + "(");
            }
        });

        rightBracket.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mainOutput.setText(mainOutput.getText().toString() + ")");
            }
        });

        power.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mainOutput.setText(mainOutput.getText().toString() + "^");
            }
        });

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

        log.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mainOutput.setText(mainOutput.getText().toString() + "log");
            }
        });

        ln.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mainOutput.setText(mainOutput.getText().toString() + "ln");
            }
        });

        sin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mainOutput.setText(mainOutput.getText().toString() + "sin");
            }
        });

        cos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mainOutput.setText(mainOutput.getText().toString() + "cos");
            }
        });

        tan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mainOutput.setText(mainOutput.getText().toString() + "tan");
            }
        });


        equal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String input = mainOutput.getText().toString();
                String res = evaluate(input)+"";
                mainOutput.setText(res);
                secOutput.setText(input);
            }
        });
    }

    private double evaluate(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else if (func.equals("log")) x = Math.log10(x);
                    else if (func.equals("ln")) x = Math.log(x);
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();


    }


}