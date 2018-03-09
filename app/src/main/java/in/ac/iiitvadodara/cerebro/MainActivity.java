package in.ac.iiitvadodara.cerebro;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import in.ac.iiitvadodara.cerebro.YoYo.EventN;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter adapter;
    private int[] tabIcons = {
            R.drawable.ic_code_white_24dp,
            R.drawable.ic_games_white_24dp,
    };
    static String name_s = " ", email_s = " ";
    private boolean bool_home;
    Fragment fragment = null;
    private ArrayList<EventN> eventList;
    private ArrayList<EventN> codingList;
    private ArrayList<EventN> gamingList;

    private DatabaseReference mDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bool_home = true;
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        eventList = new ArrayList<EventN>();
        gamingList = new ArrayList<EventN>();
        codingList = new ArrayList<EventN>();
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();

        mDatabaseReference.child("events").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("Y O Y O Y O Y O Y O Y O", String.valueOf(dataSnapshot.getChildrenCount()));
                if(dataSnapshot == null){
                    Log.d("N U L L", "N U L L");
                }
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    EventN event = ds.getValue(EventN.class);
                    if(event.getType() == 1){
                        if(!codingList.contains(event)){
                            codingList.add(event);
                        }else{
                            codingList.remove(event);
                            codingList.add(event);
                        }
                    } else {
                        if(!gamingList.contains(event)){
                            gamingList.add(event);
                        }else{
                            gamingList.remove(event);
                            gamingList.add(event);
                        }
                    }
                    eventList.add(event);
                    Log.d("N A M E", event.getName());
                }
                CodingFragment.adapter.notifyDataSetChanged();
                GamingFragment.adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        viewPager=(ViewPager) findViewById(R.id.viewpager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), gamingList, codingList);
        viewPager.setAdapter(adapter);

        tabLayout=(TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
        tabLayout.setTabTextColors(getResources().getColor(R.color.tabUnselected),getResources().getColor(R.color.colorAccent));

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View header=navigationView.getHeaderView(0);

        TextView name = (TextView)header.findViewById(R.id.username);
        TextView email = (TextView)header.findViewById(R.id.useremail);
        ImageView image = header.findViewById(R.id.userimage);

        name.setText(name_s);
        email.setText(email_s);

        if(FirebaseAuth.getInstance().getCurrentUser() != null){
            name.setText(FirebaseAuth.getInstance().getCurrentUser().getDisplayName());
            email.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());
           Glide.with(this).load(FirebaseAuth.getInstance().getCurrentUser().getPhotoUrl().toString()).into(image);
        }

    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Class fragmentClass = null;

        FragmentManager fragmentManager = getSupportFragmentManager();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (id == R.id.nav_home) {
            if(bool_home) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                fragmentManager.beginTransaction().remove(fragment).commit();
                bool_home = true;
            }
        } else if (id == R.id.nav_timeline) {
            fragmentClass = TimelineFragment.class;
            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();
            bool_home = false;
        } else if (id == R.id.nav_dashboard) {
            fragmentClass = DashboardFragment.class;
            try {
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("eventList", eventList);
                fragment = (Fragment) fragmentClass.newInstance();
                fragment.setArguments(bundle);
            } catch (Exception e) {
                e.printStackTrace();
            }
            fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();
            bool_home = false;
        } else if (id == R.id.nav_contact_us) {
            fragmentClass = ContactUsFragment.class;
            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();
            bool_home = false;
        }
        else if (id == R.id.about_us) {
            fragmentClass = AboutUsFragment.class;
            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();
            bool_home = false;
        }
        else if (id == R.id.nav_logout) {
            bool_home = false;
            signOut();
            Intent intent = new Intent(MainActivity.this,Portal.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();

        }
//        else if (id == R.id.nav_edit_profile) {
//            Intent intent = new Intent(this,ProfileInfo.class);
//            startActivity(intent);
//        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    GoogleApiClient mGoogleApiClient;
    @Override
    protected void onStart() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
        mGoogleApiClient.connect();
        super.onStart();
    }

    private void signOut() {
        FirebaseAuth.getInstance().signOut();
        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        // ...
                        Toast.makeText(getApplicationContext(),"Logged Out",Toast.LENGTH_SHORT).show();

                    }
                });
    }
}
