package in.ac.iiitvadodara.cerebro;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import in.ac.iiitvadodara.cerebro.Models.Dev;
import in.ac.iiitvadodara.cerebro.YoYo.EventN;

public class EventInfoActivity extends AppCompatActivity implements View.OnClickListener{

    EventN event;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_info);

        event = new EventN();
        Boolean registered = false;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            event = extras.getParcelable("event");
            registered = extras.getBoolean("registered");
        }

        ListView conv = findViewById(R.id.convenor);
        TextView Ename = findViewById(R.id.event_name);
        TextView Edescription = findViewById(R.id.event_description);
        TextView Erules = findViewById(R.id.event_rules);
        ImageView Eimage = findViewById(R.id.event_image);
        register = findViewById(R.id.event_register_button);

        Ename.setText(event.getName());
        Edescription.setText(event.getDescription());
        String rules = "";
        for(String i :event.getRules()){
            rules = rules + i + "\n";
        }
        Erules.setText(rules);
        Glide.with(this).load(event.getImg()).into(Eimage);

        if(registered){
            register.setText("REGISTERED");
            register.setClickable(false);
            register.setBackgroundColor(getResources().getColor(R.color.registered));
        }else{
            register.setText("REGISTER");
            register.setClickable(true);
        }

        register.setOnClickListener(this);


//        ArrayList<HashMap<String, String>> map = event.getContact();
//        ArrayList<Dev> list = new ArrayList<>();
//        for(HashMap<String, String> m : map){
//            list.add(new Dev(m.get("name"), m.get("phone"), m.get("role"), ""));
//        }
//
//        DevAdapter adapter = new DevAdapter(this, list);
//        conv.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid().toString());
        hashMap.put("name", FirebaseAuth.getInstance().getCurrentUser().getDisplayName().toString());
        FirebaseDatabase.getInstance().getReference("events").child(Integer.toString(event.getId())).child("participants").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(hashMap);
        register.setText("REGISTERED");
        register.setClickable(false);
        register.setBackgroundColor(getResources().getColor(R.color.registered));
    }
}
