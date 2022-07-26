package com.fredporciuncula.flow.preferences.tests

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

@ExperimentalCoroutinesApi
class IntPreferenceTest : BaseTest() {

  @Test fun testDefaultValues() {
    val preference1 = flowSharedPreferences.getInt("key", defaultValue = 1)
    assertThat(preference1.get()).isEqualTo(1)

    val preference2 = flowSharedPreferences.getInt("key", defaultValue = 555)
    assertThat(preference2.get()).isEqualTo(555)
  }

  @Test fun testSettingValues() = runTest {
    val preference = flowSharedPreferences.getInt("key")

    preference.set(42)
    assertThat(preference.get()).isEqualTo(42)

    preference.setAndCommit(43)
    assertThat(preference.get()).isEqualTo(43)
  }
}
