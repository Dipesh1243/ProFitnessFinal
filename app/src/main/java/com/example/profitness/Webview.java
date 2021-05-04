package com.example.profitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.MediaController;

public class Webview extends AppCompatActivity {

    WebView webView;
    Button bt1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        webView = findViewById(R.id.webviewvideo);
        bt1 = findViewById(R.id.backweb);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(Webview.this, ViewExercises.class);
                startActivity(i2);
            }
        });


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String res_image = bundle.getString("my_image");
            webView.setWebViewClient(new WebViewClient());
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);

            if (res_image.equals("swim")) {

                webView.loadUrl("https://www.wikihow.com/Swim");


            } else if (res_image.equals("jump")) {
                webView.loadUrl("https://www.wikihow.com/Jump-Rope");
            } else if (res_image.equals("jog")) {
                webView.loadUrl("https://www.wikihow.com/Jog");
            } else if (res_image.equals("box")) {
                webView.loadUrl("https://www.wikihow.com/Train-for-Boxing");
            } else if (res_image.equals("cycle")) {
                webView.loadUrl("https://www.wikihow.com/Ride-a-Bicycle");
            } else if (res_image.equals("powerwalk")) {
                webView.loadUrl("https://www.wikihow.com/Walk-Fast");
            } else if (res_image.equals("rowing")) {
                webView.loadUrl("https://www.wikihow.com/Row-on-a-Rowing-Machine");
            } else if (res_image.equals("elliptical")) {
                webView.loadUrl("https://www.wikihow.com/Use-an-Elliptical-Machine");
            } else if (res_image.equals("stairs")) {
                webView.loadUrl("https://www.wikihow.com/Use-a-Stairmaster");
            } else if (res_image.equals("treadmill")) {
                webView.loadUrl("https://www.wikihow.fitness/Use-a-Treadmill-For-Beginners");
            } else if (res_image.equals("spinbike")) {
                webView.loadUrl("https://www.wikihow.com/Use-a-Spin-Bike");
            } else if (res_image.equals("shouldershrugs")) {
                webView.loadUrl("https://www.wikihow.com/Do-Shoulder-Shrugs");
            } else if (res_image.equals("latraises")) {
                webView.loadUrl("https://www.wikihow.com/Do-a-Lateral-Raise");
            } else if (res_image.equals("rblatraises")) {
                webView.loadUrl("https://www.muscleandstrength.com/exercises/banded-lateral-raise");
            } else if (res_image.equals("bentraises")) {
                webView.loadUrl("https://www.wikihow.com/Do-a-Bent-over-Row");
            } else if (res_image.equals("standcalf")) {
                webView.loadUrl("https://www.muscleandstrength.com/exercises/standing-machine-calf-raise#:~:text=Standing%20Machine%20Calf%20Raise%20Instructions&text=Extend%20the%20hips%20and%20knees,the%20assigned%20number%20of%20repetitions.");
            } else if (res_image.equals("seatedcalf")) {
                webView.loadUrl("https://www.muscleandstrength.com/exercises/seated-calf-raise.html#:~:text=Seated%20Calf%20Raise%20Instructions&text=Position%20the%20base%20of%20quads,as%20you%20flex%20the%20calves.");
            } else if (res_image.equals("farm")) {
                webView.loadUrl("https://www.muscleandstrength.com/exercises/farmers-walk");
            } else if (res_image.equals("squat")) {
                webView.loadUrl("https://www.muscleandstrength.com/exercises/squat.html#:~:text=Don't%20lean%20forward%20as,and%20then%20repeat%20the%20movement.");
            } else if (res_image.equals("stiff")) {
                webView.loadUrl("https://www.muscleandstrength.com/exercises/stiff-leg-deadlift-aka-romanian-deadlift.html#:~:text=Stiff%20Leg%20Deadlift%20Instructions&text=Push%20your%20hips%20back%20and,same%20height%20as%20your%20shoulders.");
            } else if (res_image.equals("barbelbench")) {
                webView.loadUrl("https://www.wikihow.com/Bench-Press#:~:text=Begin%20with%20just%20the%20bar,the%20sternum%20%E2%80%94%20with%20the%20bar.");
            } else if (res_image.equals("dumbellbench")) {
                webView.loadUrl("https://www.muscleandstrength.com/exercises/dumbbell-bench-press.html");
            } else if (res_image.equals("inclinebarbell")) {
                webView.loadUrl("https://www.wikihow.com/Incline-Bench-Press");
            } else if (res_image.equals("inclinedumbbarbell")) {
                webView.loadUrl("https://www.muscleandstrength.com/exercises/incline-dumbbell-bench-press.html");
            } else if (res_image.equals("decline")) {
                webView.loadUrl("https://www.muscleandstrength.com/exercises/decline-bench-press.html#:~:text=Decline%20Bench%20Press%20Instructions&text=Let%20the%20weight%20settle%20and,breastbone)%20and%20touch%20the%20chest.");
            } else if (res_image.equals("decline2")) {
                webView.loadUrl("https://www.muscleandstrength.com/exercises/decline-dumbbell-bench-press.html");
            } else if (res_image.equals("chestpress")) {
                webView.loadUrl("https://www.muscleandstrength.com/exercises/hammer-strength-bench-press.html");
            } else if (res_image.equals("weightpush")) {
                webView.loadUrl("https://www.t-nation.com/training/tip-the-right-wrong-way-to-do-weighted-push-ups");
            } else if (res_image.equals("weightdip")) {
                webView.loadUrl("https://www.wikihow.com/Do-Dips");
            } else if (res_image.equals("closegrip")) {
                webView.loadUrl("https://www.muscleandstrength.com/exercises/close-grip-bench-press.html");
            } else if (res_image.equals("pullover")) {
                webView.loadUrl("https://www.wikihow.com/Do-a-Dumbbell-Pullover#:~:text=Lower%20the%20dumbbell%20in%20an%20arc%20behind%20your%20head.&text=Keep%20your%20arms%20slightly%20bent%20as%20you%20move%20them.&text=Push%20your%20shoulders%20into%20the,lower%20it%20onto%20the%20bench.");
            } else if (res_image.equals("smithbench")) {
                webView.loadUrl("https://www.muscleandstrength.com/exercises/smith-machine-bench-press.html");
            } else if (res_image.equals("inclinedfly")) {
                webView.loadUrl("https://www.muscleandstrength.com/exercises/incline-dumbbell-flys.html#:~:text=Slightly%20retract%20your%20shoulder%20blades,back%20to%20their%20starting%20position.");
            } else if (res_image.equals("one")) {
                webView.loadUrl("https://www.muscleandstrength.com/exercises/cable-crossovers.html");
            } else if (res_image.equals("two")) {
                webView.loadUrl("https://www.verywellfit.com/how-to-use-a-chest-fly-machine-4589757");
            } else if (res_image.equals("three")) {
                webView.loadUrl("https://www.muscleandstrength.com/exercises/incline-cable-flys.html#:~:text=The%20incline%20bench%20cable%20fly,portion%20of%20your%20pec%20muscles.");
            } else if (res_image.equals("1")) {
                webView.loadUrl("https://www.wikihow.com/Do-Bicep-Curls");
            } else if (res_image.equals("2")) {
                webView.loadUrl("https://www.muscleandstrength.com/exercises/standing-hammer-curl.html");
            } else if (res_image.equals("3")) {
                webView.loadUrl("https://www.muscleandstrength.com/exercises/incline-dumbbell-curl.html");
            } else if (res_image.equals("4")) {
                webView.loadUrl("https://www.muscleandstrength.com/exercises/zottman-curl.html");
            } else if (res_image.equals("5")) {
                webView.loadUrl("https://www.myupchar.com/en/fitness/decline-dumbbell-curl#:~:text=Decline%20dumbbell%20curl%20targets%20the,like%20a%20charm%20for%20you.");
            } else if (res_image.equals("6")) {
                webView.loadUrl("https://www.wikihow.com/Do-a-Chin-Up#:~:text=Start%20by%20just%20holding%20the,Rest%20another%20few%20days.");
            } else if (res_image.equals("7")) {
                webView.loadUrl("https://www.muscleandstrength.com/exercises/ez-bar-curl.html");
            } else if (res_image.equals("8")) {
                webView.loadUrl("https://www.muscleandstrength.com/exercises/reverse-barbell-curl.html");
            } else if (res_image.equals("9")) {
                webView.loadUrl("https://www.muscleandstrength.com/exercises/cable-curl.html#:~:text=Cable%20Curl%20Instructions&text=Grasp%20the%20bar%20with%20an,it%20back%20to%20starting%20position.");
            } else if (res_image.equals("10")) {
                webView.loadUrl("https://www.muscleandstrength.com/exercises/concentration-cur.html");
            } else if (res_image.equals("ropetri")) {
                webView.loadUrl("https://www.muscleandstrength.com/exercises/rope-tricep-extension.html");
            } else if (res_image.equals("isolate")) {
                webView.loadUrl("https://www.muscleandstrength.com/exercises/two-arm-dumbbell-extension.html");

            } else if (res_image.equals("skullcrush")) {
                webView.loadUrl("https://www.muscleandstrength.com/exercises/ez-bar-skullcrusher.html");

            } else if (res_image.equals("triex")) {
                webView.loadUrl("https://www.wikihow.com/Do-a-Tricep-Workout");

            } else if (res_image.equals("a")) {
                webView.loadUrl("https://www.muscleandstrength.com/exercises/seated-shoulder-press.html");

            } else if (res_image.equals("c")) {
                webView.loadUrl("https://www.muscleandstrength.com/exercises/cable-face-pull");

            } else if (res_image.equals("d")) {
                webView.loadUrl("https://www.muscleandstrength.com/exercises/high-pull#:~:text=The%20high%20pull%20is%20a,the%20upper%20back%20and%20hamstrings.");

            } else if (res_image.equals("e")) {
                webView.loadUrl("https://www.muscleandstrength.com/exercises/clean-press.html");

            } else if (res_image.equals("h")) {
                webView.loadUrl("https://www.muscleandstrength.com/exercises/dumbbell-front-raise.html");

            } else if (res_image.equals("j")) {
                webView.loadUrl("https://www.muscleandstrength.com/exercises/machine-shoulder-press#:~:text=Machine%20Shoulder%20Press%20Overview,focus%20on%20isolating%20the%20shoulders.");

            } else if (res_image.equals("glutebridge")) {
                webView.loadUrl("https://www.wikihow.fitness/Do-a-Glute-Bridge#:~:text=Cross%20your%20arms%20over%20your,your%20hands%20on%20the%20floor.");

            } else if (res_image.equals("deadlift")) {
                webView.loadUrl("https://www.wikihow.com/Do-a-Deadlift");

            } else if (res_image.equals("hipthrust")) {
                webView.loadUrl("https://www.wikihow.com/Do-Hip-Thrusts");

            } else if (res_image.equals("kettle")) {
                webView.loadUrl("https://www.wikihow.fitness/Do-a-Kettleball-Swing");

            } else if (res_image.equals("legcurl")) {
                webView.loadUrl("https://www.wikihow.com/Perform-a-Hamstring-Curl");

            } else if (res_image.equals("q1")) {
                webView.loadUrl("https://www.wikihow.fitness/Front-Squat#:~:text=You'll%20start%20by%20setting,%2C%20reps%2C%20and%20grip%20styles.");

            } else if (res_image.equals("q2")) {
                webView.loadUrl("https://www.wikihow.com/Do-Leg-Extensions");
            } else if (res_image.equals("q3")) {
                webView.loadUrl("https://www.wikihow.com/Perform-a-Leg-Press-Safely");
            } else if (res_image.equals("q4")) {
                webView.loadUrl("https://www.muscleandstrength.com/exercises/dumbbell-goblet-squat");
            } else if (res_image.equals("q5")) {
                webView.loadUrl("https://www.wikihow.com/Do-a-Bulgarian-Split-Squat");
            } else if (res_image.equals("q6")) {
                webView.loadUrl("https://www.muscleandstrength.com/exercises/barbell-lunge.html");
            } else if (res_image.equals("q7")) {
                webView.loadUrl("https://www.wikihow.com/Do-a-Lateral-Step-Up");
            } else if (res_image.equals("q8")) {
                webView.loadUrl("https://www.wikihow.fitness/Do-a-Glute-Bridge");
            } else if (res_image.equals("q9")) {
                webView.loadUrl("https://www.wikihow.com/Do-a-Donkey-Kick");
            } else if (res_image.equals("q10")) {
                webView.loadUrl("https://www.wikihow.fitness/Do-a-One-Arm-Dumbbell-Row");
            } else if (res_image.equals("q11")) {
                webView.loadUrl("https://www.wikihow.com/Do-a-Bent-over-Row#:~:text=Grip%20a%20dumbbell%20in%20each,your%20abdomen%20and%20lower%20back.");
            } else if (res_image.equals("q12")) {
                webView.loadUrl("https://www.wikihow.com/Do-a-Seated-Cable-Row");
            } else if (res_image.equals("q13")) {
                webView.loadUrl("https://www.muscleandstrength.com/exercises/smith-machine-bodyweight-row.html");
            } else if (res_image.equals("q14")) {
                webView.loadUrl("https://www.wikihow.fitness/Do-a-Lat-Pulldown");
            } else if (res_image.equals("q15")) {
                webView.loadUrl("https://www.muscleandstrength.com/exercises/bent-over-row.html");
            } else if (res_image.equals("q16")) {
                webView.loadUrl("https://www.muscleandstrength.com/exercises/close-grip-pull-down.html");
            }


        }

    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}