package com.example.android.pets;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.android.pets.data.PetContract;

/**
 * Created by fengzi113 on 2018/2/27.
 */

public class PetCursorAdapter extends CursorAdapter {

    public PetCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor,0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context)
                .inflate(R.layout.list_item,viewGroup,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView nameTextView = (TextView)view.findViewById(R.id.name);
        TextView summaryTextView = (TextView)view.findViewById(R.id.summary);

        int nameColumnIndex = cursor.getColumnIndex(PetContract.PetEntry.COLUMN_PET_NAME);
        int breedColumnIndex = cursor.getColumnIndex(PetContract.PetEntry.COLUMN_PET_BREED);

        String petName = cursor.getString(nameColumnIndex);
        String petBreed = cursor.getString(breedColumnIndex);

        nameTextView.setText(petName);
        summaryTextView.setText(petBreed);

        if (TextUtils.isEmpty(petBreed)){

            summaryTextView.setText(R.string.unknown_breed);

        }
    }
}
