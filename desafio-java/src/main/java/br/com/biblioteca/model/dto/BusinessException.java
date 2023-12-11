package br.com.biblioteca.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class BusinessException extends RuntimeException {

    @Getter
    String message;


}
