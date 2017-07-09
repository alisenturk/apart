package com.apart.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class ErrorHandler implements Serializable,Runnable {
	private static final long serialVersionUID = -1855809456412530901L;
	private String strClassName 	= "";
	private String strFileName  	= "";
	private String strLineNumber 	= "";
	private String strMethodName	= "";
	private String strErrorMessage	= "";
	private Class  className;	
	private Exception exception;
	private String	userName;
	private String	logtype 		= "error";
	private String	serverName		= "";
	private String	extraInfo		= "";
	
	public ErrorHandler() {
		super();
	}
		
	public ErrorHandler(Exception e){
		this(ErrorHandler.class, e);	
	}
	public ErrorHandler(Class c,Exception e){
		this(c, e,"");
	}	
	public ErrorHandler(Class c,Exception e,String username){
		this(c, e, username, "error");
	}
	public ErrorHandler(Class c,Exception e,String username,String logtype){
		this.className = c;
		this.exception = e;
		this.userName  = username;
		this.logtype   = logtype;	
	}
	
	@Override
	public void run() {
		logwrite();		
	}
	
	public void logwrite(){
		
		StackTraceElement[] errs = exception.getStackTrace();
		Date 	today 	= new Date();
		String	strDate	= Helper.date2String(today);
		String	time	= Helper.date2String(today, "HH:mm:ss"); 
		
		ErrorData	error;
		String 		useElasticLogger = "false";
		List<ErrorData>	errorList		 = new ArrayList<>();
		for(StackTraceElement er:errs){ 			

			strClassName 	= er.getClassName();
			strFileName		= er.getFileName();
			strLineNumber	= String.valueOf(er.getLineNumber());
			strMethodName	= er.getMethodName();
			strErrorMessage	= exception.getMessage();
			
			if(strClassName==null || strClassName.length()==0 || strClassName.indexOf("BySpringCGLIB")>-1 || 
			   strClassName.indexOf("TokenController")>-1 ||		
					(strClassName.indexOf("com.alisenturk")==-1 &&	
					 strClassName.indexOf("com.apart")==-1 &&
					 strClassName.indexOf("com.dhtmlx")==-1 &&
					 strClassName.indexOf("PageExpiryFilter")==-1 )
			  )continue;
			
			
			if("true".equals(useElasticLogger)){
				error = new ErrorData();
				error.setProject("UrlShorter");
				error.setHostName(Helper.getServerIPAddress());
				error.setErrorDate(Helper.date2String(new Date()));
				error.setErrorTime(Helper.date2String(new Date(),"HH:mm:ss.SSS"));
				error.setFileName(strFileName);
				error.setClassName(strClassName);
				error.setLineNumber(strLineNumber);
				error.setUserName(userName);
				error.setErrorMessage(strErrorMessage);
				error.setExtraInfo(extraInfo);
				error.setProcessTime(Helper.date2String(new Date(),"yyyyMMddHHmmss"));
				errorList.add(error);
			}else{
				System.out.println("URLShorter" + "|" + serverName + "|" + strDate+"|" + time + "|" + strFileName + "|" + strClassName + "|" +strMethodName+ "|" + strLineNumber + "|" + userName+ "|" + strErrorMessage + "|" + exception + "|" + extraInfo);
			}
		}
		
		
	}
	
	
	public String getStrClassName() {
		return strClassName;
	}

	public void setStrClassName(String strClassName) {
		this.strClassName = strClassName;
	}

	public String getStrFileName() {
		return strFileName;
	}

	public void setStrFileName(String strFileName) {
		this.strFileName = strFileName;
	}

	public String getStrLineNumber() {
		return strLineNumber;
	}

	public void setStrLineNumber(String strLineNumber) {
		this.strLineNumber = strLineNumber;
	}

	public String getStrMethodName() {
		return strMethodName;
	}

	public void setStrMethodName(String strMethodName) {
		this.strMethodName = strMethodName;
	}

	public String getStrErrorMessage() {
		return strErrorMessage;
	}

	public void setStrErrorMessage(String strErrorMessage) {
		this.strErrorMessage = strErrorMessage;
	}

	public Class getClassName() {
		return className;
	}

	public void setClassName(Class className) {
		this.className = className;
	}

	public String getLogtype() {
		return logtype;
	}

	public void setLogtype(String logtype) {
		this.logtype = logtype;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	public String getExtraInfo() {
		return extraInfo;
	}

	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	

}
