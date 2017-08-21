package view_component.lib_android.com.componentviewexample.custom_layout;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import view_component.lib_android.com.componentviewexample.R;
import view_component.lib_android.com.view_component.base_view.layouts.ComponentLinearLayout;

/**
 * Created by Robert Apikyan on 8/18/2017.
 */

public class ColoredLayout extends ComponentLinearLayout<ColoredLayoutViewComponent,ColoredLayoutControllerComponent>{
    public ColoredLayout(@NonNull Context context) {
        super(context);
    }

    public ColoredLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ColoredLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @NonNull
    @Override
    public ColoredLayoutViewComponent createViewComponent(@NonNull LayoutInflater inflater) {
        return new ColoredLayoutViewComponent(inflater.inflate(R.layout.colored_layout,this,true));
    }

    @NonNull
    @Override
    public ColoredLayoutControllerComponent createControllerComponent() {
        return new ColoredLayoutControllerComponent();
    }
}
