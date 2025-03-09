package com.example.testingproject2;

import android.content.Context;
import android.widget.EditText;

import androidx.test.core.app.ActivityScenario;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented Tests for MainActivity
 *
 * Test Cases:
 * 1. useAppContext
 *    - Verifies the package name of the app context
 *    - Basic context validation
 *
 * 2. testPasswordValidation_UI_Empty
 *    - Tests password validation through UI with empty input
 *    - Verifies that clicking validate with empty field shows error message
 *    - UI interaction and validation testing
 *
 * 3. testPasswordValidation_UI_TooShort
 *    - Tests password validation through UI with short password
 *    - Verifies that entering short password shows error message
 *    - UI interaction and validation testing
 *
 * 4. testPasswordValidation_UI_Valid
 *    - Tests password validation through UI with valid password
 *    - Verifies that entering valid password shows success message
 *    - UI interaction and validation testing
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    /**
     * Test case to verify application context
     *
     * Purpose:
     * - Validates that the application context is correctly set up
     * - Verifies the package name matches the expected value
     *
     * Expected Result:
     * - Package name should match "com.example.testingproject2"
     * - Ensures proper app configuration
     */
    @Test
    public void useAppContext() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.testingproject2", appContext.getPackageName());
    }

    /**
     * Test case for UI password validation with empty input
     *
     * Purpose:
     * - Tests the UI behavior when validate button is clicked without entering password
     * - Validates error message display for empty input
     *
     * Steps:
     * 1. Launch MainActivity
     * 2. Click validate button without entering password
     * 3. Verify error message
     *
     * Expected Result:
     * - Should display "Password cannot be empty" message
     * - Validates proper UI feedback for empty input
     */
    @Test
    public void testPasswordValidation_UI_Empty() {
        ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.validateButton)).perform(click());
        onView(withId(R.id.resultText)).check(matches(withText("Password cannot be empty")));
    }

    /**
     * Test case for UI password validation with short password
     *
     * Purpose:
     * - Tests the UI behavior when a password shorter than 6 characters is entered
     * - Validates error message display for insufficient length
     *
     * Steps:
     * 1. Launch MainActivity
     * 2. Enter 5-character password
     * 3. Click validate button
     * 4. Verify error message
     *
     * Expected Result:
     * - Should display "Password must be at least 6 characters" message
     * - Validates proper UI feedback for short passwords
     */
    @Test
    public void testPasswordValidation_UI_TooShort() {
        ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.passwordInput)).perform(typeText("12345"));
        onView(withId(R.id.validateButton)).perform(click());
        onView(withId(R.id.resultText)).check(matches(withText("Password must be at least 6 characters")));
    }

    /**
     * Test case for UI password validation with valid password
     *
     * Purpose:
     * - Tests the UI behavior when a valid password is entered
     * - Validates success message display
     *
     * Steps:
     * 1. Launch MainActivity
     * 2. Enter 6-character password
     * 3. Click validate button
     * 4. Verify success message
     *
     * Expected Result:
     * - Should display "Valid password" message
     * - Validates proper UI feedback for valid passwords
     */
    @Test
    public void testPasswordValidation_UI_Valid() {
        ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.passwordInput)).perform(typeText("123456"));
        onView(withId(R.id.validateButton)).perform(click());
        onView(withId(R.id.resultText)).check(matches(withText("Valid password")));
    }
}
