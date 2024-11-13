class Playlist(val name: String) {
    val songs: MutableList<Song> = mutableListOf()
    var countSongs = 0

    fun addSong(song: Song) {
        songs.add(song)
    }

    fun copyPlaylist(songsPrev: List<Song>) {
        this.songs.clear()
        //this.songs.addAll(songs)
        for (song in songsPrev) {
            this.songs.add(song)
        }
    }
}