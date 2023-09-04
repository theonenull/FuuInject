package com.example.inject.repository.massage

import com.example.inject.bean.MassageBean
import kotlinx.coroutines.flow.Flow

interface MassageInterface {
    abstract fun getMassage() : Flow<List<MassageBean>>?
}