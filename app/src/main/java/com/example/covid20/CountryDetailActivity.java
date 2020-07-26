package com.example.covid20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class CountryDetailActivity extends AppCompatActivity {
    private int countryPosition;
    TextView countryName,Tests,Cases,recovered,active,criticial,todayCases,todayDeaths,totalDeaths,population;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);
        Intent intent=getIntent();
        countryPosition=intent.getIntExtra("position",0);
        getSupportActionBar().setTitle("Details of "+ CountryAffected.countryModelsList.get(countryPosition).getCountry());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        countryName=findViewById(R.id.tvCountry);
        Tests=findViewById(R.id.tvTestDetail);
        Cases=findViewById(R.id.tv_detail_Cases);
        recovered=findViewById(R.id.tv_detail_Recoverd);
        active=findViewById(R.id.tvActive);
        criticial=findViewById(R.id.tvDetailCritical);
        todayCases=findViewById(R.id.tvTodayCasesDetail);
        todayDeaths=findViewById(R.id.tvTodayDeathDetail);
        totalDeaths=findViewById(R.id.tvTotalDeathDetail);
        population=findViewById(R.id.tvPopulationDetail);

        countryName.setText(CountryAffected.countryModelsList.get(countryPosition).getCountry());
        Tests.setText(CountryAffected.countryModelsList.get(countryPosition).getTests());
        Cases.setText(CountryAffected.countryModelsList.get(countryPosition).getCases());
        recovered.setText( CountryAffected.countryModelsList.get(countryPosition).getRecovered());
        active.setText(CountryAffected.countryModelsList.get(countryPosition).getActive());
        criticial.setText(CountryAffected.countryModelsList.get(countryPosition).getCritical());
        todayCases.setText(CountryAffected.countryModelsList.get(countryPosition).getTodayCases());
        totalDeaths.setText(CountryAffected.countryModelsList.get(countryPosition).getDeaths());
        todayDeaths.setText(CountryAffected.countryModelsList.get(countryPosition).getTodayDeaths());
        population.setText(CountryAffected.countryModelsList.get(countryPosition).getPopulation());





    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()== android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}