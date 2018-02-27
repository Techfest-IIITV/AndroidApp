package in.ac.iiitvadodara.cerebro.DashBoard;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import in.ac.iiitvadodara.cerebro.DashBoard.Dashboard;
import in.ac.iiitvadodara.cerebro.DashBoard.DashboardAdapter;
import in.ac.iiitvadodara.cerebro.R;

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

        final ArrayList<Dashboard> dashboard = new ArrayList<Dashboard>();

        dashboard.add(new Dashboard(R.drawable.big_tech_quiz,"Event One","Your Event related notifications"));
        dashboard.add(new Dashboard(R.drawable.big_tech_quiz,"Event Two","Your Event related notifications"));
        dashboard.add(new Dashboard(R.drawable.big_tech_quiz,"Event Three","Your Event related notifications"));
        dashboard.add(new Dashboard(R.drawable.big_tech_quiz,"Event Four","Your Event related notifications"));

        DashboardAdapter adapter = new DashboardAdapter(getActivity(),dashboard);
        ListView listView =(ListView)rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        return rootView;
    }

}
