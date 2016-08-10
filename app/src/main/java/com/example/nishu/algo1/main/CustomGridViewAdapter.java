package com.example.nishu.algo1.main;

import android.content.Context;
import android.support.v4.view.LayoutInflaterCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nishu.algo1.R;

import org.w3c.dom.Text;

/**
 * Created by Nishu on 03-08-2016.
 */
public class CustomGridViewAdapter extends BaseAdapter{

    private Context mcontext;
    private final String[] string;
    private final int[] Imageid;

    public CustomGridViewAdapter(String[] string, int[] imageid, Context mcontext) {
        this.string = string;
        Imageid = imageid;
        this.mcontext = mcontext;
    }

    @Override
    public int getCount() {
        return string.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(view == null){
            grid =  new View(mcontext);
            grid = inflater.inflate(R.layout.gridview_custom_layout,null);
            TextView textView = (TextView) grid.findViewById(R.id.gridview_text);
            ImageView imageView = (ImageView) grid.findViewById(R.id.gridview_image);
            textView.setText(string[i]);
            imageView.setImageResource(Imageid[i]);
        }
        else{
            grid = (View) view;
        }
        return grid;
    }
}
