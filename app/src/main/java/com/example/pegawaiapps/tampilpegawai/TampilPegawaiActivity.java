package com.example.pegawaiapps.tampilpegawai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;

import com.example.pegawaiapps.R;
import com.example.pegawaiapps.network.NetworkClient;
import com.example.pegawaiapps.tambahpegawai.TambahPegawaiActivity;
import com.example.pegawaiapps.tampilpegawai.adapter.AdapterTampilPegawai;
import com.example.pegawaiapps.tampilpegawai.model.DataItem;
import com.example.pegawaiapps.tampilpegawai.model.ResponseTampilPegawai;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TampilPegawaiActivity extends AppCompatActivity {

    //inisialisasi
    private RecyclerView rvDataPegawai;
    private List<DataItem> dataItemList;
    Button btnTambahPegawai ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_pegawai);

        //deklarasi
        rvDataPegawai = findViewById(R.id.rvListPegawai);
        dataItemList = new ArrayList<>();
        btnTambahPegawai = findViewById(R.id.btnTambahPegawai);

        //beri action untuk pindah ke form tambah
        btnTambahPegawai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TampilPegawaiActivity.this,TambahPegawaiActivity.class));
            }
        });

        //menggunakan methode getListDataPegawai
        getListDataPegawai();
    }

    private void getListDataPegawai() {
        try {

        NetworkClient.service.tampil_pegawai().enqueue(new Callback<ResponseTampilPegawai>() {
            @Override
            public void onResponse(Call<ResponseTampilPegawai> call, Response<ResponseTampilPegawai> response) {
                if (response.isSuccessful()) {
                    dataItemList = response.body().getData();
                    AdapterTampilPegawai adapterTampilPegawai = new AdapterTampilPegawai(TampilPegawaiActivity.this, dataItemList);
                    rvDataPegawai.setLayoutManager(new LinearLayoutManager(TampilPegawaiActivity.this, LinearLayoutManager.VERTICAL, true));
                    rvDataPegawai.setAdapter(adapterTampilPegawai);


                }
            }

            @Override
            public void onFailure(Call<ResponseTampilPegawai> call, Throwable t) {

            }
        });
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
