package br.com.bossini;

import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaLocalizacaoGPS extends AppCompatActivity {

    private ListView listaLocalizacaoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_localizacao_gps);
        listaLocalizacaoView = findViewById(R.id.listaLocalizacaoView);
        Intent origemIntent = getIntent();
        final ArrayList<Location> locaisRecentes = origemIntent.getParcelableArrayListExtra("listaLocaisRecentes");
        ArrayAdapter<Location> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,locaisRecentes);
        listaLocalizacaoView.setAdapter(adapter);

        listaLocalizacaoView.setOnItemClickListener(new
                                                        AdapterView.OnItemClickListener() {
                                                            @Override
                                                            public void onItemClick(AdapterView<?> parent, View view, int
                                                                    position, long id) {

                                                                Uri uri = Uri.parse(
                                                                        String.format(
                                                                                "geo:%f, %f?q",
                                                                                Double.valueOf(locaisRecentes.get(0).getLatitude()),
                                                                                Double.valueOf(locaisRecentes.get(0).getLongitude())
                                                                        ));
                                                               Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                                                startActivity(intent);
                                                            }

                                                        });

    }
}
