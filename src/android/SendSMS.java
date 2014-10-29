package com.mexyon.sms;
 
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import android.telephony.SmsManager;
import android.widget.Toast;

public class SendSMS extends CordovaPlugin {
    public static final String ACTION_SMS = "sendMessage";
    
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    	
        try {
            if (ACTION_SMS.equals(action)) { 
            	String number = args.getString(0);
            	String msg = args.getString(1);
				if(number != null && msg != null){
					sendSMSMessage(number,msg,callbackContext);
					callbackContext.success("Message Sent Successfull");
					return true;
				}
			}
			callbackContext.error("Invalid action");
			return false;
        } catch(Exception e) {
            System.err.println("Exception: " + e.getMessage());
            callbackContext.error("Eroory: "+e.getMessage());
            return false;
        } 
    }
	 public void sendSMSMessage(String number,String msg,CallbackContext callbackContext) {
      
      // This will be helpful to create cordova phonegap plugin lets check
      
      try {
    	  
         SmsManager smsManager = SmsManager.getDefault();
         smsManager.sendTextMessage(number, null, msg, null, null);
         
         Toast.makeText(this.cordova.getActivity(), "SMS sent.",Toast.LENGTH_LONG).show();
         
      } catch (Exception e) {
    	  System.err.println("Exception: " + e.getMessage());
          callbackContext.error("Sending SMS Failed Error : "+e.getMessage());
      }
   }
}