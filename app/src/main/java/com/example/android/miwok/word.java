package com.example.android.miwok;

//{@link word} represents a vocabulary word that the user wants to learn.
//        it contains a default translation and a miwok translation for that word.

public class word {
    // Default translation for the word
    private String mDefaultTranslation;

    //  Miwok translation for the word
    private String mMiwokTranslation;

    // image resource id for the word
    private int mImageResourceId = NO_image_provided;

    private static final int NO_image_provided = -1;

    private int mAudioResourceId;

    public word(String defaultTranslationm, String miwokTranlation, int audioResourceId) {
        mDefaultTranslation = defaultTranslationm;
        mMiwokTranslation = miwokTranlation;
        mAudioResourceId = audioResourceId;
    }

    public word(String defaultTranslationm, String miwokTranlation, int imageResourceId, int audioResourceId) {
        mDefaultTranslation = defaultTranslationm;
        mMiwokTranslation = miwokTranlation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    // Get the default translation of the word
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    // Get the Miwok translation of the word
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    //returns the image resource ID of the word
    public boolean hasImage() {
        return mImageResourceId != NO_image_provided;
    }

    /**
     * Return the audio resource ID of the word.
     */
    public int getAudioResourceId() {
        return mAudioResourceId;
    }
}
