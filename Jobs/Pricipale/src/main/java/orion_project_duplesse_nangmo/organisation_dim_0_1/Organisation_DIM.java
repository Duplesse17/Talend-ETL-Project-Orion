// ============================================================================
//
// Copyright (c) 2006-2015, Talend SA
//
// Ce code source a été automatiquement généré par_Talend Open Studio for Data Integration
// / Soumis à la Licence Apache, Version 2.0 (la "Licence") ;
// votre utilisation de ce fichier doit respecter les termes de la Licence.
// Vous pouvez obtenir une copie de la Licence sur
// http://www.apache.org/licenses/LICENSE-2.0
// 
// Sauf lorsqu'explicitement prévu par la loi en vigueur ou accepté par écrit, le logiciel
// distribué sous la Licence est distribué "TEL QUEL",
// SANS GARANTIE OU CONDITION D'AUCUNE SORTE, expresse ou implicite.
// Consultez la Licence pour connaître la terminologie spécifique régissant les autorisations et
// les limites prévues par la Licence.


package orion_project_duplesse_nangmo.organisation_dim_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;
 




	//the import part of tJava_1
	//import java.util.List;

	//the import part of tJava_2
	//import java.util.List;

	//the import part of tJava_3
	//import java.util.List;


@SuppressWarnings("unused")

/**
 * Job: Organisation_DIM Purpose: remplir la dimension organisation du dw<br>
 * Description: utilisation des fichier organisation et staff <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class Organisation_DIM implements TalendJob {

protected static void logIgnoredError(String message, Throwable cause) {
       System.err.println(message);
       if (cause != null) {
               cause.printStackTrace();
       }

}


	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}
	private Object[] multiThreadLockWrite = new Object[0];
	
	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	
	private final static String utf8Charset = "UTF-8";
	//contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String,String> propertyTypes = new java.util.HashMap<>();
		
		public PropertiesWithType(java.util.Properties properties){
			super(properties);
		}
		public PropertiesWithType(){
			super();
		}
		
		public void setContextType(String key, String type) {
			propertyTypes.put(key,type);
		}
	
		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}
	
	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();
	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties){
			super(properties);
		}
		public ContextProperties(){
			super();
		}

		public void synchronizeContext(){
			
		}
		
		//if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if(NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

	}
	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.
	public ContextProperties getContext() {
		return this.context;
	}
	private final String jobVersion = "0.1";
	private final String jobName = "Organisation_DIM";
	private final String projectName = "ORION_PROJECT_DUPLESSE_NANGMO";
	public Integer errorCode = null;
	private String currentComponent = "";
	
		private final java.util.Map<String, Object> globalMap = java.util.Collections.synchronizedMap(new java.util.HashMap<String, Object>());
		
	
		private final java.util.Map<String, Long> start_Hash = java.util.Collections.synchronizedMap(new java.util.HashMap<String, Long>());
		private final java.util.Map<String, Long> end_Hash = java.util.Collections.synchronizedMap(new java.util.HashMap<String, Long>());
		private final java.util.Map<String, Boolean> ok_Hash = java.util.Collections.synchronizedMap(new java.util.HashMap<String, Boolean>());
		public  final java.util.List<String[]> globalBuffer = java.util.Collections.synchronizedList(new java.util.ArrayList<String[]>());
	

private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";
	
	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(), new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}
	
	public void setDataSourceReferences(List serviceReferences) throws Exception{
		
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();
		
		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils.getServices(serviceReferences,  javax.sql.DataSource.class).entrySet()) {
                    dataSources.put(entry.getKey(), entry.getValue());
                    talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}


private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

public String getExceptionStackTrace() {
	if ("failure".equals(this.getStatus())) {
		errorMessagePS.flush();
		return baos.toString();
	}
	return null;
}

private Exception exception;

public Exception getException() {
	if ("failure".equals(this.getStatus())) {
		return this.exception;
	}
	return null;
}

private class TalendException extends Exception {

	private static final long serialVersionUID = 1L;

	private java.util.Map<String, Object> globalMap = null;
	private Exception e = null;
	private String currentComponent = null;
	private String virtualComponentName = null;
	
	public void setVirtualComponentName (String virtualComponentName){
		this.virtualComponentName = virtualComponentName;
	}

	private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
		this.currentComponent= errorComponent;
		this.globalMap = globalMap;
		this.e = e;
	}

	public Exception getException() {
		return this.e;
	}

	public String getCurrentComponent() {
		return this.currentComponent;
	}

	
    public String getExceptionCauseMessage(Exception e){
        Throwable cause = e;
        String message = null;
        int i = 10;
        while (null != cause && 0 < i--) {
            message = cause.getMessage();
            if (null == message) {
                cause = cause.getCause();
            } else {
                break;          
            }
        }
        if (null == message) {
            message = e.getClass().getName();
        }   
        return message;
    }

	@Override
	public void printStackTrace() {
		if (!(e instanceof TalendException || e instanceof TDieException)) {
			if(virtualComponentName!=null && currentComponent.indexOf(virtualComponentName+"_")==0){
				globalMap.put(virtualComponentName+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			}
			globalMap.put(currentComponent+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
		}
		if (!(e instanceof TDieException)) {
			if(e instanceof TalendException){
				e.printStackTrace();
			} else {
				e.printStackTrace();
				e.printStackTrace(errorMessagePS);
				Organisation_DIM.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(Organisation_DIM.this, new Object[] { e , currentComponent, globalMap});
					break;
				}
			}

			if(!(e instanceof TDieException)){
			}
		} catch (Exception e) {
			this.e.printStackTrace();
		}
		}
	}
}

			public void tPrejob_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tPrejob_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBConnection_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBConnection_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBConnection_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBConnection_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tPostjob_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tPostjob_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBClose_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBClose_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBClose_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBClose_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_5_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
						try {
							
								if(this.execStat){
									runStat.updateStatOnConnection("OnComponentError1", 0, "error");
								}
							
							
								((java.util.Map)threadLocal.get()).put("errorCode", null);
								tDBRollback_1Process(globalMap);
								if ( !"failure".equals(((java.util.Map)threadLocal.get()).get("status")) ) {
									((java.util.Map)threadLocal.get()).put("status", "end");
								}
								

						} catch (Exception e) {
							e.printStackTrace();
						}
						
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tLogRow_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tJava_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tJava_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tSendMail_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
					tSendMail_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tJava_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tJava_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tJava_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tJava_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBCommit_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBCommit_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBRollback_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBRollback_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_5_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputExcel_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_group_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_section_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_departement_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_compagny_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_staff_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tPrejob_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBConnection_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBConnection_2_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tPostjob_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBClose_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBClose_2_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBInput_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tJava_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tSendMail_2_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "ERROR", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

				try {
					
						if(this.execStat){
							runStat.updateStatOnConnection("OnSubjobError1", 0, "error");
						}
					
					((java.util.Map)threadLocal.get()).put("errorCode", null);
					tJava_3Process(globalMap);
					if ( !"failure".equals(((java.util.Map)threadLocal.get()).get("status")) ) {
						((java.util.Map)threadLocal.get()).put("status", "end");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			public void tJava_2_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tJava_3_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBCommit_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBRollback_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	





public void tPrejob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tPrejob_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tPrejob_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tPrejob_1", false);
		start_Hash.put("tPrejob_1", System.currentTimeMillis());
		
	
	currentComponent="tPrejob_1";

	
		int tos_count_tPrejob_1 = 0;
		

 



/**
 * [tPrejob_1 begin ] stop
 */
	
	/**
	 * [tPrejob_1 main ] start
	 */

	

	
	
	currentComponent="tPrejob_1";

	

 


	tos_count_tPrejob_1++;

/**
 * [tPrejob_1 main ] stop
 */
	
	/**
	 * [tPrejob_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tPrejob_1";

	

 



/**
 * [tPrejob_1 process_data_begin ] stop
 */
	
	/**
	 * [tPrejob_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tPrejob_1";

	

 



/**
 * [tPrejob_1 process_data_end ] stop
 */
	
	/**
	 * [tPrejob_1 end ] start
	 */

	

	
	
	currentComponent="tPrejob_1";

	

 

ok_Hash.put("tPrejob_1", true);
end_Hash.put("tPrejob_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk1", 0, "ok");
				}
				tDBConnection_1Process(globalMap);



/**
 * [tPrejob_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tPrejob_1 finally ] start
	 */

	

	
	
	currentComponent="tPrejob_1";

	

 



/**
 * [tPrejob_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tPrejob_1_SUBPROCESS_STATE", 1);
	}
	

public void tDBConnection_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBConnection_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tDBConnection_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBConnection_1", false);
		start_Hash.put("tDBConnection_1", System.currentTimeMillis());
		
	
	currentComponent="tDBConnection_1";

	
		int tos_count_tDBConnection_1 = 0;
		


	
		String url_tDBConnection_1 = "jdbc:sqlite:" + "/" + "/home/duplesse/Musique/TP_BI/BDOrion.sqlite"; 
	String dbUser_tDBConnection_1 = null;
	
	
		String dbPwd_tDBConnection_1 = null;
	
	
	java.sql.Connection conn_tDBConnection_1 = null;
	
					String driverClass_tDBConnection_1 = "org.sqlite.JDBC";
			java.lang.Class jdbcclazz_tDBConnection_1 = java.lang.Class.forName(driverClass_tDBConnection_1);
			globalMap.put("driverClass_tDBConnection_1", driverClass_tDBConnection_1);
		
		conn_tDBConnection_1 = java.sql.DriverManager.getConnection(url_tDBConnection_1);

		globalMap.put("conn_tDBConnection_1", conn_tDBConnection_1);
	if (null != conn_tDBConnection_1) {
		
			conn_tDBConnection_1.setAutoCommit(false);
	}


 



/**
 * [tDBConnection_1 begin ] stop
 */
	
	/**
	 * [tDBConnection_1 main ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";

	

 


	tos_count_tDBConnection_1++;

/**
 * [tDBConnection_1 main ] stop
 */
	
	/**
	 * [tDBConnection_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";

	

 



/**
 * [tDBConnection_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBConnection_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";

	

 



/**
 * [tDBConnection_1 process_data_end ] stop
 */
	
	/**
	 * [tDBConnection_1 end ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";

	

 

ok_Hash.put("tDBConnection_1", true);
end_Hash.put("tDBConnection_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk6", 0, "ok");
				}
				tDBConnection_2Process(globalMap);



/**
 * [tDBConnection_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBConnection_1 finally ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";

	

 



/**
 * [tDBConnection_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBConnection_1_SUBPROCESS_STATE", 1);
	}
	

public void tDBConnection_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBConnection_2_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tDBConnection_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBConnection_2", false);
		start_Hash.put("tDBConnection_2", System.currentTimeMillis());
		
	
	currentComponent="tDBConnection_2";

	
		int tos_count_tDBConnection_2 = 0;
		
	

	
        String properties_tDBConnection_2 = "useSSL=false&allowPublicKeyRetrieval=true";
        if (properties_tDBConnection_2 == null || properties_tDBConnection_2.trim().length() == 0) {
            properties_tDBConnection_2 = "rewriteBatchedStatements=true&allowLoadLocalInfile=true";
        }else {
            if (!properties_tDBConnection_2.contains("rewriteBatchedStatements=")) {
                properties_tDBConnection_2 += "&rewriteBatchedStatements=true";
            }

            if (!properties_tDBConnection_2.contains("allowLoadLocalInfile=")) {
                properties_tDBConnection_2 += "&allowLoadLocalInfile=true";
            }
        }

        String url_tDBConnection_2 = "jdbc:mariadb://" + "127.0.0.1" + ":" + "3306" + "/" + "db_entrepot" + "?" + properties_tDBConnection_2;
	String dbUser_tDBConnection_2 = "orion_DW_user";
	
	
		 
	final String decryptedPassword_tDBConnection_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:gXb7jQnDqxPcRX83CWlfBakraCbkM8eHeWf8TYfN1WEmDvmUZZEh6ZY=");
		String dbPwd_tDBConnection_2 = decryptedPassword_tDBConnection_2;
	
	
	java.sql.Connection conn_tDBConnection_2 = null;
	
		
			String driverClass_tDBConnection_2 = "org.mariadb.jdbc.Driver";
			java.lang.Class jdbcclazz_tDBConnection_2 = java.lang.Class.forName(driverClass_tDBConnection_2);
			globalMap.put("driverClass_tDBConnection_2", driverClass_tDBConnection_2);
		
			conn_tDBConnection_2 = java.sql.DriverManager.getConnection(url_tDBConnection_2,dbUser_tDBConnection_2,dbPwd_tDBConnection_2);

		globalMap.put("conn_tDBConnection_2", conn_tDBConnection_2);
	if (null != conn_tDBConnection_2) {
		
			conn_tDBConnection_2.setAutoCommit(false);
	}

	globalMap.put("db_tDBConnection_2","db_entrepot");
 



/**
 * [tDBConnection_2 begin ] stop
 */
	
	/**
	 * [tDBConnection_2 main ] start
	 */

	

	
	
	currentComponent="tDBConnection_2";

	

 


	tos_count_tDBConnection_2++;

/**
 * [tDBConnection_2 main ] stop
 */
	
	/**
	 * [tDBConnection_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBConnection_2";

	

 



/**
 * [tDBConnection_2 process_data_begin ] stop
 */
	
	/**
	 * [tDBConnection_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBConnection_2";

	

 



/**
 * [tDBConnection_2 process_data_end ] stop
 */
	
	/**
	 * [tDBConnection_2 end ] start
	 */

	

	
	
	currentComponent="tDBConnection_2";

	

 

ok_Hash.put("tDBConnection_2", true);
end_Hash.put("tDBConnection_2", System.currentTimeMillis());




/**
 * [tDBConnection_2 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBConnection_2 finally ] start
	 */

	

	
	
	currentComponent="tDBConnection_2";

	

 



/**
 * [tDBConnection_2 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBConnection_2_SUBPROCESS_STATE", 1);
	}
	

public void tPostjob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tPostjob_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tPostjob_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tPostjob_1", false);
		start_Hash.put("tPostjob_1", System.currentTimeMillis());
		
	
	currentComponent="tPostjob_1";

	
		int tos_count_tPostjob_1 = 0;
		

 



/**
 * [tPostjob_1 begin ] stop
 */
	
	/**
	 * [tPostjob_1 main ] start
	 */

	

	
	
	currentComponent="tPostjob_1";

	

 


	tos_count_tPostjob_1++;

/**
 * [tPostjob_1 main ] stop
 */
	
	/**
	 * [tPostjob_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tPostjob_1";

	

 



/**
 * [tPostjob_1 process_data_begin ] stop
 */
	
	/**
	 * [tPostjob_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tPostjob_1";

	

 



/**
 * [tPostjob_1 process_data_end ] stop
 */
	
	/**
	 * [tPostjob_1 end ] start
	 */

	

	
	
	currentComponent="tPostjob_1";

	

 

ok_Hash.put("tPostjob_1", true);
end_Hash.put("tPostjob_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk2", 0, "ok");
				}
				tDBClose_1Process(globalMap);



/**
 * [tPostjob_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tPostjob_1 finally ] start
	 */

	

	
	
	currentComponent="tPostjob_1";

	

 



/**
 * [tPostjob_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tPostjob_1_SUBPROCESS_STATE", 1);
	}
	

public void tDBClose_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBClose_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tDBClose_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBClose_1", false);
		start_Hash.put("tDBClose_1", System.currentTimeMillis());
		
	
	currentComponent="tDBClose_1";

	
		int tos_count_tDBClose_1 = 0;
		

 



/**
 * [tDBClose_1 begin ] stop
 */
	
	/**
	 * [tDBClose_1 main ] start
	 */

	

	
	
	currentComponent="tDBClose_1";

	



	java.sql.Connection conn_tDBClose_1 = (java.sql.Connection)globalMap.get("conn_tDBConnection_1");
	if(conn_tDBClose_1 != null && !conn_tDBClose_1.isClosed())
	{
        conn_tDBClose_1.close();
	}

 


	tos_count_tDBClose_1++;

/**
 * [tDBClose_1 main ] stop
 */
	
	/**
	 * [tDBClose_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBClose_1";

	

 



/**
 * [tDBClose_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBClose_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBClose_1";

	

 



/**
 * [tDBClose_1 process_data_end ] stop
 */
	
	/**
	 * [tDBClose_1 end ] start
	 */

	

	
	
	currentComponent="tDBClose_1";

	

 

ok_Hash.put("tDBClose_1", true);
end_Hash.put("tDBClose_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk7", 0, "ok");
				}
				tDBClose_2Process(globalMap);



/**
 * [tDBClose_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBClose_1 finally ] start
	 */

	

	
	
	currentComponent="tDBClose_1";

	

 



