package com.example.propertymgmtapp;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Set up listeners for the buttons         
        View myPropertiesButton = findViewById(R.id.btnMyProperties);         
        myPropertiesButton.setOnClickListener(this); 
        
        View tenantsButton = findViewById(R.id.btnTenants);         
        tenantsButton.setOnClickListener(this); 
        
        //View contractorsButton = findViewById(R.id.btnContractors);
        //contractorsButton.setOnClickListener(this);
        
        View linksButton = findViewById(R.id.btnLinks);
        linksButton.setOnClickListener(this);
        
        View helpButton = findViewById(R.id.btnHelp);         
        helpButton.setOnClickListener(this); 
        
        View exitButton = findViewById(R.id.btnExit);         
        exitButton.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
    public void onClick(View v) {   
    	
    	switch (v.getId()){   
    	case R.id.btnMyProperties:    
    		Intent i = new Intent(this, MyProperties.class);   
    		startActivity(i);    
    		break;   
    		}  
    	
    	switch (v.getId()){   
    	case R.id.btnTenants:    
    		Intent i2 = new Intent(this, Tenants.class);   
    		startActivity(i2);    
    		break;   
    		} 
    	
    	/*switch (v.getId()){
    	case R.id.btnContractors:    
    		Intent i3 = new Intent(this, Contractor.class);   
    		startActivity(i3);    
    		break;   
    		} */
    	
    	switch (v.getId()){   
    	case R.id.btnLinks:
    		Intent i4 = new Intent(this, UsefulLinks.class);
    		startActivity(i4);    
    		break;   
    		}
    	
    	switch (v.getId()){   
    	case R.id.btnHelp:   
    		Intent i5 = new Intent(this, Help.class);   
    		startActivity(i5);   
    		break;   
    		}
    	
    	switch (v.getId()){   
    	case R.id.btnExit:   
    		finish();
            System.exit(0);   
    		break;   
    		}
    	
    	
    }

}
