package in.ac.iiitvadodara.cerebro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashScreen extends AppCompatActivity {

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean loggedIn = pref.getBoolean("LOGGED_IN", true);
        SharedPreferences.Editor editor = pref.edit();
        if(FirebaseAuth.getInstance().getCurrentUser() != null) {
            editor.putBoolean("LOGGED_IN", true);
        }
        else {
            editor.putBoolean("LOGGED_IN", false);
        }
        editor.commit();
        if(!loggedIn) {
            handler=new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent=new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            },1000);
        }
        else {
            handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashScreen.this, Portal.class);
                    startActivity(intent);
                    finish();
                }
            }, 1000);
        }
    }
}
