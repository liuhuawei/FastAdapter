package com.mikepenz.fastadapter_extensions.items;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikepenz.fastadapter.items.AbstractItem;
import com.mikepenz.fastadapter.utils.ViewHolderFactory;
import com.mikepenz.library_extensions.R;
import com.mikepenz.materialize.holder.ImageHolder;
import com.mikepenz.materialize.holder.StringHolder;

import java.util.List;

/**
 * Created by fabianterhorst on 30.03.16.
 */
public class ThreeLineItem extends AbstractItem<ThreeLineItem, ThreeLineItem.ViewHolder> {

    private static final ViewHolderFactory<? extends ViewHolder> FACTORY = new ItemFactory();

    private StringHolder mName, mDescription;

    private ImageHolder mAvatar, mIcon;

    public ThreeLineItem withName(String name) {
        this.mName = new StringHolder(name);
        return this;
    }

    public ThreeLineItem withDescription(String description) {
        this.mDescription = new StringHolder(description);
        return this;
    }

    public ThreeLineItem withAvatar(Drawable avatar) {
        this.mAvatar = new ImageHolder(avatar);
        return this;
    }

    public ThreeLineItem withAvatar(@DrawableRes int avatarRes) {
        this.mAvatar = new ImageHolder(avatarRes);
        return this;
    }

    public ThreeLineItem withAvatar(Uri uri) {
        this.mAvatar = new ImageHolder(uri);
        return this;
    }

    public ThreeLineItem withAvatar(Bitmap bitmap) {
        this.mAvatar = new ImageHolder(bitmap);
        return this;
    }

    public ThreeLineItem withAvatar(String url) {
        this.mAvatar = new ImageHolder(Uri.parse(url));
        return this;
    }

    public ThreeLineItem withIcon(Drawable icon) {
        this.mIcon = new ImageHolder(icon);
        return this;
    }

    public ThreeLineItem withIcon(@DrawableRes int iconRes) {
        this.mIcon = new ImageHolder(iconRes);
        return this;
    }

    public ThreeLineItem withIcon(Uri uri) {
        this.mIcon = new ImageHolder(uri);
        return this;
    }

    public ThreeLineItem withIcon(Bitmap bitmap) {
        this.mIcon = new ImageHolder(bitmap);
        return this;
    }

    public StringHolder getName() {
        return mName;
    }

    public StringHolder getDescription() {
        return mDescription;
    }

    public ImageHolder getAvatar() {
        return mAvatar;
    }

    public ImageHolder getIcon() {
        return mIcon;
    }

    @Override
    public int getType() {
        return R.id.three_line_item_id;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.three_line_item;
    }


    @Override
    public void bindView(ViewHolder holder, List<Object> payloads) {
        super.bindView(holder, payloads);
        mName.applyTo(holder.name);
        mDescription.applyTo(holder.description);
        ImageHolder.applyToOrSetInvisible(mAvatar, holder.avatar);
        ImageHolder.applyToOrSetInvisible(mIcon, holder.icon);
    }

    @Override
    public void unbindView(ViewHolder holder) {
        holder.name.setText(null);
        holder.description.setText(null);
        holder.avatar.setImageDrawable(null);
        holder.avatar.setVisibility(View.VISIBLE);
        holder.icon.setImageDrawable(null);
        holder.icon.setVisibility(View.VISIBLE);
    }

    protected static class ItemFactory implements ViewHolderFactory<ViewHolder> {
        public ViewHolder create(View v) {
            return new ViewHolder(v);
        }
    }

    @Override
    public ViewHolderFactory<? extends ViewHolder> getFactory() {
        return FACTORY;
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {

        protected TextView name, description;
        protected ImageView avatar, icon;

        public ViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            description = (TextView) view.findViewById(R.id.description);
            avatar = (ImageView) view.findViewById(R.id.avatar);
            icon = (ImageView) view.findViewById(R.id.icon);
        }
    }
}
