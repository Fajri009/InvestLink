package eu.tutorials.investlink.ListBusinessPage

class BusinessView(private val image : Int, private val days : String, private val judul : String) {
    fun getImage() : Int {
        return image
    }

    fun getDays() : String {
        return days
    }

    fun getJudul() : String {
        return judul
    }
}