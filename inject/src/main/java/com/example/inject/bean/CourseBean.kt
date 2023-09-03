package com.example.inject.bean


/**
 * Create by NOSAE on 2020/9/27
 *
 * @param type see [com.w2fzu.fzuhelper.model.db.CourseType]
 */

data class CourseBean(
    var kcName: String = "",
    var kcLocation: String = "",
    var kcStartTime: Int = 0,
    var kcEndTime: Int = 0,
    var kcStartWeek: Int = 0,
    var kcEndWeek: Int = 0,
    var kcIsDouble: Boolean = true,
    var kcIsSingle: Boolean = true,
    var kcWeekend: Int = 0,
    var kcYear: Int = 0,
    var kcXuenian: Int = 0,
    var kcNote: String = "",
    var kcBackgroundId: Int = 0,
    var shoukeJihua: String = "",
    var jiaoxueDagang: String = "",
    var teacher: String = "",
    var priority: Long = 0,
    var type: Int = 0
)

