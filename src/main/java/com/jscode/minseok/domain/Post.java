package com.jscode.minseok.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Data  // lombok 어노테이션 정리
@Entity
@AllArgsConstructor
@NoArgsConstructor // 기본 생성자 생성
public class Post {

    // @GeneratedValue(strategy = GenerationType.SEQUENCE)를 사용하는 경우,
    // 데이터베이스에서 생성된 ID 값이 아닌 SEQUENCE가 생성한 값을 반환할 수 있으므로
    // GenerationType.IDENTITY 로 변경해 줘야함
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String title;
    private String content;
    private Date createdat;

}
