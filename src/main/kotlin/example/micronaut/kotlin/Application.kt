package example.micronaut.kotlin

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("example.micronaut.kotlin")
                .mainClass(Application.javaClass)
                .start()
    }
}