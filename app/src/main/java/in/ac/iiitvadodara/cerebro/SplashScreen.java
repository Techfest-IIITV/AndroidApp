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
        handler=new Handler();
        if(FirebaseAuth.getInstance().getCurrentUser() != null) {
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
