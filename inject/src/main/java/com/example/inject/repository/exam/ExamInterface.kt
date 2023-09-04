package com.example.inject.repository.exam

import com.example.inject.bean.ExamBean
import kotlinx.coroutines.flow.Flow

interface ExamInterface {
    abstract fun getExams(): Flow<ExamBean>?
}