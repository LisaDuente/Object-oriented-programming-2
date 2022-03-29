import java.util.Random

//functions don't need to have a return value and are alwas public if you don't declare something different
fun testFunction(){
    println("String here")
}

fun declareVariablesAndValues(yourNumber: Int){
    //variable, changes
    var number: Int = yourNumber
    //value, can't change
    val text: String = "The number you chose was: "

    //if you want to print the number first it wont work, you need to cast the number to a string
    println(text + number)

    var typeOfNumber: String

    if(Random().nextInt(13) == number){
        typeOfNumber = "lucky number"
    }else{
        typeOfNumber = "miss";
    }

    println(text + typeOfNumber)

}

fun shortVarAndVals(yourNumber: Int){
    var number = yourNumber
    val text = "Your number is: "
    //tell the function that it shout concat those two values
    println("$text $number")
    //you can deklare a variable with an if statement/ also works with else if mostly for short things
    val typeofNumber = if (Random().nextInt(109)==108) "lucky" else if (number == 106) "pups" else "miss"
    println("Your number was a $typeofNumber")
}

//if you want to iterate through something you use this kind of loop its called IntRange
fun iterate(number: Int){
    for(i in 0..10 step 2){
        println(i)
    }
}

//to itterate collections u use a for loop
fun forLoop(coll: Collection<String>){
    for(c in coll){
        println(c)
    }
}
