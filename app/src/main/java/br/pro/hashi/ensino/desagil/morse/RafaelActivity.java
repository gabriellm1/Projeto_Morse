package br.pro.hashi.ensino.desagil.morse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;

public class RafaelActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rafael);

        getSupportActionBar().setTitle("Mensagem para Rafael");//titulo da pagina
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//Botao de voltar

        Button button_sos = (Button) findViewById(R.id.button_sos);
        Button button_compras = (Button) findViewById(R.id.button_compras);


        button_sos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = "URGENTE, preciso de ajuda";
                SmsManager manager = SmsManager.getDefault();
                manager.sendTextMessage("011975624243", null, message, null, null);
            }
        });
        button_compras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = "Preciso que você compre coisas";
                SmsManager manager = SmsManager.getDefault();
                manager.sendTextMessage("011975624243", null, message, null, null);
            }
        });


    }
}

