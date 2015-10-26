package com.dhatim.blog;

import com.codahale.metrics.health.HealthCheck;
import com.dhatim.blog.resources.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MJDApplication extends Application<MJDConfiguration> {

    private static final Logger log = LoggerFactory.getLogger(MJDApplication.class);

    public static void main(String[] args) throws Exception {
        new MJDApplication().run(args);
    }

    @Override
    public void run(MJDConfiguration c, Environment e) throws Exception {

        log.debug("silencing warning about no healthcheck being defined");
        e.healthChecks().register("dadida, can't hear you", new HealthCheck() {
            @Override
            protected HealthCheck.Result check() throws Exception {
                return Result.healthy();
            }
        });

        log.info("setting up api");
        e.jersey().register(new HelloWorldResource());
    }
}
