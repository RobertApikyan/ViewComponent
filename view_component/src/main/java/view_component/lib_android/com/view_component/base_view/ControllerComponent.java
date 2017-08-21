package view_component.lib_android.com.view_component.base_view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import view_component.lib_android.com.view_component.base_view.functional_interfaces.Request;

/**
 * Base ControllerComponent class, extend this class and implement your view logic inside {@link ControllerComponent#onCreate(ViewComponent)} method
 *
 * @param <VC> ViewComponent type
 */
public abstract class ControllerComponent<VC extends ViewComponent> implements ControllerLifeCycle<VC> {
    private VC viewComponent;

    /**
     * We call this inside {@link ComponentDelegateImpl} class's constructor method, after Components instantiation
     *
     * @param viewComponent non null viewComponent
     */
    @Override
    public void onCreate(@NonNull VC viewComponent) {
        this.viewComponent = viewComponent;
    }

    /**
     * We call this inside {@link View#onDetachedFromWindow()} method
     */
    @Override
    public void onDestroy() {
        this.viewComponent = null;
    }

    /**
     * Use this method in order to get non null ViewComponent
     *
     * @param request {@link Request} simple interface, where method argument is non null {@link ViewComponent} instance
     */
    protected void requestHolderComponent(Request<VC> request) {
        if (request != null && viewComponent != null && viewComponent.rootView != null) {
            request.onResult(viewComponent);
        }
    }

    /**
     * Returns nullable {@link ViewComponent}, use {@link ControllerComponent#requestHolderComponent(Request)} to get non null ViewComponent
     *
     * @return ViewComponent
     */
    @Nullable
    protected VC getViewComponent() {
        return viewComponent;
    }

    @Nullable
    protected Context getContext() {
        if (viewComponent != null) {
            return viewComponent.getContext();
        }
        return null;
    }
}
