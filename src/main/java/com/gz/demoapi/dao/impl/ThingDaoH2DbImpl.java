package com.gz.demoapi.dao.impl;

import com.gz.demoapi.dao.ThingDao;
import com.gz.demoapi.model.Thing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ThingDaoH2DbImpl implements ThingDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Thing findThing(long id) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT id, name FROM things WHERE id = ?",
                    new Object[]{id},
                    (rs, rowNum) -> new Thing(rs.getLong("id"), rs.getString("name"))
            );
        }
        catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Thing> findAllThings() {
        return jdbcTemplate.query(
                "SELECT id, name FROM things",
                (rs, rowNum) -> new Thing(rs.getLong("id"), rs.getString("name"))
        );
    }

    @Override
    public Thing createNewThing(Thing newThing) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("things").usingGeneratedKeyColumns("id");
        final Map<String, Object> params = new HashMap<>();
        params.put("name", newThing.getName());
        final Number id = simpleJdbcInsert.executeAndReturnKey(params);
        return new Thing(id.longValue(), newThing.getName());
    }
}
