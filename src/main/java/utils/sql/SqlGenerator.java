package utils.sql;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.google.common.base.CaseFormat;

import model.OverseasSettleDO;

/**
 * @Author hezhensheng
 * @Date 2021/3/24
 * @Description
 */
public class SqlGenerator {

    public static void main(String[] args) {
        // System.out.println(genInsert(new OverseasSettleDO(), "overseas_settle_bill"));
        System.out.println(genUpdate("%s", new OverseasSettleDO(), "outRequestNo", "isSend"));
        //System.out.println(genCreate("overseas_settle_bill_testmerchant20180328000", new OverseasSettleDO()));
    }

    public static String genInsert(Object obj, String tableName) {
        StringBuilder str = new StringBuilder();
        str.append("INSERT INTO ").append(tableName).append(" (");
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length - 1; i++) {
            str.append("`").append(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, fields[i].getName())).append("`, ");
        }
        str.append("`").append(fields[fields.length - 1].getName()).append("`) ")
                .append("VALUES ").append("(");
        for (int i = 0; i < fields.length - 1; i++) {
            str.append(":").append(fields[i].getName()).append(", ");
        }
        str.append(":").append(fields[fields.length-1].getName()).append(")");
        return str.toString();
    }

    public static String genUpdate(String tableName, Object obj, String ... cond) {
        StringBuilder str = new StringBuilder();
        str.append("update ").append(tableName).append(" set ");
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        System.out.println(fields.length);
        for(int i = 0; i < fields.length; i++) {
            str.append("`").append(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, fields[i].getName())).append("` = ")
                    .append(":").append(fields[i].getName());
            if (i != fields.length - 1) {
                str.append(", ");
            }
        }
        str.append(" where ");
        for (int i = 0; i < cond.length; i++) {
            str.append("`").append(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, cond[i])).append("` = ")
                    .append(":").append(cond[i]);
            if (i != cond.length - 1) {
                str.append(" and ");
            }
        }
        return str.toString();
    }

    public static Map<String, String> javaProperty2SqlColumnMap = new HashMap<>();

    static {
        javaProperty2SqlColumnMap.put("Integer", "int");
        javaProperty2SqlColumnMap.put("Boolean", "int");
        javaProperty2SqlColumnMap.put("Short", "tinyint(4)");
        javaProperty2SqlColumnMap.put("Long", "bigint(20) unsigned");
        javaProperty2SqlColumnMap.put("BigDecimal", "decimal(19,2)");
        javaProperty2SqlColumnMap.put("Double", "double precision");
        javaProperty2SqlColumnMap.put("Float", "float");
        javaProperty2SqlColumnMap.put("boolean", "bit(1)");
        javaProperty2SqlColumnMap.put("Timestamp", "datetime");
        javaProperty2SqlColumnMap.put("Date", "datetime");
        javaProperty2SqlColumnMap.put("String", "varchar(128)");
    }


    public static String genCreate(String tableName, Object obj) {
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE ").append("`").append(tableName).append("`").append("( ").append("\n");
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            sql.append("`").append(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, fields[i].getName())).append("` ");
            sql.append(javaProperty2SqlColumnMap.get(fields[i].getType().getSimpleName())).append(" NOT NULL COMMENT '',").append("\n");
        }
        sql.append(" )").append("ENGINE = InnoDB "
                + "DEFAULT CHARSET = utf8mb4 COMMENT =''");
        return sql.toString();
    }
}
