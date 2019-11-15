package example.micronaut.kotlin

import org.hamcrest.Matcher
import org.hamcrest.Matchers

fun matchesUUID(): Matcher<String> =
        Matchers.matchesPattern("([a-f0-9]{8}(-[a-f0-9]{4}){4}[a-f0-9]{8})")