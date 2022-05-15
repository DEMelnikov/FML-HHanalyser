package ru.demelnikov.fml.hhanalyser;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HandsMapper implements RowMapper<Hand> {

    @Override
    public Hand mapRow(ResultSet resultSet, int i) throws SQLException {
        String handID = resultSet.getString("roomid");
        Integer bbsize = resultSet.getInt("bbsize");
        Double stack = resultSet.getDouble("heroStack");

        return new Hand(handID,bbsize,stack);
    }
}
