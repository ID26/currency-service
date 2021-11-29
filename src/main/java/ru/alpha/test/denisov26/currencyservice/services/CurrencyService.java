package ru.alpha.test.denisov26.currencyservice.services;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.alpha.test.denisov26.currencyservice.dto.CurrencyDto;
import ru.alpha.test.denisov26.currencyservice.feignservices.GiphyClient;
import ru.alpha.test.denisov26.currencyservice.feignservices.OpenExchange;

@Service
@Data
public class CurrencyService {

    private final OpenExchange openExchange;
    private final GiphyClient giphyClient;
    private final String appId;
    private final String apiKey;

    public CurrencyService(OpenExchange openExchange,
                           GiphyClient giphyClient, @Value("${open_exchange.app_id}") String appId, @Value("${giphy.API.key}") String apiKey) {
        this.openExchange = openExchange;
        this.giphyClient = giphyClient;
        this.appId = appId;
        this.apiKey = apiKey;
    }

    public ResponseEntity<CurrencyDto> getRate(String localDate) {
        Double rateCurrencyByBaseNow = openExchange.getCurrencyRates(appId)
                .getBody().getRates().get("RUB");
        Double rateCurrencyByBaseOnDate = openExchange.getCurrencyRatesByDate(localDate, appId)
                .getBody().getRates().get("RUB");

        return rateCurrencyByBaseNow > rateCurrencyByBaseOnDate ?
                giphyClient.getRandomRich("random", apiKey) :
                giphyClient.getRandomBroke("random", apiKey);

    }
}
