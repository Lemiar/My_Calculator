package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity2 extends AppCompatActivity {



    TextView outputText;
    EditText inputText;

    private String input;
    String outp = "";

    private Button button0, button1, button2, button3, button4, button5, button6, button7,
            button8, button9, buttonAdd, buttonMultiply, buttonSubs, buttonDivision, buttonPoint,
            buttonPower, buttonEqual, buttonClear, buttonAC, buttonPar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        inputText = findViewById(R.id.solution);
        outputText = findViewById(R.id.result);
        inputText.setShowSoftInputOnFocus(false);

        button0 = findViewById(R.id.button_0);
        button1 = findViewById(R.id.button_1);
        button2 = findViewById(R.id.button_2);
        button3 = findViewById(R.id.button_3);
        button4 = findViewById(R.id.button_4);
        button5 = findViewById(R.id.button_5);
        button6 = findViewById(R.id.button_6);
        button7 = findViewById(R.id.button_7);
        button8 = findViewById(R.id.button_8);
        button9 = findViewById(R.id.button_9);
        buttonAdd = findViewById(R.id.button_plus);
        buttonMultiply = findViewById(R.id.button_mul);
        buttonDivision = findViewById(R.id.button_dev);
        buttonPower = findViewById(R.id.button_pow);
        buttonSubs = findViewById(R.id.button_m);
        buttonPoint = findViewById(R.id.button_dot);
        buttonEqual = findViewById(R.id.button_equal);
        buttonAC = findViewById(R.id.button_ac);
        buttonClear = findViewById(R.id.button_C);
        buttonPar = findViewById(R.id.button_par);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menucalcul, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.cal_standards:
                startActivity(new Intent(MainActivity2.this, MainActivity2.class));
                break;
            case R.id.cal_scientifique:
                startActivity(new Intent(MainActivity2.this, MainActivity1.class));
                break;
            case R.id.cal_device:
                startActivity(new Intent(MainActivity2.this, MainActivity3.class));
                break;
            case R.id.cal_temp:
                startActivity(new Intent(MainActivity2.this, MainActivity4.class));
                break;
            case R.id.cal_time:
                startActivity(new Intent(MainActivity2.this, MainActivity5.class));
                break;
           

            case R.id.cal_data:
                startActivity(new Intent(MainActivity2.this, MainActivity6.class));
                break;




        }


        return true;
    }

    private void updateText(String strToAdd) {
        String oldStr = inputText.getText().toString();
        int cursorPos = inputText.getSelectionStart();

        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        inputText.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        inputText.setSelection(cursorPos + 1);


    }

    int pos = -1;

    public void textClick(View view) {
        pos = inputText.getSelectionStart();
        input = inputText.getText().toString();
    }
    public void onButtonClicked(View view) {
        MaterialButton button = (MaterialButton) view;
        String data = button.getText().toString();



        switch (data) {
            case "C":

                input = "0";

                outputText.setText("");
                pos = -1;
                break;

            case "Pi":

                if(pos == -1) {
                    input = inputText.getText().toString() + "3.14";
                    pos = inputText.getText().length() + 4;

                }
                else {
                    String t1 = inputText.getText().toString();
                    String m1 = t1.substring(t1.length() - 1);
                    if (m1.equals("(")) {
                        input = inputText.getText().toString() + "3.14";
                        pos = inputText.getText().length() + 4;
                    }else{
                        String oldStr = inputText.getText().toString();
                        String leftStr = oldStr.substring(0, pos);
                        String rightStr = oldStr.substring(pos);
                        inputText.setText(String.format("%s%s%s", leftStr, "3.14", rightStr));
                        input = inputText.getText().toString();
                        inputText.setText(input);
                        pos += 4;

                        String t = inputText.getText().toString();
                        String m = t.substring(t.length() - 1);

                        if (inputText.getText().toString().contains("(")) {

                            String userExp = inputText.getText().toString();
                            userExp = userExp.replaceAll("÷", "/");
                            userExp = userExp.replaceAll("x", "*");
                            Expression exp = new Expression(userExp);
                            String result = String.valueOf(exp.calculate());
                            input = result + "";
                            if (!result.equals("NaN")) {
                                outputText.setText(result);
                            }

                        } else if ((t.contains("+") || t.contains("-") || t.contains("x") || t.contains("^") || t.contains("÷")) && (m.equals("1") || m.equals("2") || m.equals("3") || m.equals("4") || m.equals("5") || m.equals("6") || m.equals("7") || m.equals("8") || m.equals("9") || m.equals("0"))) {
                            solve(inputText.getText().toString());
                        } else {
                            outputText.setText("");
                        }
                    }
                }
                break;

            case "=":
                if( inputText.getText().toString().contains("(")){

                    String userExp=inputText.getText().toString();
                    userExp= userExp.replaceAll("÷","/");
                    userExp= userExp.replaceAll("x","*");
                    Expression exp = new Expression(userExp);
                    String result= String.valueOf(exp.calculate());
                    input = result + "";
                    outputText.setText(result);
                    inputText.setText(result);
                    pos = result.length();


                }
                else{
                    solve(inputText.getText().toString());
                    input = outp;
                    pos = input.length();
                }
                break;

            case".":
                if (pos==-1)
                {

                    String[] numb = input.split("[+÷^x-]");
                    if (!numb[numb.length - 1].contains(".")) {
                        input += ".";

                    }
                }
                else {
                    String oldStr = inputText.getText().toString();
                    String leftStr = oldStr.substring(0, pos);
                    String rightStr = oldStr.substring(pos);

                    String[] numb1 = leftStr.split("[+÷^x-]");
                    String[] numb2 = rightStr.split("[+÷^x-]");
                    if(leftStr.length()!=0){
                        if (!numb1[numb1.length - 1].contains(".") && !numb2[0].contains(".")) {
                            inputText.setText(String.format("%s%s%s", leftStr, ".", rightStr));
                            input = inputText.getText().toString();
                            inputText.setText(input);
                            pos += 1;

                        }
                    }
                    else{
                        if (!numb1[numb1.length - 1].contains(".")) {
                            inputText.setText(String.format("%s%s%s", leftStr, ".", rightStr));
                            input = inputText.getText().toString();
                            inputText.setText(input);
                            pos += 1;

                        }
                    }
                }
                break;


            case "()":
                if (inputText.getText().toString().equals("0"))
                {
                    inputText.setText("");
                }
                if(pos == -1){
                    input = inputText.getText().toString() + "(";
                    pos = inputText.length() + 1;

                }
                else{
                    int openPar=0;
                    int closePar=0;
                    int textLen = inputText.getText().length();

                    for( int i =0;i<pos;i++){
                        if(inputText.getText().toString().substring(i,i+1).equals("(")) {
                            openPar += 1 ;
                        }
                        if(inputText.getText().toString().substring(i,i+1).equals(")")) {
                            closePar += 1;
                        }
                    }
                    if(openPar==closePar||inputText.getText().toString().substring(textLen-1,textLen).equals("(")){
                        String oldStr = inputText.getText().toString();

                        String leftStr = oldStr.substring(0, pos);
                        String rightStr = oldStr.substring(pos);
                        inputText.setText(String.format("%s%s%s", leftStr, "(", rightStr));
                        input = inputText.getText().toString();

                    }
                    else if(closePar < openPar && !inputText.getText().toString().substring(textLen-1,textLen).equals("(")){
                        String oldStr = inputText.getText().toString();

                        String leftStr = oldStr.substring(0, pos);
                        String rightStr = oldStr.substring(pos);
                        inputText.setText(String.format("%s%s%s", leftStr, ")", rightStr));
                        input = inputText.getText().toString();

                    }

                    pos += 1;

                }
                outputText.setText("");
                break;

            default:
                if (input == null || input == "0") {
                    input = "";
                }
                if (pos == -1) {
                    if(!inputText.getText().toString().equals("")) {
                        int ind = inputText.getText().toString().length();
                        String d = inputText.getText().toString().substring(ind - 1, ind);
                        if ((d.equals("+") || d.equals("-") || d.equals("x") || d.equals("^") || d.equals("÷")) && (data.equals("+") || data.equals("-") || data.equals("x") || data.equals("^") || data.equals("÷"))) {

                            input = inputText.getText().toString().substring(0, ind - 1);
                            input += data;

                        } else {
                            input += data;
                        }

                        inputText.setText(input);
                        String t = inputText.getText().toString();
                        String m = t.substring(t.length() - 1);

                        if (inputText.getText().toString().contains("(")) {

                            String userExp = inputText.getText().toString();
                            userExp = userExp.replaceAll("÷", "/");
                            userExp = userExp.replaceAll("x", "*");
                            Expression exp = new Expression(userExp);
                            String result = String.valueOf(exp.calculate());
                            if (!result.equals("NaN")) {
                                outputText.setText(result);
                            }


                        } else if ((t.contains("+") || t.contains("-") || t.contains("x") || t.contains("^") || t.contains("÷")) && (m.equals("1") || m.equals("2") || m.equals("3") || m.equals("4") || m.equals("5") || m.equals("6") || m.equals("7") || m.equals("8") || m.equals("9") || m.equals("0"))) {
                            solve(inputText.getText().toString());

                        } else {
                            outputText.setText("");
                        }
                    }else{
                        input = data;
                        inputText.setText(input);
                    }

                }else {
                    if(pos!=0) {
                        String oldStr = inputText.getText().toString();
                        String leftStr = oldStr.substring(0, pos);
                        String rightStr = oldStr.substring(pos);

                        String d2 = "";
                        String d1 = oldStr.substring(pos - 1, pos);
                        if (pos != oldStr.length()) {
                            d2 = oldStr.substring(pos, pos + 1);
                        }

                        if ((d1.equals("+") || d1.equals("-") || d1.equals("x") || d1.equals("^") || d1.equals("÷")) && (data.equals("+") || data.equals("-") || data.equals("x") || data.equals("^") || data.equals("÷"))) {

                            leftStr = oldStr.substring(0, pos - 1);
                            pos -= 1;

                        }
                        if ((d2.equals("+") || d2.equals("-") || d2.equals("x") || d2.equals("^") || d2.equals("÷")) && (data.equals("+") || data.equals("-") || data.equals("x") || data.equals("^") || data.equals("÷"))) {

                            rightStr = oldStr.substring(pos + 1);
                            pos -= 1;

                        }

                        inputText.setText(String.format("%s%s%s", leftStr, data, rightStr));
                        input = inputText.getText().toString();
                        inputText.setText(input);
                        String t = inputText.getText().toString();
                        String m = t.substring(t.length() - 1);

                        if ((inputText.getText().toString().contains("(")) || (inputText.getText().toString().contains("(") && m.equals("+"))) {

                            String userExp = inputText.getText().toString();
                            userExp = userExp.replaceAll("÷", "/");
                            userExp = userExp.replaceAll("x", "*");
                            Expression exp = new Expression(userExp);
                            String result = String.valueOf(exp.calculate());
                            if (!result.equals("NaN")) {
                                outputText.setText(result);
                            }


                        } else if ((t.contains("+") || t.contains("-") || t.contains("x") || t.contains("^") || t.contains("÷")) && (m.equals("1") || m.equals("2") || m.equals("3") || m.equals("4") || m.equals("5") || m.equals("6") || m.equals("7") || m.equals("8") || m.equals("9") || m.equals("0"))) {
                            solve(inputText.getText().toString());
                        } else {
                            outputText.setText("");
                        }
                        input = inputText.getText().toString();
                        pos += data.length();
                    }else{
                        input = data + input;
                        pos = data.length();
                    }

                }
        }
        inputText.setText(input);

    }


    public void backspaceBtn(View view) {
        int cursorPos = inputText.getSelectionStart();
        int textLen = inputText.getText().length();
        if(pos == -1){
            cursorPos = textLen;
            pos = cursorPos;

        }
        if(cursorPos == 0){
            cursorPos = pos;
        }

        if (cursorPos != 0 && textLen != 0) {

            SpannableStringBuilder selection = (SpannableStringBuilder) inputText.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            inputText.setText(selection);
            inputText.setSelection(cursorPos - 1);
            input = inputText.getText().toString();

            pos -= 1;

        }



    }



    private void solve(String inputText) {

        String[] numbers = inputText.split("[+÷^x-]");
        String[] tab = inputText.split("");

        int k = 0;
        String[] tabOp = new String[numbers.length-1];
        for (int i = 0; i < tab.length; i++) {
            if (tab[i].equals("+") || tab[i].equals("-") || tab[i].equals("x") || tab[i].equals("÷") || tab[i].equals("^")) {
                tabOp[k]=tab[i];
                k++;

            }
        }


        String t;
        String[] newTab = new String[numbers.length + tabOp.length];
        for(int i = 0; i < newTab.length; i++) {
            newTab[i] = "";
        }
        for(int i=0,j=0;i<newTab.length-1;i=i+2,j++){
            newTab[i]=numbers[j];
            newTab[i+1]= tabOp[j];

        }
        newTab[newTab.length-1]=numbers[numbers.length-1];

        int x1=0;
        int x2=0;
        int x3=0;
        int x4=0;
        int x5=0;
        for(int i=0; i<tabOp.length; i++) {
            if(tabOp[i].equals("^")) {
                x1 += 1;
            }
            if(tabOp[i].equals("x")) {
                x2 += 1;
            }
            if(tabOp[i].equals("÷")) {
                x3 += 1;
            }
            if(tabOp[i].equals("-")) {
                x4 += 1;
            }
            if(tabOp[i].equals("+")) {
                x5 += 1;
            }
        }


        for(int x=0; x<x1; x++) {
            for(int i=0;i<newTab.length;i++) {
                if(newTab[i].equals("^")) {
                    double n1 = Double.parseDouble(newTab[i-1]);
                    double n2 = Double.parseDouble(newTab[i+1]);
                    double result=Math.pow(n1, n2);
                    newTab[i+1]=Double.toString(result);
                    String [] tb = new String[newTab.length-2];
                    for(int j =0;j<tb.length;j++) {
                        if(j<i-1) {
                            tb[j]=newTab[j];

                        }
                        else {
                            tb[j]=newTab[j+2];

                        }

                    }
                    newTab=tb;

                    break;

                }
            }
        }

        for(int x=0; x<x2; x++) {
            for(int i=0;i<newTab.length;i++) {
                if(newTab[i].equals("x")) {
                    double n1 = Double.parseDouble(newTab[i-1]);
                    double n2 = Double.parseDouble(newTab[i+1]);
                    double result=n1*n2;
                    newTab[i+1]=Double.toString(result);
                    String [] tb = new String[newTab.length-2];
                    for(int j =0;j<tb.length;j++) {
                        if(j<i-1) {
                            tb[j]=newTab[j];

                        }
                        else {
                            tb[j]=newTab[j+2];

                        }

                    }
                    newTab=tb;

                    break;
                }
            }
        }


        for(int x=0; x<x3; x++) {
            for(int i=0;i<newTab.length;i++) {
                if(newTab[i].equals("÷")) {
                    double n1 = Double.parseDouble(newTab[i-1]);
                    double n2 = Double.parseDouble(newTab[i+1]);
                    double result=n1/n2;
                    newTab[i+1]=Double.toString(result);
                    String [] tb = new String[newTab.length-2];
                    for(int j =0;j<tb.length;j++) {
                        if(j<i-1) {
                            tb[j]=newTab[j];

                        }
                        else {
                            tb[j]=newTab[j+2];

                        }

                    }
                    newTab=tb;

                    break;
                }

            }
        }


        for(int x=0; x<x4; x++) {
            for(int i=0;i<newTab.length;i++) {
                if(newTab[i].equals("-")) {
                    double n1 = Double.parseDouble(newTab[i-1]);
                    double n2 = Double.parseDouble(newTab[i+1]);
                    double result=n1-n2;
                    newTab[i+1]=Double.toString(result);
                    String [] tb = new String[newTab.length-2];
                    for(int j =0;j<tb.length;j++) {
                        if(j<i-1) {
                            tb[j]=newTab[j];

                        }
                        else {
                            tb[j]=newTab[j+2];

                        }

                    }
                    newTab=tb;

                }

            }
        }


        for(int x=0; x<x5; x++) {
            for(int i=0;i<newTab.length;i++) {
                if(newTab[i].equals("+")) {
                    double n1 = Double.parseDouble(newTab[i-1]);
                    double n2 = Double.parseDouble(newTab[i+1]);
                    double result=n1+n2;
                    newTab[i+1]=Double.toString(result);
                    String [] tb = new String[newTab.length-2];
                    for(int j =0;j<tb.length;j++) {
                        if(j<i-1) {
                            tb[j]=newTab[j];

                        }
                        else {
                            tb[j]=newTab[j+2];

                        }

                    }
                    newTab=tb;

                    break;
                }
            }
        }


        for(int c = 0; c < newTab.length; c++) {
            System.out.println(newTab[c]);
        }

        outputText.setText(newTab[0]);
        outp = newTab[0];

    }




    private String cutDecimal(String number) {
        String n[] = number.split("\\.");
        if (n.length > 1) {
            if (n[1].equals("0")) {
                number = n[0];
            }
        }
        return number;
    }

}