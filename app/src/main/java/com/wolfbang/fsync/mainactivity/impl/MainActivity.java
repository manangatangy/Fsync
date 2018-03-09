package com.wolfbang.fsync.mainactivity.impl;

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
import com.wolfbang.fsync.mainactivity.MainActivityContract.Coordinator;
import com.wolfbang.fsync.mainactivity.MainActivityContract.ScreenNavigation;
import com.wolfbang.fsync.mainactivity.MainActivityContract.StateManager;
import com.wolfbang.fsync.mainactivity.MainActivityContract.Ui;
import com.wolfbang.fsync.mainactivity._di.DaggerMainActivityComponent;
import com.wolfbang.fsync.mainactivity._di.MainActivityComponent;
import com.wolfbang.fsync.mainactivity._di.MainActivityModule;
import com.wolfbang.fsync.missionsummary.impl.MissionSummaryActivity;

public class MainActivity
        extends BaseUiActivity<Ui, ScreenNavigation, Coordinator, StateManager, MainActivityComponent>
        implements Ui, ScreenNavigation {


    @Preserve
    EditText mTextField;

    Button mButton;

    @NonNull
    @Override
    protected ContractBroker<Ui, ScreenNavigation, Coordinator, StateManager> createContractBroker(
            @NonNull MainActivityComponent component) {
        return component.provideContractBroker();
    }

    @Override
    protected void initializeStateManager(@NonNull StateManager stateManager) {
        stateManager.setEditTextEnableState(true);
    }

    @Override
    protected StatePreservationManager createStatePreservationManager() {
        return new MainActivity_StatePreservationManager();
    }

    @NonNull
    @Override
    protected MainActivityComponent createComponent() {
        return DaggerMainActivityComponent.builder()
                                          .applicationComponent(Application.getComponent())
                                          .mainActivityModule(new MainActivityModule())
                                          .build();
    }

    @Override
    protected void injectFields(@NonNull MainActivityComponent component) {
        component.inject(this);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
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

    //region MainActivityContract.ScreenNavigation
    @Override
    public void navigateToMissionSummaryActivity() {
        startActivity(MissionSummaryActivity.createIntent(this));
    }

    @Override
    public void requestExit() {
        finish();
    }
    //endregion
}
