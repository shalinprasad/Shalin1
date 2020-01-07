package com.keane.dbfw;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface ParamMapper {

	public void mapParam(PreparedStatement pStmt) throws SQLException;
}
