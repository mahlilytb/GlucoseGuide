/*
 * Copyright 2017 Coffee and Cream Studios
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.coffeegerm.glucoseguide.dagger

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import io.github.coffeegerm.glucoseguide.GlucoseGuide
import io.github.coffeegerm.glucoseguide.utils.Constants
import io.github.coffeegerm.glucoseguide.utils.SharedPreferencesManager
import javax.inject.Singleton

/**
 * Dagger AppModule that provides items for injection
 */

@Module
class AppModule(application: GlucoseGuide) {
  var app: GlucoseGuide = application
  
  @Provides
  @Singleton
  fun provideApplicationContext(): Context = app.applicationContext
  
  @Provides
  fun provideActivityResources(app: Context): Resources = app.resources
  
  @Provides
  fun provideSharedPreferences(context: Context): SharedPreferences = context.getSharedPreferences(Constants.SHARED_PREFERENCES, Context.MODE_PRIVATE)
  
  @Provides
  fun providesSharedPreferencesManager(sharedPreferences: SharedPreferences): SharedPreferencesManager = SharedPreferencesManager(sharedPreferences)
  
}