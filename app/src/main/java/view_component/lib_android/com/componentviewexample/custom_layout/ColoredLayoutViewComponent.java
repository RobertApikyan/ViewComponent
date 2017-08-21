package view_component.lib_android.com.componentviewexample.custom_layout;

import android.support.annotation.NonNull;
import android.view.View;

import view_component.lib_android.com.componentviewexample.R;
import view_component.lib_android.com.view_component.base_view.ViewComponent;

/**
 * Created by Robert Apikyan on 8/18/2017.
 */

public class ColoredLayoutViewComponent extends ViewComponent {
    View colorView;

    public ColoredLayoutViewComponent(@NonNull View rootView) {
        super(rootView);
        colorView = rootView.findViewById(R.id.color_view);
    }
}
