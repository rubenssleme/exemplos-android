package br.com.myapplication;

import android.app.Activity;
import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ControladorTelaConsulta extends ListActivity {

    static final String[] FRUITS = new String[] {"Apple","Avocado","Banana",
    "Blueberry","Coconut","Durian","Guava","Kiwifruit",
    "Jackfruit","Mango","Olive","Pear","Sugar-apple"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.tela_consulta);
         setListAdapter(new ArrayAdapter<String>(this,R.layout.tela_consulta,FRUITS));
        ListView listView = (ListView) findViewById(R.id.ltvConsulta);
        listView.setTextFilterEnabled(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getApplicationContext(),
                        ((TextView)view).getText(),Toast.LENGTH_SHORT).show();

            }
        });


    }
}
