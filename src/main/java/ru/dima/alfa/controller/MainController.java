package ru.dima.alfa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.dima.alfa.client.RatesClient;
import java.util.Map;


@Controller("/")
public class MainController {

    private final RatesClient ratesClient;

    public MainController(RatesClient ratesClient) {
        this.ratesClient = ratesClient;
    }

    /**
     * Метод возвращает страницу для выбора валют.
     * @param model в модели передаем список всех валют
     * @return возвращаем данные на страницу
     */

    @GetMapping()
    public String getGif(Model model){
        Map<String, Double> rates = ratesClient.getValue().getRates();
        model.addAttribute("ratesMap", rates);
        return "main";
    }

}
