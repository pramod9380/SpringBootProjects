package com.perfios.bootcamp.springcore3.bank_application;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Address implements CustomerDetails {

    private String area;
    private String city;
    private String state;
    private String zipCode;

    @Override
    public void getDetails() {
        System.out.println(
                "\nArea: "+area+
                "\nCity: "+city+
                "\nState: "+state+
                "\nPin Code: "+zipCode
                );
    }
}
