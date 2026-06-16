/*
 * Copyright (c) 2021-2024. Bernard Bou.
 */
package org.oewntk.ser.`in`

import org.oewntk.model.CoreModel
import org.oewntk.model.DeSerialize.deSerializeCoreModel
import org.oewntk.model.ModelInfo
import java.io.File
import java.io.IOException
import java.util.function.Supplier

/**
 * Core model factory from serialization
 *
 * @property file serialization file
 */
class CoreFactory(
    private val file: File,
) : Supplier<CoreModel?> {

    override fun get(): CoreModel? {
        try {
            return deSerializeCoreModel(file)
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
         * Make core model from serialization
         *
         * @param args command-line arguments
         * @return core model
         */
        private fun makeCoreModel(args: Array<String>): CoreModel? {
            val file = File(args[0])
            return CoreFactory(file).get()
        }

        /**
         * Main
         *
         * @param args command-line arguments
         */
        @JvmStatic
        fun main(args: Array<String>) {
            val model = makeCoreModel(args)
            Tracing.psInfo.printf("[CoreModel] %s%n%s%n%s%n", model!!.source, model.info(), ModelInfo.counts(model))
        }
    }
}