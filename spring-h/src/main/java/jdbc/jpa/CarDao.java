package jdbc.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CarDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public void insert() {
		String sql = "INSERT INTO car(name,carid) VALUES ('123', '456')"; 
//		jdbcTemplate.update(sql,"ÕÅÈý","ÄÐ",22);
		jdbcTemplate.update(sql);
		
	}
}
