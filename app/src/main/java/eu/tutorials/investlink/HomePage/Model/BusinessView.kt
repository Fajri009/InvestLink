package eu.tutorials.investlink.HomePage.Model

class BusinessView(private val image: Int, private val days: String, private val judul: String, private val value : String, private val money : String) {
    fun getImage() : Int {
        return image
    }

    fun getDays() : String {
        return days
    }

    fun getJudul() : String {
        return judul
    }

    fun getValue() : String {
        return value
    }

    fun getMoney() : String {
        return money
    }
}