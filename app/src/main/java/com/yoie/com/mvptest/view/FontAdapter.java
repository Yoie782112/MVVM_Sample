package com.yoie.com.mvptest.view;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.yoie.com.mvptest.R;
import com.yoie.com.mvptest.model.Font;
import com.yoie.com.mvptest.databinding.ItemFontBinding;
import com.yoie.com.mvptest.model.Item;
import com.yoie.com.mvptest.viewmodel.ItemFontViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import android.support.v7.widget.RecyclerView;

public class FontAdapter extends RecyclerView.Adapter<FontAdapter.FontAdapterViewHolder> {

    private ArrayList<Item> fontList;

//    FontAdapter() {
//        this.fontList = Collections.emptyList();
//    }
    FontAdapter(ArrayList<Item> items) {
        this.fontList = items;
    }

    @NonNull
    @Override public FontAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFontBinding itemFontBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_font,
                        parent, false);
        return new FontAdapterViewHolder(itemFontBinding);
    }

    @Override public void onBindViewHolder(FontAdapterViewHolder holder, int position) {
        holder.bindFont(fontList.get(position));
    }

    @Override public int getItemCount() {
        return fontList.size();
    }

    void setFontList(ArrayList<Item> fontList) {
        this.fontList = fontList;
        notifyDataSetChanged();
    }

    static class FontAdapterViewHolder extends RecyclerView.ViewHolder {
        ItemFontBinding mItemFontBinding;

        FontAdapterViewHolder(ItemFontBinding itemFontBinding) {
            super(itemFontBinding.getRoot());
            this.mItemFontBinding = itemFontBinding;
        }

        void bindFont(Item font) {
            if (mItemFontBinding.getFontItem() == null) {
                mItemFontBinding.setFontItem(
                        new ItemFontViewModel(font, itemView.getContext()));
            } else {
                mItemFontBinding.getFontItem().setFont(font);
            }
            mItemFontBinding.executePendingBindings();

        }
    }
}
