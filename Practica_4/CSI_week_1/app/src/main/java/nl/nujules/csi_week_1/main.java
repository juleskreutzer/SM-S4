package nl.nujules.csi_week_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CriminalProvider provider = new CriminalProvider(getApplicationContext());

        int position = getIntent().getIntExtra("criminalPosition", 1);

        Criminal criminal = provider.GetCriminal(position);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        TextView name = (TextView) findViewById(R.id.tvSuspectName);
        TextView bounty = (TextView) findViewById(R.id.tvSuspectBounty);
        TextView age = (TextView) findViewById(R.id.tvSuspectAge);
        TextView desc = (TextView) findViewById(R.id.tvSuspectDetails);
        TextView gender = (TextView) findViewById(R.id.tvSuspectGender);

        imageView.setImageDrawable(criminal.mugshot);
        name.setText(criminal.name);
        bounty.setText(String.format("%s", criminal.getBountyInDollars()));
        age.setText(String.format("%s", criminal.age));
        desc.setText(criminal.description);
        gender.setText(criminal.gender);


        Button report = (Button) findViewById(R.id.btnReport);
        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(main.this, ReportActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
