package com.example.frauks;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ezylang.evalex.EvaluationException;
import com.ezylang.evalex.Expression;
import com.ezylang.evalex.data.EvaluationValue;
import com.ezylang.evalex.parser.ParseException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText  input;
    TextView  memory;

    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnSum
            ,btnDivide,btnMultiplact,btnSubtract,btnEqual,btnClear,btnDot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constructor();

    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn0:
                input.setText(input.getText()+"0");
                break;
            case R.id.btn1:
                input.setText(input.getText()+"1");
                break;
            case R.id.btn2:
                input.setText(input.getText()+"2");
                break;
            case R.id.btn3:
                input.setText(input.getText()+"3");
                break;
            case R.id.btn4:
                input.setText(input.getText()+"4");
                break;
            case R.id.btn5:
                input.setText(input.getText()+"5");
                break;
            case R.id.btn6:
                input.setText(input.getText()+"6");
                break;
            case R.id.btn7:
                input.setText(input.getText()+"7");
                break;
            case R.id.btn8:
                input.setText(input.getText()+"8");
                break;
            case R.id.btn9:
                input.setText(input.getText()+"9");
                break;
            case R.id.btnSum:
                input.setText(input.getText()+"+");
                break;
            case R.id.btnSubtract:
                input.setText(input.getText()+"-");
                break;
            case R.id.btnMultiplact:
                input.setText(input.getText()+"*");
                break;
            case R.id.btnDivide:
                input.setText(input.getText()+"/");
                break;
            case R.id.btnDot:
                input.setText(input.getText()+".");
                break;
            case R.id.btnClear:
                input.setText("");
                break;
            case R.id.btnEqual:
                try {
                    Expression expression = new Expression(input.getText().toString());
                    EvaluationValue result = expression.evaluate();
                    input.setText(result.getNumberValue().toString());
                } catch (EvaluationException | ParseException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    protected void constructor() {
        btn0=findViewById(R.id.btn0);
        btn0.setOnClickListener(this);
        btn1=findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn2=findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        btn3=findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
        btn4=findViewById(R.id.btn4);
        btn4.setOnClickListener(this);
        btn5=findViewById(R.id.btn5);
        btn5.setOnClickListener(this);
        btn6=findViewById(R.id.btn6);
        btn6.setOnClickListener(this);
        btn7=findViewById(R.id.btn7);
        btn7.setOnClickListener(this);
        btn8=findViewById(R.id.btn8);
        btn8.setOnClickListener(this);
        btn9=findViewById(R.id.btn9);
        btn9.setOnClickListener(this);
        btnSum=findViewById(R.id.btnSum);
        btnSum.setOnClickListener(this);
        btnDivide=findViewById(R.id.btnDivide);
        btnDivide.setOnClickListener(this);
        btnMultiplact=findViewById(R.id.btnMultiplact);
        btnMultiplact.setOnClickListener(this);
        btnSubtract=findViewById(R.id.btnSubtract);
        btnSubtract.setOnClickListener(this);
        btnEqual=findViewById(R.id.btnEqual);
        btnEqual.setOnClickListener(this);
        btnClear=findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);
        btnDot=findViewById(R.id.btnDot);
        btnDot.setOnClickListener(this);
        input=findViewById(R.id.input);
        memory=findViewById(R.id.memory);
    }



}