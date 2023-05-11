package com.jscode.minseok.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // 모든 파라미터를 가진 생성자 생성
@NoArgsConstructor // 기본 생성자 생성
public class PostRequestDTO {

    private Long id;
    private String title;
    private String content;

    public PostRequestDTO(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
