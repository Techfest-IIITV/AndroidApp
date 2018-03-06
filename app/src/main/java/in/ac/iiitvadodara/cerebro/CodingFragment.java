package in.ac.iiitvadodara.cerebro;


import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

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
public class CodingFragment extends Fragment {


    public CodingFragment() {
        // Required empty public constructor
    }

    private DatabaseReference mDatabaseReference;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_coding, container, false);

        final ArrayList<EventN> eventlist = new ArrayList<EventN>();
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();

        mDatabaseReference.child("events").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("Y O Y O Y O Y O Y O Y O", String.valueOf(dataSnapshot.getChildrenCount()));
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    EventN event = ds.getValue(EventN.class);
                    Log.d("N A M E", event.getName());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        DashboardAdapter adapter = new DashboardAdapter(getActivity(), eventlist);
        ListView listView =(ListView)rootView.findViewById(R.id.event_list);
        listView.setAdapter(adapter);
        return rootView;
    }

}
