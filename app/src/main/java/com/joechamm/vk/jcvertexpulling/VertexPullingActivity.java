package com.joechamm.vk.jcvertexpulling;

import android.view.View;
import android.view.Window;

import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import com.google.androidgamesdk.GameActivity;

public class VertexPullingActivity extends GameActivity {
    static {
        System.loadLibrary ( "jcvertexpulling" );
    }

    @Override
    public void onWindowFocusChanged ( boolean hasFocus ) {
        super.onWindowFocusChanged ( hasFocus );

        if ( hasFocus ) {
            hideSystemUi ();
        }
    }

    private void hideSystemUi () {
        // Hide system UI
        Window window = getWindow ();
        View decoreView = getWindow ().getDecorView ();

        WindowCompat.setDecorFitsSystemWindows (window, false);
        WindowInsetsControllerCompat controllerCompat = new WindowInsetsControllerCompat ( window, decoreView );
        controllerCompat.hide ( WindowInsetsCompat.Type.systemBars () | WindowInsetsCompat.Type.navigationBars () );
        controllerCompat.setSystemBarsBehavior ( WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE );
    }
}
