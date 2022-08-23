package com.githukudenis.baibo.domain.model

data class Passage(
    val bible: String,
    val bibleTitle: String,
    val languages: List<String>,
    val passages: List<String>
)
