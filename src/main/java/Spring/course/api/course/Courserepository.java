package Spring.course.api.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface Courserepository extends CrudRepository<Course,String>{

	//public List<Course> findByName(String name);
	//public List<Course> findByDescription(String description);
	public List<Course> findByTopicId(String topicID);
}
