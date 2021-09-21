package com.example.consumoapicep;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Async extends AsyncTask {
   TextView textViewEndereco;
   String cep;
    public Async(TextView textViewEndereco, String cep) {
        this.textViewEndereco = textViewEndereco;
        this.cep= cep;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        InputStream inputStream = null;
        String endereco = "";
        try {
            //
           // URL url = new URL("http://viacep.com.br/ws/" +cep+"/json/");
            //URL url = new URL("https://5f9b67a1856f4c00168be719.mockapi.io/users/id");
            URL url = new URL("https://apirest-produto1.herokuapp.com/api/produtos");
            HttpURLConnection connection  = (HttpURLConnection) url.openConnection();
          inputStream  = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String linha = "";
            while (( linha = bufferedReader.readLine())!= null){
                endereco += linha;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e){
            Log.d("ErroDeRede:", e.toString()) ;
        }

        return endereco;
    }

    @Override
    protected void onPostExecute(Object endereco) {
        super.onPostExecute(endereco);
        textViewEndereco.setText((CharSequence) String.valueOf(endereco));
    }
}
