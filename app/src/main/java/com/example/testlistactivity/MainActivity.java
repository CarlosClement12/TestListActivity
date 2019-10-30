package com.example.testlistactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    private String[] paises = new String[] {"Bolivia", "Peru", "Argentina", "Chile", "TODOS"};
    private int[] habitantes = new int[] {100,25,32,50};

    private TextView tv1;
    private ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv1);
        lv1 = findViewById(R.id.listview1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, paises);
        lv1.setAdapter(adapter);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> paises, View view, int posicion, long id)
            {
                if(paises.getItemAtPosition(posicion) == "TODOS")
                {
                    int total = 0;
                    for (int i = 0; i < paises.getCount() - 1; i++)
                        total += habitantes[i];
                    tv1.setText("Población de " + lv1.getItemAtPosition(posicion) + " es "+ total + " millones");
                }
                else
                    tv1.setText("Población de " + lv1.getItemAtPosition(posicion) + " es "+ habitantes[posicion] + " millones");
            }
        });
    }
}
