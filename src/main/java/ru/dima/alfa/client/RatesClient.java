package ru.dima.alfa.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.dima.alfa.model.RatesModel;

@FeignClient(name="ExchangeRatesClient", url = "${rates.listOfServers}")
public interface RatesClient {

    @GetMapping("/latest.json?app_id=${api.app_id}")
    RatesModel getValue();

    @GetMapping("/historical/{date}.json?app_id=${api.app_id}&symbols={value}")
    RatesModel getHistory(@PathVariable String date, @PathVariable String value);


}
