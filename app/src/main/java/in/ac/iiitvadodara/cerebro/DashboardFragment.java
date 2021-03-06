package in.ac.iiitvadodara.cerebro;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import in.ac.iiitvadodara.cerebro.YoYo.EventN;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {


    public DashboardFragment() {
        // Required empty public constructor
    }

    private ArrayList<EventN> eventlist;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dashboard_list, container,false);

        eventlist = new ArrayList<EventN>();
        ArrayList<EventN> list = new ArrayList<EventN>();
        if(getArguments() != null){
            eventlist = getArguments().getParcelableArrayList("eventList");
        }

        for(EventN event : eventlist){
            if(FirebaseAuth.getInstance().getCurrentUser() != null){
                if(event.getParticipants().containsKey(FirebaseAuth.getInstance().getCurrentUser().getUid())){
                    if(!list.contains(event)) {
                        list.add(event);
                    }
                }
            }
        }
        Log.e("LIST", list.toString());
        ListView listView =(ListView)rootView.findViewById(R.id.event_list);
        TextView textView = rootView.findViewById(R.id.textView2);

        if(list.size() > 0){
            textView.setVisibility(View.INVISIBLE);
            listView.setVisibility(View.VISIBLE);
        }else{
            textView.setVisibility(View.VISIBLE);
            listView.setVisibility(View.INVISIBLE);
        }
        DashboardAdapter adapter = new DashboardAdapter(getActivity(), list);

        listView.setAdapter(adapter);
        return rootView;
    }

}
