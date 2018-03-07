package in.ac.iiitvadodara.cerebro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import in.ac.iiitvadodara.cerebro.YoYo.EventN;

public class EventInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_info);

        EventN event = new EventN();
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            event = extras.getParcelable("event");
        }

        TextView Ename = findViewById(R.id.event_name);
        TextView Edescription = findViewById(R.id.event_description);
        TextView Erules = findViewById(R.id.event_rules);

        Ename.setText(event.getName());
        Edescription.setText(event.getDescription());
        String rules = "";
        for(String i :event.getRules()){
            rules = rules + i + "\n";
        }
        Erules.setText(rules);

    }
}
