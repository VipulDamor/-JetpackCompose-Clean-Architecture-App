package com.one993.notescleanarchitecture.ui.navigation

sealed class NavigationScreens(val route : String){
    object Home : NavigationScreens("home")
    object Note : NavigationScreens("note")
    object NoteDetail: NavigationScreens("note/{noteId}/NoteDetail")

}
