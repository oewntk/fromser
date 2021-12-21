/*
 * Copyright (c) 2021-2021. Bernard Bou.
 */

package org.oewntk.ser.in;

import org.oewntk.model.CoreModel;
import org.oewntk.model.DeSerialize;

import java.io.File;
import java.io.IOException;
import java.util.function.Supplier;

public class CoreFactory implements Supplier<CoreModel>
{
	private final File file;

	public CoreFactory(final File file)
	{
		this.file = file;
	}

	@Override
	public CoreModel get()
	{
		try
		{
			return DeSerialize.deSerializeCoreModel(file);
		}
		catch (IOException | ClassNotFoundException e)
		{
			e.printStackTrace(Tracing.psErr);
			return null;
		}
	}

	static public CoreModel makeCoreModel(String[] args)
	{
		File file = new File(args[0]);
		return new CoreFactory(file).get();
	}

	static public void main(String[] args)
	{
		CoreModel model = makeCoreModel(args);
		Tracing.psInfo.printf("[CoreModel] %s\n%s\n%s%n", model.getSource(), model.info(), model.counts());
	}
}