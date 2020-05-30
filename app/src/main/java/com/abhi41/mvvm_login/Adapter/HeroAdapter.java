package com.abhi41.mvvm_login.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abhi41.mvvm_login.Model.HeroModel;
import com.abhi41.mvvm_login.Model.StateModel;
import com.abhi41.mvvm_login.R;
import com.abhi41.mvvm_login.RecyclerviewActivity;
import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.ViewHolder> {

    private List<HeroModel> heroModelArrayList;
    private List<StateModel> stateModels;
    private Context context;


    public HeroAdapter(RecyclerviewActivity recyclerviewActivity, List<HeroModel> heroModels) {
        this.heroModelArrayList = heroModels;
        this.context = recyclerviewActivity;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_place, parent, false);
        return new HeroAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroAdapter.ViewHolder holder, int position) {

        HeroModel heroModel = heroModelArrayList.get(position);

        holder.txtPlace.setText(heroModel.getName());
        Glide.with(context)
                .load(heroModel.getImageurl())
                .into(holder.profile_image);
    }


    @Override
    public int getItemCount() {
        return heroModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView profile_image;
        private TextView txtPlace;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtPlace = itemView.findViewById(R.id.txtPlace);
            profile_image = itemView.findViewById(R.id.profile_image);


        }
    }
}
