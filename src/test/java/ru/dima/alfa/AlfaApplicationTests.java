package ru.dima.alfa;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.dima.alfa.client.GiphyClient;
import ru.dima.alfa.client.RatesClient;
import ru.dima.alfa.model.GiphyModel;
import ru.dima.alfa.model.RatesModel;

import java.time.LocalDate;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class AlfaApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RatesClient ratesClient;
    @MockBean
    private GiphyClient giphyClient;

    @Test
    public void testMainPage() throws Exception {
        Mockito.when(ratesClient.getValue())
                .thenReturn(new RatesModel(Map.of("RUB",3.0)));

        this.mockMvc.perform(get("/")) //пойти по пути
                .andExpect(model().attribute("ratesMap",Map.of("RUB",3.0)))
                .andExpect(status().isOk()); //ответ от сервера 200

    }

    @Test
    public void testRatePage() throws Exception {
        Mockito.when(ratesClient.getHistory(LocalDate.now().minusDays(1).toString(),"RUB"))
                .thenReturn(new RatesModel(Map.of("RUB",3.0)));
        Mockito.when(ratesClient.getValue()).thenReturn(new RatesModel(Map.of("RUB",4.0)));

        Mockito.when(giphyClient.getGiphy("rich"))
                .thenReturn(
                        new GiphyModel(
                                new GiphyModel.GiphyData(
                                        new GiphyModel.Images(
                                                new GiphyModel.OriginalImages("url")
                                        )
                                )
                        )
                );

        this.mockMvc.perform(get("/RUB"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("realTimeRates",4.0))
                .andExpect(model().attribute("historyDayRates",3.0))
                .andExpect(model().attribute("currency","RUB"))
                .andExpect(model().attribute("gif","url"));
    }

}
