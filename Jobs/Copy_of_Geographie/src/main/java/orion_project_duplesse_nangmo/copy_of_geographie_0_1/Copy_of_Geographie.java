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


package orion_project_duplesse_nangmo.copy_of_geographie_0_1;

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


@SuppressWarnings("unused")

/**
 * Job: Copy_of_Geographie Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class Copy_of_Geographie implements TalendJob {

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
	private final String jobName = "Copy_of_Geographie";
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
				Copy_of_Geographie.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(Copy_of_Geographie.this, new Object[] { e , currentComponent, globalMap});
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
			
			public void tSendMail_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tSendMail_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tJava_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tJava_2_onSubJobError(exception, errorComponent, globalMap);
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
			
			public void tDBInput_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_5_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_county_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_state_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_country_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_continent_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
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
			public void tSendMail_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tJava_2_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

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
   	 				runStat.updateStatOnConnection("OnComponentOk2", 0, "ok");
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
	
	
		 
	final String decryptedPassword_tDBConnection_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:/UpismwA6qLovCu7o5SZPe3zzma2iXQ8iOJAwr/AgmLzeGWUYZ4tNCs=");
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
   	 				runStat.updateStatOnConnection("OnComponentOk3", 0, "ok");
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
   	 				runStat.updateStatOnConnection("OnComponentOk4", 0, "ok");
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
	


public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public long Street_ID;

				public long getStreet_ID () {
					return this.Street_ID;
				}
				
			    public String Continent;

				public String getContinent () {
					return this.Continent;
				}
				
			    public String Country;

				public String getCountry () {
					return this.Country;
				}
				
			    public String State_Code;

				public String getState_Code () {
					return this.State_Code;
				}
				
			    public String State;

				public String getState () {
					return this.State;
				}
				
			    public String Region;

				public String getRegion () {
					return this.Region;
				}
				
			    public String Province;

				public String getProvince () {
					return this.Province;
				}
				
			    public String County;

				public String getCounty () {
					return this.County;
				}
				
			    public String City;

				public String getCity () {
					return this.City;
				}
				
			    public String Postal_Code;

				public String getPostal_Code () {
					return this.Postal_Code;
				}
				
			    public String Street_Name;

				public String getStreet_Name () {
					return this.Street_Name;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.Street_ID;
						
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
		final row1Struct other = (row1Struct) obj;
		
						if (this.Street_ID != other.Street_ID)
							return false;
					

		return true;
    }

	public void copyDataTo(row1Struct other) {

		other.Street_ID = this.Street_ID;
	            other.Continent = this.Continent;
	            other.Country = this.Country;
	            other.State_Code = this.State_Code;
	            other.State = this.State;
	            other.Region = this.Region;
	            other.Province = this.Province;
	            other.County = this.County;
	            other.City = this.City;
	            other.Postal_Code = this.Postal_Code;
	            other.Street_Name = this.Street_Name;
	            
	}

	public void copyKeysDataTo(row1Struct other) {

		other.Street_ID = this.Street_ID;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie, 0, length, utf8Charset);
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
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie) {

        	try {

        		int length = 0;
		
			        this.Street_ID = dis.readLong();
					
					this.Continent = readString(dis);
					
					this.Country = readString(dis);
					
					this.State_Code = readString(dis);
					
					this.State = readString(dis);
					
					this.Region = readString(dis);
					
					this.Province = readString(dis);
					
					this.County = readString(dis);
					
					this.City = readString(dis);
					
					this.Postal_Code = readString(dis);
					
					this.Street_Name = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie) {

        	try {

        		int length = 0;
		
			        this.Street_ID = dis.readLong();
					
					this.Continent = readString(dis);
					
					this.Country = readString(dis);
					
					this.State_Code = readString(dis);
					
					this.State = readString(dis);
					
					this.Region = readString(dis);
					
					this.Province = readString(dis);
					
					this.County = readString(dis);
					
					this.City = readString(dis);
					
					this.Postal_Code = readString(dis);
					
					this.Street_Name = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// long
				
		            	dos.writeLong(this.Street_ID);
					
					// String
				
						writeString(this.Continent,dos);
					
					// String
				
						writeString(this.Country,dos);
					
					// String
				
						writeString(this.State_Code,dos);
					
					// String
				
						writeString(this.State,dos);
					
					// String
				
						writeString(this.Region,dos);
					
					// String
				
						writeString(this.Province,dos);
					
					// String
				
						writeString(this.County,dos);
					
					// String
				
						writeString(this.City,dos);
					
					// String
				
						writeString(this.Postal_Code,dos);
					
					// String
				
						writeString(this.Street_Name,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// long
				
		            	dos.writeLong(this.Street_ID);
					
					// String
				
						writeString(this.Continent,dos);
					
					// String
				
						writeString(this.Country,dos);
					
					// String
				
						writeString(this.State_Code,dos);
					
					// String
				
						writeString(this.State,dos);
					
					// String
				
						writeString(this.Region,dos);
					
					// String
				
						writeString(this.Province,dos);
					
					// String
				
						writeString(this.County,dos);
					
					// String
				
						writeString(this.City,dos);
					
					// String
				
						writeString(this.Postal_Code,dos);
					
					// String
				
						writeString(this.Street_Name,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Street_ID="+String.valueOf(Street_ID));
		sb.append(",Continent="+Continent);
		sb.append(",Country="+Country);
		sb.append(",State_Code="+State_Code);
		sb.append(",State="+State);
		sb.append(",Region="+Region);
		sb.append(",Province="+Province);
		sb.append(",County="+County);
		sb.append(",City="+City);
		sb.append(",Postal_Code="+Postal_Code);
		sb.append(",Street_Name="+Street_Name);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row1Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.Street_ID, other.Street_ID);
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

public static class finStruct implements routines.system.IPersistableRow<finStruct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public long Street_ID;

				public long getStreet_ID () {
					return this.Street_ID;
				}
				
			    public String Continent;

				public String getContinent () {
					return this.Continent;
				}
				
			    public String Country;

				public String getCountry () {
					return this.Country;
				}
				
			    public String State_Code;

				public String getState_Code () {
					return this.State_Code;
				}
				
			    public String State;

				public String getState () {
					return this.State;
				}
				
			    public String Region;

				public String getRegion () {
					return this.Region;
				}
				
			    public String Province;

				public String getProvince () {
					return this.Province;
				}
				
			    public String County;

				public String getCounty () {
					return this.County;
				}
				
			    public String City;

				public String getCity () {
					return this.City;
				}
				
			    public String Postal_Code;

				public String getPostal_Code () {
					return this.Postal_Code;
				}
				
			    public String Street_Name;

				public String getStreet_Name () {
					return this.Street_Name;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.Street_ID;
						
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
		final finStruct other = (finStruct) obj;
		
						if (this.Street_ID != other.Street_ID)
							return false;
					

		return true;
    }

	public void copyDataTo(finStruct other) {

		other.Street_ID = this.Street_ID;
	            other.Continent = this.Continent;
	            other.Country = this.Country;
	            other.State_Code = this.State_Code;
	            other.State = this.State;
	            other.Region = this.Region;
	            other.Province = this.Province;
	            other.County = this.County;
	            other.City = this.City;
	            other.Postal_Code = this.Postal_Code;
	            other.Street_Name = this.Street_Name;
	            
	}

	public void copyKeysDataTo(finStruct other) {

		other.Street_ID = this.Street_ID;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie, 0, length, utf8Charset);
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
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie) {

        	try {

        		int length = 0;
		
			        this.Street_ID = dis.readLong();
					
					this.Continent = readString(dis);
					
					this.Country = readString(dis);
					
					this.State_Code = readString(dis);
					
					this.State = readString(dis);
					
					this.Region = readString(dis);
					
					this.Province = readString(dis);
					
					this.County = readString(dis);
					
					this.City = readString(dis);
					
					this.Postal_Code = readString(dis);
					
					this.Street_Name = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie) {

        	try {

        		int length = 0;
		
			        this.Street_ID = dis.readLong();
					
					this.Continent = readString(dis);
					
					this.Country = readString(dis);
					
					this.State_Code = readString(dis);
					
					this.State = readString(dis);
					
					this.Region = readString(dis);
					
					this.Province = readString(dis);
					
					this.County = readString(dis);
					
					this.City = readString(dis);
					
					this.Postal_Code = readString(dis);
					
					this.Street_Name = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// long
				
		            	dos.writeLong(this.Street_ID);
					
					// String
				
						writeString(this.Continent,dos);
					
					// String
				
						writeString(this.Country,dos);
					
					// String
				
						writeString(this.State_Code,dos);
					
					// String
				
						writeString(this.State,dos);
					
					// String
				
						writeString(this.Region,dos);
					
					// String
				
						writeString(this.Province,dos);
					
					// String
				
						writeString(this.County,dos);
					
					// String
				
						writeString(this.City,dos);
					
					// String
				
						writeString(this.Postal_Code,dos);
					
					// String
				
						writeString(this.Street_Name,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// long
				
		            	dos.writeLong(this.Street_ID);
					
					// String
				
						writeString(this.Continent,dos);
					
					// String
				
						writeString(this.Country,dos);
					
					// String
				
						writeString(this.State_Code,dos);
					
					// String
				
						writeString(this.State,dos);
					
					// String
				
						writeString(this.Region,dos);
					
					// String
				
						writeString(this.Province,dos);
					
					// String
				
						writeString(this.County,dos);
					
					// String
				
						writeString(this.City,dos);
					
					// String
				
						writeString(this.Postal_Code,dos);
					
					// String
				
						writeString(this.Street_Name,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Street_ID="+String.valueOf(Street_ID));
		sb.append(",Continent="+Continent);
		sb.append(",Country="+Country);
		sb.append(",State_Code="+State_Code);
		sb.append(",State="+State);
		sb.append(",Region="+Region);
		sb.append(",Province="+Province);
		sb.append(",County="+County);
		sb.append(",City="+City);
		sb.append(",Postal_Code="+Postal_Code);
		sb.append(",Street_Name="+Street_Name);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(finStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.Street_ID, other.Street_ID);
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

public static class derniereStruct implements routines.system.IPersistableRow<derniereStruct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[0];

	
			    public double street_id;

				public double getStreet_id () {
					return this.street_id;
				}
				
			    public String street_name;

				public String getStreet_name () {
					return this.street_name;
				}
				
			    public String postal_code;

				public String getPostal_code () {
					return this.postal_code;
				}
				
			    public String city_name;

				public String getCity_name () {
					return this.city_name;
				}
				
			    public String province_name;

				public String getProvince_name () {
					return this.province_name;
				}
				
			    public String county;

				public String getCounty () {
					return this.county;
				}
				
			    public String region_name;

				public String getRegion_name () {
					return this.region_name;
				}
				
			    public String state_name;

				public String getState_name () {
					return this.state_name;
				}
				
			    public String country;

				public String getCountry () {
					return this.country;
				}
				
			    public String state_code;

				public String getState_code () {
					return this.state_code;
				}
				
			    public Double continent_id;

				public Double getContinent_id () {
					return this.continent_id;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie, 0, length, utf8Charset);
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
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie) {

        	try {

        		int length = 0;
		
			        this.street_id = dis.readDouble();
					
					this.street_name = readString(dis);
					
					this.postal_code = readString(dis);
					
					this.city_name = readString(dis);
					
					this.province_name = readString(dis);
					
					this.county = readString(dis);
					
					this.region_name = readString(dis);
					
					this.state_name = readString(dis);
					
					this.country = readString(dis);
					
					this.state_code = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.continent_id = null;
           				} else {
           			    	this.continent_id = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie) {

        	try {

        		int length = 0;
		
			        this.street_id = dis.readDouble();
					
					this.street_name = readString(dis);
					
					this.postal_code = readString(dis);
					
					this.city_name = readString(dis);
					
					this.province_name = readString(dis);
					
					this.county = readString(dis);
					
					this.region_name = readString(dis);
					
					this.state_name = readString(dis);
					
					this.country = readString(dis);
					
					this.state_code = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.continent_id = null;
           				} else {
           			    	this.continent_id = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.street_id);
					
					// String
				
						writeString(this.street_name,dos);
					
					// String
				
						writeString(this.postal_code,dos);
					
					// String
				
						writeString(this.city_name,dos);
					
					// String
				
						writeString(this.province_name,dos);
					
					// String
				
						writeString(this.county,dos);
					
					// String
				
						writeString(this.region_name,dos);
					
					// String
				
						writeString(this.state_name,dos);
					
					// String
				
						writeString(this.country,dos);
					
					// String
				
						writeString(this.state_code,dos);
					
					// Double
				
						if(this.continent_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.continent_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.street_id);
					
					// String
				
						writeString(this.street_name,dos);
					
					// String
				
						writeString(this.postal_code,dos);
					
					// String
				
						writeString(this.city_name,dos);
					
					// String
				
						writeString(this.province_name,dos);
					
					// String
				
						writeString(this.county,dos);
					
					// String
				
						writeString(this.region_name,dos);
					
					// String
				
						writeString(this.state_name,dos);
					
					// String
				
						writeString(this.country,dos);
					
					// String
				
						writeString(this.state_code,dos);
					
					// Double
				
						if(this.continent_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.continent_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("street_id="+String.valueOf(street_id));
		sb.append(",street_name="+street_name);
		sb.append(",postal_code="+postal_code);
		sb.append(",city_name="+city_name);
		sb.append(",province_name="+province_name);
		sb.append(",county="+county);
		sb.append(",region_name="+region_name);
		sb.append(",state_name="+state_name);
		sb.append(",country="+country);
		sb.append(",state_code="+state_code);
		sb.append(",continent_id="+String.valueOf(continent_id));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(derniereStruct other) {

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

public static class deuxiemeStruct implements routines.system.IPersistableRow<deuxiemeStruct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[0];

	
			    public double street_id;

				public double getStreet_id () {
					return this.street_id;
				}
				
			    public String street_name;

				public String getStreet_name () {
					return this.street_name;
				}
				
			    public String postal_code;

				public String getPostal_code () {
					return this.postal_code;
				}
				
			    public String city_name;

				public String getCity_name () {
					return this.city_name;
				}
				
			    public String province_name;

				public String getProvince_name () {
					return this.province_name;
				}
				
			    public String county;

				public String getCounty () {
					return this.county;
				}
				
			    public String region_name;

				public String getRegion_name () {
					return this.region_name;
				}
				
			    public String state_name;

				public String getState_name () {
					return this.state_name;
				}
				
			    public String country;

				public String getCountry () {
					return this.country;
				}
				
			    public String state_code;

				public String getState_code () {
					return this.state_code;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie, 0, length, utf8Charset);
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
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie) {

        	try {

        		int length = 0;
		
			        this.street_id = dis.readDouble();
					
					this.street_name = readString(dis);
					
					this.postal_code = readString(dis);
					
					this.city_name = readString(dis);
					
					this.province_name = readString(dis);
					
					this.county = readString(dis);
					
					this.region_name = readString(dis);
					
					this.state_name = readString(dis);
					
					this.country = readString(dis);
					
					this.state_code = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie) {

        	try {

        		int length = 0;
		
			        this.street_id = dis.readDouble();
					
					this.street_name = readString(dis);
					
					this.postal_code = readString(dis);
					
					this.city_name = readString(dis);
					
					this.province_name = readString(dis);
					
					this.county = readString(dis);
					
					this.region_name = readString(dis);
					
					this.state_name = readString(dis);
					
					this.country = readString(dis);
					
					this.state_code = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.street_id);
					
					// String
				
						writeString(this.street_name,dos);
					
					// String
				
						writeString(this.postal_code,dos);
					
					// String
				
						writeString(this.city_name,dos);
					
					// String
				
						writeString(this.province_name,dos);
					
					// String
				
						writeString(this.county,dos);
					
					// String
				
						writeString(this.region_name,dos);
					
					// String
				
						writeString(this.state_name,dos);
					
					// String
				
						writeString(this.country,dos);
					
					// String
				
						writeString(this.state_code,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.street_id);
					
					// String
				
						writeString(this.street_name,dos);
					
					// String
				
						writeString(this.postal_code,dos);
					
					// String
				
						writeString(this.city_name,dos);
					
					// String
				
						writeString(this.province_name,dos);
					
					// String
				
						writeString(this.county,dos);
					
					// String
				
						writeString(this.region_name,dos);
					
					// String
				
						writeString(this.state_name,dos);
					
					// String
				
						writeString(this.country,dos);
					
					// String
				
						writeString(this.state_code,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("street_id="+String.valueOf(street_id));
		sb.append(",street_name="+street_name);
		sb.append(",postal_code="+postal_code);
		sb.append(",city_name="+city_name);
		sb.append(",province_name="+province_name);
		sb.append(",county="+county);
		sb.append(",region_name="+region_name);
		sb.append(",state_name="+state_name);
		sb.append(",country="+country);
		sb.append(",state_code="+state_code);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(deuxiemeStruct other) {

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

public static class premiereStruct implements routines.system.IPersistableRow<premiereStruct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[0];

	
			    public double street_id;

				public double getStreet_id () {
					return this.street_id;
				}
				
			    public String street_name;

				public String getStreet_name () {
					return this.street_name;
				}
				
			    public String postal_code;

				public String getPostal_code () {
					return this.postal_code;
				}
				
			    public String city_name;

				public String getCity_name () {
					return this.city_name;
				}
				
			    public String province_name;

				public String getProvince_name () {
					return this.province_name;
				}
				
			    public String county;

				public String getCounty () {
					return this.county;
				}
				
			    public String reagion_name;

				public String getReagion_name () {
					return this.reagion_name;
				}
				
			    public Double state_id;

				public Double getState_id () {
					return this.state_id;
				}
				
			    public String country;

				public String getCountry () {
					return this.country;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie, 0, length, utf8Charset);
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
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie) {

        	try {

        		int length = 0;
		
			        this.street_id = dis.readDouble();
					
					this.street_name = readString(dis);
					
					this.postal_code = readString(dis);
					
					this.city_name = readString(dis);
					
					this.province_name = readString(dis);
					
					this.county = readString(dis);
					
					this.reagion_name = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.state_id = null;
           				} else {
           			    	this.state_id = dis.readDouble();
           				}
					
					this.country = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie) {

        	try {

        		int length = 0;
		
			        this.street_id = dis.readDouble();
					
					this.street_name = readString(dis);
					
					this.postal_code = readString(dis);
					
					this.city_name = readString(dis);
					
					this.province_name = readString(dis);
					
					this.county = readString(dis);
					
					this.reagion_name = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.state_id = null;
           				} else {
           			    	this.state_id = dis.readDouble();
           				}
					
					this.country = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.street_id);
					
					// String
				
						writeString(this.street_name,dos);
					
					// String
				
						writeString(this.postal_code,dos);
					
					// String
				
						writeString(this.city_name,dos);
					
					// String
				
						writeString(this.province_name,dos);
					
					// String
				
						writeString(this.county,dos);
					
					// String
				
						writeString(this.reagion_name,dos);
					
					// Double
				
						if(this.state_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.state_id);
		            	}
					
					// String
				
						writeString(this.country,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.street_id);
					
					// String
				
						writeString(this.street_name,dos);
					
					// String
				
						writeString(this.postal_code,dos);
					
					// String
				
						writeString(this.city_name,dos);
					
					// String
				
						writeString(this.province_name,dos);
					
					// String
				
						writeString(this.county,dos);
					
					// String
				
						writeString(this.reagion_name,dos);
					
					// Double
				
						if(this.state_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.state_id);
		            	}
					
					// String
				
						writeString(this.country,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("street_id="+String.valueOf(street_id));
		sb.append(",street_name="+street_name);
		sb.append(",postal_code="+postal_code);
		sb.append(",city_name="+city_name);
		sb.append(",province_name="+province_name);
		sb.append(",county="+county);
		sb.append(",reagion_name="+reagion_name);
		sb.append(",state_id="+String.valueOf(state_id));
		sb.append(",country="+country);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(premiereStruct other) {

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

public static class streetStruct implements routines.system.IPersistableRow<streetStruct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[0];

	
			    public double street_id;

				public double getStreet_id () {
					return this.street_id;
				}
				
			    public String country;

				public String getCountry () {
					return this.country;
				}
				
			    public String street_name;

				public String getStreet_name () {
					return this.street_name;
				}
				
			    public Double city_id;

				public Double getCity_id () {
					return this.city_id;
				}
				
			    public String postal_code;

				public String getPostal_code () {
					return this.postal_code;
				}
				
			    public Double from_street_num;

				public Double getFrom_street_num () {
					return this.from_street_num;
				}
				
			    public Double to_street_num;

				public Double getTo_street_num () {
					return this.to_street_num;
				}
				
			    public String city_name;

				public String getCity_name () {
					return this.city_name;
				}
				
			    public Double count;

				public Double getCount () {
					return this.count;
				}
				
			    public Double county_id;

				public Double getCounty_id () {
					return this.county_id;
				}
				
			    public Double postal_code_id;

				public Double getPostal_code_id () {
					return this.postal_code_id;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie, 0, length, utf8Charset);
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
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie) {

        	try {

        		int length = 0;
		
			        this.street_id = dis.readDouble();
					
					this.country = readString(dis);
					
					this.street_name = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.city_id = null;
           				} else {
           			    	this.city_id = dis.readDouble();
           				}
					
					this.postal_code = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.from_street_num = null;
           				} else {
           			    	this.from_street_num = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.to_street_num = null;
           				} else {
           			    	this.to_street_num = dis.readDouble();
           				}
					
					this.city_name = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.count = null;
           				} else {
           			    	this.count = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.county_id = null;
           				} else {
           			    	this.county_id = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.postal_code_id = null;
           				} else {
           			    	this.postal_code_id = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie) {

        	try {

        		int length = 0;
		
			        this.street_id = dis.readDouble();
					
					this.country = readString(dis);
					
					this.street_name = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.city_id = null;
           				} else {
           			    	this.city_id = dis.readDouble();
           				}
					
					this.postal_code = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.from_street_num = null;
           				} else {
           			    	this.from_street_num = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.to_street_num = null;
           				} else {
           			    	this.to_street_num = dis.readDouble();
           				}
					
					this.city_name = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.count = null;
           				} else {
           			    	this.count = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.county_id = null;
           				} else {
           			    	this.county_id = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.postal_code_id = null;
           				} else {
           			    	this.postal_code_id = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.street_id);
					
					// String
				
						writeString(this.country,dos);
					
					// String
				
						writeString(this.street_name,dos);
					
					// Double
				
						if(this.city_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.city_id);
		            	}
					
					// String
				
						writeString(this.postal_code,dos);
					
					// Double
				
						if(this.from_street_num == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.from_street_num);
		            	}
					
					// Double
				
						if(this.to_street_num == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.to_street_num);
		            	}
					
					// String
				
						writeString(this.city_name,dos);
					
					// Double
				
						if(this.count == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.count);
		            	}
					
					// Double
				
						if(this.county_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.county_id);
		            	}
					
					// Double
				
						if(this.postal_code_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.postal_code_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.street_id);
					
					// String
				
						writeString(this.country,dos);
					
					// String
				
						writeString(this.street_name,dos);
					
					// Double
				
						if(this.city_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.city_id);
		            	}
					
					// String
				
						writeString(this.postal_code,dos);
					
					// Double
				
						if(this.from_street_num == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.from_street_num);
		            	}
					
					// Double
				
						if(this.to_street_num == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.to_street_num);
		            	}
					
					// String
				
						writeString(this.city_name,dos);
					
					// Double
				
						if(this.count == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.count);
		            	}
					
					// Double
				
						if(this.county_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.county_id);
		            	}
					
					// Double
				
						if(this.postal_code_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.postal_code_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("street_id="+String.valueOf(street_id));
		sb.append(",country="+country);
		sb.append(",street_name="+street_name);
		sb.append(",city_id="+String.valueOf(city_id));
		sb.append(",postal_code="+postal_code);
		sb.append(",from_street_num="+String.valueOf(from_street_num));
		sb.append(",to_street_num="+String.valueOf(to_street_num));
		sb.append(",city_name="+city_name);
		sb.append(",count="+String.valueOf(count));
		sb.append(",county_id="+String.valueOf(county_id));
		sb.append(",postal_code_id="+String.valueOf(postal_code_id));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(streetStruct other) {

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
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public double street_id;

				public double getStreet_id () {
					return this.street_id;
				}
				
			    public String country;

				public String getCountry () {
					return this.country;
				}
				
			    public String street_name;

				public String getStreet_name () {
					return this.street_name;
				}
				
			    public Double city_id;

				public Double getCity_id () {
					return this.city_id;
				}
				
			    public String postal_code;

				public String getPostal_code () {
					return this.postal_code;
				}
				
			    public Double from_street_num;

				public Double getFrom_street_num () {
					return this.from_street_num;
				}
				
			    public Double to_street_num;

				public Double getTo_street_num () {
					return this.to_street_num;
				}
				
			    public String city_name;

				public String getCity_name () {
					return this.city_name;
				}
				
			    public Double count;

				public Double getCount () {
					return this.count;
				}
				
			    public Double county_id;

				public Double getCounty_id () {
					return this.county_id;
				}
				
			    public Double postal_code_id;

				public Double getPostal_code_id () {
					return this.postal_code_id;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.street_id;
						
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
		
						if (this.street_id != other.street_id)
							return false;
					

		return true;
    }

	public void copyDataTo(after_tDBInput_1Struct other) {

		other.street_id = this.street_id;
	            other.country = this.country;
	            other.street_name = this.street_name;
	            other.city_id = this.city_id;
	            other.postal_code = this.postal_code;
	            other.from_street_num = this.from_street_num;
	            other.to_street_num = this.to_street_num;
	            other.city_name = this.city_name;
	            other.count = this.count;
	            other.county_id = this.county_id;
	            other.postal_code_id = this.postal_code_id;
	            
	}

	public void copyKeysDataTo(after_tDBInput_1Struct other) {

		other.street_id = this.street_id;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie, 0, length, utf8Charset);
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
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie) {

        	try {

        		int length = 0;
		
			        this.street_id = dis.readDouble();
					
					this.country = readString(dis);
					
					this.street_name = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.city_id = null;
           				} else {
           			    	this.city_id = dis.readDouble();
           				}
					
					this.postal_code = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.from_street_num = null;
           				} else {
           			    	this.from_street_num = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.to_street_num = null;
           				} else {
           			    	this.to_street_num = dis.readDouble();
           				}
					
					this.city_name = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.count = null;
           				} else {
           			    	this.count = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.county_id = null;
           				} else {
           			    	this.county_id = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.postal_code_id = null;
           				} else {
           			    	this.postal_code_id = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie) {

        	try {

        		int length = 0;
		
			        this.street_id = dis.readDouble();
					
					this.country = readString(dis);
					
					this.street_name = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.city_id = null;
           				} else {
           			    	this.city_id = dis.readDouble();
           				}
					
					this.postal_code = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.from_street_num = null;
           				} else {
           			    	this.from_street_num = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.to_street_num = null;
           				} else {
           			    	this.to_street_num = dis.readDouble();
           				}
					
					this.city_name = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.count = null;
           				} else {
           			    	this.count = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.county_id = null;
           				} else {
           			    	this.county_id = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.postal_code_id = null;
           				} else {
           			    	this.postal_code_id = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.street_id);
					
					// String
				
						writeString(this.country,dos);
					
					// String
				
						writeString(this.street_name,dos);
					
					// Double
				
						if(this.city_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.city_id);
		            	}
					
					// String
				
						writeString(this.postal_code,dos);
					
					// Double
				
						if(this.from_street_num == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.from_street_num);
		            	}
					
					// Double
				
						if(this.to_street_num == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.to_street_num);
		            	}
					
					// String
				
						writeString(this.city_name,dos);
					
					// Double
				
						if(this.count == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.count);
		            	}
					
					// Double
				
						if(this.county_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.county_id);
		            	}
					
					// Double
				
						if(this.postal_code_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.postal_code_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.street_id);
					
					// String
				
						writeString(this.country,dos);
					
					// String
				
						writeString(this.street_name,dos);
					
					// Double
				
						if(this.city_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.city_id);
		            	}
					
					// String
				
						writeString(this.postal_code,dos);
					
					// Double
				
						if(this.from_street_num == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.from_street_num);
		            	}
					
					// Double
				
						if(this.to_street_num == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.to_street_num);
		            	}
					
					// String
				
						writeString(this.city_name,dos);
					
					// Double
				
						if(this.count == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.count);
		            	}
					
					// Double
				
						if(this.county_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.county_id);
		            	}
					
					// Double
				
						if(this.postal_code_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.postal_code_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("street_id="+String.valueOf(street_id));
		sb.append(",country="+country);
		sb.append(",street_name="+street_name);
		sb.append(",city_id="+String.valueOf(city_id));
		sb.append(",postal_code="+postal_code);
		sb.append(",from_street_num="+String.valueOf(from_street_num));
		sb.append(",to_street_num="+String.valueOf(to_street_num));
		sb.append(",city_name="+city_name);
		sb.append(",count="+String.valueOf(count));
		sb.append(",county_id="+String.valueOf(county_id));
		sb.append(",postal_code_id="+String.valueOf(postal_code_id));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(after_tDBInput_1Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.street_id, other.street_id);
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
		tDBInput_4Process(globalMap);
		tDBInput_5Process(globalMap);

		streetStruct street = new streetStruct();
premiereStruct premiere = new premiereStruct();
deuxiemeStruct deuxieme = new deuxiemeStruct();
derniereStruct derniere = new derniereStruct();
finStruct fin = new finStruct();
row1Struct row1 = new row1Struct();









	
	/**
	 * [tLogRow_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tLogRow_1", false);
		start_Hash.put("tLogRow_1", System.currentTimeMillis());
		
	
	currentComponent="tLogRow_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row1");
					}
				
		int tos_count_tLogRow_1 = 0;
		

	///////////////////////
	
         class Util_tLogRow_1 {

        String[] des_top = { ".", ".", "-", "+" };

        String[] des_head = { "|=", "=|", "-", "+" };

        String[] des_bottom = { "'", "'", "-", "+" };

        String name="";

        java.util.List<String[]> list = new java.util.ArrayList<String[]>();

        int[] colLengths = new int[11];

        public void addRow(String[] row) {

            for (int i = 0; i < 11; i++) {
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
                    for (k = 0; k < (totals + 10 - name.length()) / 2; k++) {
                        sb.append(' ');
                    }
                    sb.append(name);
                    for (int i = 0; i < totals + 10 - name.length() - k; i++) {
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
                
                    //last column
                    for (int i = 0; i < colLengths[10] - fillChars[1].length() + 1; i++) {
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
        util_tLogRow_1.addRow(new String[]{"Street_ID","Continent","Country","State_Code","State","Region","Province","County","City","Postal_Code","Street_Name",});        
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
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"fin");
					}
				
		int tos_count_tDBOutput_1 = 0;
		





        int updateKeyCount_tDBOutput_1 = 1;
        if(updateKeyCount_tDBOutput_1 < 1) {
            throw new RuntimeException("For update, Schema must have a key");
        } else if (updateKeyCount_tDBOutput_1 == 11 && true) {
                    System.err.println("For update, every Schema column can not be a key");
        }

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

String tableName_tDBOutput_1 = "Geography_Dim";
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
	    java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement("SELECT COUNT(1) FROM `" + "Geography_Dim" + "` WHERE `Street_ID` = ?");
	    resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);
	    String insert_tDBOutput_1 = "INSERT INTO `" + "Geography_Dim" + "` (`Street_ID`,`Continent`,`Country`,`State_Code`,`State`,`Region`,`Province`,`County`,`City`,`Postal_Code`,`Street_Name`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	        
	    java.sql.PreparedStatement pstmtInsert_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
	    resourceMap.put("pstmtInsert_tDBOutput_1", pstmtInsert_tDBOutput_1);
	    String update_tDBOutput_1 = "UPDATE `" + "Geography_Dim" + "` SET `Continent` = ?,`Country` = ?,`State_Code` = ?,`State` = ?,`Region` = ?,`Province` = ?,`County` = ?,`City` = ?,`Postal_Code` = ?,`Street_Name` = ? WHERE `Street_ID` = ?";
	    
	    java.sql.PreparedStatement pstmtUpdate_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(update_tDBOutput_1);
	    resourceMap.put("pstmtUpdate_tDBOutput_1", pstmtUpdate_tDBOutput_1);
	    

 



/**
 * [tDBOutput_1 begin ] stop
 */



	
	/**
	 * [tMap_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_4", false);
		start_Hash.put("tMap_4", System.currentTimeMillis());
		
	
	currentComponent="tMap_4";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"derniere");
					}
				
		int tos_count_tMap_4 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<continentStruct> tHash_Lookup_continent = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<continentStruct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<continentStruct>) 
					globalMap.get( "tHash_Lookup_continent" ))
					;					
					
	

continentStruct continentHashKey = new continentStruct();
continentStruct continentDefault = new continentStruct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_4__Struct  {
}
Var__tMap_4__Struct Var__tMap_4 = new Var__tMap_4__Struct();
// ###############################

// ###############################
// # Outputs initialization
finStruct fin_tmp = new finStruct();
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
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"deuxieme");
					}
				
		int tos_count_tMap_3 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<countryStruct> tHash_Lookup_country = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<countryStruct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<countryStruct>) 
					globalMap.get( "tHash_Lookup_country" ))
					;					
					
	

countryStruct countryHashKey = new countryStruct();
countryStruct countryDefault = new countryStruct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_3__Struct  {
}
Var__tMap_3__Struct Var__tMap_3 = new Var__tMap_3__Struct();
// ###############################

// ###############################
// # Outputs initialization
derniereStruct derniere_tmp = new derniereStruct();
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
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"premiere");
					}
				
		int tos_count_tMap_2 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<stateStruct> tHash_Lookup_state = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<stateStruct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<stateStruct>) 
					globalMap.get( "tHash_Lookup_state" ))
					;					
					
	

stateStruct stateHashKey = new stateStruct();
stateStruct stateDefault = new stateStruct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_2__Struct  {
}
Var__tMap_2__Struct Var__tMap_2 = new Var__tMap_2__Struct();
// ###############################

// ###############################
// # Outputs initialization
deuxiemeStruct deuxieme_tmp = new deuxiemeStruct();
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
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"street");
					}
				
		int tos_count_tMap_1 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<countyStruct> tHash_Lookup_county = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<countyStruct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<countyStruct>) 
					globalMap.get( "tHash_Lookup_county" ))
					;					
					
	

countyStruct countyHashKey = new countyStruct();
countyStruct countyDefault = new countyStruct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_1__Struct  {
}
Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
premiereStruct premiere_tmp = new premiereStruct();
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

		    String dbquery_tDBInput_1 = "SELECT STREET_CODE.street_id,\n		STREET_CODE.country,\n		STREET_CODE.street_name,\n		STREET_CODE.city_id,\n		STREET_CODE.po"
+"stal_code,\n		STREET_CODE.from_street_num,\n		STREET_CODE.to_street_num,\n		STREET_CODE.city_name,\n		STREET_CODE.\"count\","
+"\n		STREET_CODE.county_id,\n		STREET_CODE.postal_code_id\nFROM	STREET_CODE";
		    

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
								street.street_id = 0;
							} else {
	                         		
            street.street_id = rs_tDBInput_1.getDouble(1);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 2) {
								street.country = null;
							} else {
	                         		
        	street.country = routines.system.JDBCUtil.getString(rs_tDBInput_1, 2, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 3) {
								street.street_name = null;
							} else {
	                         		
        	street.street_name = routines.system.JDBCUtil.getString(rs_tDBInput_1, 3, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 4) {
								street.city_id = null;
							} else {
	                         		
            street.city_id = rs_tDBInput_1.getDouble(4);
            if(rs_tDBInput_1.wasNull()){
                    street.city_id = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 5) {
								street.postal_code = null;
							} else {
	                         		
        	street.postal_code = routines.system.JDBCUtil.getString(rs_tDBInput_1, 5, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 6) {
								street.from_street_num = null;
							} else {
	                         		
            street.from_street_num = rs_tDBInput_1.getDouble(6);
            if(rs_tDBInput_1.wasNull()){
                    street.from_street_num = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 7) {
								street.to_street_num = null;
							} else {
	                         		
            street.to_street_num = rs_tDBInput_1.getDouble(7);
            if(rs_tDBInput_1.wasNull()){
                    street.to_street_num = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 8) {
								street.city_name = null;
							} else {
	                         		
        	street.city_name = routines.system.JDBCUtil.getString(rs_tDBInput_1, 8, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 9) {
								street.count = null;
							} else {
	                         		
            street.count = rs_tDBInput_1.getDouble(9);
            if(rs_tDBInput_1.wasNull()){
                    street.count = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 10) {
								street.county_id = null;
							} else {
	                         		
            street.county_id = rs_tDBInput_1.getDouble(10);
            if(rs_tDBInput_1.wasNull()){
                    street.county_id = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 11) {
								street.postal_code_id = null;
							} else {
	                         		
            street.postal_code_id = rs_tDBInput_1.getDouble(11);
            if(rs_tDBInput_1.wasNull()){
                    street.postal_code_id = null;
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
						
							,"street"
						
						);
					}
					

			


		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_1 = false;
		  boolean mainRowRejected_tMap_1 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "county" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLoopcounty = false;
       		  	    	
       		  	    	
 							countyStruct countyObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
	                        		    	Object exprKeyValue_county__county_id = street.county_id ;
	                        		    	if(exprKeyValue_county__county_id == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_1 = true;
	                        		    	} else {
                        		    			countyHashKey.county_id = (double)(Double) exprKeyValue_county__county_id;
                        		    		}
                        		    		

								
		                        	countyHashKey.hashCodeDirty = true;
                        		
	  					
	  							
	
		  							if(!hasCasePrimitiveKeyWithNull_tMap_1) { // G_TM_M_091
		  							
			  					
			  					
			  					
	  					
		  							tHash_Lookup_county.lookup( countyHashKey );

	  							

	  							

			  						} // G_TM_M_091
			  						
			  					

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_county != null && tHash_Lookup_county.getCount(countyHashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'county' and it contains more one result from keys :  county.county_id = '" + countyHashKey.county_id + "'");
								} // G 071
							

							countyStruct county = null;
                    		  	 
							   
                    		  	 
	       		  	    	countyStruct fromLookup_county = null;
							county = countyDefault;
										 
							
								 
							
							
								if (tHash_Lookup_county !=null && tHash_Lookup_county.hasNext()) { // G 099
								
							
								
								fromLookup_county = tHash_Lookup_county.next();

							
							
								} // G 099
							
							

							if(fromLookup_county != null) {
								county = fromLookup_county;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
        // ###############################
        // # Output tables

premiere = null;


// # Output table : 'premiere'
premiere_tmp.street_id = street.street_id ;
premiere_tmp.street_name = street.street_name ;
premiere_tmp.postal_code = street.postal_code ;
premiere_tmp.city_name = street.city_name ;
premiere_tmp.province_name = county.province_name ;
premiere_tmp.county = county.county_name ;
premiere_tmp.reagion_name = county.region_name ;
premiere_tmp.state_id = county.state_id ;
premiere_tmp.country = street.country ;
premiere = premiere_tmp;
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
// Start of branch "premiere"
if(premiere != null) { 



	
	/**
	 * [tMap_2 main ] start
	 */

	

	
	
	currentComponent="tMap_2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"premiere"
						
						);
					}
					

			


		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_2 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_2 = false;
		  boolean mainRowRejected_tMap_2 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "state" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLoopstate = false;
       		  	    	
       		  	    	
 							stateStruct stateObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_2) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_2 = false;
								
	                        		    	Object exprKeyValue_state__state_id = premiere.state_id ;
	                        		    	if(exprKeyValue_state__state_id == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_2 = true;
	                        		    	} else {
                        		    			stateHashKey.state_id = (double)(Double) exprKeyValue_state__state_id;
                        		    		}
                        		    		

								
		                        	stateHashKey.hashCodeDirty = true;
                        		
	  					
	  							
	
		  							if(!hasCasePrimitiveKeyWithNull_tMap_2) { // G_TM_M_091
		  							
			  					
			  					
			  					
	  					
		  							tHash_Lookup_state.lookup( stateHashKey );

	  							

	  							

			  						} // G_TM_M_091
			  						
			  					

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_state != null && tHash_Lookup_state.getCount(stateHashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'state' and it contains more one result from keys :  state.state_id = '" + stateHashKey.state_id + "'");
								} // G 071
							

							stateStruct state = null;
                    		  	 
							   
                    		  	 
	       		  	    	stateStruct fromLookup_state = null;
							state = stateDefault;
										 
							
								 
							
							
								if (tHash_Lookup_state !=null && tHash_Lookup_state.hasNext()) { // G 099
								
							
								
								fromLookup_state = tHash_Lookup_state.next();

							
							
								} // G 099
							
							

							if(fromLookup_state != null) {
								state = fromLookup_state;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_2__Struct Var = Var__tMap_2;// ###############################
        // ###############################
        // # Output tables

deuxieme = null;


// # Output table : 'deuxieme'
deuxieme_tmp.street_id = premiere.street_id ;
deuxieme_tmp.street_name = premiere.street_name ;
deuxieme_tmp.postal_code = premiere.postal_code ;
deuxieme_tmp.city_name = premiere.city_name ;
deuxieme_tmp.province_name = premiere.province_name ;
deuxieme_tmp.county = premiere.county ;
deuxieme_tmp.region_name = premiere.reagion_name ;
deuxieme_tmp.state_name = state.state_name ;
deuxieme_tmp.country = premiere.country ;
deuxieme_tmp.state_code = state.state_code ;
deuxieme = deuxieme_tmp;
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
// Start of branch "deuxieme"
if(deuxieme != null) { 



	
	/**
	 * [tMap_3 main ] start
	 */

	

	
	
	currentComponent="tMap_3";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"deuxieme"
						
						);
					}
					

			


		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_3 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_3 = false;
		  boolean mainRowRejected_tMap_3 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "country" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLoopcountry = false;
       		  	    	
       		  	    	
 							countryStruct countryObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_3) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_3 = false;
								
                        		    		    countryHashKey.country = deuxieme.country ;
                        		    		

								
		                        	countryHashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_country.lookup( countryHashKey );

	  							

	  							

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_country != null && tHash_Lookup_country.getCount(countryHashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'country' and it contains more one result from keys :  country.country = '" + countryHashKey.country + "'");
								} // G 071
							

							countryStruct country = null;
                    		  	 
							   
                    		  	 
	       		  	    	countryStruct fromLookup_country = null;
							country = countryDefault;
										 
							
								 
							
							
								if (tHash_Lookup_country !=null && tHash_Lookup_country.hasNext()) { // G 099
								
							
								
								fromLookup_country = tHash_Lookup_country.next();

							
							
								} // G 099
							
							

							if(fromLookup_country != null) {
								country = fromLookup_country;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_3__Struct Var = Var__tMap_3;// ###############################
        // ###############################
        // # Output tables

derniere = null;


// # Output table : 'derniere'
derniere_tmp.street_id = deuxieme.street_id ;
derniere_tmp.street_name = deuxieme.street_name ;
derniere_tmp.postal_code = deuxieme.postal_code ;
derniere_tmp.city_name = deuxieme.city_name ;
derniere_tmp.province_name = deuxieme.province_name ;
derniere_tmp.county = deuxieme.county ;
derniere_tmp.region_name = deuxieme.region_name ;
derniere_tmp.state_name = deuxieme.state_name ;
derniere_tmp.country = country.country_name ;
derniere_tmp.state_code = deuxieme.state_code ;
derniere_tmp.continent_id = country.continent_id ;
derniere = derniere_tmp;
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
// Start of branch "derniere"
if(derniere != null) { 



	
	/**
	 * [tMap_4 main ] start
	 */

	

	
	
	currentComponent="tMap_4";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"derniere"
						
						);
					}
					

			


		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_4 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_4 = false;
		  boolean mainRowRejected_tMap_4 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "continent" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLoopcontinent = false;
       		  	    	
       		  	    	
 							continentStruct continentObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_4) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_4 = false;
								
	                        		    	Object exprKeyValue_continent__continent_id = derniere.continent_id ;
	                        		    	if(exprKeyValue_continent__continent_id == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_4 = true;
	                        		    	} else {
                        		    			continentHashKey.continent_id = (double)(Double) exprKeyValue_continent__continent_id;
                        		    		}
                        		    		

								
		                        	continentHashKey.hashCodeDirty = true;
                        		
	  					
	  							
	
		  							if(!hasCasePrimitiveKeyWithNull_tMap_4) { // G_TM_M_091
		  							
			  					
			  					
			  					
	  					
		  							tHash_Lookup_continent.lookup( continentHashKey );

	  							

	  							

			  						} // G_TM_M_091
			  						
			  					

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_continent != null && tHash_Lookup_continent.getCount(continentHashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'continent' and it contains more one result from keys :  continent.continent_id = '" + continentHashKey.continent_id + "'");
								} // G 071
							

							continentStruct continent = null;
                    		  	 
							   
                    		  	 
	       		  	    	continentStruct fromLookup_continent = null;
							continent = continentDefault;
										 
							
								 
							
							
								if (tHash_Lookup_continent !=null && tHash_Lookup_continent.hasNext()) { // G 099
								
							
								
								fromLookup_continent = tHash_Lookup_continent.next();

							
							
								} // G 099
							
							

							if(fromLookup_continent != null) {
								continent = fromLookup_continent;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_4__Struct Var = Var__tMap_4;// ###############################
        // ###############################
        // # Output tables

fin = null;


// # Output table : 'fin'
fin_tmp.Street_ID = routines.system.TypeConvert.Double2Long(derniere.street_id );
fin_tmp.Continent = continent.continent_name ;
fin_tmp.Country = derniere.country ;
fin_tmp.State_Code = derniere.state_code ;
fin_tmp.State = derniere.state_name ;
fin_tmp.Region = derniere.region_name ;
fin_tmp.Province = derniere.province_name ;
fin_tmp.County = derniere.county ;
fin_tmp.City = derniere.city_name ;
fin_tmp.Postal_Code = derniere.postal_code ;
fin_tmp.Street_Name = derniere.street_name ;
fin = fin_tmp;
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
// Start of branch "fin"
if(fin != null) { 



	
	/**
	 * [tDBOutput_1 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"fin"
						
						);
					}
					



            row1 = null;
        whetherReject_tDBOutput_1 = false;
                    pstmt_tDBOutput_1.setLong(1, fin.Street_ID);

            int checkCount_tDBOutput_1 = -1;
            try (java.sql.ResultSet rs_tDBOutput_1 = pstmt_tDBOutput_1.executeQuery()) {
                while(rs_tDBOutput_1.next()) {
                    checkCount_tDBOutput_1 = rs_tDBOutput_1.getInt(1);
                }
            }
            if(checkCount_tDBOutput_1 > 0) {
                        if(fin.Continent == null) {
pstmtUpdate_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(1, fin.Continent);
}

                        if(fin.Country == null) {
pstmtUpdate_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(2, fin.Country);
}

                        if(fin.State_Code == null) {
pstmtUpdate_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(3, fin.State_Code);
}

                        if(fin.State == null) {
pstmtUpdate_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(4, fin.State);
}

                        if(fin.Region == null) {
pstmtUpdate_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(5, fin.Region);
}

                        if(fin.Province == null) {
pstmtUpdate_tDBOutput_1.setNull(6, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(6, fin.Province);
}

                        if(fin.County == null) {
pstmtUpdate_tDBOutput_1.setNull(7, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(7, fin.County);
}

                        if(fin.City == null) {
pstmtUpdate_tDBOutput_1.setNull(8, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(8, fin.City);
}

                        if(fin.Postal_Code == null) {
pstmtUpdate_tDBOutput_1.setNull(9, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(9, fin.Postal_Code);
}

                        if(fin.Street_Name == null) {
pstmtUpdate_tDBOutput_1.setNull(10, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(10, fin.Street_Name);
}

                        pstmtUpdate_tDBOutput_1.setLong(11 + count_tDBOutput_1, fin.Street_ID);

                try {
                    int processedCount_tDBOutput_1 = pstmtUpdate_tDBOutput_1.executeUpdate();
                    updatedCount_tDBOutput_1 += processedCount_tDBOutput_1;
                    rowsToCommitCount_tDBOutput_1 += processedCount_tDBOutput_1;
                    nb_line_tDBOutput_1++;
                } catch(java.lang.Exception e) {
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e.getMessage());
                    whetherReject_tDBOutput_1 = true;
                        nb_line_tDBOutput_1++;
                            System.err.print(e.getMessage());
                }
            } else {
                        pstmtInsert_tDBOutput_1.setLong(1, fin.Street_ID);

                        if(fin.Continent == null) {
pstmtInsert_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(2, fin.Continent);
}

                        if(fin.Country == null) {
pstmtInsert_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(3, fin.Country);
}

                        if(fin.State_Code == null) {
pstmtInsert_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(4, fin.State_Code);
}

                        if(fin.State == null) {
pstmtInsert_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(5, fin.State);
}

                        if(fin.Region == null) {
pstmtInsert_tDBOutput_1.setNull(6, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(6, fin.Region);
}

                        if(fin.Province == null) {
pstmtInsert_tDBOutput_1.setNull(7, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(7, fin.Province);
}

                        if(fin.County == null) {
pstmtInsert_tDBOutput_1.setNull(8, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(8, fin.County);
}

                        if(fin.City == null) {
pstmtInsert_tDBOutput_1.setNull(9, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(9, fin.City);
}

                        if(fin.Postal_Code == null) {
pstmtInsert_tDBOutput_1.setNull(10, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(10, fin.Postal_Code);
}

                        if(fin.Street_Name == null) {
pstmtInsert_tDBOutput_1.setNull(11, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(11, fin.Street_Name);
}

                try {
                    int processedCount_tDBOutput_1 = pstmtInsert_tDBOutput_1.executeUpdate();
                    insertedCount_tDBOutput_1 += processedCount_tDBOutput_1;
                    rowsToCommitCount_tDBOutput_1 += processedCount_tDBOutput_1;
                    nb_line_tDBOutput_1++;
                } catch(java.lang.Exception e) {
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e.getMessage());
                    whetherReject_tDBOutput_1 = true;
                        nb_line_tDBOutput_1++;
                            System.err.print(e.getMessage());
                }
            }
            if(!whetherReject_tDBOutput_1) {
                            row1 = new row1Struct();
                                row1.Street_ID = fin.Street_ID;
                                row1.Continent = fin.Continent;
                                row1.Country = fin.Country;
                                row1.State_Code = fin.State_Code;
                                row1.State = fin.State;
                                row1.Region = fin.Region;
                                row1.Province = fin.Province;
                                row1.County = fin.County;
                                row1.City = fin.City;
                                row1.Postal_Code = fin.Postal_Code;
                                row1.Street_Name = fin.Street_Name;
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
// Start of branch "row1"
if(row1 != null) { 



	
	/**
	 * [tLogRow_1 main ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row1"
						
						);
					}
					
///////////////////////		
						

				
				String[] row_tLogRow_1 = new String[11];
              
                 row_tLogRow_1[0]=    						    
				                String.valueOf(row1.Street_ID)			
					          ;	
										
    			   				
	    		if(row1.Continent != null) { //              
                 row_tLogRow_1[1]=    						    
				                String.valueOf(row1.Continent)			
					          ;	
							
	    		} //			
    			   				
	    		if(row1.Country != null) { //              
                 row_tLogRow_1[2]=    						    
				                String.valueOf(row1.Country)			
					          ;	
							
	    		} //			
    			   				
	    		if(row1.State_Code != null) { //              
                 row_tLogRow_1[3]=    						    
				                String.valueOf(row1.State_Code)			
					          ;	
							
	    		} //			
    			   				
	    		if(row1.State != null) { //              
                 row_tLogRow_1[4]=    						    
				                String.valueOf(row1.State)			
					          ;	
							
	    		} //			
    			   				
	    		if(row1.Region != null) { //              
                 row_tLogRow_1[5]=    						    
				                String.valueOf(row1.Region)			
					          ;	
							
	    		} //			
    			   				
	    		if(row1.Province != null) { //              
                 row_tLogRow_1[6]=    						    
				                String.valueOf(row1.Province)			
					          ;	
							
	    		} //			
    			   				
	    		if(row1.County != null) { //              
                 row_tLogRow_1[7]=    						    
				                String.valueOf(row1.County)			
					          ;	
							
	    		} //			
    			   				
	    		if(row1.City != null) { //              
                 row_tLogRow_1[8]=    						    
				                String.valueOf(row1.City)			
					          ;	
							
	    		} //			
    			   				
	    		if(row1.Postal_Code != null) { //              
                 row_tLogRow_1[9]=    						    
				                String.valueOf(row1.Postal_Code)			
					          ;	
							
	    		} //			
    			   				
	    		if(row1.Street_Name != null) { //              
                 row_tLogRow_1[10]=    						    
				                String.valueOf(row1.Street_Name)			
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

} // End of branch "row1"




	
	/**
	 * [tDBOutput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	

 



/**
 * [tDBOutput_1 process_data_end ] stop
 */

} // End of branch "fin"




	
	/**
	 * [tMap_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_4";

	

 



/**
 * [tMap_4 process_data_end ] stop
 */

} // End of branch "derniere"




	
	/**
	 * [tMap_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_3";

	

 



/**
 * [tMap_3 process_data_end ] stop
 */

} // End of branch "deuxieme"




	
	/**
	 * [tMap_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_2";

	

 



/**
 * [tMap_2 process_data_end ] stop
 */

} // End of branch "premiere"




	
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
					if(tHash_Lookup_county != null) {
						tHash_Lookup_county.endGet();
					}
					globalMap.remove( "tHash_Lookup_county" );

					
					
				
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"street");
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
					if(tHash_Lookup_state != null) {
						tHash_Lookup_state.endGet();
					}
					globalMap.remove( "tHash_Lookup_state" );

					
					
				
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"premiere");
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
					if(tHash_Lookup_country != null) {
						tHash_Lookup_country.endGet();
					}
					globalMap.remove( "tHash_Lookup_country" );

					
					
				
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"deuxieme");
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
					if(tHash_Lookup_continent != null) {
						tHash_Lookup_continent.endGet();
					}
					globalMap.remove( "tHash_Lookup_continent" );

					
					
				
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"derniere");
			  	}
			  	
 

