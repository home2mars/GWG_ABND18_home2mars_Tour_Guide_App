/*
 * Copyright (C) 2016 The Android Open Source Project
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
package com.example.android.gwg_abnd18_home2mars_tour_guide_app;

/**
 * {@link Place} represents a place a visitor might want to visit.
 * It contains a name, tagline and website for that place.
 */
public class Place {

    /**
     * Name for the place
     */
    private String mPlaceName = "";

    /**
     * TagLine for the place
     */
    private String mPlaceTagLine = "";

    /**
     * Website for the place
     */
    private String mWebsite = "";

    /**
     * Image resource ID for the place
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /**
     * Constant value that represents no image was provided for this place
     */
    private static final int NO_IMAGE_PROVIDED = -1;


    /**
     * Create a new Place object.
     *
     * @param placeName       is the name for the place
     * @param placeTagLine    is the tag line for the place
     * @param placeWebsite    is the website for the place
     * @param imageResourceId is the resource ID for the image file associated with this place
     */
    public Place(String placeName, String placeTagLine, String placeWebsite, int imageResourceId) {
        mPlaceName = placeName;
        mPlaceTagLine = placeTagLine;
        mWebsite = placeWebsite;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get name of the place
     */
    String getPlaceName() {
        return mPlaceName;
    }

    /**
     * Get address of the place
     */
    String getPlaceTagLine() {
        return mPlaceTagLine;
    }

    /**
     * Get website of the place
     */
    String getWebsite() {
        return mWebsite;
    }

    /**
     * Return the image resource ID of the place.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this place.
     */
    boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}


