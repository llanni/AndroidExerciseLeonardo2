package com.freenow.android_demo;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.freenow.android_demo.activities.AuthenticationActivity;
import com.freenow.android_demo.activities.MainActivity;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.widget.Button;
import android.widget.EditText;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.freenow.android_demo.misc.Constants.LOG_TAG;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule
    public ActivityTestRule<AuthenticationActivity> authActivityRule =
        new ActivityTestRule<>(AuthenticationActivity.class);

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
        new ActivityTestRule<>(MainActivity.class);



    @Test
    public void failedLogin() throws Exception {
        String wrongUsername = "wrongUsername";
        String wrongPassword = "wrongPassword";

        Log.i(LOG_TAG, "verifyUnsuccessfullLoginAttempt() --- START");

        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        //1. Type wrong username in the username field
        Log.i(LOG_TAG, "1. Type wrong username in the username field");
        onView(withId(R.id.edt_username)).perform(typeText(""))
            .perform(click())
            .perform(typeText(wrongUsername));
        Log.i(LOG_TAG, "1. Type wrong username in the username field > Done");

        //2. Type wrong password in the password field
        Log.i(LOG_TAG, "2. Type wrong password in the password field");
        onView(withId(R.id.edt_password)).perform(typeText(""))
            .perform(click())
            .perform(typeText(wrongPassword));
        Log.i(LOG_TAG, "2. Type wrong password in the password field > Done");

        //3. Click on login button
        Log.i(LOG_TAG, "3. Click on login button");
        onView(withId(R.id.btn_login)).perform(click());
        Log.i(LOG_TAG, "3. Click on login button > Done");

        //4. Verify a 'login failed' message is displayed
        Log.i(LOG_TAG, "4. Verify a 'login failed' message is displayed");
        //onView(withId(android.R.id.content)).check(matches(withText(containsString("Login failed"))));
        onView(allOf(withId(android.support.design.R.id.snackbar_text), withText("Login failed")))
            .check(matches(isDisplayed()));
        Log.i(LOG_TAG, "4. Verify a 'login failed' message is displayed > Done");

        Thread.sleep(2000);
        Log.i(LOG_TAG, "verifyUnsuccessfullLoginAttempt() --- END");
    }

    @Test
    public void successfulLogin() throws Exception {
        String rightUsername = "crazydog335";
        String rightPassword = "venture";

        Log.i(LOG_TAG, "verifySuccessfullLoginAttempt() --- START");

        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        //1. Type wrong username in the username field
        Log.i(LOG_TAG, "1. Type wrong username in the username field");
        onView(withId(R.id.edt_username)).perform(typeText(""))
            .perform(click())
            .perform(typeText(rightUsername));
        Log.i(LOG_TAG, "1. Type wrong username in the username field > Done");

        //2. Type wrong password in the password field
        Log.i(LOG_TAG, "2. Type wrong password in the password field");
        onView(withId(R.id.edt_password)).perform(typeText(""))
            .perform(click())
            .perform(typeText(rightPassword));
        Log.i(LOG_TAG, "2. Type wrong password in the password field > Done");

        //3. Click on login button
        Log.i(LOG_TAG, "3. Click on login button");
        onView(withId(R.id.btn_login)).perform(click());
        Log.i(LOG_TAG, "3. Click on login button > Done");

        //4. Verify the 'FREE NOW demo' is visualized in the main panel
        Log.i(LOG_TAG, "Verify the 'FREE NOW demo' is visualized in the main panel");
        String mainPageTitle = "FREE Now demo";
        onView(withText(equalToIgnoringCase(mainPageTitle))).check(matches(isDisplayed()));
        Log.i(LOG_TAG, "Verify the 'FREE NOW demo' is visualized in the main panel > Done");
    }

    @Test
    public void callDriver() throws Exception {
        String rightUsername = "crazydog335";
        String rightPassword = "venture";

        Log.i(LOG_TAG, "verifySuccessfullLoginAttempt() --- START");

        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        //1. Type wrong username in the username field
        Log.i(LOG_TAG, "1. Type wrong username in the username field");
        onView(withId(R.id.edt_username)).perform(typeText(""))
            .perform(click())
            .perform(typeText(rightUsername));
        Log.i(LOG_TAG, "1. Type wrong username in the username field > Done");

        //2. Type wrong password in the password field
        Log.i(LOG_TAG, "2. Type wrong password in the password field");
        onView(withId(R.id.edt_password)).perform(typeText(""))
            .perform(click())
            .perform(typeText(rightPassword));
        Log.i(LOG_TAG, "2. Type wrong password in the password field > Done");

        //3. Click on login button
        Log.i(LOG_TAG, "3. Click on login button");
        onView(withId(R.id.btn_login)).perform(click());
        Log.i(LOG_TAG, "3. Click on login button > Done");

        //4. Verify the 'FREE NOW demo' is visualized in the main panel
        Log.i(LOG_TAG, "Verify the 'FREE NOW demo' is visualized in the main panel");
        String mainPageTitle = "FREE Now demo";
        onView(withText(equalToIgnoringCase(mainPageTitle))).check(matches(isDisplayed()));
        Log.i(LOG_TAG, "Verify the 'FREE NOW demo' is visualized in the main panel > Done");

        //5. Write 'sa' into the driver search text box
        Log.i(LOG_TAG, "5. Write 'sa' into the driver search text box");
        String textToSearch = "sa";
        onView(withId(R.id.textSearch)).perform(typeText(""))
            .perform(click())
            .perform(typeText(textToSearch));
        Log.i(LOG_TAG, "5. Write 'sa' into the driver search text box > Done");

        //6. Click on the second name
        Log.i(LOG_TAG, "6. Click on the second name");
        onView(withText("Samantha Reed")).inRoot(withDecorView(Matchers.not(is(mActivityRule.getActivity().getWindow().getDecorView())))).perform(click());
        Log.i(LOG_TAG, "6. Click on the second name > Done");

        //7. Verify you are on the Driver Profile page
        Log.i(LOG_TAG, "7. Verify you are on the Driver Profile page");
        String driverProfilePageTitle = "Driver Profile";
        onView(withText(equalToIgnoringCase(driverProfilePageTitle))).check(matches(isDisplayed()));
        Log.i(LOG_TAG, "7. Verify you are on the Driver Profile page > Done");

        //8. Click to call the driver
        Log.i(LOG_TAG, "8. Click to call the driver");
        ViewInteraction floatingActionButton = onView(
            Matchers.allOf(withId(R.id.fab), childAtPosition(childAtPosition(withId(android.R.id.content), 0), 2), isDisplayed()));
        floatingActionButton.perform(click());
        Log.i(LOG_TAG, "8. Click to call the driver > Done");

        Thread.sleep(1000);
        Log.i(LOG_TAG, "verifySuccessfullLoginAttempt() --- END");
    }

    private static Matcher<View> childAtPosition(
        final Matcher<View> parentMatcher, final int position)
    {

        return new TypeSafeMatcher<View>()
        {
            @Override
            public void describeTo(Description description)
            {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }


            @Override
            public boolean matchesSafely(View view)
            {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                    && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
