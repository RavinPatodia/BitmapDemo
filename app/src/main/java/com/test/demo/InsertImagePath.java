package com.test.demo;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import com.demo.test.library.widget.DrawableResource;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询图片在相册的路径
 */

public class InsertImagePath {
    private static InsertImagePath mInstance = new InsertImagePath();

    private InsertImagePath() {
    }

    public static InsertImagePath getInstance() {
        return mInstance;
    }

    private List<DrawableResource> mPath = new ArrayList<>();

    public List<DrawableResource> getImagesPath(final Activity context) {

        Uri mImageUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        ContentResolver mContentResolver = context.getContentResolver();

        //只查询jpeg和png的图片
        Cursor mCursor = mContentResolver.query(mImageUri, null,
                MediaStore.Images.Media.MIME_TYPE + "=? or "
                        + MediaStore.Images.Media.MIME_TYPE + "=?",
                new String[]{"image/jpeg", "image/png"}, MediaStore.Images.Media.DATE_MODIFIED);

        if (mCursor == null) {
            return null;
        }

        while (mCursor.moveToNext()) {
            //获取图片的路径
            String path = mCursor.getString(mCursor
                    .getColumnIndex(MediaStore.Images.Media.DATA));

            DrawableResource drawablePath = new DrawableResource(path);

            if (!mPath.contains(drawablePath)) {
                mPath.add(drawablePath);
            }else {

            }
        }

        mCursor.close();
        return mPath;

    }
}
