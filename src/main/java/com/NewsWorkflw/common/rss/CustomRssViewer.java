package com.NewsWorkflw.common.rss;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.feed.AbstractRssFeedView;

import com.NewsWorkflw.common.model.SampleContent;
import com.sun.syndication.feed.rss.Channel;
import com.sun.syndication.feed.rss.Content;
import com.sun.syndication.feed.rss.Item;

public class CustomRssViewer extends AbstractRssFeedView {

	@Override
	protected void buildFeedMetadata(Map<String, Object> model, Channel feed,
			HttpServletRequest request) {
		
		feed.setTitle("NewsWorkflw");
		feed.setDescription("This is a test feed");
		feed.setLink("http://www.test.com");
		
		super.buildFeedMetadata(model, feed, request);
	}
	
	
	@Override
	protected List<Item> buildFeedItems(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		@SuppressWarnings("unchecked")
		List<SampleContent> listContent = (List<SampleContent>) model.get("feedContent");
		List<Item> items = new ArrayList<Item>(listContent.size());
		
		// The use of an array for this set of data is very helpful in visualizing what you're trying to do.  I wasn't able to run it successfully but I can sort of get it
		
		for(SampleContent tempContent : listContent ){
		
			Item item = new Item();
			
			Content content = new Content();
			content.setValue(tempContent.getSummary());
			item.setContent(content);
			
			item.setTitle(tempContent.getTitle());
			item.setLink(tempContent.getUrl());
			item.setPubDate(tempContent.getCreatedDate());
			
			items.add(item);
		}
		
		return items;
	}

	
}