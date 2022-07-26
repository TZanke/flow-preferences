package com.fredporciuncula.flow.preferences.tests

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

@ExperimentalCoroutinesApi
class LongPreferenceTest : BaseTest() {

  @Test fun testDefaultValues() {
    val preference1 = flowSharedPreferences.getLong("key", defaultValue = 430)
    assertThat(preference1.get()).isEqualTo(430)

    val preference2 = flowSharedPreferences.getLong("key", defaultValue = 3)
    assertThat(preference2.get()).isEqualTo(3)
  }

  @Test fun testSettingValues() = runTest {
    val preference = flowSharedPreferences.getLong("key")

    preference.set(28)
    assertThat(preference.get()).isEqualTo(28)

    preference.setAndCommit(67)
    assertThat(preference.get()).isEqualTo(67)
  }
}
