package com.example.arslanprojectretrofloating.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.arslanprojectretrofloating.Model.Data;
import com.example.arslanprojectretrofloating.Model.Example;
import com.example.arslanprojectretrofloating.R;
import com.example.arslanprojectretrofloating.Utils.AppClient;
import com.example.arslanprojectretrofloating.Utils.RetrofitLoginInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DisplayMessageActivity extends AppCompatActivity {

    private RetrofitLoginInterface retrofitInterface;
    EditText empAge,edName,edSalary;
    Button loginSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        empAge=findViewById(R.id.edAge);
        edName=findViewById(R.id.edName);
        edSalary=findViewById(R.id.edSalary);

        //button
        loginSub = (Button) findViewById(R.id.loginSub);

        //yaha say interface ka name deina h .class say pahly
        //initialize interface here
        retrofitInterface = AppClient.getClient().create(RetrofitLoginInterface.class);

        loginSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Data data = new Data(edName.getText().toString(), edSalary.getText().toString(), empAge.getText().toString());
                Call<Example> call = retrofitInterface.createPost(data);

                //enqueue call is here for callback data object
                call.enqueue(new Callback<Example>() {
                    @Override
                    public void onResponse(Call<Example> call, Response<Example> response) {
                        if(response.isSuccessful())
                        {
                            Example data = response.body();
                            Toast.makeText(DisplayMessageActivity.this, "Entery Name  "+ edName.getText() +"  Age = "+empAge.getText()+ " is added Successfully", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }

                    @Override
                    public void onFailure(Call<Example> call, Throwable t) {
                        Toast.makeText(DisplayMessageActivity.this,
                                "Error is " + t.getMessage()
                                , Toast.LENGTH_LONG).show();
                    }
                });
            }

        });
    }
}