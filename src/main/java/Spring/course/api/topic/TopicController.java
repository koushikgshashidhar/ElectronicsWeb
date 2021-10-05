package Spring.course.api.topic;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@Autowired
	private Topicservice topicservice;
	
	@RequestMapping("/electronics")
	public List<Topic> getAllTopics()
	{
		return  topicservice.getAllTopics();
	}
	
	@RequestMapping("/electronics/{id}")
	public Topic getTopic(@PathVariable String id)
	{
		return topicservice.getTopic(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/electronics")
	public void addTopic(@RequestBody Topic topic) {
		topicservice.addTopic(topic);
		
	}
	@RequestMapping(method = RequestMethod.PUT, value="/electronics/{id}")
	public void updateTopic(@RequestBody Topic topic,@PathVariable String id) {
		topicservice.updateTopic(id,topic);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/electronics/{id}")
	public void deleteTopic(@PathVariable String id)
	{
		topicservice.deleteTopic(id);
	}
	
}
