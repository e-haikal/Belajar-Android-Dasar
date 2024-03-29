package com.tuntasdigital.belajarandroiddasar

import android.content.Context
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.ViewAction.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    lateinit var mainActivityScenario: ActivityScenario<MainActivity>

//    @Before
//    fun setUp() {
//        mainActivityScenario = ActivityScenario.launch(MainActivity::class.java)
//    }
//
//    @After
//    fun tearDown() {
//        mainActivityScenario.close()
//    }

    @get:Rule
    var mainActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testSayHello() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val name = "Asman"

        onView(withId(R.id.namaAndaEditText))
            .perform(typeText(name))

        onView(withId(R.id.sayHaiButton))
            .perform(click())

        onView(withId(R.id.haiTextView))
            .check(matches(withText(context.getString(R.string.haiTextView, name))))

        Thread.sleep(4000)
    }
}
