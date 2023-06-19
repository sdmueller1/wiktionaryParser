/**
 * Simple data tree structure to place the parsed data
 * @param name
 * Title of the given branch
 */
class Datatree(val name:String):
  //class Branch(val name:String, val depth:Int):
  //  val branches:Array[Branch] = Array()
  var children:Array[Datatree] = Array()
  //def addBranches(a:Array[Datatree]):Unit = children ++= a
  //def branches:Array[Datatree] = children

  var data:Array[Any] = Array()
  //def addData(a:Any):Unit = data :+= a
  //def getData:Array[Any] = data

  override def toString:String =
    toString(0)

  private def toString(tbs: Int): String =
    var ret = "-"*15+"\n"+name+"\n"+"-"*15+"\n"
    for datum <- data do
      ret = ret + datum.toString + "\n"
    for child <- children do
      ret += child.toString(tbs+1) + "\n"
    ret.replaceAll("(?m)^", "\t" * tbs)


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
 * Helper class for Word, represents a translation from one language to another.
 * @param context
 * A simpler version of definitions suitable for translations.
 * @param target
 * Which word does the definition point to?
 */
class Translation(val context:String, val target:Word)

