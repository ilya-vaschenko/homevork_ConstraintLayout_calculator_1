package com.example.homevork_constraintlayout_calculator_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class new_Activity extends AppCompatActivity {

    private static final String NAME_SHARED_PREFERENCE = "LOGIN";

    private static final String appTheme = "APP_THEME";

    private static final int MyCoolCodeStyle = 0;
    private static final int AppThemeLightCodeStyle = 1;
    private static final int AppThemeCodeStyle = 2;
    private static final int AppThemeDarkCodeStale = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int currentThemeCode = getCodeStyle();
        int currentThemeResID = codeStyleToStyleId(currentThemeCode);
        setTheme(currentThemeResID);


        setContentView(R.layout.activity_new);

        initView();
        initRadioButtons();
    }

    private void initView() {
        findViewById(R.id.btnReturn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private int getCodeStyle() {
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
    }
}