
/**
 * Simple class representing a word in a multilingual dictionary
 * @param s
 * The characters that comprise the word
 * @param lg
 * The language the word belongs to, eg. "en", "es", "fr" etc
 * Defaults to "en"
 */
class Word(val s:String, val lg:String = "en"):
  var definitions:Array[Definition] = Array()
  var translations:Array[Translation] = Array()

/**
 * Helper class for Word, represents a word definition
 * @param text
 * Contents of the definition
 * @param part
 * Part of speech in which this word appears
 * @param ex
 * Possible example sentence for this definition
 */
class Definition(val text:String,val part:String,val ex:Option[String]=None)

/**
 * A simpler version of definitions suitable for translations.
 * @param text
 * Contents of the definition
 */
class Context(text:String)

/**
 * Helper class for Word, represents a translation from one language to another.
 * @param origDef
 * What does this word mean in this context?
 * @param target
 * Which word does the definition point to?
 */
class Translation(val origDef:Context, val target:Word)

