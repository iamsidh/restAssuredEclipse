package restAssuredTest;

import org.testng.annotations.DataProvider;

public class DataForTests {

	@DataProvider(name = "dataforpost")
	public Object[][] DataForPost() {

		Object[][] data = new Object[2][3];

		data[0][0] = "Thor";
		data[0][1] = "Odinson";
		data[0][2] = 1;

		data[1][0] = "Steve";
		data[1][1] = "Rogers";
		data[1][2] = 3;

		return data;
	}

	@DataProvider(name = "dataforpost2")
	public Object[][] dataForPost2() {

		return new Object[][] {

				{ "Natasha", "Maxximof", 2 }, { "Peter", "Parker", 1 } };
	}

	@DataProvider(name = "datafordelete")
	public Object[] datafordelete() {

		return new Object[] { 8,9,10,11 };

	}

}
