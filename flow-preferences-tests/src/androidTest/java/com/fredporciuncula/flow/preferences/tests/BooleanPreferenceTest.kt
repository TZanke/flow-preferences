package com.fredporciuncula.flow.preferences.tests

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

@ExperimentalCoroutinesApi
class BooleanPreferenceTest : BaseTest() {

  @Test fun testDefaultValues() {
    val preference1 = flowSharedPreferences.getBoolean("key", defaultValue = false)
    assertThat(preference1.get()).isFalse()

    val preference2 = flowSharedPreferences.getBoolean("key", defaultValue = true)
    assertThat(preference2.get()).isTrue()
  }

  @Test fun testSettingValues() = runTest {
    val preference = flowSharedPreferences.getBoolean("key")

    preference.set(true)
    assertThat(preference.get()).isTrue()

    preference.setAndCommit(false)
    assertThat(preference.get()).isFalse()
  }
}
