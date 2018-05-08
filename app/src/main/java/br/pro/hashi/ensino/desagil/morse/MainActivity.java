package br.pro.hashi.ensino.desagil.morse;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.LinkedList;
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
        Button sendCuida = findViewById(R.id.button_sendCuida);
        Button sendRafa = findViewById(R.id.button_sendRafa);

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

        // creating list dictionary letter - code
        char letter = 'a';
        char number = '0';
        String line;
        int i;
        LinkedList<String> dic1 = new LinkedList<String>();
        dic1.add("GUIA letra - código");
        for (i = 0; i < 26; i++) {


            line = translator.charToMorse(letter);
            dic1.add(letter + " = " + line);
            letter += 1;
        }
        for (i = 0; i < 10; i++){
            line = translator.charToMorse(number);
            dic1.add(number + " = " + line);
            number += 1;
        }


        Spinner myDictionary1 = findViewById(R.id.dictionary1);

        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, dic1);
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myDictionary1.setAdapter(myAdapter1);

        myDictionary1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        // creating list dictionary code - letter
        LinkedList<String> dic2 = new LinkedList<String>();
        LinkedList<String> codes = new LinkedList<String>();
        codes = translator.getCodes();
        dic2.add("GUIA código - letra");

        for (String word:codes) {

            letter = translator.morseToChar(word);
            dic2.add(word + " = " + letter);


        }

        Spinner myDictionary = findViewById(R.id.dictionary2);

        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, dic2);
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myDictionary.setAdapter(myAdapter2);

        myDictionary.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        
        final StringBuilder currentChar = new StringBuilder();//letra que está sendo digitada 
        final StringBuilder messageTrans = new StringBuilder();// mensagem completa traduzida
        final TextView messageText = findViewById(R.id.messageText);

        button_morse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentChar.append(".");
                String displayText = messageTrans.toString()+currentChar;//menssagem exibida para o usuario 
                messageText.setText(displayText);
            }
        });

        button_morse.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                currentChar.append("-");
                String displayText = messageTrans.toString()+currentChar;//menssagem exibida para o usuario 
                messageText.setText(displayText);
                return true;
            }
        });

        button_space.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                char msg =  translator.morseToChar(currentChar.toString());//traduz o caracter
                currentChar.setLength(0);// da reset na letra que esta sendo escrita
                messageTrans.append(msg);
                String displayText = messageTrans.toString(); //menssagem exibida para o usuario 
                messageText.setText(displayText);
                }
        });

        button_space.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {// da reset na mensagem e  no display
                currentChar.setLength(0);
                messageTrans.setLength(0);
                messageText.setText(messageTrans.toString());

                return true;
            }
        });

        sendCuida.setOnClickListener(new View.OnClickListener() {
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

        sendRafa.setOnClickListener(new View.OnClickListener() {
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
