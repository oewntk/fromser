/*
 * Copyright (c) 2021-2021. Bernard Bou.
 */

package org.oewntk.ser.in;

import org.oewntk.model.DeSerialize;
import org.oewntk.model.Model;
import org.oewntk.model.Tracing;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.function.Supplier;

/**
 * Model factory from serialization
 */
public class Factory implements Supplier<Model>
{
	private final File file;

	/**
	 * Constructor
	 *
	 * @param file serialization file
	 */
	public Factory(final File file)
	{
		this.file = file;
	}

	@Override
	public Model get()
	{
		try
		{
			return DeSerialize.deSerializeModel(file);
		}
		catch (IOException | ClassNotFoundException e)
		{
			e.printStackTrace(org.oewntk.ser.in.Tracing.psErr);
			return null;
		}
	}

	/**
	 * Make model from serialization
	 *
	 * @param args command-line arguments
	 * @return model
	 */
	static public Model makeModel(String[] args)
	{
		File file = new File(args[0]);
		return new Factory(file).get();
	}

	/**
	 * Main
	 *
	 * @param args command-line arguments
	 */
	static public void main(String[] args)
	{
		Model model = makeModel(args);
		Tracing.psInfo.printf("[Model] %s%n%s%n%s%n", Arrays.toString(model.getSources()), model.info(), model.counts());
	}
}