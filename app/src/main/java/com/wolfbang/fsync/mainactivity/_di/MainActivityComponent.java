package com.wolfbang.fsync.mainactivity._di;

import com.cjsoftware.library.ucs.ContractBroker;

import com.wolfbang.fsync.application._di.ApplicationComponent;
import com.wolfbang.fsync.mainactivity.MainActivityContract.Coordinator;
import com.wolfbang.fsync.mainactivity.MainActivityContract.ScreenNavigation;
import com.wolfbang.fsync.mainactivity.MainActivityContract.StateManager;
import com.wolfbang.fsync.mainactivity.MainActivityContract.Ui;
import com.wolfbang.fsync.mainactivity.impl.MainActivity;
import com.wolfbang.fsync.shared.PerActivity;
import dagger.Component;

/**
 * @author chrisjames
 * @date 09 Mar 2018.
 */
@PerActivity
@Component(
        dependencies = ApplicationComponent.class,
        modules={MainActivityModule.class}
)
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);
    ContractBroker<Ui, ScreenNavigation, Coordinator, StateManager> provideContractBroker();

}
