package com.tonyxlh.barcodescanner

class DynamsoftBarcodeScanner {
    private val scanner: BarcodeScanner = getBarcodeScanner()
    fun register(context: Any, callback: (String) -> Unit):Any {
        return scanner.register(context,callback)
    }
    fun startScanning(launcher: Any) {
        scanner.startScanning(launcher)
    }
}