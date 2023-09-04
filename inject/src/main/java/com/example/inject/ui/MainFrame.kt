package com.example.inject.ui

import androidx.compose.runtime.Composable
import com.example.inject.repository.Repository

interface MainFrame {
    @Composable fun MainCompose(param:Repository)
}