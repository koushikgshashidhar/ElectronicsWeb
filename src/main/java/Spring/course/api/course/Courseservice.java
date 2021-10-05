package Spring.course.api.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Courseservice {
	@Autowired
	private Courserepository courserepository;
	
	/*private List <Course> topics= new ArrayList<>(Arrays.asList(new Course("spring","Spring name","Spring decription"),
			new Course("java","Spring name1","Spring decription1"),
			new Course("selenium","Spring name2","Spring decription2")));
	*/
	public List<Course> getAllCourses(String topicId){
		//return topics;
		List <Course> course =new ArrayList();
		courserepository.findByTopicId(topicId).forEach(course::add);
		return course;
	}
	
	public Course getCourse(String courseid)
	{
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return courserepository.findById(courseid).get();
	}

	public void addCourse(Course course) {
	//	topics.add(topic);
		courserepository.save(course);
	}

	public void updateCourse( Course course) {
	/*	for (int i=0;i<topics.size();i++) {
			Topic t=topics.get(i);
			if(t.getId().equals(id))
			{
				topics.set(i, topic);
				return;
			}
		
		
		}*/
	courserepository.save(course);
	}

	public void deleteCourse(String id) {
		//topics.removeIf(t->t.getId().equals(id));
		courserepository.deleteById(id);
		
	}

}