/**
 * [tDBClose_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBClose_1_SUBPROCESS_STATE", 1);
	}
	

public void tDBClose_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBClose_2_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tDBClose_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBClose_2", false);
		start_Hash.put("tDBClose_2", System.currentTimeMillis());
		
	
	currentComponent="tDBClose_2";

	
		int tos_count_tDBClose_2 = 0;
		

 



/**
 * [tDBClose_2 begin ] stop
 */
	
	/**
	 * [tDBClose_2 main ] start
	 */

	

	
	
	currentComponent="tDBClose_2";

	

	java.sql.Connection conn_tDBClose_2 = (java.sql.Connection)globalMap.get("conn_tDBConnection_2");

	if(conn_tDBClose_2 != null && !conn_tDBClose_2.isClosed())
	{
		
			conn_tDBClose_2.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_tDBConnection_2"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	}

 


	tos_count_tDBClose_2++;

/**
 * [tDBClose_2 main ] stop
 */
	
	/**
	 * [tDBClose_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBClose_2";

	

 



/**
 * [tDBClose_2 process_data_begin ] stop
 */
	
	/**
	 * [tDBClose_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBClose_2";

	

 



/**
 * [tDBClose_2 process_data_end ] stop
 */
	
	/**
	 * [tDBClose_2 end ] start
	 */

	

	
	
	currentComponent="tDBClose_2";

	

 

ok_Hash.put("tDBClose_2", true);
end_Hash.put("tDBClose_2", System.currentTimeMillis());




/**
 * [tDBClose_2 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBClose_2 finally ] start
	 */

	

	
	
	currentComponent="tDBClose_2";

	

 



/**
 * [tDBClose_2 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBClose_2_SUBPROCESS_STATE", 1);
	}
	


public static class row7Struct implements routines.system.IPersistableRow<row7Struct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public double Employee_ID;

				public double getEmployee_ID () {
					return this.Employee_ID;
				}
				
			    public String Employee_Country;

				public String getEmployee_Country () {
					return this.Employee_Country;
				}
				
			    public String Company;

				public String getCompany () {
					return this.Company;
				}
				
			    public String Department;

				public String getDepartment () {
					return this.Department;
				}
				
			    public String Section;

				public String getSection () {
					return this.Section;
				}
				
			    public String Org_Group;

				public String getOrg_Group () {
					return this.Org_Group;
				}
				
			    public String Job_Title;

				public String getJob_Title () {
					return this.Job_Title;
				}
				
			    public String Employee_Name;

				public String getEmployee_Name () {
					return this.Employee_Name;
				}
				
			    public String Employee_Gender;

				public String getEmployee_Gender () {
					return this.Employee_Gender;
				}
				
			    public BigDecimal Salary;

				public BigDecimal getSalary () {
					return this.Salary;
				}
				
			    public java.util.Date Employee_Birth_Date;

				public java.util.Date getEmployee_Birth_Date () {
					return this.Employee_Birth_Date;
				}
				
			    public java.util.Date Employee_Hire_Date;

				public java.util.Date getEmployee_Hire_Date () {
					return this.Employee_Hire_Date;
				}
				
			    public java.util.Date Employee_Term_Date;

				public java.util.Date getEmployee_Term_Date () {
					return this.Employee_Term_Date;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.Employee_ID;
						
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row7Struct other = (row7Struct) obj;
		
						if (this.Employee_ID != other.Employee_ID)
							return false;
					

		return true;
    }

	public void copyDataTo(row7Struct other) {

		other.Employee_ID = this.Employee_ID;
	            other.Employee_Country = this.Employee_Country;
	            other.Company = this.Company;
	            other.Department = this.Department;
	            other.Section = this.Section;
	            other.Org_Group = this.Org_Group;
	            other.Job_Title = this.Job_Title;
	            other.Employee_Name = this.Employee_Name;
	            other.Employee_Gender = this.Employee_Gender;
	            other.Salary = this.Salary;
	            other.Employee_Birth_Date = this.Employee_Birth_Date;
	            other.Employee_Hire_Date = this.Employee_Hire_Date;
	            other.Employee_Term_Date = this.Employee_Term_Date;
	            
	}

	public void copyKeysDataTo(row7Struct other) {

		other.Employee_ID = this.Employee_ID;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM) {

        	try {

        		int length = 0;
		
			        this.Employee_ID = dis.readDouble();
					
					this.Employee_Country = readString(dis);
					
					this.Company = readString(dis);
					
					this.Department = readString(dis);
					
					this.Section = readString(dis);
					
					this.Org_Group = readString(dis);
					
					this.Job_Title = readString(dis);
					
					this.Employee_Name = readString(dis);
					
					this.Employee_Gender = readString(dis);
					
						this.Salary = (BigDecimal) dis.readObject();
					
					this.Employee_Birth_Date = readDate(dis);
					
					this.Employee_Hire_Date = readDate(dis);
					
					this.Employee_Term_Date = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM) {

        	try {

        		int length = 0;
		
			        this.Employee_ID = dis.readDouble();
					
					this.Employee_Country = readString(dis);
					
					this.Company = readString(dis);
					
					this.Department = readString(dis);
					
					this.Section = readString(dis);
					
					this.Org_Group = readString(dis);
					
					this.Job_Title = readString(dis);
					
					this.Employee_Name = readString(dis);
					
					this.Employee_Gender = readString(dis);
					
						this.Salary = (BigDecimal) dis.readObject();
					
					this.Employee_Birth_Date = readDate(dis);
					
					this.Employee_Hire_Date = readDate(dis);
					
					this.Employee_Term_Date = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.Employee_ID);
					
					// String
				
						writeString(this.Employee_Country,dos);
					
					// String
				
						writeString(this.Company,dos);
					
					// String
				
						writeString(this.Department,dos);
					
					// String
				
						writeString(this.Section,dos);
					
					// String
				
						writeString(this.Org_Group,dos);
					
					// String
				
						writeString(this.Job_Title,dos);
					
					// String
				
						writeString(this.Employee_Name,dos);
					
					// String
				
						writeString(this.Employee_Gender,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.Salary);
					
					// java.util.Date
				
						writeDate(this.Employee_Birth_Date,dos);
					
					// java.util.Date
				
						writeDate(this.Employee_Hire_Date,dos);
					
					// java.util.Date
				
						writeDate(this.Employee_Term_Date,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.Employee_ID);
					
					// String
				
						writeString(this.Employee_Country,dos);
					
					// String
				
						writeString(this.Company,dos);
					
					// String
				
						writeString(this.Department,dos);
					
					// String
				
						writeString(this.Section,dos);
					
					// String
				
						writeString(this.Org_Group,dos);
					
					// String
				
						writeString(this.Job_Title,dos);
					
					// String
				
						writeString(this.Employee_Name,dos);
					
					// String
				
						writeString(this.Employee_Gender,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.Salary);
					
					// java.util.Date
				
						writeDate(this.Employee_Birth_Date,dos);
					
					// java.util.Date
				
						writeDate(this.Employee_Hire_Date,dos);
					
					// java.util.Date
				
						writeDate(this.Employee_Term_Date,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Employee_ID="+String.valueOf(Employee_ID));
		sb.append(",Employee_Country="+Employee_Country);
		sb.append(",Company="+Company);
		sb.append(",Department="+Department);
		sb.append(",Section="+Section);
		sb.append(",Org_Group="+Org_Group);
		sb.append(",Job_Title="+Job_Title);
		sb.append(",Employee_Name="+Employee_Name);
		sb.append(",Employee_Gender="+Employee_Gender);
		sb.append(",Salary="+String.valueOf(Salary));
		sb.append(",Employee_Birth_Date="+String.valueOf(Employee_Birth_Date));
		sb.append(",Employee_Hire_Date="+String.valueOf(Employee_Hire_Date));
		sb.append(",Employee_Term_Date="+String.valueOf(Employee_Term_Date));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row7Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.Employee_ID, other.Employee_ID);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class fitre_finalStruct implements routines.system.IPersistableRow<fitre_finalStruct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public double Employee_ID;

				public double getEmployee_ID () {
					return this.Employee_ID;
				}
				
			    public String Employee_Country;

				public String getEmployee_Country () {
					return this.Employee_Country;
				}
				
			    public String Company;

				public String getCompany () {
					return this.Company;
				}
				
			    public String Department;

				public String getDepartment () {
					return this.Department;
				}
				
			    public String Section;

				public String getSection () {
					return this.Section;
				}
				
			    public String Org_Group;

				public String getOrg_Group () {
					return this.Org_Group;
				}
				
			    public String Job_Title;

				public String getJob_Title () {
					return this.Job_Title;
				}
				
			    public String Employee_Name;

				public String getEmployee_Name () {
					return this.Employee_Name;
				}
				
			    public String Employee_Gender;

				public String getEmployee_Gender () {
					return this.Employee_Gender;
				}
				
			    public BigDecimal Salary;

				public BigDecimal getSalary () {
					return this.Salary;
				}
				
			    public java.util.Date Employee_Birth_Date;

				public java.util.Date getEmployee_Birth_Date () {
					return this.Employee_Birth_Date;
				}
				
			    public java.util.Date Employee_Hire_Date;

				public java.util.Date getEmployee_Hire_Date () {
					return this.Employee_Hire_Date;
				}
				
			    public java.util.Date Employee_Term_Date;

				public java.util.Date getEmployee_Term_Date () {
					return this.Employee_Term_Date;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.Employee_ID;
						
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final fitre_finalStruct other = (fitre_finalStruct) obj;
		
						if (this.Employee_ID != other.Employee_ID)
							return false;
					

		return true;
    }

	public void copyDataTo(fitre_finalStruct other) {

		other.Employee_ID = this.Employee_ID;
	            other.Employee_Country = this.Employee_Country;
	            other.Company = this.Company;
	            other.Department = this.Department;
	            other.Section = this.Section;
	            other.Org_Group = this.Org_Group;
	            other.Job_Title = this.Job_Title;
	            other.Employee_Name = this.Employee_Name;
	            other.Employee_Gender = this.Employee_Gender;
	            other.Salary = this.Salary;
	            other.Employee_Birth_Date = this.Employee_Birth_Date;
	            other.Employee_Hire_Date = this.Employee_Hire_Date;
	            other.Employee_Term_Date = this.Employee_Term_Date;
	            
	}

	public void copyKeysDataTo(fitre_finalStruct other) {

		other.Employee_ID = this.Employee_ID;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM) {

        	try {

        		int length = 0;
		
			        this.Employee_ID = dis.readDouble();
					
					this.Employee_Country = readString(dis);
					
					this.Company = readString(dis);
					
					this.Department = readString(dis);
					
					this.Section = readString(dis);
					
					this.Org_Group = readString(dis);
					
					this.Job_Title = readString(dis);
					
					this.Employee_Name = readString(dis);
					
					this.Employee_Gender = readString(dis);
					
						this.Salary = (BigDecimal) dis.readObject();
					
					this.Employee_Birth_Date = readDate(dis);
					
					this.Employee_Hire_Date = readDate(dis);
					
					this.Employee_Term_Date = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM) {

        	try {

        		int length = 0;
		
			        this.Employee_ID = dis.readDouble();
					
					this.Employee_Country = readString(dis);
					
					this.Company = readString(dis);
					
					this.Department = readString(dis);
					
					this.Section = readString(dis);
					
					this.Org_Group = readString(dis);
					
					this.Job_Title = readString(dis);
					
					this.Employee_Name = readString(dis);
					
					this.Employee_Gender = readString(dis);
					
						this.Salary = (BigDecimal) dis.readObject();
					
					this.Employee_Birth_Date = readDate(dis);
					
					this.Employee_Hire_Date = readDate(dis);
					
					this.Employee_Term_Date = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.Employee_ID);
					
					// String
				
						writeString(this.Employee_Country,dos);
					
					// String
				
						writeString(this.Company,dos);
					
					// String
				
						writeString(this.Department,dos);
					
					// String
				
						writeString(this.Section,dos);
					
					// String
				
						writeString(this.Org_Group,dos);
					
					// String
				
						writeString(this.Job_Title,dos);
					
					// String
				
						writeString(this.Employee_Name,dos);
					
					// String
				
						writeString(this.Employee_Gender,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.Salary);
					
					// java.util.Date
				
						writeDate(this.Employee_Birth_Date,dos);
					
					// java.util.Date
				
						writeDate(this.Employee_Hire_Date,dos);
					
					// java.util.Date
				
						writeDate(this.Employee_Term_Date,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.Employee_ID);
					
					// String
				
						writeString(this.Employee_Country,dos);
					
					// String
				
						writeString(this.Company,dos);
					
					// String
				
						writeString(this.Department,dos);
					
					// String
				
						writeString(this.Section,dos);
					
					// String
				
						writeString(this.Org_Group,dos);
					
					// String
				
						writeString(this.Job_Title,dos);
					
					// String
				
						writeString(this.Employee_Name,dos);
					
					// String
				
						writeString(this.Employee_Gender,dos);
					
					// BigDecimal
				
       			    	dos.writeObject(this.Salary);
					
					// java.util.Date
				
						writeDate(this.Employee_Birth_Date,dos);
					
					// java.util.Date
				
						writeDate(this.Employee_Hire_Date,dos);
					
					// java.util.Date
				
						writeDate(this.Employee_Term_Date,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Employee_ID="+String.valueOf(Employee_ID));
		sb.append(",Employee_Country="+Employee_Country);
		sb.append(",Company="+Company);
		sb.append(",Department="+Department);
		sb.append(",Section="+Section);
		sb.append(",Org_Group="+Org_Group);
		sb.append(",Job_Title="+Job_Title);
		sb.append(",Employee_Name="+Employee_Name);
		sb.append(",Employee_Gender="+Employee_Gender);
		sb.append(",Salary="+String.valueOf(Salary));
		sb.append(",Employee_Birth_Date="+String.valueOf(Employee_Birth_Date));
		sb.append(",Employee_Hire_Date="+String.valueOf(Employee_Hire_Date));
		sb.append(",Employee_Term_Date="+String.valueOf(Employee_Term_Date));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(fitre_finalStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.Employee_ID, other.Employee_ID);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class filtrage_4Struct implements routines.system.IPersistableRow<filtrage_4Struct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[0];

	
			    public double employe_id;

				public double getEmploye_id () {
					return this.employe_id;
				}
				
			    public String employee_country;

				public String getEmployee_country () {
					return this.employee_country;
				}
				
			    public String employer_compagny;

				public String getEmployer_compagny () {
					return this.employer_compagny;
				}
				
			    public String employee_departement;

				public String getEmployee_departement () {
					return this.employee_departement;
				}
				
			    public String employee_section;

				public String getEmployee_section () {
					return this.employee_section;
				}
				
			    public String org_group;

				public String getOrg_group () {
					return this.org_group;
				}
				
			    public String employee_name;

				public String getEmployee_name () {
					return this.employee_name;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM) {

        	try {

        		int length = 0;
		
			        this.employe_id = dis.readDouble();
					
					this.employee_country = readString(dis);
					
					this.employer_compagny = readString(dis);
					
					this.employee_departement = readString(dis);
					
					this.employee_section = readString(dis);
					
					this.org_group = readString(dis);
					
					this.employee_name = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM) {

        	try {

        		int length = 0;
		
			        this.employe_id = dis.readDouble();
					
					this.employee_country = readString(dis);
					
					this.employer_compagny = readString(dis);
					
					this.employee_departement = readString(dis);
					
					this.employee_section = readString(dis);
					
					this.org_group = readString(dis);
					
					this.employee_name = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.employe_id);
					
					// String
				
						writeString(this.employee_country,dos);
					
					// String
				
						writeString(this.employer_compagny,dos);
					
					// String
				
						writeString(this.employee_departement,dos);
					
					// String
				
						writeString(this.employee_section,dos);
					
					// String
				
						writeString(this.org_group,dos);
					
					// String
				
						writeString(this.employee_name,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.employe_id);
					
					// String
				
						writeString(this.employee_country,dos);
					
					// String
				
						writeString(this.employer_compagny,dos);
					
					// String
				
						writeString(this.employee_departement,dos);
					
					// String
				
						writeString(this.employee_section,dos);
					
					// String
				
						writeString(this.org_group,dos);
					
					// String
				
						writeString(this.employee_name,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("employe_id="+String.valueOf(employe_id));
		sb.append(",employee_country="+employee_country);
		sb.append(",employer_compagny="+employer_compagny);
		sb.append(",employee_departement="+employee_departement);
		sb.append(",employee_section="+employee_section);
		sb.append(",org_group="+org_group);
		sb.append(",employee_name="+employee_name);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(filtrage_4Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class filtrage_3Struct implements routines.system.IPersistableRow<filtrage_3Struct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[0];

	
			    public double employe_id;

				public double getEmploye_id () {
					return this.employe_id;
				}
				
			    public String employee_country;

				public String getEmployee_country () {
					return this.employee_country;
				}
				
			    public String employee_departement;

				public String getEmployee_departement () {
					return this.employee_departement;
				}
				
			    public String employee_section;

				public String getEmployee_section () {
					return this.employee_section;
				}
				
			    public String employee_group;

				public String getEmployee_group () {
					return this.employee_group;
				}
				
			    public Double org_ref_id;

				public Double getOrg_ref_id () {
					return this.org_ref_id;
				}
				
			    public String employee_name;

				public String getEmployee_name () {
					return this.employee_name;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM) {

        	try {

        		int length = 0;
		
			        this.employe_id = dis.readDouble();
					
					this.employee_country = readString(dis);
					
					this.employee_departement = readString(dis);
					
					this.employee_section = readString(dis);
					
					this.employee_group = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.org_ref_id = null;
           				} else {
           			    	this.org_ref_id = dis.readDouble();
           				}
					
					this.employee_name = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM) {

        	try {

        		int length = 0;
		
			        this.employe_id = dis.readDouble();
					
					this.employee_country = readString(dis);
					
					this.employee_departement = readString(dis);
					
					this.employee_section = readString(dis);
					
					this.employee_group = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.org_ref_id = null;
           				} else {
           			    	this.org_ref_id = dis.readDouble();
           				}
					
					this.employee_name = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.employe_id);
					
					// String
				
						writeString(this.employee_country,dos);
					
					// String
				
						writeString(this.employee_departement,dos);
					
					// String
				
						writeString(this.employee_section,dos);
					
					// String
				
						writeString(this.employee_group,dos);
					
					// Double
				
						if(this.org_ref_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.org_ref_id);
		            	}
					
					// String
				
						writeString(this.employee_name,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.employe_id);
					
					// String
				
						writeString(this.employee_country,dos);
					
					// String
				
						writeString(this.employee_departement,dos);
					
					// String
				
						writeString(this.employee_section,dos);
					
					// String
				
						writeString(this.employee_group,dos);
					
					// Double
				
						if(this.org_ref_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.org_ref_id);
		            	}
					
					// String
				
						writeString(this.employee_name,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("employe_id="+String.valueOf(employe_id));
		sb.append(",employee_country="+employee_country);
		sb.append(",employee_departement="+employee_departement);
		sb.append(",employee_section="+employee_section);
		sb.append(",employee_group="+employee_group);
		sb.append(",org_ref_id="+String.valueOf(org_ref_id));
		sb.append(",employee_name="+employee_name);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(filtrage_3Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class filtrage_2Struct implements routines.system.IPersistableRow<filtrage_2Struct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[0];

	
			    public double employee_id;

				public double getEmployee_id () {
					return this.employee_id;
				}
				
			    public String employer_name;

				public String getEmployer_name () {
					return this.employer_name;
				}
				
			    public String employee_section;

				public String getEmployee_section () {
					return this.employee_section;
				}
				
			    public String employee_group;

				public String getEmployee_group () {
					return this.employee_group;
				}
				
			    public String employee_country;

				public String getEmployee_country () {
					return this.employee_country;
				}
				
			    public Double org_ref_id;

				public Double getOrg_ref_id () {
					return this.org_ref_id;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM) {

        	try {

        		int length = 0;
		
			        this.employee_id = dis.readDouble();
					
					this.employer_name = readString(dis);
					
					this.employee_section = readString(dis);
					
					this.employee_group = readString(dis);
					
					this.employee_country = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.org_ref_id = null;
           				} else {
           			    	this.org_ref_id = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM) {

        	try {

        		int length = 0;
		
			        this.employee_id = dis.readDouble();
					
					this.employer_name = readString(dis);
					
					this.employee_section = readString(dis);
					
					this.employee_group = readString(dis);
					
					this.employee_country = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.org_ref_id = null;
           				} else {
           			    	this.org_ref_id = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.employee_id);
					
					// String
				
						writeString(this.employer_name,dos);
					
					// String
				
						writeString(this.employee_section,dos);
					
					// String
				
						writeString(this.employee_group,dos);
					
					// String
				
						writeString(this.employee_country,dos);
					
					// Double
				
						if(this.org_ref_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.org_ref_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.employee_id);
					
					// String
				
						writeString(this.employer_name,dos);
					
					// String
				
						writeString(this.employee_section,dos);
					
					// String
				
						writeString(this.employee_group,dos);
					
					// String
				
						writeString(this.employee_country,dos);
					
					// Double
				
						if(this.org_ref_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.org_ref_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("employee_id="+String.valueOf(employee_id));
		sb.append(",employer_name="+employer_name);
		sb.append(",employee_section="+employee_section);
		sb.append(",employee_group="+employee_group);
		sb.append(",employee_country="+employee_country);
		sb.append(",org_ref_id="+String.valueOf(org_ref_id));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(filtrage_2Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class filtrage_1Struct implements routines.system.IPersistableRow<filtrage_1Struct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[0];

	
			    public double id;

				public double getId () {
					return this.id;
				}
				
			    public String name;

				public String getName () {
					return this.name;
				}
				
			    public String country;

				public String getCountry () {
					return this.country;
				}
				
			    public String group;

				public String getGroup () {
					return this.group;
				}
				
			    public Double org_ref_id;

				public Double getOrg_ref_id () {
					return this.org_ref_id;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM) {

        	try {

        		int length = 0;
		
			        this.id = dis.readDouble();
					
					this.name = readString(dis);
					
					this.country = readString(dis);
					
					this.group = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.org_ref_id = null;
           				} else {
           			    	this.org_ref_id = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM) {

        	try {

        		int length = 0;
		
			        this.id = dis.readDouble();
					
					this.name = readString(dis);
					
					this.country = readString(dis);
					
					this.group = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.org_ref_id = null;
           				} else {
           			    	this.org_ref_id = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.id);
					
					// String
				
						writeString(this.name,dos);
					
					// String
				
						writeString(this.country,dos);
					
					// String
				
						writeString(this.group,dos);
					
					// Double
				
						if(this.org_ref_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.org_ref_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.id);
					
					// String
				
						writeString(this.name,dos);
					
					// String
				
						writeString(this.country,dos);
					
					// String
				
						writeString(this.group,dos);
					
					// Double
				
						if(this.org_ref_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.org_ref_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id="+String.valueOf(id));
		sb.append(",name="+name);
		sb.append(",country="+country);
		sb.append(",group="+group);
		sb.append(",org_ref_id="+String.valueOf(org_ref_id));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(filtrage_1Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class employerStruct implements routines.system.IPersistableRow<employerStruct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[0];

	
			    public Double employee_id;

				public Double getEmployee_id () {
					return this.employee_id;
				}
				
			    public String org_name;

				public String getOrg_name () {
					return this.org_name;
				}
				
			    public String country;

				public String getCountry () {
					return this.country;
				}
				
			    public Double org_level;

				public Double getOrg_level () {
					return this.org_level;
				}
				
			    public java.util.Date start_date;

				public java.util.Date getStart_date () {
					return this.start_date;
				}
				
			    public java.util.Date end_date;

				public java.util.Date getEnd_date () {
					return this.end_date;
				}
				
			    public Double org_ref_id;

				public Double getOrg_ref_id () {
					return this.org_ref_id;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.employee_id = null;
           				} else {
           			    	this.employee_id = dis.readDouble();
           				}
					
					this.org_name = readString(dis);
					
					this.country = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.org_level = null;
           				} else {
           			    	this.org_level = dis.readDouble();
           				}
					
					this.start_date = readDate(dis);
					
					this.end_date = readDate(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.org_ref_id = null;
           				} else {
           			    	this.org_ref_id = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.employee_id = null;
           				} else {
           			    	this.employee_id = dis.readDouble();
           				}
					
					this.org_name = readString(dis);
					
					this.country = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.org_level = null;
           				} else {
           			    	this.org_level = dis.readDouble();
           				}
					
					this.start_date = readDate(dis);
					
					this.end_date = readDate(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.org_ref_id = null;
           				} else {
           			    	this.org_ref_id = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Double
				
						if(this.employee_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.employee_id);
		            	}
					
					// String
				
						writeString(this.org_name,dos);
					
					// String
				
						writeString(this.country,dos);
					
					// Double
				
						if(this.org_level == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.org_level);
		            	}
					
					// java.util.Date
				
						writeDate(this.start_date,dos);
					
					// java.util.Date
				
						writeDate(this.end_date,dos);
					
					// Double
				
						if(this.org_ref_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.org_ref_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Double
				
						if(this.employee_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.employee_id);
		            	}
					
					// String
				
						writeString(this.org_name,dos);
					
					// String
				
						writeString(this.country,dos);
					
					// Double
				
						if(this.org_level == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.org_level);
		            	}
					
					// java.util.Date
				
						writeDate(this.start_date,dos);
					
					// java.util.Date
				
						writeDate(this.end_date,dos);
					
					// Double
				
						if(this.org_ref_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.org_ref_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("employee_id="+String.valueOf(employee_id));
		sb.append(",org_name="+org_name);
		sb.append(",country="+country);
		sb.append(",org_level="+String.valueOf(org_level));
		sb.append(",start_date="+String.valueOf(start_date));
		sb.append(",end_date="+String.valueOf(end_date));
		sb.append(",org_ref_id="+String.valueOf(org_ref_id));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(employerStruct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class after_tDBInput_1Struct implements routines.system.IPersistableRow<after_tDBInput_1Struct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public Double employee_id;

				public Double getEmployee_id () {
					return this.employee_id;
				}
				
			    public String org_name;

				public String getOrg_name () {
					return this.org_name;
				}
				
			    public String country;

				public String getCountry () {
					return this.country;
				}
				
			    public Double org_level;

				public Double getOrg_level () {
					return this.org_level;
				}
				
			    public java.util.Date start_date;

				public java.util.Date getStart_date () {
					return this.start_date;
				}
				
			    public java.util.Date end_date;

				public java.util.Date getEnd_date () {
					return this.end_date;
				}
				
			    public Double org_ref_id;

				public Double getOrg_ref_id () {
					return this.org_ref_id;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.employee_id == null) ? 0 : this.employee_id.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final after_tDBInput_1Struct other = (after_tDBInput_1Struct) obj;
		
						if (this.employee_id == null) {
							if (other.employee_id != null)
								return false;
						
						} else if (!this.employee_id.equals(other.employee_id))
						
							return false;
					

		return true;
    }

	public void copyDataTo(after_tDBInput_1Struct other) {

		other.employee_id = this.employee_id;
	            other.org_name = this.org_name;
	            other.country = this.country;
	            other.org_level = this.org_level;
	            other.start_date = this.start_date;
	            other.end_date = this.end_date;
	            other.org_ref_id = this.org_ref_id;
	            
	}

	public void copyKeysDataTo(after_tDBInput_1Struct other) {

		other.employee_id = this.employee_id;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.employee_id = null;
           				} else {
           			    	this.employee_id = dis.readDouble();
           				}
					
					this.org_name = readString(dis);
					
					this.country = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.org_level = null;
           				} else {
           			    	this.org_level = dis.readDouble();
           				}
					
					this.start_date = readDate(dis);
					
					this.end_date = readDate(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.org_ref_id = null;
           				} else {
           			    	this.org_ref_id = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.employee_id = null;
           				} else {
           			    	this.employee_id = dis.readDouble();
           				}
					
					this.org_name = readString(dis);
					
					this.country = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.org_level = null;
           				} else {
           			    	this.org_level = dis.readDouble();
           				}
					
					this.start_date = readDate(dis);
					
					this.end_date = readDate(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.org_ref_id = null;
           				} else {
           			    	this.org_ref_id = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Double
				
						if(this.employee_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.employee_id);
		            	}
					
					// String
				
						writeString(this.org_name,dos);
					
					// String
				
						writeString(this.country,dos);
					
					// Double
				
						if(this.org_level == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.org_level);
		            	}
					
					// java.util.Date
				
						writeDate(this.start_date,dos);
					
					// java.util.Date
				
						writeDate(this.end_date,dos);
					
					// Double
				
						if(this.org_ref_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.org_ref_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Double
				
						if(this.employee_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.employee_id);
		            	}
					
					// String
				
						writeString(this.org_name,dos);
					
					// String
				
						writeString(this.country,dos);
					
					// Double
				
						if(this.org_level == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.org_level);
		            	}
					
					// java.util.Date
				
						writeDate(this.start_date,dos);
					
					// java.util.Date
				
						writeDate(this.end_date,dos);
					
					// Double
				
						if(this.org_ref_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.org_ref_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("employee_id="+String.valueOf(employee_id));
		sb.append(",org_name="+org_name);
		sb.append(",country="+country);
		sb.append(",org_level="+String.valueOf(org_level));
		sb.append(",start_date="+String.valueOf(start_date));
		sb.append(",end_date="+String.valueOf(end_date));
		sb.append(",org_ref_id="+String.valueOf(org_ref_id));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(after_tDBInput_1Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.employee_id, other.employee_id);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;


		tDBInput_2Process(globalMap);
		tDBInput_3Process(globalMap);
		tDBInput_5Process(globalMap);
		tDBInput_4Process(globalMap);
		tFileInputExcel_1Process(globalMap);

		employerStruct employer = new employerStruct();
filtrage_1Struct filtrage_1 = new filtrage_1Struct();
filtrage_2Struct filtrage_2 = new filtrage_2Struct();
filtrage_3Struct filtrage_3 = new filtrage_3Struct();
filtrage_4Struct filtrage_4 = new filtrage_4Struct();
fitre_finalStruct fitre_final = new fitre_finalStruct();
row7Struct row7 = new row7Struct();










	
	/**
	 * [tLogRow_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tLogRow_1", false);
		start_Hash.put("tLogRow_1", System.currentTimeMillis());
		
	
	currentComponent="tLogRow_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row7");
					}
				
		int tos_count_tLogRow_1 = 0;
		

	///////////////////////
	
         class Util_tLogRow_1 {

        String[] des_top = { ".", ".", "-", "+" };

        String[] des_head = { "|=", "=|", "-", "+" };

        String[] des_bottom = { "'", "'", "-", "+" };

        String name="";

        java.util.List<String[]> list = new java.util.ArrayList<String[]>();

        int[] colLengths = new int[13];

        public void addRow(String[] row) {

            for (int i = 0; i < 13; i++) {
                if (row[i]!=null) {
                  colLengths[i] = Math.max(colLengths[i], row[i].length());
                }
            }
            list.add(row);
        }

        public void setTableName(String name) {

            this.name = name;
        }

            public StringBuilder format() {
            
                StringBuilder sb = new StringBuilder();
  
            
                    sb.append(print(des_top));
    
                    int totals = 0;
                    for (int i = 0; i < colLengths.length; i++) {
                        totals = totals + colLengths[i];
                    }
    
                    // name
                    sb.append("|");
                    int k = 0;
                    for (k = 0; k < (totals + 12 - name.length()) / 2; k++) {
                        sb.append(' ');
                    }
                    sb.append(name);
                    for (int i = 0; i < totals + 12 - name.length() - k; i++) {
                        sb.append(' ');
                    }
                    sb.append("|\n");

                    // head and rows
                    sb.append(print(des_head));
                    for (int i = 0; i < list.size(); i++) {
    
                        String[] row = list.get(i);
    
                        java.util.Formatter formatter = new java.util.Formatter(new StringBuilder());
                        
                        StringBuilder sbformat = new StringBuilder();                                             
        			        sbformat.append("|%1$-");
        			        sbformat.append(colLengths[0]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%2$-");
        			        sbformat.append(colLengths[1]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%3$-");
        			        sbformat.append(colLengths[2]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%4$-");
        			        sbformat.append(colLengths[3]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%5$-");
        			        sbformat.append(colLengths[4]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%6$-");
        			        sbformat.append(colLengths[5]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%7$-");
        			        sbformat.append(colLengths[6]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%8$-");
        			        sbformat.append(colLengths[7]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%9$-");
        			        sbformat.append(colLengths[8]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%10$-");
        			        sbformat.append(colLengths[9]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%11$-");
        			        sbformat.append(colLengths[10]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%12$-");
        			        sbformat.append(colLengths[11]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%13$-");
        			        sbformat.append(colLengths[12]);
        			        sbformat.append("s");
        			                      
                        sbformat.append("|\n");                    
       
                        formatter.format(sbformat.toString(), (Object[])row);	
                                
                        sb.append(formatter.toString());
                        if (i == 0)
                            sb.append(print(des_head)); // print the head
                    }
    
                    // end
                    sb.append(print(des_bottom));
                    return sb;
                }
            

            private StringBuilder print(String[] fillChars) {
                StringBuilder sb = new StringBuilder();
                //first column
                sb.append(fillChars[0]);                
                    for (int i = 0; i < colLengths[0] - fillChars[0].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);	                

                    for (int i = 0; i < colLengths[1] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[2] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[3] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[4] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[5] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[6] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[7] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[8] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[9] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[10] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[11] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                
                    //last column
                    for (int i = 0; i < colLengths[12] - fillChars[1].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }         
                sb.append(fillChars[1]);
                sb.append("\n");               
                return sb;
            }
            
            public boolean isTableEmpty(){
            	if (list.size() > 1)
            		return false;
            	return true;
            }
        }
        Util_tLogRow_1 util_tLogRow_1 = new Util_tLogRow_1();
        util_tLogRow_1.setTableName("tLogRow_1");
        util_tLogRow_1.addRow(new String[]{"Employee_ID","Employee_Country","Company","Department","Section","Org_Group","Job_Title","Employee_Name","Employee_Gender","Salary","Employee_Birth_Date","Employee_Hire_Date","Employee_Term_Date",});        
 		StringBuilder strBuffer_tLogRow_1 = null;
		int nb_line_tLogRow_1 = 0;
///////////////////////    			



 



/**
 * [tLogRow_1 begin ] stop
 */



	
	/**
	 * [tDBOutput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_1", false);
		start_Hash.put("tDBOutput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"fitre_final");
					}
				
		int tos_count_tDBOutput_1 = 0;
		






int nb_line_tDBOutput_1 = 0;
int nb_line_update_tDBOutput_1 = 0;
int nb_line_inserted_tDBOutput_1 = 0;
int nb_line_deleted_tDBOutput_1 = 0;
int nb_line_rejected_tDBOutput_1 = 0;

int deletedCount_tDBOutput_1=0;
int updatedCount_tDBOutput_1=0;
int insertedCount_tDBOutput_1=0;
int rowsToCommitCount_tDBOutput_1=0;
int rejectedCount_tDBOutput_1=0;

String tableName_tDBOutput_1 = "Organization_Dim";
boolean whetherReject_tDBOutput_1 = false;

java.util.Calendar calendar_tDBOutput_1 = java.util.Calendar.getInstance();
calendar_tDBOutput_1.set(1, 0, 1, 0, 0, 0);
long year1_tDBOutput_1 = calendar_tDBOutput_1.getTime().getTime();
calendar_tDBOutput_1.set(10000, 0, 1, 0, 0, 0);
long year10000_tDBOutput_1 = calendar_tDBOutput_1.getTime().getTime();
long date_tDBOutput_1;

java.sql.Connection conn_tDBOutput_1 = null;
	conn_tDBOutput_1 = (java.sql.Connection)globalMap.get("conn_tDBConnection_2");
	

int count_tDBOutput_1=0;
    	
            try (java.sql.Statement stmtClear_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
                stmtClear_tDBOutput_1.executeUpdate("DELETE FROM `" + tableName_tDBOutput_1 + "`");
            }

				String insert_tDBOutput_1 = "INSERT INTO `" + "Organization_Dim" + "` (`Employee_ID`,`Employee_Country`,`Company`,`Department`,`Section`,`Org_Group`,`Job_Title`,`Employee_Name`,`Employee_Gender`,`Salary`,`Employee_Birth_Date`,`Employee_Hire_Date`,`Employee_Term_Date`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		        int batchSize_tDBOutput_1 = 100;
	   			int batchSizeCounter_tDBOutput_1=0;
		            
		        java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
		        resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);


 



/**
 * [tDBOutput_1 begin ] stop
 */



	
	/**
	 * [tMap_5 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_5", false);
		start_Hash.put("tMap_5", System.currentTimeMillis());
		
	
	currentComponent="tMap_5";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"filtrage_4");
					}
				
		int tos_count_tMap_5 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<staffStruct> tHash_Lookup_staff = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<staffStruct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<staffStruct>) 
					globalMap.get( "tHash_Lookup_staff" ))
					;					
					
	

staffStruct staffHashKey = new staffStruct();
staffStruct staffDefault = new staffStruct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_5__Struct  {
}
Var__tMap_5__Struct Var__tMap_5 = new Var__tMap_5__Struct();
// ###############################

// ###############################
// # Outputs initialization
fitre_finalStruct fitre_final_tmp = new fitre_finalStruct();
// ###############################

        
        



        









 



/**
 * [tMap_5 begin ] stop
 */



	
	/**
	 * [tMap_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_4", false);
		start_Hash.put("tMap_4", System.currentTimeMillis());
		
	
	currentComponent="tMap_4";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"filtrage_3");
					}
				
		int tos_count_tMap_4 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<compagnyStruct> tHash_Lookup_compagny = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<compagnyStruct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<compagnyStruct>) 
					globalMap.get( "tHash_Lookup_compagny" ))
					;					
					
	

compagnyStruct compagnyHashKey = new compagnyStruct();
compagnyStruct compagnyDefault = new compagnyStruct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_4__Struct  {
}
Var__tMap_4__Struct Var__tMap_4 = new Var__tMap_4__Struct();
// ###############################

// ###############################
// # Outputs initialization
filtrage_4Struct filtrage_4_tmp = new filtrage_4Struct();
// ###############################

        
        



        









 



/**
 * [tMap_4 begin ] stop
 */



	
	/**
	 * [tMap_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_3", false);
		start_Hash.put("tMap_3", System.currentTimeMillis());
		
	
	currentComponent="tMap_3";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"filtrage_2");
					}
				
		int tos_count_tMap_3 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<departementStruct> tHash_Lookup_departement = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<departementStruct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<departementStruct>) 
					globalMap.get( "tHash_Lookup_departement" ))
					;					
					
	

departementStruct departementHashKey = new departementStruct();
departementStruct departementDefault = new departementStruct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_3__Struct  {
}
Var__tMap_3__Struct Var__tMap_3 = new Var__tMap_3__Struct();
// ###############################

// ###############################
// # Outputs initialization
filtrage_3Struct filtrage_3_tmp = new filtrage_3Struct();
// ###############################

        
        



        









 



/**
 * [tMap_3 begin ] stop
 */



	
	/**
	 * [tMap_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_2", false);
		start_Hash.put("tMap_2", System.currentTimeMillis());
		
	
	currentComponent="tMap_2";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"filtrage_1");
					}
				
		int tos_count_tMap_2 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<sectionStruct> tHash_Lookup_section = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<sectionStruct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<sectionStruct>) 
					globalMap.get( "tHash_Lookup_section" ))
					;					
					
	

sectionStruct sectionHashKey = new sectionStruct();
sectionStruct sectionDefault = new sectionStruct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_2__Struct  {
}
Var__tMap_2__Struct Var__tMap_2 = new Var__tMap_2__Struct();
// ###############################

// ###############################
// # Outputs initialization
filtrage_2Struct filtrage_2_tmp = new filtrage_2Struct();
// ###############################

        
        



        









 



/**
 * [tMap_2 begin ] stop
 */



	
	/**
	 * [tMap_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_1", false);
		start_Hash.put("tMap_1", System.currentTimeMillis());
		
	
	currentComponent="tMap_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"employer");
					}
				
		int tos_count_tMap_1 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<groupStruct> tHash_Lookup_group = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<groupStruct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<groupStruct>) 
					globalMap.get( "tHash_Lookup_group" ))
					;					
					
	

groupStruct groupHashKey = new groupStruct();
groupStruct groupDefault = new groupStruct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_1__Struct  {
}
Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
filtrage_1Struct filtrage_1_tmp = new filtrage_1Struct();
// ###############################

        
        



        









 



/**
 * [tMap_1 begin ] stop
 */



	
	/**
	 * [tDBInput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_1", false);
		start_Hash.put("tDBInput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_1";

	
		int tos_count_tDBInput_1 = 0;
		
	
    
	
		    int nb_line_tDBInput_1 = 0;
		    java.sql.Connection conn_tDBInput_1 = null;
			    String driverClass_tDBInput_1 = "org.sqlite.JDBC";
			    java.lang.Class.forName(driverClass_tDBInput_1);
				
			String url_tDBInput_1 = "jdbc:sqlite:" + "/" + "/home/duplesse/Musique/TP_BI/BDOrion.sqlite";
			
		        conn_tDBInput_1 = java.sql.DriverManager.getConnection(url_tDBInput_1);
		    
			java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1.createStatement();

		    String dbquery_tDBInput_1 = "SELECT ORGANIZATION.employee_id,\n		ORGANIZATION.org_name,\n		ORGANIZATION.country,\n		ORGANIZATION.org_level,\n		ORGANIZAT"
+"ION.start_date,\n		ORGANIZATION.end_date,\n		ORGANIZATION.org_ref_id\nFROM	ORGANIZATION";
		    

            	globalMap.put("tDBInput_1_QUERY",dbquery_tDBInput_1);
		    java.sql.ResultSet rs_tDBInput_1 = null;

		    try {
		    	rs_tDBInput_1 = stmt_tDBInput_1.executeQuery(dbquery_tDBInput_1);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_1 = rs_tDBInput_1.getMetaData();
		    	int colQtyInRs_tDBInput_1 = rsmd_tDBInput_1.getColumnCount();

		    String tmpContent_tDBInput_1 = null;
		    
		    
		    while (rs_tDBInput_1.next()) {
		        nb_line_tDBInput_1++;
		        
							if(colQtyInRs_tDBInput_1 < 1) {
								employer.employee_id = null;
							} else {
	                         		
            employer.employee_id = rs_tDBInput_1.getDouble(1);
            if(rs_tDBInput_1.wasNull()){
                    employer.employee_id = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 2) {
								employer.org_name = null;
							} else {
	                         		
        	employer.org_name = routines.system.JDBCUtil.getString(rs_tDBInput_1, 2, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 3) {
								employer.country = null;
							} else {
	                         		
        	employer.country = routines.system.JDBCUtil.getString(rs_tDBInput_1, 3, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 4) {
								employer.org_level = null;
							} else {
	                         		
            employer.org_level = rs_tDBInput_1.getDouble(4);
            if(rs_tDBInput_1.wasNull()){
                    employer.org_level = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 5) {
								employer.start_date = null;
							} else {
										
			employer.start_date = routines.system.JDBCUtil.getDate(rs_tDBInput_1, 5);
		                    }
							if(colQtyInRs_tDBInput_1 < 6) {
								employer.end_date = null;
							} else {
										
			employer.end_date = routines.system.JDBCUtil.getDate(rs_tDBInput_1, 6);
		                    }
							if(colQtyInRs_tDBInput_1 < 7) {
								employer.org_ref_id = null;
							} else {
	                         		
            employer.org_ref_id = rs_tDBInput_1.getDouble(7);
            if(rs_tDBInput_1.wasNull()){
                    employer.org_ref_id = null;
            }
		                    }
					



 



/**
 * [tDBInput_1 begin ] stop
 */
	
	/**
	 * [tDBInput_1 main ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 


	tos_count_tDBInput_1++;

/**
 * [tDBInput_1 main ] stop
 */
	
	/**
	 * [tDBInput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 process_data_begin ] stop
 */

	
	/**
	 * [tMap_1 main ] start
	 */

	

	
	
	currentComponent="tMap_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"employer"
						
						);
					}
					

			


		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_1 = false;
		  boolean mainRowRejected_tMap_1 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "group" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLoopgroup = false;
       		  	    	
       		  	    	
 							groupStruct groupObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
	                        		    	Object exprKeyValue_group__employee_id = employer.org_ref_id ;
	                        		    	if(exprKeyValue_group__employee_id == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_1 = true;
	                        		    	} else {
                        		    			groupHashKey.employee_id = (double)(Double) exprKeyValue_group__employee_id;
                        		    		}
                        		    		

								
		                        	groupHashKey.hashCodeDirty = true;
                        		
	  					
	  							
	
		  							if(!hasCasePrimitiveKeyWithNull_tMap_1) { // G_TM_M_091
		  							
			  					
			  					
			  					
	  					
		  							tHash_Lookup_group.lookup( groupHashKey );

	  							

	  							

			  						} // G_TM_M_091
			  						
			  					

 								
								  
								  if(hasCasePrimitiveKeyWithNull_tMap_1 || !tHash_Lookup_group.hasNext()) { // G_TM_M_090

  								
		  				
	  								
			  							rejectedInnerJoin_tMap_1 = true;
	  								
						
									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_group != null && tHash_Lookup_group.getCount(groupHashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'group' and it contains more one result from keys :  group.employee_id = '" + groupHashKey.employee_id + "'");
								} // G 071
							

							groupStruct group = null;
                    		  	 
							   
                    		  	 
	       		  	    	groupStruct fromLookup_group = null;
							group = groupDefault;
										 
							
								 
							
							
								if (tHash_Lookup_group !=null && tHash_Lookup_group.hasNext()) { // G 099
								
							
								
								fromLookup_group = tHash_Lookup_group.next();

							
							
								} // G 099
							
							

							if(fromLookup_group != null) {
								group = fromLookup_group;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
        // ###############################
        // # Output tables

filtrage_1 = null;

if(!rejectedInnerJoin_tMap_1 ) {

// # Output table : 'filtrage_1'
filtrage_1_tmp.id = employer.employee_id ;
filtrage_1_tmp.name = employer.org_name ;
filtrage_1_tmp.country = employer.country ;
filtrage_1_tmp.group = group.org_name ;
filtrage_1_tmp.org_ref_id = group.org_ref_id ;
filtrage_1 = filtrage_1_tmp;
}  // closing inner join bracket (2)
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_1 = false;










 


	tos_count_tMap_1++;

/**
 * [tMap_1 main ] stop
 */
	
	/**
	 * [tMap_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 process_data_begin ] stop
 */
// Start of branch "filtrage_1"
if(filtrage_1 != null) { 



	
	/**
	 * [tMap_2 main ] start
	 */

	

	
	
	currentComponent="tMap_2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"filtrage_1"
						
						);
					}
					

			


		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_2 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_2 = false;
		  boolean mainRowRejected_tMap_2 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "section" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLoopsection = false;
       		  	    	
       		  	    	
 							sectionStruct sectionObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_2) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_2 = false;
								
	                        		    	Object exprKeyValue_section__employee_id = filtrage_1.org_ref_id ;
	                        		    	if(exprKeyValue_section__employee_id == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_2 = true;
	                        		    	} else {
                        		    			sectionHashKey.employee_id = (double)(Double) exprKeyValue_section__employee_id;
                        		    		}
                        		    		

								
		                        	sectionHashKey.hashCodeDirty = true;
                        		
	  					
	  							
	
		  							if(!hasCasePrimitiveKeyWithNull_tMap_2) { // G_TM_M_091
		  							
			  					
			  					
			  					
	  					
		  							tHash_Lookup_section.lookup( sectionHashKey );

	  							

	  							

			  						} // G_TM_M_091
			  						
			  					

 								
								  
								  if(hasCasePrimitiveKeyWithNull_tMap_2 || !tHash_Lookup_section.hasNext()) { // G_TM_M_090

  								
		  				
	  								
			  							rejectedInnerJoin_tMap_2 = true;
	  								
						
									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_section != null && tHash_Lookup_section.getCount(sectionHashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'section' and it contains more one result from keys :  section.employee_id = '" + sectionHashKey.employee_id + "'");
								} // G 071
							

							sectionStruct section = null;
                    		  	 
							   
                    		  	 
	       		  	    	sectionStruct fromLookup_section = null;
							section = sectionDefault;
										 
							
								 
							
							
								if (tHash_Lookup_section !=null && tHash_Lookup_section.hasNext()) { // G 099
								
							
								
								fromLookup_section = tHash_Lookup_section.next();

							
							
								} // G 099
							
							

							if(fromLookup_section != null) {
								section = fromLookup_section;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_2__Struct Var = Var__tMap_2;// ###############################
        // ###############################
        // # Output tables

filtrage_2 = null;

if(!rejectedInnerJoin_tMap_2 ) {

// # Output table : 'filtrage_2'
filtrage_2_tmp.employee_id = filtrage_1.id ;
filtrage_2_tmp.employer_name = filtrage_1.name ;
filtrage_2_tmp.employee_section = section.org_name ;
filtrage_2_tmp.employee_group = filtrage_1.group ;
filtrage_2_tmp.employee_country = filtrage_1.country ;
filtrage_2_tmp.org_ref_id = section.org_ref_id ;
filtrage_2 = filtrage_2_tmp;
}  // closing inner join bracket (2)
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_2 = false;










 


	tos_count_tMap_2++;

/**
 * [tMap_2 main ] stop
 */
	
	/**
	 * [tMap_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_2";

	

 



/**
 * [tMap_2 process_data_begin ] stop
 */
// Start of branch "filtrage_2"
if(filtrage_2 != null) { 



	
	/**
	 * [tMap_3 main ] start
	 */

	

	
	
	currentComponent="tMap_3";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"filtrage_2"
						
						);
					}
					

			


		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_3 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_3 = false;
		  boolean mainRowRejected_tMap_3 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "departement" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLoopdepartement = false;
       		  	    	
       		  	    	
 							departementStruct departementObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_3) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_3 = false;
								
                        		    		    departementHashKey.employee_id = filtrage_2.org_ref_id ;
                        		    		

								
		                        	departementHashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_departement.lookup( departementHashKey );

	  							

	  							

 								
								  
								  if(!tHash_Lookup_departement.hasNext()) { // G_TM_M_090

  								
		  				
	  								
			  							rejectedInnerJoin_tMap_3 = true;
	  								
						
									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_departement != null && tHash_Lookup_departement.getCount(departementHashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'departement' and it contains more one result from keys :  departement.employee_id = '" + departementHashKey.employee_id + "'");
								} // G 071
							

							departementStruct departement = null;
                    		  	 
							   
                    		  	 
	       		  	    	departementStruct fromLookup_departement = null;
							departement = departementDefault;
										 
							
								 
							
							
								if (tHash_Lookup_departement !=null && tHash_Lookup_departement.hasNext()) { // G 099
								
							
								
								fromLookup_departement = tHash_Lookup_departement.next();

							
							
								} // G 099
							
							

							if(fromLookup_departement != null) {
								departement = fromLookup_departement;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_3__Struct Var = Var__tMap_3;// ###############################
        // ###############################
        // # Output tables

filtrage_3 = null;

if(!rejectedInnerJoin_tMap_3 ) {

// # Output table : 'filtrage_3'
filtrage_3_tmp.employe_id = filtrage_2.employee_id ;
filtrage_3_tmp.employee_country = filtrage_2.employee_country ;
filtrage_3_tmp.employee_departement = departement.org_name ;
filtrage_3_tmp.employee_section = filtrage_2.employee_section ;
filtrage_3_tmp.employee_group = filtrage_2.employee_group ;
filtrage_3_tmp.org_ref_id = departement.org_ref_id ;
filtrage_3_tmp.employee_name = filtrage_2.employer_name ;
filtrage_3 = filtrage_3_tmp;
}  // closing inner join bracket (2)
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_3 = false;










 


	tos_count_tMap_3++;

/**
 * [tMap_3 main ] stop
 */
	
	/**
	 * [tMap_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_3";

	

 



/**
 * [tMap_3 process_data_begin ] stop
 */
// Start of branch "filtrage_3"
if(filtrage_3 != null) { 



	
	/**
	 * [tMap_4 main ] start
	 */

	

	
	
	currentComponent="tMap_4";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"filtrage_3"
						
						);
					}
					

			


		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_4 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_4 = false;
		  boolean mainRowRejected_tMap_4 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "compagny" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLoopcompagny = false;
       		  	    	
       		  	    	
 							compagnyStruct compagnyObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_4) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_4 = false;
								
                        		    		    compagnyHashKey.employee_id = filtrage_3.org_ref_id ;
                        		    		

								
		                        	compagnyHashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_compagny.lookup( compagnyHashKey );

	  							

	  							

 								
								  
								  if(!tHash_Lookup_compagny.hasNext()) { // G_TM_M_090

  								
		  				
	  								
			  							rejectedInnerJoin_tMap_4 = true;
	  								
						
									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_compagny != null && tHash_Lookup_compagny.getCount(compagnyHashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'compagny' and it contains more one result from keys :  compagny.employee_id = '" + compagnyHashKey.employee_id + "'");
								} // G 071
							

							compagnyStruct compagny = null;
                    		  	 
							   
                    		  	 
	       		  	    	compagnyStruct fromLookup_compagny = null;
							compagny = compagnyDefault;
										 
							
								 
							
							
								if (tHash_Lookup_compagny !=null && tHash_Lookup_compagny.hasNext()) { // G 099
								
							
								
								fromLookup_compagny = tHash_Lookup_compagny.next();

							
							
								} // G 099
							
							

							if(fromLookup_compagny != null) {
								compagny = fromLookup_compagny;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_4__Struct Var = Var__tMap_4;// ###############################
        // ###############################
        // # Output tables

filtrage_4 = null;

if(!rejectedInnerJoin_tMap_4 ) {

// # Output table : 'filtrage_4'
filtrage_4_tmp.employe_id = filtrage_3.employe_id ;
filtrage_4_tmp.employee_country = filtrage_3.employee_country ;
filtrage_4_tmp.employer_compagny = compagny.org_name ;
filtrage_4_tmp.employee_departement = filtrage_3.employee_departement ;
filtrage_4_tmp.employee_section = filtrage_3.employee_section ;
filtrage_4_tmp.org_group = filtrage_3.employee_group ;
filtrage_4_tmp.employee_name = filtrage_3.employee_name ;
filtrage_4 = filtrage_4_tmp;
}  // closing inner join bracket (2)
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_4 = false;










 


	tos_count_tMap_4++;

/**
 * [tMap_4 main ] stop
 */
	
	/**
	 * [tMap_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_4";

	

 



/**
 * [tMap_4 process_data_begin ] stop
 */
// Start of branch "filtrage_4"
if(filtrage_4 != null) { 



	
	/**
	 * [tMap_5 main ] start
	 */

	

	
	
	currentComponent="tMap_5";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"filtrage_4"
						
						);
					}
					

			


		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_5 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_5 = false;
		  boolean mainRowRejected_tMap_5 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "staff" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLoopstaff = false;
       		  	    	
       		  	    	
 							staffStruct staffObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_5) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_5 = false;
								
                        		    		    staffHashKey.Employee_ID = routines.system.TypeConvert.Double2Integer(filtrage_4.employe_id );
                        		    		

								
		                        	staffHashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_staff.lookup( staffHashKey );

	  							

	  							

 								
								  
								  if(!tHash_Lookup_staff.hasNext()) { // G_TM_M_090

  								
		  				
	  								
			  							rejectedInnerJoin_tMap_5 = true;
	  								
						
									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_staff != null && tHash_Lookup_staff.getCount(staffHashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'staff' and it contains more one result from keys :  staff.Employee_ID = '" + staffHashKey.Employee_ID + "'");
								} // G 071
							

							staffStruct staff = null;
                    		  	 
							   
                    		  	 
	       		  	    	staffStruct fromLookup_staff = null;
							staff = staffDefault;
										 
							
								 
							
							
								if (tHash_Lookup_staff !=null && tHash_Lookup_staff.hasNext()) { // G 099
								
							
								
								fromLookup_staff = tHash_Lookup_staff.next();

							
							
								} // G 099
							
							

							if(fromLookup_staff != null) {
								staff = fromLookup_staff;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_5__Struct Var = Var__tMap_5;// ###############################
        // ###############################
        // # Output tables

fitre_final = null;

if(!rejectedInnerJoin_tMap_5 ) {

// # Output table : 'fitre_final'
fitre_final_tmp.Employee_ID = filtrage_4.employe_id ;
fitre_final_tmp.Employee_Country = filtrage_4.employee_country ;
fitre_final_tmp.Company = filtrage_4.employer_compagny ;
fitre_final_tmp.Department = filtrage_4.employee_departement ;
fitre_final_tmp.Section = filtrage_4.employee_section ;
fitre_final_tmp.Org_Group = filtrage_4.org_group ;
fitre_final_tmp.Job_Title = staff.Job_Title ;
fitre_final_tmp.Employee_Name = filtrage_4.employee_name ;
fitre_final_tmp.Employee_Gender = (((staff.Gender ) == null) ? null : (routines.system.TypeConvert.Character2String(staff.Gender )));
fitre_final_tmp.Salary = staff.Salary ;
fitre_final_tmp.Employee_Birth_Date = staff.Birth_Date ;
fitre_final_tmp.Employee_Hire_Date = staff.Emp_Hire_Date ;
fitre_final_tmp.Employee_Term_Date = staff.Emp_Term_Date ;
fitre_final = fitre_final_tmp;
}  // closing inner join bracket (2)
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_5 = false;










 


	tos_count_tMap_5++;

/**
 * [tMap_5 main ] stop
 */
	
	/**
	 * [tMap_5 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_5";

	

 



/**
 * [tMap_5 process_data_begin ] stop
 */
// Start of branch "fitre_final"
if(fitre_final != null) { 



	
	/**
	 * [tDBOutput_1 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"fitre_final"
						
						);
					}
					



            row7 = null;
        whetherReject_tDBOutput_1 = false;
                            pstmt_tDBOutput_1.setDouble(1, fitre_final.Employee_ID);

                            if(fitre_final.Employee_Country == null) {
pstmt_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(2, fitre_final.Employee_Country);
}

                            if(fitre_final.Company == null) {
pstmt_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(3, fitre_final.Company);
}

                            if(fitre_final.Department == null) {
pstmt_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(4, fitre_final.Department);
}

                            if(fitre_final.Section == null) {
pstmt_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(5, fitre_final.Section);
}

                            if(fitre_final.Org_Group == null) {
pstmt_tDBOutput_1.setNull(6, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(6, fitre_final.Org_Group);
}

                            if(fitre_final.Job_Title == null) {
pstmt_tDBOutput_1.setNull(7, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(7, fitre_final.Job_Title);
}

                            if(fitre_final.Employee_Name == null) {
pstmt_tDBOutput_1.setNull(8, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(8, fitre_final.Employee_Name);
}

                            if(fitre_final.Employee_Gender == null) {
pstmt_tDBOutput_1.setNull(9, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(9, fitre_final.Employee_Gender);
}

                            pstmt_tDBOutput_1.setBigDecimal(10, fitre_final.Salary);

                            if(fitre_final.Employee_Birth_Date != null) {
date_tDBOutput_1 = fitre_final.Employee_Birth_Date.getTime();
if(date_tDBOutput_1 < year1_tDBOutput_1 || date_tDBOutput_1 >= year10000_tDBOutput_1) {
pstmt_tDBOutput_1.setString(11, "0000-00-00 00:00:00");
} else {pstmt_tDBOutput_1.setTimestamp(11, new java.sql.Timestamp(date_tDBOutput_1));
}
} else {
pstmt_tDBOutput_1.setNull(11, java.sql.Types.DATE);
}

                            if(fitre_final.Employee_Hire_Date != null) {
date_tDBOutput_1 = fitre_final.Employee_Hire_Date.getTime();
if(date_tDBOutput_1 < year1_tDBOutput_1 || date_tDBOutput_1 >= year10000_tDBOutput_1) {
pstmt_tDBOutput_1.setString(12, "0000-00-00 00:00:00");
} else {pstmt_tDBOutput_1.setTimestamp(12, new java.sql.Timestamp(date_tDBOutput_1));
}
} else {
pstmt_tDBOutput_1.setNull(12, java.sql.Types.DATE);
}

                            if(fitre_final.Employee_Term_Date != null) {
date_tDBOutput_1 = fitre_final.Employee_Term_Date.getTime();
if(date_tDBOutput_1 < year1_tDBOutput_1 || date_tDBOutput_1 >= year10000_tDBOutput_1) {
pstmt_tDBOutput_1.setString(13, "0000-00-00 00:00:00");
} else {pstmt_tDBOutput_1.setTimestamp(13, new java.sql.Timestamp(date_tDBOutput_1));
}
} else {
pstmt_tDBOutput_1.setNull(13, java.sql.Types.DATE);
}

                    pstmt_tDBOutput_1.addBatch();
                    nb_line_tDBOutput_1++;

						
                      batchSizeCounter_tDBOutput_1++;
            if(!whetherReject_tDBOutput_1) {
                            row7 = new row7Struct();
                                row7.Employee_ID = fitre_final.Employee_ID;
                                row7.Employee_Country = fitre_final.Employee_Country;
                                row7.Company = fitre_final.Company;
                                row7.Department = fitre_final.Department;
                                row7.Section = fitre_final.Section;
                                row7.Org_Group = fitre_final.Org_Group;
                                row7.Job_Title = fitre_final.Job_Title;
                                row7.Employee_Name = fitre_final.Employee_Name;
                                row7.Employee_Gender = fitre_final.Employee_Gender;
                                row7.Salary = fitre_final.Salary;
                                row7.Employee_Birth_Date = fitre_final.Employee_Birth_Date;
                                row7.Employee_Hire_Date = fitre_final.Employee_Hire_Date;
                                row7.Employee_Term_Date = fitre_final.Employee_Term_Date;
            }
                if ( batchSize_tDBOutput_1 <= batchSizeCounter_tDBOutput_1) {
                try {
                        int countSum_tDBOutput_1 = 0;
                        for(int countEach_tDBOutput_1: pstmt_tDBOutput_1.executeBatch()) {
                            countSum_tDBOutput_1 += (countEach_tDBOutput_1 == java.sql.Statement.EXECUTE_FAILED ? 0 : 1);
                        }
                        rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
                        insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
                }catch (java.sql.BatchUpdateException e){
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e.getMessage());
                    int countSum_tDBOutput_1 = 0;
                    for(int countEach_tDBOutput_1: e.getUpdateCounts()) {
                        countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
                    }
                    rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
                    insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
                    System.err.println(e.getMessage());
                }

                batchSizeCounter_tDBOutput_1 = 0;
            }

 


	tos_count_tDBOutput_1++;

/**
 * [tDBOutput_1 main ] stop
 */
	
	/**
	 * [tDBOutput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	

 



/**
 * [tDBOutput_1 process_data_begin ] stop
 */
// Start of branch "row7"
if(row7 != null) { 



	
	/**
	 * [tLogRow_1 main ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row7"
						
						);
					}
					
///////////////////////		
						

				
				String[] row_tLogRow_1 = new String[13];
              
                 row_tLogRow_1[0]=    						
								FormatterUtils.formatUnwithE(row7.Employee_ID)
					          ;	
										
    			   				
	    		if(row7.Employee_Country != null) { //              
                 row_tLogRow_1[1]=    						    
				                String.valueOf(row7.Employee_Country)			
					          ;	
							
	    		} //			
    			   				
	    		if(row7.Company != null) { //              
                 row_tLogRow_1[2]=    						    
				                String.valueOf(row7.Company)			
					          ;	
							
	    		} //			
    			   				
	    		if(row7.Department != null) { //              
                 row_tLogRow_1[3]=    						    
				                String.valueOf(row7.Department)			
					          ;	
							
	    		} //			
    			   				
	    		if(row7.Section != null) { //              
                 row_tLogRow_1[4]=    						    
				                String.valueOf(row7.Section)			
					          ;	
							
	    		} //			
    			   				
	    		if(row7.Org_Group != null) { //              
                 row_tLogRow_1[5]=    						    
				                String.valueOf(row7.Org_Group)			
					          ;	
							
	    		} //			
    			   				
	    		if(row7.Job_Title != null) { //              
                 row_tLogRow_1[6]=    						    
				                String.valueOf(row7.Job_Title)			
					          ;	
							
	    		} //			
    			   				
	    		if(row7.Employee_Name != null) { //              
                 row_tLogRow_1[7]=    						    
				                String.valueOf(row7.Employee_Name)			
					          ;	
							
	    		} //			
    			   				
	    		if(row7.Employee_Gender != null) { //              
                 row_tLogRow_1[8]=    						    
				                String.valueOf(row7.Employee_Gender)			
					          ;	
							
	    		} //			
    			   				
	    		if(row7.Salary != null) { //              
                 row_tLogRow_1[9]=    						
								row7.Salary.setScale(0, java.math.RoundingMode.HALF_UP).toPlainString()
					          ;	
							
	    		} //			
    			   				
	    		if(row7.Employee_Birth_Date != null) { //              
                 row_tLogRow_1[10]=    						
								FormatterUtils.format_Date(row7.Employee_Birth_Date, "dd-MM-yyyy")
					          ;	
							
	    		} //			
    			   				
	    		if(row7.Employee_Hire_Date != null) { //              
                 row_tLogRow_1[11]=    						
								FormatterUtils.format_Date(row7.Employee_Hire_Date, "dd-MM-yyyy")
					          ;	
							
	    		} //			
    			   				
	    		if(row7.Employee_Term_Date != null) { //              
                 row_tLogRow_1[12]=    						
								FormatterUtils.format_Date(row7.Employee_Term_Date, "dd-MM-yyyy")
					          ;	
							
	    		} //			
    			 

				util_tLogRow_1.addRow(row_tLogRow_1);	
				nb_line_tLogRow_1++;
//////

//////                    
                    
///////////////////////    			

 


	tos_count_tLogRow_1++;

/**
 * [tLogRow_1 main ] stop
 */
	
	/**
	 * [tLogRow_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	

 



/**
 * [tLogRow_1 process_data_begin ] stop
 */
	
	/**
	 * [tLogRow_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	

 



/**
 * [tLogRow_1 process_data_end ] stop
 */

} // End of branch "row7"




	
	/**
	 * [tDBOutput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	

 



/**
 * [tDBOutput_1 process_data_end ] stop
 */

} // End of branch "fitre_final"




	
	/**
	 * [tMap_5 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_5";

	

 



/**
 * [tMap_5 process_data_end ] stop
 */

} // End of branch "filtrage_4"




	
	/**
	 * [tMap_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_4";

	

 



/**
 * [tMap_4 process_data_end ] stop
 */

} // End of branch "filtrage_3"




	
	/**
	 * [tMap_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_3";

	

 



/**
 * [tMap_3 process_data_end ] stop
 */

} // End of branch "filtrage_2"




	
	/**
	 * [tMap_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_2";

	

 



/**
 * [tMap_2 process_data_end ] stop
 */

} // End of branch "filtrage_1"




	
	/**
	 * [tMap_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_1 end ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

	}
}finally{
	if (rs_tDBInput_1 != null) {
		rs_tDBInput_1.close();
	}
	if (stmt_tDBInput_1 != null) {
		stmt_tDBInput_1.close();
	}
		if(conn_tDBInput_1 != null && !conn_tDBInput_1.isClosed()) {
			
			conn_tDBInput_1.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
		}
}
globalMap.put("tDBInput_1_NB_LINE",nb_line_tDBInput_1);

 

ok_Hash.put("tDBInput_1", true);
end_Hash.put("tDBInput_1", System.currentTimeMillis());




/**
 * [tDBInput_1 end ] stop
 */

	
	/**
	 * [tMap_1 end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	


// ###############################
// # Lookup hashes releasing
					if(tHash_Lookup_group != null) {
						tHash_Lookup_group.endGet();
					}
					globalMap.remove( "tHash_Lookup_group" );

					
					
				
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"employer");
			  	}
			  	
 

ok_Hash.put("tMap_1", true);
end_Hash.put("tMap_1", System.currentTimeMillis());




/**
 * [tMap_1 end ] stop
 */

	
	/**
	 * [tMap_2 end ] start
	 */

	

	
	
	currentComponent="tMap_2";

	


