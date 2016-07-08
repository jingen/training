package com.training;

public class EnumTest {
	public enum Day {
		MONDAY(0, "Monday"), TUESDAY(1, "Tuesday"), WENDESDAY(2, "Wendesday"), THURSDAY(
				3, "Thursday"), FRIDAY(4, "Friday"), SATURDAY(5, "Saturday"), SUNDAY(
				6, "Sunday");
//		private Integer number;
		private String description;

		Day(Integer number, String description) {
//			this.number = number;
			this.description = description;
		}

//		public Integer getNumber() {
//			return number;
//		}
//
//		public void setNumber(Integer number) {
//			this.number = number;
//		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public int getOrdinal() {
			return ordinal();
		}
		@Override
		public String toString(){
			return this.description;
		}
	}

	private Day day;

	public EnumTest(Day day) {
		this.day = day;
	}

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	public static void main(String[] args) {
		// EnumTest enumTest = new EnumTest(Day.FRIDAY);
		// System.out.println(enumTest.getDay());
		// System.out.println(Day.FRIDAY.getOrdinal());
		for(Day day: Day.values()){
			System.out.println(day);
		}
	}
}
