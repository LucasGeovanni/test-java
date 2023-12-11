package br.com.biblioteca.model.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum RiskEnum {
    BAIXO("BAIXO","Baixo"),
    MEDIO("MEDIO","Medio"),
    ALTO("ALTO","Alto");

    private final String name;
    private final String description;

    public static RiskEnum toEnum(String description) {
        return Arrays.stream(RiskEnum.values()).filter(v->  v.getDescription().equals(description)).findFirst().orElse(null);
    }
}