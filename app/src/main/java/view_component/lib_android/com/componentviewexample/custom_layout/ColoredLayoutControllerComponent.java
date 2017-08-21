package view_component.lib_android.com.componentviewexample.custom_layout;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.view.animation.LinearInterpolator;

import view_component.lib_android.com.view_component.base_view.ControllerComponent;
import view_component.lib_android.com.view_component.base_view.functional_interfaces.Request;

/**
 * Created by Robert Apikyan on 8/18/2017.
 */

public class ColoredLayoutControllerComponent extends ControllerComponent<ColoredLayoutViewComponent> {
    private Handler handler;
    private int startColor = Color.argb(getColorInt(), getColorInt(), getColorInt(), getColorInt());
    private int endColor;

    @Override
    public void onCreate(@NonNull ColoredLayoutViewComponent viewComponent) {
        super.onCreate(viewComponent);
        handler = new Handler();
        viewComponent.colorView.setBackgroundColor(startColor);
        post();
    }

    private void post() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                endColor = Color.argb(getColorInt(), getColorInt(), getColorInt(), getColorInt());
                requestHolderComponent(new Request<ColoredLayoutViewComponent>() {
                    @Override
                    public void onResult(@NonNull final ColoredLayoutViewComponent viewHolderComponent) {
                        final ValueAnimator valueAnimator = ValueAnimator.ofObject(new ArgbEvaluator(), startColor, endColor);
                        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            @Override
                            public void onAnimationUpdate(ValueAnimator animation) {
                                viewHolderComponent.colorView.setBackgroundColor((Integer) valueAnimator.getAnimatedValue());
                            }
                        });
                        valueAnimator.setInterpolator(new LinearInterpolator());
                        valueAnimator.setDuration(1000);
                        valueAnimator.start();
                        post();
                    }
                });
                startColor = endColor;
            }
        }, 1000);
    }

    private int getColorInt() {
        return (int) (Math.random() * 255);
    }
}
