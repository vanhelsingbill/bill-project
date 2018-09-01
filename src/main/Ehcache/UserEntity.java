package Ehcache;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Inherited;

/**
 * Created by Vanhelsing on 2018/6/24.
 */
@Setter
@Getter
@Data
@Slf4j
public class UserEntity {
    private String userId;
    private String userName;
    private Integer age;
}
