package br.com.biblioteca.model.dto;


import br.com.biblioteca.model.enuns.RiskEnum;
import br.com.biblioteca.model.enuns.StatusProjectEnum;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ToString
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectResponse {

    private Long id;

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateForecastEnd;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    private String description;

    private StatusProjectEnum status;

    private Float budget;

    private RiskEnum risk;

    private PersonResponse manager;
}
