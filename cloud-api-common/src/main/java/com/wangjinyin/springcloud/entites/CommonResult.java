package com.wangjinyin.springcloud.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author jinyin wang
 * @create 2020-04-11 13:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {

    private Integer code;

    private String mesaage;

    private  T data;

    public CommonResult(Integer code, String mesaage) {
        this.code = code;
        this.mesaage = mesaage;
        data = null;
    }


	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMesaage() {
		return mesaage;
	}

	public void setMesaage(String mesaage) {
		this.mesaage = mesaage;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
