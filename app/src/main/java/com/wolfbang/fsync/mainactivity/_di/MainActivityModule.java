package com.wolfbang.fsync.mainactivity._di;

import com.cjsoftware.library.ucs.ContractBroker;

import com.wolfbang.fsync.mainactivity.MainActivityContract.Coordinator;
import com.wolfbang.fsync.mainactivity.MainActivityContract.ScreenNavigation;
import com.wolfbang.fsync.mainactivity.MainActivityContract.StateManager;
import com.wolfbang.fsync.mainactivity.MainActivityContract.Ui;
import com.wolfbang.fsync.mainactivity.MainActivityContract_ContractBroker;
import com.wolfbang.fsync.mainactivity.impl.MainActivityCoordinator;
import com.wolfbang.fsync.mainactivity.impl.MainActivityStateManager;
import dagger.Module;
import dagger.Provides;

/**
 * @author chrisjames
 * @date 09 Mar 2018.
 */
@Module
public class MainActivityModule {
    @Provides
    public ContractBroker<Ui, ScreenNavigation, Coordinator, StateManager> provideContractBroker(MainActivityContract_ContractBroker contractBroker) {
        return contractBroker;
    }

    @Provides
    public Coordinator provideCoordinator() {
        return new MainActivityCoordinator();
    }

    @Provides
    public StateManager provideStateManager(MainActivityStateManager stateManager) {
        return stateManager;
    }
}