ok_Hash.put("tMap_4", true);
end_Hash.put("tMap_4", System.currentTimeMillis());




/**
 * [tMap_4 end ] stop
 */

	
	/**
	 * [tDBOutput_1 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	



        if(pstmtUpdate_tDBOutput_1 != null){
            pstmtUpdate_tDBOutput_1.close();
            resourceMap.remove("pstmtUpdate_tDBOutput_1");
        }
        if(pstmtInsert_tDBOutput_1 != null){
            pstmtInsert_tDBOutput_1.close();
            resourceMap.remove("pstmtInsert_tDBOutput_1");
        }
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
			  		runStat.updateStat(resourceMap,iterateId,2,0,"fin");
			  	}
			  	
 

ok_Hash.put("tDBOutput_1", true);
end_Hash.put("tDBOutput_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk5", 0, "ok");
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
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row1");
			  	}
			  	
 

ok_Hash.put("tLogRow_1", true);
end_Hash.put("tLogRow_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk6", 0, "ok");
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
				
					     			//free memory for "tMap_4"
					     			globalMap.remove("tHash_Lookup_continent"); 
				     			
					     			//free memory for "tMap_3"
					     			globalMap.remove("tHash_Lookup_country"); 
				     			
					     			//free memory for "tMap_2"
					     			globalMap.remove("tHash_Lookup_state"); 
				     			
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_county"); 
				     			
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
	 * [tDBOutput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	



    if (resourceMap.get("statementClosed_tDBOutput_1") == null) {
                java.sql.PreparedStatement pstmtUpdateToClose_tDBOutput_1 = null;
                if ((pstmtUpdateToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap.remove("pstmtUpdate_tDBOutput_1")) != null) {
                    pstmtUpdateToClose_tDBOutput_1.close();
                }
                java.sql.PreparedStatement pstmtInsertToClose_tDBOutput_1 = null;
                if ((pstmtInsertToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap.remove("pstmtInsert_tDBOutput_1")) != null) {
                    pstmtInsertToClose_tDBOutput_1.close();
                }
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
System.out.println("L\'execution du job de remplisage de la dimension Geographie c'est effectuer avec succée." +"\n Fin du Job");
 



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




/**
 * [tJava_1 end ] stop
 */
				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tJava_1:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk1", 0, "ok");
								} 
							
							tSendMail_1Process(globalMap); 
						



	
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
	

