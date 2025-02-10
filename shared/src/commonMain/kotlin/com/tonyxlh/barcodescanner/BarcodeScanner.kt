package com.tonyxlh.barcodescanner

interface BarcodeScanner {
    fun register(context: Any, callback: (String) -> Unit):Any
    fun startScanning(launcher: Any)
}

expect fun getBarcodeScanner(): BarcodeScanner