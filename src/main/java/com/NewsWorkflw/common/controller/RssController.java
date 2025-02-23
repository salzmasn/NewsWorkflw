package com.NewsWorkflw.common.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//		is this a spring boot project? I cannot seem to run it and the springframework is one of the issues.

import com.NewsWorkflw.common.model.SampleContent;

@Controller
public class RssController {

	@RequestMapping(value="/rssfeed", method = RequestMethod.GET)
	public ModelAndView getFeedInRss() {

		List<SampleContent> items = new ArrayList<SampleContent>();
		
		SampleContent content  = new SampleContent();
		content.setTitle("Spring MVC Tutorial 1");
		content.setUrl("http://www.mkyong.com/spring-mvc/tutorial-1");
		content.setSummary("Tutorial 1 summary ...");
		content.setCreatedDate(new Date());
		items.add(content);
		
		SampleContent content2  = new SampleContent();
		content2.setTitle("Spring MVC Tutorial 2");
		content2.setUrl("http://www.mkyong.com/spring-mvc/tutorial-2");
		content2.setSummary("Tutorial 2 summary ...");
		content2.setCreatedDate(new Date());
		items.add(content2);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("rssViewer");
		mav.addObject("feedContent", items);
		
		ModelAndView modelview = new ModelAndView();
		modelview.setViewName("rssViewer");
		modelview.addObject("feedContent"), items);
		
		//renamed mav to modelview, makes it more explainable
		
		
		
		return mav;

	}
	
}