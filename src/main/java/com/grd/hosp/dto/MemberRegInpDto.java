package com.grd.hosp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberRegInpDto {
	private String id;
	private String pw;
	private String name;
	private String address;
	private String phone;
	private String gender;
}
