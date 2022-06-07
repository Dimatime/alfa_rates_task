package ru.dima.alfa.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GifRateDTO {
    private Double historyDayRates;
    private Double realTimeRates;
    private String gif;
}
