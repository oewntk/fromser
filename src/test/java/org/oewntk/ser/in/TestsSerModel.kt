/*
 * Copyright (c) 2021-2024. Bernard Bou.
 */
package org.oewntk.ser.`in`

import org.junit.BeforeClass
import org.junit.Test
import org.oewntk.model.ModelInfo
import org.oewntk.ser.`in`.LibTestsSerCommon.model
import org.oewntk.ser.`in`.LibTestsSerCommon.ps
import java.io.File
import kotlin.test.assertEquals

class TestsSerModel {

    @Test
    fun testOrig() {
        assertEquals(origInfo, modelInfo)
    }

    companion object {

        lateinit var origInfo: String

        lateinit var modelInfo: String

        @JvmStatic
        @BeforeClass
        fun init() {
            val orig: String = System.getProperty("INFO")!!
            origInfo = File(orig).readText()

            LibTestsSerCommon.init()
            checkNotNull(model)
            val info = model!!.info()
            val counts = ModelInfo.counts(model!!)
            modelInfo = "$info\n$counts"
            ps.println(modelInfo)
            ps.println()
        }
    }
}