// ###############################
// # Lookup hashes releasing
					if(tHash_Lookup_section != null) {
						tHash_Lookup_section.endGet();
					}
					globalMap.remove( "tHash_Lookup_section" );

					
					
				
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"filtrage_1");
			  	}
			  	
 

ok_Hash.put("tMap_2", true);
end_Hash.put("tMap_2", System.currentTimeMillis());




/**
 * [tMap_2 end ] stop
 */

	
	/**
	 * [tMap_3 end ] start
	 */

	

	
	
	currentComponent="tMap_3";

	


// ###############################
// # Lookup hashes releasing
					if(tHash_Lookup_departement != null) {
						tHash_Lookup_departement.endGet();
					}
					globalMap.remove( "tHash_Lookup_departement" );

					
					
				
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"filtrage_2");
			  	}
			  	
 

ok_Hash.put("tMap_3", true);
end_Hash.put("tMap_3", System.currentTimeMillis());




/**
 * [tMap_3 end ] stop
 */

	
	/**
	 * [tMap_4 end ] start
	 */

	

	
	
	currentComponent="tMap_4";

	


// ###############################
// # Lookup hashes releasing
					if(tHash_Lookup_compagny != null) {
						tHash_Lookup_compagny.endGet();
					}
					globalMap.remove( "tHash_Lookup_compagny" );

					
					
				
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"filtrage_3");
			  	}
			  	
 

