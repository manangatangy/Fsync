package com.wolfbang.fsync.missionsummary.impl;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.cjsoftware.library.platform.android.ucs.BaseUiActivity;
import com.cjsoftware.library.ucs.ContractBroker;
import com.cjsoftware.library.uistatepreservation.Preserve;
import com.cjsoftware.library.uistatepreservation.StatePreservationManager;
import com.wolfbang.fsync.R;
import com.wolfbang.fsync.application.Application;
import com.wolfbang.fsync.missionsummary.MissionSummaryActivityContract.Ui;
import com.wolfbang.fsync.missionsummary.MissionSummaryActivityContract.ScreenNavigation;
import com.wolfbang.fsync.missionsummary.MissionSummaryActivityContract.Coordinator;
import com.wolfbang.fsync.missionsummary.MissionSummaryActivityContract.StateManager;
import com.wolfbang.fsync.missionsummary._di.DaggerMissionSummaryComponent;
import com.wolfbang.fsync.missionsummary._di.MissionSummaryComponent;
import com.wolfbang.fsync.missionsummary._di.MissionSummaryModule;

/**
 * @author david
 * @date 09 Mar 2018.
 */
public class MissionSummaryActivity
        extends BaseUiActivity<Ui, ScreenNavigation, Coordinator, StateManager, MissionSummaryComponent>
        implements Ui, ScreenNavigation {

    @Preserve
    EditText mTextField;

    Button mButton;

    
    @NonNull
    @Override
    protected ContractBroker<Ui, ScreenNavigation, Coordinator, StateManager> createContractBroker(
            @NonNull MissionSummaryComponent component) {
        return component.provideContractBroker();
    }

    @Override
    protected void initializeStateManager(@NonNull StateManager stateManager) {
        stateManager.setEditTextEnableState(true);
    }

    @Override
    protected StatePreservationManager createStatePreservationManager() {
        return new MissionSummaryActivity_StatePreservationManager();
    }

    @NonNull
    @Override
    protected MissionSummaryComponent createComponent() {
        return DaggerMissionSummaryComponent.builder()
                .applicationComponent(Application.getComponent())
                .missionSummaryModule(new MissionSummaryModule())
                .build();
    }

    @Override
    protected void injectFields(@NonNull MissionSummaryComponent component) {
        component.inject(this);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_mission_summary;
    }

    @Override
    protected void onBindViews(View layoutRoot) {
        mTextField = layoutRoot.findViewById(R.id.edittext);
        mButton = layoutRoot.findViewById(R.id.button);
    }

    @Override
    protected void onAttachViewListeners() {
        super.onAttachViewListeners();
        mButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                getCoordinator().onUserClickedEnable();
            }
        });
    }

    @Override
    public void setEditTextEnable(boolean enable) {
        mTextField.setEnabled(enable);
    }

    @Override
    public void requestExit() {
        finish();
    }

}
