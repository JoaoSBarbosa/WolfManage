package com.joaobarbosadev.WolfManage.web.client.dtos;

import com.joaobarbosadev.WolfManage.core.enums.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientForm {

    private String name;
    private String email;
    private String phone;
    private String address;
    private String addressNumber;
    private String city;
    private String state;
    private String neighbourhood;
    private Country country = Country.BRAZIL;
}
