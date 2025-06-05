package com.test.client_service.services;

import com.test.client_service.dto.ClientRequest;
import com.test.client_service.dto.ClientResponse;
import com.test.client_service.dto.MockClient;
import com.test.client_service.exeptions.ClientNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    private final List<MockClient> mockDatabase;

    public ClientService() {
        // Initialize the mock database with several records
        mockDatabase = new ArrayList<>();
        mockDatabase.add(createMockClient("Carlos", "Andrés", "Pérez", "Ramírez", "3001234567", "Calle Falsa 123", "Bogotá", "23445322", "C"));
        mockDatabase.add(createMockClient("Ana", "María", "Gómez", "López", "3109876543", "Carrera 45 #12-34", "Medellín", "98765432", "P"));
        mockDatabase.add(createMockClient("Luis", "Fernando", "Martínez", "Rodríguez", "3204567890", "Avenida Siempre Viva", "Cali", "12345678", "C"));
    }


    public ClientResponse findByNumberDocument(ClientRequest request) {
        if (!"C".equals(request.getTypeDocument()) && !"P".equals(request.getTypeDocument())) {
            throw new ClientNotFoundException("Tipo de documento no válido");
        }

        for (MockClient client : mockDatabase) {
            if (client.getTypeDocument().equals(request.getTypeDocument()) &&
                    client.getNumberDocument().equals(request.getNumberDocument())) {
                return mapToClientResponse(client);
            }
        }

        throw new ClientNotFoundException("Cliente no encontrado");
    }

    private MockClient createMockClient(String firstName, String secondName, String lastName, String secondLastName,
                                        String phone, String address, String homeCity, String numberDocument, String typeDocument) {
        MockClient client = new MockClient();
        client.setFirstName(firstName);
        client.setSecondName(secondName);
        client.setLastName(lastName);
        client.setSecondLastName(secondLastName);
        client.setPhone(phone);
        client.setAddress(address);
        client.setHomeCity(homeCity);
        client.setNumberDocument(numberDocument);
        client.setTypeDocument(typeDocument);
        return client;
    }

    private ClientResponse mapToClientResponse(MockClient mockClient) {
        ClientResponse response = new ClientResponse();
        response.setFirstName(mockClient.getFirstName());
        response.setSecondName(mockClient.getSecondName());
        response.setLastName(mockClient.getLastName());
        response.setSecondLastName(mockClient.getSecondLastName());
        response.setPhone(mockClient.getPhone());
        response.setAddress(mockClient.getAddress());
        response.setHomeCity(mockClient.getHomeCity());
        return response;
    }


}
