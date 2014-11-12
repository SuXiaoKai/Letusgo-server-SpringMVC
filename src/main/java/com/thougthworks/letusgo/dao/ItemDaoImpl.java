package com.thougthworks.letusgo.dao;

import com.thougthworks.letusgo.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ItemDaoImpl {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Item> getItems(){

        List<Item> itemlist;
        String sql = "select * from item";

        itemlist = jdbcTemplate.query(sql,new RowMapper<Item>() {
            @Override
            public Item mapRow(ResultSet resultSet, int i) throws SQLException {
                
                return new Item(resultSet.getInt("id"),resultSet.getString("barcode"),
                        resultSet.getString("name"),resultSet.getString("unit"),
                        resultSet.getDouble("price"),null);
            }
        });
        return itemlist;
    }
}