public void tSendMail_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tSendMail_1_SUBPROCESS_STATE", 0);

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
	 * [tSendMail_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tSendMail_1", false);
		start_Hash.put("tSendMail_1", System.currentTimeMillis());
		
	
	currentComponent="tSendMail_1";

	
		int tos_count_tSendMail_1 = 0;
		

 



/**
 * [tSendMail_1 begin ] stop
 */
	
	/**
	 * [tSendMail_1 main ] start
	 */

	

	
	
	currentComponent="tSendMail_1";

	

 

	String smtpHost_tSendMail_1 = "smtp.gmail.com";
        String smtpPort_tSendMail_1 = "587";
	String from_tSendMail_1 = ("duplusse.nangmo@facsciences-uy1.cm");
    String to_tSendMail_1 = ("richel.kembou@facsciences-uy1.cm").replace(";",",");
    String cc_tSendMail_1 = (("")==null || "".equals(""))?null:("").replace(";",",");
    String bcc_tSendMail_1 = (("")==null || "".equals(""))?null:("").replace(";",",");
    String subject_tSendMail_1 = ("Talend Open Studio notification for DIM GeoGraphy");
    
	java.util.List<java.util.Map<String, String>> headers_tSendMail_1 = new java.util.ArrayList<java.util.Map<String,String>>();
	java.util.List<String> attachments_tSendMail_1 = new java.util.ArrayList<String>();
	java.util.List<String> contentTransferEncoding_tSendMail_1 = new java.util.ArrayList<String>();

	String message_tSendMail_1 = (("eecution du job de remplissage de la dimmension Geographie effectuer avec succes") == null || "".equals("eecution du job de remplissage de la dimmension Geographie effectuer avec succes")) ? "\"\"" : ("eecution du job de remplissage de la dimmension Geographie effectuer avec succes") ;
	java.util.Properties props_tSendMail_1 = System.getProperties();     
	props_tSendMail_1.put("mail.smtp.host", smtpHost_tSendMail_1);
	props_tSendMail_1.put("mail.smtp.port", smtpPort_tSendMail_1);
		props_tSendMail_1.put("mail.mime.encodefilename", "true");
		props_tSendMail_1.put("mail.smtp.starttls.enable","true");     
	try {
		
		
			props_tSendMail_1.put("mail.smtp.auth", "true");
			javax.mail.Session session_tSendMail_1 = javax.mail.Session.getInstance(props_tSendMail_1, new javax.mail.Authenticator(){         
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				
                 
	final String decryptedPassword_tSendMail_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:m7yhz8jDpsEFAnVjAWtoqoIY2j1bZtOX6bUh59k55eHMEBZCu4HCh5Yp7wzhP2g=");
				
				
				return new javax.mail.PasswordAuthentication("duplusse.nangmo@facsciences-uy1.cm", decryptedPassword_tSendMail_1); 
				}         
			});   
		
		
		javax.mail.Message msg_tSendMail_1 = new javax.mail.internet.MimeMessage(session_tSendMail_1);
		msg_tSendMail_1.setFrom(new javax.mail.internet.InternetAddress(from_tSendMail_1, "Duplesse Nangmo"));
		msg_tSendMail_1.setRecipients(javax.mail.Message.RecipientType.TO,javax.mail.internet.InternetAddress.parse(to_tSendMail_1, false));
		if (cc_tSendMail_1 != null) msg_tSendMail_1.setRecipients(javax.mail.Message.RecipientType.CC, javax.mail.internet.InternetAddress.parse(cc_tSendMail_1, false));
		if (bcc_tSendMail_1 != null) msg_tSendMail_1.setRecipients(javax.mail.Message.RecipientType.BCC, javax.mail.internet.InternetAddress.parse(bcc_tSendMail_1, false));
		msg_tSendMail_1.setSubject(subject_tSendMail_1);

		for (int i_tSendMail_1 = 0; i_tSendMail_1 < headers_tSendMail_1.size(); i_tSendMail_1++) {
			java.util.Map<String, String> header_tSendMail_1 = headers_tSendMail_1.get(i_tSendMail_1);
			msg_tSendMail_1.setHeader(header_tSendMail_1.get("KEY"), header_tSendMail_1.get("VALUE"));    
		}  
		msg_tSendMail_1.setSentDate(new Date());
		msg_tSendMail_1.setHeader("X-Priority", "3"); //High->1 Normal->3 Low->5
		javax.mail.Multipart mp_tSendMail_1 = new javax.mail.internet.MimeMultipart();
		javax.mail.internet.MimeBodyPart mbpText_tSendMail_1 = new javax.mail.internet.MimeBodyPart();
		mbpText_tSendMail_1.setText(message_tSendMail_1,"ISO-8859-15", "plain");
		mp_tSendMail_1.addBodyPart(mbpText_tSendMail_1);
  
		javax.mail.internet.MimeBodyPart mbpFile_tSendMail_1 = null;

		for (int i_tSendMail_1 = 0; i_tSendMail_1 < attachments_tSendMail_1.size(); i_tSendMail_1++){
			String filename_tSendMail_1 = attachments_tSendMail_1.get(i_tSendMail_1);
			javax.activation.FileDataSource fds_tSendMail_1 = null;
			java.io.File file_tSendMail_1 = new java.io.File(filename_tSendMail_1);
			
				if (!file_tSendMail_1.exists()){
					continue;
				}
			
    		if (file_tSendMail_1.isDirectory()){
				java.io.File[] subFiles_tSendMail_1 = file_tSendMail_1.listFiles();
				for(java.io.File subFile_tSendMail_1 : subFiles_tSendMail_1){
					if (subFile_tSendMail_1.isFile()){
						fds_tSendMail_1 = new javax.activation.FileDataSource(subFile_tSendMail_1.getAbsolutePath());
						mbpFile_tSendMail_1 = new javax.mail.internet.MimeBodyPart();
						mbpFile_tSendMail_1.setDataHandler(new javax.activation.DataHandler(fds_tSendMail_1));
						mbpFile_tSendMail_1.setFileName(javax.mail.internet.MimeUtility.encodeText(fds_tSendMail_1.getName()));
						if(contentTransferEncoding_tSendMail_1.get(i_tSendMail_1).equalsIgnoreCase("base64")){
							mbpFile_tSendMail_1.setHeader("Content-Transfer-Encoding", "base64");
						}
						mp_tSendMail_1.addBodyPart(mbpFile_tSendMail_1);
					}
				}
    		}else{
				mbpFile_tSendMail_1 = new javax.mail.internet.MimeBodyPart();
				fds_tSendMail_1 = new javax.activation.FileDataSource(filename_tSendMail_1);
				mbpFile_tSendMail_1.setDataHandler(new javax.activation.DataHandler(fds_tSendMail_1)); 
				mbpFile_tSendMail_1.setFileName(javax.mail.internet.MimeUtility.encodeText(fds_tSendMail_1.getName()));
				if(contentTransferEncoding_tSendMail_1.get(i_tSendMail_1).equalsIgnoreCase("base64")){
					mbpFile_tSendMail_1.setHeader("Content-Transfer-Encoding", "base64");
				}
				mp_tSendMail_1.addBodyPart(mbpFile_tSendMail_1);
			}
		}
		// -- set the content --
		msg_tSendMail_1.setContent(mp_tSendMail_1);
		// add handlers for main MIME types
		javax.activation.MailcapCommandMap mc_tSendMail_1 = ( javax.activation.MailcapCommandMap)javax.activation.CommandMap.getDefaultCommandMap();
		mc_tSendMail_1.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
		mc_tSendMail_1.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
		mc_tSendMail_1.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
		mc_tSendMail_1.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
		mc_tSendMail_1.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
		javax.activation.CommandMap.setDefaultCommandMap(mc_tSendMail_1);
		// add com.sun.mail.handlers to job imports / depenencies (TESB-27110)
		com.sun.mail.handlers.text_plain text_plain_h_tSendMail_1 = null;
		// -- Send the message --
		javax.mail.Transport.send(msg_tSendMail_1);
	} catch(java.lang.Exception e){
globalMap.put("tSendMail_1_ERROR_MESSAGE",e.getMessage());
  		
			throw(e);
		
	}finally{
		props_tSendMail_1.remove("mail.smtp.host");
		props_tSendMail_1.remove("mail.smtp.port");
		
		props_tSendMail_1.remove("mail.mime.encodefilename");
		
			props_tSendMail_1.remove("mail.smtp.starttls.enable");
		
		props_tSendMail_1.remove("mail.smtp.auth");     
	}

 


	tos_count_tSendMail_1++;

