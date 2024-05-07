/*
 * Copyright (c) 2021-2024. Bernard Bou.
 */
package org.oewntk.ser.`in`

import org.junit.Assert
import org.oewntk.model.CoreModel
import org.oewntk.model.DeSerialize
import org.oewntk.model.ModelInfo
import java.io.File
import java.io.PrintStream

object LibTestsSerCommon {

    private val source: String? = System.getProperty("SOURCE")

    val ps: PrintStream = if (!System.getProperties().containsKey("SILENT")) Tracing.psInfo else Tracing.psNull

    var model: CoreModel? = null

    fun init() {
        if (model == null) {
            if (source == null) {
                Tracing.psErr.println("Define serialized source file dir with -DSOURCE=path")
                Assert.fail()
            }
            val file = File(source!!)
            Tracing.psInfo.printf("source=%s%n", file.absolutePath)
            if (!file.exists()) {
                Tracing.psErr.println("Define serialized source dir that exists")
                Assert.fail()
            }

            model = DeSerialize.deSerializeCoreModel(file)
        }
        checkNotNull(model)
    }
}
