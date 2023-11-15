package guessnum2;

public class RowNumDto {
	private Integer startRow = 1;
	private Integer endRow = 10;

	public RowNumDto() {
		super();
	}

	public RowNumDto(Integer startRow, Integer endRow) {
		super();
		this.startRow = startRow;
		this.endRow = endRow;
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
	
	public void setStartEndRow(int page) {
		// page		start		endRow
		// 1		1			10
		// 2		11			20
		this.endRow = page * 10;
		this.startRow = this.endRow - 9;
	}

	@Override
	public String toString() {
		return "RowNumDto [startRow=" + startRow + ", endRow=" + endRow + "]";
	}

}