package in.ac.iiitvadodara.cerebro;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactUsFragment extends Fragment implements View.OnClickListener{


    View root;

    public ContactUsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_contact_us, container, false);
        TextView ns = root.findViewById(R.id.ns);
        TextView ms = root.findViewById(R.id.ms);
        TextView tk = root.findViewById(R.id.tk);
        TextView mk = root.findViewById(R.id.mk);
        TextView ak = root.findViewById(R.id.ak);
        TextView ut = root.findViewById(R.id.ut);
        final TextView mail = root.findViewById(R.id.mail);
        ns.setOnClickListener(this);
        ms.setOnClickListener(this);
        tk.setOnClickListener(this);
        mk.setOnClickListener(this);
        ak.setOnClickListener(this);
        ut.setOnClickListener(this);

        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto",mail.getText().toString(), null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Cerebro-Help");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "I would like to know ...");
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            }
        });

        return root;
    }

    @Override
    public void onClick(View v) {
        Log.e("WOWWW", (Integer.toString(v.getId())));
        TextView tv = root.findViewById(v.getId());
        String s = tv.getText().toString();
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:"+s));
        startActivity(callIntent);
    }
}
