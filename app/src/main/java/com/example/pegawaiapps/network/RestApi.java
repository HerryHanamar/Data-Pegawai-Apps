package com.example.pegawaiapps.network;


import com.example.pegawaiapps.model.ResponseTambahPegawai;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RestApi {

    @FormUrlEncoded
    @POST("tambah_pegawai")
    Call<ResponseTambahPegawai> tambah_pegawai(
            @Field("nama_pegawai") String namaPegawai,
            @Field("email_pegawai") String emailPegawai,
            @Field("no_hp_pegawai") String noHpPegawai,
            @Field("alamat_pegawai") String alamatPegawai
    );
}
