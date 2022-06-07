package ru.dima.alfa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GiphyModel {

    private GiphyData data;

    @Data
    @AllArgsConstructor
    public static class GiphyData {
        private Images images;
    }

    @Data
    @AllArgsConstructor
    public static class Images {
        private OriginalImages original;
    }

    @Data
    @AllArgsConstructor
    public static class OriginalImages {
        private String url;
    }
}
