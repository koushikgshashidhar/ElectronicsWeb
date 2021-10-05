package Spring.course.api.lesson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Lessonservice {
	@Autowired
	private Lessonrepository lessonrepository;
	
	/*private List <Course> topics= new ArrayList<>(Arrays.asList(new Course("spring","Spring name","Spring decription"),
			new Course("java","Spring name1","Spring decription1"),
			new Course("selenium","Spring name2","Spring decription2")));
	*/
	public List<Lesson> getAllLessons(String courseId){
		//return topics;
		List <Lesson> lesson =new ArrayList();
		lessonrepository.findByCourseId(courseId).forEach(lesson::add);
		return lesson;
	}
	
	public Lesson getLesson(String lessonid)
	{
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return lessonrepository.findById(lessonid).get();
	}

	public void addLesson(Lesson lesson) {
	//	topics.add(topic);
		lessonrepository.save(lesson);
	}

	public void updateLesson( Lesson lesson) {
	/*	for (int i=0;i<topics.size();i++) {
			Topic t=topics.get(i);
			if(t.getId().equals(id))
			{
				topics.set(i, topic);
				return;
			}
		
		
		}*/
	lessonrepository.save(lesson);
	}

	public void deleteLesson(String id) {
		//topics.removeIf(t->t.getId().equals(id));
		lessonrepository.deleteById(id);
		
	}

}
