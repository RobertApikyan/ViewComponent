package view_component.lib_android.com.view_component.base_view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;

/**
 * Inside your custom view create this class instance (with {@link ComponentDelegateImpl#create(ComponentDelegate, Context)} method), and implement {@link ComponentDelegate} interface
 * Default implementation for {@link ComponentDelegate} interface, this class handles {@link ViewComponent} and {@link ControllerComponent} instantiation:
 *
 * @param <VC> ViewComponent type
 * @param <CC> ControllerComponent type
 */
public class ComponentDelegateImpl<VC extends ViewComponent, CC extends ControllerComponent<VC>> implements ComponentDelegate<VC, CC>, ControllerLifeCycle<VC> {

    /**
     * Use this method to crate ComponentDelegateImpl instance, call this method inside your view's constructor
     *
     * @param componentDelegate, Your view must implement {@link ComponentDelegate} interface
     * @param context            Activity context
     * @param <VC>               ViewComponent Type
     * @param <CC>               ControllerComponent Type
     * @return ComponentDelegateImpl
     */
    @NonNull
    public static <VC extends ViewComponent, CC extends ControllerComponent<VC>> ComponentDelegateImpl<VC, CC> create(@NonNull ComponentDelegate<VC, CC> componentDelegate, @NonNull Context context) {
        return new ComponentDelegateImpl<>(componentDelegate, context);
    }

    private VC viewComponent;
    private CC controllerComponent;
    private final ComponentDelegate<VC, CC> componentDelegate;

    private ComponentDelegateImpl(ComponentDelegate<VC, CC> componentDelegate, Context context) {
        this.componentDelegate = componentDelegate;
        viewComponent = createViewComponent(LayoutInflater.from(context));
        controllerComponent = createControllerComponent();
        // pass viewComponent instance in to controllerComponent
        onCreate(viewComponent);
    }

    /**
     * Use this method to get access to CustomViews ViewComponent
     *
     * @return returns CustomViews ViewComponent
     */
    @Override
    public VC getViewComponent() {
        return viewComponent;
    }

    /**
     * Use this method to get access to CustomViews ControllerComponent
     *
     * @return returns CustomViews ControllerComponent
     */
    @Override
    public CC getControllerComponent() {
        return controllerComponent;
    }

    @NonNull
    @Override
    public VC createViewComponent(@NonNull LayoutInflater inflater) {
        VC component = componentDelegate.createViewComponent(inflater);
        assertComponent(component, "createViewComponent method can't return null");
        return component;
    }

    @NonNull
    @Override
    public CC createControllerComponent() {
        CC component = componentDelegate.createControllerComponent();
        assertComponent(component, "createControllerComponent method can't return null");
        return component;
    }

    @Override
    public void onCreate(@NonNull VC viewComponent) {
        controllerComponent.onCreate(viewComponent);
    }

    /**
     * throws an {@link NullPointerException} if {@link #createViewComponent(LayoutInflater)} or {@link #createControllerComponent()} where return null
     */
    private void assertComponent(Object component, String msg) {
        if (component == null) {
            throw new NullPointerException(getCallerClassName() + msg);
        }
    }

    private String getCallerClassName() {
        StackTraceElement[] stackTrace = new Exception().getStackTrace();
        String packageName = getClass().getPackage().getName();
        for (StackTraceElement aStackTrace : stackTrace) {
            if (!aStackTrace.getClassName().contains(packageName)) {
                return aStackTrace.getClassName() + ":";
            }
        }
        return "";
    }
}
