package in.ac.iiitvadodara.cerebro;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by harshendra on 28/2/18.
 */

public class DashboardAdapter extends ArrayAdapter<Event> {

    public DashboardAdapter(Context context, List<Event> events) {
        super(context, 0, events);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.event_item, parent, false);
        }

        final Event currentPosition = getItem(position);

        ImageView eventIcon = (ImageView) listItemView.findViewById(R.id.image);
        eventIcon.setImageResource(currentPosition.getEventIconId());
        eventIcon.setVisibility(View.VISIBLE);

        TextView eventName = (TextView) listItemView.findViewById(R.id.name) ;
        eventName.setText(currentPosition.getEventName());

        LinearLayout item = (LinearLayout) listItemView.findViewById(R.id.itemLinearLayout);
        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), currentPosition.getEventName(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getContext(), EventInfoActivity.class);
//              i.putExtra();
                getContext().startActivity(i);
            }
        });

        TextView eventDescription = (TextView) listItemView.findViewById(R.id.description) ;
        eventDescription.setText(currentPosition.getEventDescription());
        return listItemView;
    }
}
