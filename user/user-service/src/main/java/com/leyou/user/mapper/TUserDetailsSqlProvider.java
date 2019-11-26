package com.leyou.user.mapper;

import com.leyou.common.domain.TUserDetails;
import com.leyou.common.domain.TUserDetailsExample.Criteria;
import com.leyou.common.domain.TUserDetailsExample.Criterion;
import com.leyou.common.domain.TUserDetailsExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class TUserDetailsSqlProvider
{

    public String countByExample(TUserDetailsExample example)
    {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_user_details");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(TUserDetailsExample example)
    {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_user_details");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(TUserDetails record)
    {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_user_details");

        if (record.getUid() != null)
        {
            sql.VALUES("uid", "#{uid,jdbcType=INTEGER}");
        }

        if (record.getBirth() != null)
        {
            sql.VALUES("birth", "#{birth,jdbcType=INTEGER}");
        }

        if (record.getPhoneArea() != null)
        {
            sql.VALUES("phone_area", "#{phoneArea,jdbcType=CHAR}");
        }

        if (record.getCountry() != null)
        {
            sql.VALUES("country", "#{country,jdbcType=VARCHAR}");
        }

        if (record.getProvince() != null)
        {
            sql.VALUES("province", "#{province,jdbcType=VARCHAR}");
        }

        if (record.getCity() != null)
        {
            sql.VALUES("city", "#{city,jdbcType=VARCHAR}");
        }

        if (record.getLastLogin() != null)
        {
            sql.VALUES("last_login", "#{lastLogin,jdbcType=INTEGER}");
        }

        if (record.getPublicKey() != null)
        {
            sql.VALUES("public_key", "#{publicKey,jdbcType=CHAR}");
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

    public String selectByExample(TUserDetailsExample example)
    {
        SQL sql = new SQL();
        if (example != null && example.isDistinct())
        {
            sql.SELECT_DISTINCT("id");
        } else
        {
            sql.SELECT("id");
        }
        sql.SELECT("uid");
        sql.SELECT("birth");
        sql.SELECT("phone_area");
        sql.SELECT("country");
        sql.SELECT("province");
        sql.SELECT("city");
        sql.SELECT("last_login");
        sql.SELECT("public_key");
        sql.SELECT("update_time");
        sql.SELECT("create_time");
        sql.FROM("t_user_details");
        applyWhere(sql, example, false);

        if (example != null && example.getOrderByClause() != null)
        {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter)
    {
        TUserDetails record = (TUserDetails) parameter.get("record");
        TUserDetailsExample example = (TUserDetailsExample) parameter.get("example");

        SQL sql = new SQL();
        sql.UPDATE("t_user_details");

        if (record.getId() != null)
        {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }

        if (record.getUid() != null)
        {
            sql.SET("uid = #{record.uid,jdbcType=INTEGER}");
        }

        if (record.getBirth() != null)
        {
            sql.SET("birth = #{record.birth,jdbcType=INTEGER}");
        }

        if (record.getPhoneArea() != null)
        {
            sql.SET("phone_area = #{record.phoneArea,jdbcType=CHAR}");
        }

        if (record.getCountry() != null)
        {
            sql.SET("country = #{record.country,jdbcType=VARCHAR}");
        }

        if (record.getProvince() != null)
        {
            sql.SET("province = #{record.province,jdbcType=VARCHAR}");
        }

        if (record.getCity() != null)
        {
            sql.SET("city = #{record.city,jdbcType=VARCHAR}");
        }

        if (record.getLastLogin() != null)
        {
            sql.SET("last_login = #{record.lastLogin,jdbcType=INTEGER}");
        }

        if (record.getPublicKey() != null)
        {
            sql.SET("public_key = #{record.publicKey,jdbcType=CHAR}");
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
        sql.UPDATE("t_user_details");

        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("uid = #{record.uid,jdbcType=INTEGER}");
        sql.SET("birth = #{record.birth,jdbcType=INTEGER}");
        sql.SET("phone_area = #{record.phoneArea,jdbcType=CHAR}");
        sql.SET("country = #{record.country,jdbcType=VARCHAR}");
        sql.SET("province = #{record.province,jdbcType=VARCHAR}");
        sql.SET("city = #{record.city,jdbcType=VARCHAR}");
        sql.SET("last_login = #{record.lastLogin,jdbcType=INTEGER}");
        sql.SET("public_key = #{record.publicKey,jdbcType=CHAR}");
        sql.SET("update_time = #{record.updateTime,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=INTEGER}");

        TUserDetailsExample example = (TUserDetailsExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(TUserDetails record)
    {
        SQL sql = new SQL();
        sql.UPDATE("t_user_details");

        if (record.getUid() != null)
        {
            sql.SET("uid = #{uid,jdbcType=INTEGER}");
        }

        if (record.getBirth() != null)
        {
            sql.SET("birth = #{birth,jdbcType=INTEGER}");
        }

        if (record.getPhoneArea() != null)
        {
            sql.SET("phone_area = #{phoneArea,jdbcType=CHAR}");
        }

        if (record.getCountry() != null)
        {
            sql.SET("country = #{country,jdbcType=VARCHAR}");
        }

        if (record.getProvince() != null)
        {
            sql.SET("province = #{province,jdbcType=VARCHAR}");
        }

        if (record.getCity() != null)
        {
            sql.SET("city = #{city,jdbcType=VARCHAR}");
        }

        if (record.getLastLogin() != null)
        {
            sql.SET("last_login = #{lastLogin,jdbcType=INTEGER}");
        }

        if (record.getPublicKey() != null)
        {
            sql.SET("public_key = #{publicKey,jdbcType=CHAR}");
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

    protected void applyWhere(SQL sql, TUserDetailsExample example, boolean includeExamplePhrase)
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