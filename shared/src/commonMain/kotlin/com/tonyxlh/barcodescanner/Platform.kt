package com.tonyxlh.barcodescanner

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform