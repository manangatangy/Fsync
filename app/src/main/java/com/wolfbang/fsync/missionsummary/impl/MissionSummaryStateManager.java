package com.wolfbang.fsync.missionsummary.impl;

import com.wolfbang.fsync.missionsummary.MissionSummaryActivityContract.StateManager;

import javax.inject.Inject;

/**
 * @author david
 * @date 09 Mar 2018.
 */
public class MissionSummaryStateManager implements StateManager {

    private boolean mEditTextEnable;

    @Inject
    public MissionSummaryStateManager() {
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
