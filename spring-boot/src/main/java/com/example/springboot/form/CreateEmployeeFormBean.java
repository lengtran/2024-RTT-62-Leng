package com.example.springboot.form;
//form bean

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@ToString

public class CreateEmployeeFormBean {

    @Length(max = 50, message = "Email must be less than 50 characters")
    @NotEmpty(message = "Email is required")
    private String email; //these variables have to match!!!! with what is on the jsp page

    @Length(max = 50, message = "First name must be less than 50 characters")
    @NotEmpty(message = "First name is required")
    private String firstName;

    @Length(max = 50, message = "Last name must be less than 50 characters")
    @NotEmpty(message = "Last name is required")
    private String lastName;


    private Integer reportsTo;//we are going to make this data type an integer
    // this is for the officeId
    private Integer officeId;
    private String extension;
    private String jobTitle;
    private String profileImageUrl;
    private Integer vacationHours;

}
