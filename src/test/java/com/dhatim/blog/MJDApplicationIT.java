package com.dhatim.blog;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;
import static org.assertj.core.api.Assertions.assertThat;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.junit.Test;

public class MJDApplicationIT {

    @Test
    public void hello_world() {

        String api_endpoint = System.getenv("API_ENDPOINT");
        if (null == api_endpoint) {
            api_endpoint = "localhost:8080";
        }

        System.out.println("api endpoint: " + api_endpoint);

        Client client = new JerseyClientBuilder().build();

        Response response = client
                .target("http://" + api_endpoint + "/hello")
                .request()
                .get();

        assertThat(response.getStatus()).isEqualTo(200);
        String s = response.readEntity(String.class);
        assertThat(s).isEqualTo("Hello, World!");
    }
}
