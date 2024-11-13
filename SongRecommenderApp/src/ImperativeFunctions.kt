import kotlin.math.pow
import kotlin.math.sqrt

fun calculateEuclideanDistance(song: Song, userPref: User): Float {
    val normalizedValence = normalize(song.valence, 0.0187f, 0.988f) - normalize(userPref.actualMood, 0.0187f, 0.988f)
    val normalizedEnergy = normalize(song.energy, 0.000243f, 1.0f) - normalize(userPref.actualEnergy, 0.000243f, 1.0f)
    val normalizedDanceability = normalize(song.danceability, 0.0651f, 0.988f) - normalize(userPref.prefDanceability, 0.0651f, 0.988f)
    val normalizedInstrumentalness = normalize(song.instrumentalness, 0.0f, 0.989f) - normalize(userPref.prefInstrumental, 0.0f, 0.989f)
    val normalizedLiveness = normalize(song.liveness, 0.0107f, 0.988f) - normalize(userPref.prefLive, 0.0107f, 0.988f)
    val normalizedDuration = normalize(song.durationMs, 25600f, 913052f) - normalize(userPref.prefDuration, 25600f, 913052f)
    val normalizedTempo = normalize(song.tempo, 57.967f, 220.29f) - normalize(userPref.prefTempo, 57.967f, 220.29f)

    return sqrt(
        normalizedValence.pow(2) +
                normalizedEnergy.pow(2) +
                normalizedDanceability.pow(2) +
                normalizedInstrumentalness.pow(2) +
                normalizedLiveness.pow(2) +
                normalizedDuration.pow(2) +
                normalizedTempo.pow(2)
    )
}

fun normalize(value: Float, min: Float, max: Float): Float {
    return (value - min) / (max - min)
}

fun getDynamicGenres(): List<String> {
    val songs = readSongsFromCSV("/Users/user/Downloads/genres_v2.csv")
    val list = mutableListOf<String>()
    for (song in songs) {
        var count = 0
        for (songI in list) {
            if (song.genre == songI) {
                count++
            }
        }
        if(count == 0){
            list.add(song.genre.toString())
        }
    }
    return list
}