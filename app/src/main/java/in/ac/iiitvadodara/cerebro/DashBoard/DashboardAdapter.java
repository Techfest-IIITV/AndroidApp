package in.ac.iiitvadodara.cerebro.DashBoard;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import in.ac.iiitvadodara.cerebro.DashBoard.Dashboard;
import in.ac.iiitvadodara.cerebro.R;

/**
 * Created by harshendra on 28/2/18.
 */

public class DashboardAdapter extends ArrayAdapter<Dashboard> {

    public DashboardAdapter(Context context, List<Dashboard> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.dashboard_list_item, parent, false);
        }

        Dashboard currentPosition = getItem(position);

        ImageView eventIcon = (ImageView) listItemView.findViewById(R.id.dashboard_event_icon);
        eventIcon.setImageResource(currentPosition.getEventIconId());
        eventIcon.setVisibility(View.VISIBLE);

        TextView eventName = (TextView) listItemView.findViewById(R.id.dashboard_event_name) ;
        eventName.setText(currentPosition.getEventName());

        TextView eventNotification = (TextView) listItemView.findViewById(R.id.dashboard_event_notification);
        eventNotification.setText(currentPosition.getEventNotification());

        return listItemView;
    }


}
