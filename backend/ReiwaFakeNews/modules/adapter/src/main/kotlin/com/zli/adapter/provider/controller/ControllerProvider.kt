package com.zli.adapter.provider.controller

import com.zli.adapter.controller.getnews.GetNewsController
import com.zli.adapter.controller.impl.GetNewsControllerImpl
import com.zli.adapter.controller.impl.SaveNewsControllerImpl
import com.zli.adapter.controller.savenews.SaveNewsController
import com.zli.usecase.getnews.GetNewsUseCase
import com.zli.usecase.savenews.SaveNewsUseCase

class ControllerProvider(
    private val getNewsUseCase: GetNewsUseCase,
    private val saveNewsUseCase: SaveNewsUseCase
) {
    fun provideGetNewsController(): GetNewsController = GetNewsControllerImpl(getNewsUseCase)
    fun provideSaveNewsController(): SaveNewsController = SaveNewsControllerImpl(saveNewsUseCase)
}