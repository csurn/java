package demo;

import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.query.criteria.internal.expression.function.FunctionExpression;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.ResultTransformer;

import javax.persistence.criteria.Expression;
import java.io.Serializable;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class CriteriaExt<T> implements Criteria {

    Criteria criteria;
    public  CriteriaExt(Criteria criteria)
    {
        this.criteria = criteria;
    }

    @Override
    public String getAlias() {
        return this.criteria.getAlias();
    }

    @Override
    public Criteria setProjection(Projection projection) {
        return this.criteria.setProjection(projection);
    }

    @Override
    public Criteria add(Criterion criterion) {
        return this.criteria.add(criterion);
    }

    @Override
    public Criteria addOrder(Order order) {
        return this.criteria.addOrder(order);
    }

    @Override
    public Criteria setFetchMode(String associationPath, FetchMode mode) throws HibernateException {
        return this.criteria.setFetchMode(associationPath,mode);
    }

    @Override
    public Criteria setLockMode(LockMode lockMode) {
        return this.criteria.setLockMode(lockMode);
    }

    @Override
    public Criteria setLockMode(String alias, LockMode lockMode) {
        return this.criteria.setLockMode(alias,lockMode);
    }

    @Override
    public Criteria createAlias(String associationPath, String alias) throws HibernateException {
        return this.criteria.createAlias(associationPath,alias);
    }

    @Override
    public Criteria createAlias(String associationPath, String alias, JoinType joinType) throws HibernateException {
        return this.criteria.createAlias(associationPath,alias,joinType);
    }

    @Override
    public Criteria createAlias(String associationPath, String alias, int joinType) throws HibernateException {
        return this.criteria.createAlias(associationPath,alias,joinType);
    }

    @Override
    public Criteria createAlias(String associationPath, String alias, JoinType joinType, Criterion withClause) throws HibernateException {
        return this.criteria.createAlias(associationPath,alias,joinType,withClause);
    }

    @Override
    public Criteria createAlias(String associationPath, String alias, int joinType, Criterion withClause) throws HibernateException {
        return this.criteria.createAlias(associationPath,alias,joinType,withClause);
    }

    @Override
    public Criteria createCriteria(String associationPath) throws HibernateException {
        return this.criteria.createCriteria(associationPath);
    }

    @Override
    public Criteria createCriteria(String associationPath, JoinType joinType) throws HibernateException {
        return this.criteria.createCriteria(associationPath,joinType);
    }

    @Override
    public Criteria createCriteria(String associationPath, int joinType) throws HibernateException {
        return null;
    }

    @Override
    public Criteria createCriteria(String associationPath, String alias) throws HibernateException {
        return null;
    }

    @Override
    public Criteria createCriteria(String associationPath, String alias, JoinType joinType) throws HibernateException {
        return this.criteria.createCriteria(associationPath,alias,joinType);
    }

    @Override
    public Criteria createCriteria(String associationPath, String alias, int joinType) throws HibernateException {
        return this.criteria.createCriteria(associationPath,alias,joinType);
    }

    @Override
    public Criteria createCriteria(String associationPath, String alias, JoinType joinType, Criterion withClause) throws HibernateException {
        return this.criteria.createCriteria(associationPath,alias,joinType,withClause);
    }

    @Override
    public Criteria createCriteria(String associationPath, String alias, int joinType, Criterion withClause) throws HibernateException {
        return this.criteria.createCriteria(associationPath,alias,joinType,withClause);
    }

    @Override
    public Criteria setResultTransformer(ResultTransformer resultTransformer) {
        return this.criteria.setResultTransformer(resultTransformer);
    }

    @Override
    public Criteria setMaxResults(int maxResults) {
        return this.criteria.setMaxResults(maxResults);
    }

    @Override
    public Criteria setFirstResult(int firstResult) {
        return null;
    }

    @Override
    public boolean isReadOnlyInitialized() {
        return this.criteria.isReadOnlyInitialized();
    }

    @Override
    public boolean isReadOnly() {
        return this.criteria.isReadOnly();
    }

    @Override
    public Criteria setReadOnly(boolean readOnly) {
        return this.criteria.setReadOnly(readOnly);
    }

    @Override
    public Criteria setFetchSize(int fetchSize) {
        return this.criteria.setFetchSize(fetchSize);
    }

    @Override
    public Criteria setTimeout(int timeout) {
        return this.criteria.setTimeout(timeout);
    }

    @Override
    public Criteria setCacheable(boolean cacheable) {
        return this.criteria.setCacheable(cacheable);
    }

    @Override
    public Criteria setCacheRegion(String cacheRegion) {
        return this.criteria.setCacheRegion(cacheRegion);
    }

    @Override
    public Criteria setComment(String comment) {
        return this.criteria.setComment(comment);
    }

    @Override
    public Criteria addQueryHint(String hint) {
        return this.criteria.addQueryHint(hint);
    }

    @Override
    public Criteria setFlushMode(FlushMode flushMode) {
        return this.criteria.setFlushMode(flushMode);
    }

    @Override
    public Criteria setCacheMode(CacheMode cacheMode) {
        return this.criteria.setCacheMode(cacheMode);
    }

    @Override
    public List list() throws HibernateException {
        return this.criteria.list();
    }

    @Override
    public ScrollableResults scroll() throws HibernateException {
        return this.criteria.scroll();
    }

    @Override
    public ScrollableResults scroll(ScrollMode scrollMode) throws HibernateException {
        return this.criteria.scroll(scrollMode);
    }

    @Override
    public Object uniqueResult() throws HibernateException {
        return this.criteria.uniqueResult();
    }

    public Criteria add(Function fun,String value) {
        System.out.println(fun);
        return this;
    }
}
