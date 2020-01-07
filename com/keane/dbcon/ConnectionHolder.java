package com.keane.dbcon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class ConnectionHolder {

	private static ConnectionHolder connectionHolderInstance = null;

	private DataSource ds = null;

	private ConnectionHolder() {
	}

//	private void initAppDatasource() throws DBConnectionException {
//
//		try {
//
//			BasicDataSource bds = new BasicDataSource();
//
//			Properties ps = new Properties();
//			ps.load(new FileInputStream("C:\\091322\\Induction\\FrontControllerApp\\src\\jdbcds.properties"));
//			String uid = ps.getProperty("uid");
//			String pwd = ps.getProperty("pwd");
//			String URL = ps.getProperty("url");
//			String driverclazz = ps.getProperty("driver");
//
//			bds.setUrl(URL);
//			bds.setDriverClassName(driverclazz);
//			bds.setUsername(uid);
//			bds.setPassword(pwd);
//
//			this.ds = bds;
//
//		} catch (FileNotFoundException e) {
//
//			throw new DBConnectionException(
//					"Unable to get connection Data to the database", e);
//
//		} catch (IOException e) {
//
//			throw new DBConnectionException(
//					"Unable to get connection Data to the database", e);
//		}
//	}

	// Used during web application instead of the above method
	private void initAppserverDataSource() throws DBConnectionException {
		Context initContext;

		try {
			initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/MyDB");
			//System.out.println(ds.toString());
		} catch (NamingException e) {
			e.printStackTrace();
			throw new DBConnectionException("Unable to get datasource", e);

		}
	}


	public static ConnectionHolder getInstance() throws DBConnectionException {

		//	happens only once
		synchronized (ConnectionHolder.class) {

			// use reflection to synchronize as we have no object
			if (connectionHolderInstance == null) {

				connectionHolderInstance = new ConnectionHolder();

				// Replace this line for Web Application
				connectionHolderInstance.initAppserverDataSource();
			}
		}
		return connectionHolderInstance;
	}

	public Connection getConnection() throws DBConnectionException {

		try {
			
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBConnectionException("Unable to obtain a connection", e);
		}
	}

	public void dispose() throws DBConnectionException {

		BasicDataSource bds = (BasicDataSource) ds;
		try {

			bds.close();
		} catch (SQLException e) {

			throw new DBConnectionException("Unable to close the connection", e);
		}
	}
}
