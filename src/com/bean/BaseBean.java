package com.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.util.FacesUtil;

@ManagedBean
@ViewScoped
public class BaseBean {
	
	private boolean _isMessageError;
	private boolean _isMessageAlert;
	
	public void cleanMessageFlags()
	{
		_isMessageAlert = false;
		_isMessageError = false;
	}
	
	public boolean isMessageError() {
		return _isMessageError;
	}

	public boolean isMessageAlert() {
		return _isMessageAlert;
	}

	public void showInfo(String message)
	{
		FacesUtil.adicionaMsgInfo(message);
	}
	
	public void showAlert(String message)
	{
		_isMessageAlert = true;
		FacesUtil.adicionaMsgInfo(message);
	}
	
	public void showError(String message)
	{
		_isMessageError = true;
		FacesUtil.adicionaMsgErro(message);
	}
	
	public boolean isNullOrEmpty(String value)
	{
		return value == null || value.equals("");
	}
}
