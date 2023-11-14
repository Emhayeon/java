package guessnum2;

public class RowNumDto {
	private Integer startRow = 1;
	private Integer endRow = 10;
	private Integer rn;
	private boolean isprev;
	private boolean isnext;
	
	public RowNumDto() {
		super();
		
	}

	public RowNumDto(Integer startRow, Integer endRow, Integer rn, boolean isprev, boolean isnext) {
		super();
		this.startRow = startRow;
		this.endRow = endRow;
		this.rn = rn;
		this.isprev = isprev;
		this.isnext = isnext;
	}

	@Override
	public String toString() {
		return "RowNumDto [startRow=" + startRow + ", endRow=" + endRow + ", rn=" + rn + ", isprev=" + isprev
				+ ", isnext=" + isnext + "]";
	}

	public Integer getStartRow() {
		return startRow;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	public Integer getEndRow() {
		return endRow;
	}

	public void setEndRow(Integer endRow) {
		this.endRow = endRow;
	}

	public Integer getRn() {
		return rn;
	}

	public void setRn(Integer rn) {
		this.rn = rn;
	}

	public boolean isIsprev() {
		return isprev;
	}

	public void setIsprev(boolean isprev) {
		this.isprev = isprev;
	}

	public boolean isIsnext() {
		return isnext;
	}

	public void setIsnext(boolean isnext) {
		this.isnext = isnext;
	}
	
	public void setStartEndRow(int page) {
		//현재 page  start endRow
		//		1	1		10
		//		2	11		20
		
		this.endRow = page * 10;
		this.startRow = this.endRow - 9;
	}
	
	
	
	

	
	
	
	
	
}
