package ru.dima.alfa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GiphyModel {

    private GiphyData data;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class GiphyData {
        private Images images;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Images {
        private Original original;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Original {
        private String url;
    }
}
