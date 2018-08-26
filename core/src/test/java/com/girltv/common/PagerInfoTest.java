/*
 * @(#)PagerInfoTest.java $version 2014. 7. 29.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.girltv.common;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author JOHN KIM
 */
@RunWith(MockitoJUnitRunner.class)
public class PagerInfoTest {
	@InjectMocks
	private PagerInfo pagerInfo;

	@Test
	public void testPages() {
		/* Given */
		int page = 8;
		int totalRows = 187;
		int indexSize = 5;
		int pageSize = 10;

		/* When */
		pagerInfo.init(page, totalRows, indexSize, pageSize);

		/* Then */
		assertThat(pagerInfo.getPage(), is(page));
		assertThat(pagerInfo.getTotalRows(), is(totalRows));
		assertThat(pagerInfo.getIndexSize(), is(indexSize));
		assertThat(pagerInfo.getPageSize(), is(pageSize));
		assertThat(pagerInfo.getTotalPages(), is(19));
		assertThat(pagerInfo.getFirstPage(), is(6));
		assertThat(pagerInfo.getLastPage(), is(10));
		assertThat(pagerInfo.hasPrevButton(), is(true));
		assertThat(pagerInfo.hasNextButton(), is(true));
	}

	@Test
	public void testFirstPage_onlyOnePage() {
		/* Given */
		int page = 1;
		int totalRows = 10;
		int indexSize = 5;
		int pageSize = 10;

		/* When */
		pagerInfo.init(page, totalRows, indexSize, pageSize);

		/* Then */
		assertThat(pagerInfo.getPage(), is(page));
		assertThat(pagerInfo.getTotalRows(), is(totalRows));
		assertThat(pagerInfo.getIndexSize(), is(indexSize));
		assertThat(pagerInfo.getPageSize(), is(pageSize));
		assertThat(pagerInfo.getTotalPages(), is(1));
		assertThat(pagerInfo.getFirstPage(), is(1));
		assertThat(pagerInfo.getLastPage(), is(1));
		assertThat(pagerInfo.hasPrevButton(), is(false));
		assertThat(pagerInfo.hasNextButton(), is(false));
	}

	@Test
	public void testFirstPage_moreThanOnePage() {
		/* Given */
		int page = 1;
		int totalRows = 11;
		int indexSize = 5;
		int pageSize = 10;

		/* When */
		pagerInfo.init(page, totalRows, indexSize, pageSize);

		/* Then */
		assertThat(pagerInfo.getPage(), is(page));
		assertThat(pagerInfo.getTotalRows(), is(totalRows));
		assertThat(pagerInfo.getIndexSize(), is(indexSize));
		assertThat(pagerInfo.getPageSize(), is(pageSize));
		assertThat(pagerInfo.getTotalPages(), is(2));
		assertThat(pagerInfo.getFirstPage(), is(1));
		assertThat(pagerInfo.getLastPage(), is(2));
		assertThat(pagerInfo.hasPrevButton(), is(false));
		assertThat(pagerInfo.hasNextButton(), is(true));
	}

	@Test
	public void testLastPage() {
		/* Given */
		int page = 10;
		int totalRows = 100;
		int indexSize = 5;
		int pageSize = 10;

		/* When */
		pagerInfo.init(page, totalRows, indexSize, pageSize);

		/* Then */
		assertThat(pagerInfo.getPage(), is(page));
		assertThat(pagerInfo.getTotalRows(), is(totalRows));
		assertThat(pagerInfo.getIndexSize(), is(indexSize));
		assertThat(pagerInfo.getPageSize(), is(pageSize));
		assertThat(pagerInfo.getTotalPages(), is(10));
		assertThat(pagerInfo.getFirstPage(), is(6));
		assertThat(pagerInfo.getLastPage(), is(10));
		assertThat(pagerInfo.hasPrevButton(), is(true));
		assertThat(pagerInfo.hasNextButton(), is(false));
	}
}
