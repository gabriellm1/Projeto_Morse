package br.pro.hashi.ensino.desagil.morse;

import android.telephony.SmsManager;

public class SendSms {
    public SendSms(){
    }

    public void sendTocontact(String number,String message){
        SmsManager manager = SmsManager.getDefault();
        manager.sendTextMessage(number, null, message, null, null);
    }
}
