package TESTAEV5.model;

import org.springframework.data.domain.Sort;

public class ProductoPage{
	private int limit  ; 
	private int offset ;
	
	private Sort.Direction sortDirection = Sort.Direction.ASC;
	
	private String sortBy = "id";

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public Sort.Direction getSortDirection() {
		return sortDirection;
	}

	public void setSortDirection(Sort.Direction sortDirection) {
		this.sortDirection = sortDirection;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	
	
	
}