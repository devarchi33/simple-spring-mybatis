package com.skyfly33.spring.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by donghoon on 15. 9. 13..
 */
@Data
@Document(collection = "baseball.ranking")
public class BaseballTeam {
    private String team;
    private int the_number_of_game;
    private int win;
    private int lose;
    private int draw;
    private double winning_rate;
}
