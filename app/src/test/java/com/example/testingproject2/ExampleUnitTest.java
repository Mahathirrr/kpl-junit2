package com.example.testingproject2;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Pengujian Unit Lokal untuk kelas Calculator
 *
 * Kasus Pengujian:
 * 1. testAddition
 *    - Menguji metode add() dari Calculator
 *    - Memverifikasi bahwa 2 + 2 sama dengan 4
 *    - Validasi operasi aritmatika dasar
 *
 * 2. testSubtraction
 *    - Menguji metode subtract() dari Calculator
 *    - Memverifikasi bahwa 5 - 3 sama dengan 2
 *    - Validasi operasi aritmatika dasar
 *
 * 3. testPasswordValidation_Empty
 *    - Menguji validasi kata sandi dengan input kosong
 *    - Memverifikasi bahwa kata sandi kosong mengembalikan pesan kesalahan
 *    - Pengujian validasi input
 *
 * 4. testPasswordValidation_TooShort
 *    - Menguji validasi kata sandi dengan kata sandi yang terlalu pendek
 *    - Memverifikasi bahwa kata sandi kurang dari 6 karakter mengembalikan pesan kesalahan
 *    - Pengujian batas untuk panjang kata sandi
 */
public class ExampleUnitTest {
    private Calculator calculator = new Calculator();
    /**
     * Kasus pengujian untuk operasi penambahan
     *
     * Tujuan:
     * - Memvalidasi bahwa metode add() dengan benar melakukan penambahan
     * - Menguji dengan bilangan bulat positif sederhana (2 + 2)
     *
     * Hasil yang Diharapkan:
     * - Harus mengembalikan 4 ketika menambahkan 2 dan 2
     * - Memverifikasi fungsionalitas aritmatika dasar
     */
    @Test
    public void testAddition() {
        assertEquals(4, calculator.add(2, 2));
    }
    /**
     * Kasus pengujian untuk operasi pengurangan
     *
     * Tujuan:
     * - Memvalidasi bahwa metode subtract() dengan benar melakukan pengurangan
     * - Menguji dengan bilangan bulat positif sederhana (5 - 3)
     *
     * Hasil yang Diharapkan:
     * - Harus mengembalikan 2 ketika mengurangkan 3 dari 5
     * - Memverifikasi fungsionalitas aritmatika dasar
     */
    @Test
    public void testSubtraction() {
        assertEquals(2, calculator.subtract(5, 3));
    }
    /**
     * Kasus pengujian untuk validasi kata sandi dengan input kosong
     *
     * Tujuan:
     * - Memvalidasi perilaku ketika kata sandi kosong diberikan
     * - Menguji kasus batas dari input string kosong
     *
     * Hasil yang Diharapkan:
     * - Harus mengembalikan pesan kesalahan "Password cannot be empty"
     * - Memastikan penanganan yang tepat untuk input kosong
     */
    @Test
    public void testPasswordValidation_Empty() {
        assertEquals("Password cannot be empty", calculator.validatePassword(""));
    }
    /**
     * Kasus pengujian untuk validasi kata sandi dengan kata sandi pendek
     *
     * Tujuan:
     * - Memvalidasi persyaratan panjang minimum untuk kata sandi
     * - Menguji kondisi batas dengan kata sandi 5 karakter
     *
     * Hasil yang Diharapkan:
     * - Harus mengembalikan pesan kesalahan "Password must be at least 6 characters"
     * - Memastikan validasi panjang yang tepat
     */
    @Test
    public void testPasswordValidation_TooShort() {
        assertEquals("Password must be at least 6 characters", calculator.validatePassword("12345"));
    }
}
