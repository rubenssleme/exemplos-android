package com.example.volleydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<MainData> dataArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_view);
        String url =  "https://apirest-produto1.herokuapp.com/api/produtos";

        ProgressDialog dialog =  new ProgressDialog(this);
        dialog.setMessage("Aguarde ....");
        dialog.setCancelable(true);
        dialog.show();

        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response!=null){
                dialog.dismiss();
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        parseArray(jsonArray);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                Log.d("Erro ",error.toString());
            }
        });

        RequestQueue  requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    private void parseArray(JSONArray jsonArray) {
        for (int i=0; i< jsonArray.length();i++){
            try {
                JSONObject object  = jsonArray.getJSONObject(i);
                MainData data = new MainData();
                data.setId(object.getString("id"));
                data.setNome(object.getString("nome"));
                data.setQuantidade(object.getString("quantidade"));
                data.setValor(object.getString("valor"));
                dataArrayList.add(data);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            listView.setAdapter(new BaseAdapter() {
                @Override
                public int getCount() {
                    return dataArrayList.size();
                }

                @Override
                public Object getItem(int i) {
                    return null;
                }

                @Override
                public long getItemId(int i) {
                    return 0;
                }

                @Override
                public View getView(int i, View view, ViewGroup viewGroup) {
                   View  view1 = getLayoutInflater().inflate(R.layout.activity_main,null);
                   MainData mainData = dataArrayList.get(i);
                    return view1;
                }
            });

        }
    }
}