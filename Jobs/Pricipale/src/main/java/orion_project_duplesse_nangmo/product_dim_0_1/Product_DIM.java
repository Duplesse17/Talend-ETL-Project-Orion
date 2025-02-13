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


package orion_project_duplesse_nangmo.product_dim_0_1;

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


@SuppressWarnings("unused")

/**
 * Job: Product_DIM Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class Product_DIM implements TalendJob {

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
	private final String jobName = "Product_DIM";
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
				Product_DIM.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(Product_DIM.this, new Object[] { e , currentComponent, globalMap});
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
			
			public void tAdvancedHash_group_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_categorie_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_ligne_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_supplier_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
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
		
	

	
        String properties_tDBConnection_2 = "noDatetimeStringSync=true";
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

        String url_tDBConnection_2 = "jdbc:mysql://" + "127.0.0.1" + ":" + "3306" + "/" + "db_entrepot" + "?" + properties_tDBConnection_2;
	String dbUser_tDBConnection_2 = "orion_DW_user";
	
	
		 
	final String decryptedPassword_tDBConnection_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:0WvtE6QCBzdq3u+ENsjFMuWPkTEUmCcnTucKV/qAozkcfYauKDtxvyo=");
		String dbPwd_tDBConnection_2 = decryptedPassword_tDBConnection_2;
	
	
	java.sql.Connection conn_tDBConnection_2 = null;
	
		
			String driverClass_tDBConnection_2 = "com.mysql.cj.jdbc.Driver";
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
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public long Product_ID;

				public long getProduct_ID () {
					return this.Product_ID;
				}
				
			    public String Product_Line;

				public String getProduct_Line () {
					return this.Product_Line;
				}
				
			    public String Product_Category;

				public String getProduct_Category () {
					return this.Product_Category;
				}
				
			    public String Product_Group;

				public String getProduct_Group () {
					return this.Product_Group;
				}
				
			    public String Product_Name;

				public String getProduct_Name () {
					return this.Product_Name;
				}
				
			    public String Product_Country;

				public String getProduct_Country () {
					return this.Product_Country;
				}
				
			    public String Supplier_Name;

				public String getSupplier_Name () {
					return this.Supplier_Name;
				}
				
			    public Integer Supplier_ID;

				public Integer getSupplier_ID () {
					return this.Supplier_ID;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.Product_ID;
						
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
		
						if (this.Product_ID != other.Product_ID)
							return false;
					

		return true;
    }

	public void copyDataTo(row1Struct other) {

		other.Product_ID = this.Product_ID;
	            other.Product_Line = this.Product_Line;
	            other.Product_Category = this.Product_Category;
	            other.Product_Group = this.Product_Group;
	            other.Product_Name = this.Product_Name;
	            other.Product_Country = this.Product_Country;
	            other.Supplier_Name = this.Supplier_Name;
	            other.Supplier_ID = this.Supplier_ID;
	            
	}

	public void copyKeysDataTo(row1Struct other) {

		other.Product_ID = this.Product_ID;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM, 0, length, utf8Charset);
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
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM, 0, length, utf8Charset);
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

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM) {

        	try {

        		int length = 0;
		
			        this.Product_ID = dis.readLong();
					
					this.Product_Line = readString(dis);
					
					this.Product_Category = readString(dis);
					
					this.Product_Group = readString(dis);
					
					this.Product_Name = readString(dis);
					
					this.Product_Country = readString(dis);
					
					this.Supplier_Name = readString(dis);
					
						this.Supplier_ID = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM) {

        	try {

        		int length = 0;
		
			        this.Product_ID = dis.readLong();
					
					this.Product_Line = readString(dis);
					
					this.Product_Category = readString(dis);
					
					this.Product_Group = readString(dis);
					
					this.Product_Name = readString(dis);
					
					this.Product_Country = readString(dis);
					
					this.Supplier_Name = readString(dis);
					
						this.Supplier_ID = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// long
				
		            	dos.writeLong(this.Product_ID);
					
					// String
				
						writeString(this.Product_Line,dos);
					
					// String
				
						writeString(this.Product_Category,dos);
					
					// String
				
						writeString(this.Product_Group,dos);
					
					// String
				
						writeString(this.Product_Name,dos);
					
					// String
				
						writeString(this.Product_Country,dos);
					
					// String
				
						writeString(this.Supplier_Name,dos);
					
					// Integer
				
						writeInteger(this.Supplier_ID,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// long
				
		            	dos.writeLong(this.Product_ID);
					
					// String
				
						writeString(this.Product_Line,dos);
					
					// String
				
						writeString(this.Product_Category,dos);
					
					// String
				
						writeString(this.Product_Group,dos);
					
					// String
				
						writeString(this.Product_Name,dos);
					
					// String
				
						writeString(this.Product_Country,dos);
					
					// String
				
						writeString(this.Supplier_Name,dos);
					
					// Integer
				
						writeInteger(this.Supplier_ID,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Product_ID="+String.valueOf(Product_ID));
		sb.append(",Product_Line="+Product_Line);
		sb.append(",Product_Category="+Product_Category);
		sb.append(",Product_Group="+Product_Group);
		sb.append(",Product_Name="+Product_Name);
		sb.append(",Product_Country="+Product_Country);
		sb.append(",Supplier_Name="+Supplier_Name);
		sb.append(",Supplier_ID="+String.valueOf(Supplier_ID));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row1Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.Product_ID, other.Product_ID);
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

public static class product_dimStruct implements routines.system.IPersistableRow<product_dimStruct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public long Product_ID;

				public long getProduct_ID () {
					return this.Product_ID;
				}
				
			    public String Product_Line;

				public String getProduct_Line () {
					return this.Product_Line;
				}
				
			    public String Product_Category;

				public String getProduct_Category () {
					return this.Product_Category;
				}
				
			    public String Product_Group;

				public String getProduct_Group () {
					return this.Product_Group;
				}
				
			    public String Product_Name;

				public String getProduct_Name () {
					return this.Product_Name;
				}
				
			    public String Product_Country;

				public String getProduct_Country () {
					return this.Product_Country;
				}
				
			    public String Supplier_Name;

				public String getSupplier_Name () {
					return this.Supplier_Name;
				}
				
			    public Integer Supplier_ID;

				public Integer getSupplier_ID () {
					return this.Supplier_ID;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.Product_ID;
						
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
		final product_dimStruct other = (product_dimStruct) obj;
		
						if (this.Product_ID != other.Product_ID)
							return false;
					

		return true;
    }

	public void copyDataTo(product_dimStruct other) {

		other.Product_ID = this.Product_ID;
	            other.Product_Line = this.Product_Line;
	            other.Product_Category = this.Product_Category;
	            other.Product_Group = this.Product_Group;
	            other.Product_Name = this.Product_Name;
	            other.Product_Country = this.Product_Country;
	            other.Supplier_Name = this.Supplier_Name;
	            other.Supplier_ID = this.Supplier_ID;
	            
	}

	public void copyKeysDataTo(product_dimStruct other) {

		other.Product_ID = this.Product_ID;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM, 0, length, utf8Charset);
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
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM, 0, length, utf8Charset);
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

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM) {

        	try {

        		int length = 0;
		
			        this.Product_ID = dis.readLong();
					
					this.Product_Line = readString(dis);
					
					this.Product_Category = readString(dis);
					
					this.Product_Group = readString(dis);
					
					this.Product_Name = readString(dis);
					
					this.Product_Country = readString(dis);
					
					this.Supplier_Name = readString(dis);
					
						this.Supplier_ID = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM) {

        	try {

        		int length = 0;
		
			        this.Product_ID = dis.readLong();
					
					this.Product_Line = readString(dis);
					
					this.Product_Category = readString(dis);
					
					this.Product_Group = readString(dis);
					
					this.Product_Name = readString(dis);
					
					this.Product_Country = readString(dis);
					
					this.Supplier_Name = readString(dis);
					
						this.Supplier_ID = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// long
				
		            	dos.writeLong(this.Product_ID);
					
					// String
				
						writeString(this.Product_Line,dos);
					
					// String
				
						writeString(this.Product_Category,dos);
					
					// String
				
						writeString(this.Product_Group,dos);
					
					// String
				
						writeString(this.Product_Name,dos);
					
					// String
				
						writeString(this.Product_Country,dos);
					
					// String
				
						writeString(this.Supplier_Name,dos);
					
					// Integer
				
						writeInteger(this.Supplier_ID,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// long
				
		            	dos.writeLong(this.Product_ID);
					
					// String
				
						writeString(this.Product_Line,dos);
					
					// String
				
						writeString(this.Product_Category,dos);
					
					// String
				
						writeString(this.Product_Group,dos);
					
					// String
				
						writeString(this.Product_Name,dos);
					
					// String
				
						writeString(this.Product_Country,dos);
					
					// String
				
						writeString(this.Supplier_Name,dos);
					
					// Integer
				
						writeInteger(this.Supplier_ID,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Product_ID="+String.valueOf(Product_ID));
		sb.append(",Product_Line="+Product_Line);
		sb.append(",Product_Category="+Product_Category);
		sb.append(",Product_Group="+Product_Group);
		sb.append(",Product_Name="+Product_Name);
		sb.append(",Product_Country="+Product_Country);
		sb.append(",Supplier_Name="+Supplier_Name);
		sb.append(",Supplier_ID="+String.valueOf(Supplier_ID));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(product_dimStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.Product_ID, other.Product_ID);
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

public static class dernierStruct implements routines.system.IPersistableRow<dernierStruct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[0];

	
			    public double product_id;

				public double getProduct_id () {
					return this.product_id;
				}
				
			    public String product_name;

				public String getProduct_name () {
					return this.product_name;
				}
				
			    public String product_group;

				public String getProduct_group () {
					return this.product_group;
				}
				
			    public String product_category;

				public String getProduct_category () {
					return this.product_category;
				}
				
			    public String product_line;

				public String getProduct_line () {
					return this.product_line;
				}
				
			    public Double supplier_id;

				public Double getSupplier_id () {
					return this.supplier_id;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM, 0, length, utf8Charset);
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
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM) {

        	try {

        		int length = 0;
		
			        this.product_id = dis.readDouble();
					
					this.product_name = readString(dis);
					
					this.product_group = readString(dis);
					
					this.product_category = readString(dis);
					
					this.product_line = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.supplier_id = null;
           				} else {
           			    	this.supplier_id = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM) {

        	try {

        		int length = 0;
		
			        this.product_id = dis.readDouble();
					
					this.product_name = readString(dis);
					
					this.product_group = readString(dis);
					
					this.product_category = readString(dis);
					
					this.product_line = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.supplier_id = null;
           				} else {
           			    	this.supplier_id = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.product_id);
					
					// String
				
						writeString(this.product_name,dos);
					
					// String
				
						writeString(this.product_group,dos);
					
					// String
				
						writeString(this.product_category,dos);
					
					// String
				
						writeString(this.product_line,dos);
					
					// Double
				
						if(this.supplier_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.supplier_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.product_id);
					
					// String
				
						writeString(this.product_name,dos);
					
					// String
				
						writeString(this.product_group,dos);
					
					// String
				
						writeString(this.product_category,dos);
					
					// String
				
						writeString(this.product_line,dos);
					
					// Double
				
						if(this.supplier_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.supplier_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("product_id="+String.valueOf(product_id));
		sb.append(",product_name="+product_name);
		sb.append(",product_group="+product_group);
		sb.append(",product_category="+product_category);
		sb.append(",product_line="+product_line);
		sb.append(",supplier_id="+String.valueOf(supplier_id));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(dernierStruct other) {

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

public static class deuxieme_jointureStruct implements routines.system.IPersistableRow<deuxieme_jointureStruct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[0];

	
			    public double product_id;

				public double getProduct_id () {
					return this.product_id;
				}
				
			    public String product_name;

				public String getProduct_name () {
					return this.product_name;
				}
				
			    public String product_group;

				public String getProduct_group () {
					return this.product_group;
				}
				
			    public String product_category;

				public String getProduct_category () {
					return this.product_category;
				}
				
			    public Double product_ref_id;

				public Double getProduct_ref_id () {
					return this.product_ref_id;
				}
				
			    public Double supplier_id;

				public Double getSupplier_id () {
					return this.supplier_id;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM, 0, length, utf8Charset);
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
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM) {

        	try {

        		int length = 0;
		
			        this.product_id = dis.readDouble();
					
					this.product_name = readString(dis);
					
					this.product_group = readString(dis);
					
					this.product_category = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.product_ref_id = null;
           				} else {
           			    	this.product_ref_id = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.supplier_id = null;
           				} else {
           			    	this.supplier_id = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM) {

        	try {

        		int length = 0;
		
			        this.product_id = dis.readDouble();
					
					this.product_name = readString(dis);
					
					this.product_group = readString(dis);
					
					this.product_category = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.product_ref_id = null;
           				} else {
           			    	this.product_ref_id = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.supplier_id = null;
           				} else {
           			    	this.supplier_id = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.product_id);
					
					// String
				
						writeString(this.product_name,dos);
					
					// String
				
						writeString(this.product_group,dos);
					
					// String
				
						writeString(this.product_category,dos);
					
					// Double
				
						if(this.product_ref_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.product_ref_id);
		            	}
					
					// Double
				
						if(this.supplier_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.supplier_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.product_id);
					
					// String
				
						writeString(this.product_name,dos);
					
					// String
				
						writeString(this.product_group,dos);
					
					// String
				
						writeString(this.product_category,dos);
					
					// Double
				
						if(this.product_ref_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.product_ref_id);
		            	}
					
					// Double
				
						if(this.supplier_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.supplier_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("product_id="+String.valueOf(product_id));
		sb.append(",product_name="+product_name);
		sb.append(",product_group="+product_group);
		sb.append(",product_category="+product_category);
		sb.append(",product_ref_id="+String.valueOf(product_ref_id));
		sb.append(",supplier_id="+String.valueOf(supplier_id));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(deuxieme_jointureStruct other) {

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

public static class premiere_jointureStruct implements routines.system.IPersistableRow<premiere_jointureStruct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[0];

	
			    public double product_id;

				public double getProduct_id () {
					return this.product_id;
				}
				
			    public String product_name;

				public String getProduct_name () {
					return this.product_name;
				}
				
			    public String product_group;

				public String getProduct_group () {
					return this.product_group;
				}
				
			    public Double product_ref_id;

				public Double getProduct_ref_id () {
					return this.product_ref_id;
				}
				
			    public Double supplier_id;

				public Double getSupplier_id () {
					return this.supplier_id;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM, 0, length, utf8Charset);
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
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM) {

        	try {

        		int length = 0;
		
			        this.product_id = dis.readDouble();
					
					this.product_name = readString(dis);
					
					this.product_group = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.product_ref_id = null;
           				} else {
           			    	this.product_ref_id = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.supplier_id = null;
           				} else {
           			    	this.supplier_id = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM) {

        	try {

        		int length = 0;
		
			        this.product_id = dis.readDouble();
					
					this.product_name = readString(dis);
					
					this.product_group = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.product_ref_id = null;
           				} else {
           			    	this.product_ref_id = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.supplier_id = null;
           				} else {
           			    	this.supplier_id = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.product_id);
					
					// String
				
						writeString(this.product_name,dos);
					
					// String
				
						writeString(this.product_group,dos);
					
					// Double
				
						if(this.product_ref_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.product_ref_id);
		            	}
					
					// Double
				
						if(this.supplier_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.supplier_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.product_id);
					
					// String
				
						writeString(this.product_name,dos);
					
					// String
				
						writeString(this.product_group,dos);
					
					// Double
				
						if(this.product_ref_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.product_ref_id);
		            	}
					
					// Double
				
						if(this.supplier_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.supplier_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("product_id="+String.valueOf(product_id));
		sb.append(",product_name="+product_name);
		sb.append(",product_group="+product_group);
		sb.append(",product_ref_id="+String.valueOf(product_ref_id));
		sb.append(",supplier_id="+String.valueOf(supplier_id));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(premiere_jointureStruct other) {

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

public static class produitStruct implements routines.system.IPersistableRow<produitStruct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[0];

	
			    public double product_id;

				public double getProduct_id () {
					return this.product_id;
				}
				
			    public String product_name;

				public String getProduct_name () {
					return this.product_name;
				}
				
			    public Double supplier_id;

				public Double getSupplier_id () {
					return this.supplier_id;
				}
				
			    public Double product_level;

				public Double getProduct_level () {
					return this.product_level;
				}
				
			    public Double product_ref_id;

				public Double getProduct_ref_id () {
					return this.product_ref_id;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM, 0, length, utf8Charset);
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
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM) {

        	try {

        		int length = 0;
		
			        this.product_id = dis.readDouble();
					
					this.product_name = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.supplier_id = null;
           				} else {
           			    	this.supplier_id = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.product_level = null;
           				} else {
           			    	this.product_level = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.product_ref_id = null;
           				} else {
           			    	this.product_ref_id = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM) {

        	try {

        		int length = 0;
		
			        this.product_id = dis.readDouble();
					
					this.product_name = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.supplier_id = null;
           				} else {
           			    	this.supplier_id = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.product_level = null;
           				} else {
           			    	this.product_level = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.product_ref_id = null;
           				} else {
           			    	this.product_ref_id = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.product_id);
					
					// String
				
						writeString(this.product_name,dos);
					
					// Double
				
						if(this.supplier_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.supplier_id);
		            	}
					
					// Double
				
						if(this.product_level == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.product_level);
		            	}
					
					// Double
				
						if(this.product_ref_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.product_ref_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.product_id);
					
					// String
				
						writeString(this.product_name,dos);
					
					// Double
				
						if(this.supplier_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.supplier_id);
		            	}
					
					// Double
				
						if(this.product_level == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.product_level);
		            	}
					
					// Double
				
						if(this.product_ref_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.product_ref_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("product_id="+String.valueOf(product_id));
		sb.append(",product_name="+product_name);
		sb.append(",supplier_id="+String.valueOf(supplier_id));
		sb.append(",product_level="+String.valueOf(product_level));
		sb.append(",product_ref_id="+String.valueOf(product_ref_id));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(produitStruct other) {

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
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[0];

	
			    public double product_id;

				public double getProduct_id () {
					return this.product_id;
				}
				
			    public String product_name;

				public String getProduct_name () {
					return this.product_name;
				}
				
			    public Double supplier_id;

				public Double getSupplier_id () {
					return this.supplier_id;
				}
				
			    public Double product_level;

				public Double getProduct_level () {
					return this.product_level;
				}
				
			    public Double product_ref_id;

				public Double getProduct_ref_id () {
					return this.product_ref_id;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM, 0, length, utf8Charset);
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
			if(length > commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM.length) {
				if(length < 1024 && commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM.length == 0) {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[1024];
				} else {
   					commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM, 0, length);
			strReturn = new String(commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM) {

        	try {

        		int length = 0;
		
			        this.product_id = dis.readDouble();
					
					this.product_name = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.supplier_id = null;
           				} else {
           			    	this.supplier_id = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.product_level = null;
           				} else {
           			    	this.product_level = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.product_ref_id = null;
           				} else {
           			    	this.product_ref_id = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM) {

        	try {

        		int length = 0;
		
			        this.product_id = dis.readDouble();
					
					this.product_name = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.supplier_id = null;
           				} else {
           			    	this.supplier_id = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.product_level = null;
           				} else {
           			    	this.product_level = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.product_ref_id = null;
           				} else {
           			    	this.product_ref_id = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.product_id);
					
					// String
				
						writeString(this.product_name,dos);
					
					// Double
				
						if(this.supplier_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.supplier_id);
		            	}
					
					// Double
				
						if(this.product_level == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.product_level);
		            	}
					
					// Double
				
						if(this.product_ref_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.product_ref_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.product_id);
					
					// String
				
						writeString(this.product_name,dos);
					
					// Double
				
						if(this.supplier_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.supplier_id);
		            	}
					
					// Double
				
						if(this.product_level == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.product_level);
		            	}
					
					// Double
				
						if(this.product_ref_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.product_ref_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("product_id="+String.valueOf(product_id));
		sb.append(",product_name="+product_name);
		sb.append(",supplier_id="+String.valueOf(supplier_id));
		sb.append(",product_level="+String.valueOf(product_level));
		sb.append(",product_ref_id="+String.valueOf(product_ref_id));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(after_tDBInput_1Struct other) {

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

		produitStruct produit = new produitStruct();
premiere_jointureStruct premiere_jointure = new premiere_jointureStruct();
deuxieme_jointureStruct deuxieme_jointure = new deuxieme_jointureStruct();
dernierStruct dernier = new dernierStruct();
product_dimStruct product_dim = new product_dimStruct();
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

        int[] colLengths = new int[8];

        public void addRow(String[] row) {

            for (int i = 0; i < 8; i++) {
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
                    for (k = 0; k < (totals + 7 - name.length()) / 2; k++) {
                        sb.append(' ');
                    }
                    sb.append(name);
                    for (int i = 0; i < totals + 7 - name.length() - k; i++) {
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
                
                    //last column
                    for (int i = 0; i < colLengths[7] - fillChars[1].length() + 1; i++) {
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
        util_tLogRow_1.addRow(new String[]{"Product_ID","Product_Line","Product_Category","Product_Group","Product_Name","Product_Country","Supplier_Name","Supplier_ID",});        
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
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"product_dim");
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

String tableName_tDBOutput_1 = "Product_Dim";
boolean whetherReject_tDBOutput_1 = false;

java.util.Calendar calendar_tDBOutput_1 = java.util.Calendar.getInstance();
calendar_tDBOutput_1.set(1, 0, 1, 0, 0, 0);
long year1_tDBOutput_1 = calendar_tDBOutput_1.getTime().getTime();
calendar_tDBOutput_1.set(10000, 0, 1, 0, 0, 0);
long year10000_tDBOutput_1 = calendar_tDBOutput_1.getTime().getTime();
long date_tDBOutput_1;

java.sql.Connection conn_tDBOutput_1 = null;
		
        String properties_tDBOutput_1 = "useSSL=false&allowPublicKeyRetrieval=true";
        if (properties_tDBOutput_1 == null || properties_tDBOutput_1.trim().length() == 0) {
            properties_tDBOutput_1 = "rewriteBatchedStatements=true&allowLoadLocalInfile=true";
        }else {
            if (!properties_tDBOutput_1.contains("rewriteBatchedStatements=")) {
                properties_tDBOutput_1 += "&rewriteBatchedStatements=true";
            }

            if (!properties_tDBOutput_1.contains("allowLoadLocalInfile=")) {
                properties_tDBOutput_1 += "&allowLoadLocalInfile=true";
            }
        }

        String url_tDBOutput_1 = "jdbc:mariadb://" + "127.0.0.1" + ":" + "3306" + "/" + "db_entrepot" + "?" + properties_tDBOutput_1;
		
		String driverClass_tDBOutput_1 = "org.mariadb.jdbc.Driver";
		
		String dbUser_tDBOutput_1 = "orion_DW_user";
		

		 
	final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:xMDPkQNfjOXQqIAaLfYKNPaEWQ1OkfUjlCbj9tx+4wAY/4YZISkUWdI=");

		String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;
		java.lang.Class.forName(driverClass_tDBOutput_1);
		
		conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1, dbUser_tDBOutput_1, dbPwd_tDBOutput_1);
		
	
	resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);
        conn_tDBOutput_1.setAutoCommit(false);
        int commitEvery_tDBOutput_1 = 10000;
        int commitCounter_tDBOutput_1 = 0;

int count_tDBOutput_1=0;
    	
            try (java.sql.Statement stmtClear_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
                stmtClear_tDBOutput_1.executeUpdate("DELETE FROM `" + tableName_tDBOutput_1 + "`");
            }

				String insert_tDBOutput_1 = "INSERT INTO `" + "Product_Dim" + "` (`Product_ID`,`Product_Line`,`Product_Category`,`Product_Group`,`Product_Name`,`Product_Country`,`Supplier_Name`,`Supplier_ID`) VALUES (?,?,?,?,?,?,?,?)";
		        int batchSize_tDBOutput_1 = 100;
	   			int batchSizeCounter_tDBOutput_1=0;
		            
		        java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
		        resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);


 



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
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"dernier");
					}
				
		int tos_count_tMap_4 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<supplierStruct> tHash_Lookup_supplier = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<supplierStruct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<supplierStruct>) 
					globalMap.get( "tHash_Lookup_supplier" ))
					;					
					
	

supplierStruct supplierHashKey = new supplierStruct();
supplierStruct supplierDefault = new supplierStruct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_4__Struct  {
}
Var__tMap_4__Struct Var__tMap_4 = new Var__tMap_4__Struct();
// ###############################

// ###############################
// # Outputs initialization
product_dimStruct product_dim_tmp = new product_dimStruct();
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
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"deuxieme_jointure");
					}
				
		int tos_count_tMap_3 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<ligneStruct> tHash_Lookup_ligne = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<ligneStruct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<ligneStruct>) 
					globalMap.get( "tHash_Lookup_ligne" ))
					;					
					
	

ligneStruct ligneHashKey = new ligneStruct();
ligneStruct ligneDefault = new ligneStruct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_3__Struct  {
}
Var__tMap_3__Struct Var__tMap_3 = new Var__tMap_3__Struct();
// ###############################

// ###############################
// # Outputs initialization
dernierStruct dernier_tmp = new dernierStruct();
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
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"premiere_jointure");
					}
				
		int tos_count_tMap_2 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<categorieStruct> tHash_Lookup_categorie = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<categorieStruct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<categorieStruct>) 
					globalMap.get( "tHash_Lookup_categorie" ))
					;					
					
	

categorieStruct categorieHashKey = new categorieStruct();
categorieStruct categorieDefault = new categorieStruct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_2__Struct  {
}
Var__tMap_2__Struct Var__tMap_2 = new Var__tMap_2__Struct();
// ###############################

// ###############################
// # Outputs initialization
deuxieme_jointureStruct deuxieme_jointure_tmp = new deuxieme_jointureStruct();
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
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"produit");
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
premiere_jointureStruct premiere_jointure_tmp = new premiere_jointureStruct();
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

		    String dbquery_tDBInput_1 = "SELECT PRODUCT_LIST.product_id,\n		PRODUCT_LIST.product_name,\n		PRODUCT_LIST.supplier_id,\n		PRODUCT_LIST.product_level,\n"
+"		PRODUCT_LIST.product_ref_id\nFROM	PRODUCT_LIST";
		    

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
								produit.product_id = 0;
							} else {
	                         		
            produit.product_id = rs_tDBInput_1.getDouble(1);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 2) {
								produit.product_name = null;
							} else {
	                         		
        	produit.product_name = routines.system.JDBCUtil.getString(rs_tDBInput_1, 2, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 3) {
								produit.supplier_id = null;
							} else {
	                         		
            produit.supplier_id = rs_tDBInput_1.getDouble(3);
            if(rs_tDBInput_1.wasNull()){
                    produit.supplier_id = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 4) {
								produit.product_level = null;
							} else {
	                         		
            produit.product_level = rs_tDBInput_1.getDouble(4);
            if(rs_tDBInput_1.wasNull()){
                    produit.product_level = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 5) {
								produit.product_ref_id = null;
							} else {
	                         		
            produit.product_ref_id = rs_tDBInput_1.getDouble(5);
            if(rs_tDBInput_1.wasNull()){
                    produit.product_ref_id = null;
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
						
							,"produit"
						
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
								
	                        		    	Object exprKeyValue_group__product_id = produit.product_ref_id ;
	                        		    	if(exprKeyValue_group__product_id == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_1 = true;
	                        		    	} else {
                        		    			groupHashKey.product_id = (double)(Double) exprKeyValue_group__product_id;
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
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'group' and it contains more one result from keys :  group.product_id = '" + groupHashKey.product_id + "'");
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

premiere_jointure = null;

if(!rejectedInnerJoin_tMap_1 ) {

// # Output table : 'premiere_jointure'
premiere_jointure_tmp.product_id = produit.product_id ;
premiere_jointure_tmp.product_name = produit.product_name ;
premiere_jointure_tmp.product_group = group.product_name ;
premiere_jointure_tmp.product_ref_id = group.product_ref_id ;
premiere_jointure_tmp.supplier_id = produit.supplier_id ;
premiere_jointure = premiere_jointure_tmp;
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
// Start of branch "premiere_jointure"
if(premiere_jointure != null) { 



	
	/**
	 * [tMap_2 main ] start
	 */

	

	
	
	currentComponent="tMap_2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"premiere_jointure"
						
						);
					}
					

			


		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_2 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_2 = false;
		  boolean mainRowRejected_tMap_2 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "categorie" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLoopcategorie = false;
       		  	    	
       		  	    	
 							categorieStruct categorieObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_2) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_2 = false;
								
	                        		    	Object exprKeyValue_categorie__product_id = premiere_jointure.product_ref_id ;
	                        		    	if(exprKeyValue_categorie__product_id == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_2 = true;
	                        		    	} else {
                        		    			categorieHashKey.product_id = (double)(Double) exprKeyValue_categorie__product_id;
                        		    		}
                        		    		

								
		                        	categorieHashKey.hashCodeDirty = true;
                        		
	  					
	  							
	
		  							if(!hasCasePrimitiveKeyWithNull_tMap_2) { // G_TM_M_091
		  							
			  					
			  					
			  					
	  					
		  							tHash_Lookup_categorie.lookup( categorieHashKey );

	  							

	  							

			  						} // G_TM_M_091
			  						
			  					

 								
								  
								  if(hasCasePrimitiveKeyWithNull_tMap_2 || !tHash_Lookup_categorie.hasNext()) { // G_TM_M_090

  								
		  				
	  								
			  							rejectedInnerJoin_tMap_2 = true;
	  								
						
									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_categorie != null && tHash_Lookup_categorie.getCount(categorieHashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'categorie' and it contains more one result from keys :  categorie.product_id = '" + categorieHashKey.product_id + "'");
								} // G 071
							

							categorieStruct categorie = null;
                    		  	 
							   
                    		  	 
	       		  	    	categorieStruct fromLookup_categorie = null;
							categorie = categorieDefault;
										 
							
								 
							
							
								if (tHash_Lookup_categorie !=null && tHash_Lookup_categorie.hasNext()) { // G 099
								
							
								
								fromLookup_categorie = tHash_Lookup_categorie.next();

							
							
								} // G 099
							
							

							if(fromLookup_categorie != null) {
								categorie = fromLookup_categorie;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_2__Struct Var = Var__tMap_2;// ###############################
        // ###############################
        // # Output tables

deuxieme_jointure = null;

if(!rejectedInnerJoin_tMap_2 ) {

// # Output table : 'deuxieme_jointure'
deuxieme_jointure_tmp.product_id = premiere_jointure.product_id ;
deuxieme_jointure_tmp.product_name = premiere_jointure.product_name ;
deuxieme_jointure_tmp.product_group = premiere_jointure.product_group ;
deuxieme_jointure_tmp.product_category = categorie.product_name ;
deuxieme_jointure_tmp.product_ref_id = categorie.product_ref_id ;
deuxieme_jointure_tmp.supplier_id = premiere_jointure.supplier_id ;
deuxieme_jointure = deuxieme_jointure_tmp;
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
// Start of branch "deuxieme_jointure"
if(deuxieme_jointure != null) { 



	
	/**
	 * [tMap_3 main ] start
	 */

	

	
	
	currentComponent="tMap_3";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"deuxieme_jointure"
						
						);
					}
					

			


		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_3 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_3 = false;
		  boolean mainRowRejected_tMap_3 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "ligne" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLoopligne = false;
       		  	    	
       		  	    	
 							ligneStruct ligneObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_3) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_3 = false;
								
	                        		    	Object exprKeyValue_ligne__product_id = deuxieme_jointure.product_ref_id ;
	                        		    	if(exprKeyValue_ligne__product_id == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_3 = true;
	                        		    	} else {
                        		    			ligneHashKey.product_id = (double)(Double) exprKeyValue_ligne__product_id;
                        		    		}
                        		    		

								
		                        	ligneHashKey.hashCodeDirty = true;
                        		
	  					
	  							
	
		  							if(!hasCasePrimitiveKeyWithNull_tMap_3) { // G_TM_M_091
		  							
			  					
			  					
			  					
	  					
		  							tHash_Lookup_ligne.lookup( ligneHashKey );

	  							

	  							

			  						} // G_TM_M_091
			  						
			  					

 								
								  
								  if(hasCasePrimitiveKeyWithNull_tMap_3 || !tHash_Lookup_ligne.hasNext()) { // G_TM_M_090

  								
		  				
	  								
			  							rejectedInnerJoin_tMap_3 = true;
	  								
						
									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_ligne != null && tHash_Lookup_ligne.getCount(ligneHashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'ligne' and it contains more one result from keys :  ligne.product_id = '" + ligneHashKey.product_id + "'");
								} // G 071
							

							ligneStruct ligne = null;
                    		  	 
							   
                    		  	 
	       		  	    	ligneStruct fromLookup_ligne = null;
							ligne = ligneDefault;
										 
							
								 
							
							
								if (tHash_Lookup_ligne !=null && tHash_Lookup_ligne.hasNext()) { // G 099
								
							
								
								fromLookup_ligne = tHash_Lookup_ligne.next();

							
							
								} // G 099
							
							

							if(fromLookup_ligne != null) {
								ligne = fromLookup_ligne;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_3__Struct Var = Var__tMap_3;// ###############################
        // ###############################
        // # Output tables

dernier = null;

if(!rejectedInnerJoin_tMap_3 ) {

// # Output table : 'dernier'
dernier_tmp.product_id = deuxieme_jointure.product_id ;
dernier_tmp.product_name = deuxieme_jointure.product_name ;
dernier_tmp.product_group = deuxieme_jointure.product_group ;
dernier_tmp.product_category = deuxieme_jointure.product_category ;
dernier_tmp.product_line = ligne.product_name ;
dernier_tmp.supplier_id = deuxieme_jointure.supplier_id ;
dernier = dernier_tmp;
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
// Start of branch "dernier"
if(dernier != null) { 



	
	/**
	 * [tMap_4 main ] start
	 */

	

	
	
	currentComponent="tMap_4";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"dernier"
						
						);
					}
					

			


		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_4 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_4 = false;
		  boolean mainRowRejected_tMap_4 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "supplier" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLoopsupplier = false;
       		  	    	
       		  	    	
 							supplierStruct supplierObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_4) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_4 = false;
								
	                        		    	Object exprKeyValue_supplier__supplier_id = dernier.supplier_id ;
	                        		    	if(exprKeyValue_supplier__supplier_id == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_4 = true;
	                        		    	} else {
                        		    			supplierHashKey.supplier_id = (double)(Double) exprKeyValue_supplier__supplier_id;
                        		    		}
                        		    		

								
		                        	supplierHashKey.hashCodeDirty = true;
                        		
	  					
	  							
	
		  							if(!hasCasePrimitiveKeyWithNull_tMap_4) { // G_TM_M_091
		  							
			  					
			  					
			  					
	  					
		  							tHash_Lookup_supplier.lookup( supplierHashKey );

	  							

	  							

			  						} // G_TM_M_091
			  						
			  					

 								
								  
								  if(hasCasePrimitiveKeyWithNull_tMap_4 || !tHash_Lookup_supplier.hasNext()) { // G_TM_M_090

  								
		  				
	  								
			  							rejectedInnerJoin_tMap_4 = true;
	  								
						
									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_supplier != null && tHash_Lookup_supplier.getCount(supplierHashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'supplier' and it contains more one result from keys :  supplier.supplier_id = '" + supplierHashKey.supplier_id + "'");
								} // G 071
							

							supplierStruct supplier = null;
                    		  	 
							   
                    		  	 
	       		  	    	supplierStruct fromLookup_supplier = null;
							supplier = supplierDefault;
										 
							
								 
							
							
								if (tHash_Lookup_supplier !=null && tHash_Lookup_supplier.hasNext()) { // G 099
								
							
								
								fromLookup_supplier = tHash_Lookup_supplier.next();

							
							
								} // G 099
							
							

							if(fromLookup_supplier != null) {
								supplier = fromLookup_supplier;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_4__Struct Var = Var__tMap_4;// ###############################
        // ###############################
        // # Output tables

product_dim = null;

if(!rejectedInnerJoin_tMap_4 ) {

// # Output table : 'product_dim'
product_dim_tmp.Product_ID = routines.system.TypeConvert.Double2Long(dernier.product_id );
product_dim_tmp.Product_Line = dernier.product_name ;
product_dim_tmp.Product_Category = dernier.product_group ;
product_dim_tmp.Product_Group = dernier.product_category ;
product_dim_tmp.Product_Name = dernier.product_line ;
product_dim_tmp.Product_Country = supplier.country ;
product_dim_tmp.Supplier_Name = supplier.supplier_name ;
product_dim_tmp.Supplier_ID = routines.system.TypeConvert.Double2Integer(supplier.supplier_id );
product_dim = product_dim_tmp;
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
// Start of branch "product_dim"
if(product_dim != null) { 



	
	/**
	 * [tDBOutput_1 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"product_dim"
						
						);
					}
					



            row1 = null;
        whetherReject_tDBOutput_1 = false;
                            pstmt_tDBOutput_1.setLong(1, product_dim.Product_ID);

                            if(product_dim.Product_Line == null) {
pstmt_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(2, product_dim.Product_Line);
}

                            if(product_dim.Product_Category == null) {
pstmt_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(3, product_dim.Product_Category);
}

                            if(product_dim.Product_Group == null) {
pstmt_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(4, product_dim.Product_Group);
}

                            if(product_dim.Product_Name == null) {
pstmt_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(5, product_dim.Product_Name);
}

                            if(product_dim.Product_Country == null) {
pstmt_tDBOutput_1.setNull(6, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(6, product_dim.Product_Country);
}

                            if(product_dim.Supplier_Name == null) {
pstmt_tDBOutput_1.setNull(7, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(7, product_dim.Supplier_Name);
}

                            if(product_dim.Supplier_ID == null) {
pstmt_tDBOutput_1.setNull(8, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_1.setInt(8, product_dim.Supplier_ID);
}

                    pstmt_tDBOutput_1.addBatch();
                    nb_line_tDBOutput_1++;

						
                      batchSizeCounter_tDBOutput_1++;
            if(!whetherReject_tDBOutput_1) {
                            row1 = new row1Struct();
                                row1.Product_ID = product_dim.Product_ID;
                                row1.Product_Line = product_dim.Product_Line;
                                row1.Product_Category = product_dim.Product_Category;
                                row1.Product_Group = product_dim.Product_Group;
                                row1.Product_Name = product_dim.Product_Name;
                                row1.Product_Country = product_dim.Product_Country;
                                row1.Supplier_Name = product_dim.Supplier_Name;
                                row1.Supplier_ID = product_dim.Supplier_ID;
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
                commitCounter_tDBOutput_1++;

                if(commitEvery_tDBOutput_1 <= commitCounter_tDBOutput_1) {

                try {
                        int countSum_tDBOutput_1 = 0;
                        for(int countEach_tDBOutput_1: pstmt_tDBOutput_1.executeBatch()) {
                            countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : 1);
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
                    if(rowsToCommitCount_tDBOutput_1 != 0){
                    }
                    conn_tDBOutput_1.commit();
                    if(rowsToCommitCount_tDBOutput_1 != 0){
                        rowsToCommitCount_tDBOutput_1 = 0;
                    }
                    commitCounter_tDBOutput_1=0;

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
						

				
				String[] row_tLogRow_1 = new String[8];
              
                 row_tLogRow_1[0]=    						    
				                String.valueOf(row1.Product_ID)			
					          ;	
										
    			   				
	    		if(row1.Product_Line != null) { //              
                 row_tLogRow_1[1]=    						    
				                String.valueOf(row1.Product_Line)			
					          ;	
							
	    		} //			
    			   				
	    		if(row1.Product_Category != null) { //              
                 row_tLogRow_1[2]=    						    
				                String.valueOf(row1.Product_Category)			
					          ;	
							
	    		} //			
    			   				
	    		if(row1.Product_Group != null) { //              
                 row_tLogRow_1[3]=    						    
				                String.valueOf(row1.Product_Group)			
					          ;	
							
	    		} //			
    			   				
	    		if(row1.Product_Name != null) { //              
                 row_tLogRow_1[4]=    						    
				                String.valueOf(row1.Product_Name)			
					          ;	
							
	    		} //			
    			   				
	    		if(row1.Product_Country != null) { //              
                 row_tLogRow_1[5]=    						    
				                String.valueOf(row1.Product_Country)			
					          ;	
							
	    		} //			
    			   				
	    		if(row1.Supplier_Name != null) { //              
                 row_tLogRow_1[6]=    						    
				                String.valueOf(row1.Supplier_Name)			
					          ;	
							
	    		} //			
    			   				
	    		if(row1.Supplier_ID != null) { //              
                 row_tLogRow_1[7]=    						    
				                String.valueOf(row1.Supplier_ID)			
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

} // End of branch "product_dim"




	
	/**
	 * [tMap_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_4";

	

 



/**
 * [tMap_4 process_data_end ] stop
 */

} // End of branch "dernier"




	
	/**
	 * [tMap_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_3";

	

 



/**
 * [tMap_3 process_data_end ] stop
 */

} // End of branch "deuxieme_jointure"




	
	/**
	 * [tMap_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_2";

	

 



/**
 * [tMap_2 process_data_end ] stop
 */

} // End of branch "premiere_jointure"




	
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
			  		runStat.updateStat(resourceMap,iterateId,2,0,"produit");
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
					if(tHash_Lookup_categorie != null) {
						tHash_Lookup_categorie.endGet();
					}
					globalMap.remove( "tHash_Lookup_categorie" );

					
					
				
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"premiere_jointure");
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
					if(tHash_Lookup_ligne != null) {
						tHash_Lookup_ligne.endGet();
					}
					globalMap.remove( "tHash_Lookup_ligne" );

					
					
				
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"deuxieme_jointure");
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
					if(tHash_Lookup_supplier != null) {
						tHash_Lookup_supplier.endGet();
					}
					globalMap.remove( "tHash_Lookup_supplier" );

					
					
				
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"dernier");
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
    	if (commitCounter_tDBOutput_1 > 0 && rowsToCommitCount_tDBOutput_1 != 0) {
    		
    	}
    	conn_tDBOutput_1.commit();
    	if (commitCounter_tDBOutput_1 > 0 && rowsToCommitCount_tDBOutput_1 != 0) {
    		
			rowsToCommitCount_tDBOutput_1 = 0;
    	}
		commitCounter_tDBOutput_1 = 0;
    	
		
    	conn_tDBOutput_1 .close();
    	
    	resourceMap.put("finish_tDBOutput_1", true);
    	

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
			  		runStat.updateStat(resourceMap,iterateId,2,0,"product_dim");
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
					     			globalMap.remove("tHash_Lookup_supplier"); 
				     			
					     			//free memory for "tMap_3"
					     			globalMap.remove("tHash_Lookup_ligne"); 
				     			
					     			//free memory for "tMap_2"
					     			globalMap.remove("tHash_Lookup_categorie"); 
				     			
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
	 * [tDBOutput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	



    try {
    if (resourceMap.get("statementClosed_tDBOutput_1") == null) {
                java.sql.PreparedStatement pstmtToClose_tDBOutput_1 = null;
                if ((pstmtToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_1")) != null) {
                    pstmtToClose_tDBOutput_1.close();
                }
    }
    } finally {
        if(resourceMap.get("finish_tDBOutput_1") == null){
            java.sql.Connection ctn_tDBOutput_1 = null;
            if((ctn_tDBOutput_1 = (java.sql.Connection)resourceMap.get("conn_tDBOutput_1")) != null){
                try {
                    ctn_tDBOutput_1.close();
                } catch (java.sql.SQLException sqlEx_tDBOutput_1) {
                    String errorMessage_tDBOutput_1 = "failed to close the connection in tDBOutput_1 :" + sqlEx_tDBOutput_1.getMessage();
                    System.err.println(errorMessage_tDBOutput_1);
                }
            }
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
System.out.println("L\'execution du job de remplisage de la dimension Product c'est effectuer avec succée." +"\n Fin du Job");
 



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
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public double product_id;

				public double getProduct_id () {
					return this.product_id;
				}
				
			    public String product_name;

				public String getProduct_name () {
					return this.product_name;
				}
				
			    public Double supplier_id;

				public Double getSupplier_id () {
					return this.supplier_id;
				}
				
			    public Double product_level;

				public Double getProduct_level () {
					return this.product_level;
				}
				
			    public Double product_ref_id;

				public Double getProduct_ref_id () {
					return this.product_ref_id;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.product_id;
						
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
		
						if (this.product_id != other.product_id)
							return false;
					

		return true;
    }

	public void copyDataTo(groupStruct other) {

		other.product_id = this.product_id;
	            other.product_name = this.product_name;
	            other.supplier_id = this.supplier_id;
	            other.product_level = this.product_level;
	            other.product_ref_id = this.product_ref_id;
	            
	}

	public void copyKeysDataTo(groupStruct other) {

		other.product_id = this.product_id;
	            	
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

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM) {

        	try {

        		int length = 0;
		
			        this.product_id = dis.readDouble();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM) {

        	try {

        		int length = 0;
		
			        this.product_id = dis.readDouble();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.product_id);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.product_id);
					
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
		
						this.product_name = readString(dis,ois);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.supplier_id = null;
           				} else {
           			    	this.supplier_id = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.product_level = null;
           				} else {
           			    	this.product_level = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.product_ref_id = null;
           				} else {
           			    	this.product_ref_id = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
						this.product_name = readString(dis,objectIn);
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.supplier_id = null;
           				} else {
           			    	this.supplier_id = objectIn.readDouble();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.product_level = null;
           				} else {
           			    	this.product_level = objectIn.readDouble();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.product_ref_id = null;
           				} else {
           			    	this.product_ref_id = objectIn.readDouble();
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

		
						writeString(this.product_name, dos, oos);
					
						if(this.supplier_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.supplier_id);
		            	}
					
						if(this.product_level == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.product_level);
		            	}
					
						if(this.product_ref_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.product_ref_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						writeString(this.product_name, dos, objectOut);
					
						if(this.supplier_id == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.supplier_id);
		            	}
					
						if(this.product_level == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.product_level);
		            	}
					
						if(this.product_ref_id == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.product_ref_id);
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
		sb.append("product_id="+String.valueOf(product_id));
		sb.append(",product_name="+product_name);
		sb.append(",supplier_id="+String.valueOf(supplier_id));
		sb.append(",product_level="+String.valueOf(product_level));
		sb.append(",product_ref_id="+String.valueOf(product_ref_id));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(groupStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.product_id, other.product_id);
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
			   		// linked node: tMap_1 - inputs:(produit,group) outputs:(premiere_jointure)
			   
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
			    String driverClass_tDBInput_2 = "org.sqlite.JDBC";
			    java.lang.Class.forName(driverClass_tDBInput_2);
				
			String url_tDBInput_2 = "jdbc:sqlite:" + "/" + "/home/duplesse/Musique/TP_BI/BDOrion.sqlite";
			
		        conn_tDBInput_2 = java.sql.DriverManager.getConnection(url_tDBInput_2);
		    
			java.sql.Statement stmt_tDBInput_2 = conn_tDBInput_2.createStatement();

		    String dbquery_tDBInput_2 = "SELECT PRODUCT_LIST.product_id,\n		PRODUCT_LIST.product_name,\n		PRODUCT_LIST.supplier_id,\n		PRODUCT_LIST.product_level,\n"
+"		PRODUCT_LIST.product_ref_id\nFROM	PRODUCT_LIST";
		    

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
								group.product_id = 0;
							} else {
	                         		
            group.product_id = rs_tDBInput_2.getDouble(1);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 2) {
								group.product_name = null;
							} else {
	                         		
        	group.product_name = routines.system.JDBCUtil.getString(rs_tDBInput_2, 2, false);
		                    }
							if(colQtyInRs_tDBInput_2 < 3) {
								group.supplier_id = null;
							} else {
	                         		
            group.supplier_id = rs_tDBInput_2.getDouble(3);
            if(rs_tDBInput_2.wasNull()){
                    group.supplier_id = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 4) {
								group.product_level = null;
							} else {
	                         		
            group.product_level = rs_tDBInput_2.getDouble(4);
            if(rs_tDBInput_2.wasNull()){
                    group.product_level = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 5) {
								group.product_ref_id = null;
							} else {
	                         		
            group.product_ref_id = rs_tDBInput_2.getDouble(5);
            if(rs_tDBInput_2.wasNull()){
                    group.product_ref_id = null;
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
		   	   	   
				
				group_HashRow.product_id = group.product_id;
				
				group_HashRow.product_name = group.product_name;
				
				group_HashRow.supplier_id = group.supplier_id;
				
				group_HashRow.product_level = group.product_level;
				
				group_HashRow.product_ref_id = group.product_ref_id;
				
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
		if(conn_tDBInput_2 != null && !conn_tDBInput_2.isClosed()) {
			
			conn_tDBInput_2.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
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
	


public static class categorieStruct implements routines.system.IPersistableComparableLookupRow<categorieStruct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public double product_id;

				public double getProduct_id () {
					return this.product_id;
				}
				
			    public String product_name;

				public String getProduct_name () {
					return this.product_name;
				}
				
			    public Double supplier_id;

				public Double getSupplier_id () {
					return this.supplier_id;
				}
				
			    public Double product_level;

				public Double getProduct_level () {
					return this.product_level;
				}
				
			    public Double product_ref_id;

				public Double getProduct_ref_id () {
					return this.product_ref_id;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.product_id;
						
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
		final categorieStruct other = (categorieStruct) obj;
		
						if (this.product_id != other.product_id)
							return false;
					

		return true;
    }

	public void copyDataTo(categorieStruct other) {

		other.product_id = this.product_id;
	            other.product_name = this.product_name;
	            other.supplier_id = this.supplier_id;
	            other.product_level = this.product_level;
	            other.product_ref_id = this.product_ref_id;
	            
	}

	public void copyKeysDataTo(categorieStruct other) {

		other.product_id = this.product_id;
	            	
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

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM) {

        	try {

        		int length = 0;
		
			        this.product_id = dis.readDouble();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM) {

        	try {

        		int length = 0;
		
			        this.product_id = dis.readDouble();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.product_id);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.product_id);
					
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
		
						this.product_name = readString(dis,ois);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.supplier_id = null;
           				} else {
           			    	this.supplier_id = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.product_level = null;
           				} else {
           			    	this.product_level = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.product_ref_id = null;
           				} else {
           			    	this.product_ref_id = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
						this.product_name = readString(dis,objectIn);
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.supplier_id = null;
           				} else {
           			    	this.supplier_id = objectIn.readDouble();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.product_level = null;
           				} else {
           			    	this.product_level = objectIn.readDouble();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.product_ref_id = null;
           				} else {
           			    	this.product_ref_id = objectIn.readDouble();
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

		
						writeString(this.product_name, dos, oos);
					
						if(this.supplier_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.supplier_id);
		            	}
					
						if(this.product_level == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.product_level);
		            	}
					
						if(this.product_ref_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.product_ref_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						writeString(this.product_name, dos, objectOut);
					
						if(this.supplier_id == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.supplier_id);
		            	}
					
						if(this.product_level == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.product_level);
		            	}
					
						if(this.product_ref_id == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.product_ref_id);
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
		sb.append("product_id="+String.valueOf(product_id));
		sb.append(",product_name="+product_name);
		sb.append(",supplier_id="+String.valueOf(supplier_id));
		sb.append(",product_level="+String.valueOf(product_level));
		sb.append(",product_ref_id="+String.valueOf(product_ref_id));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(categorieStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.product_id, other.product_id);
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



		categorieStruct categorie = new categorieStruct();




	
	/**
	 * [tAdvancedHash_categorie begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_categorie", false);
		start_Hash.put("tAdvancedHash_categorie", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_categorie";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"categorie");
					}
				
		int tos_count_tAdvancedHash_categorie = 0;
		

			   		// connection name:categorie
			   		// source node:tDBInput_3 - inputs:(after_tDBInput_1) outputs:(categorie,categorie) | target node:tAdvancedHash_categorie - inputs:(categorie) outputs:()
			   		// linked node: tMap_2 - inputs:(premiere_jointure,categorie) outputs:(deuxieme_jointure)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_categorie = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<categorieStruct> tHash_Lookup_categorie =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<categorieStruct>getLookup(matchingModeEnum_categorie);
	   						   
		   	   	   globalMap.put("tHash_Lookup_categorie", tHash_Lookup_categorie);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_categorie begin ] stop
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
			    String driverClass_tDBInput_3 = "org.sqlite.JDBC";
			    java.lang.Class.forName(driverClass_tDBInput_3);
				
			String url_tDBInput_3 = "jdbc:sqlite:" + "/" + "/home/duplesse/Musique/TP_BI/BDOrion.sqlite";
			
		        conn_tDBInput_3 = java.sql.DriverManager.getConnection(url_tDBInput_3);
		    
			java.sql.Statement stmt_tDBInput_3 = conn_tDBInput_3.createStatement();

		    String dbquery_tDBInput_3 = "SELECT PRODUCT_LIST.product_id,\n		PRODUCT_LIST.product_name,\n		PRODUCT_LIST.supplier_id,\n		PRODUCT_LIST.product_level,\n"
+"		PRODUCT_LIST.product_ref_id\nFROM	PRODUCT_LIST";
		    

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
								categorie.product_id = 0;
							} else {
	                         		
            categorie.product_id = rs_tDBInput_3.getDouble(1);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 2) {
								categorie.product_name = null;
							} else {
	                         		
        	categorie.product_name = routines.system.JDBCUtil.getString(rs_tDBInput_3, 2, false);
		                    }
							if(colQtyInRs_tDBInput_3 < 3) {
								categorie.supplier_id = null;
							} else {
	                         		
            categorie.supplier_id = rs_tDBInput_3.getDouble(3);
            if(rs_tDBInput_3.wasNull()){
                    categorie.supplier_id = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 4) {
								categorie.product_level = null;
							} else {
	                         		
            categorie.product_level = rs_tDBInput_3.getDouble(4);
            if(rs_tDBInput_3.wasNull()){
                    categorie.product_level = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 5) {
								categorie.product_ref_id = null;
							} else {
	                         		
            categorie.product_ref_id = rs_tDBInput_3.getDouble(5);
            if(rs_tDBInput_3.wasNull()){
                    categorie.product_ref_id = null;
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
	 * [tAdvancedHash_categorie main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_categorie";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"categorie"
						
						);
					}
					


			   
			   

					categorieStruct categorie_HashRow = new categorieStruct();
		   	   	   
				
				categorie_HashRow.product_id = categorie.product_id;
				
				categorie_HashRow.product_name = categorie.product_name;
				
				categorie_HashRow.supplier_id = categorie.supplier_id;
				
				categorie_HashRow.product_level = categorie.product_level;
				
				categorie_HashRow.product_ref_id = categorie.product_ref_id;
				
			tHash_Lookup_categorie.put(categorie_HashRow);
			
            




 


	tos_count_tAdvancedHash_categorie++;

/**
 * [tAdvancedHash_categorie main ] stop
 */
	
	/**
	 * [tAdvancedHash_categorie process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_categorie";

	

 



/**
 * [tAdvancedHash_categorie process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_categorie process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_categorie";

	

 



/**
 * [tAdvancedHash_categorie process_data_end ] stop
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
		if(conn_tDBInput_3 != null && !conn_tDBInput_3.isClosed()) {
			
			conn_tDBInput_3.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
		}
}
globalMap.put("tDBInput_3_NB_LINE",nb_line_tDBInput_3);

 

ok_Hash.put("tDBInput_3", true);
end_Hash.put("tDBInput_3", System.currentTimeMillis());




/**
 * [tDBInput_3 end ] stop
 */

	
	/**
	 * [tAdvancedHash_categorie end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_categorie";

	

tHash_Lookup_categorie.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"categorie");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_categorie", true);
end_Hash.put("tAdvancedHash_categorie", System.currentTimeMillis());




/**
 * [tAdvancedHash_categorie end ] stop
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
	 * [tAdvancedHash_categorie finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_categorie";

	

 



/**
 * [tAdvancedHash_categorie finally ] stop
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
	


public static class ligneStruct implements routines.system.IPersistableComparableLookupRow<ligneStruct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public double product_id;

				public double getProduct_id () {
					return this.product_id;
				}
				
			    public String product_name;

				public String getProduct_name () {
					return this.product_name;
				}
				
			    public Double supplier_id;

				public Double getSupplier_id () {
					return this.supplier_id;
				}
				
			    public Double product_level;

				public Double getProduct_level () {
					return this.product_level;
				}
				
			    public Double product_ref_id;

				public Double getProduct_ref_id () {
					return this.product_ref_id;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.product_id;
						
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
		final ligneStruct other = (ligneStruct) obj;
		
						if (this.product_id != other.product_id)
							return false;
					

		return true;
    }

	public void copyDataTo(ligneStruct other) {

		other.product_id = this.product_id;
	            other.product_name = this.product_name;
	            other.supplier_id = this.supplier_id;
	            other.product_level = this.product_level;
	            other.product_ref_id = this.product_ref_id;
	            
	}

	public void copyKeysDataTo(ligneStruct other) {

		other.product_id = this.product_id;
	            	
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

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM) {

        	try {

        		int length = 0;
		
			        this.product_id = dis.readDouble();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM) {

        	try {

        		int length = 0;
		
			        this.product_id = dis.readDouble();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.product_id);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.product_id);
					
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
		
						this.product_name = readString(dis,ois);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.supplier_id = null;
           				} else {
           			    	this.supplier_id = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.product_level = null;
           				} else {
           			    	this.product_level = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.product_ref_id = null;
           				} else {
           			    	this.product_ref_id = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
						this.product_name = readString(dis,objectIn);
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.supplier_id = null;
           				} else {
           			    	this.supplier_id = objectIn.readDouble();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.product_level = null;
           				} else {
           			    	this.product_level = objectIn.readDouble();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.product_ref_id = null;
           				} else {
           			    	this.product_ref_id = objectIn.readDouble();
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

		
						writeString(this.product_name, dos, oos);
					
						if(this.supplier_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.supplier_id);
		            	}
					
						if(this.product_level == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.product_level);
		            	}
					
						if(this.product_ref_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.product_ref_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						writeString(this.product_name, dos, objectOut);
					
						if(this.supplier_id == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.supplier_id);
		            	}
					
						if(this.product_level == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.product_level);
		            	}
					
						if(this.product_ref_id == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.product_ref_id);
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
		sb.append("product_id="+String.valueOf(product_id));
		sb.append(",product_name="+product_name);
		sb.append(",supplier_id="+String.valueOf(supplier_id));
		sb.append(",product_level="+String.valueOf(product_level));
		sb.append(",product_ref_id="+String.valueOf(product_ref_id));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(ligneStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.product_id, other.product_id);
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



		ligneStruct ligne = new ligneStruct();




	
	/**
	 * [tAdvancedHash_ligne begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_ligne", false);
		start_Hash.put("tAdvancedHash_ligne", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_ligne";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"ligne");
					}
				
		int tos_count_tAdvancedHash_ligne = 0;
		

			   		// connection name:ligne
			   		// source node:tDBInput_4 - inputs:(after_tDBInput_1) outputs:(ligne,ligne) | target node:tAdvancedHash_ligne - inputs:(ligne) outputs:()
			   		// linked node: tMap_3 - inputs:(deuxieme_jointure,ligne) outputs:(dernier)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_ligne = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<ligneStruct> tHash_Lookup_ligne =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<ligneStruct>getLookup(matchingModeEnum_ligne);
	   						   
		   	   	   globalMap.put("tHash_Lookup_ligne", tHash_Lookup_ligne);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_ligne begin ] stop
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

		    String dbquery_tDBInput_4 = "SELECT PRODUCT_LIST.product_id,\n		PRODUCT_LIST.product_name,\n		PRODUCT_LIST.supplier_id,\n		PRODUCT_LIST.product_level,\n"
+"		PRODUCT_LIST.product_ref_id\nFROM	PRODUCT_LIST";
		    

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
								ligne.product_id = 0;
							} else {
	                         		
            ligne.product_id = rs_tDBInput_4.getDouble(1);
            if(rs_tDBInput_4.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 2) {
								ligne.product_name = null;
							} else {
	                         		
        	ligne.product_name = routines.system.JDBCUtil.getString(rs_tDBInput_4, 2, false);
		                    }
							if(colQtyInRs_tDBInput_4 < 3) {
								ligne.supplier_id = null;
							} else {
	                         		
            ligne.supplier_id = rs_tDBInput_4.getDouble(3);
            if(rs_tDBInput_4.wasNull()){
                    ligne.supplier_id = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 4) {
								ligne.product_level = null;
							} else {
	                         		
            ligne.product_level = rs_tDBInput_4.getDouble(4);
            if(rs_tDBInput_4.wasNull()){
                    ligne.product_level = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 5) {
								ligne.product_ref_id = null;
							} else {
	                         		
            ligne.product_ref_id = rs_tDBInput_4.getDouble(5);
            if(rs_tDBInput_4.wasNull()){
                    ligne.product_ref_id = null;
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
	 * [tAdvancedHash_ligne main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_ligne";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"ligne"
						
						);
					}
					


			   
			   

					ligneStruct ligne_HashRow = new ligneStruct();
		   	   	   
				
				ligne_HashRow.product_id = ligne.product_id;
				
				ligne_HashRow.product_name = ligne.product_name;
				
				ligne_HashRow.supplier_id = ligne.supplier_id;
				
				ligne_HashRow.product_level = ligne.product_level;
				
				ligne_HashRow.product_ref_id = ligne.product_ref_id;
				
			tHash_Lookup_ligne.put(ligne_HashRow);
			
            




 


	tos_count_tAdvancedHash_ligne++;

/**
 * [tAdvancedHash_ligne main ] stop
 */
	
	/**
	 * [tAdvancedHash_ligne process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_ligne";

	

 



/**
 * [tAdvancedHash_ligne process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_ligne process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_ligne";

	

 



/**
 * [tAdvancedHash_ligne process_data_end ] stop
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
	 * [tAdvancedHash_ligne end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_ligne";

	

tHash_Lookup_ligne.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"ligne");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_ligne", true);
end_Hash.put("tAdvancedHash_ligne", System.currentTimeMillis());




/**
 * [tAdvancedHash_ligne end ] stop
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
	 * [tAdvancedHash_ligne finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_ligne";

	

 



/**
 * [tAdvancedHash_ligne finally ] stop
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
	


public static class supplierStruct implements routines.system.IPersistableComparableLookupRow<supplierStruct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public double supplier_id;

				public double getSupplier_id () {
					return this.supplier_id;
				}
				
			    public String supplier_name;

				public String getSupplier_name () {
					return this.supplier_name;
				}
				
			    public double street_id;

				public double getStreet_id () {
					return this.street_id;
				}
				
			    public String supplier_address;

				public String getSupplier_address () {
					return this.supplier_address;
				}
				
			    public String sup_street_number;

				public String getSup_street_number () {
					return this.sup_street_number;
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
	
							result = prime * result + (int) this.supplier_id;
						
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
		final supplierStruct other = (supplierStruct) obj;
		
						if (this.supplier_id != other.supplier_id)
							return false;
					

		return true;
    }

	public void copyDataTo(supplierStruct other) {

		other.supplier_id = this.supplier_id;
	            other.supplier_name = this.supplier_name;
	            other.street_id = this.street_id;
	            other.supplier_address = this.supplier_address;
	            other.sup_street_number = this.sup_street_number;
	            other.country = this.country;
	            
	}

	public void copyKeysDataTo(supplierStruct other) {

		other.supplier_id = this.supplier_id;
	            	
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

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM) {

        	try {

        		int length = 0;
		
			        this.supplier_id = dis.readDouble();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Product_DIM) {

        	try {

        		int length = 0;
		
			        this.supplier_id = dis.readDouble();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.supplier_id);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.supplier_id);
					
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
		
						this.supplier_name = readString(dis,ois);
					
			            this.street_id = dis.readDouble();
					
						this.supplier_address = readString(dis,ois);
					
						this.sup_street_number = readString(dis,ois);
					
						this.country = readString(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
						this.supplier_name = readString(dis,objectIn);
					
			            this.street_id = objectIn.readDouble();
					
						this.supplier_address = readString(dis,objectIn);
					
						this.sup_street_number = readString(dis,objectIn);
					
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

		
						writeString(this.supplier_name, dos, oos);
					
		            	dos.writeDouble(this.street_id);
					
						writeString(this.supplier_address, dos, oos);
					
						writeString(this.sup_street_number, dos, oos);
					
						writeString(this.country, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						writeString(this.supplier_name, dos, objectOut);
					
					objectOut.writeDouble(this.street_id);
					
						writeString(this.supplier_address, dos, objectOut);
					
						writeString(this.sup_street_number, dos, objectOut);
					
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
		sb.append("supplier_id="+String.valueOf(supplier_id));
		sb.append(",supplier_name="+supplier_name);
		sb.append(",street_id="+String.valueOf(street_id));
		sb.append(",supplier_address="+supplier_address);
		sb.append(",sup_street_number="+sup_street_number);
		sb.append(",country="+country);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(supplierStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.supplier_id, other.supplier_id);
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



		supplierStruct supplier = new supplierStruct();




	
	/**
	 * [tAdvancedHash_supplier begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_supplier", false);
		start_Hash.put("tAdvancedHash_supplier", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_supplier";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"supplier");
					}
				
		int tos_count_tAdvancedHash_supplier = 0;
		

			   		// connection name:supplier
			   		// source node:tDBInput_5 - inputs:(after_tDBInput_1) outputs:(supplier,supplier) | target node:tAdvancedHash_supplier - inputs:(supplier) outputs:()
			   		// linked node: tMap_4 - inputs:(dernier,supplier) outputs:(product_dim)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_supplier = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<supplierStruct> tHash_Lookup_supplier =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<supplierStruct>getLookup(matchingModeEnum_supplier);
	   						   
		   	   	   globalMap.put("tHash_Lookup_supplier", tHash_Lookup_supplier);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_supplier begin ] stop
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

		    String dbquery_tDBInput_5 = "SELECT SUPPLIER.supplier_id,\n		SUPPLIER.supplier_name,\n		SUPPLIER.street_id,\n		SUPPLIER.supplier_address,\n		SUPPLIER.su"
+"p_street_number,\n		SUPPLIER.country\nFROM	SUPPLIER";
		    

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
								supplier.supplier_id = 0;
							} else {
	                         		
            supplier.supplier_id = rs_tDBInput_5.getDouble(1);
            if(rs_tDBInput_5.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 2) {
								supplier.supplier_name = null;
							} else {
	                         		
        	supplier.supplier_name = routines.system.JDBCUtil.getString(rs_tDBInput_5, 2, false);
		                    }
							if(colQtyInRs_tDBInput_5 < 3) {
								supplier.street_id = 0;
							} else {
	                         		
            supplier.street_id = rs_tDBInput_5.getDouble(3);
            if(rs_tDBInput_5.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 4) {
								supplier.supplier_address = null;
							} else {
	                         		
        	supplier.supplier_address = routines.system.JDBCUtil.getString(rs_tDBInput_5, 4, false);
		                    }
							if(colQtyInRs_tDBInput_5 < 5) {
								supplier.sup_street_number = null;
							} else {
	                         		
        	supplier.sup_street_number = routines.system.JDBCUtil.getString(rs_tDBInput_5, 5, false);
		                    }
							if(colQtyInRs_tDBInput_5 < 6) {
								supplier.country = null;
							} else {
	                         		
        	supplier.country = routines.system.JDBCUtil.getString(rs_tDBInput_5, 6, false);
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
	 * [tAdvancedHash_supplier main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_supplier";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"supplier"
						
						);
					}
					


			   
			   

					supplierStruct supplier_HashRow = new supplierStruct();
		   	   	   
				
				supplier_HashRow.supplier_id = supplier.supplier_id;
				
				supplier_HashRow.supplier_name = supplier.supplier_name;
				
				supplier_HashRow.street_id = supplier.street_id;
				
				supplier_HashRow.supplier_address = supplier.supplier_address;
				
				supplier_HashRow.sup_street_number = supplier.sup_street_number;
				
				supplier_HashRow.country = supplier.country;
				
			tHash_Lookup_supplier.put(supplier_HashRow);
			
            




 


	tos_count_tAdvancedHash_supplier++;

/**
 * [tAdvancedHash_supplier main ] stop
 */
	
	/**
	 * [tAdvancedHash_supplier process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_supplier";

	

 



/**
 * [tAdvancedHash_supplier process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_supplier process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_supplier";

	

 



/**
 * [tAdvancedHash_supplier process_data_end ] stop
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
	 * [tAdvancedHash_supplier end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_supplier";

	

tHash_Lookup_supplier.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"supplier");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_supplier", true);
end_Hash.put("tAdvancedHash_supplier", System.currentTimeMillis());




/**
 * [tAdvancedHash_supplier end ] stop
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
	 * [tAdvancedHash_supplier finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_supplier";

	

 



/**
 * [tAdvancedHash_supplier finally ] stop
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
        final Product_DIM Product_DIMClass = new Product_DIM();

        int exitCode = Product_DIMClass.runJobInTOS(args);

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
            java.io.InputStream inContext = Product_DIM.class.getClassLoader().getResourceAsStream("orion_project_duplesse_nangmo/product_dim_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = Product_DIM.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : Product_DIM");
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
 *     259043 characters generated by Talend Open Studio for Data Integration 
 *     on the 13 février 2025 à 06:01:19 WAT
 ************************************************************************************************/