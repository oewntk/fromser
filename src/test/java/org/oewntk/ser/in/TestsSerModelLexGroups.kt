/*
 * Copyright (c) 2021-2024. Bernard Bou.
 */
package org.oewntk.ser.`in`

import org.junit.BeforeClass
import org.junit.Test
import org.oewntk.model.Lex
import org.oewntk.model.LexGroupings
import org.oewntk.model.LibTestModelLexGroups.testCICounts
import org.oewntk.model.LibTestModelLexGroups.testCICountsFromMap
import org.oewntk.model.LibTestModelLexGroups.testCIHypermap3
import org.oewntk.model.LibTestModelLexGroups.testCILemmas
import org.oewntk.model.LibTestModelLexGroups.testCILexesFor
import org.oewntk.model.LibTestModelLexGroups.testCILexesFor3
import org.oewntk.model.LibTestModelLexGroups.testCIMultipleAll
import org.oewntk.ser.`in`.LibTestsSerCommon.model
import org.oewntk.ser.`in`.LibTestsSerCommon.ps

class TestsSerModelLexGroups {

    private val lexHyperMap: Map<String, Map<String, Collection<Lex>>> by lazy { LexGroupings.hyperMapByLCLemmaByLemma(model!!) }

    @Test
    fun testCIMultipleAll() {
        testCIMultipleAll(model!!, ps)
    }

    @Test
    fun testCILemmas() {
        testCILemmas(model!!, "battle of verdun", ps)
    }

    @Test
    fun testCICounts() {
        testCICounts(model!!, "battle of verdun", ps)
    }

    @Test
    fun testCICountsFromMap() {
        testCICountsFromMap(model!!, "battle of verdun", ps)
    }

    @Test
    fun testCIAi() {
        testCILexesFor(model!!, "ai", ps)
    }

    @Test
    fun testCIBaroque() {
        testCILexesFor(model!!, "baroque", ps)
    }

    @Test
    fun testCIWest3() {
        testCILexesFor3(model!!, "West", ps)
    }

    @Test
    fun testCIBaroque3() {
        testCILexesFor3(model!!, "Baroque", ps)
    }

    @Test
    fun testCIAi3() {
        testCILexesFor3(model!!, "Ai", ps)
    }

    @Test
    fun testCIAbsolute3() {
        testCILexesFor3(model!!, "Absolute", ps)
    }

    @Test
    fun testCIHypermapWest() {
        testCIHypermap3(lexHyperMap, "west", ps)
    }

    @Test
    fun testCIHypermapBaroque() {
        testCIHypermap3(lexHyperMap, "baroque", ps)
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
