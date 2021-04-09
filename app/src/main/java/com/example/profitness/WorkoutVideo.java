package com.example.profitness;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import java.net.URI;

public class WorkoutVideo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_video);

        VideoView videoView = findViewById(R.id.video_view);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            int video = bundle.getInt("my_image");
            String videoPath = "android.resource://" + getPackageName() + "/" + video;

            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);

            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);

        }
    }
}