/**
 * [tSendMail_1 main ] stop
 */
	
	/**
	 * [tSendMail_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tSendMail_1";

	

 



/**
 * [tSendMail_1 process_data_begin ] stop
 */
	
	/**
	 * [tSendMail_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tSendMail_1";

	

 



/**
 * [tSendMail_1 process_data_end ] stop
 */
	
	/**
	 * [tSendMail_1 end ] start
	 */

	

	
	
	currentComponent="tSendMail_1";

	

 

ok_Hash.put("tSendMail_1", true);
end_Hash.put("tSendMail_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk7", 0, "ok");
				}
				tJava_2Process(globalMap);



/**
 * [tSendMail_1 end ] stop
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
	 * [tSendMail_1 finally ] start
	 */

	

	
	
	currentComponent="tSendMail_1";

	

 



/**
 * [tSendMail_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tSendMail_1_SUBPROCESS_STATE", 1);
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
	
			
			conn_tDBCommit_1.commit();
			
	
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
	
			conn_tDBRollback_1.rollback();
			
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
	


public static class countyStruct implements routines.system.IPersistableComparableLookupRow<countyStruct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public double county_id;

				public double getCounty_id () {
					return this.county_id;
				}
				
			    public Double county_type;

				public Double getCounty_type () {
					return this.county_type;
				}
				
			    public String county_name;

				public String getCounty_name () {
					return this.county_name;
				}
				
			    public Double province_type;

				public Double getProvince_type () {
					return this.province_type;
				}
				
			    public String province_name;

				public String getProvince_name () {
					return this.province_name;
				}
				
			    public String region_name;

				public String getRegion_name () {
					return this.region_name;
				}
				
			    public Double region_type;

				public Double getRegion_type () {
					return this.region_type;
				}
				
			    public Double state_id;

				public Double getState_id () {
					return this.state_id;
				}
				
			    public String country;

				public String getCountry () {
					return this.country;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.county_id;
						
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
		final countyStruct other = (countyStruct) obj;
		
						if (this.county_id != other.county_id)
							return false;
					

		return true;
    }

	public void copyDataTo(countyStruct other) {

		other.county_id = this.county_id;
	            other.county_type = this.county_type;
	            other.county_name = this.county_name;
	            other.province_type = this.province_type;
	            other.province_name = this.province_name;
	            other.region_name = this.region_name;
	            other.region_type = this.region_type;
	            other.state_id = this.state_id;
	            other.country = this.country;
	            
	}

	public void copyKeysDataTo(countyStruct other) {

		other.county_id = this.county_id;
	            	
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

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie) {

        	try {

        		int length = 0;
		
			        this.county_id = dis.readDouble();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie) {

        	try {

        		int length = 0;
		
			        this.county_id = dis.readDouble();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.county_id);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.county_id);
					
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
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.county_type = null;
           				} else {
           			    	this.county_type = dis.readDouble();
           				}
					
						this.county_name = readString(dis,ois);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.province_type = null;
           				} else {
           			    	this.province_type = dis.readDouble();
           				}
					
						this.province_name = readString(dis,ois);
					
						this.region_name = readString(dis,ois);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.region_type = null;
           				} else {
           			    	this.region_type = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.state_id = null;
           				} else {
           			    	this.state_id = dis.readDouble();
           				}
					
						this.country = readString(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.county_type = null;
           				} else {
           			    	this.county_type = objectIn.readDouble();
           				}
					
						this.county_name = readString(dis,objectIn);
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.province_type = null;
           				} else {
           			    	this.province_type = objectIn.readDouble();
           				}
					
						this.province_name = readString(dis,objectIn);
					
						this.region_name = readString(dis,objectIn);
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.region_type = null;
           				} else {
           			    	this.region_type = objectIn.readDouble();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.state_id = null;
           				} else {
           			    	this.state_id = objectIn.readDouble();
           				}
					
						this.country = readString(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
						if(this.county_type == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.county_type);
		            	}
					
						writeString(this.county_name, dos, oos);
					
						if(this.province_type == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.province_type);
		            	}
					
						writeString(this.province_name, dos, oos);
					
						writeString(this.region_name, dos, oos);
					
						if(this.region_type == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.region_type);
		            	}
					
						if(this.state_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.state_id);
		            	}
					
						writeString(this.country, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						if(this.county_type == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.county_type);
		            	}
					
						writeString(this.county_name, dos, objectOut);
					
						if(this.province_type == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.province_type);
		            	}
					
						writeString(this.province_name, dos, objectOut);
					
						writeString(this.region_name, dos, objectOut);
					
						if(this.region_type == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.region_type);
		            	}
					
						if(this.state_id == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.state_id);
		            	}
					
						writeString(this.country, dos, objectOut);
					
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
		sb.append("county_id="+String.valueOf(county_id));
		sb.append(",county_type="+String.valueOf(county_type));
		sb.append(",county_name="+county_name);
		sb.append(",province_type="+String.valueOf(province_type));
		sb.append(",province_name="+province_name);
		sb.append(",region_name="+region_name);
		sb.append(",region_type="+String.valueOf(region_type));
		sb.append(",state_id="+String.valueOf(state_id));
		sb.append(",country="+country);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(countyStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.county_id, other.county_id);
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



		countyStruct county = new countyStruct();




	
	/**
	 * [tAdvancedHash_county begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_county", false);
		start_Hash.put("tAdvancedHash_county", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_county";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"county");
					}
				
		int tos_count_tAdvancedHash_county = 0;
		

			   		// connection name:county
			   		// source node:tDBInput_2 - inputs:(after_tDBInput_1) outputs:(county,county) | target node:tAdvancedHash_county - inputs:(county) outputs:()
			   		// linked node: tMap_1 - inputs:(street,county) outputs:(premiere)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_county = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<countyStruct> tHash_Lookup_county =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<countyStruct>getLookup(matchingModeEnum_county);
	   						   
		   	   	   globalMap.put("tHash_Lookup_county", tHash_Lookup_county);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_county begin ] stop
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

		    String dbquery_tDBInput_2 = "SELECT COUNTY.county_id,\n		COUNTY.county_type,\n		COUNTY.county_name,\n		COUNTY.province_type,\n		COUNTY.province_name,\n		"
+"COUNTY.region_name,\n		COUNTY.region_type,\n		COUNTY.state_id,\n		COUNTY.country\nFROM	COUNTY";
		    

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
								county.county_id = 0;
							} else {
	                         		
            county.county_id = rs_tDBInput_2.getDouble(1);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 2) {
								county.county_type = null;
							} else {
	                         		
            county.county_type = rs_tDBInput_2.getDouble(2);
            if(rs_tDBInput_2.wasNull()){
                    county.county_type = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 3) {
								county.county_name = null;
							} else {
	                         		
        	county.county_name = routines.system.JDBCUtil.getString(rs_tDBInput_2, 3, false);
		                    }
							if(colQtyInRs_tDBInput_2 < 4) {
								county.province_type = null;
							} else {
	                         		
            county.province_type = rs_tDBInput_2.getDouble(4);
            if(rs_tDBInput_2.wasNull()){
                    county.province_type = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 5) {
								county.province_name = null;
							} else {
	                         		
        	county.province_name = routines.system.JDBCUtil.getString(rs_tDBInput_2, 5, false);
		                    }
							if(colQtyInRs_tDBInput_2 < 6) {
								county.region_name = null;
							} else {
	                         		
        	county.region_name = routines.system.JDBCUtil.getString(rs_tDBInput_2, 6, false);
		                    }
							if(colQtyInRs_tDBInput_2 < 7) {
								county.region_type = null;
							} else {
	                         		
            county.region_type = rs_tDBInput_2.getDouble(7);
            if(rs_tDBInput_2.wasNull()){
                    county.region_type = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 8) {
								county.state_id = null;
							} else {
	                         		
            county.state_id = rs_tDBInput_2.getDouble(8);
            if(rs_tDBInput_2.wasNull()){
                    county.state_id = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 9) {
								county.country = null;
							} else {
	                         		
        	county.country = routines.system.JDBCUtil.getString(rs_tDBInput_2, 9, false);
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
	 * [tAdvancedHash_county main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_county";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"county"
						
						);
					}
					


			   
			   

					countyStruct county_HashRow = new countyStruct();
		   	   	   
				
				county_HashRow.county_id = county.county_id;
				
				county_HashRow.county_type = county.county_type;
				
				county_HashRow.county_name = county.county_name;
				
				county_HashRow.province_type = county.province_type;
				
				county_HashRow.province_name = county.province_name;
				
				county_HashRow.region_name = county.region_name;
				
				county_HashRow.region_type = county.region_type;
				
				county_HashRow.state_id = county.state_id;
				
				county_HashRow.country = county.country;
				
			tHash_Lookup_county.put(county_HashRow);
			
            




 


	tos_count_tAdvancedHash_county++;

/**
 * [tAdvancedHash_county main ] stop
 */
	
	/**
	 * [tAdvancedHash_county process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_county";

	

 



/**
 * [tAdvancedHash_county process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_county process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_county";

	

 



/**
 * [tAdvancedHash_county process_data_end ] stop
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
	 * [tAdvancedHash_county end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_county";

	

tHash_Lookup_county.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"county");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_county", true);
end_Hash.put("tAdvancedHash_county", System.currentTimeMillis());




/**
 * [tAdvancedHash_county end ] stop
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
	 * [tAdvancedHash_county finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_county";

	

 



/**
 * [tAdvancedHash_county finally ] stop
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
	


public static class stateStruct implements routines.system.IPersistableComparableLookupRow<stateStruct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public double state_id;

				public double getState_id () {
					return this.state_id;
				}
				
			    public Double state_type;

				public Double getState_type () {
					return this.state_type;
				}
				
			    public String state_code;

				public String getState_code () {
					return this.state_code;
				}
				
			    public String state_name;

				public String getState_name () {
					return this.state_name;
				}
				
			    public String country;

				public String getCountry () {
					return this.country;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.state_id;
						
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
		final stateStruct other = (stateStruct) obj;
		
						if (this.state_id != other.state_id)
							return false;
					

		return true;
    }

	public void copyDataTo(stateStruct other) {

		other.state_id = this.state_id;
	            other.state_type = this.state_type;
	            other.state_code = this.state_code;
	            other.state_name = this.state_name;
	            other.country = this.country;
	            
	}

	public void copyKeysDataTo(stateStruct other) {

		other.state_id = this.state_id;
	            	
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

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie) {

        	try {

        		int length = 0;
		
			        this.state_id = dis.readDouble();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie) {

        	try {

        		int length = 0;
		
			        this.state_id = dis.readDouble();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.state_id);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.state_id);
					
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
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.state_type = null;
           				} else {
           			    	this.state_type = dis.readDouble();
           				}
					
						this.state_code = readString(dis,ois);
					
						this.state_name = readString(dis,ois);
					
						this.country = readString(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.state_type = null;
           				} else {
           			    	this.state_type = objectIn.readDouble();
           				}
					
						this.state_code = readString(dis,objectIn);
					
						this.state_name = readString(dis,objectIn);
					
						this.country = readString(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
						if(this.state_type == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.state_type);
		            	}
					
						writeString(this.state_code, dos, oos);
					
						writeString(this.state_name, dos, oos);
					
						writeString(this.country, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						if(this.state_type == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.state_type);
		            	}
					
						writeString(this.state_code, dos, objectOut);
					
						writeString(this.state_name, dos, objectOut);
					
						writeString(this.country, dos, objectOut);
					
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
		sb.append("state_id="+String.valueOf(state_id));
		sb.append(",state_type="+String.valueOf(state_type));
		sb.append(",state_code="+state_code);
		sb.append(",state_name="+state_name);
		sb.append(",country="+country);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(stateStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.state_id, other.state_id);
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



		stateStruct state = new stateStruct();




	
	/**
	 * [tAdvancedHash_state begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_state", false);
		start_Hash.put("tAdvancedHash_state", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_state";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"state");
					}
				
		int tos_count_tAdvancedHash_state = 0;
		

			   		// connection name:state
			   		// source node:tDBInput_3 - inputs:(after_tDBInput_1) outputs:(state,state) | target node:tAdvancedHash_state - inputs:(state) outputs:()
			   		// linked node: tMap_2 - inputs:(premiere,state) outputs:(deuxieme)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_state = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<stateStruct> tHash_Lookup_state =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<stateStruct>getLookup(matchingModeEnum_state);
	   						   
		   	   	   globalMap.put("tHash_Lookup_state", tHash_Lookup_state);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_state begin ] stop
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

		    String dbquery_tDBInput_3 = "SELECT STATE.state_id,\n		STATE.state_type,\n		STATE.state_code,\n		STATE.state_name,\n		STATE.country\nFROM	STATE";
		    

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
								state.state_id = 0;
							} else {
	                         		
            state.state_id = rs_tDBInput_3.getDouble(1);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 2) {
								state.state_type = null;
							} else {
	                         		
            state.state_type = rs_tDBInput_3.getDouble(2);
            if(rs_tDBInput_3.wasNull()){
                    state.state_type = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 3) {
								state.state_code = null;
							} else {
	                         		
        	state.state_code = routines.system.JDBCUtil.getString(rs_tDBInput_3, 3, false);
		                    }
							if(colQtyInRs_tDBInput_3 < 4) {
								state.state_name = null;
							} else {
	                         		
        	state.state_name = routines.system.JDBCUtil.getString(rs_tDBInput_3, 4, false);
		                    }
							if(colQtyInRs_tDBInput_3 < 5) {
								state.country = null;
							} else {
	                         		
        	state.country = routines.system.JDBCUtil.getString(rs_tDBInput_3, 5, false);
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
	 * [tAdvancedHash_state main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_state";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"state"
						
						);
					}
					


			   
			   

					stateStruct state_HashRow = new stateStruct();
		   	   	   
				
				state_HashRow.state_id = state.state_id;
				
				state_HashRow.state_type = state.state_type;
				
				state_HashRow.state_code = state.state_code;
				
				state_HashRow.state_name = state.state_name;
				
				state_HashRow.country = state.country;
				
			tHash_Lookup_state.put(state_HashRow);
			
            




 


	tos_count_tAdvancedHash_state++;

/**
 * [tAdvancedHash_state main ] stop
 */
	
	/**
	 * [tAdvancedHash_state process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_state";

	

 



/**
 * [tAdvancedHash_state process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_state process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_state";

	

 



/**
 * [tAdvancedHash_state process_data_end ] stop
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
	 * [tAdvancedHash_state end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_state";

	

tHash_Lookup_state.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"state");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_state", true);
end_Hash.put("tAdvancedHash_state", System.currentTimeMillis());




/**
 * [tAdvancedHash_state end ] stop
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
	 * [tAdvancedHash_state finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_state";

	

 



/**
 * [tAdvancedHash_state finally ] stop
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
	


public static class countryStruct implements routines.system.IPersistableComparableLookupRow<countryStruct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String country;

				public String getCountry () {
					return this.country;
				}
				
			    public String country_name;

				public String getCountry_name () {
					return this.country_name;
				}
				
			    public double population;

				public double getPopulation () {
					return this.population;
				}
				
			    public double country_id;

				public double getCountry_id () {
					return this.country_id;
				}
				
			    public double continent_id;

				public double getContinent_id () {
					return this.continent_id;
				}
				
			    public String country_formername;

				public String getCountry_formername () {
					return this.country_formername;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.country == null) ? 0 : this.country.hashCode());
					
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
		final countryStruct other = (countryStruct) obj;
		
						if (this.country == null) {
							if (other.country != null)
								return false;
						
						} else if (!this.country.equals(other.country))
						
							return false;
					

		return true;
    }

	public void copyDataTo(countryStruct other) {

		other.country = this.country;
	            other.country_name = this.country_name;
	            other.population = this.population;
	            other.country_id = this.country_id;
	            other.continent_id = this.continent_id;
	            other.country_formername = this.country_formername;
	            
	}

	public void copyKeysDataTo(countryStruct other) {

		other.country = this.country;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie, 0, length, utf8Charset);
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
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie, 0, length, utf8Charset);
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

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie) {

        	try {

        		int length = 0;
		
					this.country = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie) {

        	try {

        		int length = 0;
		
					this.country = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.country,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.country,dos);
					
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
		
						this.country_name = readString(dis,ois);
					
			            this.population = dis.readDouble();
					
			            this.country_id = dis.readDouble();
					
			            this.continent_id = dis.readDouble();
					
						this.country_formername = readString(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
						this.country_name = readString(dis,objectIn);
					
			            this.population = objectIn.readDouble();
					
			            this.country_id = objectIn.readDouble();
					
			            this.continent_id = objectIn.readDouble();
					
						this.country_formername = readString(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
						writeString(this.country_name, dos, oos);
					
		            	dos.writeDouble(this.population);
					
		            	dos.writeDouble(this.country_id);
					
		            	dos.writeDouble(this.continent_id);
					
						writeString(this.country_formername, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						writeString(this.country_name, dos, objectOut);
					
					objectOut.writeDouble(this.population);
					
					objectOut.writeDouble(this.country_id);
					
					objectOut.writeDouble(this.continent_id);
					
						writeString(this.country_formername, dos, objectOut);
					
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
		sb.append("country="+country);
		sb.append(",country_name="+country_name);
		sb.append(",population="+String.valueOf(population));
		sb.append(",country_id="+String.valueOf(country_id));
		sb.append(",continent_id="+String.valueOf(continent_id));
		sb.append(",country_formername="+country_formername);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(countryStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.country, other.country);
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



		countryStruct country = new countryStruct();




	
	/**
	 * [tAdvancedHash_country begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_country", false);
		start_Hash.put("tAdvancedHash_country", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_country";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"country");
					}
				
		int tos_count_tAdvancedHash_country = 0;
		

			   		// connection name:country
			   		// source node:tDBInput_4 - inputs:(after_tDBInput_1) outputs:(country,country) | target node:tAdvancedHash_country - inputs:(country) outputs:()
			   		// linked node: tMap_3 - inputs:(deuxieme,country) outputs:(derniere)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_country = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<countryStruct> tHash_Lookup_country =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<countryStruct>getLookup(matchingModeEnum_country);
	   						   
		   	   	   globalMap.put("tHash_Lookup_country", tHash_Lookup_country);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_country begin ] stop
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
			    String driverClass_tDBInput_4 = "org.sqlite.JDBC";
			    java.lang.Class.forName(driverClass_tDBInput_4);
				
			String url_tDBInput_4 = "jdbc:sqlite:" + "/" + "/home/duplesse/Musique/TP_BI/BDOrion.sqlite";
			
		        conn_tDBInput_4 = java.sql.DriverManager.getConnection(url_tDBInput_4);
		    
			java.sql.Statement stmt_tDBInput_4 = conn_tDBInput_4.createStatement();

		    String dbquery_tDBInput_4 = "SELECT COUNTRY.country,\n		COUNTRY.country_name,\n		COUNTRY.population,\n		COUNTRY.country_id,\n		COUNTRY.continent_id,\n		C"
+"OUNTRY.country_formername\nFROM	COUNTRY";
		    

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
								country.country = null;
							} else {
	                         		
        	country.country = routines.system.JDBCUtil.getString(rs_tDBInput_4, 1, false);
		                    }
							if(colQtyInRs_tDBInput_4 < 2) {
								country.country_name = null;
							} else {
	                         		
        	country.country_name = routines.system.JDBCUtil.getString(rs_tDBInput_4, 2, false);
		                    }
							if(colQtyInRs_tDBInput_4 < 3) {
								country.population = 0;
							} else {
	                         		
            country.population = rs_tDBInput_4.getDouble(3);
            if(rs_tDBInput_4.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 4) {
								country.country_id = 0;
							} else {
	                         		
            country.country_id = rs_tDBInput_4.getDouble(4);
            if(rs_tDBInput_4.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 5) {
								country.continent_id = 0;
							} else {
	                         		
            country.continent_id = rs_tDBInput_4.getDouble(5);
            if(rs_tDBInput_4.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 6) {
								country.country_formername = null;
							} else {
	                         		
        	country.country_formername = routines.system.JDBCUtil.getString(rs_tDBInput_4, 6, false);
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
	 * [tAdvancedHash_country main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_country";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"country"
						
						);
					}
					


			   
			   

					countryStruct country_HashRow = new countryStruct();
		   	   	   
				
				country_HashRow.country = country.country;
				
				country_HashRow.country_name = country.country_name;
				
				country_HashRow.population = country.population;
				
				country_HashRow.country_id = country.country_id;
				
				country_HashRow.continent_id = country.continent_id;
				
				country_HashRow.country_formername = country.country_formername;
				
			tHash_Lookup_country.put(country_HashRow);
			
            




 


	tos_count_tAdvancedHash_country++;

/**
 * [tAdvancedHash_country main ] stop
 */
	
	/**
	 * [tAdvancedHash_country process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_country";

	

 



/**
 * [tAdvancedHash_country process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_country process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_country";

	

 



/**
 * [tAdvancedHash_country process_data_end ] stop
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
		if(conn_tDBInput_4 != null && !conn_tDBInput_4.isClosed()) {
			
			conn_tDBInput_4.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
		}
}
globalMap.put("tDBInput_4_NB_LINE",nb_line_tDBInput_4);

 

ok_Hash.put("tDBInput_4", true);
end_Hash.put("tDBInput_4", System.currentTimeMillis());




/**
 * [tDBInput_4 end ] stop
 */

	
	/**
	 * [tAdvancedHash_country end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_country";

	

tHash_Lookup_country.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"country");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_country", true);
end_Hash.put("tAdvancedHash_country", System.currentTimeMillis());




/**
 * [tAdvancedHash_country end ] stop
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
	 * [tAdvancedHash_country finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_country";

	

 



/**
 * [tAdvancedHash_country finally ] stop
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
	


public static class continentStruct implements routines.system.IPersistableComparableLookupRow<continentStruct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public double continent_id;

				public double getContinent_id () {
					return this.continent_id;
				}
				
			    public String continent_name;

				public String getContinent_name () {
					return this.continent_name;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.continent_id;
						
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
		final continentStruct other = (continentStruct) obj;
		
						if (this.continent_id != other.continent_id)
							return false;
					

		return true;
    }

	public void copyDataTo(continentStruct other) {

		other.continent_id = this.continent_id;
	            other.continent_name = this.continent_name;
	            
	}

	public void copyKeysDataTo(continentStruct other) {

		other.continent_id = this.continent_id;
	            	
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

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie) {

        	try {

        		int length = 0;
		
			        this.continent_id = dis.readDouble();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Copy_of_Geographie) {

        	try {

        		int length = 0;
		
			        this.continent_id = dis.readDouble();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.continent_id);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.continent_id);
					
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
		
						this.continent_name = readString(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
						this.continent_name = readString(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
						writeString(this.continent_name, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						writeString(this.continent_name, dos, objectOut);
					
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
		sb.append("continent_id="+String.valueOf(continent_id));
		sb.append(",continent_name="+continent_name);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(continentStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.continent_id, other.continent_id);
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



		continentStruct continent = new continentStruct();




	
	/**
	 * [tAdvancedHash_continent begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_continent", false);
		start_Hash.put("tAdvancedHash_continent", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_continent";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"continent");
					}
				
		int tos_count_tAdvancedHash_continent = 0;
		

			   		// connection name:continent
			   		// source node:tDBInput_5 - inputs:(after_tDBInput_1) outputs:(continent,continent) | target node:tAdvancedHash_continent - inputs:(continent) outputs:()
			   		// linked node: tMap_4 - inputs:(derniere,continent) outputs:(fin)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_continent = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<continentStruct> tHash_Lookup_continent =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<continentStruct>getLookup(matchingModeEnum_continent);
	   						   
		   	   	   globalMap.put("tHash_Lookup_continent", tHash_Lookup_continent);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_continent begin ] stop
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
			    String driverClass_tDBInput_5 = "org.sqlite.JDBC";
			    java.lang.Class.forName(driverClass_tDBInput_5);
				
			String url_tDBInput_5 = "jdbc:sqlite:" + "/" + "/home/duplesse/Musique/TP_BI/BDOrion.sqlite";
			
		        conn_tDBInput_5 = java.sql.DriverManager.getConnection(url_tDBInput_5);
		    
			java.sql.Statement stmt_tDBInput_5 = conn_tDBInput_5.createStatement();

		    String dbquery_tDBInput_5 = "SELECT CONTINENT.continent_id,\n		CONTINENT.continent_name\nFROM	CONTINENT";
		    

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
								continent.continent_id = 0;
							} else {
	                         		
            continent.continent_id = rs_tDBInput_5.getDouble(1);
            if(rs_tDBInput_5.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 2) {
								continent.continent_name = null;
							} else {
	                         		
        	continent.continent_name = routines.system.JDBCUtil.getString(rs_tDBInput_5, 2, false);
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
	 * [tAdvancedHash_continent main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_continent";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"continent"
						
						);
					}
					


			   
			   

					continentStruct continent_HashRow = new continentStruct();
		   	   	   
				
				continent_HashRow.continent_id = continent.continent_id;
				
				continent_HashRow.continent_name = continent.continent_name;
				
			tHash_Lookup_continent.put(continent_HashRow);
			
            




 


	tos_count_tAdvancedHash_continent++;

/**
 * [tAdvancedHash_continent main ] stop
 */
	
	/**
	 * [tAdvancedHash_continent process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_continent";

	

 



/**
 * [tAdvancedHash_continent process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_continent process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_continent";

	

 



/**
 * [tAdvancedHash_continent process_data_end ] stop
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
		if(conn_tDBInput_5 != null && !conn_tDBInput_5.isClosed()) {
			
			conn_tDBInput_5.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
		}
}
globalMap.put("tDBInput_5_NB_LINE",nb_line_tDBInput_5);

 

ok_Hash.put("tDBInput_5", true);
end_Hash.put("tDBInput_5", System.currentTimeMillis());




/**
 * [tDBInput_5 end ] stop
 */

	
	/**
	 * [tAdvancedHash_continent end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_continent";

	

tHash_Lookup_continent.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"continent");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_continent", true);
end_Hash.put("tAdvancedHash_continent", System.currentTimeMillis());




/**
 * [tAdvancedHash_continent end ] stop
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
	 * [tAdvancedHash_continent finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_continent";

	

 



/**
 * [tAdvancedHash_continent finally ] stop
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
        final Copy_of_Geographie Copy_of_GeographieClass = new Copy_of_Geographie();

        int exitCode = Copy_of_GeographieClass.runJobInTOS(args);

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
            java.io.InputStream inContext = Copy_of_Geographie.class.getClassLoader().getResourceAsStream("orion_project_duplesse_nangmo/copy_of_geographie_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = Copy_of_Geographie.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : Copy_of_Geographie");
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
 *     284322 characters generated by Talend Open Studio for Data Integration 
 *     on the 13 février 2025 à 06:00:55 WAT
 ************************************************************************************************/