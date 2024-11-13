import java.lang.management.ManagementFactory

fun getPid(): String?{
    return ManagementFactory.getRuntimeMXBean().name
}

fun main() {
    val w = Window("Song recommender v0.1 - Running in: ${getPid()}")
    w.isVisible = true
    w.setLocationRelativeTo(null)

    /*val usuario1 = User("Juan", "Juancito780")
    usuario1.addActualMood(0.9f)
    usuario1.addActualEnergy(0.8f)
    usuario1.addPrefDanceability(0.9f)
    usuario1.addPrefInstrumental(0.9f)
    usuario1.addPrefLive(0.9f)
    usuario1.addPrefDuration(30000.0f)
    usuario1.addPrefTempo(100.0f)

    val songs = readSongsFromCSV("/Users/user/Downloads/genres_v2.csv")
    val recom = songs[0]
    println(songs[0].songName)

    val new = listWithoutRecommendations(songs, recom)
    println(new[0].songName)
    */

    /*val usuario1 = User("Juan", "Juancito780")
    usuario1.addActualMood(0.9f)
    usuario1.addActualEnergy(0.8f)
    usuario1.addPrefDanceability(0.9f)
    usuario1.addPrefInstrumental(0.9f)
    usuario1.addPrefLive(0.9f)
    usuario1.addPrefDuration(30000.0f)
    usuario1.addPrefTempo(100.0f)

    usuario1.addGenres("Pop")
    usuario1.addGenres("Rap")

    println("")

    val songs = readSongsFromCSV("/Users/user/Downloads/genres_v2.csv")

    val recommendation = recommendedSongsAnyGenre(songs, usuario1, 10)
    val playlist1 = Playlist("Automatically created 1")
    playlist1.copyPlaylist(recommendation)
    usuario1.addPlaylist(playlist1)
    val play = usuario1.playlists[0]?.songs
    if (play != null) {
        for (song in play) {
            println("Nombre: ${song.songName}, Género: ${song.genre}")
        }
    }
    println("")
    val recommendation2 = recommendedSongsAnyGenre(songs, usuario1, 10)
    val playlist2 = Playlist("Automatically created 2")
    playlist2.copyPlaylist(recommendation2)
    usuario1.addPlaylist(playlist2)
    val play2 = usuario1.playlists[1]?.songs
    if (play2 != null) {
        for (song in play2) {
            println("Nombre: ${song.songName}, Género: ${song.genre}")
        }
    }
    println("")
    val recommendation3 = recommendedSongsAnyGenre(songs, usuario1, 10)
    val playlist3 = Playlist("Automatically created 3")
    playlist3.copyPlaylist(recommendation3)
    usuario1.addPlaylist(playlist3)
    val play3 = usuario1.playlists[2]?.songs
    if (play3 != null) {
        for (song in play3) {
            println("Nombre: ${song.songName}, Género: ${song.genre}")
        }
    }
    println("")
    val recommendation4 = recommendedSongsAnyGenre(songs, usuario1, 10)
    val playlist4 = Playlist("Automatically created 4")
    playlist4.copyPlaylist(recommendation4)
    usuario1.addPlaylist(playlist4)
    val play4 = usuario1.playlists[3]?.songs
    if (play4 != null) {
        for (song in play4) {
            println("Nombre: ${song.songName}, Género: ${song.genre}")
        }
    }*/
}