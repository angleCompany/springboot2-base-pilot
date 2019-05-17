package com.rest.api.entity;

import javax.persistence.*;
import lombok.*;

@Builder   // Builder Pattern을 사용할수 있게
@Entity    // JPA entity
@Getter    // Get Method 생성
@NoArgsConstructor //인자없는 생성자를 자동으로 생성
@AllArgsConstructor //인자를 모두 갖춘 생성자 자동 생성
@Table(name = "user") //user table 과 매핑됨을 명시
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk생성전략을 DB에 위임한다는 의미입니다. mysql로 보면 pk 필드를 auto_increment로 설정해 놓은 경우로 보면 됩니다.
    private Long msrl;

    @Column(nullable = false, unique = true, length = 30) // uid 컬럼을 정의 한다. 필수이고 유니크 필드이며, 길이가 30인 컬럼
    private String uid;

    @Column(nullable = false, length = 100) // name 컬럼을 명시, 필수이고 길이가 100 인 컬럼
    private String name;
}
