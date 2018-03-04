package in.ac.iiitvadodara.cerebro;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {


    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dashboard_list, container,false);

        final ArrayList<Event> event = new ArrayList<Event>();

        event.add(new Event(R.drawable.big_tech_quiz,"Event One","Your Event related notifications"));
        event.add(new Event(R.drawable.big_tech_quiz,"Event Two","Your Event related notifications"));
        event.add(new Event(R.drawable.big_tech_quiz,"Event Three","Your Event related notifications"));
        event.add(new Event(R.drawable.big_tech_quiz,"Event Four","Your Event related notifications"));

        DashboardAdapter adapter = new DashboardAdapter(getActivity(), event);
        ListView listView =(ListView)rootView.findViewById(R.id.event_list);
        listView.setAdapter(adapter);
        return rootView;
    }

}
