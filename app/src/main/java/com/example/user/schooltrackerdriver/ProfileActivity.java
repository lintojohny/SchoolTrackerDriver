package com.example.user.schooltrackerdriver;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.user.schooltrackerdriver.Retrofit.RetrofitHelper;
import com.google.gson.JsonElement;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {

    String action="profile";
    int user_Id=1;
    TextView  name,classa,userName,phoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        name=findViewById(R.id.profile_name);
        classa=findViewById(R.id.profile_class);
        userName=findViewById(R.id.profile_username);
        phoneNumber=findViewById(R.id.profile_phoneNumber);
        new RetrofitHelper(ProfileActivity.this).getApi().getProfile(action,user_Id).enqueue(
                new Callback<JsonElement>() {
                    @Override
                    public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response.body().toString());
                            String namee=jsonObject.getString("name");
                            String email=jsonObject.getString("email");
                            String phone=jsonObject.getString("phone");
                            String user_name=jsonObject.getString("user_name");
                            String bus_name=jsonObject.getString("bus_name");
                            String bus_number=jsonObject.getString("bus_number");
                            String bus_root=jsonObject.getString("bus_root");



                            name.setText(namee);
                            classa.setText(bus_name+" - "+bus_number+" - "+" ("+bus_root+")");
                            phoneNumber.setText(phone);
                            userName.setText(user_name+" ("+email+")");



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonElement> call, Throwable t) {

                    }
                }
        );
    }
}
