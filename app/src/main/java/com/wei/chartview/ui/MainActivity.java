package com.wei.chartview.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.wei.chartview.R;
import com.wei.chartview.anno.ContentView;
import com.wei.chartview.anno.InJect;
import com.wei.chartview.utils.DataUtil;
import com.wei.chartview.view.AssetsMovementsView;
import com.wei.chartview.view.CircleView;
import com.wei.chartview.view.ColumnView;
import com.wei.chartview.view.FloatingView;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_getdata;
    private ColumnView columnView;
    private FloatingView floatingview;
    private CircleView circleView;
    private AssetsMovementsView assetsMovementsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InJect.inject(this);
        initView();
    }

    private void initView() {

        columnView = (ColumnView) findViewById(R.id.columview);
        floatingview = (FloatingView) findViewById(R.id.floatingview);
        circleView = (CircleView) findViewById(R.id.circle_view);
        assetsMovementsView = (AssetsMovementsView) findViewById(R.id.assets_movementview);

        tv_getdata = (TextView) findViewById(R.id.tv_getdata);
        tv_getdata.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_getdata:
                initData();
                break;
        }
    }

    private void initData() {
        columnView.setData(DataUtil.getData());
        floatingview.setData(DataUtil.getData());
        assetsMovementsView.setData(DataUtil.getAssetData());
        circleView.setData(DataUtil.getCircleData());

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        tv_getdata.setOnClickListener(null);
    }
}
