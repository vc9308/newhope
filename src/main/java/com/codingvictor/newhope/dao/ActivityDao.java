package com.codingvictor.newhope.dao;

import java.util.List;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.codingvictor.newhope.entity.Activity;

@Repository
public interface ActivityDao {

	//@Select("select count(*) from Activity")
	int getRowCount();

	//@Insert("insert into Activity (author, publishedDate, modifiedDate, heading, content) values (#{author}, #{publishedDate}, #{modifiedDate}, #{heading}, #{content});")
	void insertActivity(Activity activity);
	
	//@Select("select count(*) from Activity where content='${content}'")
	int getRowCountOfThisContent(Map<String, String> params);
	
	//@Select("select count(*) from Activity where heading='${heading}'")
	int getRowCountOfThisHeading(Map<String, String> params);

	//@Select("select * from Activity order by PublishedDate desc limit ${offset}, ${size}")
	List<Activity> selectByParams(Map<String, Object> params);

	//@Select("selectActivityById")
	Activity selectActivityById(Map<String, Integer> params);

	//@Delete("delete from Activity where id = ${id}")
	void deleteAnActivity(Map<String, Integer> params);
}