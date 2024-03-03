package com.tuntasdigital.belajarandroiddasar

import org.junit.Assert
import org.junit.Test

class HelloTest {
    @Test
    fun sayHelloTest() {
        val result = Hello.sayHello("Asman")
        Assert.assertEquals("Hello Asman", result)
   }


}