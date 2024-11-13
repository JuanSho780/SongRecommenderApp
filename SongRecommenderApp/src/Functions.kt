import java.io.File

fun readSongsFromCSV(filePath: String): List<Song> {
    return File(filePath)
        .useLines { lines ->
            lines.drop(1) // Ignore header
                .mapNotNull { line ->
                    val columns = line.split(",")
                    if (columns[19] != "") {
                        Song(
                            danceability = columns[0].toFloatOrNull() ?: 0.0f,
                            energy = columns[1].toFloatOrNull() ?: 0.0f,
                            key = columns[2].toIntOrNull() ?: 0,
                            loudness = columns[3].toFloatOrNull() ?: 0.0f,
                            mode = columns[4].toIntOrNull() ?: 0,
                            speechiness = columns[5].toFloatOrNull() ?: 0.0f,
                            acousticness = columns[6].toFloatOrNull() ?: 0.0f,
                            instrumentalness = columns[7].toFloatOrNull() ?: 0.0f,
                            liveness = columns[8].toFloatOrNull() ?: 0.0f,
                            valence = columns[9].toFloatOrNull() ?: 0.0f,
                            tempo = columns[10].toFloatOrNull() ?: 0.0f,
                            type = columns[11],
                            id = columns[12],
                            url = columns[13],
                            trackHref = columns[14],
                            analysisUrl = columns[15],
                            durationMs = columns[16].toFloatOrNull() ?: 0.0f,
                            timeSignature = columns[17].toIntOrNull() ?: 0,
                            genre = columns[18],
                            songName = columns[19]
                        )
                    } else {
                        null
                    }
                }
                .toList()
        }
}

fun recommendedSongsAnyGenre(songs: List<Song>, userPref: User, quantity: Int): List<Song> {
    return songs
        .sortedBy { calculateEuclideanDistance(it, userPref) }
        .take(quantity)
} //For any type of genre

fun recommendedSongsByFavGenres(songs: List<Song>, userPref: User, quantity: Int): List<Song> {
    return songs
        .filter { song -> song.genre in userPref.favGenres }
        .sortedBy { calculateEuclideanDistance(it, userPref) }
        .take(quantity)
} //For all the genres the user likes

fun listWithoutRecommendations(songs: List<Song>, deleteSong: Song): List<Song> {
    return songs.filter { song ->
        !(song.songName == deleteSong.songName && song.genre == deleteSong.genre)
    }
}