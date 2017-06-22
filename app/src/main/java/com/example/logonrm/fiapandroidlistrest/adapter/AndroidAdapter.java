package com.example.logonrm.fiapandroidlistrest.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.logonrm.fiapandroidlistrest.R;
import com.example.logonrm.fiapandroidlistrest.model.Android;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AndroidAdapter extends RecyclerView.Adapter<AndroidAdapter.AndroidViewHolder> {

    List<Android> androids;

    public AndroidAdapter (List<Android> androids) {
        this.androids = androids;
    }

    @Override
    public AndroidViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View meuLayout = inflater.inflate(R.layout.android_row, parent, false);

        return new AndroidViewHolder(meuLayout);
    }

    @Override
    public void onBindViewHolder(AndroidViewHolder holder, int position) {
        holder.tvTitulo.setText(androids.get(position).getNome());
        holder.tvSubTitulo.setText(androids.get(position).getVersao());

        Picasso.with(holder.itemView.getContext())
                .load(androids.get(position).getUrlImagem())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.ivLogo);
    }

    @Override
    public int getItemCount() {
        return androids.size();
    }

    public void update(List<Android> androids) {
        this.androids = androids;
        notifyDataSetChanged();
    }

    public class AndroidViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivLogo;
        public TextView tvTitulo;
        public  TextView tvSubTitulo;

        public AndroidViewHolder(View itemView) {
            super(itemView);

            ivLogo = (ImageView) itemView.findViewById(R.id.ivLogo);
            tvTitulo = (TextView) itemView.findViewById(R.id.tvTitulo);
            tvSubTitulo = (TextView) itemView.findViewById(R.id.tvSubTitulo);
        }
    }
}
