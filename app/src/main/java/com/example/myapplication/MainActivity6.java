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

public class MainActivity6 extends AppCompatActivity {

    private String d1;
    private double res;
    private Spinner spinner1;
    private Spinner spinner2;
    private EditText txt1, txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        spinner1 = findViewById(R.id.s1);
        spinner2 = findViewById(R.id.s2);
        txt1 = findViewById(R.id.t1);
        txt2 = findViewById(R.id.t2);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        d1 = "Bit";
                        break;
                    case 1:
                        d1 = "KiloBit";
                        break;
                    case 2:
                        d1 = "MégaBit";
                        break;
                    case 3:
                        d1 = "GigaBit";
                        break;
                    case 4:
                        d1 = "Octet";
                        break;
                    case 5:
                        d1 = "KiloOctet";
                        break;
                    case 6:
                        d1 = "MégaOctet";
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
                        if(d1.equals("Bit")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString());
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("KiloBit")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) * 1000;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("MégaBit")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) * 1000000;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("GigaBit")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) * 1000000000;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("Octet")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) * 8;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("KiloOctet")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) * 8000;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("MégaOctet")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) * 8000000;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        break;
                    case 1:
                        if(d1.equals("Bit")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) / 1000;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("KiloBit")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString());
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("MégaBit")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) * 1000;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("GigaBit")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) * 1000000;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("Octet")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) * 0.008;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("KiloOctet")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) * 8;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("MégaOctet")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) * 8000;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        break;
                    case 2:
                        if(d1.equals("Bit")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) / 1000000;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("KiloBit")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) / 1000;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("MégaBit")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString());
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("GigaBit")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) * 1000;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("Octet")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) * 0.000008;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("KiloOctet")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) * 0.008;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("MégaOctet")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) * 8;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        break;
                    case 3:
                        if(d1.equals("Bit")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) / 1000000000;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("KiloBit")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) / 1000000;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("MégaBit")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) / 1000;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("GigaBit")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString());
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("Octet")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) * 0.000000008;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("KiloOctet")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) * 0.000008;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("MégaOctet")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) * 8;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        break;
                    case 4:
                        if(d1.equals("Bit")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) / 8;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("KiloBit")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString())/8 * 1000;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("MégaBit")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString())/8 * 1000000;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("GigaBit")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString())/8 * 1000000000;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("Octet")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString());
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("KiloOctet")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) / 1000;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("MégaOctet")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) / 1000000;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        break;
                    case 5:
                        if(d1.equals("Bit")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) / 8000;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("KiloBit")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString())/8;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("MégaBit")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString())/8 * 1000;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("GigaBit")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString())/8 * 1000000;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("Octet")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) * 1000;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("KiloOctet")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString());
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("MégaOctet")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) / 1000;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        break;
                    case 6:
                        if(d1.equals("Bit")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) / 8000000;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("KiloBit")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString())/8000;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("MégaBit")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString())/8;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("GigaBit")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString())/8 * 1000;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("Octet")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) * 1000000;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("KiloOctet")) {
                            if(!txt1.getText().toString().equals("")) {
                                res = Double.parseDouble(txt1.getText().toString()) * 1000;
                                txt2.setText(Double.toString(res));
                            }
                        }
                        if(d1.equals("MégaOctet")) {
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
                startActivity(new Intent(MainActivity6.this, MainActivity2.class));
                break;
            case R.id.cal_scientifique:
                startActivity(new Intent(MainActivity6.this, MainActivity1.class));
                break;
            case R.id.cal_device:
                startActivity(new Intent(MainActivity6.this, MainActivity3.class));
                break;
            case R.id.cal_temp:
                startActivity(new Intent(MainActivity6.this, MainActivity4.class));
                break;
            case R.id.cal_time:
                startActivity(new Intent(MainActivity6.this, MainActivity5.class));
                break;


            case R.id.cal_data:
                startActivity(new Intent(MainActivity6.this, MainActivity6.class));
                break;




        }

        return true;
    }

}