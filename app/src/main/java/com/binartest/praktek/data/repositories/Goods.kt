package com.binartest.praktek.data.repositories

data class Goods(
    val jumlah: Int,
    val namabarang: String,
    val pemasok: String,
    val tanggal: String
) {

    constructor() : this(0, "", "", "")
}