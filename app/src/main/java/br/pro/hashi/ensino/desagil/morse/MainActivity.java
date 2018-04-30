package br.pro.hashi.ensino.desagil.morse;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    // Inteiro que identifica um pedido de permissão para enviar SMS.
    private static final int REQUEST_SEND_SMS = 0;


    private void openCuidadorActivity() {
        // Exemplo de código para abrir uma activity. Especificamente, a CuidadorActivity.
        Intent intent = new Intent(this, CuidadorActivity.class);
        startActivity(intent);

        // Depois de abrir a CuidadorActivity, não há porque manter a MainActivity aberta.
        //finish();
    }

    private void openRafaelActivity() {
        // Exemplo de código para abrir uma activity. Especificamente, a RafaelActivity.
        Intent intent = new Intent(this, RafaelActivity.class);
        startActivity(intent);

        // Depois de abrir a CuidadorActivity, não há porque manter a MainActivity aberta.
        //finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Morsi");//titulo da pagina
        Button button_send0 = (Button) findViewById(R.id.button_send0);
        Button button_send1 = (Button) findViewById(R.id.button_send1);
        final String[] mensagem = {"Fabio está selecionando uma mensagem..."};
        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this,
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
                    mensagem[0] = "PRECISO DE AJUDA AGORA";
                } else if (i == 5) {
                    mensagem[0] = "PRECISO QUE COMPRE ALGO PRA MIM";
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

        button_send1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mensagem[0] != "Fabio está selecionando uma mensagem...") {
                    String message = mensagem[0];
                    SmsManager manager = SmsManager.getDefault();
                    manager.sendTextMessage("011993321768", null, message, null, null);
                }
            }
        });

//        Button button_cuidador = (Button) findViewById(R.id.button_cuidador);
//        Button button_rafael = (Button) findViewById(R.id.button_rafael);
//
//        button_cuidador.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Se já temos permissão para enviar SMS, simplesmente abrimos a CuidadorActivity.
//                if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
//                    openCuidadorActivity();
//                }
//                // Se não temos permissão para enviar SMS, precisamos pedir essa permissão.
//                else {
//                    // Construção do vetor de permissões a pedir. Podemos pedir várias de uma
//                    // vez se quisermos, mas nesse caso específico vamos pedir apenas uma.
//                    String[] permissions = new String[1];
//                    permissions[0] = Manifest.permission.SEND_SMS;
//
//                    // Esse método vai pedir as permissões para o usuário. Quando o usuário
//                    // responder, será chamado o método onRequestPermissionsResult abaixo.
//                    ActivityCompat.requestPermissions(MainActivity.this, permissions, REQUEST_SEND_SMS);
//                }
//            }
//        });
//        button_rafael.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Se já temos permissão para enviar SMS, simplesmente abrimos a RafaelActivity.
//                if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
//                    openRafaelActivity();
//                }
//                // Se não temos permissão para enviar SMS, precisamos pedir essa permissão.
//                else {
//                    // Construção do vetor de permissões a pedir. Podemos pedir várias de uma
//                    // vez se quisermos, mas nesse caso específico vamos pedir apenas uma.
//                    String[] permissions = new String[1];
//                    permissions[0] = Manifest.permission.SEND_SMS;
//
//                    // Esse método vai pedir as permissões para o usuário. Quando o usuário
//                    // responder, será chamado o método onRequestPermissionsResult abaixo.
//                    ActivityCompat.requestPermissions(MainActivity.this, permissions, REQUEST_SEND_SMS);
//                }
//            }
//        });
//    }
//
//
//    @Override
//    public void onRequestPermissionsResult(int request, String[] permissions, int[] results) {
//        // Se o pedido de permissão foi para enviar SMS...
//        if(request == REQUEST_SEND_SMS) {
//            // ...e a permissão foi de fato concedida, abrimos a CuidadorActivity.
//            if(results.length > 0 && results[0] == PackageManager.PERMISSION_GRANTED) {
//
//            }
//            // Senão, permanecemos na mesma activity e mostramos uma bolha de mensagem.
//            else {
//                Utils.showToast(this, "Precisamos de sua permissão para enviarmos SMS!");
//            }
//        }
//    }

    }
}
