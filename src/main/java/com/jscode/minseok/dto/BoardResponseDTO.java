package com.jscode.minseok.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Data
@AllArgsConstructor
public class BoardResponseDTO {

    private Long id;
    private String title;
    private String content;
    private Date createdat;

}
