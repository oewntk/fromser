/*
 * Copyright (c) 2021-2024. Bernard Bou.
 */
package org.oewntk.ser.`in`

import org.oewntk.model.DeSerialize.deSerializeModel
import org.oewntk.model.Model
import org.oewntk.model.ModelInfo
import java.io.File
import java.io.IOException
import java.util.function.Supplier

/**
 * Model factory from serialization
 *
 * @property file serialization file
 */
class Factory(
    private val file: File,
    private val verbose: Boolean = false,
) : Supplier<Model?> {

    override fun get(): Model? {
        try {
            return deSerializeModel(file)
        } catch (e: IOException) {
            e.printStackTrace(Tracing.psErr)
            return null
        } catch (e: ClassNotFoundException) {
            e.printStackTrace(Tracing.psErr)
            return null
        }
    }

    companion object {

        /**
         * Make model from serialization
         *
         * @param args command-line arguments
         * @return model
         */
        private fun makeModel(args: Array<String>): Model? {
            var iArg = 0
            var verbose = false
            if (args[iArg] == "-verbose") {
                verbose = true
                iArg++
            }
            val file = File(args[iArg])
            return Factory(file, verbose = verbose).get()
        }

        /**
         * Main
         *
         * @param args command-line arguments
         */
        @JvmStatic
        fun main(args: Array<String>) {
            val model = makeModel(args)
            Tracing.psInfo.printf("[Model] %s%n%s%n%s%n", model!!.sources.contentToString(), model.info(), ModelInfo.counts(model))
        }
    }
}