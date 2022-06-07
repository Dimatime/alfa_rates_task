package ru.dima.alfa.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dima.alfa.client.GiphyClient;
import ru.dima.alfa.client.RatesClient;
import ru.dima.alfa.model.GifRateDTO;

import java.time.LocalDate;
import java.util.function.DoubleBinaryOperator;

@RequiredArgsConstructor
@Service
public class CompareMethodService {

    private final RatesClient ratesClient;
    private final GiphyClient giphyClient;

    public GifRateDTO compareRates(String key){
        String historyDay = LocalDate.now().minusDays(1).toString();

        Double historyDayRates = ratesClient.getHistory(historyDay, key).getRates().get(key);
        Double realTimeRates = ratesClient.getValue().getRates().get(key);

        String gif = giphyClient
                .getGiphy((historyDayRates <= realTimeRates) ? "rich": "broke")
                .getData()
                .getImages()
                .getOriginal().getUrl();
        return new GifRateDTO(historyDayRates,realTimeRates,gif);
    }
}
