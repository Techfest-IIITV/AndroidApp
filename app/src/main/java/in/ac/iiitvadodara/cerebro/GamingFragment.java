package in.ac.iiitvadodara.cerebro;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import in.ac.iiitvadodara.cerebro.YoYo.EventN;


/**
 * A simple {@link Fragment} subclass.
 */
public class GamingFragment extends Fragment {


    public GamingFragment() {
        // Required empty public constructor
    }

    private ArrayList<EventN> eventlist;
    static DashboardAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_gaming, container, false);

        eventlist = new ArrayList<EventN>();
        if(getArguments() != null){
            eventlist = getArguments().getParcelableArrayList("eventList");
        }

        adapter = new DashboardAdapter(getActivity(), eventlist);
        ListView listView =(ListView)rootView.findViewById(R.id.event_list);
        listView.setAdapter(adapter);
        return rootView;
    }
}
