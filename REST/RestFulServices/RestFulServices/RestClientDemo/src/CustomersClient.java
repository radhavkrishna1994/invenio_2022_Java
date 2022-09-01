
import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.representation.Form;



public class CustomersClient {
  public static void main(String[] args) {
    ClientConfig config = new DefaultClientConfig();
    Client client = Client.create(config);
    WebResource service = client.resource(getBaseURI());
    // Create one customer
    Customer customer = new Customer("3", "Blabla");
    ClientResponse response = service.path("rest").path("customers")
        .path(customer.getId()).accept(MediaType.APPLICATION_XML)
        .put(ClientResponse.class, customer);
    // Return code should be 201 == created resource
    System.out.println(response.getStatus());
    // Get the Customers
    System.out.println(service.path("rest").path("customers")
        .accept(MediaType.TEXT_XML).get(String.class));
    // Get JSON for application
    System.out.println(service.path("rest").path("customers")
        .accept(MediaType.APPLICATION_JSON).get(String.class));
    // Get XML for application
    System.out.println(service.path("rest").path("customers")
        .accept(MediaType.APPLICATION_XML).get(String.class));

    // Get the Customer with id 1
    System.out.println(service.path("rest").path("customers/1")
        .accept(MediaType.APPLICATION_XML).get(String.class));
    // get Customer with id 1
    service.path("rest").path("customers/1").delete();
    // Get the all customers, id 1 should be deleted
    System.out.println(service.path("rest").path("customers")
        .accept(MediaType.APPLICATION_XML).get(String.class));

    // Create a Customer
    Form form = new Form();
    form.add("id", "4");
    form.add("summary", "Demonstration of the client lib for forms");
    response = service.path("rest").path("customers")
        .type(MediaType.APPLICATION_FORM_URLENCODED)
        .post(ClientResponse.class, form);
    System.out.println("Form response " + response.getEntity(String.class));
    // Get the all customers, id 4 should be created
    System.out.println(service.path("rest").path("customers")
        .accept(MediaType.APPLICATION_XML).get(String.class));

  }

  private static URI getBaseURI() {
    return UriBuilder.fromUri("http://localhost:8080/de.vogella.jersey.customer").build();
  }