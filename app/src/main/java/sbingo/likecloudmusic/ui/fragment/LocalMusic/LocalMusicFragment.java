package sbingo.likecloudmusic.ui.fragment.LocalMusic;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sbingo.likecloudmusic.R;
import sbingo.likecloudmusic.ui.fragment.BaseFragment;
import sbingo.likecloudmusic.utils.RemindUtils;
import sbingo.likecloudmusic.widget.LocalMenuItem;

/**
 * Author: Sbingo
 * Date:   2016/12/14
 */

public class LocalMusicFragment extends BaseFragment {

    @BindView(R.id.local)
    LocalMenuItem local;
    @BindView(R.id.recent)
    LocalMenuItem recent;
    @BindView(R.id.download)
    LocalMenuItem download;
    @BindView(R.id.my_singers)
    LocalMenuItem mySingers;
    @BindView(R.id.mv)
    LocalMenuItem mv;
    @BindView(R.id.arrow)
    ImageView arrow;
    @BindView(R.id.list_count)
    TextView listCount;
    @BindView(R.id.list_more)
    ImageView listMore;
    @BindView(R.id.play_list)
    RelativeLayout playList;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;

    private float fromDegrees = 0;
    private float toDegrees = 90;
    private float tempDegrees;


    private static LocalMusicFragment localMusicFragment;

    public static LocalMusicFragment getInstance() {
        if (null == localMusicFragment) {
            synchronized (LocalMusicFragment.class) {
                if (null == localMusicFragment) {
                    localMusicFragment = new LocalMusicFragment();
                }
            }
        }
        return localMusicFragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.local_music_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initViews() {
        local.setCount(5);
        recent.setCount(1);
        download.setCount(50);
        mySingers.setCount(10);
        mv.setCount(5);
        local.showSpeaker();
        listCount.setText(getResources().getString(R.string.list_count, 9));
        initSwipeRefresh();
    }

    void initSwipeRefresh() {
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefresh.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefresh.setRefreshing(false);
                    }
                }, 2000);
            }
        });
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
    }

    @OnClick({R.id.local, R.id.recent, R.id.download, R.id.my_singers, R.id.mv, R.id.list_more, R.id.play_list})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.local:
                break;
            case R.id.recent:
                break;
            case R.id.download:
                break;
            case R.id.my_singers:
                break;
            case R.id.mv:
                break;
            case R.id.list_more:
                break;
            case R.id.play_list:
                arrowRotateAnimation();
                break;
        }
    }

    private void arrowRotateAnimation() {
        Animation rotate = new RotateAnimation(fromDegrees, toDegrees, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        arrow.startAnimation(rotate);
        tempDegrees = fromDegrees;
        fromDegrees = toDegrees;
        toDegrees = tempDegrees;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

}
