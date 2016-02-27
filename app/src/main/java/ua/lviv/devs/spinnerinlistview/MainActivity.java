package ua.lviv.devs.spinnerinlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadLandingFragment();
    }

    private void loadLandingFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(
                        R.id.main_container,
                        new LandingFragment(),
                        LandingFragment.TAG)
                .addToBackStack(LandingFragment.TAG)
                .commit();
    }
}
