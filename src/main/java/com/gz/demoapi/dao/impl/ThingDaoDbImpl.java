package com.gz.demoapi.dao.impl;

import com.gz.demoapi.dao.ThingDao;
import com.gz.demoapi.model.Thing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ThingDaoDbImpl implements ThingDao {

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
}
