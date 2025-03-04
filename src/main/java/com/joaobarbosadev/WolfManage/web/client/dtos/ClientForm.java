package com.joaobarbosadev.WolfManage.web.client.dtos;

import com.joaobarbosadev.WolfManage.core.enums.Country;
import com.joaobarbosadev.WolfManage.core.enums.States;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientForm {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String addressNumber;
    private String city;
    private States state;
    private String neighbourhood;
    private Country country = Country.BRAZIL;
    private String zip;
}
