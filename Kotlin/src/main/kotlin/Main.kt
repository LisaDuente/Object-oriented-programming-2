fun main(args: Array<String>) {
    println("Hello World!")

    //if you want to call a function you only need to write the functions name
    testFunction()
    declareVariablesAndValues(8)
    shortVarAndVals(2)

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}