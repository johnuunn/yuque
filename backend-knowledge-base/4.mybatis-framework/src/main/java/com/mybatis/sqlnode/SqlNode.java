package com.mybatis.sqlnode;

import com.mybatis.sqlsource.DynamicContext;

/**
 * 提供对sql脚本的解析
 * 
 * @author liu
 *
 */
public interface SqlNode {

	void apply(DynamicContext context);
}
