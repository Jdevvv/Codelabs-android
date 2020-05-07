package fr.mds.powerreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {

    private static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        String stringNumber = intent.getStringExtra("num");
        int number = Integer.valueOf(stringNumber);

        if (intentAction != null) {
            String toastMessage = "unknown intent action";
            switch (intentAction){
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage = "Power connected!";
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage = "Power disconnected!";
                    break;
                case ACTION_CUSTOM_BROADCAST:
                    toastMessage = context.getString(R.string.toast_msg);
                    break;
                case Intent.ACTION_HEADSET_PLUG:
                    toastMessage = context.getString(R.string.headset_mgs);
            }

            //Display the toast.
            Toast.makeText(context, toastMessage + "Square of the number is " + number * number, Toast.LENGTH_SHORT).show();
        }
    }

}
