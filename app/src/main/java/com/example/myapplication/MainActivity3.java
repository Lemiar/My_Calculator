package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;


public class MainActivity3 extends AppCompatActivity{

    private String d1;
    private double res;
    private Spinner spinner1;
    private Spinner spinner2;
    private EditText txt1, txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        spinner1 = findViewById(R.id.sp1);
        spinner2 = findViewById(R.id.sp2);
        txt1 = findViewById(R.id.txt);
        txt2 = findViewById(R.id.txt2);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        d1 = "DH";
                        break;
                    case 1:
                        d1 = "$";
                        break;
                    case 2:
                        d1 = "€";
                        break;
                    default:
                        d1 = "";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        if(d1.equals("DH")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString());
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("$")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) * 0.095;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("€")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) * 0.090;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        break;
                    case 1:
                        if(d1.equals("DH")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) * 10.54;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("$")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString());
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("€")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) * 0.95;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        break;
                    case 2:
                        if(d1.equals("DH")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) * 11.13;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("$")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) * 1.06;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("€")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString());
                                txt2.setText(Double.toString(res));
                            }
                        }
                        break;
                    default:
                        d1 = "";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

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
                startActivity(new Intent(MainActivity3.this, MainActivity2.class));
                break;
            case R.id.cal_scientifique:
                startActivity(new Intent(MainActivity3.this, MainActivity1.class));
                break;
            case R.id.cal_device:
                startActivity(new Intent(MainActivity3.this, MainActivity3.class));
                break;
            case R.id.cal_temp:
                startActivity(new Intent(MainActivity3.this, MainActivity4.class));
                break;
            case R.id.cal_time:
                startActivity(new Intent(MainActivity3.this, MainActivity5.class));
                break;


            case R.id.cal_data:
                startActivity(new Intent(MainActivity3.this, MainActivity6.class));
                break;




        }

        return true;
    }



}