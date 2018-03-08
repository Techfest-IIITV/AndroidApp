package in.ac.iiitvadodara.cerebro;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import in.ac.iiitvadodara.cerebro.YoYo.EventN;

/**
 * Created by harshendra on 28/2/18.
 */

public class DashboardAdapter extends ArrayAdapter<EventN> {

    private List<EventN> list;
    private HashMap<Integer, EventN> hashMap;
    public DashboardAdapter(Context context, List<EventN> events) {
        super(context, 0, events);
        list = events;
        hashMap = new HashMap<>();
    }

    @SuppressLint("ResourceType")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.event_item, parent, false);
        }

        final EventN currentPosition = getItem(position);

        ImageView eventIcon = (ImageView) listItemView.findViewById(R.id.image);

        String image = currentPosition.getImg();
        if(image != null){
            Glide.with(getContext()).load(image).into(eventIcon);
        }else{
            eventIcon.setImageResource(R.drawable.cerebro1);
        }

        TextView eventName = (TextView) listItemView.findViewById(R.id.name) ;
        eventName.setText(currentPosition.getName());
        for(EventN eventN: list) {
            hashMap.put(eventN.getId(), eventN);
        }
        LinearLayout item = (LinearLayout) listItemView.findViewById(R.id.itemLinearLayout);
        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), currentPosition.getName()+" "+currentPosition.getId(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getContext(), EventInfoActivity.class);
                Log.e("Firebase", hashMap.toString());
                Log.e("Firebase", Integer.toString(currentPosition.getId()));
                if(FirebaseAuth.getInstance().getCurrentUser()!=null){
                    if(hashMap.get(currentPosition.getId()).getParticipants().containsKey(FirebaseAuth.getInstance().getCurrentUser().getUid())){
                        i.putExtra("registered",true);
                    }else{
                        i.putExtra("registered",false);
                    }
                }

                i.putExtra("event",currentPosition);
                getContext().startActivity(i);
            }
        });

        TextView eventDescription = (TextView) listItemView.findViewById(R.id.description) ;
        eventDescription.setText(currentPosition.getDescription());
        return listItemView;
    }
}