ok_Hash.put("tMap_4", true);
end_Hash.put("tMap_4", System.currentTimeMillis());




/**
 * [tMap_4 end ] stop
 */

	
	/**
	 * [tMap_5 end ] start
	 */

	

	
	
	currentComponent="tMap_5";

	


// ###############################
// # Lookup hashes releasing
					if(tHash_Lookup_staff != null) {
						tHash_Lookup_staff.endGet();
					}
					globalMap.remove( "tHash_Lookup_staff" );

					
					
				
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"filtrage_4");
			  	}
			  	
 

ok_Hash.put("tMap_5", true);
end_Hash.put("tMap_5", System.currentTimeMillis());




/**
 * [tMap_5 end ] stop
 */

	
	/**
	 * [tDBOutput_1 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	



                try {
                		if (batchSizeCounter_tDBOutput_1 != 0) {
							int countSum_tDBOutput_1 = 0;
							
							for(int countEach_tDBOutput_1: pstmt_tDBOutput_1.executeBatch()) {
								countSum_tDBOutput_1 += (countEach_tDBOutput_1 == java.sql.Statement.EXECUTE_FAILED ? 0 : 1);
							}
							rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
							
	            	    	
	            	    		insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
	            	    	
            	    	}

                }catch (java.sql.BatchUpdateException e){
                    globalMap.put(currentComponent+"_ERROR_MESSAGE",e.getMessage());
                	
                	int countSum_tDBOutput_1 = 0;
					for(int countEach_tDBOutput_1: e.getUpdateCounts()) {
						countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
					}
					rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
					
            	    insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
	    	    	
                	System.err.println(e.getMessage());
                	
                }
                batchSizeCounter_tDBOutput_1 = 0;
    		
	

        if(pstmt_tDBOutput_1 != null) {
			
				pstmt_tDBOutput_1.close();
				resourceMap.remove("pstmt_tDBOutput_1");
			
        }
    resourceMap.put("statementClosed_tDBOutput_1", true);

	nb_line_deleted_tDBOutput_1=nb_line_deleted_tDBOutput_1+ deletedCount_tDBOutput_1;
	nb_line_update_tDBOutput_1=nb_line_update_tDBOutput_1 + updatedCount_tDBOutput_1;
	nb_line_inserted_tDBOutput_1=nb_line_inserted_tDBOutput_1 + insertedCount_tDBOutput_1;
	nb_line_rejected_tDBOutput_1=nb_line_rejected_tDBOutput_1 + rejectedCount_tDBOutput_1;
	
        globalMap.put("tDBOutput_1_NB_LINE",nb_line_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_UPDATED",nb_line_update_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_DELETED",nb_line_deleted_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_1);
    

	

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"fitre_final");
			  	}
			  	
 

ok_Hash.put("tDBOutput_1", true);
end_Hash.put("tDBOutput_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk3", 0, "ok");
				}
				tDBCommit_1Process(globalMap);



/**
 * [tDBOutput_1 end ] stop
 */

	
	/**
	 * [tLogRow_1 end ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	


//////

                    
                    java.io.PrintStream consoleOut_tLogRow_1 = null;
                    if (globalMap.get("tLogRow_CONSOLE")!=null)
                    {
                    	consoleOut_tLogRow_1 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
                    }
                    else
                    {
                    	consoleOut_tLogRow_1 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
                    	globalMap.put("tLogRow_CONSOLE",consoleOut_tLogRow_1);
                    }
                    
                    consoleOut_tLogRow_1.println(util_tLogRow_1.format().toString());
                    consoleOut_tLogRow_1.flush();
//////
globalMap.put("tLogRow_1_NB_LINE",nb_line_tLogRow_1);

///////////////////////    			

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row7");
			  	}
			  	
 

ok_Hash.put("tLogRow_1", true);
end_Hash.put("tLogRow_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk4", 0, "ok");
				}
				tJava_1Process(globalMap);



/**
 * [tLogRow_1 end ] stop
 */





















				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
					     			//free memory for "tMap_5"
					     			globalMap.remove("tHash_Lookup_staff"); 
				     			
					     			//free memory for "tMap_4"
					     			globalMap.remove("tHash_Lookup_compagny"); 
				     			
					     			//free memory for "tMap_3"
					     			globalMap.remove("tHash_Lookup_departement"); 
				     			
					     			//free memory for "tMap_2"
					     			globalMap.remove("tHash_Lookup_section"); 
				     			
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_group"); 
				     			
				try{
					
	
	/**
	 * [tDBInput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 finally ] stop
 */

	
	/**
	 * [tMap_1 finally ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 finally ] stop
 */

	
	/**
	 * [tMap_2 finally ] start
	 */

	

	
	
	currentComponent="tMap_2";

	

 



/**
 * [tMap_2 finally ] stop
 */

	
	/**
	 * [tMap_3 finally ] start
	 */

	

	
	
	currentComponent="tMap_3";

	

 



/**
 * [tMap_3 finally ] stop
 */

	
	/**
	 * [tMap_4 finally ] start
	 */

	

	
	
	currentComponent="tMap_4";

	

 



/**
 * [tMap_4 finally ] stop
 */

	
	/**
	 * [tMap_5 finally ] start
	 */

	

	
	
	currentComponent="tMap_5";

	

 



/**
 * [tMap_5 finally ] stop
 */

	
	/**
	 * [tDBOutput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	



    if (resourceMap.get("statementClosed_tDBOutput_1") == null) {
                java.sql.PreparedStatement pstmtToClose_tDBOutput_1 = null;
                if ((pstmtToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_1")) != null) {
                    pstmtToClose_tDBOutput_1.close();
                }
    }
 



/**
 * [tDBOutput_1 finally ] stop
 */

	
	/**
	 * [tLogRow_1 finally ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	

 



/**
 * [tLogRow_1 finally ] stop
 */





















				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 1);
	}
	

public void tJava_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tJava_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tJava_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tJava_1", false);
		start_Hash.put("tJava_1", System.currentTimeMillis());
		
	
	currentComponent="tJava_1";

	
		int tos_count_tJava_1 = 0;
		


System.out.println("Nombre total de lignes : " + ((Integer) globalMap.get("tDBOutput_1_NB_LINE")));
System.out.println("L\'execution du job de remplisage de la dimension Organisation c'est effectuer avec succée." +"\n Fin du Job");
 



/**
 * [tJava_1 begin ] stop
 */
	
	/**
	 * [tJava_1 main ] start
	 */

	

	
	
	currentComponent="tJava_1";

	

 


	tos_count_tJava_1++;

/**
 * [tJava_1 main ] stop
 */
	
	/**
	 * [tJava_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tJava_1";

	

 



/**
 * [tJava_1 process_data_begin ] stop
 */
	
	/**
	 * [tJava_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tJava_1";

	

 



/**
 * [tJava_1 process_data_end ] stop
 */
	
	/**
	 * [tJava_1 end ] start
	 */

	

	
	
	currentComponent="tJava_1";

	

 

ok_Hash.put("tJava_1", true);
end_Hash.put("tJava_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk5", 0, "ok");
				}
				tSendMail_2Process(globalMap);



/**
 * [tJava_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tJava_1 finally ] start
	 */

	

	
	
	currentComponent="tJava_1";

	

 



