package com.example.coffeeshops

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UsabilityTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testSecondActivityElementsAreVisible() {
        // Navegar a SecondActivity
        onView(withId(R.id.recyclerView))
            .perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        // Verificar elementos en SecondActivity
        onView(withId(R.id.toolbar))
            .check(matches(isDisplayed()))

        onView(withId(R.id.textViewHeader))
            .check(matches(isDisplayed()))

        onView(withText("Muy recomendable. Volveré seguro"))
            .check(matches(isDisplayed()))

        onView(withText("Acogedor. Muy buen ambiente"))
            .check(matches(isDisplayed()))

        onView(withText("Buenos precios"))
            .check(matches(isDisplayed()))

        onView(withText("Servicio algo flojo"))
            .check(matches(isDisplayed()))

        onView(withText("Para repetir... extensa carta de cafés"))
            .check(matches(isDisplayed()))
    }
}