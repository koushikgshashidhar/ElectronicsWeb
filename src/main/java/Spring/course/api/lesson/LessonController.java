package Spring.course.api.lesson;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Spring.course.api.course.Course;
import Spring.course.api.topic.Topic;

@RestController
public class LessonController {

	@Autowired
	private Lessonservice lessonservice;
	
	@RequestMapping("/electronics/{topicid}/brands/{id}/series")
	public List<Lesson> getAllLessons(@PathVariable String id)
	{
		return  lessonservice.getAllLessons(id);
	}
	
	@RequestMapping("/electronics/{id}/brands/{courseid}/series/{lessonid}")
	public Lesson getLesson(@PathVariable String lessonid)
	{
		return lessonservice.getLesson(lessonid);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/electronics/{topicid}/brands/{id}/series")
	public void addLesson(@RequestBody Lesson lesson,@PathVariable String id) {
		lesson.setCourse(new Course(id,"","",""));
		lessonservice.addLesson(lesson);
		
	}
	@RequestMapping(method = RequestMethod.PUT, value="/electronics/{topicid}/brands/{id}/series/{lessonid}")
	public void updateLesson(@RequestBody Lesson lesson,@PathVariable String id,@PathVariable String lessonid) {
		lesson.setCourse(new Course(id,"","",""));
		lessonservice.updateLesson(lesson);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/electronics/{topicid}/brands/{id}/series/{lessonid}")
	public void deleteLesson(@PathVariable String lessonid)
	{
		lessonservice.deleteLesson(lessonid);
	}
	
}
