package edu.byui.www.fileeditor;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView1 = (ListView) findViewById(R.id.listText);

        try {
            String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Documents/FileEditorApp/numbers.txt";
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));

            String line;
            ArrayList<String> lines = new ArrayList<String>();
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }

            br.close();

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lines);


            listView1.setAdapter(adapter);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}