/*
 * @(#)VideoBO.java $version 2014. 7. 23.
 *
 * Copyright 2007 JOHN KIM. All rights Reserved. 
 * Use is subject to license terms.
 */

package com.girltv.core.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.girltv.core.dao.VideoDAO;
import com.girltv.core.model.Video;


/**
 * @author JOHN KIM
 */
@Service
public class VideoBO {
	@Autowired
	private VideoDAO videoDAO;
	
	/**
	 * videoId로 동영상정보 조회
	 * @param videoId
	 * @return
	 */
	public Video getVideoByVideoId(int videoId){
		return videoDAO.selectVideoByVideoId(videoId);
	}
	
	/**
	 * Video 전체 개수 조회
	 * @return
	 */
	public int getVideoCount(){
		return videoDAO.selectVideoCount();
	}

	/**
	 * Video 목록 조회
	 * @param offset 페이지 시작점 
	 * @param pageSize 페이지당 게시물 수
	 * @return
	 */
	public List<Video> getVideoList(int offset, int pageSize){
		return videoDAO.selectVideoList(offset, pageSize);
	}
}
