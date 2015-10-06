package com.sam_chordas.android.stockhawk.rest;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sam_chordas.android.stockhawk.R;
import com.sam_chordas.android.stockhawk.touch_helper.ItemTouchHelperAdapter;

/**
 * Created by sam_chordas on 10/6/15.
 *  Credit to skyfishjy gist:
 *    https://gist.github.com/skyfishjy/443b7448f59be978bc59
 * for the code structure
 */
public class QuoteCursorAdapter extends CursorRecyclerViewAdapter<QuoteCursorAdapter.ViewHolder>
    implements ItemTouchHelperAdapter{
  private Context mContext;
  public QuoteCursorAdapter(Context context, Cursor cursor){
    super(context, cursor);
    mContext = context;
  }

  public static class ViewHolder extends RecyclerView.ViewHolder{
    public ViewHolder(View view){
      super(view);
    }
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
    View itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.list_item_quote, parent, false);
    ViewHolder vh = new ViewHolder(itemView);
    return vh;
  }

  @Override
  public void onBindViewHolder(ViewHolder viewHolder, Cursor cursor){

  }

  @Override public boolean onItemMove(int fromPosition, int toPosition) {
    return false;
  }

  @Override public void onItemDismiss(int position) {

  }

  @Override public int getItemCount() {
    return super.getItemCount();
  }
}