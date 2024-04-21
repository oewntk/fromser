/*
 * Copyright (c) 2021-2021. Bernard Bou.
 */
package org.oewntk.ser.`in`

import org.oewntk.model.DeSerialize.deSerializeModel
import org.oewntk.model.Model
import java.io.File
import java.io.IOException
import java.util.function.Supplier

/**
 * Model factory from serialization
 *
 * @property file serialization file
 */
class Factory(
	private val file: File
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
			val file = File(args[0])
			return Factory(file).get()
		}

		/**
		 * Main
		 *
		 * @param args command-line arguments
		 */
		@JvmStatic
		fun main(args: Array<String>) {
			val model = makeModel(args)
			org.oewntk.model.Tracing.psInfo.printf("[Model] %s%n%s%n%s%n", model!!.sources.contentToString(), model.info(), model.counts())
		}
	}
}