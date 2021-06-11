package com.example.hesapmakinesi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button
            btn0,
            btn1,
            btn2,
            btn3,
            btn4,
            btn5,
            btn6,
            btn7,
            btn8,
            btn9,
            btnTopla,
            btnCikar,
            btnBol,
            btnCarp,
            btnEsittir,
            btnSifirla;

    Double ilkSayi;
    TextView hesapEkrani;
    Boolean virgulDurum;
    String islemDurum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnTopla = findViewById(R.id.btnTopla);
        btnCikar = findViewById(R.id.btnCikar);
        btnBol = findViewById(R.id.btnBol);
        btnCarp = findViewById(R.id.btnCarp);
        btnEsittir = findViewById(R.id.btnEsittir);
        btnSifirla = findViewById(R.id.btnSifirla);

        hesapEkrani = findViewById(R.id.hesapEkrani);

        hesapEkrani.setText("0");
        ilkSayi = 0.0;
        virgulDurum = false;
        islemDurum = "0";
        btnEsittir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_SEMBOL("=");
            }
        });
        btnTopla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_SEMBOL("+");
            }
        });
        btnCikar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_SEMBOL("-");
            }
        });
        btnCarp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_SEMBOL("*");
            }
        });
        btnBol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_SEMBOL("/");
            }
        });
        btnSifirla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_SEMBOL("sifirla");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_NUMARA(0);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_NUMARA(1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_NUMARA(2);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_NUMARA(3);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_NUMARA(4);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_NUMARA(5);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_NUMARA(6);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_NUMARA(7);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_NUMARA(8);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_NUMARA(9);
            }
        });
    }

    private void TIKLA_NUMARA(int sayi)
    {
        if(hesapEkrani.getText().toString() == "0"){
            hesapEkrani.setText("");
        }
        else if(
                hesapEkrani.getText().toString() == "+" ||
                        hesapEkrani.getText().toString() == "*" ||
                        hesapEkrani.getText().toString() == "/"||
                        hesapEkrani.getText().toString() == "-"        )
        {
            hesapEkrani.setText("");
        }
        hesapEkrani.setText(hesapEkrani.getText() + String.valueOf(sayi));
    }
    private void TIKLA_SEMBOL(String sembol)
    {
        switch (sembol)
        {
            default:
            {
                if(hesapEkrani.getText().toString() == "+" || hesapEkrani.getText().toString() == "*"
                        || hesapEkrani.getText().toString() == "/" || hesapEkrani.getText().toString() == "-")
                {
                    if(islemDurum == "*" || islemDurum == "/")
                        ilkSayi = -1*ilkSayi;

                    hesapEkrani.setText(sembol);
                    islemDurum = sembol;
                }
                else
                {
                    ilkSayi = Double.parseDouble(hesapEkrani.getText().toString());
                    hesapEkrani.setText(sembol);
                    islemDurum = sembol;
                }
            }
            break;
            case "sifirla":
            {
                ilkSayi = 0.0;
                hesapEkrani.setText("0");
                islemDurum = "0";
            }
            break;
            case "=":
            {
                if(hesapEkrani.getText().toString() == "+" || hesapEkrani.getText().toString() == "*"
                        || hesapEkrani.getText().toString() == "/" || hesapEkrani.getText().toString() == "-")
                {

                }
                else
                {
                    switch (islemDurum)
                    {
                        default:
                        {
                            hesapEkrani.setText(ilkSayi.toString());
                        }
                        break;
                        case "+":
                        {
                            ilkSayi = ilkSayi + Double.parseDouble(hesapEkrani.getText().toString());
                            hesapEkrani.setText(ilkSayi.toString());
                        }
                        break;
                        case "-":
                        {
                            ilkSayi = ilkSayi - Double.parseDouble(hesapEkrani.getText().toString());
                            hesapEkrani.setText(ilkSayi.toString());
                        }
                        break;
                        case "/":
                        {
                            ilkSayi = ilkSayi / Double.parseDouble(hesapEkrani.getText().toString());
                            hesapEkrani.setText(ilkSayi.toString());
                        }
                        break;
                        case "*":
                        {
                            ilkSayi = ilkSayi * Double.parseDouble(hesapEkrani.getText().toString());
                            hesapEkrani.setText(ilkSayi.toString());
                        }
                        break;
                    }
                }


            }
            break;
            case ",":
            {

            }
            break;
        }
    }
}

