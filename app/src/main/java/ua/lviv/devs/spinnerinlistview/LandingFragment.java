package ua.lviv.devs.spinnerinlistview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by prossik on 26.02.16.
 */
public class LandingFragment extends Fragment {
    public static final String TAG = LandingFragment.class.getSimpleName();
    private ArrayList<String> mStringArrayList;
    private ListView mListView;
    private ListViewAdapter mListViewAdapter;
    private Spinner mSpinner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.landing_fragment, container, false);
        mSpinner = (Spinner) root.findViewById(R.id.spinner_item);
        mStringArrayList = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            mStringArrayList.add(i, i + "");
        }
        mListView = (ListView)root.findViewById(R.id.lv_main);
        mListViewAdapter = new ListViewAdapter(getActivity(), mStringArrayList);
        mListView.setAdapter(mListViewAdapter);
        return root;
    }
}
