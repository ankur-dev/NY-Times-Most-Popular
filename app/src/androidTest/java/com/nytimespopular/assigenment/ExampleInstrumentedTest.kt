package com.nytimespopular.assigenment

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.nytimespopular.assigenment.data.network.Task
import com.nytimespopular.assigenment.ui.HomeActivity
import com.nytimespopular.assigenment.ui.fragments.ArticleDetailFragment
import com.nytimespopular.assigenment.ui.fragments.ArticlesListFragment
import org.hamcrest.CoreMatchers
import org.hamcrest.Matcher
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.KoinTest


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest : KoinTest{
    /* Instantiate an IntentsTestRule object. */
    @get:Rule
    var activityRule: ActivityScenarioRule<HomeActivity> =
        ActivityScenarioRule(HomeActivity::class.java)



    fun withRecyclerView(recyclerViewId: Int): RecyclerViewMatcher {
        return RecyclerViewMatcher(recyclerViewId)
    }

    @Before
    fun registerIdlingResource() {
        IdlingRegistry.getInstance()
            .register(CountingIdlingResourceSingleton.countingIdlingResource)
        activityRule.scenario.onActivity {
            it.supportFragmentManager.beginTransaction().replace(
                R.id.fragmentContainer, ArticlesListFragment.newInstance(true),
                Task.ARTICLE_LIST_FRAGMENT.name
            ).commitAllowingStateLoss()
            Thread.sleep(500)
        }


    }

    @After
    fun unregisterIdlingResource() {
        IdlingRegistry.getInstance()
            .unregister(CountingIdlingResourceSingleton.countingIdlingResource)
    }


    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext: Context = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals(
            "com.nytimespopular.assigenment",
            appContext.packageName
        )
    }

    @Test
    fun testRecyclerView() {
        onView(withId(R.id.rvArticleList)).check(matches(isDisplayed()))
    }

    @Test
    fun testRecyclerViewItem() {

        onView(withRecyclerView(R.id.rvArticleList).atPositionOnView(0, R.id.tvTitle)).check(
            matches(isDisplayed())
        )

        onView(withRecyclerView(R.id.rvArticleList).atPositionOnView(0, R.id.tvDescription)).check(
            matches(isDisplayed())
        )
        onView(withRecyclerView(R.id.rvArticleList).atPositionOnView(0, R.id.tvDate)).check(
            matches(isDisplayed())
        )

        onView(withRecyclerView(R.id.rvArticleList).atPositionOnView(0, R.id.imgArticle)).check(
            matches(isDisplayed())
        )


        onView(withRecyclerView(R.id.rvArticleList).atPositionOnView(0, R.id.imgArrow)).check(
            matches(isDisplayed())
        )

    }



    @Test
    fun testRecyclerViewItemClick() {
        Thread.sleep(1000)
        onView(withId(R.id.rvArticleList)).
        perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>
            (0, ClickOnButtonView()))
    }



    @Test
    fun testDetailsFragment() {
        Thread.sleep(500)
        changeFragment()
        onView(withId(R.id.created_by_title_des)).check(matches(isDisplayed()))

    }

    fun changeFragment(){
        IdlingRegistry.getInstance()
            .register(CountingIdlingResourceSingleton.countingIdlingResource)
        activityRule.scenario.onActivity {
            it.supportFragmentManager.beginTransaction().replace(
                R.id.fragmentContainer, ArticleDetailFragment.newInstance(),
                Task.DETAIL_FRAGMENT.name
            ).commitAllowingStateLoss()
        }
    }


    inner class ClickOnButtonView : ViewAction {
        internal var click = click()

        override fun getConstraints(): Matcher<View> {
            return click.constraints
        }

        override fun getDescription(): String {
            return " click on custom button view"
        }

        override fun perform(uiController: UiController, view: View) {
            //btnClickMe -> Custom row item view button
            click.perform(uiController, view.findViewById(R.id.rowView))
        }

    }


    fun setTextInTextView(value: String): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return CoreMatchers.allOf(ViewMatchers.isDisplayed(), ViewMatchers.isAssignableFrom(
                    TextView::class.java))
            }

            override fun perform(uiController: UiController, view: View) {
                (view as TextView).text = value
            }

            override fun getDescription(): String {
                return "replace text"
            }
        }
    }
}