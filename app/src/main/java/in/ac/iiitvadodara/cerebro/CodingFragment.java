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
import android.widget.Toast;

import java.util.ArrayList;

import in.ac.iiitvadodara.cerebro.YoYo.EventN;


/**
 * A simple {@link Fragment} subclass.
 */
public class CodingFragment extends Fragment {


    public CodingFragment() {
        // Required empty public constructor
    }

    private ArrayList<EventN> eventlist;
    static DashboardAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_coding, container, false);

        eventlist = new ArrayList<EventN>();
        if(getArguments() != null) {
            eventlist = getArguments().getParcelableArrayList("eventList");
            Log.e("dssds", eventlist.toString());
        }
        adapter = new DashboardAdapter(getActivity(), eventlist);
        ListView listView =(ListView)rootView.findViewById(R.id.event_list);
        listView.setAdapter(adapter);
        return rootView;
    }

}
