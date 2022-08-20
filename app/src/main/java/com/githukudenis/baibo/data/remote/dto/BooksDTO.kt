package com.githukudenis.baibo.data.remote.dto

import com.githukudenis.baibo.domain.model.Books

data class BooksDTO(
    val The_New_Testament: String,
    val The_Old_Testament: String,
)

fun BooksDTO.toBooks(): Books =
    Books(The_New_Testament = The_New_Testament, The_Old_Testament = The_Old_Testament)