/**
 * [tJava_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tJava_1_SUBPROCESS_STATE", 1);
	}
	

public void tSendMail_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tSendMail_2_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tSendMail_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tSendMail_2", false);
		start_Hash.put("tSendMail_2", System.currentTimeMillis());
		
	
	currentComponent="tSendMail_2";

	
		int tos_count_tSendMail_2 = 0;
		

 



/**
 * [tSendMail_2 begin ] stop
 */
	
	/**
	 * [tSendMail_2 main ] start
	 */

	

	
	
	currentComponent="tSendMail_2";

	

 

	String smtpHost_tSendMail_2 = "smtp.gmail.com";
        String smtpPort_tSendMail_2 = "587";
	String from_tSendMail_2 = ("duplusse.nangmo@facsciences-uy1.cm");
    String to_tSendMail_2 = ("richel.kembou@facsciences-uy1.cm").replace(";",",");
    String cc_tSendMail_2 = (("")==null || "".equals(""))?null:("").replace(";",",");
    String bcc_tSendMail_2 = (("")==null || "".equals(""))?null:("").replace(";",",");
    String subject_tSendMail_2 = ("Test d’envoi depuis Talend");
    
	java.util.List<java.util.Map<String, String>> headers_tSendMail_2 = new java.util.ArrayList<java.util.Map<String,String>>();
	java.util.List<String> attachments_tSendMail_2 = new java.util.ArrayList<String>();
	java.util.List<String> contentTransferEncoding_tSendMail_2 = new java.util.ArrayList<String>();

	String message_tSendMail_2 = (("Bonjour, ceci est un test d\'email envoyé depuis Talend.ahfg ohrz lyoa vfhn ") == null || "".equals("Bonjour, ceci est un test d\'email envoyé depuis Talend.ahfg ohrz lyoa vfhn ")) ? "\"\"" : ("Bonjour, ceci est un test d\'email envoyé depuis Talend.ahfg ohrz lyoa vfhn ") ;
	java.util.Properties props_tSendMail_2 = System.getProperties();     
	props_tSendMail_2.put("mail.smtp.host", smtpHost_tSendMail_2);
	props_tSendMail_2.put("mail.smtp.port", smtpPort_tSendMail_2);
		props_tSendMail_2.put("mail.mime.encodefilename", "true");
		props_tSendMail_2.put("mail.smtp.starttls.enable","true");     
	try {
		
		
			props_tSendMail_2.put("mail.smtp.auth", "true");
			javax.mail.Session session_tSendMail_2 = javax.mail.Session.getInstance(props_tSendMail_2, new javax.mail.Authenticator(){         
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				
                 
	final String decryptedPassword_tSendMail_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:k0JQbiaC56NtsVZbpzolCay72TPW6TvSSdezdnWGWxfaAoFqavweNtRYQlPZ0wtD");
				
				
				return new javax.mail.PasswordAuthentication("duplusse.nangmo@facsciences-uy1.cm", decryptedPassword_tSendMail_2); 
				}         
			});   
		
		
		javax.mail.Message msg_tSendMail_2 = new javax.mail.internet.MimeMessage(session_tSendMail_2);
		msg_tSendMail_2.setFrom(new javax.mail.internet.InternetAddress(from_tSendMail_2, "Mac le riche"));
		msg_tSendMail_2.setRecipients(javax.mail.Message.RecipientType.TO,javax.mail.internet.InternetAddress.parse(to_tSendMail_2, false));
		if (cc_tSendMail_2 != null) msg_tSendMail_2.setRecipients(javax.mail.Message.RecipientType.CC, javax.mail.internet.InternetAddress.parse(cc_tSendMail_2, false));
		if (bcc_tSendMail_2 != null) msg_tSendMail_2.setRecipients(javax.mail.Message.RecipientType.BCC, javax.mail.internet.InternetAddress.parse(bcc_tSendMail_2, false));
		msg_tSendMail_2.setSubject(subject_tSendMail_2);

		for (int i_tSendMail_2 = 0; i_tSendMail_2 < headers_tSendMail_2.size(); i_tSendMail_2++) {
			java.util.Map<String, String> header_tSendMail_2 = headers_tSendMail_2.get(i_tSendMail_2);
			msg_tSendMail_2.setHeader(header_tSendMail_2.get("KEY"), header_tSendMail_2.get("VALUE"));    
		}  
		msg_tSendMail_2.setSentDate(new Date());
		msg_tSendMail_2.setHeader("X-Priority", "5"); //High->1 Normal->3 Low->5
		javax.mail.Multipart mp_tSendMail_2 = new javax.mail.internet.MimeMultipart();
		javax.mail.internet.MimeBodyPart mbpText_tSendMail_2 = new javax.mail.internet.MimeBodyPart();
		mbpText_tSendMail_2.setText(message_tSendMail_2,"ISO-8859-15", "plain");
		mp_tSendMail_2.addBodyPart(mbpText_tSendMail_2);
  
		javax.mail.internet.MimeBodyPart mbpFile_tSendMail_2 = null;

		for (int i_tSendMail_2 = 0; i_tSendMail_2 < attachments_tSendMail_2.size(); i_tSendMail_2++){
			String filename_tSendMail_2 = attachments_tSendMail_2.get(i_tSendMail_2);
			javax.activation.FileDataSource fds_tSendMail_2 = null;
			java.io.File file_tSendMail_2 = new java.io.File(filename_tSendMail_2);
			
				if (!file_tSendMail_2.exists()){
					continue;
				}
			
    		if (file_tSendMail_2.isDirectory()){
				java.io.File[] subFiles_tSendMail_2 = file_tSendMail_2.listFiles();
				for(java.io.File subFile_tSendMail_2 : subFiles_tSendMail_2){
					if (subFile_tSendMail_2.isFile()){
						fds_tSendMail_2 = new javax.activation.FileDataSource(subFile_tSendMail_2.getAbsolutePath());
						mbpFile_tSendMail_2 = new javax.mail.internet.MimeBodyPart();
						mbpFile_tSendMail_2.setDataHandler(new javax.activation.DataHandler(fds_tSendMail_2));
						mbpFile_tSendMail_2.setFileName(javax.mail.internet.MimeUtility.encodeText(fds_tSendMail_2.getName()));
						if(contentTransferEncoding_tSendMail_2.get(i_tSendMail_2).equalsIgnoreCase("base64")){
							mbpFile_tSendMail_2.setHeader("Content-Transfer-Encoding", "base64");
						}
						mp_tSendMail_2.addBodyPart(mbpFile_tSendMail_2);
					}
				}
    		}else{
				mbpFile_tSendMail_2 = new javax.mail.internet.MimeBodyPart();
				fds_tSendMail_2 = new javax.activation.FileDataSource(filename_tSendMail_2);
				mbpFile_tSendMail_2.setDataHandler(new javax.activation.DataHandler(fds_tSendMail_2)); 
				mbpFile_tSendMail_2.setFileName(javax.mail.internet.MimeUtility.encodeText(fds_tSendMail_2.getName()));
				if(contentTransferEncoding_tSendMail_2.get(i_tSendMail_2).equalsIgnoreCase("base64")){
					mbpFile_tSendMail_2.setHeader("Content-Transfer-Encoding", "base64");
				}
				mp_tSendMail_2.addBodyPart(mbpFile_tSendMail_2);
			}
		}
		// -- set the content --
		msg_tSendMail_2.setContent(mp_tSendMail_2);
		// add handlers for main MIME types
		javax.activation.MailcapCommandMap mc_tSendMail_2 = ( javax.activation.MailcapCommandMap)javax.activation.CommandMap.getDefaultCommandMap();
		mc_tSendMail_2.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
		mc_tSendMail_2.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
		mc_tSendMail_2.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
		mc_tSendMail_2.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
		mc_tSendMail_2.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
		javax.activation.CommandMap.setDefaultCommandMap(mc_tSendMail_2);
		// add com.sun.mail.handlers to job imports / depenencies (TESB-27110)
		com.sun.mail.handlers.text_plain text_plain_h_tSendMail_2 = null;
		// -- Send the message --
		javax.mail.Transport.send(msg_tSendMail_2);
	} catch(java.lang.Exception e){
globalMap.put("tSendMail_2_ERROR_MESSAGE",e.getMessage());
  		
			throw(e);
		
	}finally{
		props_tSendMail_2.remove("mail.smtp.host");
		props_tSendMail_2.remove("mail.smtp.port");
		
		props_tSendMail_2.remove("mail.mime.encodefilename");
		
			props_tSendMail_2.remove("mail.smtp.starttls.enable");
		
		props_tSendMail_2.remove("mail.smtp.auth");     
	}

 


	tos_count_tSendMail_2++;

/**
 * [tSendMail_2 main ] stop
 */
	
	/**
	 * [tSendMail_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tSendMail_2";

	

 



/**
 * [tSendMail_2 process_data_begin ] stop
 */
	
	/**
	 * [tSendMail_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tSendMail_2";

	

 



/**
 * [tSendMail_2 process_data_end ] stop
 */
	
	/**
	 * [tSendMail_2 end ] start
	 */

	

	
	
	currentComponent="tSendMail_2";

	

 

ok_Hash.put("tSendMail_2", true);
end_Hash.put("tSendMail_2", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk8", 0, "ok");
				}
				tJava_2Process(globalMap);



/**
 * [tSendMail_2 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tSendMail_2 finally ] start
	 */

	

	
	
	currentComponent="tSendMail_2";

	

 



/**
 * [tSendMail_2 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tSendMail_2_SUBPROCESS_STATE", 1);
	}
	

public void tJava_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tJava_2_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tJava_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tJava_2", false);
		start_Hash.put("tJava_2", System.currentTimeMillis());
		
	
	currentComponent="tJava_2";

	
		int tos_count_tJava_2 = 0;
		


System.out.println("mail envoyer a  duplesse");
 



/**
 * [tJava_2 begin ] stop
 */
	
	/**
	 * [tJava_2 main ] start
	 */

	

	
	
	currentComponent="tJava_2";

	

 


	tos_count_tJava_2++;

/**
 * [tJava_2 main ] stop
 */
	
	/**
	 * [tJava_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tJava_2";

	

 



/**
 * [tJava_2 process_data_begin ] stop
 */
	
	/**
	 * [tJava_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tJava_2";

	

 



/**
 * [tJava_2 process_data_end ] stop
 */
	
	/**
	 * [tJava_2 end ] start
	 */

	

	
	
	currentComponent="tJava_2";

	

 

ok_Hash.put("tJava_2", true);
end_Hash.put("tJava_2", System.currentTimeMillis());




/**
 * [tJava_2 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tJava_2 finally ] start
	 */

	

	
	
	currentComponent="tJava_2";

	

 



/**
 * [tJava_2 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tJava_2_SUBPROCESS_STATE", 1);
	}
	

public void tJava_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tJava_3_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tJava_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tJava_3", false);
		start_Hash.put("tJava_3", System.currentTimeMillis());
		
	
	currentComponent="tJava_3";

	
		int tos_count_tJava_3 = 0;
		


System.out.println("erreur d'envoie : "+((String)globalMap.get("tSendMail_2_ERROR_MESSAGE")));
 



/**
 * [tJava_3 begin ] stop
 */
	
	/**
	 * [tJava_3 main ] start
	 */

	

	
	
	currentComponent="tJava_3";

	

 


	tos_count_tJava_3++;

/**
 * [tJava_3 main ] stop
 */
	
	/**
	 * [tJava_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tJava_3";

	

 



/**
 * [tJava_3 process_data_begin ] stop
 */
	
	/**
	 * [tJava_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tJava_3";

	

 



/**
 * [tJava_3 process_data_end ] stop
 */
	
	/**
	 * [tJava_3 end ] start
	 */

	

	
	
	currentComponent="tJava_3";

	

 

ok_Hash.put("tJava_3", true);
end_Hash.put("tJava_3", System.currentTimeMillis());




/**
 * [tJava_3 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tJava_3 finally ] start
	 */

	

	
	
	currentComponent="tJava_3";

	

 



/**
 * [tJava_3 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tJava_3_SUBPROCESS_STATE", 1);
	}
	

public void tDBCommit_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBCommit_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tDBCommit_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBCommit_1", false);
		start_Hash.put("tDBCommit_1", System.currentTimeMillis());
		
	
	currentComponent="tDBCommit_1";

	
		int tos_count_tDBCommit_1 = 0;
		

 



/**
 * [tDBCommit_1 begin ] stop
 */
	
	/**
	 * [tDBCommit_1 main ] start
	 */

	

	
	
	currentComponent="tDBCommit_1";

	

	java.sql.Connection conn_tDBCommit_1 = (java.sql.Connection)globalMap.get("conn_tDBConnection_2");

