package com.wolfbang.fsync.missionsummary.impl;

import com.cjsoftware.library.core.UserNavigationRequest;
import com.cjsoftware.library.platform.android.ucs.BaseCoordinator;

import com.wolfbang.fsync.missionsummary.MissionSummaryActivityContract.Coordinator;
import com.wolfbang.fsync.missionsummary.MissionSummaryActivityContract.ScreenNavigation;
import com.wolfbang.fsync.missionsummary.MissionSummaryActivityContract.StateManager;
import com.wolfbang.fsync.missionsummary.MissionSummaryActivityContract.Ui;

/**
 * @author david
 * @date 09 Mar 2018.
 */

public class MissionSummaryCoordinator extends BaseCoordinator<Ui,ScreenNavigation,StateManager>
        implements Coordinator {

    @Override
    public void onInitialize() {
        super.onInitialize();
        getUi().setEditTextEnable(getStateManager().isEditTextEnabled());
    }

    @Override
    public void onUserClickedEnable() {
        getStateManager().setEditTextEnableState(!getStateManager().isEditTextEnabled());
        getUi().setEditTextEnable(getStateManager().isEditTextEnabled());
    }

    @Override
    public void onUserNavigationRequest(UserNavigationRequest navigationRequest) {
        super.onUserNavigationRequest(navigationRequest);
        getScreenNavigation().requestExit();
    }

}
