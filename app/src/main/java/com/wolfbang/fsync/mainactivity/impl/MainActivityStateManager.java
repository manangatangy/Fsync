package com.wolfbang.fsync.mainactivity.impl;

import javax.inject.Inject;

import com.wolfbang.fsync.mainactivity.MainActivityContract.StateManager;

/**
 * @author chrisjames
 * @date 09 Mar 2018.
 */

public class MainActivityStateManager implements StateManager {

    private boolean mEditTextEnable;

    @Inject
    public MainActivityStateManager() {
    }

    @Override
    public void setEditTextEnableState(boolean enable) {
        try{
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            // dont care
        }

        mEditTextEnable = enable;
    }

    @Override
    public boolean isEditTextEnabled() {
        try{
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            // dont care
        }
        return mEditTextEnable;
    }
}