if(conn_tDBCommit_1 != null && !conn_tDBCommit_1.isClosed()) {
	
		try{
	
			
			conn_tDBCommit_1.commit();
			
	
		}finally{
			
			conn_tDBCommit_1.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_tDBConnection_2"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	    }
	
}

 


	tos_count_tDBCommit_1++;

/**
 * [tDBCommit_1 main ] stop
 */
	
	/**
	 * [tDBCommit_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBCommit_1";

	

 



/**
 * [tDBCommit_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBCommit_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBCommit_1";

	

 



/**
 * [tDBCommit_1 process_data_end ] stop
 */
	
	/**
	 * [tDBCommit_1 end ] start
	 */

	

	
	
	currentComponent="tDBCommit_1";

	

 

ok_Hash.put("tDBCommit_1", true);
end_Hash.put("tDBCommit_1", System.currentTimeMillis());




/**
 * [tDBCommit_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBCommit_1 finally ] start
	 */

	

	
	
	currentComponent="tDBCommit_1";

	

 



/**
 * [tDBCommit_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBCommit_1_SUBPROCESS_STATE", 1);
	}
	

public void tDBRollback_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBRollback_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tDBRollback_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBRollback_1", false);
		start_Hash.put("tDBRollback_1", System.currentTimeMillis());
		
	
	currentComponent="tDBRollback_1";

	
		int tos_count_tDBRollback_1 = 0;
		

 



/**
 * [tDBRollback_1 begin ] stop
 */
	
	/**
	 * [tDBRollback_1 main ] start
	 */

	

	
	
	currentComponent="tDBRollback_1";

	

	java.sql.Connection conn_tDBRollback_1 = (java.sql.Connection)globalMap.get("conn_tDBConnection_2");

if(conn_tDBRollback_1 != null && !conn_tDBRollback_1.isClosed()) {
	
		try{
			
			conn_tDBRollback_1.rollback();
			
		}finally{
	    	
			conn_tDBRollback_1.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_tDBConnection_2"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	    }
	
}

 


	tos_count_tDBRollback_1++;

/**
 * [tDBRollback_1 main ] stop
 */
	
	/**
	 * [tDBRollback_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBRollback_1";

	

 



/**
 * [tDBRollback_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBRollback_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBRollback_1";

	

 



/**
 * [tDBRollback_1 process_data_end ] stop
 */
	
	/**
	 * [tDBRollback_1 end ] start
	 */

	

	
	
	currentComponent="tDBRollback_1";

	

 

ok_Hash.put("tDBRollback_1", true);
end_Hash.put("tDBRollback_1", System.currentTimeMillis());




/**
 * [tDBRollback_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBRollback_1 finally ] start
	 */

	

	
	
	currentComponent="tDBRollback_1";

	

 



/**
 * [tDBRollback_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBRollback_1_SUBPROCESS_STATE", 1);
	}
	


public static class groupStruct implements routines.system.IPersistableComparableLookupRow<groupStruct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public double employee_id;

				public double getEmployee_id () {
					return this.employee_id;
				}
				
			    public String org_name;

				public String getOrg_name () {
					return this.org_name;
				}
				
			    public String country;

				public String getCountry () {
					return this.country;
				}
				
			    public Double org_level;

				public Double getOrg_level () {
					return this.org_level;
				}
				
			    public java.util.Date start_date;

				public java.util.Date getStart_date () {
					return this.start_date;
				}
				
			    public java.util.Date end_date;

				public java.util.Date getEnd_date () {
					return this.end_date;
				}
				
			    public Double org_ref_id;

				public Double getOrg_ref_id () {
					return this.org_ref_id;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.employee_id;
						
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final groupStruct other = (groupStruct) obj;
		
						if (this.employee_id != other.employee_id)
							return false;
					

		return true;
    }

	public void copyDataTo(groupStruct other) {

		other.employee_id = this.employee_id;
	            other.org_name = this.org_name;
	            other.country = this.country;
	            other.org_level = this.org_level;
	            other.start_date = this.start_date;
	            other.end_date = this.end_date;
	            other.org_ref_id = this.org_ref_id;
	            
	}

	public void copyKeysDataTo(groupStruct other) {

		other.employee_id = this.employee_id;
	            	
	}



	
	private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			dis.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			unmarshaller.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
	}

	private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
	}

	private java.util.Date readDate(DataInputStream dis, ObjectInputStream ois) throws IOException{
		java.util.Date dateReturn = null;
		int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller ) throws IOException{
		java.util.Date dateReturn = null;
		int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

	private void writeDate(java.util.Date date1, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
	}
	
	private void writeDate(java.util.Date date1, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
	}

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM) {

        	try {

        		int length = 0;
		
			        this.employee_id = dis.readDouble();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM) {

        	try {

        		int length = 0;
		
			        this.employee_id = dis.readDouble();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.employee_id);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.employee_id);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
						this.org_name = readString(dis,ois);
					
						this.country = readString(dis,ois);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.org_level = null;
           				} else {
           			    	this.org_level = dis.readDouble();
           				}
					
						this.start_date = readDate(dis,ois);
					
						this.end_date = readDate(dis,ois);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.org_ref_id = null;
           				} else {
           			    	this.org_ref_id = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
						this.org_name = readString(dis,objectIn);
					
						this.country = readString(dis,objectIn);
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.org_level = null;
           				} else {
           			    	this.org_level = objectIn.readDouble();
           				}
					
						this.start_date = readDate(dis,objectIn);
					
						this.end_date = readDate(dis,objectIn);
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.org_ref_id = null;
           				} else {
           			    	this.org_ref_id = objectIn.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
						writeString(this.org_name, dos, oos);
					
						writeString(this.country, dos, oos);
					
						if(this.org_level == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.org_level);
		            	}
					
						writeDate(this.start_date, dos, oos);
					
						writeDate(this.end_date, dos, oos);
					
						if(this.org_ref_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.org_ref_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						writeString(this.org_name, dos, objectOut);
					
						writeString(this.country, dos, objectOut);
					
						if(this.org_level == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.org_level);
		            	}
					
						writeDate(this.start_date, dos, objectOut);
					
						writeDate(this.end_date, dos, objectOut);
					
						if(this.org_ref_id == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.org_ref_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("employee_id="+String.valueOf(employee_id));
		sb.append(",org_name="+org_name);
		sb.append(",country="+country);
		sb.append(",org_level="+String.valueOf(org_level));
		sb.append(",start_date="+String.valueOf(start_date));
		sb.append(",end_date="+String.valueOf(end_date));
		sb.append(",org_ref_id="+String.valueOf(org_ref_id));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(groupStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.employee_id, other.employee_id);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_2_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		groupStruct group = new groupStruct();




	
	/**
	 * [tAdvancedHash_group begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_group", false);
		start_Hash.put("tAdvancedHash_group", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_group";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"group");
					}
				
		int tos_count_tAdvancedHash_group = 0;
		

			   		// connection name:group
			   		// source node:tDBInput_2 - inputs:(after_tDBInput_1) outputs:(group,group) | target node:tAdvancedHash_group - inputs:(group) outputs:()
			   		// linked node: tMap_1 - inputs:(employer,group) outputs:(filtrage_1)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_group = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<groupStruct> tHash_Lookup_group =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<groupStruct>getLookup(matchingModeEnum_group);
	   						   
		   	   	   globalMap.put("tHash_Lookup_group", tHash_Lookup_group);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_group begin ] stop
 */



	
	/**
	 * [tDBInput_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_2", false);
		start_Hash.put("tDBInput_2", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_2";

	
		int tos_count_tDBInput_2 = 0;
		
	
    
	
		    int nb_line_tDBInput_2 = 0;
		    java.sql.Connection conn_tDBInput_2 = null;
				conn_tDBInput_2 = (java.sql.Connection)globalMap.get("conn_tDBConnection_1");
				
		    
			java.sql.Statement stmt_tDBInput_2 = conn_tDBInput_2.createStatement();

		    String dbquery_tDBInput_2 = "SELECT ORGANIZATION.employee_id,\n		ORGANIZATION.org_name,\n		ORGANIZATION.country,\n		ORGANIZATION.org_level,\n		ORGANIZAT"
+"ION.start_date,\n		ORGANIZATION.end_date,\n		ORGANIZATION.org_ref_id\nFROM	ORGANIZATION";
		    

            	globalMap.put("tDBInput_2_QUERY",dbquery_tDBInput_2);
		    java.sql.ResultSet rs_tDBInput_2 = null;

		    try {
		    	rs_tDBInput_2 = stmt_tDBInput_2.executeQuery(dbquery_tDBInput_2);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_2 = rs_tDBInput_2.getMetaData();
		    	int colQtyInRs_tDBInput_2 = rsmd_tDBInput_2.getColumnCount();

		    String tmpContent_tDBInput_2 = null;
		    
		    
		    while (rs_tDBInput_2.next()) {
		        nb_line_tDBInput_2++;
		        
							if(colQtyInRs_tDBInput_2 < 1) {
								group.employee_id = 0;
							} else {
	                         		
            group.employee_id = rs_tDBInput_2.getDouble(1);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 2) {
								group.org_name = null;
							} else {
	                         		
        	group.org_name = routines.system.JDBCUtil.getString(rs_tDBInput_2, 2, false);
		                    }
							if(colQtyInRs_tDBInput_2 < 3) {
								group.country = null;
							} else {
	                         		
        	group.country = routines.system.JDBCUtil.getString(rs_tDBInput_2, 3, false);
		                    }
							if(colQtyInRs_tDBInput_2 < 4) {
								group.org_level = null;
							} else {
	                         		
            group.org_level = rs_tDBInput_2.getDouble(4);
            if(rs_tDBInput_2.wasNull()){
                    group.org_level = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 5) {
								group.start_date = null;
							} else {
										
			group.start_date = routines.system.JDBCUtil.getDate(rs_tDBInput_2, 5);
		                    }
							if(colQtyInRs_tDBInput_2 < 6) {
								group.end_date = null;
							} else {
										
			group.end_date = routines.system.JDBCUtil.getDate(rs_tDBInput_2, 6);
		                    }
							if(colQtyInRs_tDBInput_2 < 7) {
								group.org_ref_id = null;
							} else {
	                         		
            group.org_ref_id = rs_tDBInput_2.getDouble(7);
            if(rs_tDBInput_2.wasNull()){
                    group.org_ref_id = null;
            }
		                    }
					



 



/**
 * [tDBInput_2 begin ] stop
 */
	
	/**
	 * [tDBInput_2 main ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 


	tos_count_tDBInput_2++;

/**
 * [tDBInput_2 main ] stop
 */
	
	/**
	 * [tDBInput_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 



/**
 * [tDBInput_2 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_group main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_group";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"group"
						
						);
					}
					


			   
			   

					groupStruct group_HashRow = new groupStruct();
		   	   	   
				
				group_HashRow.employee_id = group.employee_id;
				
				group_HashRow.org_name = group.org_name;
				
				group_HashRow.country = group.country;
				
				group_HashRow.org_level = group.org_level;
				
				group_HashRow.start_date = group.start_date;
				
				group_HashRow.end_date = group.end_date;
				
				group_HashRow.org_ref_id = group.org_ref_id;
				
			tHash_Lookup_group.put(group_HashRow);
			
            




 


	tos_count_tAdvancedHash_group++;

/**
 * [tAdvancedHash_group main ] stop
 */
	
	/**
	 * [tAdvancedHash_group process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_group";

	

 



/**
 * [tAdvancedHash_group process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_group process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_group";

	

 



/**
 * [tAdvancedHash_group process_data_end ] stop
 */



	
	/**
	 * [tDBInput_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 



/**
 * [tDBInput_2 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_2 end ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

	}
}finally{
	if (rs_tDBInput_2 != null) {
		rs_tDBInput_2.close();
	}
	if (stmt_tDBInput_2 != null) {
		stmt_tDBInput_2.close();
	}
}
globalMap.put("tDBInput_2_NB_LINE",nb_line_tDBInput_2);

 

ok_Hash.put("tDBInput_2", true);
end_Hash.put("tDBInput_2", System.currentTimeMillis());




/**
 * [tDBInput_2 end ] stop
 */

	
	/**
	 * [tAdvancedHash_group end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_group";

	

tHash_Lookup_group.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"group");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_group", true);
end_Hash.put("tAdvancedHash_group", System.currentTimeMillis());




/**
 * [tAdvancedHash_group end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBInput_2 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 



/**
 * [tDBInput_2 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_group finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_group";

	

 



/**
 * [tAdvancedHash_group finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 1);
	}
	


public static class sectionStruct implements routines.system.IPersistableComparableLookupRow<sectionStruct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public double employee_id;

				public double getEmployee_id () {
					return this.employee_id;
				}
				
			    public String org_name;

				public String getOrg_name () {
					return this.org_name;
				}
				
			    public String country;

				public String getCountry () {
					return this.country;
				}
				
			    public Double org_level;

				public Double getOrg_level () {
					return this.org_level;
				}
				
			    public java.util.Date start_date;

				public java.util.Date getStart_date () {
					return this.start_date;
				}
				
			    public java.util.Date end_date;

				public java.util.Date getEnd_date () {
					return this.end_date;
				}
				
			    public Double org_ref_id;

				public Double getOrg_ref_id () {
					return this.org_ref_id;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.employee_id;
						
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final sectionStruct other = (sectionStruct) obj;
		
						if (this.employee_id != other.employee_id)
							return false;
					

		return true;
    }

	public void copyDataTo(sectionStruct other) {

		other.employee_id = this.employee_id;
	            other.org_name = this.org_name;
	            other.country = this.country;
	            other.org_level = this.org_level;
	            other.start_date = this.start_date;
	            other.end_date = this.end_date;
	            other.org_ref_id = this.org_ref_id;
	            
	}

	public void copyKeysDataTo(sectionStruct other) {

		other.employee_id = this.employee_id;
	            	
	}



	
	private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			dis.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			unmarshaller.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
	}

	private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
	}

	private java.util.Date readDate(DataInputStream dis, ObjectInputStream ois) throws IOException{
		java.util.Date dateReturn = null;
		int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller ) throws IOException{
		java.util.Date dateReturn = null;
		int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

	private void writeDate(java.util.Date date1, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
	}
	
	private void writeDate(java.util.Date date1, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
	}

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM) {

        	try {

        		int length = 0;
		
			        this.employee_id = dis.readDouble();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM) {

        	try {

        		int length = 0;
		
			        this.employee_id = dis.readDouble();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.employee_id);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.employee_id);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
						this.org_name = readString(dis,ois);
					
						this.country = readString(dis,ois);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.org_level = null;
           				} else {
           			    	this.org_level = dis.readDouble();
           				}
					
						this.start_date = readDate(dis,ois);
					
						this.end_date = readDate(dis,ois);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.org_ref_id = null;
           				} else {
           			    	this.org_ref_id = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
						this.org_name = readString(dis,objectIn);
					
						this.country = readString(dis,objectIn);
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.org_level = null;
           				} else {
           			    	this.org_level = objectIn.readDouble();
           				}
					
						this.start_date = readDate(dis,objectIn);
					
						this.end_date = readDate(dis,objectIn);
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.org_ref_id = null;
           				} else {
           			    	this.org_ref_id = objectIn.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
						writeString(this.org_name, dos, oos);
					
						writeString(this.country, dos, oos);
					
						if(this.org_level == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.org_level);
		            	}
					
						writeDate(this.start_date, dos, oos);
					
						writeDate(this.end_date, dos, oos);
					
						if(this.org_ref_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.org_ref_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						writeString(this.org_name, dos, objectOut);
					
						writeString(this.country, dos, objectOut);
					
						if(this.org_level == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.org_level);
		            	}
					
						writeDate(this.start_date, dos, objectOut);
					
						writeDate(this.end_date, dos, objectOut);
					
						if(this.org_ref_id == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.org_ref_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("employee_id="+String.valueOf(employee_id));
		sb.append(",org_name="+org_name);
		sb.append(",country="+country);
		sb.append(",org_level="+String.valueOf(org_level));
		sb.append(",start_date="+String.valueOf(start_date));
		sb.append(",end_date="+String.valueOf(end_date));
		sb.append(",org_ref_id="+String.valueOf(org_ref_id));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(sectionStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.employee_id, other.employee_id);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_3_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		sectionStruct section = new sectionStruct();




	
	/**
	 * [tAdvancedHash_section begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_section", false);
		start_Hash.put("tAdvancedHash_section", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_section";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"section");
					}
				
		int tos_count_tAdvancedHash_section = 0;
		

			   		// connection name:section
			   		// source node:tDBInput_3 - inputs:(after_tDBInput_1) outputs:(section,section) | target node:tAdvancedHash_section - inputs:(section) outputs:()
			   		// linked node: tMap_2 - inputs:(filtrage_1,section) outputs:(filtrage_2)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_section = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<sectionStruct> tHash_Lookup_section =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<sectionStruct>getLookup(matchingModeEnum_section);
	   						   
		   	   	   globalMap.put("tHash_Lookup_section", tHash_Lookup_section);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_section begin ] stop
 */



	
	/**
	 * [tDBInput_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_3", false);
		start_Hash.put("tDBInput_3", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_3";

	
		int tos_count_tDBInput_3 = 0;
		
	
    
	
		    int nb_line_tDBInput_3 = 0;
		    java.sql.Connection conn_tDBInput_3 = null;
				conn_tDBInput_3 = (java.sql.Connection)globalMap.get("conn_tDBConnection_1");
				
		    
			java.sql.Statement stmt_tDBInput_3 = conn_tDBInput_3.createStatement();

		    String dbquery_tDBInput_3 = "SELECT ORGANIZATION.employee_id,\n		ORGANIZATION.org_name,\n		ORGANIZATION.country,\n		ORGANIZATION.org_level,\n		ORGANIZAT"
+"ION.start_date,\n		ORGANIZATION.end_date,\n		ORGANIZATION.org_ref_id\nFROM	ORGANIZATION";
		    

            	globalMap.put("tDBInput_3_QUERY",dbquery_tDBInput_3);
		    java.sql.ResultSet rs_tDBInput_3 = null;

		    try {
		    	rs_tDBInput_3 = stmt_tDBInput_3.executeQuery(dbquery_tDBInput_3);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_3 = rs_tDBInput_3.getMetaData();
		    	int colQtyInRs_tDBInput_3 = rsmd_tDBInput_3.getColumnCount();

		    String tmpContent_tDBInput_3 = null;
		    
		    
		    while (rs_tDBInput_3.next()) {
		        nb_line_tDBInput_3++;
		        
							if(colQtyInRs_tDBInput_3 < 1) {
								section.employee_id = 0;
							} else {
	                         		
            section.employee_id = rs_tDBInput_3.getDouble(1);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 2) {
								section.org_name = null;
							} else {
	                         		
        	section.org_name = routines.system.JDBCUtil.getString(rs_tDBInput_3, 2, false);
		                    }
							if(colQtyInRs_tDBInput_3 < 3) {
								section.country = null;
							} else {
	                         		
        	section.country = routines.system.JDBCUtil.getString(rs_tDBInput_3, 3, false);
		                    }
							if(colQtyInRs_tDBInput_3 < 4) {
								section.org_level = null;
							} else {
	                         		
            section.org_level = rs_tDBInput_3.getDouble(4);
            if(rs_tDBInput_3.wasNull()){
                    section.org_level = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 5) {
								section.start_date = null;
							} else {
										
			section.start_date = routines.system.JDBCUtil.getDate(rs_tDBInput_3, 5);
		                    }
							if(colQtyInRs_tDBInput_3 < 6) {
								section.end_date = null;
							} else {
										
			section.end_date = routines.system.JDBCUtil.getDate(rs_tDBInput_3, 6);
		                    }
							if(colQtyInRs_tDBInput_3 < 7) {
								section.org_ref_id = null;
							} else {
	                         		
            section.org_ref_id = rs_tDBInput_3.getDouble(7);
            if(rs_tDBInput_3.wasNull()){
                    section.org_ref_id = null;
            }
		                    }
					



 



/**
 * [tDBInput_3 begin ] stop
 */
	
	/**
	 * [tDBInput_3 main ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 


	tos_count_tDBInput_3++;

/**
 * [tDBInput_3 main ] stop
 */
	
	/**
	 * [tDBInput_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 



/**
 * [tDBInput_3 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_section main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_section";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"section"
						
						);
					}
					


			   
			   

					sectionStruct section_HashRow = new sectionStruct();
		   	   	   
				
				section_HashRow.employee_id = section.employee_id;
				
				section_HashRow.org_name = section.org_name;
				
				section_HashRow.country = section.country;
				
				section_HashRow.org_level = section.org_level;
				
				section_HashRow.start_date = section.start_date;
				
				section_HashRow.end_date = section.end_date;
				
				section_HashRow.org_ref_id = section.org_ref_id;
				
			tHash_Lookup_section.put(section_HashRow);
			
            




 


	tos_count_tAdvancedHash_section++;

/**
 * [tAdvancedHash_section main ] stop
 */
	
	/**
	 * [tAdvancedHash_section process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_section";

	

 



/**
 * [tAdvancedHash_section process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_section process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_section";

	

 



/**
 * [tAdvancedHash_section process_data_end ] stop
 */



	
	/**
	 * [tDBInput_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 



/**
 * [tDBInput_3 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_3 end ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

	}
}finally{
	if (rs_tDBInput_3 != null) {
		rs_tDBInput_3.close();
	}
	if (stmt_tDBInput_3 != null) {
		stmt_tDBInput_3.close();
	}
}
globalMap.put("tDBInput_3_NB_LINE",nb_line_tDBInput_3);

 

ok_Hash.put("tDBInput_3", true);
end_Hash.put("tDBInput_3", System.currentTimeMillis());




/**
 * [tDBInput_3 end ] stop
 */

	
	/**
	 * [tAdvancedHash_section end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_section";

	

tHash_Lookup_section.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"section");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_section", true);
end_Hash.put("tAdvancedHash_section", System.currentTimeMillis());




/**
 * [tAdvancedHash_section end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBInput_3 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 



/**
 * [tDBInput_3 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_section finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_section";

	

 



/**
 * [tAdvancedHash_section finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_3_SUBPROCESS_STATE", 1);
	}
	


public static class departementStruct implements routines.system.IPersistableComparableLookupRow<departementStruct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public Double employee_id;

				public Double getEmployee_id () {
					return this.employee_id;
				}
				
			    public String org_name;

				public String getOrg_name () {
					return this.org_name;
				}
				
			    public String country;

				public String getCountry () {
					return this.country;
				}
				
			    public Double org_level;

				public Double getOrg_level () {
					return this.org_level;
				}
				
			    public java.util.Date start_date;

				public java.util.Date getStart_date () {
					return this.start_date;
				}
				
			    public java.util.Date end_date;

				public java.util.Date getEnd_date () {
					return this.end_date;
				}
				
			    public Double org_ref_id;

				public Double getOrg_ref_id () {
					return this.org_ref_id;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.employee_id == null) ? 0 : this.employee_id.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final departementStruct other = (departementStruct) obj;
		
						if (this.employee_id == null) {
							if (other.employee_id != null)
								return false;
						
						} else if (!this.employee_id.equals(other.employee_id))
						
							return false;
					

		return true;
    }

	public void copyDataTo(departementStruct other) {

		other.employee_id = this.employee_id;
	            other.org_name = this.org_name;
	            other.country = this.country;
	            other.org_level = this.org_level;
	            other.start_date = this.start_date;
	            other.end_date = this.end_date;
	            other.org_ref_id = this.org_ref_id;
	            
	}

	public void copyKeysDataTo(departementStruct other) {

		other.employee_id = this.employee_id;
	            	
	}



	
	private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			dis.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			unmarshaller.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
	}

	private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
	}

	private java.util.Date readDate(DataInputStream dis, ObjectInputStream ois) throws IOException{
		java.util.Date dateReturn = null;
		int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller ) throws IOException{
		java.util.Date dateReturn = null;
		int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

	private void writeDate(java.util.Date date1, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
	}
	
	private void writeDate(java.util.Date date1, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
	}

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.employee_id = null;
           				} else {
           			    	this.employee_id = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.employee_id = null;
           				} else {
           			    	this.employee_id = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// Double
				
						if(this.employee_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.employee_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Double
				
						if(this.employee_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.employee_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
						this.org_name = readString(dis,ois);
					
						this.country = readString(dis,ois);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.org_level = null;
           				} else {
           			    	this.org_level = dis.readDouble();
           				}
					
						this.start_date = readDate(dis,ois);
					
						this.end_date = readDate(dis,ois);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.org_ref_id = null;
           				} else {
           			    	this.org_ref_id = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
						this.org_name = readString(dis,objectIn);
					
						this.country = readString(dis,objectIn);
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.org_level = null;
           				} else {
           			    	this.org_level = objectIn.readDouble();
           				}
					
						this.start_date = readDate(dis,objectIn);
					
						this.end_date = readDate(dis,objectIn);
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.org_ref_id = null;
           				} else {
           			    	this.org_ref_id = objectIn.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
						writeString(this.org_name, dos, oos);
					
						writeString(this.country, dos, oos);
					
						if(this.org_level == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.org_level);
		            	}
					
						writeDate(this.start_date, dos, oos);
					
						writeDate(this.end_date, dos, oos);
					
						if(this.org_ref_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.org_ref_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						writeString(this.org_name, dos, objectOut);
					
						writeString(this.country, dos, objectOut);
					
						if(this.org_level == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.org_level);
		            	}
					
						writeDate(this.start_date, dos, objectOut);
					
						writeDate(this.end_date, dos, objectOut);
					
						if(this.org_ref_id == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.org_ref_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("employee_id="+String.valueOf(employee_id));
		sb.append(",org_name="+org_name);
		sb.append(",country="+country);
		sb.append(",org_level="+String.valueOf(org_level));
		sb.append(",start_date="+String.valueOf(start_date));
		sb.append(",end_date="+String.valueOf(end_date));
		sb.append(",org_ref_id="+String.valueOf(org_ref_id));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(departementStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.employee_id, other.employee_id);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_5Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_5_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		departementStruct departement = new departementStruct();




	
	/**
	 * [tAdvancedHash_departement begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_departement", false);
		start_Hash.put("tAdvancedHash_departement", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_departement";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"departement");
					}
				
		int tos_count_tAdvancedHash_departement = 0;
		

			   		// connection name:departement
			   		// source node:tDBInput_5 - inputs:(after_tDBInput_1) outputs:(departement,departement) | target node:tAdvancedHash_departement - inputs:(departement) outputs:()
			   		// linked node: tMap_3 - inputs:(filtrage_2,departement) outputs:(filtrage_3)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_departement = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<departementStruct> tHash_Lookup_departement =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<departementStruct>getLookup(matchingModeEnum_departement);
	   						   
		   	   	   globalMap.put("tHash_Lookup_departement", tHash_Lookup_departement);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_departement begin ] stop
 */



	
	/**
	 * [tDBInput_5 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_5", false);
		start_Hash.put("tDBInput_5", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_5";

	
		int tos_count_tDBInput_5 = 0;
		
	
    
	
		    int nb_line_tDBInput_5 = 0;
		    java.sql.Connection conn_tDBInput_5 = null;
				conn_tDBInput_5 = (java.sql.Connection)globalMap.get("conn_tDBConnection_1");
				
		    
			java.sql.Statement stmt_tDBInput_5 = conn_tDBInput_5.createStatement();

		    String dbquery_tDBInput_5 = "SELECT ORGANIZATION.employee_id,\n		ORGANIZATION.org_name,\n		ORGANIZATION.country,\n		ORGANIZATION.org_level,\n		ORGANIZAT"
+"ION.start_date,\n		ORGANIZATION.end_date,\n		ORGANIZATION.org_ref_id\nFROM	ORGANIZATION";
		    

            	globalMap.put("tDBInput_5_QUERY",dbquery_tDBInput_5);
		    java.sql.ResultSet rs_tDBInput_5 = null;

		    try {
		    	rs_tDBInput_5 = stmt_tDBInput_5.executeQuery(dbquery_tDBInput_5);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_5 = rs_tDBInput_5.getMetaData();
		    	int colQtyInRs_tDBInput_5 = rsmd_tDBInput_5.getColumnCount();

		    String tmpContent_tDBInput_5 = null;
		    
		    
		    while (rs_tDBInput_5.next()) {
		        nb_line_tDBInput_5++;
		        
							if(colQtyInRs_tDBInput_5 < 1) {
								departement.employee_id = null;
							} else {
	                         		
            departement.employee_id = rs_tDBInput_5.getDouble(1);
            if(rs_tDBInput_5.wasNull()){
                    departement.employee_id = null;
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 2) {
								departement.org_name = null;
							} else {
	                         		
        	departement.org_name = routines.system.JDBCUtil.getString(rs_tDBInput_5, 2, false);
		                    }
							if(colQtyInRs_tDBInput_5 < 3) {
								departement.country = null;
							} else {
	                         		
        	departement.country = routines.system.JDBCUtil.getString(rs_tDBInput_5, 3, false);
		                    }
							if(colQtyInRs_tDBInput_5 < 4) {
								departement.org_level = null;
							} else {
	                         		
            departement.org_level = rs_tDBInput_5.getDouble(4);
            if(rs_tDBInput_5.wasNull()){
                    departement.org_level = null;
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 5) {
								departement.start_date = null;
							} else {
										
			departement.start_date = routines.system.JDBCUtil.getDate(rs_tDBInput_5, 5);
		                    }
							if(colQtyInRs_tDBInput_5 < 6) {
								departement.end_date = null;
							} else {
										
			departement.end_date = routines.system.JDBCUtil.getDate(rs_tDBInput_5, 6);
		                    }
							if(colQtyInRs_tDBInput_5 < 7) {
								departement.org_ref_id = null;
							} else {
	                         		
            departement.org_ref_id = rs_tDBInput_5.getDouble(7);
            if(rs_tDBInput_5.wasNull()){
                    departement.org_ref_id = null;
            }
		                    }
					



 



/**
 * [tDBInput_5 begin ] stop
 */
	
	/**
	 * [tDBInput_5 main ] start
	 */

	

	
	
	currentComponent="tDBInput_5";

	

 


	tos_count_tDBInput_5++;

/**
 * [tDBInput_5 main ] stop
 */
	
	/**
	 * [tDBInput_5 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_5";

	

 



/**
 * [tDBInput_5 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_departement main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_departement";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"departement"
						
						);
					}
					


			   
			   

					departementStruct departement_HashRow = new departementStruct();
		   	   	   
				
				departement_HashRow.employee_id = departement.employee_id;
				
				departement_HashRow.org_name = departement.org_name;
				
				departement_HashRow.country = departement.country;
				
				departement_HashRow.org_level = departement.org_level;
				
				departement_HashRow.start_date = departement.start_date;
				
				departement_HashRow.end_date = departement.end_date;
				
				departement_HashRow.org_ref_id = departement.org_ref_id;
				
			tHash_Lookup_departement.put(departement_HashRow);
			
            




 


	tos_count_tAdvancedHash_departement++;

/**
 * [tAdvancedHash_departement main ] stop
 */
	
	/**
	 * [tAdvancedHash_departement process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_departement";

	

 



/**
 * [tAdvancedHash_departement process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_departement process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_departement";

	

 



/**
 * [tAdvancedHash_departement process_data_end ] stop
 */



	
	/**
	 * [tDBInput_5 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_5";

	

 



/**
 * [tDBInput_5 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_5 end ] start
	 */

	

	
	
	currentComponent="tDBInput_5";

	

	}
}finally{
	if (rs_tDBInput_5 != null) {
		rs_tDBInput_5.close();
	}
	if (stmt_tDBInput_5 != null) {
		stmt_tDBInput_5.close();
	}
}
globalMap.put("tDBInput_5_NB_LINE",nb_line_tDBInput_5);

 

ok_Hash.put("tDBInput_5", true);
end_Hash.put("tDBInput_5", System.currentTimeMillis());




