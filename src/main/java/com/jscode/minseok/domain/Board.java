package com.jscode.minseok.domain;

import lombok.*;

import java.sql.Date;

@Data  // lombok 어노테이션 정리
public class Board {

    private Long id;
    private String title;
    private String content;
    private Date createdat;

}
