package com.jscode.minseok.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseDTO {

    private Long id;
    private String title;
    private String content;
    private Date createdat;

}
