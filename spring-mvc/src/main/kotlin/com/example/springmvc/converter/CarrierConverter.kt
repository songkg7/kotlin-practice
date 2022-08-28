package com.example.springmvc.converter

import com.example.springmvc.model.Alpha
import com.example.springmvc.model.UnitedModel

sealed interface CarrierConverter {

    fun convert(): UnitedModel

}

class AlphaConverter(private val alpha: Alpha) : CarrierConverter {
    override fun convert() = UnitedModel(alpha.first)
}
