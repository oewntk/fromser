/*
 * Copyright (c) 2021-2024. Bernard Bou.
 */
package org.oewntk.ser.`in`

import org.oewntk.model.CoreModel
import org.oewntk.model.DeSerialize
import org.oewntk.model.ModelInfo
import java.io.File
import java.io.PrintStream
import kotlin.test.assertEquals

object LibTestsSerCommon {

    private val source: String? = System.getProperty("SOURCE")
    private val sourceB: String? = System.getProperty("SOURCEB")

    val silent = if (System.getProperties().containsKey("VERBOSE")) false
    else if (System.getProperties().containsKey("SILENT")) true
    else true

    val ps: PrintStream = if (!silent) Tracing.psInfo else Tracing.psNull

    fun checkOrig() {
        val orig: String = System.getProperty("INFO")!!
        val origInfo = File(orig).readText()
        val info = model.info()
        val counts = ModelInfo.counts(model)
        val modelInfo = "$info\n$counts"
        ps.println(modelInfo)
        assertEquals(origInfo, modelInfo)
    }

    private fun getModel(source: String): CoreModel {
        val file = File(source)
        Tracing.psInfo.printf("source=%s%n", file.absolutePath)
        if (!file.exists()) {
            Tracing.psErr.println("Define serialized source dir that exists")
            throw AssertionError("SOURCE dir does not exist: ${file.absolutePath}")
        }
        return DeSerialize.deSerializeCoreModel(file)
    }

    val model: CoreModel by lazy {
        if (source == null) {
            Tracing.psErr.println("Define serialized source file dir with -DSOURCE=path")
            throw AssertionError("SOURCE not defined")
        }
        getModel(source)
    }

    val modelB: CoreModel by lazy {
        if (sourceB == null) {
            Tracing.psErr.println("Define serialized source file dir with -DSOURCEB=path")
            throw AssertionError("SOURCEB not defined")
        }
        getModel(sourceB)
    }
}
