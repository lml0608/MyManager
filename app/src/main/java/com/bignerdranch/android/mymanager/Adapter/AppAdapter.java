package com.bignerdranch.android.mymanager.Adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.android.mymanager.AppInfo;
import com.bignerdranch.android.mymanager.R;
import com.bignerdranch.android.mymanager.activites.DetailActivity;

import org.w3c.dom.Text;

import java.util.List;

import static android.R.attr.transitionName;

/**
 * Created by lfs-ios on 18/5/17.
 */

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.AppHolder> {

    private static final String TAG = "AppAdapter";



    private Context mContext;
    private List<AppInfo> appList;


    public AppAdapter(List<AppInfo> appList, Context context) {
        this.appList = appList;
        mContext = context;
    }



    @Override
    public AppHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.list_item_app, parent, false);

        return new AppHolder(rootView);
    }

    @Override
    public void onBindViewHolder(AppHolder holder, int position) {

        AppInfo appInfo = appList.get(position);
        Log.i(TAG, appInfo.getName());
        holder.mTxtName.setText(appInfo.getName());
        holder.mTxtApk.setText(appInfo.getAPK());
        holder.mImageIcon.setImageDrawable(appInfo.getIcon());

        setButtonEvents(holder, appInfo);
    }

    @Override
    public int getItemCount() {
        return appList.size();
    }

    public class AppHolder extends RecyclerView.ViewHolder {


        protected ImageView mImageIcon;
        protected TextView mTxtName;
        protected TextView mTxtApk;
        protected CardView vCard;

        public AppHolder(View v) {
            super(v);

            vCard = (CardView) v.findViewById(R.id.app_card);
            mImageIcon = (ImageView) v.findViewById(R.id.imgIcon);

            mTxtName = (TextView) v.findViewById(R.id.txtName);
            mTxtApk = (TextView) v.findViewById(R.id.txtApk);


        }

    }


    private void setButtonEvents(AppHolder holder, final AppInfo appInfo) {

        CardView cardView = holder.vCard;
        final ImageView appIcon = holder.mImageIcon;

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity = (Activity) mContext;
                Intent intent = DetailActivity.newIntent(mContext, appInfo);

                Log.i(TAG, String.valueOf(((BitmapDrawable) appInfo.getIcon()).getBitmap()));

//                Bundle bundle = new Bundle();
//                bundle.putSerializable("app_info", appInfo);
//                bundle.putSerializable("app_apk", appInfo.getAPK());
//                bundle.putSerializable("app_version", appInfo.getVersion());
//                bundle.putSerializable("app_source", appInfo.getSource());
//                bundle.putSerializable("app_data", appInfo.getData());
//                //Bitmap bitmap = ((BitmapDrawable) appInfo.getIcon()).getBitmap();
//                //bundle.putSerializable("app_icon", bitmap);
//                bundle.putSerializable("app_isSystem", appInfo.isSystem());
                mContext.startActivity(intent);


//                intent.putExtra("app_name", appInfo.getName());
//                intent.putExtra("app_apk", appInfo.getAPK());
//                intent.putExtra("app_version", appInfo.getVersion());
//                intent.putExtra("app_source", appInfo.getSource());
//                intent.putExtra("app_data", appInfo.getData());
//                Bitmap bitmap = ((BitmapDrawable) appInfo.getIcon()).getBitmap();
//                intent.putExtra("app_icon", bitmap);
//                intent.putExtra("app_isSystem", appInfo.isSystem());

//                String transitionName = "App Icon Transition";
//                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
//                    ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(activity, appIcon, transitionName);
//                    mContext.startActivity(intent, transitionActivityOptions.toBundle());
//                }else {
//                    mContext.startActivity(intent);
//                    activity.overridePendingTransition(R.anim.slide_in_right, R.anim.fade_back);
//                }

            }
        });
    }
}
