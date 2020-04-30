package com.example.RestApiJson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private TextView textView ;
    private RequestQueue mrequestque;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);
        Button parsebutton = findViewById(R.id.parse_btn);

        mrequestque = Volley.newRequestQueue(this);

        parsebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });
    }

    private void jsonParse(){
        String urlapi = "https://jsonplaceholder.typicode.com/todos/1";

        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, urlapi,null,
                new Response.Listener<JSONObject>() {
                    @Override


                    public void onResponse(JSONObject response) {
                        try {


                                String firstName = response.getString("title");
                                int age = response.getInt("userId");


                               textView.setText(firstName + ", " + String.valueOf(age) + ", " + "\n\n");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }

                });
        mrequestque.add(request);
    }
}

