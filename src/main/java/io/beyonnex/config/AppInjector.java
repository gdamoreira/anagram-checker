package io.beyonnex.config;

import com.google.inject.AbstractModule;
import io.beyonnex.service.AnagramService;
import io.beyonnex.service.DefaultAnagramService;

/**
 * Guice module for configuring dependency injection bindings in the application.
 */
public class AppInjector extends AbstractModule {

    /**
     * Configures the dependency injection bindings.
     */
    @Override
    protected void configure() {
        bind(AnagramService.class).to(DefaultAnagramService.class);
    }

}