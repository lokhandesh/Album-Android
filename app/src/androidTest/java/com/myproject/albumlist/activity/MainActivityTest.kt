package com.myproject.albumlist.activity

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.myproject.albumlist.CustomAssertions.Companion.hasItemCount
import com.myproject.albumlist.CustomMatchers.Companion.withItemCount
import com.myproject.albumlist.R
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)


    @Before
    fun setup() {

    }

    @Test
    fun countAlbum() {
        Espresso.onView(ViewMatchers.withId(R.id.recycler_view)).check(ViewAssertions.matches(withItemCount(100)))
    }

    @Test
    fun countAlbumWithViewAssertion() {
        Espresso.onView(ViewMatchers.withId(R.id.recycler_view)).check(hasItemCount(100))
    }

    @Test
    fun testScreenLoad() {
        onView(withText("RetrofitRecycler")).check(matches(isDisplayed()))
    }

    @Test
    fun scrollToCourseCatalog() {
        onView(withText("quidem molestiae enim")).check(matches(isDisplayed()))
    }

    @After
    fun close() {

    }

}