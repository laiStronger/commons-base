package com.youanmi.commons.base.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;


/**
 * @FileName BaseDaoImpl.java
 * @Description:
 *
 * @Date Apr 17, 2015
 * @author YangShengJun
 * @version 1.0
 * 
 */
public class BaseDAO {

    private SqlSessionTemplate sqlSessionTemplate;

    public int save(String str, Object obj) {
        return sqlSessionTemplate.insert(str, obj);
    }

    public <T> int batchSave(String str, List<T> objs) {
        return sqlSessionTemplate.insert(str, objs);
    }

    public int update(String str, Object obj) {
        return sqlSessionTemplate.update(str, obj);
    }

    public <T> void batchUpdate(String str, List<T> objs) {
        SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();
        // 批量执行器
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        try {
            if (objs != null) {
                for (int i = 0, size = objs.size(); i < size; i++) {
                    sqlSession.update(str, objs.get(i));
                }
                sqlSession.flushStatements();
                sqlSession.commit();
                sqlSession.clearCache();
            }
        }
        finally {
            sqlSession.close();
        }
    }

    public int delete(String str, Object obj) {

        return sqlSessionTemplate.delete(str, obj);
    }

    public <T> int batchDelete(String str, List<T> objs) {
        return sqlSessionTemplate.delete(str, objs);
    }

    public <T> T findForObject(String str, Object obj) {
        return sqlSessionTemplate.selectOne(str, obj);
    }

    public <E> List<E> findForList(String str, Object obj) {
        return sqlSessionTemplate.selectList(str, obj);
    }

    public <K, V> Map<K, V> findForMap(String str, Object obj, String key, String value) {
        return sqlSessionTemplate.selectMap(str, obj, key);
    }

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

}
