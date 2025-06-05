package com.test.client_service.controllers;

import com.test.client_service.dto.ClientRequest;
import com.test.client_service.dto.ClientResponse;
import com.test.client_service.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/query")
    public ResponseEntity<ClientResponse> findByNumberDocument(@Valid @RequestBody ClientRequest request) {
        ClientResponse response = clientService.findByNumberDocument(request);
        return ResponseEntity.ok(response);
    }
}
