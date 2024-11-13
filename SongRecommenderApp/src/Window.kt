import java.awt.BorderLayout
import java.awt.Color
import java.awt.Dimension
import java.awt.Font
import java.awt.event.KeyEvent
import javax.swing.*
import javax.swing.table.DefaultTableModel

class Window(title: String?):JFrame(title){
    var panel1: JPanel? = null
    var panel2: JPanel? = null
    var panel3: JPanel? = null
    var buttonSwing: JButton? = null
    var buttonSwing2: JButton? = null
    var buttonSwing3: JButton? = null
    var buttonSwing4: JButton? = null
    var campText1: JTextField? = null
    var campText2: JTextField? = null
    var User1: User? = null
    var e10: JLabel? = null
    var sliderMood: JSlider? = null
    var sliderEnergy: JSlider? = null
    var sliderDancebility: JSlider? = null
    var sliderInstrumental: JSlider? = null
    var sliderLive: JSlider? = null
    var sliderDuration: JSlider? = null
    var sliderTempo: JSlider? = null
    var valueComboBox: String = ""
    var valueComboBoxPlaylist: String = ""
    var comboBox2: JComboBox<String> = JComboBox(arrayOf(""))

    //Values required for table
    private val columnNames = arrayOf("Nombre", "Género", "Duration", "URL")
    private val data = arrayOf<Array<Any>>()

    var tableModel = DefaultTableModel(data, columnNames)

    init {
        var d = Dimension(800,600)
        this.size = d
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        addPanel()
        addLabel()
        addButton()
        addText()
        addSlider()
        addComboBox()
        addTable()
    }

    fun addTable(){
        val table = JTable(tableModel)
        val scrollPane = JScrollPane(table)
        panel3!!.add(scrollPane)
        scrollPane.setBounds(20,50,740,200)
    }

    fun addComboBox(){
        val genreList = getDynamicGenres()
        var genreArray = arrayOf<String>()
        for (genre in genreList){
            genreArray += genre
        }
        var comboBox1 = JComboBox(genreArray)
        panel2!!.add(comboBox1)
        comboBox1.setBounds(350,150,120,30)
        this.valueComboBox = comboBox1.selectedItem.toString()
        comboBox1.addActionListener {
            this.valueComboBox = comboBox1.selectedItem as String
            println("Valor seleccionado (ComboBox): ${valueComboBox}")
        }

        panel3!!.add(comboBox2)
        comboBox2.setBounds(10,10,180,30)
        comboBox2.addActionListener {
            this.valueComboBoxPlaylist = comboBox2.selectedItem as String

            this.tableModel.setRowCount(0);
            for (playlist in User1!!.playlists){
                if (playlist != null){
                    if (this.valueComboBoxPlaylist == playlist.name){
                        for (song in playlist.songs){
                            val newRow = arrayOf<Any>(song.songName, song.genre, song.durationMs.toString(), song.url)
                            this.tableModel.addRow(newRow)
                        }
                        break
                    }
                }
            }
        }
    }

    fun addSlider(){
        sliderMood = JSlider(0, 100, 50) //All data div 100 for final value
        sliderMood!!.setMajorTickSpacing(25)
        sliderMood!!.setMinorTickSpacing(5)
        sliderMood!!.setPaintTicks(true)
        sliderMood!!.setPaintLabels(true)
        panel2!!.add(sliderMood)
        sliderMood!!.setBounds(150,0,120,60)
        sliderMood!!.background = Color(20,116,29)

        sliderEnergy = JSlider(0, 100, 50) //All data div 100 for final value
        sliderEnergy!!.setMajorTickSpacing(25)
        sliderEnergy!!.setMinorTickSpacing(5)
        sliderEnergy!!.setPaintTicks(true)
        sliderEnergy!!.setPaintLabels(true)
        panel2!!.add(sliderEnergy)
        sliderEnergy!!.setBounds(150,50,120,60)
        sliderEnergy!!.background = Color(20,116,29)

        sliderDancebility = JSlider(0, 100, 50) //All data div 100 for final value
        sliderDancebility!!.setMajorTickSpacing(25)
        sliderDancebility!!.setMinorTickSpacing(5)
        sliderDancebility!!.setPaintTicks(true)
        sliderDancebility!!.setPaintLabels(true)
        panel2!!.add(sliderDancebility)
        sliderDancebility!!.setBounds(150,100,120,60)
        sliderDancebility!!.background = Color(20,116,29)

        sliderInstrumental = JSlider(0, 100, 50) //All data div 100 for final value
        sliderInstrumental!!.setMajorTickSpacing(25)
        sliderInstrumental!!.setMinorTickSpacing(5)
        sliderInstrumental!!.setPaintTicks(true)
        sliderInstrumental!!.setPaintLabels(true)
        panel2!!.add(sliderInstrumental)
        sliderInstrumental!!.setBounds(150,150,120,60)
        sliderInstrumental!!.background = Color(20,116,29)

        sliderLive = JSlider(0, 100, 50) //All data div 100 for final value
        sliderLive!!.setMajorTickSpacing(25)
        sliderLive!!.setMinorTickSpacing(5)
        sliderLive!!.setPaintTicks(true)
        sliderLive!!.setPaintLabels(true)
        panel2!!.add(sliderLive)
        sliderLive!!.setBounds(150,200,120,60)
        sliderLive!!.background = Color(20,116,29)

        sliderDuration = JSlider(0, 100, 50) //All data multi 10000 for final value
        sliderDuration!!.setMajorTickSpacing(25)
        sliderDuration!!.setMinorTickSpacing(5)
        sliderDuration!!.setPaintTicks(true)
        sliderDuration!!.setPaintLabels(true)
        panel2!!.add(sliderDuration)
        sliderDuration!!.setBounds(540,0,120,60)
        sliderDuration!!.background = Color(20,116,29)

        sliderTempo = JSlider(60, 220, 140) //All data in real value
        sliderTempo!!.setMajorTickSpacing(50)
        sliderTempo!!.setMinorTickSpacing(10)
        sliderTempo!!.setPaintTicks(true)
        sliderTempo!!.setPaintLabels(true)
        panel2!!.add(sliderTempo)
        sliderTempo!!.setBounds(540,50,120,60)
        sliderTempo!!.background = Color(20,116,29)
    }

