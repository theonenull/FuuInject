package com.example.inject.repository.course

import com.example.inject.bean.CourseBean
import kotlinx.coroutines.flow.Flow

interface CourseInterface {
    abstract fun getCourse(): Flow<List<CourseBean>?>
}