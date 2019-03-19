package com.example.pegawaiapps.tampilpegawai.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pegawaiapps.R;
import com.example.pegawaiapps.tampilpegawai.model.DataItem;

import java.util.List;

public class AdapterTampilPegawai extends RecyclerView.Adapter<AdapterTampilPegawai.MyHolder> {

    public AdapterTampilPegawai(Context context, List<DataItem> dataItemList) {
        this.context = context;
        this.dataItemList = dataItemList;
    }

    Context context;
    List<DataItem> dataItemList;


    @NonNull
    @Override
    public AdapterTampilPegawai.MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_pegawai,viewGroup,false);
        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterTampilPegawai.MyHolder myHolder, int position) {
        final DataItem dataItem = dataItemList.get(position);

        myHolder.idPegawai.setText(dataItem.getIdPegawai());
        myHolder.namaPegawai.setText(dataItem.getNamaPegawai());
        myHolder.emailPegawai.setText(dataItem.getEmailPegawai());

    }

    @Override
    public int getItemCount() {
        return dataItemList.size();
    }

    //menyambungkan ke item dari layout item_list_data
    public class MyHolder extends RecyclerView.ViewHolder {
        public TextView namaPegawai,emailPegawai,idPegawai;
        public MyHolder(@NonNull View itemView) {
            super(itemView);

            namaPegawai = itemView.findViewById(R.id.tvNamaPegawai);
            emailPegawai = itemView.findViewById(R.id.tvEmailPegawai);
            idPegawai = itemView.findViewById(R.id.tvIdPegawai);
        }
    }
}
