package ru.alpha.test.denisov26.currencyservice.services;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.alpha.test.denisov26.currencyservice.dto.CurrencyDto;
import ru.alpha.test.denisov26.currencyservice.feignservices.OpenExchange;

@Service
@Data
public class CurrencyService {

    private final OpenExchange openExchange;
    private final String appId;

    public CurrencyService(OpenExchange openExchange,
                           @Value("${open_exchange.app_id}") String appId) {
        this.openExchange = openExchange;
        this.appId = appId;
    }

    public ResponseEntity<CurrencyDto> getRate(String currencyName) {
        return openExchange.getCurrencyRates(appId);
    }
}
