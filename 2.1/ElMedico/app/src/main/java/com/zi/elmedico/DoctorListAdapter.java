package com.zi.elmedico;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by zi on 3/28/2018.
 */

public class DoctorListAdapter extends ArrayAdapter<Doctor> {

    private static final String TAG = "DoctorListAdapter";
    private Context mContext;
    private int mResource;
    private int lastPosition=-1;
    private static class ViewHolder {
        TextView name;
        TextView speciality;
        TextView address;
    }


    public DoctorListAdapter(Context context, int resource,
                             ArrayList<Doctor> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource=resource;



    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String name = getItem(position).getName();
        String speciality = getItem(position).getSpeciality();
        String address = getItem(position).getAddress();
        Doctor doctor=new Doctor(name,speciality,address);

        final View result;
        ViewHolder holder;
        if(convertView==null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
            holder = new ViewHolder();
            holder.name = convertView.findViewById(R.id.textView1);
            holder.speciality = convertView.findViewById(R.id.textView2);
            holder.address = convertView.findViewById(R.id.textView3);
            result=convertView;
            convertView.setTag(holder);
        }
        else {
            holder=(ViewHolder)convertView.getTag();
            result=convertView;
        }
        Animation animation= AnimationUtils.loadAnimation(mContext,
                (position>lastPosition)?R.anim.load_down_anim:R.anim.load_up_anim);
        result.startAnimation(animation);
        lastPosition=position;
        holder.name.setText(doctor.getName());
        holder.speciality.setText(doctor.getSpeciality());
        holder.address.setText(doctor.getAddress());

        return convertView;

    }
}
