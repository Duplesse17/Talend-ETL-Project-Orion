%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository="%cd%/../lib" -Xms256M -Xmx1024M -cp .;../lib/routines.jar;../lib/log4j-slf4j-impl-2.13.2.jar;../lib/log4j-api-2.13.2.jar;../lib/log4j-core-2.13.2.jar;../lib/log4j-1.2-api-2.13.2.jar;../lib/commons-collections-3.2.2.jar;../lib/jboss-marshalling-river-2.0.12.Final.jar;../lib/mariadb-java-client-2.5.3.jar;../lib/jboss-marshalling-2.0.12.Final.jar;../lib/mysql-connector-java-8.0.18.jar;../lib/advancedPersistentLookupLib-1.3.jar;../lib/dom4j-2.1.3.jar;../lib/sqlitejdbc-v056.jar;../lib/slf4j-api-1.7.29.jar;../lib/trove.jar;../lib/crypto-utils-0.31.12.jar;product_dim_0_1.jar; orion_project_duplesse_nangmo.product_dim_0_1.Product_DIM --context=Default %*
