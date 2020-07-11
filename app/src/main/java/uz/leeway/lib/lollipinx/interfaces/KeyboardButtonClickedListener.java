package uz.leeway.lib.lollipinx.interfaces;

import uz.leeway.lib.lollipinx.enums.KeyboardButtonEnum;

/**
 * Created by stoyan and leeway on 1/13/15.
 * The {@link uz.leeway.lib.lollipinx.managers.AppLockActivity} will implement
 * this in order to receive events from {@link uz.leeway.lib.lollipinx.views.KeyboardButtonView}
 * and {@link uz.leeway.lib.lollipinx.views.KeyboardView}
 */
public interface KeyboardButtonClickedListener {

    /**
     * Receive the click of a button, just after a {@link android.view.View.OnClickListener} has fired.
     * Called before {@link #onRippleAnimationEnd()}.
     * @param keyboardButtonEnum The organized enum of the clicked button
     */
    public void onKeyboardClick(KeyboardButtonEnum keyboardButtonEnum);

    /**
     * Receive the end of a {@link uz.leeway.lib.lollipinx.custom.ripple.RippleView} animation using a
     * {@link uz.leeway.lib.lollipinx.custom.ripple.RippleAnimationListener} to determine the end.
     * Called after {@link #onKeyboardClick(uz.leeway.lib.lollipinx.enums.KeyboardButtonEnum)}.
     */
    public void onRippleAnimationEnd();

}
