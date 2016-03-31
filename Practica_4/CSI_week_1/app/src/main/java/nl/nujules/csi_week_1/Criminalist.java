package nl.nujules.csi_week_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Criminalist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criminalist);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CriminalProvider provider = new CriminalProvider(getApplicationContext());
        CriminalListAdapter adapter = new CriminalListAdapter(getApplicationContext(), provider.GetCriminals());

        ListView listView = (ListView) findViewById(R.id.CriminalslistView);
        listView.setAdapter(adapter);

        final String[] criminals = getResources().getStringArray(R.array.names);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(Criminalist.this, main.class);

                intent.putExtra("criminalPosition", position);
                startActivity(intent);
            }
        });
    }

}
