package com.example.ramdani.customrecyclerviewdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by ramdanix on 11/28/17.
 */

public abstract class GenericAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH>{

    protected int mLayout;
    Class<VH> mViewHolder;
    Class<T> mModel;
    List<T> mListData;

    public GenericAdapter(int mLayout, Class<VH> mViewHolder, Class<T> mModel, List<T> mListData) {
        this.mLayout = mLayout;
        this.mViewHolder = mViewHolder;
        this.mModel = mModel;
        this.mListData = mListData;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewGroup view = (ViewGroup) LayoutInflater.from(parent.getContext()).inflate(mLayout,parent,false);
        try {
            Constructor<VH> constructor = mViewHolder.getConstructor(View.class);
            return constructor.newInstance(view);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        T model = mListData.get(position);
        bind(holder, model);
    }

    abstract protected void bind(VH holder, T model);

    public int getItemCount() {
        return mListData.size();
    }
}
