package com.leyou.user.mapper;

import com.leyou.domain.TMessage;

import java.util.List;
import java.util.Map;

import com.leyou.domain.TMessageExample;
import org.apache.ibatis.jdbc.SQL;

public class TMessageSqlProvider
{

    public String countByExample(TMessageExample example)
    {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_message");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(TMessageExample example)
    {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_message");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(TMessage record)
    {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_message");

        if (record.getToId() != null)
        {
            sql.VALUES("to_id", "#{toId,jdbcType=BIGINT}");
        }

        if (record.getFormId() != null)
        {
            sql.VALUES("form_id", "#{formId,jdbcType=INTEGER}");
        }

        if (record.getType() != null)
        {
            sql.VALUES("type", "#{type,jdbcType=BIT}");
        }

        if (record.getTitle() != null)
        {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }

        if (record.getStatus() != null)
        {
            sql.VALUES("status", "#{status,jdbcType=BIT}");
        }

        if (record.getUpdateTime() != null)
        {
            sql.VALUES("update_time", "#{updateTime,jdbcType=BIGINT}");
        }

        if (record.getCreateTime() != null)
        {
            sql.VALUES("create_time", "#{createTime,jdbcType=BIGINT}");
        }

        if (record.getContent() != null)
        {
            sql.VALUES("content", "#{content,jdbcType=LONGVARBINARY}");
        }

        return sql.toString();
    }

    public String selectByExampleWithBLOBs(TMessageExample example)
    {
        SQL sql = new SQL();
        if (example != null && example.isDistinct())
        {
            sql.SELECT_DISTINCT("id");
        } else
        {
            sql.SELECT("id");
        }
        sql.SELECT("to_id");
        sql.SELECT("form_id");
        sql.SELECT("type");
        sql.SELECT("title");
        sql.SELECT("status");
        sql.SELECT("update_time");
        sql.SELECT("create_time");
        sql.SELECT("content");
        sql.FROM("t_message");
        applyWhere(sql, example, false);

        if (example != null && example.getOrderByClause() != null)
        {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }

    public String selectByExample(TMessageExample example)
    {
        SQL sql = new SQL();
        if (example != null && example.isDistinct())
        {
            sql.SELECT_DISTINCT("id");
        } else
        {
            sql.SELECT("id");
        }
        sql.SELECT("to_id");
        sql.SELECT("form_id");
        sql.SELECT("type");
        sql.SELECT("title");
        sql.SELECT("status");
        sql.SELECT("update_time");
        sql.SELECT("create_time");
        sql.FROM("t_message");
        applyWhere(sql, example, false);

        if (example != null && example.getOrderByClause() != null)
        {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter)
    {
        TMessage record = (TMessage) parameter.get("record");
        TMessageExample example = (TMessageExample) parameter.get("example");

        SQL sql = new SQL();
        sql.UPDATE("t_message");

        if (record.getId() != null)
        {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }

        if (record.getToId() != null)
        {
            sql.SET("to_id = #{record.toId,jdbcType=BIGINT}");
        }

        if (record.getFormId() != null)
        {
            sql.SET("form_id = #{record.formId,jdbcType=INTEGER}");
        }

        if (record.getType() != null)
        {
            sql.SET("type = #{record.type,jdbcType=BIT}");
        }

        if (record.getTitle() != null)
        {
            sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        }

        if (record.getStatus() != null)
        {
            sql.SET("status = #{record.status,jdbcType=BIT}");
        }

        if (record.getUpdateTime() != null)
        {
            sql.SET("update_time = #{record.updateTime,jdbcType=BIGINT}");
        }

        if (record.getCreateTime() != null)
        {
            sql.SET("create_time = #{record.createTime,jdbcType=BIGINT}");
        }

        if (record.getContent() != null)
        {
            sql.SET("content = #{record.content,jdbcType=LONGVARBINARY}");
        }

        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter)
    {
        SQL sql = new SQL();
        sql.UPDATE("t_message");

        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("to_id = #{record.toId,jdbcType=BIGINT}");
        sql.SET("form_id = #{record.formId,jdbcType=INTEGER}");
        sql.SET("type = #{record.type,jdbcType=BIT}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("status = #{record.status,jdbcType=BIT}");
        sql.SET("update_time = #{record.updateTime,jdbcType=BIGINT}");
        sql.SET("create_time = #{record.createTime,jdbcType=BIGINT}");
        sql.SET("content = #{record.content,jdbcType=LONGVARBINARY}");

        TMessageExample example = (TMessageExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter)
    {
        SQL sql = new SQL();
        sql.UPDATE("t_message");

        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("to_id = #{record.toId,jdbcType=BIGINT}");
        sql.SET("form_id = #{record.formId,jdbcType=INTEGER}");
        sql.SET("type = #{record.type,jdbcType=BIT}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("status = #{record.status,jdbcType=BIT}");
        sql.SET("update_time = #{record.updateTime,jdbcType=BIGINT}");
        sql.SET("create_time = #{record.createTime,jdbcType=BIGINT}");

        TMessageExample example = (TMessageExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(TMessage record)
    {
        SQL sql = new SQL();
        sql.UPDATE("t_message");

        if (record.getToId() != null)
        {
            sql.SET("to_id = #{toId,jdbcType=BIGINT}");
        }

        if (record.getFormId() != null)
        {
            sql.SET("form_id = #{formId,jdbcType=INTEGER}");
        }

        if (record.getType() != null)
        {
            sql.SET("type = #{type,jdbcType=BIT}");
        }

        if (record.getTitle() != null)
        {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }

        if (record.getStatus() != null)
        {
            sql.SET("status = #{status,jdbcType=BIT}");
        }

        if (record.getUpdateTime() != null)
        {
            sql.SET("update_time = #{updateTime,jdbcType=BIGINT}");
        }

        if (record.getCreateTime() != null)
        {
            sql.SET("create_time = #{createTime,jdbcType=BIGINT}");
        }

        if (record.getContent() != null)
        {
            sql.SET("content = #{content,jdbcType=LONGVARBINARY}");
        }

        sql.WHERE("id = #{id,jdbcType=BIGINT}");

        return sql.toString();
    }

    protected void applyWhere(SQL sql, TMessageExample example, boolean includeExamplePhrase)
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
        List<TMessageExample.Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++)
        {
            TMessageExample.Criteria criteria = oredCriteria.get(i);
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
                List<TMessageExample.Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++)
                {
                    TMessageExample.Criterion criterion = criterions.get(j);
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