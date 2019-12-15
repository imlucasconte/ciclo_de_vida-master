package br.com.bossini;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetalhesLocalizacaoActivity extends AppCompatActivity {

    private TextView latitudeTextView;
    private TextView longitudeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_localizacao);

        setContentView(R.layout.activity_detalhes_localizacao);
        latitudeTextView = findViewById(R.id.latitudeTextView);
        longitudeTextView =
                findViewById(R.id.longitudeTextView);
        Intent origemIntent = getIntent();
        String localizacaoEscolhida =
                origemIntent.getStringExtra("localizacao_escolhida");
        String [] partes = localizacaoEscolhida.split(",");
        String latitude = partes[0];
        String longitude = partes[1];
        latitudeTextView.setText(latitude);
        longitudeTextView.setText(longitude);

    }
}
