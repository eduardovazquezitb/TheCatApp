package com.example.thecatapp.ui.model.mapper

import com.example.thecatapp.data.model.CatInfoDto
import com.example.thecatapp.ui.model.CatCardUiModel


fun CatInfoDto.toCatCardUiModel() : CatCardUiModel{
    return CatCardUiModel(
        id = this.id,
        url = this.url
    )
}