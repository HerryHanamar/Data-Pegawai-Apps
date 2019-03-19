package com.example.pegawaiapps.detailpegawai;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.pegawaiapps.R;
import com.example.pegawaiapps.tampilpegawai.model.DataItem;

public class DetailPegawaiActivity extends AppCompatActivity {

    //inisialisasi
    TextView tvDetailNama, tvDetailEmail, tvDetailAlamat, tvDetailNoHp;
    DataItem dataItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pegawai);

        //deklarasi
        tvDetailNama = findViewById(R.id.tvDetailNama);
        tvDetailEmail = findViewById(R.id.tvDetailEmail);
        tvDetailAlamat = findViewById(R.id.tvDetailAlamat);
        tvDetailNoHp = findViewById(R.id.tvDetailNoHp);

        //tampung data di string
//        String namaPegawai = getIntent().getStringExtra("nama_pegawai");
//        String emailPegawai = getIntent().getStringExtra("email_pegawai");
//        String hpPegawai = getIntent().getStringExtra("no_hp_pegawai");
//        String alamatPegawai = getIntent().getStringExtra("alamat_pegawai");

        dataItem = (DataItem)getIntent().getSerializableExtra("data_pegawai");


        tvDetailNama.setText(dataItem.getNamaPegawai());
        tvDetailNoHp.setText(dataItem.getNoHpPegawai());
        tvDetailEmail.setText(dataItem.getEmailPegawai());
        tvDetailAlamat.setText(dataItem.getAlamatPegawai());











    }
}
