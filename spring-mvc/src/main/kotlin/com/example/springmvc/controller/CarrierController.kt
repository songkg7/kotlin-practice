package com.example.springmvc.controller

import com.example.springmvc.converter.AlphaConverter
import com.example.springmvc.model.Alpha
import com.example.springmvc.service.CarrierService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CarrierController(private val carrierService: CarrierService) {

    @PostMapping("/alpha")
    fun alpha(@RequestBody alpha: Alpha) = carrierService.bypass(AlphaConverter(alpha))

}
