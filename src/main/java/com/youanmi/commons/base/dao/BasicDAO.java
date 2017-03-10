package com.youanmi.commons.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * 数据持久化公共类，提供多功能的CRUD方法,mybatis中的mapper配置中的id是Service层的方法名
 * <p>
 * 支持在任意地方调用,传入Class<?>和mapperId即可，例子请参考{@link #selectOne(Class, String)}
 * 
 * @author longting
 *
 */
public class BasicDAO {

    private static final Logger LOG = LoggerFactory.getLogger(BasicDAO.class);

    @Autowired
    private SqlSession sqlSession;

    public <T> T selectOne() {
        return this.sqlSession.selectOne(getSqlId());
    };

    public <T> T selectOne(Object param) {
        return this.sqlSession.selectOne(getSqlId(), param);
    };

    public <T> T selectOne(Class<?> clazz, String mapperId) {
        return this.sqlSession.selectOne(appendSqlId(clazz, mapperId));
    };

    public <T> T selectOne(Object param, String mapperId) {
        return this.sqlSession.selectOne(getSqlId(mapperId), param);
    };

    public <T> T selectOne(Object param, Class<?> clazz, String mapperId) {
        return this.sqlSession.selectOne(appendSqlId(clazz, mapperId), param);
    };

    public <T> T selectOneByMappingId(String mappingId) {
        return this.sqlSession.selectOne(mappingId);
    };

    public <E> List<E> selectList() {
        return this.sqlSession.selectList(getSqlId());
    };

    public <E> List<E> selectListByMappingId(String mappingId) {
        return this.sqlSession.selectList(mappingId);
    };

    public <E> List<E> selectList(Object param) {
        return this.sqlSession.selectList(getSqlId(), param);
    };

    public <E> List<E> selectList(Class<?> clazz, String mapperId) {
        return this.sqlSession.selectList(appendSqlId(clazz, mapperId));
    };

    public <E> List<E> selectList(Object param, String mapperId) {
        return this.sqlSession.selectList(getSqlId(mapperId), param);
    };

    public <E> List<E> selectList(Object param, Class<?> clazz, String mapperId) {
        return this.sqlSession.selectList(appendSqlId(clazz, mapperId), param);
    };

    public int insert(Object param) {
        return sqlSession.insert(getSqlId(), param);
    }

    public int insert(Class<?> clazz, String mapperId) {
        return sqlSession.insert(appendSqlId(clazz, mapperId));
    }

    public int insert(Object param, String mapperId) {
        return sqlSession.insert(getSqlId(mapperId), param);
    }

    public int insert(Object param, Class<?> clazz, String mapperId) {
        return sqlSession.insert(appendSqlId(clazz, mapperId), param);
    }

    public int update() {
        return sqlSession.update(getSqlId());
    }

    public int update(Class<?> clazz, String mapperId) {
        return sqlSession.update(appendSqlId(clazz, mapperId));
    }

    public int update(Object param) {
        return sqlSession.update(getSqlId(), param);
    }

    public int update(Object param, String mapperId) {
        return sqlSession.update(getSqlId(mapperId), param);
    }

    public int update(Object param, Class<?> clazz, String mapperId) {
        return sqlSession.update(appendSqlId(clazz, mapperId), param);
    }

    public int delete(Object param) {
        return sqlSession.delete(getSqlId(), param);
    }

    public int delete(Object param, String mapperId) {
        return sqlSession.delete(getSqlId(mapperId), param);
    }

    public int delete(Object param, Class<?> clazz, String mapperId) {
        return sqlSession.delete(appendSqlId(clazz, mapperId), param);
    }

    public void insertBatch(List<?> params) {
        for (Object param : params) {
            this.sqlSession.insert(getSqlId(), param);
        }
    }

    public void insertBatch(Class<?> clazz, String mapperId, List<?> params) {
        String sqlId = appendSqlId(clazz, mapperId);
        for (Object param : params) {
            this.sqlSession.insert(sqlId, param);
        }
    }

    private String appendSqlId(Class<?> clazz, String mapperId) {
        String sqlId = new StringBuffer(clazz.getCanonicalName()).append(".").append(mapperId).toString();
        if (LOG.isDebugEnabled()) {
            LOG.info("sql id :" + sqlId);
        }
        return sqlId;
    }

    /**
     * 生成mapper id
     * 
     * 反射的原理，获取调用BaseDao方法的Service className 和 方法名字
     * 
     * 
     * @return
     */
    private String getSqlId() {
        StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
        StackTraceElement stack = stacks[3];
        String sqlID =
                new StringBuffer(stack.getClassName()).append(".").append(stack.getMethodName()).toString();
        if (LOG.isDebugEnabled()) {
            LOG.info("sql id :" + sqlID);
        }
        return sqlID;
    }

    private String getSqlId(String mapperID) {
        StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
        StackTraceElement stack = stacks[3];
        String sqlID = new StringBuffer(stack.getClassName()).append(".").append(mapperID).toString();
        if (LOG.isDebugEnabled()) {
            LOG.info("sql id :" + sqlID);
        }
        LOG.info("sql id :" + sqlID);
        return sqlID;
    }

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

}
