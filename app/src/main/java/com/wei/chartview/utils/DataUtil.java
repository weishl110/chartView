package com.wei.chartview.utils;

import com.wei.chartview.bean.CircleValueBean;
import com.wei.chartview.bean.ColumnBean;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by ${wei} on 2017/3/19.
 */

public class DataUtil {

    //创建假数据
    public static ArrayList<ColumnBean> getData() {
        ArrayList<ColumnBean> list = new ArrayList<ColumnBean>();
        int tempIndex = 0;
        for (int i = 0; i < 29; i++) {
            ColumnBean columnBean = new ColumnBean();
            float value = (float) (10000 - ((Math.random() * 20000)));
            value = getDecimal(value);
            columnBean.setValue(value);
            if (tempIndex + 1 < 10) {
                columnBean.setDate("2016020" + (tempIndex += 1));
            } else {
                columnBean.setDate("201602" + (tempIndex += 1));
            }
            list.add(columnBean);
        }
        return list;
    }


    public static ArrayList<ColumnBean> getAssetData() {
        ArrayList<ColumnBean> list = new ArrayList<ColumnBean>();
        int tempIndex = 0;
        for (int i = 0; i < 15; i++) {
            ColumnBean columnBean = new ColumnBean();
            float value = (float) (((Math.random() * 100000)));
            value = getDecimal(value);
            float hasValue = (float) (((Math.random() * 100000)));
            hasValue = getDecimal(hasValue);
            float totalValue = (float) (((Math.random() * 100000)));
            totalValue = getDecimal(totalValue);

            columnBean.setValue(value);
            columnBean.setHasValue(hasValue);
            columnBean.setTotalValue(totalValue);
            if (tempIndex + 1 < 10) {
                columnBean.setDate("201110" + (tempIndex += 1));
            } else {
                columnBean.setDate("201611" + (tempIndex += 1));
            }
            list.add(columnBean);
        }
        return list;
    }

    /**
     * 饼图的数据
     * @return
     */
    public static ArrayList<CircleValueBean> getCircleData() {
        ArrayList<CircleValueBean> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            float value = (float) (Math.random() * 100);
            CircleValueBean bean = new CircleValueBean();
            bean.setValue(value);
            switch (i) {
                case 0:
                    bean.setName("Android");
                    break;
                case 1:
                    bean.setName("iOS");
                    break;
                case 2:
                    bean.setName("PHP");
                    break;
                case 3:
                    bean.setName("Java");
                    break;
                case 4:
                    bean.setName("python");
                    break;
                case 5:
                    bean.setName("c++");
                    break;
            }
            list.add(bean);
        }
        return list;
    }

    private static float getDecimal(float value) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        return Float.parseFloat(decimalFormat.format(value));
    }
}
