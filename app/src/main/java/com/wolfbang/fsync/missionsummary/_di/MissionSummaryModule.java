package com.wolfbang.fsync.missionsummary._di;

import com.cjsoftware.library.ucs.ContractBroker;

import com.wolfbang.fsync.missionsummary.MissionSummaryActivityContract.Coordinator;
import com.wolfbang.fsync.missionsummary.MissionSummaryActivityContract.ScreenNavigation;
import com.wolfbang.fsync.missionsummary.MissionSummaryActivityContract.StateManager;
import com.wolfbang.fsync.missionsummary.MissionSummaryActivityContract.Ui;
import com.wolfbang.fsync.missionsummary.MissionSummaryActivityContract_ContractBroker;
import com.wolfbang.fsync.missionsummary.impl.MissionSummaryCoordinator;
import com.wolfbang.fsync.missionsummary.impl.MissionSummaryStateManager;
import dagger.Module;
import dagger.Provides;

/**
 * @author david
 * @date 09 Mar 2018.
 */
@Module
public class MissionSummaryModule {
    @Provides
    public ContractBroker<Ui, ScreenNavigation, Coordinator, StateManager>
    provideContractBroker(MissionSummaryActivityContract_ContractBroker contractBroker) {
        return contractBroker;
    }

    @Provides
    public Coordinator provideCoordinator() {
        return new MissionSummaryCoordinator();
    }

    @Provides
    public StateManager provideStateManager(MissionSummaryStateManager stateManager) {
        return stateManager;
    }
}
