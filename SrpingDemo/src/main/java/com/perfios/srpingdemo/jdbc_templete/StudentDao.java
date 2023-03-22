package com.perfios.srpingdemo.jdbc_templete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDao {

    JdbcTemplate jdbcTemplate;

    NamedParameterJdbcTemplate template;

    public void setTemplate(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Autowired
    Student student;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertStudentData(Student student){
        String sql = "insert into student_details values("+student.getId()+",'"+student.getName()+"','"+student.getUsn()+"','"+student.getLocation()+"'"+")";
        return jdbcTemplate.update(sql);
    }

    public int updateStudentData(Student student){
        String sql = "update student_details set name='"+student.getName()+"',usn='"+student.getUsn()+"',location='"+student.getLocation()+"' where id="+student.getId();
        return jdbcTemplate.update(sql);
    }

    public int deleteStudentData(Student student){
        String sql = "delete from student_details where id="+student.getId();
        return jdbcTemplate.update(sql);
    }

    public Boolean insetStudentDataUsingPreparedStatement(Student student){
        String sql = "insert into student_details values(?,?,?,?)";
        return  jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setInt(1,student.getId());
                ps.setString(2,student.getName());
                ps.setString(3,student.getUsn());
                ps.setString(4,student.getLocation());
                return ps.execute();
            }
        });
    }

    public Object insertStudentDataUsingNamedParameter(){
        String sql = "insert into student_details values(:id,:name,:usn,:location)";

        Map<String,Object> map = new HashMap<>();
        map.put("id",5);
        map.put("name","Dhanush");
        map.put("usn","1MS18EI016");
        map.put("location","Bangalore");

        System.out.println("map: "+map);
        return template.update(sql,map);
    }



    public List<Student> getAllStudentUsingResultSet(){
        String sql = "select * from student_details;";
        return jdbcTemplate.query(sql, new ResultSetExtractor<List<Student>>() {
            @Override
            public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Student> students = new ArrayList<>();
                while (rs.next()){
                    Student student1 = new Student();
                    student1.setId(rs.getInt(1));
                    student1.setName(rs.getString(2));
                    student1.setUsn(rs.getString(3));
                    student1.setLocation(rs.getString(4));
                    students.add(student1);
                }
                return students;
            }
        });
    }

    public List<Student> getAllStudentUsingRowMap(){
        String sql = "select * from student_details;";
        return jdbcTemplate.query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student student1 = new Student();
                student1.setId(rs.getInt(1));
                student1.setName(rs.getString(2));
                student1.setUsn(rs.getString(3));
                student1.setLocation(rs.getString(4));
                return student1;
            }
        });
    }
}
