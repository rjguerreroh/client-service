package com.test.client_service.dto;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Data
public class ClientRequest {
    @NotBlank
    private String typeDocument;

    @NotBlank
    private String numberDocument;
}
