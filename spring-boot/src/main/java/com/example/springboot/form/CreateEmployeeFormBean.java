package com.example.springboot.form;
//form bean

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class CreateEmployeeFormBean {

    private String email; //these variables have to match!!!! with what is on the jsp page
    private String firstName;
    private String lastName;
    //we are going to make this data type an integer
    private Integer reportsTo;
    // this is for the officeId
    private Integer officeId;
    private String extension;
    private String jobTitle;
    private String profileImageUrl;
    private Integer vacationHours;

}
