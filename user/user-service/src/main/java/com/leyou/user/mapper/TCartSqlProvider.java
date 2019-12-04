package com.leyou.user.mapper;

import com.leyou.common.domain.TCart;
import com.leyou.common.domain.TCartExample.Criteria;
import com.leyou.common.domain.TCartExample.Criterion;
import com.leyou.common.domain.TCartExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class TCartSqlProvider
{

    public String countByExample(TCartExample example)
    {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_cart");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(TCartExample example)
    {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_cart");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(TCart record)
    {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_cart");

        if (record.getUserId() != null)
        {
            sql.VALUES("user_id", "#{userId,jdbcType=BIGINT}");
        }

        if (record.getGoodsStyleId() != null)
        {
            sql.VALUES("goods_style_id", "#{goodsStyleId,jdbcType=BIGINT}");
        }

        if (record.getNum() != null)
        {
            sql.VALUES("num", "#{num,jdbcType=INTEGER}");
        }

        if (record.getSum() != null)
        {
            sql.VALUES("sum", "#{sum,jdbcType=INTEGER}");
        }

        if (record.getUpdateTime() != null)
        {
            sql.VALUES("update_time", "#{updateTime,jdbcType=BIGINT}");
        }

        if (record.getCreateTime() != null)
        {
            sql.VALUES("create_time", "#{createTime,jdbcType=BIGINT}");
        }

        return sql.toString();
    }

    public String selectByExample(TCartExample example)
    {
        SQL sql = new SQL();
        if (example != null && example.isDistinct())
        {
            sql.SELECT_DISTINCT("id");
        } else
        {
            sql.SELECT("id");
        }
        sql.SELECT("user_id");
        sql.SELECT("goods_style_id");
        sql.SELECT("num");
        sql.SELECT("sum");
        sql.SELECT("update_time");
        sql.SELECT("create_time");
        sql.FROM("t_cart");
        applyWhere(sql, example, false);

        if (example != null && example.getOrderByClause() != null)
        {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter)
    {
        TCart record = (TCart) parameter.get("record");
        TCartExample example = (TCartExample) parameter.get("example");

        SQL sql = new SQL();
        sql.UPDATE("t_cart");

        if (record.getId() != null)
        {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }

        if (record.getUserId() != null)
        {
            sql.SET("user_id = #{record.userId,jdbcType=BIGINT}");
        }

        if (record.getGoodsStyleId() != null)
        {
            sql.SET("goods_style_id = #{record.goodsStyleId,jdbcType=BIGINT}");
        }

        if (record.getNum() != null)
        {
            sql.SET("num = #{record.num,jdbcType=INTEGER}");
        }

        if (record.getSum() != null)
        {
            sql.SET("sum = #{record.sum,jdbcType=INTEGER}");
        }

        if (record.getUpdateTime() != null)
        {
            sql.SET("update_time = #{record.updateTime,jdbcType=BIGINT}");
        }

        if (record.getCreateTime() != null)
        {
            sql.SET("create_time = #{record.createTime,jdbcType=BIGINT}");
        }

        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter)
    {
        SQL sql = new SQL();
        sql.UPDATE("t_cart");

        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("user_id = #{record.userId,jdbcType=BIGINT}");
        sql.SET("goods_style_id = #{record.goodsStyleId,jdbcType=BIGINT}");
        sql.SET("num = #{record.num,jdbcType=INTEGER}");
        sql.SET("sum = #{record.sum,jdbcType=INTEGER}");
        sql.SET("update_time = #{record.updateTime,jdbcType=BIGINT}");
        sql.SET("create_time = #{record.createTime,jdbcType=BIGINT}");

        TCartExample example = (TCartExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(TCart record)
    {
        SQL sql = new SQL();
        sql.UPDATE("t_cart");

        if (record.getUserId() != null)
        {
            sql.SET("user_id = #{userId,jdbcType=BIGINT}");
        }

        if (record.getGoodsStyleId() != null)
        {
            sql.SET("goods_style_id = #{goodsStyleId,jdbcType=BIGINT}");
        }

        if (record.getNum() != null)
        {
            sql.SET("num = #{num,jdbcType=INTEGER}");
        }

        if (record.getSum() != null)
        {
            sql.SET("sum = #{sum,jdbcType=INTEGER}");
        }

        if (record.getUpdateTime() != null)
        {
            sql.SET("update_time = #{updateTime,jdbcType=BIGINT}");
        }

        if (record.getCreateTime() != null)
        {
            sql.SET("create_time = #{createTime,jdbcType=BIGINT}");
        }

        sql.WHERE("id = #{id,jdbcType=BIGINT}");

        return sql.toString();
    }

    protected void applyWhere(SQL sql, TCartExample example, boolean includeExamplePhrase)
    {
        if (example == null)
        {
            return;
        }

        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase)
        {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else
        {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }

        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++)
        {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid())
            {
                if (firstCriteria)
                {
                    firstCriteria = false;
                } else
                {
                    sb.append(" or ");
                }

                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++)
                {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion)
                    {
                        firstCriterion = false;
                    } else
                    {
                        sb.append(" and ");
                    }

                    if (criterion.isNoValue())
                    {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue())
                    {
                        if (criterion.getTypeHandler() == null)
                        {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else
                        {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue())
                    {
                        if (criterion.getTypeHandler() == null)
                        {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else
                        {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue())
                    {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++)
                        {
                            if (comma)
                            {
                                sb.append(", ");
                            } else
                            {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null)
                            {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else
                            {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }

        if (sb.length() > 0)
        {
            sql.WHERE(sb.toString());
        }
    }
}