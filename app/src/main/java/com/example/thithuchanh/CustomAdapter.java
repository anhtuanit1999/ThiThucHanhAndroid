package com.example.thithuchanh;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thithuchanh.api.APIService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    Context context;
    List<User> mUsers;
    onClickListener listener;

    public CustomAdapter(Context ctx, List<User> users,onClickListener listener1) {
        context = ctx;
        mUsers = users;
        listener = listener1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycle,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  CustomAdapter.ViewHolder holder, int position) {
        User user = mUsers.get(position);
        holder.muser = user;
        holder.tvStt.setText(user.getId());
        holder.tvName.setText(user.getName());
        holder.tvAge.setText(user.getAge());
        holder.tvDepart.setText(user.getDepartment());
        
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                APIService.apiService.deleteUser(user.getId()).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {

                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                    }
                });
            }
        });

        holder.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context ctx = new MainActivity().getBaseContext();
                Intent intent = new Intent(ctx, UpdateActivity.class);
                Toast.makeText(ctx, "success", Toast.LENGTH_SHORT).show();
                ctx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public void setList(List<User> users) {
        mUsers = users;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvAge, tvDepart, tvStt;
        Button btnUpdate, btnDelete;
        User muser;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvStt = itemView.findViewById(R.id.tvStt);
            tvName = itemView.findViewById(R.id.tvName_main);
            tvAge = itemView.findViewById(R.id.tvAge_main);
            tvDepart = itemView.findViewById(R.id.tvDepart_main);

            btnUpdate = itemView.findViewById(R.id.btnUdate_main);
            btnDelete = itemView.findViewById(R.id.btnDelete_main);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.ClickItem(muser);
                }
            });
        }

    }
}