/**
 * [tDBInput_5 end ] stop
 */

	
	/**
	 * [tAdvancedHash_departement end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_departement";

	

tHash_Lookup_departement.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"departement");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_departement", true);
end_Hash.put("tAdvancedHash_departement", System.currentTimeMillis());




/**
 * [tAdvancedHash_departement end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBInput_5 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_5";

	

 



/**
 * [tDBInput_5 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_departement finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_departement";

	

 



/**
 * [tAdvancedHash_departement finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_5_SUBPROCESS_STATE", 1);
	}
	


public static class compagnyStruct implements routines.system.IPersistableComparableLookupRow<compagnyStruct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public Double employee_id;

				public Double getEmployee_id () {
					return this.employee_id;
				}
				
			    public String org_name;

				public String getOrg_name () {
					return this.org_name;
				}
				
			    public String country;

				public String getCountry () {
					return this.country;
				}
				
			    public Double org_level;

				public Double getOrg_level () {
					return this.org_level;
				}
				
			    public java.util.Date start_date;

				public java.util.Date getStart_date () {
					return this.start_date;
				}
				
			    public java.util.Date end_date;

				public java.util.Date getEnd_date () {
					return this.end_date;
				}
				
			    public Double org_ref_id;

				public Double getOrg_ref_id () {
					return this.org_ref_id;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.employee_id == null) ? 0 : this.employee_id.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final compagnyStruct other = (compagnyStruct) obj;
		
						if (this.employee_id == null) {
							if (other.employee_id != null)
								return false;
						
						} else if (!this.employee_id.equals(other.employee_id))
						
							return false;
					

		return true;
    }

	public void copyDataTo(compagnyStruct other) {

		other.employee_id = this.employee_id;
	            other.org_name = this.org_name;
	            other.country = this.country;
	            other.org_level = this.org_level;
	            other.start_date = this.start_date;
	            other.end_date = this.end_date;
	            other.org_ref_id = this.org_ref_id;
	            
	}

	public void copyKeysDataTo(compagnyStruct other) {

		other.employee_id = this.employee_id;
	            	
	}



	
	private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			dis.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			unmarshaller.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
	}

	private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
	}

	private java.util.Date readDate(DataInputStream dis, ObjectInputStream ois) throws IOException{
		java.util.Date dateReturn = null;
		int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller ) throws IOException{
		java.util.Date dateReturn = null;
		int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

	private void writeDate(java.util.Date date1, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
	}
	
	private void writeDate(java.util.Date date1, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
	}

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.employee_id = null;
           				} else {
           			    	this.employee_id = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.employee_id = null;
           				} else {
           			    	this.employee_id = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// Double
				
						if(this.employee_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.employee_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Double
				
						if(this.employee_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.employee_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
						this.org_name = readString(dis,ois);
					
						this.country = readString(dis,ois);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.org_level = null;
           				} else {
           			    	this.org_level = dis.readDouble();
           				}
					
						this.start_date = readDate(dis,ois);
					
						this.end_date = readDate(dis,ois);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.org_ref_id = null;
           				} else {
           			    	this.org_ref_id = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
						this.org_name = readString(dis,objectIn);
					
						this.country = readString(dis,objectIn);
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.org_level = null;
           				} else {
           			    	this.org_level = objectIn.readDouble();
           				}
					
						this.start_date = readDate(dis,objectIn);
					
						this.end_date = readDate(dis,objectIn);
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.org_ref_id = null;
           				} else {
           			    	this.org_ref_id = objectIn.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
						writeString(this.org_name, dos, oos);
					
						writeString(this.country, dos, oos);
					
						if(this.org_level == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.org_level);
		            	}
					
						writeDate(this.start_date, dos, oos);
					
						writeDate(this.end_date, dos, oos);
					
						if(this.org_ref_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.org_ref_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						writeString(this.org_name, dos, objectOut);
					
						writeString(this.country, dos, objectOut);
					
						if(this.org_level == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.org_level);
		            	}
					
						writeDate(this.start_date, dos, objectOut);
					
						writeDate(this.end_date, dos, objectOut);
					
						if(this.org_ref_id == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.org_ref_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("employee_id="+String.valueOf(employee_id));
		sb.append(",org_name="+org_name);
		sb.append(",country="+country);
		sb.append(",org_level="+String.valueOf(org_level));
		sb.append(",start_date="+String.valueOf(start_date));
		sb.append(",end_date="+String.valueOf(end_date));
		sb.append(",org_ref_id="+String.valueOf(org_ref_id));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(compagnyStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.employee_id, other.employee_id);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_4Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_4_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		compagnyStruct compagny = new compagnyStruct();




	
	/**
	 * [tAdvancedHash_compagny begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_compagny", false);
		start_Hash.put("tAdvancedHash_compagny", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_compagny";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"compagny");
					}
				
		int tos_count_tAdvancedHash_compagny = 0;
		

			   		// connection name:compagny
			   		// source node:tDBInput_4 - inputs:(after_tDBInput_1) outputs:(compagny,compagny) | target node:tAdvancedHash_compagny - inputs:(compagny) outputs:()
			   		// linked node: tMap_4 - inputs:(filtrage_3,compagny) outputs:(filtrage_4)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_compagny = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<compagnyStruct> tHash_Lookup_compagny =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<compagnyStruct>getLookup(matchingModeEnum_compagny);
	   						   
		   	   	   globalMap.put("tHash_Lookup_compagny", tHash_Lookup_compagny);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_compagny begin ] stop
 */



	
	/**
	 * [tDBInput_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_4", false);
		start_Hash.put("tDBInput_4", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_4";

	
		int tos_count_tDBInput_4 = 0;
		
	
    
	
		    int nb_line_tDBInput_4 = 0;
		    java.sql.Connection conn_tDBInput_4 = null;
				conn_tDBInput_4 = (java.sql.Connection)globalMap.get("conn_tDBConnection_1");
				
		    
			java.sql.Statement stmt_tDBInput_4 = conn_tDBInput_4.createStatement();

		    String dbquery_tDBInput_4 = "SELECT ORGANIZATION.employee_id,\n		ORGANIZATION.org_name,\n		ORGANIZATION.country,\n		ORGANIZATION.org_level,\n		ORGANIZAT"
+"ION.start_date,\n		ORGANIZATION.end_date,\n		ORGANIZATION.org_ref_id\nFROM	ORGANIZATION";
		    

            	globalMap.put("tDBInput_4_QUERY",dbquery_tDBInput_4);
		    java.sql.ResultSet rs_tDBInput_4 = null;

		    try {
		    	rs_tDBInput_4 = stmt_tDBInput_4.executeQuery(dbquery_tDBInput_4);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_4 = rs_tDBInput_4.getMetaData();
		    	int colQtyInRs_tDBInput_4 = rsmd_tDBInput_4.getColumnCount();

		    String tmpContent_tDBInput_4 = null;
		    
		    
		    while (rs_tDBInput_4.next()) {
		        nb_line_tDBInput_4++;
		        
							if(colQtyInRs_tDBInput_4 < 1) {
								compagny.employee_id = null;
							} else {
	                         		
            compagny.employee_id = rs_tDBInput_4.getDouble(1);
            if(rs_tDBInput_4.wasNull()){
                    compagny.employee_id = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 2) {
								compagny.org_name = null;
							} else {
	                         		
        	compagny.org_name = routines.system.JDBCUtil.getString(rs_tDBInput_4, 2, false);
		                    }
							if(colQtyInRs_tDBInput_4 < 3) {
								compagny.country = null;
							} else {
	                         		
        	compagny.country = routines.system.JDBCUtil.getString(rs_tDBInput_4, 3, false);
		                    }
							if(colQtyInRs_tDBInput_4 < 4) {
								compagny.org_level = null;
							} else {
	                         		
            compagny.org_level = rs_tDBInput_4.getDouble(4);
            if(rs_tDBInput_4.wasNull()){
                    compagny.org_level = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 5) {
								compagny.start_date = null;
							} else {
										
			compagny.start_date = routines.system.JDBCUtil.getDate(rs_tDBInput_4, 5);
		                    }
							if(colQtyInRs_tDBInput_4 < 6) {
								compagny.end_date = null;
							} else {
										
			compagny.end_date = routines.system.JDBCUtil.getDate(rs_tDBInput_4, 6);
		                    }
							if(colQtyInRs_tDBInput_4 < 7) {
								compagny.org_ref_id = null;
							} else {
	                         		
            compagny.org_ref_id = rs_tDBInput_4.getDouble(7);
            if(rs_tDBInput_4.wasNull()){
                    compagny.org_ref_id = null;
            }
		                    }
					



 



/**
 * [tDBInput_4 begin ] stop
 */
	
	/**
	 * [tDBInput_4 main ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 


	tos_count_tDBInput_4++;

/**
 * [tDBInput_4 main ] stop
 */
	
	/**
	 * [tDBInput_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 



/**
 * [tDBInput_4 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_compagny main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_compagny";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"compagny"
						
						);
					}
					


			   
			   

					compagnyStruct compagny_HashRow = new compagnyStruct();
		   	   	   
				
				compagny_HashRow.employee_id = compagny.employee_id;
				
				compagny_HashRow.org_name = compagny.org_name;
				
				compagny_HashRow.country = compagny.country;
				
				compagny_HashRow.org_level = compagny.org_level;
				
				compagny_HashRow.start_date = compagny.start_date;
				
				compagny_HashRow.end_date = compagny.end_date;
				
				compagny_HashRow.org_ref_id = compagny.org_ref_id;
				
			tHash_Lookup_compagny.put(compagny_HashRow);
			
            




 


	tos_count_tAdvancedHash_compagny++;

/**
 * [tAdvancedHash_compagny main ] stop
 */
	
	/**
	 * [tAdvancedHash_compagny process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_compagny";

	

 



/**
 * [tAdvancedHash_compagny process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_compagny process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_compagny";

	

 



/**
 * [tAdvancedHash_compagny process_data_end ] stop
 */



	
	/**
	 * [tDBInput_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 



/**
 * [tDBInput_4 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_4 end ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

	}
}finally{
	if (rs_tDBInput_4 != null) {
		rs_tDBInput_4.close();
	}
	if (stmt_tDBInput_4 != null) {
		stmt_tDBInput_4.close();
	}
}
globalMap.put("tDBInput_4_NB_LINE",nb_line_tDBInput_4);

 

ok_Hash.put("tDBInput_4", true);
end_Hash.put("tDBInput_4", System.currentTimeMillis());




/**
 * [tDBInput_4 end ] stop
 */

	
	/**
	 * [tAdvancedHash_compagny end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_compagny";

	

tHash_Lookup_compagny.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"compagny");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_compagny", true);
end_Hash.put("tAdvancedHash_compagny", System.currentTimeMillis());




/**
 * [tAdvancedHash_compagny end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBInput_4 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 



/**
 * [tDBInput_4 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_compagny finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_compagny";

	

 



/**
 * [tAdvancedHash_compagny finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_4_SUBPROCESS_STATE", 1);
	}
	


public static class staffStruct implements routines.system.IPersistableComparableLookupRow<staffStruct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public Integer Employee_ID;

				public Integer getEmployee_ID () {
					return this.Employee_ID;
				}
				
			    public java.util.Date Start_Date;

				public java.util.Date getStart_Date () {
					return this.Start_Date;
				}
				
			    public java.util.Date End_Date;

				public java.util.Date getEnd_Date () {
					return this.End_Date;
				}
				
			    public String Job_Title;

				public String getJob_Title () {
					return this.Job_Title;
				}
				
			    public BigDecimal Salary;

				public BigDecimal getSalary () {
					return this.Salary;
				}
				
			    public Character Gender;

				public Character getGender () {
					return this.Gender;
				}
				
			    public java.util.Date Birth_Date;

				public java.util.Date getBirth_Date () {
					return this.Birth_Date;
				}
				
			    public java.util.Date Emp_Hire_Date;

				public java.util.Date getEmp_Hire_Date () {
					return this.Emp_Hire_Date;
				}
				
			    public java.util.Date Emp_Term_Date;

				public java.util.Date getEmp_Term_Date () {
					return this.Emp_Term_Date;
				}
				
			    public Integer Manager_ID;

				public Integer getManager_ID () {
					return this.Manager_ID;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.Employee_ID == null) ? 0 : this.Employee_ID.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final staffStruct other = (staffStruct) obj;
		
						if (this.Employee_ID == null) {
							if (other.Employee_ID != null)
								return false;
						
						} else if (!this.Employee_ID.equals(other.Employee_ID))
						
							return false;
					

		return true;
    }

	public void copyDataTo(staffStruct other) {

		other.Employee_ID = this.Employee_ID;
	            other.Start_Date = this.Start_Date;
	            other.End_Date = this.End_Date;
	            other.Job_Title = this.Job_Title;
	            other.Salary = this.Salary;
	            other.Gender = this.Gender;
	            other.Birth_Date = this.Birth_Date;
	            other.Emp_Hire_Date = this.Emp_Hire_Date;
	            other.Emp_Term_Date = this.Emp_Term_Date;
	            other.Manager_ID = this.Manager_ID;
	            
	}

	public void copyKeysDataTo(staffStruct other) {

		other.Employee_ID = this.Employee_ID;
	            	
	}



	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private java.util.Date readDate(DataInputStream dis, ObjectInputStream ois) throws IOException{
		java.util.Date dateReturn = null;
		int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller ) throws IOException{
		java.util.Date dateReturn = null;
		int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

	private void writeDate(java.util.Date date1, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
	}
	
	private void writeDate(java.util.Date date1, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
	}
	
	private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			dis.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			unmarshaller.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
	}

	private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
	}
	private Integer readInteger(DataInputStream dis, ObjectInputStream ois) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
			intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		Integer intReturn;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
			intReturn = unmarshaller.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, DataOutputStream dos,org.jboss.marshalling.Marshaller marshaller ) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM) {

        	try {

        		int length = 0;
		
						this.Employee_ID = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Organisation_DIM) {

        	try {

        		int length = 0;
		
						this.Employee_ID = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.Employee_ID,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.Employee_ID,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
						this.Start_Date = readDate(dis,ois);
					
						this.End_Date = readDate(dis,ois);
					
						this.Job_Title = readString(dis,ois);
					
       			    	this.Salary = (BigDecimal) ois.readObject();
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Gender = null;
           				} else {
           			    	this.Gender = dis.readChar();
           				}
					
						this.Birth_Date = readDate(dis,ois);
					
						this.Emp_Hire_Date = readDate(dis,ois);
					
						this.Emp_Term_Date = readDate(dis,ois);
					
						this.Manager_ID = readInteger(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
						this.Start_Date = readDate(dis,objectIn);
					
						this.End_Date = readDate(dis,objectIn);
					
						this.Job_Title = readString(dis,objectIn);
					
       			    	this.Salary = (BigDecimal) objectIn.readObject();
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.Gender = null;
           				} else {
           			    	this.Gender = objectIn.readChar();
           				}
					
						this.Birth_Date = readDate(dis,objectIn);
					
						this.Emp_Hire_Date = readDate(dis,objectIn);
					
						this.Emp_Term_Date = readDate(dis,objectIn);
					
						this.Manager_ID = readInteger(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
						writeDate(this.Start_Date, dos, oos);
					
						writeDate(this.End_Date, dos, oos);
					
						writeString(this.Job_Title, dos, oos);
					
       			    	oos.writeObject(this.Salary);
					
						if(this.Gender == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeChar(this.Gender);
		            	}
					
						writeDate(this.Birth_Date, dos, oos);
					
						writeDate(this.Emp_Hire_Date, dos, oos);
					
						writeDate(this.Emp_Term_Date, dos, oos);
					
					writeInteger(this.Manager_ID, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						writeDate(this.Start_Date, dos, objectOut);
					
						writeDate(this.End_Date, dos, objectOut);
					
						writeString(this.Job_Title, dos, objectOut);
					
       			    	objectOut.writeObject(this.Salary);
					
						if(this.Gender == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeChar(this.Gender);
		            	}
					
						writeDate(this.Birth_Date, dos, objectOut);
					
						writeDate(this.Emp_Hire_Date, dos, objectOut);
					
						writeDate(this.Emp_Term_Date, dos, objectOut);
					
					writeInteger(this.Manager_ID, dos, objectOut);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Employee_ID="+String.valueOf(Employee_ID));
		sb.append(",Start_Date="+String.valueOf(Start_Date));
		sb.append(",End_Date="+String.valueOf(End_Date));
		sb.append(",Job_Title="+Job_Title);
		sb.append(",Salary="+String.valueOf(Salary));
		sb.append(",Gender="+String.valueOf(Gender));
		sb.append(",Birth_Date="+String.valueOf(Birth_Date));
		sb.append(",Emp_Hire_Date="+String.valueOf(Emp_Hire_Date));
		sb.append(",Emp_Term_Date="+String.valueOf(Emp_Term_Date));
		sb.append(",Manager_ID="+String.valueOf(Manager_ID));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(staffStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.Employee_ID, other.Employee_ID);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tFileInputExcel_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFileInputExcel_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		staffStruct staff = new staffStruct();




	
	/**
	 * [tAdvancedHash_staff begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_staff", false);
		start_Hash.put("tAdvancedHash_staff", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_staff";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"staff");
					}
				
		int tos_count_tAdvancedHash_staff = 0;
		

			   		// connection name:staff
			   		// source node:tFileInputExcel_1 - inputs:(after_tDBInput_1) outputs:(staff,staff) | target node:tAdvancedHash_staff - inputs:(staff) outputs:()
			   		// linked node: tMap_5 - inputs:(filtrage_4,staff) outputs:(fitre_final)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_staff = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<staffStruct> tHash_Lookup_staff =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<staffStruct>getLookup(matchingModeEnum_staff);
	   						   
		   	   	   globalMap.put("tHash_Lookup_staff", tHash_Lookup_staff);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_staff begin ] stop
 */



	
	/**
	 * [tFileInputExcel_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputExcel_1", false);
		start_Hash.put("tFileInputExcel_1", System.currentTimeMillis());
		
	
	currentComponent="tFileInputExcel_1";

	
		int tos_count_tFileInputExcel_1 = 0;
		



			class RegexUtil_tFileInputExcel_1 {

		    	public java.util.List<jxl.Sheet> getSheets(jxl.Workbook workbook, String oneSheetName, boolean useRegex) {

			        java.util.List<jxl.Sheet> list = new java.util.ArrayList<jxl.Sheet>();

			        if(useRegex){//this part process the regex issue

				        jxl.Sheet[] sheets = workbook.getSheets();
				        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(oneSheetName);
				        for (int i = 0; i < sheets.length; i++) {
				            String sheetName = sheets[i].getName();
				            java.util.regex.Matcher matcher = pattern.matcher(sheetName);
				            if (matcher.matches()) {
				            	jxl.Sheet sheet = workbook.getSheet(sheetName);
				            	if(sheet != null){
				                	list.add(sheet);
				                }
				            }
				        }

			        }else{
			        	jxl.Sheet sheet = workbook.getSheet(oneSheetName);
		            	if(sheet != null){
		                	list.add(sheet);
		                }

			        }

			        return list;
			    }

			    public java.util.List<jxl.Sheet> getSheets(jxl.Workbook workbook, int index, boolean useRegex) {
			    	java.util.List<jxl.Sheet> list =  new java.util.ArrayList<jxl.Sheet>();
			    	jxl.Sheet sheet = workbook.getSheet(index);
	            	if(sheet != null){
	                	list.add(sheet);
	                }
			    	return list;
			    }

			}


		RegexUtil_tFileInputExcel_1 regexUtil_tFileInputExcel_1 = new RegexUtil_tFileInputExcel_1();
		final jxl.WorkbookSettings workbookSettings_tFileInputExcel_1 = new jxl.WorkbookSettings();
		workbookSettings_tFileInputExcel_1.setDrawingsDisabled(true);
        workbookSettings_tFileInputExcel_1.setEncoding("UTF-8");

        Object source_tFileInputExcel_1 ="/home/duplesse/Téléchargements/societe_orion-master/enonce/staff.xls";
        final jxl.Workbook workbook_tFileInputExcel_1;

        java.io.InputStream toClose_tFileInputExcel_1 = null;
        java.io.BufferedInputStream buffIStreamtFileInputExcel_1 = null;
        try {
            if(source_tFileInputExcel_1 instanceof java.io.InputStream){
        		toClose_tFileInputExcel_1 = (java.io.InputStream)source_tFileInputExcel_1;
        		buffIStreamtFileInputExcel_1 = new java.io.BufferedInputStream(toClose_tFileInputExcel_1);
        		workbook_tFileInputExcel_1 = jxl.Workbook.getWorkbook(buffIStreamtFileInputExcel_1, workbookSettings_tFileInputExcel_1);
            }else if(source_tFileInputExcel_1 instanceof String){
        		toClose_tFileInputExcel_1 = new java.io.FileInputStream(source_tFileInputExcel_1.toString());
        		buffIStreamtFileInputExcel_1 = new java.io.BufferedInputStream(toClose_tFileInputExcel_1);
        		workbook_tFileInputExcel_1 = jxl.Workbook.getWorkbook(buffIStreamtFileInputExcel_1, workbookSettings_tFileInputExcel_1);
            }else{
            	workbook_tFileInputExcel_1 = null;
            	throw new java.lang.Exception("The data source should be specified as Inputstream or File Path!");
            }
        } finally {
			try{
			   if(buffIStreamtFileInputExcel_1 != null){
			   	  buffIStreamtFileInputExcel_1.close();
			   }
			}catch(Exception e){
globalMap.put("tFileInputExcel_1_ERROR_MESSAGE",e.getMessage());
			}
        }
        try {
		java.util.List<jxl.Sheet> sheetList_tFileInputExcel_1 = java.util.Arrays.<jxl.Sheet> asList(workbook_tFileInputExcel_1.getSheets());
        if(sheetList_tFileInputExcel_1.size() <= 0){
        	throw new RuntimeException("Special sheets not exist!");
        }

        java.util.List<jxl.Sheet> sheet_FilterNullList_tFileInputExcel_1 = new java.util.ArrayList<jxl.Sheet>();
        for(jxl.Sheet sheet_FilterNull_tFileInputExcel_1 : sheetList_tFileInputExcel_1){
        	if(sheet_FilterNull_tFileInputExcel_1.getRows()>0){
        		sheet_FilterNullList_tFileInputExcel_1.add(sheet_FilterNull_tFileInputExcel_1);
        	}
        }
		sheetList_tFileInputExcel_1 = sheet_FilterNullList_tFileInputExcel_1;
	if(sheetList_tFileInputExcel_1.size()>0){
        int nb_line_tFileInputExcel_1 = 0;

        int begin_line_tFileInputExcel_1 = 1;

        int footer_input_tFileInputExcel_1 = 0;

        int end_line_tFileInputExcel_1=0;
        for(jxl.Sheet sheet_tFileInputExcel_1:sheetList_tFileInputExcel_1){
        	end_line_tFileInputExcel_1+=sheet_tFileInputExcel_1.getRows();
        }
        end_line_tFileInputExcel_1 -= footer_input_tFileInputExcel_1;
        int limit_tFileInputExcel_1 = -1;
        int start_column_tFileInputExcel_1 = 1-1;
        int end_column_tFileInputExcel_1 = sheetList_tFileInputExcel_1.get(0).getColumns();
        jxl.Cell[] row_tFileInputExcel_1 = null;
        jxl.Sheet sheet_tFileInputExcel_1 = sheetList_tFileInputExcel_1.get(0);
        int rowCount_tFileInputExcel_1 = 0;
        int sheetIndex_tFileInputExcel_1 = 0;
        int currentRows_tFileInputExcel_1 = sheetList_tFileInputExcel_1.get(0).getRows();

        //for the number format
        java.text.DecimalFormat df_tFileInputExcel_1 = new java.text.DecimalFormat("#.####################################");
		char separatorChar_tFileInputExcel_1 = df_tFileInputExcel_1.getDecimalFormatSymbols().getDecimalSeparator();
		
		
		
        for(int i_tFileInputExcel_1 = begin_line_tFileInputExcel_1; i_tFileInputExcel_1 < end_line_tFileInputExcel_1; i_tFileInputExcel_1++){

        	int emptyColumnCount_tFileInputExcel_1 = 0;

        	if (limit_tFileInputExcel_1 != -1 && nb_line_tFileInputExcel_1 >= limit_tFileInputExcel_1) {
        		break;
        	}

            while (i_tFileInputExcel_1 >= rowCount_tFileInputExcel_1 + currentRows_tFileInputExcel_1) {
                rowCount_tFileInputExcel_1 += currentRows_tFileInputExcel_1;
                sheet_tFileInputExcel_1 = sheetList_tFileInputExcel_1.get(++sheetIndex_tFileInputExcel_1);
                currentRows_tFileInputExcel_1 = sheet_tFileInputExcel_1.getRows();
            }
            if (rowCount_tFileInputExcel_1 <= i_tFileInputExcel_1) {
                row_tFileInputExcel_1 = sheet_tFileInputExcel_1.getRow(i_tFileInputExcel_1 - rowCount_tFileInputExcel_1);
            }
        	globalMap.put("tFileInputExcel_1_CURRENT_SHEET",sheet_tFileInputExcel_1.getName());
    		staff = null;
    		staff = null;
					int tempRowLength_tFileInputExcel_1 = 10;
				
				int columnIndex_tFileInputExcel_1 = 0;
			
//
//end%>
			
			String[] temp_row_tFileInputExcel_1 = new String[tempRowLength_tFileInputExcel_1];
			int actual_end_column_tFileInputExcel_1 = end_column_tFileInputExcel_1 >	row_tFileInputExcel_1.length ? row_tFileInputExcel_1.length : end_column_tFileInputExcel_1;

				java.util.TimeZone zone_tFileInputExcel_1 = java.util.TimeZone.getTimeZone("GMT");
                java.text.SimpleDateFormat sdf_tFileInputExcel_1 = new java.text.SimpleDateFormat("dd-MM-yyyy");
                sdf_tFileInputExcel_1.setTimeZone(zone_tFileInputExcel_1);
                

			for(int i=0;i<tempRowLength_tFileInputExcel_1;i++){

				if(i + start_column_tFileInputExcel_1 < actual_end_column_tFileInputExcel_1){

				  jxl.Cell cell_tFileInputExcel_1 = row_tFileInputExcel_1[i + start_column_tFileInputExcel_1];
                        temp_row_tFileInputExcel_1[i] = cell_tFileInputExcel_1.getContents();

				}else{
					temp_row_tFileInputExcel_1[i]="";
				}
			}

			boolean whetherReject_tFileInputExcel_1 = false;
			staff = new staffStruct();
			int curColNum_tFileInputExcel_1 = -1;
			String curColName_tFileInputExcel_1 = "";
			try {
							columnIndex_tFileInputExcel_1 = 0;
						
			if( temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
				curColNum_tFileInputExcel_1=columnIndex_tFileInputExcel_1 + start_column_tFileInputExcel_1 + 1;
				curColName_tFileInputExcel_1 = "Employee_ID";
			staff.Employee_ID = ParserUtils.parseTo_Integer(temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]);
			}else {
				staff.Employee_ID = null;
				emptyColumnCount_tFileInputExcel_1++;
		}
							columnIndex_tFileInputExcel_1 = 1;
						
			if( temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
				curColNum_tFileInputExcel_1=columnIndex_tFileInputExcel_1 + start_column_tFileInputExcel_1 + 1;
				curColName_tFileInputExcel_1 = "Start_Date";
			if(1<actual_end_column_tFileInputExcel_1){
				try{
					java.util.Date dateGMT_tFileInputExcel_1 = ((jxl.DateCell)row_tFileInputExcel_1[columnIndex_tFileInputExcel_1 + start_column_tFileInputExcel_1]).getDate();
					staff.Start_Date = new java.util.Date(dateGMT_tFileInputExcel_1.getTime() - java.util.TimeZone.getDefault().getOffset(dateGMT_tFileInputExcel_1.getTime()));
				}catch(java.lang.Exception e){
globalMap.put("tFileInputExcel_1_ERROR_MESSAGE",e.getMessage());
					
					throw new RuntimeException("The cell format is not Date in ( Row. "+(nb_line_tFileInputExcel_1+1)+ " and ColumnNum. " + curColNum_tFileInputExcel_1 + " )");
				}
			}
			}else {
				staff.Start_Date = null;
				emptyColumnCount_tFileInputExcel_1++;
		}
							columnIndex_tFileInputExcel_1 = 2;
						
			if( temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
				curColNum_tFileInputExcel_1=columnIndex_tFileInputExcel_1 + start_column_tFileInputExcel_1 + 1;
				curColName_tFileInputExcel_1 = "End_Date";
			if(2<actual_end_column_tFileInputExcel_1){
				try{
					java.util.Date dateGMT_tFileInputExcel_1 = ((jxl.DateCell)row_tFileInputExcel_1[columnIndex_tFileInputExcel_1 + start_column_tFileInputExcel_1]).getDate();
					staff.End_Date = new java.util.Date(dateGMT_tFileInputExcel_1.getTime() - java.util.TimeZone.getDefault().getOffset(dateGMT_tFileInputExcel_1.getTime()));
				}catch(java.lang.Exception e){
globalMap.put("tFileInputExcel_1_ERROR_MESSAGE",e.getMessage());
					
					throw new RuntimeException("The cell format is not Date in ( Row. "+(nb_line_tFileInputExcel_1+1)+ " and ColumnNum. " + curColNum_tFileInputExcel_1 + " )");
				}
			}
			}else {
				staff.End_Date = null;
				emptyColumnCount_tFileInputExcel_1++;
		}
							columnIndex_tFileInputExcel_1 = 3;
						
			if( temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
				curColNum_tFileInputExcel_1=columnIndex_tFileInputExcel_1 + start_column_tFileInputExcel_1 + 1;
				curColName_tFileInputExcel_1 = "Job_Title";
			staff.Job_Title = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1];
			}else {
				staff.Job_Title = null;
				emptyColumnCount_tFileInputExcel_1++;
		}
							columnIndex_tFileInputExcel_1 = 4;
						
			if( temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
				curColNum_tFileInputExcel_1=columnIndex_tFileInputExcel_1 + start_column_tFileInputExcel_1 + 1;
				curColName_tFileInputExcel_1 = "Salary";
			staff.Salary = ParserUtils.parseTo_BigDecimal(temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]);
			}else {
				staff.Salary = null;
				emptyColumnCount_tFileInputExcel_1++;
		}
							columnIndex_tFileInputExcel_1 = 5;
						
			if( temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
				curColNum_tFileInputExcel_1=columnIndex_tFileInputExcel_1 + start_column_tFileInputExcel_1 + 1;
				curColName_tFileInputExcel_1 = "Gender";
			staff.Gender = ParserUtils.parseTo_Character(temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]);
			}else {
				staff.Gender = null;
				emptyColumnCount_tFileInputExcel_1++;
		}
							columnIndex_tFileInputExcel_1 = 6;
						
			if( temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
				curColNum_tFileInputExcel_1=columnIndex_tFileInputExcel_1 + start_column_tFileInputExcel_1 + 1;
				curColName_tFileInputExcel_1 = "Birth_Date";
			if(6<actual_end_column_tFileInputExcel_1){
				try{
					java.util.Date dateGMT_tFileInputExcel_1 = ((jxl.DateCell)row_tFileInputExcel_1[columnIndex_tFileInputExcel_1 + start_column_tFileInputExcel_1]).getDate();
					staff.Birth_Date = new java.util.Date(dateGMT_tFileInputExcel_1.getTime() - java.util.TimeZone.getDefault().getOffset(dateGMT_tFileInputExcel_1.getTime()));
				}catch(java.lang.Exception e){
globalMap.put("tFileInputExcel_1_ERROR_MESSAGE",e.getMessage());
					
					throw new RuntimeException("The cell format is not Date in ( Row. "+(nb_line_tFileInputExcel_1+1)+ " and ColumnNum. " + curColNum_tFileInputExcel_1 + " )");
				}
			}
			}else {
				staff.Birth_Date = null;
				emptyColumnCount_tFileInputExcel_1++;
		}
							columnIndex_tFileInputExcel_1 = 7;
						
			if( temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
				curColNum_tFileInputExcel_1=columnIndex_tFileInputExcel_1 + start_column_tFileInputExcel_1 + 1;
				curColName_tFileInputExcel_1 = "Emp_Hire_Date";
			if(7<actual_end_column_tFileInputExcel_1){
				try{
					java.util.Date dateGMT_tFileInputExcel_1 = ((jxl.DateCell)row_tFileInputExcel_1[columnIndex_tFileInputExcel_1 + start_column_tFileInputExcel_1]).getDate();
					staff.Emp_Hire_Date = new java.util.Date(dateGMT_tFileInputExcel_1.getTime() - java.util.TimeZone.getDefault().getOffset(dateGMT_tFileInputExcel_1.getTime()));
				}catch(java.lang.Exception e){
globalMap.put("tFileInputExcel_1_ERROR_MESSAGE",e.getMessage());
					
					throw new RuntimeException("The cell format is not Date in ( Row. "+(nb_line_tFileInputExcel_1+1)+ " and ColumnNum. " + curColNum_tFileInputExcel_1 + " )");
				}
			}
			}else {
				staff.Emp_Hire_Date = null;
				emptyColumnCount_tFileInputExcel_1++;
		}
							columnIndex_tFileInputExcel_1 = 8;
						
			if( temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
				curColNum_tFileInputExcel_1=columnIndex_tFileInputExcel_1 + start_column_tFileInputExcel_1 + 1;
				curColName_tFileInputExcel_1 = "Emp_Term_Date";
			if(8<actual_end_column_tFileInputExcel_1){
				try{
					java.util.Date dateGMT_tFileInputExcel_1 = ((jxl.DateCell)row_tFileInputExcel_1[columnIndex_tFileInputExcel_1 + start_column_tFileInputExcel_1]).getDate();
					staff.Emp_Term_Date = new java.util.Date(dateGMT_tFileInputExcel_1.getTime() - java.util.TimeZone.getDefault().getOffset(dateGMT_tFileInputExcel_1.getTime()));
				}catch(java.lang.Exception e){
globalMap.put("tFileInputExcel_1_ERROR_MESSAGE",e.getMessage());
					
					throw new RuntimeException("The cell format is not Date in ( Row. "+(nb_line_tFileInputExcel_1+1)+ " and ColumnNum. " + curColNum_tFileInputExcel_1 + " )");
				}
			}
			}else {
				staff.Emp_Term_Date = null;
				emptyColumnCount_tFileInputExcel_1++;
		}
							columnIndex_tFileInputExcel_1 = 9;
						
			if( temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
				curColNum_tFileInputExcel_1=columnIndex_tFileInputExcel_1 + start_column_tFileInputExcel_1 + 1;
				curColName_tFileInputExcel_1 = "Manager_ID";
			staff.Manager_ID = ParserUtils.parseTo_Integer(temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]);
			}else {
				staff.Manager_ID = null;
				emptyColumnCount_tFileInputExcel_1++;
		}

			nb_line_tFileInputExcel_1++;
			
    } catch (java.lang.Exception e) {
globalMap.put("tFileInputExcel_1_ERROR_MESSAGE",e.getMessage());
        whetherReject_tFileInputExcel_1 = true;
                System.err.println(e.getMessage());
                staff = null;
    }

					
		



 



/**
 * [tFileInputExcel_1 begin ] stop
 */
	
	/**
	 * [tFileInputExcel_1 main ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_1";

	

 


	tos_count_tFileInputExcel_1++;

/**
 * [tFileInputExcel_1 main ] stop
 */
	
	/**
	 * [tFileInputExcel_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_1";

	

 



/**
 * [tFileInputExcel_1 process_data_begin ] stop
 */
