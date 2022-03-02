package com.ksnx3684.s1.util;

public class Pager {

	private Long perPage; // Page당 보여줄 row의 갯수
	private Long page; // Page 번호
	private Long startRow; // 시작 번호
	private Long lastRow; // 끝 번호
	
	// -------------------- 검색 사용 변수
	
	private String search;
	private String kind;
	
	// -------------------- JSP 사용 변수
	
	private Long startNum; // 블럭 내의 시작 페이지 번호
	private Long lastNum; // 블럭 내의 끝 페이지 번호
	
	private boolean next;
	private boolean pre;

	
	public void makeRow() {
		this.startRow = (this.getPage() - 1) * this.getPerPage() + 1;
		this.lastRow = this.getPage() * this.getPerPage();
	}
	
	public void makeNum(Long totalCount) {
		// 1. 전체 row의 갯수 구하기
		
		// 2. 전체 page의 갯수 구하기
		Long totalPage = totalCount / this.getPerPage();
		if(totalCount % this.getPerPage() != 0) {
			totalPage++;
		}
		
		// 3. 블럭 당 갯수
		Long perBlock = 10L;
		
		// 4. 전체 블록의 갯수 구하기
		Long totalBlock = totalPage / perBlock;
		if(totalPage % perBlock != 0)
			totalBlock++;
		
		// 5. page번호로 현재 몇 번째 블록인지 계산
		// 1번 블록 : 1 ~ 10 페이지
		// 2번 블록 : 11 ~ 20 페이지
		Long curBlock = this.getPage() / perBlock;
		if(this.getPage() % perBlock != 0)
			curBlock++;
		
		// 6. curBlock으로 startNum, lastNum 구하기
		// curBlock startNum lastNum
		// 1        1        10
		// 2        11       20
		this.startNum = (curBlock - 1) * perBlock + 1;
		this.lastNum = curBlock * perBlock;
		
		// 7. 이전, 다음 블럭 유무
		this.pre = false;
		if(curBlock > 1) {
			this.pre = true;
		}
		
		this.next = false;
		if(totalBlock > curBlock) {
			this.next = true;
		}
		
		// 8. 현재 블럭이 마지막 블럭번호와 같다면
		if(curBlock == totalBlock) {
			this.lastNum = totalPage;
		}
			
	}

	
	
	public Long getPerPage() {
		if(this.perPage == null || this.perPage < 1) {
			this.perPage = 10L;
		}

		return perPage;
	}
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	
	public Long getPage() {
		if(this.page == null || this.page < 1) {
			this.page = 1L;
		}
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	
	
	
	public String getSearch() {
		if(this.search == null) {
			this.search="";
		}
		
//		this.search="%"+this.search+"%";
				
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}	
	
	public Long getStartNum() {
		return startNum;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	public Long getLastNum() {
		return lastNum;
	}
	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}
	
	
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public boolean isPre() {
		return pre;
	}
	public void setPre(boolean pre) {
		this.pre = pre;
	}
	
}
