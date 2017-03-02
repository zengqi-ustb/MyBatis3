package com.zeng;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * Created by zeng on 17-3-1.
 */
public class GoodsDaoSelectProvider {
    static String platform;
    static String fundType;
    static Integer pageSize;
    static Integer pageNum;
    public static String findGoods(Map<String, Object> params) {
             platform = (String)params.get("platform");
             fundType = (String)params.get("fundType");
             pageSize = (Integer)params.get("pageSize");
             pageNum = (Integer) params.get("pageNum");
            //实现1
//            StringBuffer buffer = new StringBuffer();
//            buffer.append("SELECT * FROM goods WHERE 1=1 ");
//            if (!("all".equals(platform))) {
//                buffer.append("AND platform=#{platform} ");
//            }
//            if (!("all".equals(fundType))) {
//                buffer.append("AND fund_type=#{fundType} ");
//            }
//
//            buffer.append("LIMIT #{pageNum},#{pageSize}");
//
//            return buffer.toString();
            //实现2
            return new SQL(){{
                SELECT("*");
                FROM("goods");
                if (!("all".equals(platform))) {
                WHERE("platform=#{platform}");
            }
            if (!("all".equals(fundType))) {
                WHERE("fund_type=#{fundType}");
            }
            }
            }.toString()+" LIMIT #{pageNum},#{pageSize}";
        }
}
