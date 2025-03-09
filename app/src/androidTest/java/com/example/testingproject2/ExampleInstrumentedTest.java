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
 * Pengujian Instrumen untuk MainActivity
 *
 * Kasus Pengujian:
 * 1. useAppContext
 *    - Memverifikasi nama paket dari konteks aplikasi
 *    - Validasi konteks dasar
 *
 * 2. testPasswordValidation_UI_Empty
 *    - Menguji validasi kata sandi melalui UI dengan input kosong
 *    - Memverifikasi bahwa mengklik validasi dengan kolom kosong menampilkan pesan kesalahan
 *    - Pengujian interaksi dan validasi UI
 *
 * 3. testPasswordValidation_UI_TooShort
 *    - Menguji validasi kata sandi melalui UI dengan kata sandi pendek
 *    - Memverifikasi bahwa memasukkan kata sandi pendek menampilkan pesan kesalahan
 *    - Pengujian interaksi dan validasi UI
 *
 * 4. testPasswordValidation_UI_Valid
 *    - Menguji validasi kata sandi melalui UI dengan kata sandi valid
 *    - Memverifikasi bahwa memasukkan kata sandi valid menampilkan pesan sukses
 *    - Pengujian interaksi dan validasi UI
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    /**
     * Kasus pengujian untuk memverifikasi konteks aplikasi
     *
     * Tujuan:
     * - Memvalidasi bahwa konteks aplikasi diatur dengan benar
     * - Memverifikasi nama paket sesuai dengan nilai yang diharapkan
     *
     * Hasil yang Diharapkan:
     * - Nama paket harus sesuai dengan "com.example.testingproject2"
     * - Memastikan konfigurasi aplikasi yang tepat
     */
    @Test
    public void useAppContext() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.testingproject2", appContext.getPackageName());
    }

    /**
     * Kasus pengujian untuk validasi kata sandi UI dengan input kosong
     *
     * Tujuan:
     * - Menguji perilaku UI ketika tombol validasi diklik tanpa memasukkan kata sandi
     * - Memvalidasi tampilan pesan kesalahan untuk input kosong
     *
     * Langkah-langkah:
     * 1. Meluncurkan MainActivity
     * 2. Mengklik tombol validasi tanpa memasukkan kata sandi
     * 3. Memverifikasi pesan kesalahan
     *
     * Hasil yang Diharapkan:
     * - Harus menampilkan pesan "Password cannot be empty"
     * - Memvalidasi umpan balik UI yang tepat untuk input kosong
     */
    @Test
    public void testPasswordValidation_UI_Empty() {
        ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.validateButton)).perform(click());
        onView(withId(R.id.resultText)).check(matches(withText("Password cannot be empty")));
    }

    /**
     * Kasus pengujian untuk validasi kata sandi UI dengan kata sandi pendek
     *
     * Tujuan:
     * - Menguji perilaku UI ketika kata sandi kurang dari 6 karakter dimasukkan
     * - Memvalidasi tampilan pesan kesalahan untuk panjang yang tidak mencukupi
     *
     * Langkah-langkah:
     * 1. Meluncurkan MainActivity
     * 2. Memasukkan kata sandi 5 karakter
     * 3. Mengklik tombol validasi
     * 4. Memverifikasi pesan kesalahan
     *
     * Hasil yang Diharapkan:
     * - Harus menampilkan pesan "Password must be at least 6 characters"
     * - Memvalidasi umpan balik UI yang tepat untuk kata sandi pendek
     */
    @Test
    public void testPasswordValidation_UI_TooShort() {
        ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.passwordInput)).perform(typeText("12345"));
        onView(withId(R.id.validateButton)).perform(click());
        onView(withId(R.id.resultText)).check(matches(withText("Password must be at least 6 characters")));
    }

    /**
     * Kasus pengujian untuk validasi kata sandi UI dengan kata sandi valid
     *
     * Tujuan:
     * - Menguji perilaku UI ketika kata sandi valid dimasukkan
     * - Memvalidasi tampilan pesan sukses
     *
     * Langkah-langkah:
     * 1. Meluncurkan MainActivity
     * 2. Memasukkan kata sandi 6 karakter
     * 3. Mengklik tombol validasi
     * 4. Memverifikasi pesan sukses
     *
     * Hasil yang Diharapkan:
     * - Harus menampilkan pesan "Valid password"
     * - Memvalidasi umpan balik UI yang tepat untuk kata sandi valid
     */
    @Test
    public void testPasswordValidation_UI_Valid() {
        ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.passwordInput)).perform(typeText("123456"));
        onView(withId(R.id.validateButton)).perform(click());
        onView(withId(R.id.resultText)).check(matches(withText("Valid password")));
    }
}
