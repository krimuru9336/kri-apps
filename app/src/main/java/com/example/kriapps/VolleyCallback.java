package com.example.kriapps;

import org.json.JSONException;

public interface VolleyCallback {
    void onSuccess(String result) throws JSONException;
    void onError(String result);
}
