import kotlin.random.Random

fun main(args: Array<String>) {
    // CREAR VARIABLES

    // Booleans
    var variableBoolean1 = true
    var variableBoolean2 : Boolean = true
    var variableBoolean3 : Boolean? = true
    var variableBoolean4 : Boolean? = null

    // Int
    var variableInt1 = 1
    var variableInt2 : Int = 1
    var variableInt3 : Int? = 1
    var varaibleInt4 : Int? = null

    // Long
    var variableLong1 = 1L
    var variableLong2 : Long = 1
    var variableLong3 : Long? = 1
    var variableLong4 : Long? = null

    // Float
    var variableFloat1 = 1F
    var variableFloat2 : Float = 1F
    var variableFloat3 : Float? = 1F
    var variableFloat4 : Float? = null

    // Double
    var variableDouble1 = 1.0
    var variableDouble2 : Double = 1.0
    var variableDouble3 : Double? = 1.0
    var variableDouble4 : Double? = null

    // String
    var variableString1 = "texto 1"
    var variableString2 : String = "texto 1"
    var variableString3 : String? = "texto 1"
    var variableString4 : String? = null

    // Listas fijas
    val listaDeNombresFija = listOf("A", "B", "C", "D", "E")

    // Listas mutables
    val listaDeNombresMutable = mutableListOf("A", "B", "C", "D", "E")

    // Transformar lista fija en mutable (Creando una copia)
    var listaMutable = listaDeNombresFija.toMutableList()

    // OPERACIONES CON LISTA
    listaMutable.add("F")
    listaMutable.remove("F")
    listaMutable.add("F")
    listaMutable.removeAt(listaMutable.size-1)
    println(listaMutable.subList(0,3))

    // Escribir por pantalla
    print("Texto")
    // Escribir por pantalla con un salto de línea al final
    println("Texto")


    // CREAR CONSTANTES
    // Igual que lo anterior pero cambiando var por val.
    val constanteInt1 = 1
    val constanteDouble1 = 1.0
    var constanteString1 = "texto 1"


    // CONDICIONALES
    var myInt : Int? =  5
    if (myInt is Int) {
        println("myIntNullable es un Int")
    } else {
        println("myIntNullable no es un Int")
    }
    // Negativos
    if (myInt !is Int) {
        println("myIntNullable no es un Int")
    } else {
        println("myIntNullable es un Int")
    }

    when (myInt) {
        null -> {
            println("Es null")
        }
        0 -> {
            println("Es cero")
        }
        1 -> {
            println("Es 1")
        }
        else -> {
            println("Es otra cosa")
        }
    }

    // BUCLES
    //// REPEAT
    repeat(5){
        // ir es el contador de 0 hasta 5 (no incluido)
        println("Repeat $it")
    }
    //// WHILE
    var contadorWhile = 0
    while (contadorWhile < 10) {
        // Si la condición no se cumple, esto no se ejecuta.
        println("While $contadorWhile")
        contadorWhile++
    }
    //// DO WHILE
    var contadorDoWhile = 0
    do {
        // Nos garantiza que al menos se ejecutarça una vez
        println("While $contadorWhile")
        contadorDoWhile++
    }
    while (contadorDoWhile < 10)

    //// FOR
    for (i in 0..9) {
        // Incluye al 9
        println(i)
    }
    for (i in 0 until 9) {
        // No incluye al 9
        println(i)
    }
    for (nombre in listaDeNombresFija){
        println(nombre)
    }
    for (index in listaDeNombresFija.indices){
        println("En la posiciçon $index está ${listaMutable[index]}")
    }

    // FOREACH
    listaDeNombresFija.forEach {
        println(it)
    }
    listaDeNombresFija.forEachIndexed { index, texto ->
        println("En la posiciçon $index está $texto")
    }
    // FUNCIONES

    funcionSinParametros()
    funcionConParametros(1)
    funcionConParametrosPorDefecto(1)
    funcionConParametrosPorDefecto()

    // USAR UNA FUNCIÓN
    printHelloWorld()
    repeat(5){
        printHelloWorld()
    }
    printHelloWorld("Carlos")


    // CREAR Y USAR UN LAMBDA
    val lambda1 = { println("Hello World! Lambda") }
    lambda1()
    repeat(5){
        lambda1()
    }

    val lambda2 = { parametro : String -> println("Hello World! Lambda $parametro") }
    lambda2("Federico")


    val lista = listOf(1,2,3,4)
    lista.forEach { numero ->
        println(numero*2)
        lambda2(numero.toString())
    }


    val lambdaConReturn = {
        if(Random.nextBoolean()) {
            "Adios"
        } else {
            "Hola"
        }
    }
    println(lambdaConReturn())

    val lambdaConReturnYParametro = { parametroBooleano : Boolean ->
        if(parametroBooleano) {
            "Adios"
        } else {
            "Hola"
        }
    }
    println(lambdaConReturnYParametro(Random.nextBoolean()))

    // En esta declaración SÍ podríamos devolver algo que no sea int
    val declararMatrimonio = {nombre1 : String, nombre2 : String ->
        "$nombre1 y $nombre2 ya se han casado"
    }

    // En esta declaración NO podríamos devolver algo que no sea int
    val declararMatrimonioFormaLarga : (String, String) -> String = {nombre1 : String, nombre2 : String ->
        "$nombre1 y $nombre2 ya se han casado"
    }

    println(declararMatrimonio("Paco", "Lucía"))
    println(declararMatrimonioFormaLarga("Antonio", "Manuela"))


    //--------------- FIN LAMBDAS

    //--------------- FUNCIONES ÚTILES


    val miNumero : Int? = 10
    // LET es el más usado
    miNumero?.let{
        println(it)
    }

    var miString = "hola"
    var a = miString.run {
        val aux = plus(" que tal")
        aux.capitalize()
    }
    println(a)

    println(miString)
    miString = miString.apply {
        capitalize()
    }
    println(miString)

    //--------------- FIN FUNCIONES ÚTILES

    //--------------- USO DE CLASES EN KOTLIN
    val student1a = Student1()
    student1a.name = "Carlos"
    student1a.surname = "de Tena"
    student1a.age = 33
    // No deja cambiar el email ya que lo hemos puesto privado
    // student1a.email = "SDFASDF"
    student1a.updateEmail("carlos@gmail.com")
    val student1b = Student1().apply {
        name = "Carlos"
        surname = "de Tena"
        age = 33
        updateEmail("carlos@gmail.com")
    }

    val student2 = Student2("Carlos", "de Tena", 33, "carlos@outlook.com")
    // No deja cambiar el email ya que lo hemos puesto privado
    // student2.email = "asdfasdfas"

    //--------------- FIN USO DE CLASES EN KOTLIN

}

