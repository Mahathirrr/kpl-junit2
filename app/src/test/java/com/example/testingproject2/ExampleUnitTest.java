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

    @Test
    public void testAddition() {
        assertEquals(4, calculator.add(2, 2));
    }

    @Test
    public void testSubtraction() {
        assertEquals(2, calculator.subtract(5, 3));
    }

    @Test
    public void testPasswordValidation_Empty() {
        assertEquals("Password cannot be empty", calculator.validatePassword(""));
    }

    @Test
    public void testPasswordValidation_TooShort() {
        assertEquals("Password must be at least 6 characters", calculator.validatePassword("12345"));
    }
}
