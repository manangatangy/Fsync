package applinks.ashtonw.net.myucsapplication.mainactivity._di;

import com.cjsoftware.library.ucs.ContractBroker;

import applinks.ashtonw.net.myucsapplication.application._di.ApplicationComponent;
import applinks.ashtonw.net.myucsapplication.mainactivity.MainActivityContract.Coordinator;
import applinks.ashtonw.net.myucsapplication.mainactivity.MainActivityContract.ScreenNavigation;
import applinks.ashtonw.net.myucsapplication.mainactivity.MainActivityContract.StateManager;
import applinks.ashtonw.net.myucsapplication.mainactivity.MainActivityContract.Ui;
import applinks.ashtonw.net.myucsapplication.mainactivity.impl.MainActivity;
import applinks.ashtonw.net.myucsapplication.shared.PerActivity;
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
