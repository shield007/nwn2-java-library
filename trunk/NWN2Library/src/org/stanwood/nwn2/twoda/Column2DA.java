package org.stanwood.nwn2.twoda;

/**
 * Used to represent a column within a Neverwinter Nights 2 Database(2DA) file
 */
public class Column2DA {

	private String name;
	private TwoDAColumnType type = TwoDAColumnType.INTEGER;
	private boolean nullable = false;
	
	/**
	 * Used to construct a column instance
	 * @param name The name of the column
	 */
	public Column2DA(String name) {
		super();
		this.name = name;	
	}
	
	/**
	 * If returns true, then the column can contain null values
	 * @return True if the column can contain nulls, otherwise false
	 */
	public boolean isNullable() {
		return nullable;
	}
	
	/**
	 * Used to set if the column can contain nulls
	 * @param nullable True if the column can contain nulls, otherwise false
	 */
	public void setNullable(boolean nullable) {
		this.nullable = nullable;
	}
	
	/**
	 * Used to get the column name
	 * @return The name of the column
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Used to set the name of the column
	 * @param name The name of the column
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the data type of the column
	 * @return The data type of the column
	 */
	public TwoDAColumnType getType() {
		return type;
	}
	
	/**
	 * Used to set the data type of the column
	 * @param type The data type of the column
	 */
	public void setType(TwoDAColumnType type) {
		this.type = type;
	}
	
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Column2DA other = (Column2DA) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}
