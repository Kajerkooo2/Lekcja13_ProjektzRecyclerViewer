package com.example.skrotymyslowe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MysliAdapter extends RecyclerView.Adapter<MysliAdapter.MysliViewHolder> {

    private List<Mysl> mysliList;

    public MysliAdapter(List<Mysl> mysliList) {
        this.mysliList = mysliList;
    }

    @NonNull
    @Override
    public MysliViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mysli_layout, parent, false);
        return new MysliViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MysliViewHolder holder, int position) {
        Mysl mysl = mysliList.get(position);
        holder.textView.setText(mysl.getMysl());
        holder.imageView.setImageResource(mysl.getLandscape());
    }

    @Override
    public int getItemCount() {
        return mysliList.size();
    }

    public class MysliViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public MysliViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}