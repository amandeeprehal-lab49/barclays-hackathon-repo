package com.ion.barclaysapi.client.cdm;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.isda.cdm.CdmRuntimeModule;

public abstract class AbstractCdm {

	private Injector injector;

	public void run() {
		createInjectorAndInject();
		example();
	}

	protected void createInjectorAndInject() {
		injector = Guice.createInjector(new CdmRuntimeModule());
		injector.injectMembers(this);
	}

	public abstract void example();
}