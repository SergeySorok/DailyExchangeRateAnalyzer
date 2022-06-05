package ru.saakian.dailyexchangerateanalyzer.feign.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GifDto {
    private Data data;

    public String getGifId() {
        return this.data.id;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    private static class Data {
        private String id;
    }
}




