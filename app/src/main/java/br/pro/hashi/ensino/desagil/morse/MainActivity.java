package br.pro.hashi.ensino.desagil.morse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Inteiro que identifica um pedido de permissão para enviar SMS.
    private static final int REQUEST_SEND_SMS = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Morsi");//titulo da pagina

        Button button_morse = (Button) findViewById(R.id.button_morse);
        Button button_space = (Button) findViewById(R.id.button_space);
        Button button_send0 = (Button) findViewById(R.id.button_send0);
        Button button_send1 = (Button) findViewById(R.id.button_send1);

        final String[] msg = {"Fabio está selecionando uma msg..."};
        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this,
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

        final String[] list = {" "};
        final TextView messageText = (TextView) findViewById(R.id.messageText);

        final String[] mCodes={/*Stop*/ "*-*-*- ", /*quotation marks*/ "*-**-* ", /*comma*/ "--**-- ", /*question mark*/ "**--** ", /*parentheses*/"-*--*- ", "-*--*-", /*apostrophe*/ "*----* ", /*exclamation mark*/ "-*-*-- ", /*slash*/ "-**-* ", /*numbers*/ "*---- ", "**--- ", "***-- ", "****- ", "***** ", "-**** ", "--*** ", "---** ", "----* ", "----- ", /*Letters*/ "--** ", "-*-- ", "-**- ", "*--- ", "*--* ", "***- ", "*-- ", "**-* ", "**- ", "-*-* ", "-*** ", "**** ", "*-** ", "*** ", "*-* ", "-** ", "--*- ", "-*- ", "--* ", "*- ", "-* ", "--- ", "** ", "-- ", "- ", "* "};

        final String[] chars={".", "\"", ",", "?", "(", ")", "'", "!", "/", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "z", "y", "x", "j", "p", "v", "w", "f", "u", "c", "b", "h", "l", "s", "r", "d", "q", "k", "g", "a", "n", "o", "i", "m", "t", "e"};

        button_morse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list[0] += "*";

                messageText.setText(list[0]);
            }
        });

        button_morse.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                list[0] += "-";
                messageText.setText(list[0]);

                return true;
            }
        });

        button_space.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list[0] += " ";

                for(int a=0; a<=44; a++){
                    list[0]=list[0].replace(mCodes[a], chars[a]);
                    messageText.setText(list[0]);
                }
            }
        });

        button_space.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                list[0] ="";
                messageText.setText(list[0]);

                return true;
            }
        });

        button_send0.setOnClickListener(new View.OnClickListener() {
            String message = null;

            @Override
            public void onClick(View view) {
                if (msg[0] != "Fabio está selecionando uma msg...") {
                    message = msg[0];
                }
                if (msg[0] == "Fabio está selecionando uma msg...") {
                    for(int a=0; a<=44; a++){
                        list[0]=list[0].replace(mCodes[a], chars[a]);}
                    message = list[0];

                }
                SmsManager manager = SmsManager.getDefault();
                manager.sendTextMessage("011975624243", null, message, null, null);
            }
        });

        button_send1.setOnClickListener(new View.OnClickListener() {
            String message = null;

            @Override
            public void onClick(View view) {
                if (msg[0] != "Fabio está selecionando uma msg...") {
                    message = msg[0];
                }
                if (msg[0] == "Fabio está selecionando uma msg...") {
                    for(int a=0; a<=44; a++){
                        list[0]=list[0].replace(mCodes[a], chars[a]);}
                        message = list[0];
                }
                SmsManager manager = SmsManager.getDefault();
                manager.sendTextMessage("011999615552", null, message, null, null);

            }
        });

    }
}
