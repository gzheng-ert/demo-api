package com.gz.demoapi;

import com.gz.demoapi.model.Thing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@ComponentScan("com.gz.demoapi")
public class DemoapiApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DemoapiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoapiApplication.class, args);
	}

	@Override
	public void run(String... strings) {

		//initialize in-memory H2 DB
		//initDb();

	}

	/*
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private void initDb() {
		log.info("Initializing database...");
		jdbcTemplate.execute("DROP TABLE IF EXISTS things ");
		jdbcTemplate.execute("CREATE TABLE things(" +
				"id SERIAL, " +
				"name VARCHAR(255))");
		List<Object[]> things = Arrays.asList(
				new Object[]{"thing1"},
				new Object[]{"thing2"},
				new Object[]{"thing3"},
				new Object[]{"thing4"},
				new Object[]{"thing5"}
		);
		jdbcTemplate.batchUpdate("INSERT INTO things(name) VALUES(?)", things);

		log.info("Querying for customer records where name = 'thing2':");
		jdbcTemplate.query(
				"SELECT id, name FROM things WHERE name = ?",
				new Object[] { "thing2" },
				(rs, rowNum) -> new Thing(rs.getLong("id"), rs.getString("name"))
		).forEach(thing -> log.info(thing.toString()));

	}
	*/
}
