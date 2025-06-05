package com.test.client_service.services;

import com.test.client_service.dto.ClientRequest;
import com.test.client_service.dto.ClientResponse;
import com.test.client_service.exeptions.ClientNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    @InjectMocks
    private ClientService clientService;

    @Test
    void testFindByNumberDocument_ValidClient() {
        // Arrange
        ClientRequest request = new ClientRequest();
        request.setTypeDocument("C");
        request.setNumberDocument("23445322");

        // Act
        ClientResponse response = clientService.findByNumberDocument(request);

        // Assert

        Assertions.assertNotNull(response);


    }

    @Test
    void testFindByNumberDocument_InvalidDocumentType() {
        // Arrange
        ClientRequest request = new ClientRequest();
        request.setTypeDocument("X");
        request.setNumberDocument("23445322");

        // Act & Assert
        assertThrows(ClientNotFoundException.class, () -> clientService.findByNumberDocument(request));
    }

    @Test
    void testFindByNumberDocument_ClientNotFound() {
        // Arrange
        ClientRequest request = new ClientRequest();
        request.setTypeDocument("C");
        request.setNumberDocument("99999999");

        // Act & Assert
        assertThrows(ClientNotFoundException.class, () -> clientService.findByNumberDocument(request));
    }
}