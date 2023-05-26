package com.example.demo.core.utilities.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProblemDetails {

    //Amaç; hata bilgisini tek satıra indirip kullanıcının anlamasını sağlamak.
    String message;
}