// ---------------- CREACIÓN DE CLASES EN KOTLIN
class Student1(){
    var name : String = ""
    var surname : String = ""
    var age : Int = 0
    private var email : String = ""

    fun fullName() : String {
        return "$name $surname"
    }

    fun updateEmail(email : String) {
        if (email.contains("@")) {
            println("El email ${this.email} se ha actualizado a $email")
            this.email = email
        } else {
            println("El email es incorrecto. No se ha actualizado")
        }
    }
}

class Student2(
    var name : String,
    var surname : String = "",
    var age : Int = 18,
    private var email : String = ""){

    fun fullName() : String {
        return "$name $surname"
    }

    fun updateEmail(email : String) {
        if (email.contains("@")) {
            println("El email ${this.email} se ha actualizado a $email")
            this.email = email
        } else {
            println("El email es incorrecto. No se ha actualizado")
        }
    }
}

// ---------------- FIN CREACIÓN DE CLASES EN KOTLIN


fun printHelloWorld(){
    println("Hello World! Fun")
}


fun printHelloWorld(nombre : String){
    println("Hello World! Fun $nombre")
}


fun funcionEjercicio1(text : String){
    if (text.isEmpty()){
        println("Debiste escribir algo")
    } else {
        println(text)
    }
}

fun funcionSinParametros() {
    println("Soy la función sin parámetros")
}

fun funcionConParametros(numero : Int) {
    println("Soy la función con parámetro y he recibido un $numero")
}

fun funcionConParametrosPorDefecto(numero : Int = 5) {
    println("Soy la función con parámetro por defecto y he recibido un $numero")
}