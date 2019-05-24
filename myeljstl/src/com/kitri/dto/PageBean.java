package com.kitri.dto;

import java.util.List;

/*페이지별 JAVA BEAN
 * @author KITRI
*/

public class PageBean {

	
	private int cntPerPage = 10; // 페이지 보여줄 목록수
	private int startRow = 1; // 시작행
	private int endRow = 1; // 끝행
	private List<RepBoardDto> list; // 목록
	private int totalPage = 1; // 총페이지 수
	private int currentPage; // 현재페이지번호
	private int totalCnt; // 총게시글 수
	private int cntPerPageGroup = 3; // 페이지그룹에 보여줄 페이지 수
	private int startPage; // 페이지그룹의 시작페이지
	private int endPage; // 페이지그룹의 끝페이지
	private String url; // 페이지링크클릭시 요청할 url
	
	public PageBean() {
		
	}
	
	public PageBean(int currentPage, int cntPerPage, int cntPerPageGroup,   int totalCnt, String url) {
		super();
		this.cntPerPage = cntPerPage;
		this.currentPage = currentPage;
		this.totalCnt = totalCnt;
		this.cntPerPageGroup = cntPerPageGroup;
		this.url = url;
		execute();
	}
	
	public void execute() {
		startRow = (currentPage-1) * cntPerPage + 1;
		endRow = currentPage *cntPerPage;
		totalPage = (int)Math.ceil((float)totalCnt/cntPerPage);
		startPage = ((currentPage-1)/cntPerPageGroup)*cntPerPageGroup+1;
		endPage = startPage + cntPerPageGroup-1;
		if(endPage>totalPage) {
			endPage = totalPage;
		}

		
	}

	
	
	public int getCntPerPage() {
		return cntPerPage;
	}

	public void setCntPerPage(int cntPerPage) {
		this.cntPerPage = cntPerPage;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public List<RepBoardDto> getList() {
		return list;
	}

	public void setList(List<RepBoardDto> list) {
		this.list = list;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public int getCntPerPageGroup() {
		return cntPerPageGroup;
	}

	public void setCntPerPageGroup(int cntPerPageGroup) {
		this.cntPerPageGroup = cntPerPageGroup;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
