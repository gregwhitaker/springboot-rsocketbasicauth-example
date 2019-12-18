package example.client.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import static picocli.CommandLine.Option;
import static picocli.CommandLine.Parameters;
import static picocli.CommandLine.populateCommand;

@SpringBootApplication
public class HelloClientApplication {
    private static final Logger LOG = LoggerFactory.getLogger(HelloClientApplication.class);

    public static void main(String... args) {
        SpringApplication.run(HelloClientApplication.class, args);
    }

    /**
     * Runs the application.
     */
    @Component
    public class Runner implements CommandLineRunner {

        @Override
        public void run(String... args) throws Exception {
            ClientArguments params = populateCommand(new ClientArguments(), args);

            LOG.debug("username: {}", params.username);
            LOG.debug("password: {}", params.password);
            LOG.debug("method: {}", params.method);
            LOG.debug("name: {}", params.name);
        }
    }

    /**
     * Hello client command line arguments.
     */
    public static class ClientArguments {

        /**
         * Basic auth username
         */
        @Option(names = "--username", description = "basic auth username")
        public String username;

        /**
         * Basic auth password
         */
        @Option(names = "--password", defaultValue = "basic auth password")
        public String password;

        /**
         * RSocket method name
         */
        @Parameters(index = "0", arity = "1", description = "the method to call")
        public String method;

        /**
         * "name" argument to send to the method
         */
        @Parameters(index = "1", arity = "1", defaultValue = "name argument for method")
        public String name;
    }
}
