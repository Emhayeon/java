package ver16;

public class SearchDto {
	private String searchOption;
	private String keyword;
	
	public SearchDto() {
		super();
	}
	public SearchDto(String searchOption, String keyword) {
		super();
		this.searchOption = searchOption;
		this.keyword = keyword;
	}
	public String getSearchOption() {
		return searchOption;
	}
	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return "SearchDto [searchOption=" + searchOption + ", keyword=" + keyword + "]";
	}
	
	
}