package com.example.x455l.magiccalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //To do List:
    //1. Define semua element UI yang ada di Activity
    //2. Sambungkan semua element UI dengan variabel local
    //3. Logic development

    //1
    private EditText edtAngkaSatu, edtAngkaDua;
    private Button btnCalculate, btnPindahPage;
    private TextView txtHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //2
        edtAngkaSatu = (EditText)findViewById(R.id.edt_angka_satu);
        edtAngkaDua = (EditText)findViewById(R.id.edt_angka_dua);
        txtHasil = (TextView)findViewById(R.id.txt_hasil);
        btnCalculate = (Button)findViewById(R.id.btn_hitung);
        btnCalculate.setOnClickListener(this);
        btnPindahPage = (Button)findViewById(R.id.btn_pindah_page);
        btnPindahPage.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_hitung){

            // dibawah ini convert ke string untuk cek dia gaboleh kosong
            String as = edtAngkaSatu.getText().toString().trim();
            //trim itu potong jaga2 kalo user kasih spasi
            String ad = edtAngkaDua.getText().toString().trim();
            boolean isEmptyFields = false;

            //ini untuk filter kalo dia gaboleh kosong
            if (TextUtils.isEmpty(as)){
                isEmptyFields = true;
                edtAngkaSatu.setError("Field ini tidak boleh kosong!");
            }

            if (TextUtils.isEmpty(ad)){
                isEmptyFields = true;
                edtAngkaDua.setError("Field ini tidak boleh kosong!");
            }

            if (!isEmptyFields){
                Double angka_s = Double.parseDouble(as);
                Double angkad_d = Double.parseDouble(ad);
                Double hasil_result = angka_s + angkad_d;
                txtHasil.setText(String.valueOf(hasil_result));
            }
        }else if (view.getId() == R.id.btn_pindah_page){
            Intent moveIntent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(moveIntent);
        }

    }
}
