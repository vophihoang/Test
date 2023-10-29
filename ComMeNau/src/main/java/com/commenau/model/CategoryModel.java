package com.commenau.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryModel {
	private Integer id;
	private String code;
	private String name;
	private Timestamp updated;
	private Timestamp create;
	
}