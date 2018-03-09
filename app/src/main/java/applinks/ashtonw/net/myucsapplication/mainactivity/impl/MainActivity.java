package applinks.ashtonw.net.myucsapplication.mainactivity.impl;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.cjsoftware.library.platform.android.ucs.BaseUiActivity;
import com.cjsoftware.library.ucs.ContractBroker;
import com.cjsoftware.library.uistatepreservation.Preserve;
import com.cjsoftware.library.uistatepreservation.StatePreservationManager;

import applinks.ashtonw.net.myucsapplication.R;
import applinks.ashtonw.net.myucsapplication.application.Application;
import applinks.ashtonw.net.myucsapplication.mainactivity.MainActivityContract.Coordinator;
import applinks.ashtonw.net.myucsapplication.mainactivity.MainActivityContract.ScreenNavigation;
import applinks.ashtonw.net.myucsapplication.mainactivity.MainActivityContract.StateManager;
import applinks.ashtonw.net.myucsapplication.mainactivity.MainActivityContract.Ui;
import applinks.ashtonw.net.myucsapplication.mainactivity._di.DaggerMainActivityComponent;
import applinks.ashtonw.net.myucsapplication.mainactivity._di.MainActivityComponent;
import applinks.ashtonw.net.myucsapplication.mainactivity._di.MainActivityModule;

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

    @Override
    public void requestExit() {
        finish();
    }
}
