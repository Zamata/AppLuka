/*
Copyright 2022 Google LLC

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package com.puyodev.luka.model.service.impl

//import com.puyodev.luka.BuildConfig
import com.puyodev.luka.R.xml as AppConfig
import com.puyodev.luka.model.service.ConfigurationService
//import com.puyodev.luka.model.service.trace sirve para medir el rendimiento de un bloque de código con Firebase Performance Monitoring.
import com.google.firebase.Firebase
import com.google.firebase.remoteconfig.get
import com.google.firebase.remoteconfig.remoteConfig//para administrar configuraciones remotas que pueden actualizarse sin necesidad de lanzar una nueva versión de la app.
import com.google.firebase.remoteconfig.remoteConfigSettings
import javax.inject.Inject
import kotlinx.coroutines.tasks.await

class ConfigurationServiceImpl @Inject constructor() : ConfigurationService {
  private val remoteConfig
    get() = Firebase.remoteConfig
/*
  init {
    if (BuildConfig.DEBUG) {
      val configSettings = remoteConfigSettings { minimumFetchIntervalInSeconds = 0 }
      remoteConfig.setConfigSettingsAsync(configSettings)
    }

    remoteConfig.setDefaultsAsync(AppConfig.remote_config_defaults)
  }
*/
  override suspend fun fetchConfiguration(): Boolean = true

  override val isShowTaskEditButtonConfig: Boolean
    get() = true

  companion object {
    private const val SHOW_TASK_EDIT_BUTTON_KEY = "show_task_edit_button"
    private const val FETCH_CONFIG_TRACE = "fetchConfig"
  }
}
