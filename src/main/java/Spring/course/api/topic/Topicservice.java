package Spring.course.api.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Topicservice {
	@Autowired
	private Topicrepository topicrepository;
	
	private List <Topic> topics= new ArrayList<>(Arrays.asList(new Topic("spring","Spring name","Spring decription"),
			new Topic("java","Spring name1","Spring decription1"),
			new Topic("selenium","Spring name2","Spring decription2")));
	
	public List<Topic> getAllTopics(){
		//return topics;
		List <Topic> topics =new ArrayList();
		topicrepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id)
	{
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicrepository.findById(id).get();
	}

	public void addTopic(Topic topic) {
	//	topics.add(topic);
		topicrepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
	/*	for (int i=0;i<topics.size();i++) {
			Topic t=topics.get(i);
			if(t.getId().equals(id))
			{
				topics.set(i, topic);
				return;
			}
		
		
		}*/
	topicrepository.save(topic);
	}

	public void deleteTopic(String id) {
		//topics.removeIf(t->t.getId().equals(id));
		topicrepository.deleteById(id);
		
	}

}
