package org.sinau.config;
import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 * Singleton with the configurations
 * @author Lucas
 */
public class Config {
	private ClientConfig clientConfig;
	Client client;
    private String baseURI;
    private static Config instance;

    static {
        instance = new Config();
    }

    private Config() {
        this.baseURI = "http://garapa.intermidia.icmc.usp.br:8080/Sinau/rest/";
        
        clientConfig = new DefaultClientConfig();
        client = Client.create(clientConfig);
    }

    public static Config getInstance() {
    	return Config.instance;
    }

    public WebResource getService() {
        return client.resource(getBaseURI());
    }
    
    public WebResource getService(String path) {
        return client.resource(getBaseURI()).path(path);
    }

    public URI getBaseURI() {
        return UriBuilder.fromUri(this.baseURI).build();
    }

    public String getBaseURIString() {
        return baseURI;
    }
}
