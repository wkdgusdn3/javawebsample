/*
 * @(#)VideoListController.java $version 2014. 7. 28.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.girltv.pc.video;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.girltv.common.PagerInfo;
import com.girltv.core.bo.VideoBO;
import com.girltv.core.model.Video;

/**
 * @author JOHN KIM
 */
@Controller
public class VideoListController {
	private final int PAGE_SIZE = 3;
	private final int INDEX_SIZE = 20;
	private final String DEFAULT_PAGE = "1";

	@Autowired
	private VideoBO videoBO;

	@RequestMapping("/videoList.tv")
	public ModelAndView controlList(@RequestParam(required = false, defaultValue = DEFAULT_PAGE) int pageNo) {
		ModelAndView mav = new ModelAndView();

		int totalCount = videoBO.getVideoCount();

		PagerInfo pagerInfo = new PagerInfo();
		pagerInfo.init(pageNo, totalCount, INDEX_SIZE, PAGE_SIZE);

		List<Video> videoList = videoBO.getVideoList(pagerInfo.getOffsetRow(), pagerInfo.getPageSize());
		mav.addObject("videoList", videoList);
		mav.addObject("pagerInfo", pagerInfo);

		return mav;
	}

	@RequestMapping("/videoListE.tv")
	public ModelAndView experimentList(@RequestParam(required = false, defaultValue = DEFAULT_PAGE) int pageNo) {
		ModelAndView mav = new ModelAndView();

		int totalCount = videoBO.getVideoCount();

		PagerInfo pagerInfo = new PagerInfo();
		pagerInfo.init(pageNo, totalCount, INDEX_SIZE, PAGE_SIZE);

		List<Video> videoList = videoBO.getVideoList(pagerInfo.getOffsetRow(), pagerInfo.getPageSize());
		mav.addObject("videoList", videoList);
		mav.addObject("pagerInfo", pagerInfo);

		return mav;
	}
}