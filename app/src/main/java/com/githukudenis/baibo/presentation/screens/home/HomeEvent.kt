package com.githukudenis.baibo.presentation.screens.home

import com.githukudenis.baibo.domain.model.BibleData

sealed interface HomeEvent {
    class AddToSelectedBibles(val bibleData: BibleData): HomeEvent
    class RemoveFromSelectedBibles(val bibleData: BibleData): HomeEvent
    object DownloadSelectedBibles: HomeEvent
}
