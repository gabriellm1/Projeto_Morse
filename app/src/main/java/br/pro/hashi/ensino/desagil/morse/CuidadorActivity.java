package br.pro.hashi.ensino.desagil.morse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;

public class CuidadorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuidador);



        Button button_sede = (Button) findViewById(R.id.button_sede);
        Button button_ban = (Button) findViewById(R.id.button_ban);


        button_sede.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = "Estou com sede";
                SmsManager manager = SmsManager.getDefault();
                manager.sendTextMessage("011975624243", null, message, null, null);
            }
        });
        button_ban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = "Preciso ir ao banheiro";
                SmsManager manager = SmsManager.getDefault();
                manager.sendTextMessage("011975624243", null, message, null, null);
            }
        });


    }
}
