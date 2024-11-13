data class Song(
    var danceability: Float = 0.0f,
    var energy: Float = 0.0f,
    var key: Int = 0,
    var loudness: Float = 0.0f,
    var mode: Int = 0,
    var speechiness: Float = 0.0f,
    var acousticness: Float = 0.0f,
    var instrumentalness: Float = 0.0f,
    var liveness: Float = 0.0f,
    var valence: Float = 0.0f,
    var tempo: Float = 0.0f,
    var type: String = "",
    var id: String = "",
    var url: String = "",
    var trackHref: String = "",
    var analysisUrl: String = "",
    var durationMs: Float = 0.0f,
    var timeSignature: Int = 0,
    var genre: String = "",
    var songName: String = ""
) {
    fun isEmpty(): Boolean {
        if(songName.isEmpty()){
            return true
        }
        else{
            return false
        }
    }

}