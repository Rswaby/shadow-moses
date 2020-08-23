package com.shadowmoses.api.model.stock;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
public class StockData {
    private final LocalDateTime dateTime;
    private final double open;
    private final double high;
    private final double close;
    private final double adjustedClose;
    private final long volume;
    private final double dividendAmount;//not in spec
    private final double splitCoefficient;//not in spec

}
