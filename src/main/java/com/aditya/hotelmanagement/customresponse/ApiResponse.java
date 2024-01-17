package com.aditya.hotelmanagement.customresponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ApiResponse {
    private String status;
    private String message;
    private Object data;

}
