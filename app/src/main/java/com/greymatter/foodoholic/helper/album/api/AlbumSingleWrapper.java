/*
 * Copyright 2017 Yan Zhenjie.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.greymatter.foodoholic.helper.album.api;

import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;

import com.greymatter.foodoholic.helper.album.Album;
import com.greymatter.foodoholic.helper.album.AlbumFile;
import com.greymatter.foodoholic.helper.album.Filter;
import com.greymatter.foodoholic.helper.album.app.album.AlbumActivity;


public class AlbumSingleWrapper extends BasicChoiceAlbumWrapper<AlbumSingleWrapper, ArrayList<AlbumFile>, String, AlbumFile> {

    private Filter<Long> mDurationFilter;

    public AlbumSingleWrapper(Context context) {
        super(context);
    }

    /**
     * Filter video duration.
     *
     * @param filter filter.
     */
    public AlbumSingleWrapper filterDuration(Filter<Long> filter) {
        this.mDurationFilter = filter;
        return this;
    }

    @Override
    public void start() {
        AlbumActivity.sSizeFilter = mSizeFilter;
        AlbumActivity.sMimeFilter = mMimeTypeFilter;
        AlbumActivity.sDurationFilter = mDurationFilter;
        AlbumActivity.sResult = mResult;
        AlbumActivity.sCancel = mCancel;
        Intent intent = new Intent(mContext, AlbumActivity.class);
        intent.putExtra(Album.KEY_INPUT_WIDGET, mWidget);

        intent.putExtra(Album.KEY_INPUT_FUNCTION, Album.FUNCTION_CHOICE_ALBUM);
        intent.putExtra(Album.KEY_INPUT_CHOICE_MODE, Album.MODE_SINGLE);
        intent.putExtra(Album.KEY_INPUT_COLUMN_COUNT, mColumnCount);
        intent.putExtra(Album.KEY_INPUT_ALLOW_CAMERA, mHasCamera);
        intent.putExtra(Album.KEY_INPUT_LIMIT_COUNT, 1);
        intent.putExtra(Album.KEY_INPUT_FILTER_VISIBILITY, mFilterVisibility);
        intent.putExtra(Album.KEY_INPUT_CAMERA_QUALITY, mQuality);
        intent.putExtra(Album.KEY_INPUT_CAMERA_DURATION, mLimitDuration);
        intent.putExtra(Album.KEY_INPUT_CAMERA_BYTES, mLimitBytes);
        mContext.startActivity(intent);
    }
}