package br.pro.hashi.ensino.desagil.morse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class CuidadorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuidador);

        getSupportActionBar().setTitle("Mensagem para Cuidador");//Titulo da pagina
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//botao de voltar

        Button button_send0 = (Button) findViewById(R.id.button_send0);
        final String[] mensagem = {"Fabio está selecionando uma mensagem..."};
        Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(CuidadorActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names0));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    mensagem[0] = "Fabio está selecionando uma mensagem...";
                } else if (i == 1) {
                    mensagem[0] = "PRECISO DE AGUA";
                } else if (i == 2) {
                    mensagem[0] = "PRECISO DE COMIDA";
                } else if (i == 3) {
                    mensagem[0] = "PRECISO IR AO BANHEIRO";
                } else if (i == 4) {
                    mensagem[0] = "PRECISO DORMIR";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                mensagem[0] = null;
            }

        });

        button_send0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mensagem[0] != "Fabio está selecionando uma mensagem...") {
                    String message = mensagem[0];
                    SmsManager manager = SmsManager.getDefault();
                    manager.sendTextMessage("011993321768", null, message, null, null);
                }
            }
        });
    }

}
