package ru.alpha.test.denisov26.currencyservice.feignservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.alpha.test.denisov26.currencyservice.dto.CurrencyDto;

@FeignClient(url = "${giphy.client.url}", name = "giphyClient")
public interface GiphyClient {

    @GetMapping("/rich/{random}")
    ResponseEntity<CurrencyDto> getRandomRich(
            @PathVariable("random") String random,
            @RequestParam(name = "app_key") String appId);

    @GetMapping("/broke/{random}")
    ResponseEntity<CurrencyDto> getRandomBroke(
            @PathVariable("random") String random,
            @RequestParam("api_key") String appId);
}
