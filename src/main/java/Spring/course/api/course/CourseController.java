package Spring.course.api.course;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Spring.course.api.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	private Courseservice courseservice;
	
	@RequestMapping("/electronics/{id}/brands")
	public List<Course> getAllCourses(@PathVariable String id)
	{
		return  courseservice.getAllCourses(id);
	}
	
	@RequestMapping("/electronics/{id}/brands/{courseid}")
	public Course getCourse(@PathVariable String courseid)
	{
		return courseservice.getCourse(courseid);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/electronics/{topicid}/brands")
	public void addCourse(@RequestBody Course course,@PathVariable String topicid) {
		course.setTopic(new Topic(topicid,"",""));
		courseservice.addCourse(course);
		
	}
	@RequestMapping(method = RequestMethod.PUT, value="/electronics/{topicid}/brands/{id}")
	public void updateCourse(@RequestBody Course course,@PathVariable String topicid,@PathVariable String id) {
		course.setTopic(new Topic(topicid,"",""));
		courseservice.updateCourse(course);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/electronics/{topicid}/brands/{id}")
	public void deleteCourse(@PathVariable String id)
	{
		courseservice.deleteCourse(id);
	}
	
}
