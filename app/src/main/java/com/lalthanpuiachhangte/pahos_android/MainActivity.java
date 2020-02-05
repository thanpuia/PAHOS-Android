package com.lalthanpuiachhangte.pahos_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

   String mURL ="http://10.180.243.4:8000/api/android";
   //    String mURL ="https://10.180.243.10:8000/showAllArea";
   // String mURL ="https://api.chucknorris.io/jokes/random";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void LoginClick(View view) {
    }

    public void registerClick(View view) {
        startActivity(new Intent(this,RegistrationActivity.class));

        //test start
//        try{
//            Ion.with(this)
//                    .load(mURL)
//                    .setBodyParameter("name", "ANDROID!")
////                    .setBodyParameter("email", "email@email.com")
////                    .setBodyParameter("phone", "66666666")
////                    .setBodyParameter("password", "77777777")
//
//                    .asJsonObject()
//                    .setCallback(new FutureCallback<JsonObject>() {
//                        @Override
//                        public void onCompleted(Exception e, JsonObject result) {
//                            Log.e("result","result: "+result+". Exception:"+e);
//                            Log.e("result: ","url: "+mURL);
//                        }
//                    });
//        }catch (Exception e) {
//            Toasty.error(getApplicationContext(), "Server Error, please try again after sometime", Toasty.LENGTH_SHORT).show();
//        }
        //test end


    }
}
