package org.ktorm.kapt.demo

import org.ktorm.kapt.KtormTable

@KtormTable
public data class DemoUserTable(
    val name: String? = null,
    val id: String? = null,
)