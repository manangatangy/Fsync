package applinks.ashtonw.net.myucsapplication.application._di;


import com.cjsoftware.library.core.ObjectRegistry;
import com.cjsoftware.library.platform.android.core.facility.MainLooper;


import java.util.concurrent.Executor;

import javax.inject.Singleton;

import applinks.ashtonw.net.myucsapplication.application.Application;
import dagger.Component;


/**
 * Created by chris on 12/04/2015.
 */
@Singleton
@Component(
        modules = {ApplicationModule.class})
public interface ApplicationComponent {
    Application application();

    ObjectRegistry getObjectRegistry();

    Executor getExecutor();

    @MainLooper
    Executor getUiExecutor();

}
