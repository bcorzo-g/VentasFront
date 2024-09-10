package integracion;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class BaseIntegracion {

    protected Client cliente = ClientBuilder.newClient();

}
