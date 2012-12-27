package controllers.admin.utils

object Stemmer {
	
    def stem(word : String) : String = {
        new JStemmer(word).toString()
    }
    
    def main(args: Array[String]): Unit = {
        println(Stemmer.stem("table"))
    }
}