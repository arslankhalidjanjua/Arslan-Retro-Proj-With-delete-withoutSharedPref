package com.example.arslanprojectretrofloating.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.arslanprojectretrofloating.Model.LoginObject;
import com.example.arslanprojectretrofloating.R;
import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.MyViewHolder> {
    private ArrayList<LoginObject> arrayList;
    private Context context;

    //constructor
    public EmployeeAdapter(Context context, ArrayList<LoginObject> arrayList){
        this.context = context;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public EmployeeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull EmployeeAdapter.MyViewHolder holder, int position) {
        holder.employee_name.setText(arrayList.get(position).getEmployee_name());
        holder.employee_salary.setText(arrayList.get(position).getEmployee_salary());
        holder.employee_age.setText(arrayList.get(position).getEmployee_age() );

        Glide.with(context) //1
                .load("https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50?s=200&r=pg&d=404")
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(holder.profile_image);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView employee_salary;
        ImageView profile_image;
        TextView employee_name;
        TextView employee_age;
        public MyViewHolder(View itemView) {
            super(itemView);
            employee_name =  itemView.findViewById(R.id.employee_name);
            employee_salary =  itemView.findViewById(R.id.employee_salary);
            employee_age =itemView.findViewById(R.id.employee_age);
            profile_image=itemView.findViewById(R.id.profile_image);
        }
    }
}
