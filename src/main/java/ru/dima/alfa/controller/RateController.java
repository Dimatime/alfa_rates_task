package ru.dima.alfa.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dima.alfa.model.GifRateDTO;
import ru.dima.alfa.service.CompareMethodService;


@Controller
@RequestMapping("{getKey}")
@AllArgsConstructor
public class RateController {

    private final CompareMethodService compareMethodService;

    /**
     * Метод для установленной валюты
     * @param getKey параметр устанавливает валюту
     * @param model параметр для передачи на страницу значений
     * @return возвращаем данные на страницу
     */

    @GetMapping()
    public String getValue(@PathVariable("getKey") String getKey, Model model){

        GifRateDTO dto = compareMethodService.compareRates(getKey);

        model.addAttribute("realTimeRates", dto.getRealTimeRates());
        model.addAttribute("historyDayRates", dto.getHistoryDayRates());
        model.addAttribute("currency", getKey);
        model.addAttribute("gif", dto.getGif());

        return "gif";
    }



}
