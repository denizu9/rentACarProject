package com.example.demo.core.utilities.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationProblemDetails extends ProblemDetails{

    private Map<String, String> validationErrors; // Hangi alanda(String) ne hatası var(String)

    // Burada hem mesaj oluyor(Problem Details'dan gelen) hem de hangi alanda ne hatası olduğunu bulunduruyoruz.
}
