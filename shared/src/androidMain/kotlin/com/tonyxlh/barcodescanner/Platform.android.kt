package com.tonyxlh.barcodescanner
import android.app.Activity
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import com.dynamsoft.core.basic_structures.DSRect
import com.dynamsoft.dbr.EnumBarcodeFormat
import com.dynamsoft.dbrbundle.ui.BarcodeScanResult
import com.dynamsoft.dbrbundle.ui.BarcodeScannerActivity
import com.dynamsoft.dbrbundle.ui.BarcodeScannerConfig

class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

class AndroidBarcodeScanner:BarcodeScanner {
    override fun register(context:Any,callback:(String)->Unit):Any {
        Log.d("DBR","register")
        var activity: ComponentActivity = context as ComponentActivity
        var launcher: ActivityResultLauncher<BarcodeScannerConfig> = activity.registerForActivityResult(BarcodeScannerActivity.ResultContract()) { result ->
            if (result.resultStatus == BarcodeScanResult.EnumResultStatus.RS_FINISHED && result.barcodes != null) {
                val content = """
            Result: format: ${result.barcodes[0].formatString}
            content: ${result.barcodes[0].text}
            """.trimIndent()
                Log.d("DBR",content)
                callback(content)
            } else if (result.resultStatus == BarcodeScanResult.EnumResultStatus.RS_CANCELED) {
                Log.d("DBR","canceled")
                callback("canceled")
            }
            if (result.errorString != null && result.errorString.isNotEmpty()) {
                Log.d("DBR",result.errorString)
                callback(result.errorString)
            }
        }
        return launcher as Any;
    }
    override fun startScanning(launcher:Any) {
        Log.d("DBR","startScanning")
        var activityLauncher = launcher as ActivityResultLauncher<BarcodeScannerConfig>
        val config = BarcodeScannerConfig().apply {
            license = "DLS2eyJvcmdhbml6YXRpb25JRCI6IjIwMDAwMSJ9";
        }
        activityLauncher.launch(config)
    }

}

actual fun getPlatform(): Platform = AndroidPlatform()
actual fun getBarcodeScanner(): BarcodeScanner = AndroidBarcodeScanner()