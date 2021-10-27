import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class Livescore18Test {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		// setting the driver executable
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\90sun\\Desktop\\chromedriver.exe");

		// Initiating your chromedriver
		WebDriver driver = new ChromeDriver();

		//driver.get("https://www.livescore18.com/basketball/tomorrow/");
		driver.get("https://www.livescore18.com/today/");

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		// wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//html/body/div[1]/div[5]/header/nav/div[2]/div[1]/i[1]"))));
		try {
			driver.findElement(By.xpath("//*[@id='header']/header/nav/div[2]/div[1]/i[1]")).click();
			driver.findElement(By.xpath("//*[@id='header']/header/nav/div[2]/div[1]/i[1]")).click();
			driver.findElement(By.xpath("//*[@id='header']/header/nav/div[2]/div[1]/i[1]")).click();
			driver.findElement(By.xpath("//*[@id='header']/header/nav/div[2]/div[1]/i[1]")).click();
		} catch (Exception e) {
		}

		// wait.until(ExpectedConditions.elementToBeSelected(driver.findElement(By.xpath("//*[@id='settingLayer']/div[1]/div[2]/ul[1]/li"))));
		driver.findElement(By.xpath("//*[@id='cbbZone']")).click();

		// wait.until(ExpectedConditions.elementToBeSelected(driver.findElement(By.xpath("//*[@id='cbbZone']/option[8]"))));
		driver.findElement(By.xpath("//*[@id='cbbZone']/option[8]")).click();

		driver.navigate().refresh();

		// wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//html/body/div[1]/div[5]/header/nav/div[2]/div[1]/i[1]"))));
		try {
			driver.findElement(By.xpath("//*[@id='header']/header/nav/div[2]/div[1]/i[1]")).click();
			driver.findElement(By.xpath("//*[@id='header']/header/nav/div[2]/div[1]/i[1]")).click();
			driver.findElement(By.xpath("//*[@id='header']/header/nav/div[2]/div[1]/i[1]")).click();
			driver.findElement(By.xpath("//*[@id='header']/header/nav/div[2]/div[1]/i[1]")).click();
		} catch (Exception e) {
		}

		// wait.until(ExpectedConditions.elementToBeSelected(driver.findElement(By.xpath("//*[@id='settingLayer']/div[1]/div[2]/ul[1]/li"))));
		driver.findElement(By.xpath("//*[@id='cbbZone']")).click();

		// wait.until(ExpectedConditions.elementToBeSelected(driver.findElement(By.xpath("//*[@id='cbbZone']/option[8]"))));
		driver.findElement(By.xpath("//*[@id='cbbZone']/option[9]")).click();

		driver.navigate().refresh();

		ArrayList<String> links = new ArrayList<String>();
		int i = 1;

		String postponedCanceledFT, bbpostponedCanceledFT;
		while (true) {
			try {

				
//				bbpostponedCanceledFT = driver.findElement(By.xpath("//html/body/div[1]/div[6]/div/div[1]/div[4]/ul/li["+i+"]/div[2]/div[2]/div[2]/i")).getText();
//				
//				//System.out.println(bbpostponedCanceledFT);
//				
//				if (bbpostponedCanceledFT.equals("Postp.") || bbpostponedCanceledFT.equals("Cancel") || bbpostponedCanceledFT.equals("FT")) {
//					i++;
//					continue;
//				} else
//					links.add(driver.findElement(By.xpath("//html/body/div[1]/div[6]/div/div[1]/div[4]/ul/li["+i+"]/div[2]/a")).getAttribute("href"));
//				System.out.println(driver.findElement(By.xpath("//html/body/div[1]/div[6]/div/div[1]/div[4]/ul/li["+i+"]/div[2]/a")).getAttribute("href"));
//				i++;
//				
				postponedCanceledFT = driver.findElement(By.xpath("//html/body/div[1]/div[6]/div/div[1]/div[4]/ul/li["+i+"]/div[2]/div[1]/i")).getText();

				//System.out.println(postponedCanceledFT);
				if (postponedCanceledFT.equals("Postp.") || postponedCanceledFT.equals("Cancel") || postponedCanceledFT.equals("FT")) {
					i++;
					continue;
				} else
					links.add(driver.findElement(By.xpath("//html/body/div[1]/div[6]/div/div[1]/div[4]/ul/li["+i+"]/div[2]/a")).getAttribute("href"));
				//System.out.println(driver.findElement(By.xpath("//html/body/div[1]/div[6]/div/div[1]/div[4]/ul/li["+i+"]/div[2]/a")).getAttribute("href"));
				i++;

			} catch (Exception e) {
				System.out.println("no more links");
				break;
			}
		}

		File file = new File("C:\\Users\\90sun\\Desktop\\todaysbets.txt");

		
		Writer myWriter = new FileWriter(file);
		

		// Using list iterator
		ListIterator<String> litr = null;
		litr = links.listIterator();

		while (litr.hasNext()) {

			String link = litr.next();
			driver.get(link);
			System.out.println(link);

			ArrayList<Integer> homeForm = new ArrayList<Integer>();
			ArrayList<Integer> awayForm = new ArrayList<Integer>();
			ArrayList<Integer> homeGoals = new ArrayList<Integer>();
			ArrayList<Integer> homeOppGoals = new ArrayList<Integer>();
			ArrayList<Integer> awayGoals = new ArrayList<Integer>();
			ArrayList<Integer> awayOppGoals = new ArrayList<Integer>();
			String homeName, awayName,date;

			try {

				// driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

				driver.findElement(By.xpath("//*[@id='sm1']")).click();
				driver.findElement(By.xpath("//*[@id='sm2']")).click();
				
			} catch (Exception e) {
				//System.out.println("Show more matches not clickable");
			}

			try {
				driver.findElement(By.xpath("//label[@for='cbSos1']")).click();
				driver.findElement(By.xpath("//label[@for='cbSos2']")).click();
				driver.findElement(By.xpath("//label[@for='cbSos1']")).click();
				driver.findElement(By.xpath("//label[@for='cbSos2']")).click();
				driver.findElement(By.xpath("//label[@for='cbSos1']")).click();
				driver.findElement(By.xpath("//label[@for='cbSos2']")).click();
				driver.findElement(By.xpath("//label[@for='cbSos1']")).click();
				driver.findElement(By.xpath("//label[@for='cbSos2']")).click();
				driver.findElement(By.xpath("//label[@for='cbSos1']")).click();
				driver.findElement(By.xpath("//label[@for='cbSos2']")).click();
				
			} catch (Exception e) {
				//System.out.println("No boxes to click");
				continue;
			}

			int gLS1 = 0;
			int gLS2 = 0;
			List<WebElement> gameLists = driver.findElements(By.xpath("(//*[@class='gameList'])"));
			if (gameLists.size() == 2) {
				gLS1 = 1;
				gLS2 = 2;
			} else if (gameLists.size() == 3) {
				gLS1 = 2;
				gLS2 = 3;
			}

			try {
				//get time of game
				date = driver.findElement(By.xpath("//*[@id='liveMt']")).getText(); 
				// get home name
				homeName = driver.findElement(By.xpath("(//*[@class='gameList'])["+gLS1+"]//li[@style='display: list-item;']/div[2]/div[1]/div")).getText();
				// get away name
				awayName = driver.findElement(By.xpath("(//*[@class='gameList'])["+gLS2+"]//li[@style='display: list-item;']/div[2]/div[3]/div")).getText();

				// get home avg
				i = 1;
				while (true) {
					try {
						homeGoals.add(Integer.valueOf(driver.findElement(By.xpath("((//*[@class='gameList'])["+gLS1+"]//li[@style='display: list-item;']/div[2]/div[2]/span[1])["+i+"]")).getText()));
						homeOppGoals.add(Integer.valueOf(driver.findElement(By.xpath("((//*[@class='gameList'])["+gLS1+"]//li[@style='display: list-item;']/div[2]/div[2]/span[2])["+i+"]")).getText()));

//						 System.out.println("homegoal = " +
//						 driver.findElement(By.xpath("((//*[@class='gameList'])["+gLS1+"]//li[@style='display: "+
//						 "list-item;']/div[2]/div[2]/span[1])["+i+"]")).getText());
//						 System.out.println("homeoppgoal = " +
//						 driver.findElement(By.xpath("((//*[@class='gameList'])["+gLS1+"]//li[@style='display: "+
//						 "list-item;']/div[2]/div[2]/span[2])["+i+"]")).getText());

						if (homeGoals.get(i-1) > homeOppGoals.get(i-1))
							homeForm.add(3);
						else if (homeGoals.get(i-1) == homeOppGoals.get(i-1))
							homeForm.add(1);
						else if (homeGoals.get(i-1) < homeOppGoals.get(i-1))
							homeForm.add(0);
 
						// System.out.println("home form = " + homeForm.get(i-1));

						i++;

					} catch (Exception e) {
						//System.out.println("no more home goals");
						break;
					}
				}

				i = 1;
				while (true) {
					try {
						awayGoals.add(Integer.valueOf(driver.findElement(By.xpath("((//*[@class='gameList'])["+gLS2+"]//li[@style='display: list-item;']/div[2]/div[2]/span[2])["+i+"]")).getText()));
						awayOppGoals.add(Integer.valueOf(driver.findElement(By.xpath("((//*[@class='gameList'])["+gLS2+"]//li[@style='display: list-item;']/div[2]/div[2]/span[1])["+i+"]")).getText()));

//						 System.out.println("awaygoal = " +
//						 driver.findElement(By.xpath("((//*[@class='gameList'])["+gLS2+"]//li[@style='display:"+
//						 "list-item;']/div[2]/div[2]/span[2])["+i+"]")).getText());
//						 System.out.println("awayoppgoal = " +
//						 driver.findElement(By.xpath("((//*[@class='gameList'])["+gLS2+"]//li[@style='display:"+
//						 "list-item;']/div[2]/div[2]/span[1])["+i+"]")).getText());

						if (awayGoals.get(i-1) > awayOppGoals.get(i-1))
							awayForm.add(3);
						else if (awayGoals.get(i-1) == awayOppGoals.get(i-1))
							awayForm.add(1);
						else if (awayGoals.get(i-1) < awayOppGoals.get(i-1))
							awayForm.add(0);

//						 System.out.println("away form = " + awayForm.get(i-1));

						i++;
					} catch (Exception e) {
						//System.out.println("no more away goals");
						break;
					}
				}

				float sum = 0;
				ArrayList<Float> homeGoalAvgArr = new ArrayList<Float>();
				for (i = 0; i < homeGoals.size(); i++) {

					sum += homeGoals.get(i);
					homeGoalAvgArr.add(sum / (i+1));

				}
				sum = 0;
				float homeGoalAvg = 0;
				for (i = 0; i < homeGoalAvgArr.size(); i++) {

					sum += homeGoalAvgArr.get(i);
				}
				homeGoalAvg = sum / homeGoalAvgArr.size();

				sum = 0;
				ArrayList<Float> awayGoalAvgArr = new ArrayList<Float>();
				for (i = 0; i < awayGoals.size(); i++) {

					sum += awayGoals.get(i);
					awayGoalAvgArr.add(sum / (i+1));

				}
				sum = 0;
				float awayGoalAvg = 0;
				for (i = 0; i < awayGoalAvgArr.size(); i++) {

					sum += awayGoalAvgArr.get(i);

				}
				awayGoalAvg = sum / awayGoalAvgArr.size();

				sum = 0;
				ArrayList<Float> homeOppGoalAvgArr = new ArrayList<Float>();
				for (i = 0; i < homeOppGoals.size(); i++) {

					sum += homeOppGoals.get(i);
					homeOppGoalAvgArr.add(sum / (i+1));

				}
				sum = 0;
				float homeOppGoalAvg = 0;
				for (i = 0; i < homeOppGoalAvgArr.size(); i++) {

					sum += homeOppGoalAvgArr.get(i);

				}
				homeOppGoalAvg = sum / homeOppGoalAvgArr.size();

				sum = 0;
				ArrayList<Float> awayOppGoalAvgArr = new ArrayList<Float>();
				for (i = 0; i < awayOppGoals.size(); i++) {

					sum += awayOppGoals.get(i);
					awayOppGoalAvgArr.add(sum / (i+1));

				}
				sum = 0;
				float awayOppGoalAvg = 0;
				for (i = 0; i < awayOppGoalAvgArr.size(); i++) {

					sum += awayOppGoalAvgArr.get(i);

				}
				awayOppGoalAvg = sum / awayOppGoalAvgArr.size();

				float homeExpGoals = (homeGoalAvg + awayOppGoalAvg) / 2;
				float awayExpGoals = (awayGoalAvg + homeOppGoalAvg) / 2;

				sum = 0;
				ArrayList<Float> homeFormAvgArr = new ArrayList<Float>();
				for (i = 0; i < homeForm.size(); i++) {

					sum += homeForm.get(i);
					homeFormAvgArr.add(sum / (i+1));

				}
				sum = 0;
				float homeFormAvg = 0;
				for (i = 0; i < homeFormAvgArr.size(); i++) {

					sum += homeFormAvgArr.get(i);

				}
				homeFormAvg = sum / homeFormAvgArr.size();

				sum = 0;
				ArrayList<Float> awayFormAvgArr = new ArrayList<Float>();
				for (i = 0; i < awayForm.size(); i++) {

					sum += awayForm.get(i);
					awayFormAvgArr.add(sum / (i+1));

				}
				sum = 0;
				float awayFormAvg = 0;
				for (i = 0; i < awayFormAvgArr.size(); i++) {

					sum += awayFormAvgArr.get(i);

				}
				awayFormAvg = sum / awayFormAvgArr.size();


				if (homeExpGoals < 1.2)
					homeExpGoals = 0;
				if (awayExpGoals < 1.2)
					awayExpGoals = 0;
				
				float formDiff = Math.abs(homeFormAvg - awayFormAvg);
				double bet = Math.floor(homeExpGoals) + Math.floor(awayExpGoals) - 0.5;
				
				if (homeGoals.size() >=5 && awayGoals.size() >=5 &&
						!homeName.contains("U19") &&
						!awayName.contains("U19") &&
						!homeName.contains("U20") &&
						!awayName.contains("U20") &&
						!homeName.contains("U21") &&
						!awayName.contains("U21") &&
						!homeName.contains("U22") &&
						!awayName.contains("U22") &&
						!homeName.contains("U23") &&
						!awayName.contains("U23") &&
						!homeName.contains("Youth") &&
						!awayName.contains("Youth") &&
						formDiff >= 0.85 &&
						(homeFormAvg >= 1.4 || awayFormAvg >= 1.4) &&
						(homeExpGoals >= 1.4 || awayExpGoals >= 1.4) &&
						bet > 1) {
					
					myWriter.write(date.substring(11));
					myWriter.write(",");
					myWriter.write(homeName);
					myWriter.write(",");
					myWriter.write(awayName);
					myWriter.write(",");
					myWriter.write(Float.toString(homeFormAvg));
					myWriter.write(",");
					myWriter.write(Float.toString(awayFormAvg));
					myWriter.write(",");
					myWriter.write(Float.toString(formDiff));
					myWriter.write(",");
					myWriter.write(Float.toString(homeExpGoals));
					myWriter.write(",");
					myWriter.write(Float.toString(awayExpGoals));
					myWriter.write(",");
					myWriter.write(Double.toString(bet));
					myWriter.write(System.lineSeparator()); // new line
				
					System.out.println("date = " + date.substring(11));
					System.out.format("|%-30s|", homeName);
					System.out.format("|%-30s|", "Form = " + homeFormAvg);
					System.out.format("|%-30s|", "Exp Goals = " + homeExpGoals);
					System.out.println();
					System.out.format("|%-30s|", awayName);
					System.out.format("|%-30s|", "Form = " + awayFormAvg);
					System.out.format("|%-30s|", "Exp Goals = " + awayExpGoals);
					System.out.println();
					System.out.format("|%-30s|", "");
					System.out.format("|%-30s|", "Form Diff = " + formDiff);
					System.out.format("|%-30s|", "Over = " + bet);
			


					System.out.println();
				
				}
				


			} catch (Exception e) {
				continue;
			}

		}
		// closing the browser
		myWriter.close();

		driver.close();

	}
}
