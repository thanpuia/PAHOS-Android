package com.lalthanpuiachhangte.pahos_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.lalthanpuiachhangte.pahos_android.entity.UserClass;

import es.dmoral.toasty.Toasty;

public class RegistrationActivity extends AppCompatActivity {

    EditText name, email, phone, password;
    String mURL ="http://10.180.243.4:8000/api/android";
    //String mURL ="https://api.chucknorris.io/jokes/random";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name = findViewById(R.id.regName);
        email = findViewById(R.id.regEmail);
        phone = findViewById(R.id.regPhone);
        password = findViewById(R.id.regPassword);
    }

    public void Register(View view) {

        UserClass mUser = new UserClass();
        mUser.setName(name.getText().toString());
//        mUser.setEmail(email.getText().toString());
//        mUser.setPhone(phone.getText().toString());
//        mUser.setPassword(password.getText().toString());

        //CONVERT THE USER OBJECT TO NORMAL JsonObject
        GsonBuilder gsonMapBuilder = new GsonBuilder();
        Gson gsonObject = gsonMapBuilder.create();
        String jsonObj = gsonObject.toJson(mUser);

        JsonObject convertedObject = new Gson().fromJson(jsonObj, JsonObject.class);
        Log.e("result","data: "+convertedObject);

        try{
            Ion.with(this)
                    .load(mURL)
                    .setJsonObjectBody(convertedObject)
                    .asString()
                    .setCallback(new FutureCallback<String>() {
                        @Override
                        public void onCompleted(Exception e, String result) {
                            Log.e("result","result: "+result+". Exception:"+e);
                            Log.e("result: ","url: "+mURL);

                        }
                    });
        }catch (Exception e) {
            Toasty.error(getApplicationContext(), "Server Error, please try again after sometime", Toasty.LENGTH_SHORT).show();
        }

    }


/*
    public void registerToServer(){

        showProgressDialog();

        String url =  "http://" + mURL + ":8080/add";

        JsonObject mUser = userObjectToJsonObject();

        try{
            Ion.with(this)
                    .load("POST",url)
                    .setJsonPojoBody(mUser)
                    .asString()
                    .setCallback(new FutureCallback<String>() {
                        @Override
                        public void onCompleted(Exception e, String result) {
                            // do stuff with the result or error
                            if(result.equals("user added successfully...")){
                                Toasty.success(getApplicationContext(), "Registration successful", Toasty.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }else if(result.equals("Username Exist")){
                                Toasty.error(getApplicationContext(), "User Name already exist!", Toasty.LENGTH_SHORT).show();
                            }else if(result.equals("Phoneno Exist")){
                                Toasty.error(getApplicationContext(), "Phone number already exist!", Toasty.LENGTH_SHORT).show();
                            }else if(result.equals("Email Exist")){
                                Toasty.error(getApplicationContext(), "Email already exist!", Toasty.LENGTH_SHORT).show();
                            }else {
                                Toasty.error(getApplicationContext(), "Server error!", Toasty.LENGTH_SHORT).show();

                            }

                            Log.i("TAG", result+"");
                            dismissProgressDialog();

                        }
                    });
        }catch (Exception e) {
            Toasty.error(getApplicationContext(), "Server Error, please try again after sometime", Toasty.LENGTH_SHORT).show();
            dismissProgressDialog();
        }
    }*/
}
