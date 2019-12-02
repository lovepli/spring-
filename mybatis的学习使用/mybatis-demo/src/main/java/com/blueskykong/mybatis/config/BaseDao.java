package com.blueskykong.mybatis.config;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 特别注意，该接口不能被扫描到，否则会出错
 * @param <T>
 */
public interface BaseDao<T> extends Mapper<T>, MySqlMapper<T> {

}

