package com.zli.adapter.json.model

import kotlinx.serialization.Transient

interface Result {

    @Transient
    val isSuccess: Boolean
}