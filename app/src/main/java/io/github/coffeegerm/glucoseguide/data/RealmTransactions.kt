/*
 * Copyright 2018 Coffee and Cream Studios
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

package io.github.coffeegerm.glucoseguide.data

import io.github.coffeegerm.glucoseguide.data.model.Entry
import io.realm.Realm
import javax.inject.Inject

/**
 * Class dedicated to transactions for the Realm database
 */

class RealmTransactions @Inject constructor() {
  
  val realm: Realm = Realm.getDefaultInstance()
  
  fun insertEntryToRealm(item: Entry) = realm.executeTransaction { realm.insertOrUpdate(item) }
  
  fun copyEntryToRealm(item: Entry) = realm.executeTransaction { realm.copyToRealm(item) }
  
  fun deleteEntry(item: Entry) = realm.executeTransaction { item.deleteFromRealm() }
}