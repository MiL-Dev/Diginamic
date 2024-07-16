package fr.diginamic.hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiDepartmentGouvDto {
	@JsonProperty("nom")
	private String name;
	private String code;
	private String codeRegion;
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "ApiDepartmentGouvDto [name=" + name + ", code=" + code + ", codeRegion=" + codeRegion + "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCodeRegion() {
		return codeRegion;
	}
	public void setCodeRegion(String codeRegion) {
		this.codeRegion = codeRegion;
	}
	
	
}
