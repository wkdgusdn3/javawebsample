/*
 * @(#)VideoBOTest.java $version 2014. 7. 23.
 *
 * Copyright 2007 JOHN KIM. All rights Reserved. 
 * Use is subject to license terms.
 */

package com.girltv.core.bo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.girltv.core.bo.VideoBO;

/**
 * @author JOHN KIM
 */
@RunWith(MockitoJUnitRunner.class)
public class VideoBOTest {
	@Mock
	private VideoBO videoBO;

	@Test
	public void testGetVideoByVideoId(){
		videoBO.getVideoByVideoId(1);
	}
}
