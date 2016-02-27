package ua.lviv.devs.spinnerinlistview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by prossik on 26.02.16.
 */
public class ListViewAdapter extends BaseAdapter{
    ArrayList<String> mArrayList;
    Context context;
    private static LayoutInflater inflater=null;
    public ListViewAdapter(FragmentActivity mainActivity, ArrayList<String> arrayList) {
        mArrayList=arrayList;
        context=mainActivity;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {return mArrayList.size();}

    @Override
    public Object getItem(int position) {return position;}

    @Override
    public long getItemId(int position) {return position;}

    public class Holder
    {
        TextView tv;
        Spinner spinner;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.list_item, null);
        holder.tv=(TextView) rowView.findViewById(R.id.tv_item);
        holder.spinner = (Spinner) rowView.findViewById(R.id.spinner_item);
        holder.tv.setText(mArrayList.get(position));
        List<String> itemList = new ArrayList<>(
                Arrays.asList("0", "1", "2", "3", "4"));
        CustomSpinnerAdapter spinnerAdapter =
                new CustomSpinnerAdapter(
                        context, android.R.layout.simple_spinner_item, itemList);
        holder.spinner.setAdapter(spinnerAdapter);
        holder.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position != 0) {
                        Toast.makeText(context, "You clicked on " + position + " position inside spinner:)", Toast.LENGTH_SHORT).show();
                        holder.tv.setBackgroundColor(Color.parseColor("#bdbdbd"));
                    }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
return;
            }
        });


        return rowView;
    }

}