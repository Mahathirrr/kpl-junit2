package com.example.testingproject2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Local Unit Tests for Calculator class
 *
 * Test Cases:
 * 1. testAddition
 *    - Tests the add() method of Calculator
 *    - Verifies that 2 + 2 equals 4
 *    - Basic arithmetic operation validation
 *
 * 2. testSubtraction
 *    - Tests the subtract() method of Calculator
 *    - Verifies that 5 - 3 equals 2
 *    - Basic arithmetic operation validation
 *
 * 3. testPasswordValidation_Empty
 *    - Tests password validation with empty input
 *    - Verifies that empty password returns error message
 *    - Input validation testing
 *
 * 4. testPasswordValidation_TooShort
 *    - Tests password validation with short password
 *    - Verifies that password less than 6 characters returns error message
 *    - Boundary testing for password length
 */
public class ExampleUnitTest {
    private Calculator calculator = new Calculator();

    /**
     * Test case for addition operation
     *
     * Purpose:
     * - Validates that the add() method correctly performs addition
     * - Tests with simple positive integers (2 + 2)
     *
     * Expected Result:
     * - Should return 4 when adding 2 and 2
     * - Verifies basic arithmetic functionality
     */
    @Test
    public void testAddition() {
        assertEquals(4, calculator.add(2, 2));
    }

    /**
     * Test case for subtraction operation
     *
     * Purpose:
     * - Validates that the subtract() method correctly performs subtraction
     * - Tests with simple positive integers (5 - 3)
     *
     * Expected Result:
     * - Should return 2 when subtracting 3 from 5
     * - Verifies basic arithmetic functionality
     */
    @Test
    public void testSubtraction() {
        assertEquals(2, calculator.subtract(5, 3));
    }

    /**
     * Test case for password validation with empty input
     *
     * Purpose:
     * - Validates the behavior when an empty password is provided
     * - Tests edge case of empty string input
     *
     * Expected Result:
     * - Should return "Password cannot be empty" error message
     * - Ensures proper handling of empty input
     */
    @Test
    public void testPasswordValidation_Empty() {
        assertEquals("Password cannot be empty", calculator.validatePassword(""));
    }

    /**
     * Test case for password validation with short password
     *
     * Purpose:
     * - Validates the minimum length requirement for passwords
     * - Tests boundary condition with a 5-character password
     *
     * Expected Result:
     * - Should return "Password must be at least 6 characters" error message
     * - Ensures proper length validation
     */
    @Test
    public void testPasswordValidation_TooShort() {
        assertEquals("Password must be at least 6 characters", calculator.validatePassword("12345"));
    }
}
