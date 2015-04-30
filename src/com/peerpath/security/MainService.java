package com.peerpath.security;

import com.peerpath.security.aidl.SecurityService;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MainService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		Log.d("security", "-----Stupid invoker comes ~");
		return serviceStub;		//when request comes, return the stub for further interaction
	}

	
	
	@Override
	public boolean onUnbind(Intent intent) {
		Log.d("security", "=== unbinding service");
		return super.onUnbind(intent);
	}



	SecurityService.Stub serviceStub = new SecurityService.Stub(){
		@Override
		public String sayHi(String someone){
			Log.d("security", "---hello, "+someone+". I'm your father Tommy");
			return "hello, "+someone+". I'm your father Tommy";
		}
		
	};
}
