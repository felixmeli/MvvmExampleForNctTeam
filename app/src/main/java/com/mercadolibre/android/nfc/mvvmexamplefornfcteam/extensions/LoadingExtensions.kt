package com.mercadolibre.android.nfc.mvvmexamplefornfcteam.extensions

import android.app.Activity
import android.view.WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE

fun Activity.blockScreen() {
    window.setFlags(FLAG_NOT_TOUCHABLE, FLAG_NOT_TOUCHABLE)
}

fun Activity.unBlockScreen() {
    window.clearFlags(FLAG_NOT_TOUCHABLE)
}