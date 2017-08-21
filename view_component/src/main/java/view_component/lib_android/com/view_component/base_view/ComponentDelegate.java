package view_component.lib_android.com.view_component.base_view;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;

/**
 * This interface is representation of component view pattern
 * Custom view must implement this interface and implements all it's methods with {@link ComponentDelegateImpl} class,
 * or you can create your custom implementation
 *
 * @param <VC> ViewComponent type
 * @param <CC> ControllerComponent type
 */
public interface ComponentDelegate<VC extends ViewComponent, CC extends ControllerComponent> {
    /**
     * Use this method to create ViewComponent instant, view will be inflated by LayoutInflater and passed in to your ViewComponent subclass's constructor.
     * With default implementation this method called inside {@link ComponentDelegateImpl} class's constructor
     *
     * @param inflater non null Layout inflater, inflater.inflate(R.layout.some_layout,this, true)
     *                 NOTE. for {@link android.view.ViewGroup} in inflater.inflate(...,...,true) method's third argument is true
     * @return non null ViewComponent
     */
    @NonNull
    VC createViewComponent(@NonNull LayoutInflater inflater);

    /**
     * Use this method to create ControllerComponent instant,
     * With default implementation this method called inside {@link ComponentDelegateImpl} class's constructor
     *
     * @return non null ControllerComponent
     */
    @NonNull
    CC createControllerComponent();

    /**
     * Use this method to get access to CustomViews ViewComponent
     *
     * @return returns CustomViews ViewComponent
     */
    VC getViewComponent();

    /**
     * Use this method to get access to CustomViews ControllerComponent
     *
     * @return returns CustomViews ControllerComponent
     */
    CC getControllerComponent();
}
