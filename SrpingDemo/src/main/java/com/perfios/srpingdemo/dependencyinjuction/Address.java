package com.perfios.srpingdemo.dependencyinjuction;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Address {

    private String area;
    private String city;
    private String state;
    private String zipCode;

}
