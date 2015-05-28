package com.example.propertymgmtapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.telephony.SmsManager;
import android.widget.Toast;

public class TenantSms extends Activity implements OnClickListener{

    EditText tenantId, tenantName, tenantMobile, smsText;
    Button viewAllTenants, findTenant, sendSMS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_sms);


        viewAllTenants = (Button) findViewById(R.id.btnViewAllTenants);
        findTenant = (Button) findViewById(R.id.btnFindTenant);
        sendSMS = (Button) findViewById(R.id.btnTenantSendSms);


        tenantId = (EditText) findViewById(R.id.etTennantId);
        tenantName = (EditText) findViewById(R.id.etTenantName1);
        tenantMobile = (EditText) findViewById(R.id.etTenantMobile1);
        smsText = (EditText) findViewById(R.id.etSmsText);


        findTenant.setOnClickListener(this);

        //Set up listeners for the buttons
        View viewAllTenantsButton = findViewById(R.id.btnViewAllTenants);
        viewAllTenantsButton.setOnClickListener(this);

        View sendSMSButton = findViewById(R.id.btnTenantSendSms);
        sendSMSButton.setOnClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tenant_sms, menu);
        return true;
    }


    public void sendSmsByManager() {
        try {
            // Get the default instance of the SmsManager
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(tenantMobile.getText().toString(),
                    null,
                    smsText.getText().toString(),
                    null,
                    null);
            Toast.makeText(getApplicationContext(), "Your sms has successfully sent!",
                    Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "Your sms has failed...",
                    Toast.LENGTH_LONG).show();
            ex.printStackTrace();

        }
    }




    public void onClick(View v) {
        // TODO Auto-generated method stub

        switch (v.getId()) {

            case R.id.btnViewAllTenants:
                Intent i = new Intent(this, Tenants.class);
                startActivity(i);
                break;


        case R.id.btnFindTenant:
        try{

            String tenant = tenantId.getText().toString();
            long longTen = Long.parseLong(tenant);

            DbHandler fthandler = new DbHandler(this);
            fthandler.open();
            String returnedTenName = fthandler.getTenName(longTen);
            String returnedTenMob = fthandler.getTenMob(longTen);
            fthandler.close();

            tenantName.setText(returnedTenName);
            tenantMobile.setText(returnedTenMob);

        }
        catch(Exception e)
        {
            Dialog d = new Dialog(this);
            d.setTitle("Failed!");
            TextView tv = new TextView(this);
            tv.setText("Couldn't find tenant in database");
            d.setContentView(tv);
            d.show();
        }
        break;


            case R.id.btnTenantSendSms:
                sendSmsByManager();
                Intent i2 = new Intent(this, Tenants.class);
                startActivity(i2);
                break;


        }
    }


}
