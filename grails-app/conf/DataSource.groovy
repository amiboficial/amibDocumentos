dataSource {
	pooled = false//pooled = true
	//jmxExport = true
	driverClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"
	username = "auditoria"
	password = "E5c0m100"
}
hibernate {
	cache.use_second_level_cache = true
	cache.use_query_cache = false
//    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
	cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
	singleSession = true // configure OSIV singleSession mode
}

// environment specific settings
environments {
	development {
		dataSource {
			dbCreate = "validate" // one of 'create', 'create-drop', 'update', 'validate', ''
			url = "jdbc:sqlserver://10.100.128.58:1433;databaseName=qa_amib_documentos"
		}
	}
	test {
		dataSource {
			dbCreate = "validate"
		   url = "jdbc:sqlserver://10.100.128.58:1433;databaseName=qa_amib_documentos"
		}
	}
	production {
		dataSource {
			//dbCreate = "validate"
			url = "jdbc:sqlserver://10.100.128.58:1433;databaseName=qa_amib_documentos"
			properties {
			   // See http://grails.org/doc/latest/guide/conf.html#dataSource for documentation
			   jmxEnabled = true
			   initialSize = 5
			   maxActive = 50
			   minIdle = 5
			   maxIdle = 25
			   maxWait = 10000
			   maxAge = 10 * 60000
			   timeBetweenEvictionRunsMillis = 5000
			   minEvictableIdleTimeMillis = 60000
			   validationQuery = "SELECT 1"
			   validationQueryTimeout = 3
			   validationInterval = 15000
			   testOnBorrow = true
			   testWhileIdle = true
			   testOnReturn = false
			   jdbcInterceptors = "ConnectionState"
			   defaultTransactionIsolation = java.sql.Connection.TRANSACTION_READ_COMMITTED
			}
		}
	}
}