// Start of branch "staff"
if(staff != null) { 



	
	/**
	 * [tAdvancedHash_staff main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_staff";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"staff"
						
						);
					}
					


			   
			   

					staffStruct staff_HashRow = new staffStruct();
		   	   	   
				
				staff_HashRow.Employee_ID = staff.Employee_ID;
				
				staff_HashRow.Start_Date = staff.Start_Date;
				
				staff_HashRow.End_Date = staff.End_Date;
				
				staff_HashRow.Job_Title = staff.Job_Title;
				
				staff_HashRow.Salary = staff.Salary;
				
				staff_HashRow.Gender = staff.Gender;
				
				staff_HashRow.Birth_Date = staff.Birth_Date;
				
				staff_HashRow.Emp_Hire_Date = staff.Emp_Hire_Date;
				
				staff_HashRow.Emp_Term_Date = staff.Emp_Term_Date;
				
				staff_HashRow.Manager_ID = staff.Manager_ID;
				
			tHash_Lookup_staff.put(staff_HashRow);
			
            




 


	tos_count_tAdvancedHash_staff++;

/**
 * [tAdvancedHash_staff main ] stop
 */
	
	/**
	 * [tAdvancedHash_staff process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_staff";

	

 



/**
 * [tAdvancedHash_staff process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_staff process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_staff";

	

 



/**
 * [tAdvancedHash_staff process_data_end ] stop
 */

} // End of branch "staff"




	
	/**
	 * [tFileInputExcel_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_1";

	

 



/**
 * [tFileInputExcel_1 process_data_end ] stop
 */
	
	/**
	 * [tFileInputExcel_1 end ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_1";

	

			}
			
			
			
			globalMap.put("tFileInputExcel_1_NB_LINE",nb_line_tFileInputExcel_1);
			
				}
			
		} finally { 
				
					if(!(source_tFileInputExcel_1 instanceof java.io.InputStream)){
						workbook_tFileInputExcel_1.close();
					}
				
		}	
		

 

ok_Hash.put("tFileInputExcel_1", true);
end_Hash.put("tFileInputExcel_1", System.currentTimeMillis());




/**
 * [tFileInputExcel_1 end ] stop
 */

	
	/**
	 * [tAdvancedHash_staff end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_staff";

	

tHash_Lookup_staff.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"staff");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_staff", true);
end_Hash.put("tAdvancedHash_staff", System.currentTimeMillis());




/**
 * [tAdvancedHash_staff end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tFileInputExcel_1 finally ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_1";

	

 



/**
 * [tFileInputExcel_1 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_staff finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_staff";

	

 



/**
 * [tAdvancedHash_staff finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFileInputExcel_1_SUBPROCESS_STATE", 1);
	}
	
    public String resuming_logs_dir_path = null;
    public String resuming_checkpoint_path = null;
    public String parent_part_launcher = null;
    private String resumeEntryMethodName = null;
    private boolean globalResumeTicket = false;

    public boolean watch = false;
    // portStats is null, it means don't execute the statistics
    public Integer portStats = null;
    public int portTraces = 4334;
    public String clientHost;
    public String defaultClientHost = "localhost";
    public String contextStr = "Default";
    public boolean isDefaultContext = true;
    public String pid = "0";
    public String rootPid = null;
    public String fatherPid = null;
    public String fatherNode = null;
    public long startTime = 0;
    public boolean isChildJob = false;
    public String log4jLevel = "";
    
    private boolean enableLogStash;

    private boolean execStat = true;

    private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
        protected java.util.Map<String, String> initialValue() {
            java.util.Map<String,String> threadRunResultMap = new java.util.HashMap<String, String>();
            threadRunResultMap.put("errorCode", null);
            threadRunResultMap.put("status", "");
            return threadRunResultMap;
        };
    };

    private SyncInt runningThreadCount =new SyncInt();

    private class SyncInt
    {
        private int count = 0;
        public synchronized void add(int i)
        {
            count +=i;
        }

        public synchronized int getCount()
        {
            return count;
        }
    }

    protected PropertiesWithType context_param = new PropertiesWithType();
    public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

    public String status= "";
    

    public static void main(String[] args){
        final Organisation_DIM Organisation_DIMClass = new Organisation_DIM();

        int exitCode = Organisation_DIMClass.runJobInTOS(args);

        System.exit(exitCode);
    }


    public String[][] runJob(String[] args) {

        int exitCode = runJobInTOS(args);
        String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

        return bufferValue;
    }

    public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;
    	
        return hastBufferOutput;
    }

    public int runJobInTOS(String[] args) {
	   	// reset status
	   	status = "";
	   	
        String lastStr = "";
        for (String arg : args) {
            if (arg.equalsIgnoreCase("--context_param")) {
                lastStr = arg;
            } else if (lastStr.equals("")) {
                evalParam(arg);
            } else {
                evalParam(lastStr + " " + arg);
                lastStr = "";
            }
        }
        enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

    	
    	

        if(clientHost == null) {
            clientHost = defaultClientHost;
        }

        if(pid == null || "0".equals(pid)) {
            pid = TalendString.getAsciiRandomString(6);
        }

        if (rootPid==null) {
            rootPid = pid;
        }
        if (fatherPid==null) {
            fatherPid = pid;
        }else{
            isChildJob = true;
        }

        if (portStats != null) {
            // portStats = -1; //for testing
            if (portStats < 0 || portStats > 65535) {
                // issue:10869, the portStats is invalid, so this client socket can't open
                System.err.println("The statistics socket port " + portStats + " is invalid.");
                execStat = false;
            }
        } else {
            execStat = false;
        }
        boolean inOSGi = routines.system.BundleUtils.inOSGi();

        if (inOSGi) {
            java.util.Dictionary<String, Object> jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

            if (jobProperties != null && jobProperties.get("context") != null) {
                contextStr = (String)jobProperties.get("context");
            }
        }

        try {
            //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead.
            java.io.InputStream inContext = Organisation_DIM.class.getClassLoader().getResourceAsStream("orion_project_duplesse_nangmo/organisation_dim_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = Organisation_DIM.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
            }
            if (inContext != null) {
                try {
                    //defaultProps is in order to keep the original context value
                    if(context != null && context.isEmpty()) {
	                defaultProps.load(inContext);
	                context = new ContextProperties(defaultProps);
                    }
                } finally {
                    inContext.close();
                }
            } else if (!isDefaultContext) {
                //print info and job continue to run, for case: context_param is not empty.
                System.err.println("Could not find the context " + contextStr);
            }

            if(!context_param.isEmpty()) {
                context.putAll(context_param);
				//set types for params from parentJobs
				for (Object key: context_param.keySet()){
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
            }
            class ContextProcessing {
                private void processContext_0() {
                } 
                public void processAllContext() {
                        processContext_0();
                }
            }

            new ContextProcessing().processAllContext();
        } catch (java.io.IOException ie) {
            System.err.println("Could not load context "+contextStr);
            ie.printStackTrace();
        }

        // get context value from parent directly
        if (parentContextMap != null && !parentContextMap.isEmpty()) {
        }

        //Resume: init the resumeUtil
        resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
        resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
        resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
        //Resume: jobStart
        resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","","","",resumeUtil.convertToJsonText(context,parametersToEncrypt));

if(execStat) {
    try {
        runStat.openSocket(!isChildJob);
        runStat.setAllPID(rootPid, fatherPid, pid, jobName);
        runStat.startThreadStat(clientHost, portStats);
        runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
    } catch (java.io.IOException ioException) {
        ioException.printStackTrace();
    }
}



	
	    java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
	    globalMap.put("concurrentHashMap", concurrentHashMap);
	

    long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long endUsedMemory = 0;
    long end = 0;

    startTime = System.currentTimeMillis();


this.globalResumeTicket = true;//to run tPreJob

try {
errorCode = null;tPrejob_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tPrejob_1) {
globalMap.put("tPrejob_1_SUBPROCESS_STATE", -1);

e_tPrejob_1.printStackTrace();

}




this.globalResumeTicket = false;//to run others jobs
final Thread launchingThread = Thread.currentThread();
        runningThreadCount.add(1);
        new Thread(){
            public void run() {
                java.util.Map threadRunResultMap = new java.util.HashMap();
                threadRunResultMap.put("errorCode", null);
                threadRunResultMap.put("status", "");
                threadLocal.set(threadRunResultMap);

                try {
((java.util.Map) threadLocal.get()).put("errorCode", null);tDBInput_1Process(globalMap);
if ( !"failure".equals(((java.util.Map)threadLocal.get()).get("status")) ) {
((java.util.Map) threadLocal.get()).put("status", "end");
}
}catch (TalendException e_tDBInput_1) {
globalMap.put("tDBInput_1_SUBPROCESS_STATE", -1);

e_tDBInput_1.printStackTrace();

}catch (java.lang.Error e_tDBInput_1) {
globalMap.put("tDBInput_1_SUBPROCESS_STATE", -1);
((java.util.Map) threadLocal.get()).put("status", "failure");throw e_tDBInput_1;

}
                finally {
                    Integer localErrorCode = (Integer)(((java.util.Map)threadLocal.get()).get("errorCode"));
                    String localStatus = (String)(((java.util.Map)threadLocal.get()).get("status"));
                    if (localErrorCode != null) {
                        if (errorCode == null || localErrorCode.compareTo(errorCode) > 0) {
                           errorCode = localErrorCode;
                        }
                    }
                    if (!status.equals("failure")){
                        status = localStatus;
                    }

                    if ("true".equals(((java.util.Map) threadLocal.get()).get("JobInterrupted"))) {
                        launchingThread.interrupt();
                    }

                    runningThreadCount.add(-1);
                }
            }
        }.start();

    boolean interrupted = false;
    while (runningThreadCount.getCount() > 0) {
        try {
            Thread.sleep(10);
        } catch (java.lang.InterruptedException e) {
            interrupted = true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    if (interrupted) {
        Thread.currentThread().interrupt();
    }



this.globalResumeTicket = true;//to run tPostJob

try {
errorCode = null;tPostjob_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tPostjob_1) {
globalMap.put("tPostjob_1_SUBPROCESS_STATE", -1);

e_tPostjob_1.printStackTrace();

}



        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : Organisation_DIM");
        }



if (execStat) {
    runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
    runStat.stopThreadStat();
}
    int returnCode = 0;

        Integer localErrorCode = (Integer)(((java.util.Map)threadLocal.get()).get("errorCode"));
        String localStatus = (String)(((java.util.Map)threadLocal.get()).get("status"));
        if (localErrorCode != null) {
            if (errorCode == null || localErrorCode.compareTo(errorCode) > 0) {
                   errorCode = localErrorCode;
            }
        }
        if (localStatus != null && !status.equals("failure")){
            status = localStatus;
        }

    if(errorCode == null) {
         returnCode = status != null && status.equals("failure") ? 1 : 0;
    } else {
         returnCode = errorCode.intValue();
    }
    resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","" + returnCode,"","","");

    return returnCode;

  }

    // only for OSGi env
    public void destroy() {
    closeSqlDbConnections();


    }



    private void closeSqlDbConnections() {
        try {
            Object obj_conn;
            obj_conn = globalMap.remove("conn_tDBConnection_2");
            if (null != obj_conn) {
                ((java.sql.Connection) obj_conn).close();
            }
            obj_conn = globalMap.remove("conn_tDBConnection_1");
            if (null != obj_conn) {
                ((java.sql.Connection) obj_conn).close();
            }
        } catch (java.lang.Exception e) {
        }
    }











    private java.util.Map<String, Object> getSharedConnections4REST() {
        java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();
            connections.put("conn_tDBConnection_2", globalMap.get("conn_tDBConnection_2"));
            connections.put("conn_tDBConnection_1", globalMap.get("conn_tDBConnection_1"));






        return connections;
    }

    private void evalParam(String arg) {
        if (arg.startsWith("--resuming_logs_dir_path")) {
            resuming_logs_dir_path = arg.substring(25);
        } else if (arg.startsWith("--resuming_checkpoint_path")) {
            resuming_checkpoint_path = arg.substring(27);
        } else if (arg.startsWith("--parent_part_launcher")) {
            parent_part_launcher = arg.substring(23);
        } else if (arg.startsWith("--watch")) {
            watch = true;
        } else if (arg.startsWith("--stat_port=")) {
            String portStatsStr = arg.substring(12);
            if (portStatsStr != null && !portStatsStr.equals("null")) {
                portStats = Integer.parseInt(portStatsStr);
            }
        } else if (arg.startsWith("--trace_port=")) {
            portTraces = Integer.parseInt(arg.substring(13));
        } else if (arg.startsWith("--client_host=")) {
            clientHost = arg.substring(14);
        } else if (arg.startsWith("--context=")) {
            contextStr = arg.substring(10);
            isDefaultContext = false;
        } else if (arg.startsWith("--father_pid=")) {
            fatherPid = arg.substring(13);
        } else if (arg.startsWith("--root_pid=")) {
            rootPid = arg.substring(11);
        } else if (arg.startsWith("--father_node=")) {
            fatherNode = arg.substring(14);
        } else if (arg.startsWith("--pid=")) {
            pid = arg.substring(6);
        } else if (arg.startsWith("--context_type")) {
            String keyValue = arg.substring(15);
			int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.setContextType(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }

            }

		} else if (arg.startsWith("--context_param")) {
            String keyValue = arg.substring(16);
            int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }
            }
        } else if (arg.startsWith("--log4jLevel=")) {
            log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {//for trunjob call
		    final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
    }
    
    private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

    private final String[][] escapeChars = {
        {"\\\\","\\"},{"\\n","\n"},{"\\'","\'"},{"\\r","\r"},
        {"\\f","\f"},{"\\b","\b"},{"\\t","\t"}
        };
    private String replaceEscapeChars (String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0],currIndex);
				if (index>=0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0], strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
    }

    public Integer getErrorCode() {
        return errorCode;
    }


    public String getStatus() {
        return status;
    }

    ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 *     344987 characters generated by Talend Open Studio for Data Integration 
 *     on the 13 février 2025 à 06:01:19 WAT
 ************************************************************************************************/