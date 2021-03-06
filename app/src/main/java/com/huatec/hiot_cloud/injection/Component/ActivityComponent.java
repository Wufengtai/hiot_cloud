/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.huatec.hiot_cloud.injection.Component;


import com.huatec.hiot_cloud.Test.MvpTest.Test.TestNetWorkActivity;
import com.huatec.hiot_cloud.UI.Login.LoginActivity;
import com.huatec.hiot_cloud.UI.MainActivity;
import com.huatec.hiot_cloud.Test.MvpTest.MvpTestActivity;
import com.huatec.hiot_cloud.UI.SplashActivity;
import com.huatec.hiot_cloud.UI.mine.mineFragment;
import com.huatec.hiot_cloud.UI.zhuce.ZhuceActivity;
import com.huatec.hiot_cloud.injection.PerActivity;
import com.huatec.hiot_cloud.injection.module.ActivityModule;

import dagger.Component;

/**
 * A base component upon which fragment's components may depend.
 * Activity-level components should extend this component.
 * <p>
 * Subtypes of ActivityComponent should be decorated with annotation:
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);
    void  inject(TestNetWorkActivity testNetWorkActivity);
    void inject(MvpTestActivity mvpTestActivity);
    void inject(LoginActivity activity);
    void inject(SplashActivity activity);
    void inject(ZhuceActivity activity);
    void inject(mineFragment fragment);
    @Component.Builder
    interface ActivityComponentBuilder {

        ActivityComponent build();

        ActivityComponentBuilder applicationComponent(ApplicationComponent applicationComponent);

        ActivityComponentBuilder activityModule(ActivityModule activityModule);
    }
}
