package com.example.inject.bean


/**
 * Create by NOSAE on 2020/9/28
 */
data class ExamBean(
    var examId: Long = 0,
    var name: String = "",
    var xuefen: String = "",
    var teacher: String = "",
    var address: String = "",
    var zuohao: String = ""
) {
    constructor(
        name: String,
        xuefen: String,
        teacher: String,
        address: String,
        zuohao: String
    ) : this(0, name, xuefen, teacher, address, zuohao)
}