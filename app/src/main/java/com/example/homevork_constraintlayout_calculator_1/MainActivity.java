package com.example.homevork_constraintlayout_calculator_1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText calculation, result;
    private String curr, res;
    private Button  division, multiplication, subtraction, equally, addition, del, ac, dot;
    private boolean dot_inserted, operator_inserted;

    private final int[] numberButtonIds = new int[]{R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
            R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculation = (EditText) findViewById(R.id.calculation);
        result = (EditText) findViewById(R.id.result);
        curr = "";
        res = "";
        dot_inserted = false;
        operator_inserted = false;
        dot = (Button) findViewById(R.id.dot);
        multiplication = (Button) findViewById(R.id.multiplication);
        division = (Button) findViewById(R.id.division);
        subtraction = (Button) findViewById(R.id.subtraction);
        addition = (Button) findViewById(R.id.addition);
        equally = (Button) findViewById(R.id.equally);
        del = (Button) findViewById(R.id.del);
        ac = (Button) findViewById(R.id.ac);
        setNumberButtonListeners();

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(curr.isEmpty()) {
                    curr ="0.";
                    dot_inserted = true;
                }
                if(dot_inserted == false){
                    curr = curr +".";
                    dot_inserted = true;
                }
                displayOne();
            }
        });

        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
                displayOne();
                displayTyo();
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backspace();
                displayOne();
            }
        });

        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dot_inserted = false;
                if (!curr.isEmpty()) {
                    if (curr.substring(curr.length() - 1, curr.length()).equals(".")) {
                        backspace();
                    }
                    if (operator_inserted == false) {
                        curr = curr + " / ";
                        operator_inserted = true;
                    }
                }
                displayOne();
            }
        });

        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dot_inserted = false;
                if (!curr.isEmpty()) {
                    if (curr.substring(curr.length() - 1, curr.length()).equals(".")) {
                        backspace();
                    }
                    if (operator_inserted == false) {
                        curr = curr + " * ";
                        operator_inserted = true;
                    }
                }
                displayOne();
            }
        });

        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dot_inserted = false;
                if (!curr.isEmpty()) {
                    if (curr.substring(curr.length() - 1, curr.length()).equals(".")) {
                        backspace();
                    }
                    if (operator_inserted == false) {
                        curr = curr + " - ";
                        operator_inserted = true;
                    }
                }
                displayOne();
            }
        });

        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dot_inserted = false;
                if (!curr.isEmpty()) {
                    if (curr.substring(curr.length() - 1, curr.length()).equals(".")) {
                        backspace();
                    }
                    if (operator_inserted == false) {
                        curr = curr + " + ";
                        operator_inserted = true;
                    }
                }
                displayOne();
            }
        });

        equally.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operator_inserted == true && !curr.substring(curr.length() - 1, curr.length()).equals(" ")) {
                    String [] tokens = curr.split(" ");

                    switch (tokens[1].charAt(0)) {
                        case '+':
                            res = Double.toString(Double.parseDouble(tokens[0]) + Double.parseDouble(tokens[2]));
                            break;

                        case '-':
                            res = Double.toString(Double.parseDouble(tokens[0]) - Double.parseDouble(tokens[2]));
                            break;

                        case '/':
                            res = Double.toString(Double.parseDouble(tokens[0]) / Double.parseDouble(tokens[2]));
                            break;

                        case '*':
                            res = Double.toString(Double.parseDouble(tokens[0]) * Double.parseDouble(tokens[2]));
                            break;
                    }
                    displayTyo();
                }
            }
        });
    }

    public void displayOne() {
        calculation.setText(curr);
    }

    public void displayTyo() {
        result.setText(res);
    }

    public void clear() {
        curr = "";
        res = "";
        dot_inserted = false;
        operator_inserted = false;
    }

    public void backspace() {
        if(!curr.isEmpty()) {
            if(curr.substring(curr.length() - 1, curr.length()).equals(".")){
                dot_inserted = false;
            }
            if(curr.substring(curr.length() - 1, curr.length()).equals(" ")){
                curr = curr.substring(0, curr.length() - 3);
                operator_inserted = false;
            }else {
                curr = curr.substring(0,curr.length() - 1);
            }
        }
    }

    private void setNumberButtonListeners() {
        for (int i = 0; i < numberButtonIds.length; i++) {
            findViewById(numberButtonIds[i]).setOnClickListener(v -> {
                Button btn = (Button)v;
                curr = curr + btn.getText().toString();
                displayOne();
            });
        }
    }
}