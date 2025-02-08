package com.tonyxlh.barcodescanner

import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

class IOSBarcodeScanner: BarcodeScanner {
    override fun register(context: Any) {
        TODO("Not yet implemented")
    }
    override fun startScanning() {
        TODO("Not yet implemented")
    }
}

actual fun getBarcodeScanner(): BarcodeScanner = IOSBarcodeScanner()
actual fun getPlatform(): Platform = IOSPlatform()