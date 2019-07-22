package com.javaarchaius.example.live_config;

import com.javaarchaius.example.dao.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class LiveConfigServiceImpl implements LiveConfigService {

    @Override
    public void setConfig(String key, Object val) {
        String insert_sql = "insert into config (name,value,isActive) values (?,?,?)";
        try(Connection conn = JDBCUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(insert_sql);
            statement.setString(1,key);
            statement.setString(2,(String) val);
            statement.setString(3,"1");
            boolean result = statement.execute();

        }catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<String, Object> getConfig(String key) {
        Map<String, Object> map = new HashMap<>();
        String select_sql = "select name,value,isActive from config where name = ?";
        try(Connection conn = JDBCUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(select_sql);
            statement.setString(1,key);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                map.put("name",rs.getString("name"));
                map.put("value",rs.getString("value"));
                map.put("isActive",rs.getString("isActive"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public Map<String, Object> getAllConfigs() {
        Map<String, Object> map = new HashMap<>();
        String select_sql = "select name,value,isActive from config";
        try(Connection conn = JDBCUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(select_sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                map.put("name",rs.getString("name"));
                map.put("value",rs.getString("value"));
                map.put("isActive",rs.getString("isActive"));
            }

        }catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return map;
    }
}
