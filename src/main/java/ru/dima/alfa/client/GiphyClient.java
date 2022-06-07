package ru.dima.alfa.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.dima.alfa.model.GiphyModel;


@FeignClient(name="GiphyClient", url ="${giphy.listOfServers}")
public interface GiphyClient {

    @GetMapping("?api_key=${api.giphy_id}&tag={value}&rating=g")
    GiphyModel getGiphy(@PathVariable() String value);

}
