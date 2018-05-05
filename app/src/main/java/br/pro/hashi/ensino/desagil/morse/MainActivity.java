package br.pro.hashi.ensino.desagil.morse;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private Translator translator = new Translator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Morsi");//titulo da pagina

        Button button_morse = findViewById(R.id.button_morse);
        Button button_space = findViewById(R.id.button_space);
        Button button_send0 = findViewById(R.id.button_send0);
        Button button_send1 = findViewById(R.id.button_send1);

        final String[] msg = {"Fabio está selecionando uma msg..."};
        Spinner mySpinner = findViewById(R.id.spinner);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names0));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    msg[0] = "Fabio está selecionando uma msg...";
                } else if (i == 1) {
                    msg[0] = "PRECISO DE AGUA";
                } else if (i == 2) {
                    msg[0] = "PRECISO DE COMIDA";
                } else if (i == 3) {
                    msg[0] = "PRECISO IR AO BANHEIRO";
                } else if (i == 4) {
                    msg[0] = "PRECISO DE AJUDA AGORA";
                } else if (i == 5) {
                    msg[0] = "PRECISO QUE COMPRE ALGO PRA MIM";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                msg[0] = null;
            }
        });

        final StringBuilder currentChar = new StringBuilder();
        final StringBuilder messageTrans = new StringBuilder();
        final TextView messageText = findViewById(R.id.messageText);

        button_morse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentChar.append(".");
                String displayText = messageTrans.toString()+currentChar;
                messageText.setText(displayText);
            }
        });

        button_morse.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                currentChar.append("-");
                String displayText = messageTrans.toString()+currentChar;
                messageText.setText(displayText);
                return true;
            }
        });

        button_space.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
               
                String penis = currentChar.toString();
                char msg =  translator.morseToChar(currentChar.toString());
                currentChar.setLength(0);
                messageTrans.append(msg);
                String displayText = messageTrans.toString();
                messageText.setText(displayText);
                }

        });

        button_space.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                StringBuilder currentChar = new StringBuilder();
                messageText.setText(messageTrans.toString());

                return true;
            }
        });

        button_send0.setOnClickListener(new View.OnClickListener() {
            String message = null;

            @SuppressLint("UnlocalizedSms")
            @Override
            public void onClick(View view) {
                if (!msg[0].equals("Fabio está selecionando uma msg...")) {
                    message = msg[0];
                }
                if (msg[0].equals("Fabio está selecionando uma msg...")) {
                    message = messageTrans.toString();
                }
                SmsManager manager = SmsManager.getDefault();
                manager.sendTextMessage("011994529712", null, message, null, null);
            }
        });

        button_send1.setOnClickListener(new View.OnClickListener() {
            String message = null;

            @SuppressLint("UnlocalizedSms")
            @Override
            public void onClick(View view) {
                if (!msg[0].equals("Fabio está selecionando uma msg...")) {
                    message = msg[0];
                }
                if (msg[0].equals("Fabio está selecionando uma msg...")) {
                    message = messageTrans.toString();
                }
                SmsManager manager = SmsManager.getDefault();
                manager.sendTextMessage("011994529712", null, message, null, null);

            }
        });

    }
}
