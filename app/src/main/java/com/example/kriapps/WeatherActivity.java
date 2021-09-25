package com.example.kriapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpStack;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.security.ProviderInstaller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class WeatherActivity extends AppCompatActivity {

    String apiId = "303aac6e391c435fa90269c68917f233";

    TextView temperature;
    TextView sunrise;
    TextView sunset;
    TextView description;
    EditText cityName;
    Button getWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        cityName = findViewById(R.id.cityName);
//        cityName.setText("fulda");
        getWeather = findViewById(R.id.btVar1);
        temperature = findViewById(R.id.temperature);
        sunrise = findViewById(R.id.sunrise);
        sunset = findViewById(R.id.sunset);
        description = findViewById(R.id.description);


        getWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cityNameString = cityName.getText().toString();
                try {
                    setWeatherUrlByCity(cityNameString);
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(WeatherActivity.this, "Error in finding city", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    private void setWeatherUrlByCity(String cityName) throws JSONException {

        String cityUrl = "https://geocode.xyz/" + cityName + "?json=1";

        //hitApi(Request.Method.GET, cityUrl);
        hitApiGet(new VolleyCallback() {
            @Override
            public void onSuccess(String result) throws JSONException {
                String url = "";
                double latitude = 0.0;
                double longitude = 0.0;
                JSONObject object = new JSONObject(result);
                latitude = Double.parseDouble(object.get("latt").toString());
                longitude = Double.parseDouble(object.get("longt").toString());
                url = "https://api.weatherbit.io/v2.0/current?lat=" + latitude + "&lon=" + longitude + "&key=" + apiId;

                displayWeather(url);
            }

            @Override
            public void onError(String result) {
                Toast.makeText(WeatherActivity.this, result, Toast.LENGTH_SHORT).show();
            }
        }, cityUrl);
    }


    private void displayWeather(String weatherUrl) {
        hitApiGet(new VolleyCallback() {
            @Override
            public void onSuccess(String result) throws JSONException {
                Toast.makeText(WeatherActivity.this, result, Toast.LENGTH_SHORT).show();
                try {
                    JSONObject root = new JSONObject(result);
                    JSONArray data = root.getJSONArray("data");
                    JSONObject dataJSONObject = data.getJSONObject(0);
                    JSONObject weatherObject = dataJSONObject.getJSONObject("weather");
                    temperature.setText(dataJSONObject.getString("temp") + "");
                    sunrise.setText(dataJSONObject.getString("sunrise") + "");
                    sunset.setText(dataJSONObject.getString("sunset") + "");
                    description.setText(weatherObject.getString("description") + "");
                    Toast.makeText(WeatherActivity.this, dataJSONObject + "", Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(WeatherActivity.this, "Error while displaying weather", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onError(String result) {
                Toast.makeText(WeatherActivity.this, result, Toast.LENGTH_SHORT).show();
            }
        }, weatherUrl);
    }


    public void hitApiGet(final VolleyCallback callback, String url) {
        StringRequest strReq = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            callback.onSuccess(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(WeatherActivity.this, "Error while hitting API", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                callback.onError(volleyError + "");
            }
        });
        Volley.newRequestQueue(this).add(strReq);
    }


    public void hitApiPost1(final VolleyCallback callback, String url) {


        try {
            ProviderInstaller.installIfNeeded(this);
        } catch (Exception e) {
            e.getMessage();
        }

        RequestQueue requestQueue;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN
                && Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {

            HttpStack stack = null;
            try {
                stack = new HurlStack(null, new TLSSocketFactory());
            } catch (KeyManagementException e) {
                e.printStackTrace();
                Log.d("Your Wrapper Class", "Could not create new stack for TLS v1.2");
                stack = new HurlStack();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                Log.d("Your Wrapper Class", "Could not create new stack for TLS v1.2");
                stack = new HurlStack();
            }
            requestQueue = Volley.newRequestQueue(this, stack);
        } else {
            requestQueue = Volley.newRequestQueue(this);
        }

        StringRequest strReq = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            callback.onSuccess(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(WeatherActivity.this, "Error while hitting API", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                callback.onError(volleyError + "");
            }
        })

        {
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("text","hi");

                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("Content-Type","application/json");
                params.put("accept-charset","utf-8");
                return params;
            }

        };
        requestQueue.add(strReq);

        //Volley.newRequestQueue(this);
    }




    public void hitApiPost(String url) {

        try {
            ProviderInstaller.installIfNeeded(this);
        } catch (Exception e) {
            e.getMessage();
        }

        RequestQueue requestQueue;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN
                && Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {

            HttpStack stack = null;
            try {
                stack = new HurlStack(null, new TLSSocketFactory());
            } catch (KeyManagementException e) {
                e.printStackTrace();
                Log.d("Your Wrapper Class", "Could not create new stack for TLS v1.2");
                stack = new HurlStack();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                Log.d("Your Wrapper Class", "Could not create new stack for TLS v1.2");
                stack = new HurlStack();
            }
            requestQueue = Volley.newRequestQueue(this, stack);
        } else {
            requestQueue = Volley.newRequestQueue(this);
        }


        Map<String, String> params = new HashMap<String, String>();
        params.put("text", "hi");


        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, new JSONObject(params),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(WeatherActivity.this, "Response: "+ response, Toast.LENGTH_SHORT).show();
                    }


                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(WeatherActivity.this, "Error while hitting chatbot API", Toast.LENGTH_SHORT).show();
                Log.e("Chatbot Api Hit Error",volleyError+"");
            }
        })

        {
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("text","hi");

                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("Content-Type","application/json");
                params.put("accept-charset","utf-8");
                return params;
            }

        };
        requestQueue.add(jsonObjReq);

        //Volley.newRequestQueue(this);
    }

}