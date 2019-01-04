package com.example.android.miwok;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mostafa on 20/04/2017.
 */

public class WordAdapter extends ArrayAdapter<word> {
    /** Resource ID for the background color for this list of words */
    private int mColorResourceId;
    public WordAdapter(Activity context, ArrayList<word> words,int ColorResourceId) {
        super(context, 0, words);
        mColorResourceId=ColorResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());
        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        if(currentWord.hasImage()) {
            // Set the ImageView to the image resource specified in the current
            imageView.setImageResource(currentWord.getImageResourceId());
            // هيطهر صورة
            imageView.setVisibility(View.VISIBLE);
        }
        else {
            // مش هيظهر صورة
            imageView.setVisibility(View.GONE);
        }

        //set the theme color for the list item
        View textcontainer = listItemView.findViewById(R.id.text_container);
        //find the color that the resource id maps to
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        //set the backgroud color of the text container view
        textcontainer.setBackgroundColor(color);
        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
