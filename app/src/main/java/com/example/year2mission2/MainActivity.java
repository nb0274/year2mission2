package com.example.year2mission2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener{

    TextView tvPopulation;
    TextView tvCapital;
    TextView tvLanguage;
    TextView tvAnthem;
    Spinner spinnerContinents;
    ListView lvCountries;
    ArrayAdapter<String> adapterForSpinner;
    ArrayAdapter<String> adapterForLv;
    int countryPosition;
    private static final String[] continentsArr = {"Africa", "Asia", "Europe", "North America", "South America", "Oceania"};

    private static final String[][] countriesArr = {
            {"Egypt", "Algeria", "Nigeria", "South Africa", "Ethiopia", "Kenya", "Tanzania"},
            {"China", "India", "Indonesia", "Pakistan", "Bangladesh", "Japan", "Russia"},
            {"United Kingdom", "Germany", "France", "Italy", "Spain", "Poland", "Ukraine"},
            {"United States", "Canada", "Mexico", "Brazil", "Colombia", "Argentina", "Chile"},
            {"Argentina", "Brazil", "Colombia", "Chile", "Ecuador", "Peru", "Venezuela"},
            {"Australia", "New Zealand"}
    };

    String[][][] countriesInfoArr = {
            {{"106259525", "Bilady, Bilady, Bilady", "Arabic", "Cairo"},
                    {"46075187", "Qassaman", "Arabic", "Algiers"},
                    {"211400708", "Arise, O Compatriots", "English", "Abuja"},
                    {"60893104", "Nkosi Sikelel' iAfrika", "IsiNdebele, Sesotho, Afrikaans, English, Xhosa, Zulu", "Pretoria, Bloemfontein, Cape Town"},
                    {"115179978", "Wendye Ethiopia, Hosanna!", "Amharic", "Addis Ababa"},
                    {"56465031", "Jambo Kenya", "Swahili", "Nairobi"},
                    {"61595739", "Mungu ibariki Tanzania", "Swahili", "Dar es Salaam"}},
            {{"1452100000", "March of the Volunteers", "Chinese", "Beijing"},
                    {"1411380000", "Jana Gana Mana", "Hindi", "New Delhi"},
                    {"278709400", "Indonesia Raya", "Indonesian", "Jakarta"},
                    {"227192787", "Qaumi Tarana", "Urdu", "Islamabad"},
                    {"164689383", "Amar Sonar Bangla", "Bengali", "Dhaka"},
                    {"126497561", "Kimigayo", "Japanese", "Tokyo"},
                    {"146167000", "Gosudarstvennyy Gimn Rossiyskoy Federatsii", "Russian", "Moscow"}},
            {{"67081263", "God Save the Queen", "English", "London"},
                    {"83240000", "Einigkeit und Recht und Freiheit", "German", "Berlin"},
                    {"67552859", "La Marseillaise", "French", "Paris"},
                    {"60431652", "Il Canto degli Italiani", "Italian", "Rome"},
                    {"47351567", "Marcha Real", "Spanish", "Madrid"},
                    {"38008007", "Mazurek Dąbrowskiego", "Polish", "Warsaw"},
                    {"44134693", "Ще не вмерла Україна", "Ukrainian", "Kyiv"}},
            {{"332403650", "The Star-Spangled Banner", "English", "Washington, D.C."},
                    {"38009071", "O Canada", "English, French", "Ottawa"},
                    {"128932753", "Himno Nacional Mexicano", "Spanish", "Mexico City"},
                    {"212559407", "Hino Nacional Brasileiro", "Portuguese", "Brasília"},
                    {"51684644", "Himno Nacional de la República de Colombia", "Spanish", "Bogotá"},
                    {"46100558", "Himno Nacional Argentino", "Spanish", "Buenos Aires"},
                    {"19126110", "Himno Nacional de Chile", "Spanish", "Santiago"}},
            {{"517859171", "Argentina, Aurora Austral", "Spanish", "Buenos Aires"},
                    {"212559407", "Hino Nacional Brasileiro", "Portuguese", "Brasília"},
                    {"51684644", "Himno Nacional de la República de Colombia", "Spanish", "Bogotá"},
                    {"19126110", "Himno Nacional de Chile", "Spanish", "Santiago"},
                    {"18190484", "Salve, Oh Patria", "Spanish", "Quito"},
                    {"34352719", "Himno Nacional del Peru", "Spanish", "Lima"},
                    {"28838499", "Gloria al Bravo Pueblo", "Spanish", "Caracas"}},
            {{"26026922", "Advance Australia Fair", "English", "Canberra"},
                    {"5129360", "God Defend New Zealand", "English, Māori", "Wellington"}}};


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvPopulation = (TextView) findViewById(R.id.tvPopulation);
        tvCapital = (TextView) findViewById(R.id.tvCapital);
        tvLanguage = (TextView) findViewById(R.id.tvLanguage);
        tvAnthem = (TextView) findViewById(R.id.tvAnthem);
        spinnerContinents = (Spinner) findViewById(R.id.spinnerContinents);
        lvCountries = (ListView) findViewById(R.id.lvCountries);

        adapterForSpinner = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, continentsArr);
        spinnerContinents.setAdapter(adapterForSpinner);
        spinnerContinents.setOnItemSelectedListener(this);
        lvCountries.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        tvPopulation.setText(countriesInfoArr[countryPosition][position][0]);
        tvAnthem.setText(countriesInfoArr[countryPosition][position][1]);
        tvLanguage.setText(countriesInfoArr[countryPosition][position][2]);
        tvCapital.setText(countriesInfoArr[countryPosition][position][3]);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        adapterForLv = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, countriesArr[position]);
        lvCountries.setAdapter(adapterForLv);
        countryPosition = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}