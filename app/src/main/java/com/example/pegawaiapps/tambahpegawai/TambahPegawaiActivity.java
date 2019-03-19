package com.example.pegawaiapps.tambahpegawai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pegawaiapps.R;
import com.example.pegawaiapps.model.ResponseTambahPegawai;
import com.example.pegawaiapps.network.NetworkClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahPegawaiActivity extends AppCompatActivity {

    //inisialisasi widget view
    EditText etNama, etEmail, etNoHp, etAlamat;
    Button btnInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_pegawai);

        //deklarasi widget view
        etNama = findViewById(R.id.etAlamatPegawai);
        etEmail = findViewById(R.id.etEmailPegawai);
        etNoHp = findViewById(R.id.etNoHpPegawai);
        etAlamat = findViewById(R.id.etAlamatPegawai);
        btnInput = findViewById(R.id.btnInputPegawai);

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionInputPegawai();
            }
        });

    }

    private void actionInputPegawai() {
        String namaPegawai = etNama.getText().toString();
        String emailPegawai = etEmail.getText().toString();
        String noHpPegawai = etNoHp.getText().toString();
        String alamatPegawai = etAlamat.getText().toString();

        if (TextUtils.isEmpty(namaPegawai)) {
            etNama.setError("Nama Pegawai tidak boleh kosong !!");
            etNama.requestFocus();
        } else if (TextUtils.isEmpty(emailPegawai)) {
            etEmail.setError("Email Tidak Boleh Kosong");
            etEmail.requestFocus();
        } else if (TextUtils.isEmpty(noHpPegawai)) {
            etNoHp.setError("No Hp Tidak Boleh Kosong");
            etNoHp.requestFocus();
        } else if (TextUtils.isEmpty(alamatPegawai)) {
            etAlamat.setError("Email Tidak Boleh Kosong");
            etAlamat.requestFocus();

        } else {
            NetworkClient.service.tambah_pegawai(namaPegawai, emailPegawai, noHpPegawai, alamatPegawai)
                    .enqueue(new Callback<ResponseTambahPegawai>() {
                        @Override
                        public void onResponse(Call<ResponseTambahPegawai> call, Response<ResponseTambahPegawai> response) {
                            if (response.isSuccessful()) {
                                Boolean status = response.body().isStatus();
                                String pesan = response.body().getPesan();

                                if (status) {
                                    startActivity(new Intent(TambahPegawaiActivity.this, TambahPegawaiActivity.class));
                                    Toast.makeText(TambahPegawaiActivity.this, pesan, Toast.LENGTH_SHORT).show();

                                } else {
                                    Toast.makeText(TambahPegawaiActivity.this, pesan, Toast.LENGTH_SHORT).show();
                                }
                            }
                        }


                        @Override
                        public void onFailure(Call<ResponseTambahPegawai> call, Throwable t) {
                            t.printStackTrace();
                        }
                    });
        }

    }

}
