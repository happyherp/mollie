package be.feelio.mollie;

import be.feelio.mollie.util.Config;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void constructor() {
        Client client = new Client("apiKey");

        assertEquals("https://api.mollie.com/v2", client.getEndpoint());
        assertEquals("apiKey", client.getConfig().getApiKey());
    }

    @Test
    void setAccessToken() {
        Client client = new Client("apiKey");

        client.setAccessToken("access_token");

        assertEquals("access_token", client.getConfig().getAccessToken());
    }

    @Test
    void revokeAccessToken() {
        Client client = new Client("apiKey");

        client.setAccessToken("access_token");

        assertEquals("access_token", client.getConfig().getAccessToken());

        client.revokeAccessToken();

        assertNull(client.getConfig().getAccessToken());
    }

    @Test
    void enableTestMode() {
        Client client = new Client("apiKey");
        client.enableTestMode();

        assertTrue(client.getConfig().isTestMode());
    }

    @Test
    void disableTestMode() {
        Client client = new Client("apiKey");
        client.enableTestMode();
        client.disableTestMode();

        assertFalse(client.getConfig().isTestMode());
    }
    
    @Test
    void twoClients(){
        Client client1 = new Client("apiKey1");
        Client client2 = new Client("apiKey2");

        assertEquals("apiKey1",client1.getConfig().getApiKey());
        assertEquals("apiKey2",client2.getConfig().getApiKey());
        
    }

}