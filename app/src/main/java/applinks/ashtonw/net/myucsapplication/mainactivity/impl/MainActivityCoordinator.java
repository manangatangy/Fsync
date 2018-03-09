package applinks.ashtonw.net.myucsapplication.mainactivity.impl;

import com.cjsoftware.library.core.UserNavigationRequest;
import com.cjsoftware.library.platform.android.ucs.BaseCoordinator;

import applinks.ashtonw.net.myucsapplication.mainactivity.MainActivityContract.Coordinator;
import applinks.ashtonw.net.myucsapplication.mainactivity.MainActivityContract.ScreenNavigation;
import applinks.ashtonw.net.myucsapplication.mainactivity.MainActivityContract.StateManager;
import applinks.ashtonw.net.myucsapplication.mainactivity.MainActivityContract.Ui;

/**
 * @author chrisjames
 * @date 09 Mar 2018.
 */

public class MainActivityCoordinator
        extends BaseCoordinator<Ui,ScreenNavigation,StateManager>
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
