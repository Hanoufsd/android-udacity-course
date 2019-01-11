package andriodproject.tourguideapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Hanouf on 3/31/17.
 */

public class CategoryItemAdaptor extends ArrayAdapter<CategoryItem> {

    private static final String LOG_TAG = CategoryItemAdaptor.class.getSimpleName();

    public CategoryItemAdaptor(Context context, ArrayList<CategoryItem> categoryItem) {

        super(context, 0, categoryItem);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        CategoryItem currentCategoryItem = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID itemTextView.
        TextView itemTextView = (TextView) listItemView.findViewById(R.id.item_text);
        itemTextView.setText(currentCategoryItem.getItemTextResourceId());

        // Find the TextView in the list_item.xml layout with the ID item_additional_text.
        TextView itemAdditionalTextView = (TextView) listItemView.findViewById(R.id.item_additional_text);

        if (currentCategoryItem.hasAdditionalText())
        {
            itemAdditionalTextView.setText(currentCategoryItem.getItemAdditionalTextResourceId());
            itemAdditionalTextView.setVisibility(View.VISIBLE);
        }
        else
            itemAdditionalTextView.setVisibility(View.GONE);

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        // Check if an image is provided for this word or not
        if (currentCategoryItem.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentCategoryItem.getmImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }


        return listItemView;
    }
}
