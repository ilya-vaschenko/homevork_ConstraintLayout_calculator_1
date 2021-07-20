package com.example.homevork_constraintlayout_calculator_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    /*private static final String NAME_SHARED_PREFERENCE = "LOGIN";

    private static final String appTheme = "APP_THEME";

    private static final int MyCoolCodeStyle = 0;
    private static final int AppThemeLightCodeStyle = 1;
    private static final int AppThemeCodeStyle = 2;
    private static final int AppThemeDarkCodeStale = 3;*/

    private EditText calculation, result;
    private String curr, res;
    private Button topic, division, multiplication, subtraction, equally, addition, del, ac, dot;
    private boolean dot_inserted, operator_inserted;

    private final int[] numberButtonIds = new int[]{R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
            R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*int currentThemeCode = getCodeStyle();
        int currentThemeResID = codeStyleToStyleId(currentThemeCode);
        setTheme(currentThemeResID);*/

        setContentView(R.layout.activity_main);

        calculation = (EditText) findViewById(R.id.calculation);
        result = (EditText) findViewById(R.id.result);
        curr = "";
        res = "";
        dot_inserted = false;
        operator_inserted = false;
        topic = (Button) findViewById(R.id.topic);
        dot = (Button) findViewById(R.id.dot);
        multiplication = (Button) findViewById(R.id.multiplication);
        division = (Button) findViewById(R.id.division);
        subtraction = (Button) findViewById(R.id.subtraction);
        addition = (Button) findViewById(R.id.addition);
        equally = (Button) findViewById(R.id.equally);
        del = (Button) findViewById(R.id.del);
        ac = (Button) findViewById(R.id.ac);
        setNumberButtonListeners();
        /*initRadioButtons();*/

        topic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newActivity = new Intent(MainActivity.this, new_Activity.class);
                startActivity(newActivity);
            }
        });

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

    /*private int getCodeStyle() {
        SharedPreferences preferences = getSharedPreferences(NAME_SHARED_PREFERENCE, MODE_PRIVATE);
        return preferences.getInt(appTheme,MyCoolCodeStyle);
    }

    private void setAppTheme(int codeStyle) {
        SharedPreferences preferences = getSharedPreferences(NAME_SHARED_PREFERENCE, MODE_PRIVATE);

        preferences.edit()
                .putInt(appTheme, codeStyle)
                .apply();
    }

    private int codeStyleToStyleId(int codeStyle) {
        switch (codeStyle) {
            case AppThemeCodeStyle:
                return R.style.Theme_Homevork_ConstraintLayout_calculator_1;
            case AppThemeLightCodeStyle:
                return R.style.AppThemeLight;
            case AppThemeDarkCodeStale:
                return R.style.AppThemeDark;
            case MyCoolCodeStyle:
            default:
                return R.style.MyCoolStyle ;
        }
    }

    private void initRadioButtons() {
        findViewById(R.id.radioButtonMyCoolStyle).setOnClickListener(v -> {
            setAppTheme(MyCoolCodeStyle);
            recreate();
        });

        findViewById(R.id.radioButtonMaterialDark).setOnClickListener(v -> {
            setAppTheme(AppThemeDarkCodeStale);
            recreate();
        });

        findViewById(R.id.radioButtonMaterialLight).setOnClickListener(v -> {
            setAppTheme(AppThemeLightCodeStyle);
            recreate();
        });

        findViewById(R.id.radioButtonMaterialLightDarkAction ).setOnClickListener(v -> {
            setAppTheme(AppThemeCodeStyle);
            recreate();
        });
    }*/

    // дисплей где пишется пример
    public void displayOne() {
        calculation.setText(curr);
    }

    // дисплей где пишится ответ
    public void displayTyo() {
        result.setText(res);
    }

    // удаляет все
    public void clear() {
        curr = "";
        res = "";
        dot_inserted = false;
        operator_inserted = false;
    }

    // удаление одного значения
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

    // метод назначающий кнопки от 0 до 9
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