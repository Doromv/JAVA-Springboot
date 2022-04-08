package com.doromv.boot.been;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author Doromv
 * @create 2022-03-08-15:59
 */
@Component
@Data
public class Pet {
    private String name;
    private Double weight;
}
