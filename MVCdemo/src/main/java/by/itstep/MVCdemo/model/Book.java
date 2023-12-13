package by.itstep.MVCdemo.model;

import lombok.*;


@Data
@AllArgsConstructor
public class Book{
    private Long id;
    private int price;
    private String title;
}
