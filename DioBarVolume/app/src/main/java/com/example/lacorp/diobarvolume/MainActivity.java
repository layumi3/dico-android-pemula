package com.example.lacorp.diobarvolume;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText teWidth;
    private EditText teHeight;
    private EditText teLength;
    private Button btnCalc;
    private TextView tResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teWidth = findViewById(R.id.te_width);
        teHeight = findViewById(R.id.te_height);
        teLength = findViewById(R.id.te_length);
        btnCalc = findViewById(R.id.btn_calc);
        tResult = findViewById(R.id.t_result);
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_calc){
            String inputLength = teLength.getText().toString().trim();
            String inputWidth = teWidth.getText().toString().trim();
            String inputHeight = teHeight.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            if (TextUtils.isEmpty(inputLength)){
                isEmptyFields = true;
                teLength.setError("Field ini tidak boleh kosong");
            }

            if (TextUtils.isEmpty(inputWidth)){
                isEmptyFields = true;
                teWidth.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputHeight)){
                isEmptyFields = true;
                teHeight.setError("Field ini tidak boleh kosong");
            }

            Double length = toDouble(inputLength);
            Double width = toDouble(inputWidth);
            Double height = toDouble(inputHeight);

            if (length == null){
                isInvalidDouble = true;
                teLength.setError("Field ini tidak boleh kosong");
            }
            if (width == null){
                isInvalidDouble = true;
                teWidth.setError("Field ini tidak boleh kosong");
            }
            if (height == null){
                isInvalidDouble = true;
                teHeight.setError("Field ini tidak boleh kosong");
            }

            if (!isEmptyFields && !isInvalidDouble){
                double volume = length * width * height;
                tResult.setText(String.valueOf(volume));
            }
        }
    }

    private Double toDouble(String str) {
        try {
            return  Double.valueOf(str);
        }catch (NumberFormatException e){
            return null;
        }
    }
}
