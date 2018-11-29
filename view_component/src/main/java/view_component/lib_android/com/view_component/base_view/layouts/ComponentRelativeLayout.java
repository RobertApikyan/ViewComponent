package view_component.lib_android.com.view_component.base_view.layouts;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import view_component.lib_android.com.view_component.base_view.ComponentDelegate;
import view_component.lib_android.com.view_component.base_view.ComponentDelegateImpl;
import view_component.lib_android.com.view_component.base_view.ControllerComponent;
import view_component.lib_android.com.view_component.base_view.ViewComponent;

import static view_component.lib_android.com.view_component.base_view.ComponentDelegateImpl.create;

public abstract class ComponentRelativeLayout<VC extends ViewComponent, CC extends ControllerComponent<VC>> extends RelativeLayout implements ComponentDelegate<VC, CC> {
    private final ComponentDelegateImpl<VC, CC> componentDelegate;

    public ComponentRelativeLayout(@NonNull Context context) {
        super(context);
        componentDelegate = create(this, context);
    }

    public ComponentRelativeLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        componentDelegate = create(this, context);
    }

    public ComponentRelativeLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        componentDelegate = create(this, context);
    }

    @Override
    public VC getViewComponent() {
        return componentDelegate.getViewComponent();
    }

    @Override
    public CC getControllerComponent() {
        return componentDelegate.getControllerComponent();
    }

}
