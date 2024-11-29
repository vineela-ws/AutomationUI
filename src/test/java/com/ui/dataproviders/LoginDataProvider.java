package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.User;

public class LoginDataProvider {

	@DataProvider(name = "LoginTestDataProvider")
	public Iterator<Object[]> loginDataProvider() throws FileNotFoundException {
		Gson gson = new Gson();
		File testDataFile = new File(System.getProperty("user.dir") + "\\testData\\loginData.json");
		
			FileReader fileReader = new FileReader(testDataFile);
			TestData data = gson.fromJson(fileReader, TestData.class);
			List<Object[]> dataToReturn = new ArrayList<Object[]>();
			for (User user : data.getData()) {
				dataToReturn.add(new Object[] { user });
			}
			return dataToReturn.iterator();
     }
}
