package applinks.ashtonw.net.myucsapplication.mainactivity._di;

import com.cjsoftware.library.ucs.ContractBroker;

import applinks.ashtonw.net.myucsapplication.mainactivity.MainActivityContract.Coordinator;
import applinks.ashtonw.net.myucsapplication.mainactivity.MainActivityContract.ScreenNavigation;
import applinks.ashtonw.net.myucsapplication.mainactivity.MainActivityContract.StateManager;
import applinks.ashtonw.net.myucsapplication.mainactivity.MainActivityContract.Ui;
import applinks.ashtonw.net.myucsapplication.mainactivity.MainActivityContract_ContractBroker;
import applinks.ashtonw.net.myucsapplication.mainactivity.impl.MainActivityCoordinator;
import applinks.ashtonw.net.myucsapplication.mainactivity.impl.MainActivityStateManager;
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
