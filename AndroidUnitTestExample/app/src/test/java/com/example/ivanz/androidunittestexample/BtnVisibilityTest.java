package com.example.ivanz.androidunittestexample;

import android.widget.Button;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = "src/main/AndroidManifest.xml", sdk = 21, constants = BuildConfig.class)
public class BtnVisibilityTest {

    private MainActivity mainActivity;
    private MainActivity mockedMainActivity;
    private Button btn;

    @Before
    public void init() {
        mainActivity = Robolectric.buildActivity(MainActivity.class).create().get();
        mockedMainActivity = Mockito.spy(mainActivity);
        btn = (Button) mockedMainActivity.findViewById(R.id.btn);
    }

    @Test
    public void testButtonVisability() {
        when(mockedMainActivity.isVisible()).thenReturn(Boolean.TRUE);
        mainActivity.isBtnVisible();
        Assert.assertEquals(Button.VISIBLE, btn.getVisibility());
    }

    @Test
    public void testButtonInvisibility() {
        when(mockedMainActivity.isVisible()).thenReturn(Boolean.FALSE);
        mockedMainActivity.isBtnVisible();
        Assert.assertEquals(Button.INVISIBLE, btn.getVisibility());
    }
}
