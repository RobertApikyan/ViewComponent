package view_component.lib_android.com.view_component.base_view.functional_interfaces;

import android.support.annotation.NonNull;

import view_component.lib_android.com.view_component.base_view.ViewComponent;

/**
 * Created by Robert Apikyan on 8/18/2017.
 */

public interface Request<VC extends ViewComponent> {
    void onResult(@NonNull VC viewComponent);
}