    fun addText(){
        campText1 = JTextField()
        panel1!!.add(campText1)
        campText1!!.setBounds(150,60,120,30)
        campText1!!.columns = 25

        campText2 = JTextField()
        panel1!!.add(campText2)
        campText2!!.setBounds(150,110,120,30)
        campText2!!.columns = 25
    }

    fun addButton(){
        buttonSwing = JButton("Ingresar")
        panel1!!.add(buttonSwing)
        buttonSwing!!.setBounds(500,100,120,30)
        buttonSwing!!.font = Font(Font.MONOSPACED, Font.ITALIC, 12)
        buttonSwing!!.foreground = Color.BLACK
        buttonSwing!!.background = Color.WHITE
        buttonSwing!!.addActionListener {
            val nameContent = campText1!!.text
            val passContent = campText2!!.text
            User1 = User(nameContent, passContent)
            panel1!!.isVisible = false
            panel2!!.isVisible = true
            panel3!!.isVisible = true
            println("Nombre: ${User1!!.name}, Contraseña: ${User1!!.getPassword()}")
            e10!!.text = "Hola, ${User1!!.name}!!"
        }

        buttonSwing2 = JButton("Procesar información")
        panel2!!.add(buttonSwing2)
        buttonSwing2!!.setBounds(520,180,240,30)
        buttonSwing2!!.font = Font(Font.MONOSPACED, Font.ITALIC, 12)
        buttonSwing2!!.foreground = Color.BLACK
        buttonSwing2!!.background = Color.WHITE
        buttonSwing2!!.addActionListener {
            //Add data to User (object) attributes and initialize recommendation process
            println("")
            User1!!.addActualMood(sliderMood!!.value/100f)
            println("Actual Mood: ${User1!!.actualMood}")
            User1!!.addActualEnergy(sliderEnergy!!.value/100f)
            println("Actual Energy: ${User1!!.actualEnergy}")
            User1!!.addPrefDanceability(sliderDancebility!!.value/100f)
            println("Danceability: ${User1!!.prefDanceability}")
            User1!!.addPrefInstrumental(sliderInstrumental!!.value/100f)
            println("Instrumental: ${User1!!.prefInstrumental}")
            User1!!.addPrefLive(sliderLive!!.value/100f)
            println("Liveness: ${User1!!.prefLive}")
            User1!!.addPrefDuration(sliderDuration!!.value*10000f)
            println("Duration (ms): ${User1!!.prefDuration}")
            User1!!.addPrefTempo(sliderTempo!!.value.toFloat())
            println("Tempo: ${User1!!.prefTempo}")
            println("Genre:")
            for (genre in User1!!.favGenres){
                if(genre != ""){
                    println(" - ${genre}")
                }
            }
            println("")

            User1!!.recommendPlaylistByActualAttributesWithoutGenre(10)
            var playListCounter = User1!!.countPlaylists
            println("")
            println(User1!!.playlists[playListCounter-1]!!.name)
            for (song in User1!!.playlists[playListCounter-1]!!.songs){
                println(" - ${song.songName}, Valence: ${song.valence}, Energy: ${song.energy}")
            }

            comboBox2.addItem(User1!!.playlists[playListCounter-1]!!.name)
        }

        buttonSwing3 = JButton("Agregar")
        panel2!!.add(buttonSwing3)
        buttonSwing3!!.setBounds(350,200,100,30)
        buttonSwing3!!.font = Font(Font.MONOSPACED, Font.ITALIC, 12)
        buttonSwing3!!.foreground = Color.BLACK
        buttonSwing3!!.background = Color.WHITE
        buttonSwing3!!.addActionListener {
            User1!!.addGenres(this.valueComboBox)
        }

        buttonSwing4 = JButton("Procesar información (género)")
        panel2!!.add(buttonSwing4)
        buttonSwing4!!.setBounds(520,240,240,30)
        buttonSwing4!!.font = Font(Font.MONOSPACED, Font.ITALIC, 12)
        buttonSwing4!!.foreground = Color.BLACK
        buttonSwing4!!.background = Color.WHITE
        buttonSwing4!!.addActionListener {
            //Add data to User (object) attributes and initialize process recommendation
            println("")
            User1!!.addActualMood(sliderMood!!.value/100f)
            println("Actual Mood: ${User1!!.actualMood}")
            User1!!.addActualEnergy(sliderEnergy!!.value/100f)
            println("Actual Energy: ${User1!!.actualEnergy}")
            User1!!.addPrefDanceability(sliderDancebility!!.value/100f)
            println("Danceability: ${User1!!.prefDanceability}")
            User1!!.addPrefInstrumental(sliderInstrumental!!.value/100f)
            println("Instrumental: ${User1!!.prefInstrumental}")
            User1!!.addPrefLive(sliderLive!!.value/100f)
            println("Liveness: ${User1!!.prefLive}")
            User1!!.addPrefDuration(sliderDuration!!.value*10000f)
            println("Duration (ms): ${User1!!.prefDuration}")
            User1!!.addPrefTempo(sliderTempo!!.value.toFloat())
            println("Tempo: ${User1!!.prefTempo}")
            println("Genre:")
            for (genre in User1!!.favGenres){
                if(genre != ""){
                    println(" - ${genre}")
                }
            }
            println("")

            User1!!.recommendPlaylistByActualAttributes(10)
            var playListCounter = User1!!.countPlaylists
            println("")
            println(User1!!.playlists[playListCounter-1]!!.name)
            for (song in User1!!.playlists[playListCounter-1]!!.songs){
                println(" - ${song.songName}, Valence: ${song.valence}, Energy: ${song.energy}, Genre: ${song.genre}")
            }

            comboBox2.addItem(User1!!.playlists[playListCounter-1]!!.name)
        }
    }

