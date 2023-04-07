package eu.tutorials.investlink.HomePage.Model

class GuideView(private val image : Int, private val judul : String) {
    fun getImage() : Int {
        return image
    }

    fun getJudul() : String {
        return judul
    }
}