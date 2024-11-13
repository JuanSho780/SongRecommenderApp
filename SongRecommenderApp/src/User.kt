class User {
    var name: String
    private var password: String
    var favGenres = Array(5) { "" }
    private var countGenres = 0 //relate this with Genre
    var actualMood = 0.0f //relate this with Valence
    var actualEnergy = 0.0f //relate this with Energy
    var prefDanceability = 0.0f //relate this with Dance-ability
    var prefInstrumental = 0.0f //relate this with Instrumental-ness
    var prefLive = 0.0f //relate this with Live-ness
    var prefDuration = 0.0f //relate this with duration_ms
    var prefTempo = 0.0f //relate this with Tempo
    var playlists = arrayOfNulls<Playlist>(5)
    var countPlaylists = 0
    var totalSongs: MutableList<Song> = mutableListOf()

    constructor(nom: String, pass: String) {
        this.name = nom
        this.password = pass
        val newTotal = readSongsFromCSV("/Users/user/Downloads/genres_v2.csv")
        for (song in newTotal) {
            totalSongs.add(song)
        }
    }

    fun recommendPlaylistByActualAttributes(quantity: Int){
        val recommendation = recommendedSongsByFavGenres(totalSongs, this, quantity)
        for (songR in recommendation) {
            val newTotal = listWithoutRecommendations(totalSongs, songR)
            this.totalSongs.clear()
            for (song in newTotal) {
                this.totalSongs.add(song)
            }
        }

        val playlist = Playlist("Automatically created ${this.countPlaylists + 1}")
        playlist.copyPlaylist(recommendation)
        this.addPlaylist(playlist)
    }

    fun recommendPlaylistByActualAttributesWithoutGenre(quantity: Int){
        val recommendation = recommendedSongsAnyGenre(totalSongs, this, quantity)
        for (songR in recommendation) {
            val newTotal = listWithoutRecommendations(totalSongs, songR)
            this.totalSongs.clear()
            for (song in newTotal) {
                this.totalSongs.add(song)
            }
        }

        val playlist = Playlist("Automatically created ${this.countPlaylists + 1}")
        playlist.copyPlaylist(recommendation)
        this.addPlaylist(playlist)
    }

    fun addPlaylist(play: Playlist) {
        if (this.countPlaylists == 5){
            println("")
            println("Tienes todas tus Playlist llenas, incorpora un plan Premium para aumentarlas.")
        }
        else{
            playlists[countPlaylists] = play
            countPlaylists++
        }
    }

    fun isEmpty(): Boolean {
        if (countGenres == 0 && actualMood == 0.0f && actualEnergy == 0.0f && prefDanceability == 0.0f && prefInstrumental == 0.0f && prefLive == 0.0f && prefDuration == 0.0f && prefTempo == 0.0f) {
            return true
        } //At least one attribute is not empty (not used for UI)
        return false
    }

    fun addGenres(genre: String) {
        this.favGenres[countGenres] += genre
        this.countGenres++
    }

    fun addActualMood(actualMood: Float) {
        this.actualMood = actualMood
    }

    fun addActualEnergy(actualEnergy: Float) {
        this.actualEnergy = actualEnergy
    }

    fun addPrefDanceability(prefDanceability: Float) {
        this.prefDanceability = prefDanceability
    }

    fun addPrefInstrumental(prefInstrumental: Float) {
        this.prefInstrumental += prefInstrumental
    }

    fun addPrefLive(prefLive: Float) {
        this.prefLive = prefLive
    }

    fun addPrefDuration(prefDuration: Float) {
        this.prefDuration = prefDuration
    }

    fun addPrefTempo(prefTempo: Float) {
        this.prefTempo = prefTempo
    }

    fun getPassword(): String {
        return password
    }
}