    fun addPanel(){
        var container = JPanel()
        container.background = Color.black
        this.contentPane.add(container)
        panel1 = JPanel()
        panel2 = JPanel()
        panel3 = JPanel()
        container.add(panel1)
        container.add(panel2)
        container.add(panel3)
        panel1!!.background = Color(38,166,166)
        panel2!!.background = Color(20,116,29)
        panel3!!.background = Color(166,193,41)
        container.layout = BoxLayout(container, BoxLayout.Y_AXIS)
        panel2!!.isVisible = false
        panel3!!.isVisible = false
    }
    fun addLabel(){
        var e1 = JLabel("<html>Ingrese su nombre:</html>")
        var e2 = JLabel("<html>Ingrese su contraseña:</html>")
        panel1!!.add(e1)
        panel1!!.add(e2)
        panel1!!.setLayout(null)
        panel2!!.setLayout(null)
        panel3!!.setLayout(null)
        e1.setBounds(10,40,120,60)
        e2.setBounds(10,90,120,60)

        var e3 = JLabel("<html>¿Qué tan feliz te sientes?</html>")
        panel2!!.add(e3)
        e3.setBounds(10,0,120,60)
        var e4 = JLabel("<html>¿Deseas entrenar o relajarte?</html>")
        panel2!!.add(e4)
        e4.setBounds(10,50,120,60)
        var e5 = JLabel("<html>¿Qué tanto quieres bailar?</html>")
        panel2!!.add(e5)
        e5.setBounds(10,100,120,60)
        var e6 = JLabel("<html>¿Instrumental o voces predominantes?</html>")
        panel2!!.add(e6)
        e6.setBounds(10,150,120,60)
        var e7 = JLabel("<html>¿Canción en vivo o en estudio?</html>")
        panel2!!.add(e7)
        e7.setBounds(10,200,120,60)
        var e8 = JLabel("<html>¿Qué tan largo quieres la canción?</html>")
        panel2!!.add(e8)
        e8.setBounds(400,0,120,60)
        var e9 = JLabel("<html>¿Tempo (ritmo) preferido?</html>")
        panel2!!.add(e9)
        e9.setBounds(400,50,120,60)
        e10 = JLabel("<html>Hola!!</html>")
        panel2!!.add(e10)
        e10!!.setBounds(550,80,240,120)
        e10!!.font = Font(Font.MONOSPACED, Font.ITALIC, 24)
    }
}