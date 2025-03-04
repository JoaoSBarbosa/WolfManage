package com.joaobarbosadev.WolfManage.web.client.dtos;

import com.joaobarbosadev.WolfManage.core.enums.States;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientViewModel {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String addressNumber;
    private String city;
    private States state;
    private String neighbourhood;
    private String zip;


    public String getPhoneFormat() {
        return phone.replaceAll("(\\d{2})(\\d{5})(\\d{4})", "($1) $2-$3");
    }

}
