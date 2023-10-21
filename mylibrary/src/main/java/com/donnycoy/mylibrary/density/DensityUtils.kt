package com.donnycoy.mylibrary.density

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager

object DensityUtils {
    /**
     * convert Sp To Pixel
     *
     * @param context 上下文
     * @param spValue sp值
     * @return pixel的值
     */
    @JvmStatic
    fun convertSpToPixel(context: Context, spValue: Float): Int {
        val resources = context.resources
        val metrics = resources.displayMetrics
        return (spValue * metrics.scaledDensity + 0.5f).toInt()
    }

    /**
     * This method converts dp unit to equivalent device specific value in pixels.
     *
     * @param ctx The current context
     * @param dp A value in dp (Device independent pixels) unit
     * @return float A float value to represent Pixels equivalent to dp according to device
     */
    @JvmStatic
    fun convertDpToPixel(ctx: Context, dp: Float): Float {
        val resources = ctx.resources
        val metrics = resources.displayMetrics
        return dp * (metrics.densityDpi / 160f)
    }

    @JvmStatic
    fun px2dp(context: Context, scale: Float): Int {
        return (scale / context.resources.displayMetrics.density + 0.5f).toInt()
    }

    @JvmStatic
    fun getDensityDpi(context: Context): Int {
        val displayMetrics = DisplayMetrics()

        (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay.getMetrics(
            displayMetrics
        )
        return displayMetrics.densityDpi
    }

    @JvmStatic
    fun getScaledDensity(context: Context): Float {
        val displayMetrics = DisplayMetrics()
        (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay.getMetrics(
            displayMetrics
        )
        return displayMetrics.scaledDensity
    }
}