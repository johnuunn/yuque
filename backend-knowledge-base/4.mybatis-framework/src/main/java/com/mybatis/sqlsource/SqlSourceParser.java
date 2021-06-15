package com.mybatis.sqlsource;

import com.mybatis.utils.GenericTokenParser;
import com.mybatis.utils.ParameterMappingTokenHandler;

/**
 * 将DynamicSqlSource和RawSqlSource解析成StaticSqlSource
 * StaticSqlSource存储的就是只有?的sql语句以及相应的sql信息
 * 
 * @author liu
 *
 */
public class SqlSourceParser {

	public SqlSource parse(String sqlText) {
		ParameterMappingTokenHandler tokenHandler = new ParameterMappingTokenHandler();
		GenericTokenParser tokenParser = new GenericTokenParser("#{", "}", tokenHandler);
		// tokenParser.parse(sqlText)参数是未处理的，返回值是已处理的（没有${}和#{}）
		String sql = tokenParser.parse(sqlText);
		return new StaticSqlSource(sql, tokenHandler.getParameterMappings());
	}

}
