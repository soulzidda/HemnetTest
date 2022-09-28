package com.abassey.hemnettest

import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.abassey.hemnettest.ui.details.DetailsScreen
import com.abassey.hemnettest.ui.main.MainActivity
import com.abassey.hemnettest.ui.shared.AdvertViewModel
import com.abassey.hemnettest.ui.theme.HemnetTestTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class DetailsViewTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private lateinit var activity: MainActivity

    @Before
    fun init() {
        composeTestRule.activityRule.scenario.onActivity {
            activity = it
        }
    }

    @Test
    fun detailsViewComposeTest() {
        composeTestRule.activity.setContent() {
            HemnetTestTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    val navController =
                        TestNavHostController(ApplicationProvider.getApplicationContext())
                    val advertViewModel = hiltViewModel<AdvertViewModel>()
                    DetailsScreen(
                        viewModel = advertViewModel,
                        advertId = "12345",
                        navController = navController
                    )
                }
            }

            composeTestRule.onNodeWithText("12345", ignoreCase = false).assertIsDisplayed()
        }
    }

}