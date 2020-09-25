package com.example.arslanprojectretrofloating.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.arslanprojectretrofloating.Model.Example;
import com.example.arslanprojectretrofloating.Utils.AppClient;
import com.example.arslanprojectretrofloating.Adapters.EmployeeAdapter;
import com.example.arslanprojectretrofloating.Model.LoginObject;
import com.example.arslanprojectretrofloating.Model.ObjectName2;
import com.example.arslanprojectretrofloating.R;
import com.example.arslanprojectretrofloating.Utils.RetrofitLoginInterface;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    ArrayList<LoginObject> arrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    EmployeeAdapter adapter;
    Button btnDel;
    private RetrofitLoginInterface retrofitInterface;
    Button btn_del;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        retrofitInterface = AppClient.getClient().create(RetrofitLoginInterface.class);
       serverLogin();

        //for delete
        btn_del = (Button) findViewById(R.id.btn_del);
        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Delete();
            }

        });

        //floating button for new intent DisplayMessageActivity
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(LoginActivity.this, DisplayMessageActivity.class);
                startActivity(intent);
            }
        });
    }
    //call.enqueue evokes retro fit call
    private void serverLogin() {

        Call<ObjectName2> call = retrofitInterface.arrayList();
        call.enqueue(new Callback<ObjectName2>() {

            @Override
            public void onResponse(Call<ObjectName2> call, Response<ObjectName2> response) {
                generateDataList(response.body().getData());
            }

            @Override
            public void onFailure(Call<ObjectName2> call, Throwable t) {
                // t.toString();
                Log.d("TAG", "Response = " + t.toString());
            }
        });
    }
    //https://codingwithmitch.com/blog/android-retrofit2-getting-started/
    //above link for generating data list
    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(ArrayList<LoginObject> arrayList) {
        recyclerView = findViewById(R.id.recyclerView1);
        this.arrayList = arrayList;
        adapter = new EmployeeAdapter(this, arrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(LoginActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    //delete
  public void Delete() {
        Call<Example> call = retrofitInterface.deletePost(719 + "");
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
             Toast.makeText(LoginActivity.this, "Entery is Deleted Successfully", Toast.LENGTH_SHORT).show();
                response.body();
            }
            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                t.toString();
            }
        });
    }
}