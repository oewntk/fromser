/*
 * Copyright (c) 2021-2024. Bernard Bou.
 */
package org.oewntk.ser.`in`

import org.junit.BeforeClass
import org.junit.Test
import org.oewntk.model.LibTestModelDuplicates.testDuplicatesForKeyIC
import org.oewntk.model.LibTestModelDuplicates.testDuplicatesForKeyOEWN
import org.oewntk.model.LibTestModelDuplicates.testDuplicatesForKeyPWN
import org.oewntk.model.LibTestModelDuplicates.testDuplicatesForKeyPos
import org.oewntk.ser.`in`.LibTestsSerCommon.model
import org.oewntk.ser.`in`.LibTestsSerCommon.ps

class TestsSerModelDuplicates {

    @Test
    fun testKeyOEWN() {
        testDuplicatesForKeyOEWN(model!!, ps)
    }

    @Test
    fun testKeyPos() {
        testDuplicatesForKeyPos(model!!, ps)
    }

    @Test
    fun testKeyIC() {
        testDuplicatesForKeyIC(model!!, ps)
    }

    @Test
    fun testKeyPWN() {
        testDuplicatesForKeyPWN(model!!, ps)
    }

    companion object {

        @JvmStatic
        @BeforeClass
        fun init() {
            LibTestsSerCommon.init()
            checkNotNull(model)
        }
    }
}
