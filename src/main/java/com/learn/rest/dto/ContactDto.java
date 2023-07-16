
package com.learn.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto {
    private int contactId;
    private String firstName;
    private String lastName;
    private String mobile;
    private String email;
    private String contactGroup;
}
