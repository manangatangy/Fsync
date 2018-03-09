package com.wolfbang.fsync.missionsummary._di;

import com.cjsoftware.library.ucs.ContractBroker;
import com.wolfbang.fsync.application._di.ApplicationComponent;
import com.wolfbang.fsync.missionsummary.MissionSummaryActivityContract.Ui;
import com.wolfbang.fsync.missionsummary.MissionSummaryActivityContract.ScreenNavigation;
import com.wolfbang.fsync.missionsummary.MissionSummaryActivityContract.Coordinator;
import com.wolfbang.fsync.missionsummary.MissionSummaryActivityContract.StateManager;
import com.wolfbang.fsync.missionsummary.impl.MissionSummaryActivity;
import com.wolfbang.fsync.shared.PerActivity;

import dagger.Component;

/**
 * @author david
 * @date 09 Mar 2018.
 */
@PerActivity
@Component(
        dependencies = ApplicationComponent.class,
        modules={MissionSummaryModule.class}
)
public interface MissionSummaryComponent {

    void inject(MissionSummaryActivity mainActivity);
    ContractBroker<Ui, ScreenNavigation, Coordinator, StateManager> provideContractBroker();

}
