/*
 * Copyright (c) 2021. Bernard Bou.
 */
package org.oewntk.ser.`in`

import java.io.OutputStream
import java.io.PrintStream

object Tracing {
	val psInfo: PrintStream = System.out

	@JvmField
	val psErr: PrintStream = System.err

	val psNull: PrintStream = PrintStream(object : OutputStream(
	) {
		override fun write(i: Int) {
			// do nothing
		}
	})
}
