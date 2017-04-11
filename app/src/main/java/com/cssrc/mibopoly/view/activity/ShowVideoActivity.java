package com.cssrc.mibopoly.view.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cssrc.mibopoly.R;
import com.cssrc.mibopoly.view.widget.CustomMediaController;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class ShowVideoActivity extends AppCompatActivity implements MediaPlayer.OnInfoListener,
    MediaPlayer.OnBufferingUpdateListener{

    private Uri uri;
    @Bind(R.id.probar)
    ProgressBar progressBar;
    @Bind(R.id.download_rate)
    TextView downloadRateView;
    @Bind(R.id.load_rate)
    TextView loadRateView;
    @Bind(R.id.buffer)
    VideoView videoView;

    private MediaController mediaController;
    private CustomMediaController customMediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initVideo();
        setContentView(R.layout.activity_show_video);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initVideo(){
        int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;      //全屏参数
        Window window = ShowVideoActivity.this.getWindow();               //获取当前窗口
        window.setFlags(flag, flag);        //全屏显示
        Vitamio.isInitialized(this);
    }

    private void initView(){
        mediaController = new MediaController(this);
        customMediaController = new CustomMediaController(this, videoView, this);
    }

    private void initData(){
        String video = getIntent().getStringExtra("videoUri");                 //URL
        String title = getIntent().getStringExtra("videoTitle");
        customMediaController.setVideoName(title);
        uri = Uri.parse(video);
        videoView.setVideoURI(uri);
        videoView.setMediaController(customMediaController);
        videoView.setVideoQuality(io.vov.vitamio.MediaPlayer.VIDEOQUALITY_HIGH);
        mediaController.show(5000);         //5秒没有网络数据流关闭
        videoView.requestFocus();
        videoView.setOnInfoListener(this);
        videoView.setOnBufferingUpdateListener(this);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener(){
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setPlaybackSpeed(1.0f);      //播放倍率
            }
        });
    }

    @Override
    public boolean onInfo(MediaPlayer mp, int what, int extra) {
        switch (what) {
            case MediaPlayer.MEDIA_INFO_BUFFERING_START:
                if (videoView.isPlaying()) {
                    videoView.pause();
                    progressBar.setVisibility(View.VISIBLE);
                    downloadRateView.setText("");
                    loadRateView.setText("");
                    downloadRateView.setVisibility(View.VISIBLE);
                    loadRateView.setVisibility(View.VISIBLE);

                }
                break;
            case MediaPlayer.MEDIA_INFO_BUFFERING_END:
                videoView.start();
                progressBar.setVisibility(View.GONE);
                downloadRateView.setVisibility(View.GONE);
                loadRateView.setVisibility(View.GONE);
                break;
            case MediaPlayer.MEDIA_INFO_DOWNLOAD_RATE_CHANGED:
                downloadRateView.setText("" + extra + "kb/s" + "  ");
                break;
        }
        return true;
    }

    @Override
    public void onBufferingUpdate(MediaPlayer mp, int percent) {
        loadRateView.setText(percent + "%");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        //屏幕切换时，设置全屏
        if (videoView != null){
            videoView.setVideoLayout(VideoView.VIDEO_LAYOUT_SCALE, 0);
        }
        super.onConfigurationChanged(newConfig);
    }
}
