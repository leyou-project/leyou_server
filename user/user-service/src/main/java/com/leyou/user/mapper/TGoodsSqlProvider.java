package com.leyou.user.mapper;

import com.leyou.common.domain.TGoods;
import com.leyou.common.domain.TGoodsExample.Criteria;
import com.leyou.common.domain.TGoodsExample.Criterion;
import com.leyou.common.domain.TGoodsExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class TGoodsSqlProvider
{

    public String countByExample(TGoodsExample example)
    {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_goods");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(TGoodsExample example)
    {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_goods");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(TGoods record)
    {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_goods");

        if (record.getGoodsName() != null)
        {
            sql.VALUES("goods_name", "#{goodsName,jdbcType=VARCHAR}");
        }

        if (record.getCoverUrl() != null)
        {
            sql.VALUES("cover_url", "#{coverUrl,jdbcType=VARCHAR}");
        }

        if (record.getGoodsType() != null)
        {
            sql.VALUES("goods_type", "#{goodsType,jdbcType=BIGINT}");
        }

        if (record.getStatus() != null)
        {
            sql.VALUES("status", "#{status,jdbcType=BIT}");
        }

        if (record.getUpdateTime() != null)
        {
            sql.VALUES("update_time", "#{updateTime,jdbcType=INTEGER}");
        }

        if (record.getCreateTime() != null)
        {
            sql.VALUES("create_time", "#{createTime,jdbcType=INTEGER}");
        }

        return sql.toString();
    }

    public String selectByExample(TGoodsExample example)
    {
        SQL sql = new SQL();
        if (example != null && example.isDistinct())
        {
            sql.SELECT_DISTINCT("id");
        } else
        {
            sql.SELECT("id");
        }
        sql.SELECT("goods_name");
        sql.SELECT("cover_url");
        sql.SELECT("goods_type");
        sql.SELECT("status");
        sql.SELECT("update_time");
        sql.SELECT("create_time");
        sql.FROM("t_goods");
        applyWhere(sql, example, false);

        if (example != null && example.getOrderByClause() != null)
        {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter)
    {
        TGoods record = (TGoods) parameter.get("record");
        TGoodsExample example = (TGoodsExample) parameter.get("example");

        SQL sql = new SQL();
        sql.UPDATE("t_goods");

        if (record.getId() != null)
        {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }

        if (record.getGoodsName() != null)
        {
            sql.SET("goods_name = #{record.goodsName,jdbcType=VARCHAR}");
        }

        if (record.getCoverUrl() != null)
        {
            sql.SET("cover_url = #{record.coverUrl,jdbcType=VARCHAR}");
        }

        if (record.getGoodsType() != null)
        {
            sql.SET("goods_type = #{record.goodsType,jdbcType=BIGINT}");
        }

        if (record.getStatus() != null)
        {
            sql.SET("status = #{record.status,jdbcType=BIT}");
        }

        if (record.getUpdateTime() != null)
        {
            sql.SET("update_time = #{record.updateTime,jdbcType=INTEGER}");
        }

        if (record.getCreateTime() != null)
        {
            sql.SET("create_time = #{record.createTime,jdbcType=INTEGER}");
        }

        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter)
    {
        SQL sql = new SQL();
        sql.UPDATE("t_goods");

        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("goods_name = #{record.goodsName,jdbcType=VARCHAR}");
        sql.SET("cover_url = #{record.coverUrl,jdbcType=VARCHAR}");
        sql.SET("goods_type = #{record.goodsType,jdbcType=BIGINT}");
        sql.SET("status = #{record.status,jdbcType=BIT}");
        sql.SET("update_time = #{record.updateTime,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=INTEGER}");

        TGoodsExample example = (TGoodsExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(TGoods record)
    {
        SQL sql = new SQL();
        sql.UPDATE("t_goods");

        if (record.getGoodsName() != null)
        {
            sql.SET("goods_name = #{goodsName,jdbcType=VARCHAR}");
        }

        if (record.getCoverUrl() != null)
        {
            sql.SET("cover_url = #{coverUrl,jdbcType=VARCHAR}");
        }

        if (record.getGoodsType() != null)
        {
            sql.SET("goods_type = #{goodsType,jdbcType=BIGINT}");
        }

        if (record.getStatus() != null)
        {
            sql.SET("status = #{status,jdbcType=BIT}");
        }

        if (record.getUpdateTime() != null)
        {
            sql.SET("update_time = #{updateTime,jdbcType=INTEGER}");
        }

        if (record.getCreateTime() != null)
        {
            sql.SET("create_time = #{createTime,jdbcType=INTEGER}");
        }

        sql.WHERE("id = #{id,jdbcType=BIGINT}");

        return sql.toString();
    }

    protected void applyWhere(SQL sql, TGoodsExample example, boolean includeExamplePhrase)
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