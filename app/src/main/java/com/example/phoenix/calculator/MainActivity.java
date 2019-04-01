package com.example.phoenix.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private Button zero = null;
    private Button one = null;
    private Button two = null;
    private Button three = null;
    private Button four = null;
    private Button five = null;
    private Button six = null;
    private Button seven = null;
    private Button eight = null;
    private Button nine = null;

    private Button ac = null;
    private Button plus = null;
    private Button minus = null;
    private Button multiply = null;
    private Button divide = null;
    private Button equals = null;
    private Button percent = null;
    private Button answer = null;
    private Button dot = null;

    private TextView inputArea = null;
    private TextView result = null;

    private String inputString;
    private char lastChar;
    private String[] partsOfInput;
    private boolean dotIsPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zero = (Button) findViewById(R.id.zero);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);

        ac = (Button) findViewById(R.id.AC);
        plus = (Button) findViewById(R.id.addtn);
        minus = (Button) findViewById(R.id.sbtrc);
        multiply = (Button) findViewById(R.id.mltpcl);
        divide = (Button) findViewById(R.id.division);
        equals = (Button) findViewById(R.id.eqal);
        percent = (Button) findViewById(R.id.percent);
        answer = (Button) findViewById(R.id.ans);
        dot = (Button) findViewById(R.id.dot);

        inputArea = (TextView) findViewById(R.id.calculation);
        result = (TextView) findViewById(R.id.result);


        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!inputArea.getText().toString().equals("0"))
                    inputArea.setText(inputArea.getText() + "0");
                else
                    inputArea.setText("0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!inputArea.getText().toString().equals("0")) {
                    inputArea.setText(inputArea.getText() + "1");
                }
                else
                    inputArea.setText("1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!inputArea.getText().toString().equals("0"))
                    inputArea.setText(inputArea.getText() + "2");
                else
                    inputArea.setText("2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!inputArea.getText().toString().equals("0"))
                    inputArea.setText(inputArea.getText() + "3");
                else
                    inputArea.setText("3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!inputArea.getText().toString().equals("0"))
                    inputArea.setText(inputArea.getText() + "4");
                else
                    inputArea.setText("4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!inputArea.getText().toString().equals("0"))
                    inputArea.setText(inputArea.getText() + "5");
                else
                    inputArea.setText("5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!inputArea.getText().toString().equals("0"))
                    inputArea.setText(inputArea.getText() + "6");
                else
                    inputArea.setText("6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!inputArea.getText().toString().equals("0"))
                    inputArea.setText(inputArea.getText() + "7");
                else
                    inputArea.setText("7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!inputArea.getText().toString().equals("0"))
                    inputArea.setText(inputArea.getText() + "8");
                else
                    inputArea.setText("8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!inputArea.getText().toString().equals("0"))
                    inputArea.setText(inputArea.getText() + "9");
                else
                    inputArea.setText("9");
            }
        });



        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputString = inputArea.getText().toString();

                if (inputString.contains("-"))
                    minusClicked();
                else if (inputString.contains("x"))
                    multiplyClicked();
                else if (inputString.contains("/"))
                    divideClicked();
                else
                    plusClicked();
            }
        });


        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputString = inputArea.getText().toString();

                if (inputString.contains("+"))
                    plusClicked();
                else if (inputString.contains("x"))
                    multiplyClicked();
                else if (inputString.contains("/"))
                    divideClicked();
                else
                    minusClicked();
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputString = inputArea.getText().toString();

                if (inputString.contains("+"))
                    plusClicked();
                else if (inputString.contains("-"))
                    minusClicked();
                else if (inputString.contains("/"))
                    divideClicked();
                else
                    multiplyClicked();
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputString = inputArea.getText().toString();

                if (inputString.contains("+"))
                    plusClicked();
                else if (inputString.contains("-"))
                    minusClicked();
                else if (inputString.contains("x"))
                    multiplyClicked();
                else
                    divideClicked();
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputString = inputArea.getText().toString();
                dotIsPressed = false;

                if (inputString.contains("+")){
                    partsOfInput = inputString.split("\\+");
                    double total = Double.parseDouble(partsOfInput[0]) + Double.parseDouble(partsOfInput[1]);

                    if (Double.toString(total).startsWith(".0",Double.toString(total).length() - 2))
                        result.setText(inputString + "\n" + (int)total);
                    else
                        result.setText(inputString + "\n" + total);

                    inputArea.setText("0");
                } else if (inputString.contains("-")) {
                    partsOfInput = inputString.split("-");
                    double total = Double.parseDouble(partsOfInput[0]) - Double.parseDouble(partsOfInput[1]);

                    if (Double.toString(total).startsWith(".0",Double.toString(total).length() - 2))
                        result.setText(inputString + "\n" + (int)total);
                    else
                        result.setText(inputString + "\n" + total);

                    inputArea.setText("0");
                } else if (inputString.contains("x")) {
                    partsOfInput = inputString.split("x");
                    double total = Double.parseDouble(partsOfInput[0]) * Double.parseDouble(partsOfInput[1]);

                    if (Double.toString(total).startsWith(".0",Double.toString(total).length() - 2))
                        result.setText(inputString + "\n" + (int)total);
                    else
                        result.setText(inputString + "\n" + total);

                    inputArea.setText("0");
                } else if (inputString.contains("/")) {
                    partsOfInput = inputString.split("\\/");

                    if (Double.parseDouble(partsOfInput[1]) != 0) {
                        double total = Double.parseDouble(partsOfInput[0]) / Double.parseDouble(partsOfInput[1]);

                        if (Double.toString(total).startsWith(".0",Double.toString(total).length() - 2))
                            result.setText(inputString + "\n" + (int)total);
                        else
                            result.setText(inputString + "\n" + total);

                        inputArea.setText("0");
                    }
                    else {
                        result.setText(inputString + "\n" + "Error!");
                        inputArea.setText("0");
                    }
                } else
                    result.setText(inputString);
            }
        });

        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputArea.setText("0");
                dotIsPressed = false;
            }
        });

        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputString = inputArea.getText().toString();
                lastChar = inputString.charAt(inputString.length() - 1);

                if (lastChar != '+' && lastChar != '-' && lastChar != 'x' && lastChar != '/'
                        && !inputString.contains("+") && !inputString.contains("-")
                        && !inputString.contains("x") && !inputString.contains("/")){
                    result.setText(Double.parseDouble(inputArea.getText().toString())/100.0 + "");
                    inputArea.setText("0");
                    dotIsPressed = false;
                }
            }
        });

        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputString = result.getText().toString();

                if (inputString.contains("\n")){
                    partsOfInput = inputString.split("\n");
                    inputArea.setText(partsOfInput[1]);
                } else
                    inputArea.setText(inputString);
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputString = inputArea.getText().toString();
                lastChar = inputString.charAt(inputString.length() - 1);

                if (lastChar != '+' && lastChar != '-' && lastChar != 'x' && lastChar != '/' && lastChar != '.' && !dotIsPressed) {
                    inputArea.setText(inputString + ".");
                    dotIsPressed = true;
                }
            }
        });
    }


    private void plusClicked(){
        inputString = inputArea.getText().toString();
        lastChar = inputString.charAt(inputString.length() - 1);

        partsOfInput = inputString.split("\\+");
        dotIsPressed = false;

        if (lastChar != '+' && lastChar != '-' && lastChar != 'x' && lastChar != '/') {
            if (partsOfInput.length < 2)
                inputArea.setText(inputArea.getText() + "+");
            else{
                double total = Double.parseDouble(partsOfInput[0]) + Double.parseDouble(partsOfInput[1]);

                if (Double.toString(total).startsWith(".0",Double.toString(total).length() - 2))
                    result.setText(inputString + "\n" + (int)total);
                else
                    result.setText(inputString + "\n" + total);

                inputArea.setText("0");
            }
        }
    }

    private void minusClicked(){
        inputString = inputArea.getText().toString();
        lastChar = inputString.charAt(inputString.length() - 1);

        partsOfInput = inputString.split("-");
        dotIsPressed = false;

        if (lastChar != '+' && lastChar != '-' && lastChar != 'x' && lastChar != '/') {
            if (partsOfInput.length < 2)
                inputArea.setText(inputArea.getText() + "-");
            else {
                double total = Double.parseDouble(partsOfInput[0]) - Double.parseDouble(partsOfInput[1]);

                if (Double.toString(total).startsWith(".0",Double.toString(total).length() - 2))
                    result.setText(inputString + "\n" + (int)total);
                else
                    result.setText(inputString + "\n" + total);

                inputArea.setText("0");
            }
        }
    }

    private void multiplyClicked(){
        inputString = inputArea.getText().toString();
        lastChar = inputString.charAt(inputString.length() - 1);

        partsOfInput = inputString.split("x");
        dotIsPressed = false;

        if (lastChar != '+' && lastChar != '-' && lastChar != 'x' && lastChar != '/') {
            if (partsOfInput.length < 2)
                inputArea.setText(inputArea.getText() + "x");
            else{
                double total = Double.parseDouble(partsOfInput[0]) * Double.parseDouble(partsOfInput[1]);

                if (Double.toString(total).startsWith(".0",Double.toString(total).length() - 2))
                    result.setText(inputString + "\n" + (int)total);
                else
                    result.setText(inputString + "\n" + total);

                inputArea.setText("0");
            }
        }
    }

    private void divideClicked(){
        inputString = inputArea.getText().toString();
        lastChar = inputString.charAt(inputString.length() - 1);

        partsOfInput = inputString.split("\\/");
        dotIsPressed = false;

        if (lastChar != '+' && lastChar != '-' && lastChar != 'x' && lastChar != '/') {
            if (partsOfInput.length < 2)
                inputArea.setText(inputArea.getText() + "/");
            else{
                double total = 0;

                if (Double.parseDouble(partsOfInput[1]) != 0) {
                    total = Double.parseDouble(partsOfInput[0]) / Double.parseDouble(partsOfInput[1]);

                    if (Double.toString(total).startsWith(".0",Double.toString(total).length() - 2))
                        result.setText(inputString + "\n" + (int)total);
                    else
                        result.setText(inputString + "\n" + total);

                    inputArea.setText("0");
                }
                else {
                    result.setText(inputArea.getText().toString() + "\n" + "Error!");
                    inputArea.setText("0");
                }
            }
        }
    }
}
