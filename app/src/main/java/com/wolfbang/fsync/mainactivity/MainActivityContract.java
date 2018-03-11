package com.wolfbang.fsync.mainactivity;

import com.cjsoftware.library.ucs.BaseUcsContract;
import com.cjsoftware.library.ucs.UcsContract;

/**
 * @author chrisjames
 * @date 09 Mar 2018.
 */
@UcsContract
public interface MainActivityContract extends BaseUcsContract {

    interface ScreenNavigation extends BaseScreenNavigationContract {
        void navigateToMissionSummaryActivity();
        void requestExit();
    }

    interface Ui extends BaseUiContract {
        void setEditTextEnable(boolean enable);
    }

    interface Coordinator extends BaseCoordinatorContract {
        void onUserClickedEnable();
    }

    interface StateManager extends BaseStateManagerContract {
        void setEditTextEnableState(boolean enable);
        boolean isEditTextEnabled();
    }
}
