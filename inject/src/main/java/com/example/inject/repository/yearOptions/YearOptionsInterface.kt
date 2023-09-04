package com.example.inject.repository.yearOptions

import com.example.inject.bean.YearOptionsBean
import kotlinx.coroutines.flow.Flow

interface YearOptionsInterface {
    abstract fun getYearOptions(): Flow<List<YearOptionsBean>?>
}