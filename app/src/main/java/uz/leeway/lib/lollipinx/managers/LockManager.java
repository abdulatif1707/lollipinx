package uz.leeway.lib.lollipinx.managers;

import android.content.Context;

import uz.leeway.lib.lollipinx.PinActivity;
import uz.leeway.lib.lollipinx.PinCompatActivity;
import uz.leeway.lib.lollipinx.PinFragmentActivity;

/**
 * Allows to handle the {@link uz.leeway.lib.lollipinx.managers.AppLock} from within
 * the actual app calling the library.
 * You must get this static instance by calling {@link #getInstance()}
 */
public class LockManager<T extends AppLockActivity> {

    /**
     * The static singleton instance
     */
    private static LockManager mInstance;
    /**
     * The static singleton instance of {@link uz.leeway.lib.lollipinx.managers.AppLock}
     */
    private static AppLock mAppLocker;

    /**
     * Used to retrieve the static instance
     */
    public static LockManager getInstance() {
        synchronized (LockManager.class) {
            if (mInstance == null) {
                mInstance = new LockManager<>();
            }
        }
        return mInstance;
    }

    /**
     * You must call that into your custom {@link android.app.Application} to enable the
     * {@link uz.leeway.lib.lollipinx.PinActivity}
     */
    public void enableAppLock(Context context, Class<T> activityClass) {
        if (mAppLocker != null) {
            mAppLocker.disable();
        }
        mAppLocker = AppLockImpl.getInstance(context, activityClass);
        mAppLocker.enable();
    }

    /**
     * Tells the app if the {@link uz.leeway.lib.lollipinx.managers.AppLock} is enabled or not
     */
    public boolean isAppLockEnabled() {
        return (mAppLocker != null && (PinActivity.hasListeners() ||
                PinFragmentActivity.hasListeners() || PinCompatActivity.hasListeners()));
    }

    /**
     * Disables the app lock by calling {@link AppLock#disable()}
     */
    public void disableAppLock() {
        if (mAppLocker != null) {
            mAppLocker.disable();
        }
        mAppLocker = null;
    }

    /**
     * Disables the previous app lock and set a new one
     */
    public void setAppLock(AppLock appLocker) {
        if (mAppLocker != null) {
            mAppLocker.disable();
        }
        mAppLocker = appLocker;
    }

    /**
     * Get the {@link AppLock}. Used for defining custom timeouts etc...
     */
    public AppLock getAppLock() {
        return mAppLocker;
    }
}
