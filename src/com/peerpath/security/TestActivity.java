package com.peerpath.security;

import com.peerpath.security.aidl.SecurityService;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TestActivity extends Activity {
	private SecurityService remoteService;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		
		final TextView display = (TextView)findViewById(R.id.textView1);
		Button button = (Button)findViewById(R.id.button1);
		final Button greet = (Button)findViewById(R.id.button2);
		Button unbind = (Button)findViewById(R.id.button3);
		
		//bind the remote service and invoke something
		final ServiceConnection connection =new ServiceConnection() {					
			@Override
			public void onServiceDisconnected(ComponentName name) {
				Log.d("security", "---Service disconnect");
				remoteService = null;
			}
			
			@Override
			public void onServiceConnected(ComponentName name, IBinder service) {
				//connect to the remote service
				remoteService = SecurityService.Stub.asInterface(service);				
			}
		};
		
		//bind with the service
		button.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent intent =new Intent("com.peerpath.security.AIDLService");
				bindService(intent, connection, BIND_AUTO_CREATE);

				greet.setEnabled(true);
			}
		});
		
		greet.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				try {
					if(remoteService != null){
						String response = remoteService.sayHi("Emilio");
						display.setText("From Remote Server: "+response);
					}
					else {
						Toast.makeText(TestActivity.this, "Service Not Start", Toast.LENGTH_LONG).show();
						greet.setEnabled(false);
					}
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		});
		
		unbind.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				if(remoteService !=null){
					unbindService(connection);
					remoteService = null;
				}
				else
					Toast.makeText(TestActivity.this, "Service Not Start", Toast.LENGTH_LONG).show();
					
				greet.setEnabled(false);
			}
		});
	}
}
//Log.d("security", "");
