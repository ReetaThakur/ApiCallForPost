package com.example.apicallforpost;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private EditText title;
    private EditText request;
    private Button click;
    private TextView titleFetch;
    private TextView body;
    private TextView emailFetch;
    private TextView passFetch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=findViewById(R.id.edtemail);
        password=findViewById(R.id.edtpassword);
        title=findViewById(R.id.edttitle);
        request=findViewById(R.id.edtrequest);
        titleFetch=findViewById(R.id.txttitle);
        body=findViewById(R.id.txtrequest);
        emailFetch=findViewById(R.id.txtemial);
        passFetch=findViewById(R.id.txtpassword);
        click=findViewById(R.id.btnclick);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApit();
            }
        });

    }

    private void callApit() {
        ApiService apiService=Network.getInstance().create(ApiService.class);
        apiService.getPost().enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                ResponseModel model=response.body();
                String titleset=model.getTitle();
                String bodyset=model.getBody();
                body.setText(bodyset);
                title.setText(titleset);
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });
    }
}